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

    @GetMapping("/select/user/{userId}")
    public Information selectByUserId (@PathVariable Integer userId) {
        List<Album> albumList = this.albumService.queryByUserId(userId);
        System.out.println(albumList);
        if (albumList == null) {
            return Information.error(501, "没有结果");
        }
        return Information.success(200,"画集列表", albumList);
    }

    /**
     * 添加画集
     * @param album 画集信息
     * @param tagIds 画集标签列表
     * @return
     */
    @PostMapping("add")
    public Information insertOne(Album album, @RequestParam List<Integer> tagIds) {
        if (album.getAlbumName() ==  null || album.getAlbumName().trim().length() <=0 || album.getAlbumName().length()>10) {
            return Information.error(300,"画集名错误");
        }
        // 查询是否重名
        Album isMore = this.albumService.queryByNameAndUserId(album);
        if(isMore != null) {
            return Information.error(300,"重复画集名");
        }
        Album insert = albumService.insert(album);
        if (insert != null) {
            // 把标签加上
            if (tagIds != null) {
                for (Integer tid : tagIds) {
                    AlbumTags tag = new AlbumTags();
                    tag.setTagId(tid);
                    tag.setAlbumId(insert.getId());
                    albumTagsService.insert(tag);
                }
            }
            return Information.success(200,"添加成功", album);
        }else {
            return Information.error(501,"未知错误");
        }
    }




}