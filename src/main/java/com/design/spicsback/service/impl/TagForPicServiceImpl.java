package com.design.spicsback.service.impl;

import com.design.spicsback.entity.TagForPic;
import com.design.spicsback.dao.TagForPicDao;
import com.design.spicsback.service.TagForPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TTagForPic)表服务实现类
 *
 * @author jj
 * @since 2021-02-22 00:03:10
 */
@Service("tTagForPicService")
public class TagForPicServiceImpl implements TagForPicService {
    @Resource
    private TagForPicDao tagForPicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TagForPic queryById(Integer id) {
        return this.tagForPicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TagForPic> queryAllByLimit(int offset, int limit) {
        return this.tagForPicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tagForPic 实例对象
     * @return 实例对象
     */
    @Override
    public TagForPic insert(TagForPic tagForPic) {
        this.tagForPicDao.insert(tagForPic);
        return tagForPic;
    }

    /**
     * 修改数据
     *
     * @param tagForPic 实例对象
     * @return 实例对象
     */
    @Override
    public TagForPic update(TagForPic tagForPic) {
        this.tagForPicDao.update(tagForPic);
        return this.queryById(tagForPic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tagForPicDao.deleteById(id) > 0;
    }

    /**
     * 查找标签名
     *
     * @param tagName
     * @return
     */
    @Override
    public TagForPic queryByTagName(String tagName) {
        return tagForPicDao.queryByTagName(tagName);
    }
}