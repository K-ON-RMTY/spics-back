package com.design.spicsback.dao;

import com.design.spicsback.entity.TagForPic;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TTagForPic)表数据库访问层
 *
 * @author jj
 * @since 2021-02-22 00:03:10
 */
public interface TagForPicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TagForPic queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TagForPic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tagForPic 实例对象
     * @return 对象列表
     */
    List<TagForPic> queryAll(TagForPic tagForPic);

    /**
     * 新增数据
     *
     * @param tagForPic 实例对象
     * @return 影响行数
     */
    int insert(TagForPic tagForPic);

    /**
     * 修改数据
     *
     * @param tagForPic 实例对象
     * @return 影响行数
     */
    int update(TagForPic tagForPic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    /**
     * 查找标签名
     *
     * @param tagName
     * @return
     */
    TagForPic queryByTagName(String tagName);
}