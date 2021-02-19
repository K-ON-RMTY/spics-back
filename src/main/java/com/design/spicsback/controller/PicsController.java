package com.design.spicsback.controller;

import com.design.spicsback.configuration.UploadProperties;
import com.design.spicsback.entity.Information;
import com.design.spicsback.entity.Pics;
import com.design.spicsback.service.PicsService;
import com.design.spicsback.utils.UploadFileQiniu;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @PostMapping("upload/img")
    public Information<String> insertList(MultipartFile picFile) {
        System.out.println(picFile);
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
            UploadFileQiniu  uploadFileQiniu = new UploadFileQiniu();
            String url=uploadFileQiniu.uploadFile(path+"\\src\\main\\resources\\static"+"\\imgs\\"+random+".jpg",random+".jpg");
            System.out.println(url);
            return Information.success(200,"上传成功",url);
        } catch (IOException e) {
            e.printStackTrace();
            return Information.error(500,"上传失败");
            // http://qom3or861.hn-bkt.clouddn.com73786f47-fa86-4fcb-b01e-a64eca768d82.jpg/
        }

    }


}