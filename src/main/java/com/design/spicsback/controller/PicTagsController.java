package com.design.spicsback.controller;

import com.design.spicsback.entity.Information;
import com.design.spicsback.entity.PicTags;
import com.design.spicsback.service.PicTagsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TPicTags)表控制层
 *
 * @author jj
 * @since 2021-02-22 00:01:51
 */
@RestController
@RequestMapping("tPicTags")
public class PicTagsController {
    /**
     * 服务对象
     */
    @Resource
    private PicTagsService picTagsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PicTags selectOne(Integer id) {
        return this.picTagsService.queryById(id);
    }

    /**
     * 添加图片标签
     * @param picTags
     * @return
     */
    @PostMapping("addOne")
    public Information addOne(PicTags picTags){
        PicTags isSuccess = this.picTagsService.insert(picTags);
        if(isSuccess!=null){
            return Information.success("添加图片标签");
        }else{
            return Information.error(301,"添加图片标签失败");
        }
    }

}