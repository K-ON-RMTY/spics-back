package com.design.spicsback.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TPics)实体类
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@Data
public class Pics implements Serializable {
    private static final long serialVersionUID = -93685339442338954L;
    
    private Integer id;
    
    private String url;
    
    private String picDescription;
    //所属图集
    private Integer albumId;
    
    private Integer userId;
    //上传时间
    private Date uploadTime;
    //收藏数
    private Integer collectNum;
    //点赞数
    private Integer likeNum;



}