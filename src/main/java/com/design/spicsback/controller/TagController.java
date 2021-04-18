package com.design.spicsback.controller;

import com.design.spicsback.entity.Information;
import com.design.spicsback.entity.Tag;
import com.design.spicsback.service.TagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TTag)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@RestController
@RequestMapping("tag")
public class TagController {
    /**
     * 服务对象
     */
    @Resource
    private TagService tagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Tag selectOne(Integer id) {
        return this.tagService.queryById(id);
    }

    @PostMapping("addOne")
    public Information addOne(Tag tag){
        Tag isSuccess = this.tagService.insert(tag);
        if(isSuccess!=null){
            return Information.success("画集标签添加");
        }else{
            return Information.error(301,"画集标签添加失败");
        }
    }
}