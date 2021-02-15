package com.design.spicsback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TCollect)实体类
 *
 * @author jj
 * @since 2021-02-15 09:07:47
 */
public class Collect implements Serializable {
    private static final long serialVersionUID = -82708867339198237L;
    
    private Integer id;
    
    private Integer picsId;
    
    private Integer userId;
    //收藏时间
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPicsId() {
        return picsId;
    }

    public void setPicsId(Integer picsId) {
        this.picsId = picsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}