package com.design.spicsback.service;

import com.design.spicsback.entity.TagForPic;
import java.util.List;

/**
 * (TTagForPic)表服务接口
 *
 * @author jj
 * @since 2021-02-22 00:03:10
 */
public interface TagForPicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TagForPic queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TagForPic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tagForPic 实例对象
     * @return 实例对象
     */
    TagForPic insert(TagForPic tagForPic);

    /**
     * 修改数据
     *
     * @param tagForPic 实例对象
     * @return 实例对象
     */
    TagForPic update(TagForPic tagForPic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查找标签名
     * @param tagName
     * @return
     */
    TagForPic queryByTagName(String tagName);
}