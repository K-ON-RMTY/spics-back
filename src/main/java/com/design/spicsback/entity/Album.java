package com.design.spicsback.entity;

import java.io.Serializable;

/**
 * (TAlbum)实体类
 *
 * @author jj
 * @since 2021-02-15 09:07:37
 */
public class Album implements Serializable {
    private static final long serialVersionUID = 452190285849906655L;
    
    private Integer id;
    
    private String albumName;
    
    private String albumDescription;
    
    private Integer userId;
    
    private Integer collectNum;
    
    private Integer likeNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }



    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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