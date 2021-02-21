package com.design.spicsback.controller;

import com.design.spicsback.configuration.UploadProperties;
import com.design.spicsback.entity.Information;
import com.design.spicsback.entity.PicTags;
import com.design.spicsback.entity.Pics;
import com.design.spicsback.service.PicTagsService;
import com.design.spicsback.service.PicsService;
import com.design.spicsback.utils.FileQiniuManager;
import com.qiniu.common.QiniuException;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * (TPics)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@RestController
@RequestMapping("pics")
public class PicsController {
    /**
     * 服务对象
     */
    @Resource
    private PicsService picsService;
    @Resource
    private PicTagsService picTagsService;
    private FileQiniuManager fileQiniuManager = new FileQiniuManager();



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Pics selectOne(Integer id) {
        return this.picsService.queryById(id);
    }

    /**
     *  上传图片
     * @param request 请求
     * @param picFile 图片
     * @return
     */
    @PostMapping("upload/img")
    public Information<String> uploadImg(HttpServletRequest request, MultipartFile picFile) {
        // 暂存图片到session
        HttpSession session = request.getSession();
        // 接收图片并进行缩放 120px * 120px 默认大于该尺寸
        try {
            String random = UUID.randomUUID().toString();
            String uploadPath = "/imgs/"+random+".jpg";
            //缩略图
            // http://localhost:8080/#/home
            //http://qom3or861.hn-bkt.clouddn.com/
            Thumbnails.of(picFile.getInputStream()).size(120, 120).outputFormat("jpg").toFile("src/main/resources/static/imgs/"+random);
            // 将地址返回给前端
            String path = System.getProperty("user.dir");
            System.out.println(path);
            if (session.getAttribute("fileMap") == null) {
                session.setAttribute("fileMap", new HashMap<String, MultipartFile>());
            }
            Map<String,MultipartFile> fileMap = (HashMap<String,MultipartFile>)session.getAttribute("fileMap");
            if (fileMap.size() == 6 ) {
                return Information.error(300,"图片已满，不可再添加");
            }
            String filePath = path+"\\src\\main\\resources\\static"+"\\imgs\\"+random+".jpg";
            String url=fileQiniuManager.uploadFile(filePath,random+".jpg");
            // 删除后端的缩略图
            File tempFile = new File(filePath);
            tempFile.delete();

            // 暂存七牛云连接(key)和图片文件(value)

            fileMap.put(url,picFile);
            session.setAttribute("fileMap", fileMap);
            if (fileMap.size() == 6 ) {
                return Information.success(201,"上传成功，但不可再添加",url);
            }
            System.out.println(fileMap.size());
            return Information.success(200,"上传成功",url);
        } catch (IOException e) {
            e.printStackTrace();
            return Information.error(500,"上传失败");
            // http://qom3or861.hn-bkt.clouddn.com73786f47-fa86-4fcb-b01e-a64eca768d82.jpg/
        }

    }

    /**
     * 取消上传所有
     * @param request
     * @return
     */
    @DeleteMapping("delete/imgs")
    public Information cancelUpload (HttpServletRequest request) {
        // 清空session缓存中的图片
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("fileMap") !=null) {
                Map<String,MultipartFile> fileMap = (Map<String,MultipartFile>)session.getAttribute("fileMap");
                for (String url : fileMap.keySet()) {
                    fileQiniuManager.deleteFile(url);
                }
                session.removeAttribute("fileMap");
            }
            return Information.success("删除成功");
        }catch (QiniuException e) {
            e.printStackTrace();
            return Information.error(500,"删除失败");
        }

    }

    /**
     * 取消上传其中一个
     * @param url
     * @return
     */
    @PostMapping("delete/img")
    public Information cancelUploadImg (HttpServletRequest request, String url) {
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("fileMap") != null ) {
                Map<String,MultipartFile> fileMap = (Map<String,MultipartFile>)session.getAttribute("fileMap");
                if (fileMap.get(url) != null) {
                    fileMap.remove(url);
                }
                fileQiniuManager.deleteFile(url);
            }
            return Information.success("删除");
        }catch (QiniuException e) {
            e.printStackTrace();
            return Information.error(500,"删除失败");
        }

    }

    /**
     * 上传所有原始图片
     * @param request
     * @param albumId
     * @param description
     * @param picTags
     * @return
     */
    @PostMapping("confirm/upload")
    public Information uploadImgsToAlbum (HttpServletRequest request, Integer userId, Integer albumId, String description, List<PicTags> picTags)  {
        HttpSession session = request.getSession();
        Map<String,MultipartFile> fileMap = (Map<String,MultipartFile>)session.getAttribute("fileMap");
        if (fileMap == null || fileMap.size() == 0) {
            return Information.success("没有图片上传");
        }
        // 上传到七牛云
        for (MultipartFile file : fileMap.values()) {
            String url = fileQiniuManager.uploadFile(file);
            // 将图片连接存储到数据库
            Pics pic = new Pics();
            pic.setAlbumId(albumId);
            pic.setUrl(url);
            pic.setUserId(userId);
            if (description != null){
                pic.setDescription(description);
            }
            Pics insert = picsService.insert(pic);
            // 添加图片标签
            if (picTags != null) {
                for (PicTags tags : picTags) {
                    tags.setPicId(insert.getId());
                    picTagsService.insert(tags);
                }
            }
        }
        // 删除七牛云上所有缩略图
        for (String url : fileMap.keySet()) {
            try {
                fileQiniuManager.deleteFile(url);
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }

        // 删除缓存
        session.removeAttribute("fileMap");
        return Information.success("成功上传");
    }

}