package com.design.spicsback.controller;

import com.design.spicsback.entity.AlbumTags;
import com.design.spicsback.entity.Information;
import com.design.spicsback.service.AlbumTagsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TAlbumTags)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:47
 */
@RestController
@RequestMapping("albumTags")
public class AlbumTagsController {
    /**
     * 服务对象
     */
    @Resource
    private AlbumTagsService albumTagsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AlbumTags selectOne(Integer id) {
        return this.albumTagsService.queryById(id);
    }

    /**
     * 添加画集标签
     * @param albumTags
     * @return
     */
    @PostMapping("addOne")
    public Information addOne(AlbumTags albumTags){
        AlbumTags isSuccess = this.albumTagsService.insert(albumTags);
        if(isSuccess!=null){
            return Information.success("画集标签添加");
        }else{
            return Information.error(301,"画集标签添加失败");
        }
    }

}