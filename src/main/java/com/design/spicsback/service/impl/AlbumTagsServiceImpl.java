package com.design.spicsback.service.impl;

import com.design.spicsback.entity.AlbumTags;
import com.design.spicsback.dao.AlbumTagsDao;
import com.design.spicsback.service.AlbumTagsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAlbumTags)表服务实现类
 *
 * @author jj
 * @since 2021-02-15 09:07:47
 */
@Service("tAlbumTagsService")
public class AlbumTagsServiceImpl implements AlbumTagsService {
    @Resource
    private AlbumTagsDao albumTagsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AlbumTags queryById(Integer id) {
        return this.albumTagsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AlbumTags> queryAllByLimit(int offset, int limit) {
        return this.albumTagsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param albumTags 实例对象
     * @return 实例对象
     */
    @Override
    public AlbumTags insert(AlbumTags albumTags) {
        this.albumTagsDao.insert(albumTags);
        return albumTags;
    }

    /**
     * 修改数据
     *
     * @param albumTags 实例对象
     * @return 实例对象
     */
    @Override
    public AlbumTags update(AlbumTags albumTags) {
        this.albumTagsDao.update(albumTags);
        return this.queryById(albumTags.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.albumTagsDao.deleteById(id) > 0;
    }

    /**
     * 添加画集标签
     *
     * @param albumTags
     * @return
     */
    @Override
    public AlbumTags addOne(AlbumTags albumTags) {
        return this.albumTagsDao.addOne(albumTags);
    }
}