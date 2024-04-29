package com.project.dao.shop;

import com.project.model.shopEntity.ShopUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopUserDao {

    /**
     * 登录方法
     *
     * @param shopUser
     * @return
     */
    ShopUser login(ShopUser shopUser);

    /**
     * 查询所有
     *
     * @return
     */
    List<ShopUser> findAll();

    /**
     * 获取总的用户数
     *
     * @return
     */
    Integer getAllUserCount();

    /**
     * 注册方法
     *
     * @param shopUser
     */
    void register(ShopUser shopUser);

    /**
     * 判断用户名是否已经存在
     *
     * @param shopUserName
     * @return
     */
    ShopUser isExist(String shopUserName);

    /**
     * 更新用户信息
     *
     * @param shopUser
     */
    void updateUserByUsername(ShopUser shopUser);

    /**
     * 根据用户id进行删除操作
     *
     * @param id
     */
    void deleteByUserid(Integer id);

    /**
     * 根据用户id查询对象并返回
     *
     * @param userid
     * @return
     */
    ShopUser getUserById(Integer userid);

    /**
     * 根据用户id进行更新操作
     *
     * @param shopUser
     */
    void updateUserById(ShopUser shopUser);

}
