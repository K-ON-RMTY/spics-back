package com.design.spicsback.dao;

import com.design.spicsback.entity.Pics;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TPics)表数据库访问层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
public interface PicsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Pics queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Pics> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pics 实例对象
     * @return 对象列表
     */
    List<Pics> queryAll(Pics pics);

    /**
     * 新增数据
     *
     * @param pics 实例对象
     * @return 影响行数
     */
    int insert(Pics pics);

    /**
     * 修改数据
     *
     * @param pics 实例对象
     * @return 影响行数
     */
    int update(Pics pics);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}