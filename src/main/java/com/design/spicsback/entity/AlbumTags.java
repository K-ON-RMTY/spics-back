package com.design.spicsback.entity;

import java.io.Serializable;

/**
 * (TAlbumTags)实体类
 *
 * @author jj
 * @since 2021-02-15 09:07:47
 */
public class AlbumTags implements Serializable {
    private static final long serialVersionUID = 285327117008799900L;
    
    private Integer id;
    
    private Integer albumId;
    
    private Integer tagId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

}