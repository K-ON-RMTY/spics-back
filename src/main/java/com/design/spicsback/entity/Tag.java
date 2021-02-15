package com.design.spicsback.entity;

import java.io.Serializable;

/**
 * (TTag)实体类
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = 937307813472850356L;
    
    private Integer id;
    
    private String tagName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}