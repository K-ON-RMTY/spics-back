package com.design.spicsback.dto;

import com.design.spicsback.entity.TagForPic;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TagsForPic implements Serializable {
    //  Json字符串
   String tagForPics;
}
