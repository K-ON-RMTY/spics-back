package com.design.spicsback.controller;

import com.design.spicsback.entity.Album;
import com.design.spicsback.entity.AlbumTags;
import com.design.spicsback.entity.Information;
import com.design.spicsback.service.AlbumService;
import com.design.spicsback.service.AlbumTagsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private AlbumTagsService albumTagsService;
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

    /**
     * 添加画集
     * @param album 画集信息
     * @param albumTags 画集标签列表
     * @return
     */
    @PostMapping("add")
    public Information<Album> insertOne(Album album, List<AlbumTags> albumTags) {
        if (album.getAlbumName() ==  null || album.getAlbumName().trim().length() <=0 || album.getAlbumName().length()>10) {
            return Information.error(300,"画集名过长");
        }
        Album insert = albumService.insert(album);
        if (insert != null) {
            // 把标签加上
            if (albumTags != null) {
                for (AlbumTags tags : albumTags) {
                    albumTagsService.insert(tags);
                }
            }
            return Information.success(200,"添加成功", album);
        }else {
            return Information.error(501,"未知错误");
        }
    }


}