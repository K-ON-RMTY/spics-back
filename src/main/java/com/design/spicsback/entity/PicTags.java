package com.design.spicsback.entity;

import java.io.Serializable;

/**
 * (TPicTags)实体类
 *
 * @author jj
 * @since 2021-02-22 00:01:51
 */
public class PicTags implements Serializable {
    private static final long serialVersionUID = -74416168889144898L;
    
    private Integer id;
    
    private Integer picTagId;
    
    private Integer picId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPicTagId() {
        return picTagId;
    }

    public void setPicTagId(Integer picTagId) {
        this.picTagId = picTagId;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

}