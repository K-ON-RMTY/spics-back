package com.design.spicsback.dao;

import com.design.spicsback.entity.Like;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TLike)表数据库访问层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
public interface LikeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Like queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Like> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param like 实例对象
     * @return 对象列表
     */
    List<Like> queryAll(Like like);

    /**
     * 新增数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int insert(Like like);

    /**
     * 修改数据
     *
     * @param like 实例对象
     * @return 影响行数
     */
    int update(Like like);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Like addOne(Like like);

    boolean deleteByUserIdAndPicId(Like like);
}