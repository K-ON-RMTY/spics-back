package com.design.spicsback.dao;

import com.design.spicsback.entity.PicTags;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TPicTags)表数据库访问层
 *
 * @author jj
 * @since 2021-02-22 00:01:51
 */
public interface PicTagsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PicTags queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PicTags> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param picTags 实例对象
     * @return 对象列表
     */
    List<PicTags> queryAll(PicTags picTags);

    /**
     * 新增数据
     *
     * @param picTags 实例对象
     * @return 影响行数
     */
    int insert(PicTags picTags);

    /**
     * 修改数据
     *
     * @param picTags 实例对象
     * @return 影响行数
     */
    int update(PicTags picTags);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 添加画集
     * @param picTags
     * @return
     */
    PicTags addOne(PicTags picTags);
}