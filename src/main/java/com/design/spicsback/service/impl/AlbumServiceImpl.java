package com.design.spicsback.service.impl;

import com.design.spicsback.entity.Album;
import com.design.spicsback.dao.AlbumDao;
import com.design.spicsback.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAlbum)表服务实现类
 *
 * @author jj
 * @since 2021-02-15 09:07:44
 */
@Service("tAlbumService")
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumDao albumDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Album queryById(Integer id) {
        return this.albumDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Album> queryAllByLimit(int offset, int limit) {
        return this.albumDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    @Override
    public Album insert(Album album) {
        this.albumDao.insert(album);
        return album;
    }

    /**
     * 修改数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    @Override
    public Album update(Album album) {
        this.albumDao.update(album);
        return this.queryById(album.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.albumDao.deleteById(id) > 0;
    }

    /**
     * 查询用户所有的画集
     *
     * @param userId 用户主键
     * @return 画集列表
     */
    @Override
    public List<Album> queryByUserId(Integer userId) {
        return this.albumDao.queryByUserId(userId);
    }

    /**
     * 查询是否重名
     *
     * @param album 画集
     * @return 画集
     */
    @Override
    public Album queryByNameAndUserId(Album album) {
        return this.albumDao.queryByNameAndUserId(album);
    }
}