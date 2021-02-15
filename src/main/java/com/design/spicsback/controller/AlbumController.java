package com.design.spicsback.controller;

import com.design.spicsback.entity.Album;
import com.design.spicsback.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TAlbum)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:45
 */
@RestController
@RequestMapping("album")
public class AlbumController {
    /**
     * 服务对象
     */
    @Resource
    private AlbumService albumService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Album selectOne(Integer id) {
        return this.albumService.queryById(id);
    }

}