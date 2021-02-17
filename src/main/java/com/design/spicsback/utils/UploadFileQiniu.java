package com.design.spicsback.utils;

import com.design.spicsback.configuration.UploadProperties;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
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
public class UploadFileQiniu {
    private UploadProperties properties;
    // 构建一个带指定Region对象的配置类
    private Configuration config = new Configuration(Region.region2());
    // 默认请求协议为 https，可设置为http请求
    // config.useHttpsDomains = false
    private UploadManager uploadManager = new UploadManager(config);
    public UploadFileQiniu(UploadProperties properties) {
        this.properties = properties;
    }

    public String uploadFile(MultipartFile file) {
        Auth auth = Auth.create(properties.getAccessKey(),properties.getSecretKey());
        String token = auth.uploadToken(properties.getBucket());
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
            return properties.getDomain()+fileKey;
        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}