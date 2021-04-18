package com.design.spicsback.service;

import com.design.spicsback.entity.AlbumTags;
import java.util.List;

/**
 * (TAlbumTags)表服务接口
 *
 * @author jj
 * @since 2021-02-15 09:07:47
 */
public interface AlbumTagsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AlbumTags queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AlbumTags> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param albumTags 实例对象
     * @return 实例对象
     */
    AlbumTags insert(AlbumTags albumTags);

    /**
     * 修改数据
     *
     * @param albumTags 实例对象
     * @return 实例对象
     */
    AlbumTags update(AlbumTags albumTags);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 添加画集标签
     * @param albumTags
     * @return
     */
    AlbumTags addOne(AlbumTags albumTags);
}