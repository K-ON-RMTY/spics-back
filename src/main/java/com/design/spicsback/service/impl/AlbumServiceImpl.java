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
    private AlbumDao tAlbumDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Album queryById(Integer id) {
        return this.tAlbumDao.queryById(id);
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
        return this.tAlbumDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param album 实例对象
     * @return 实例对象
     */
    @Override
    public Album insert(Album album) {
        this.tAlbumDao.insert(album);
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
        this.tAlbumDao.update(album);
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
        return this.tAlbumDao.deleteById(id) > 0;
    }
}