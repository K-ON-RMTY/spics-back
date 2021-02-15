package com.design.spicsback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TPics)实体类
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
public class Pics implements Serializable {
    private static final long serialVersionUID = -93685339442338954L;
    
    private Integer id;
    
    private String url;
    
    private String description;
    //所属图集
    private Integer albumId;
    
    private Integer userId;
    //上传时间
    private Date uploadTime;
    //收藏数
    private Integer collectNum;
    //点赞数
    private Integer likeNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

}