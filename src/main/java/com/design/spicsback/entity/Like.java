package com.design.spicsback.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TLike)实体类
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
public class Like implements Serializable {
    private static final long serialVersionUID = 333078486167885818L;
    
    private Integer id;
    
    private Integer picsId;
    
    private Integer userId;
    
    private Date time;


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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}