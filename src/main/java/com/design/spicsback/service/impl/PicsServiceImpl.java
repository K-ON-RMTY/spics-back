package com.design.spicsback.service.impl;

import com.design.spicsback.entity.Pics;
import com.design.spicsback.dao.PicsDao;
import com.design.spicsback.service.PicsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPics)表服务实现类
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@Service("tPicsService")
public class PicsServiceImpl implements PicsService {
    @Resource
    private PicsDao picsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Pics queryById(Integer id) {
        return this.picsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Pics> queryAllByLimit(int offset, int limit) {
        return this.picsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pics 实例对象
     * @return 实例对象
     */
    @Override
    public Pics insert(Pics pics) {
        this.picsDao.insert(pics);
        return pics;
    }

    /**
     * 修改数据
     *
     * @param pics 实例对象
     * @return 实例对象
     */
    @Override
    public Pics update(Pics pics) {
        this.picsDao.update(pics);
        return this.queryById(pics.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.picsDao.deleteById(id) > 0;
    }
}