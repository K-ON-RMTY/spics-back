package com.design.spicsback.service;

import com.design.spicsback.entity.User;
import java.util.List;

/**
 * (TUser)表服务接口
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
public interface UserService {
    

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    User queryByUserNameAndPwd(String username, String password);

    User queryById(Integer id);

    User queryByUserName(String username);
}