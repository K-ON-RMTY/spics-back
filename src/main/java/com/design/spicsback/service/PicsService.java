package com.design.spicsback.service;

import com.design.spicsback.entity.Pics;
import java.util.List;

/**
 * (TPics)表服务接口
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
public interface PicsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Pics queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Pics> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param pics 实例对象
     * @return 实例对象
     */
    Pics insert(Pics pics);

    /**
     * 修改数据
     *
     * @param pics 实例对象
     * @return 实例对象
     */
    Pics update(Pics pics);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}