package com.design.spicsback.service.impl;

import com.design.spicsback.entity.PicTags;
import com.design.spicsback.dao.PicTagsDao;
import com.design.spicsback.service.PicTagsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPicTags)表服务实现类
 *
 * @author jj
 * @since 2021-02-22 00:01:51
 */
@Service("tPicTagsService")
public class PicTagsServiceImpl implements PicTagsService {
    @Resource
    private PicTagsDao picTagsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PicTags queryById(Integer id) {
        return this.picTagsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PicTags> queryAllByLimit(int offset, int limit) {
        return this.picTagsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param picTags 实例对象
     * @return 实例对象
     */
    @Override
    public PicTags insert(PicTags picTags) {
        this.picTagsDao.insert(picTags);
        return picTags;
    }

    /**
     * 修改数据
     *
     * @param picTags 实例对象
     * @return 实例对象
     */
    @Override
    public PicTags update(PicTags picTags) {
        this.picTagsDao.update(picTags);
        return this.queryById(picTags.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.picTagsDao.deleteById(id) > 0;
    }

    @Override
    public PicTags addOne(PicTags picTags) {
        return this.picTagsDao.addOne(picTags);
    }
}