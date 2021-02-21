package com.design.spicsback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TTagForPic)实体类
 *
 * @author jj
 * @since 2021-02-22 00:03:10
 */
public class TagForPic implements Serializable {
    private static final long serialVersionUID = -13114039807300779L;
    
    private Integer id;
    
    private Integer userId;
    
    private String tagName;
    
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}