package com.design.spicsback.controller;

import com.design.spicsback.entity.Information;
import com.design.spicsback.entity.TagForPic;
import com.design.spicsback.service.TagForPicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TTagForPic)表控制层
 *
 * @author jj
 * @since 2021-02-22 00:03:10
 */
@RestController
@RequestMapping("tagforpic")
public class TagForPicController {
    /**
     * 服务对象
     */
    @Resource
    private TagForPicService tagForPicService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TagForPic selectOne(Integer id) {
        return this.tagForPicService.queryById(id);
    }

    @PostMapping("add")
    public Information insert(TagForPic tagForPic) {
        if (tagForPic.getTagName() == null || tagForPic.getTagName().trim().length() ==0) {
            return Information.error(300,"标签名长度错误");
        }
        TagForPic tag = tagForPicService.queryByTagName(tagForPic.getTagName());
        if(tag != null) {
            return Information.success(200,"已存在", tag);
        }
        TagForPic insert = tagForPicService.insert(tagForPic);
        if (insert != null) {
            return Information.success(200,"成功添加", insert);
        }else {
            return Information.error(500,"未知错误");
        }
    }

}