package com.design.spicsback.utils;

import com.design.spicsback.configuration.UploadProperties;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
/*
    参考：
    https://www.cnblogs.com/Johnson-lin/p/12059067.html
    其访问的链接主要是将空间绑定的域名（可以是七牛空间的默认域名或者是绑定的自定义域名）拼接上空间里面的文件名即可访问

* */
public class FileQiniuManager {
//    private UploadProperties properties;
    // 构建一个带指定Region对象的配置类
    private Configuration config = new Configuration(Region.region2());
    // 默认请求协议为 https，可设置为http请求
    // config.useHttpsDomains = false
    private UploadManager uploadManager = new UploadManager(config);

//    public UploadFileQiniu(UploadProperties properties) {
//        this.properties = properties;
//    }
    private String domain = "qom3or861.hn-bkt.clouddn.com";
    private String accessKey = "NNZ5NPzNtf-SEvs6V_XRGtPRG-V7L0pquHkmzkSq";
    private String secretKey = "3irrO0x33-kPdZTqLy7L_O-T2KPBvXlM1N9ofZkG";
    private String bucket = "savepics";

    /**
     * 直接上传图片
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file) {
        Auth auth = Auth.create(accessKey,secretKey);
        String token = auth.uploadToken(bucket);
        try {
            String originalFilename = file.getOriginalFilename();
            // 文件后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 设置文件名称，保证唯一
            String fileKey = UUID.randomUUID().toString()+suffix;
            // 上传结果
            Response response = uploadManager.put(file.getInputStream(), fileKey, token, null, null);
            // 解析上传结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            // 返回图片url
            return domain+fileKey;
        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 通过文件路径上传图片
     * @param filePath
     * @param fileName
     * @return
     */
    public String uploadFile(String filePath ,String fileName) {
        System.out.println(filePath);
        Auth auth = Auth.create(accessKey,secretKey);
        String token = auth.uploadToken(bucket);
        try {
            // 文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            // 设置文件名称，保证唯一
            String fileKey = UUID.randomUUID().toString()+suffix;
            // 上传结果
            Response response = uploadManager.put(filePath, fileKey, token);
            // 解析上传结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            // 返回图片url
            return "http://"+domain+"/"+fileKey;
        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r.toString());
        }
        return "error";
    }

    public void deleteFile (String path) throws QiniuException {
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, config);
        try {
            // 获取key
            String key = path.substring(domain.length()+"http://".length()+1);
            System.out.println(key);
            bucketManager.delete(bucket,key);
        } catch (QiniuException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
