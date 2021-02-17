package com.design.spicsback.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="upload")
@Data
public class UploadProperties {
    // 域名
    private String domain;
    private String accessKey;
    private String secretKey;
    // 存储空间名
    private String bucket;
}
