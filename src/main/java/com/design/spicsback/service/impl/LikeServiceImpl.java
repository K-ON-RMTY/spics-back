package com.design.spicsback.service.impl;

import com.design.spicsback.entity.Like;
import com.design.spicsback.dao.LikeDao;
import com.design.spicsback.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TLike)表服务实现类
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@Service("tLikeService")
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeDao likeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Like queryById(Integer id) {
        return this.likeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Like> queryAllByLimit(int offset, int limit) {
        return this.likeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    @Override
    public Like insert(Like like) {
        this.likeDao.insert(like);
        return like;
    }

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 实例对象
     */
    @Override
    public Like update(Like like) {
        this.likeDao.update(like);
        return this.queryById(like.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.likeDao.deleteById(id) > 0;
    }
}