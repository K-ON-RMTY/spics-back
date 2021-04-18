package com.design.spicsback.service;

import com.design.spicsback.entity.Album;
import java.util.List;

/**
 * (TAlbum)表服务接口
 *
 * @author jj
 * @since 2021-02-15 09:07:44
 */
public interface AlbumService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Album queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Album> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    Album insert(Album album);

    /**
     * 修改数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    Album update(Album album);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询用户所有的画集
     * @param userId 用户主键
     * @return 画集列表
     */
    List<Album> queryByUserId(Integer userId);

    /**
     * 查询是否重名
     * @param album 画集
     * @return 画集
     */
    Album queryByNameAndUserId(Album album);
}