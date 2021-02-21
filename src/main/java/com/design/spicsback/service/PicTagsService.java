package com.design.spicsback.service;

import com.design.spicsback.entity.PicTags;
import java.util.List;

/**
 * (TPicTags)表服务接口
 *
 * @author jj
 * @since 2021-02-22 00:01:51
 */
public interface PicTagsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PicTags queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PicTags> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param picTags 实例对象
     * @return 实例对象
     */
    PicTags insert(PicTags picTags);

    /**
     * 修改数据
     *
     * @param picTags 实例对象
     * @return 实例对象
     */
    PicTags update(PicTags picTags);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}