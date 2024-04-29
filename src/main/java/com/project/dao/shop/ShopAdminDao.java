package com.project.dao.shop;

import com.project.model.shopEntity.ShopAdmin;
import org.springframework.stereotype.Repository;

/**
 * 管理员的dao层操作
 */

@Repository
public interface ShopAdminDao {

    /**
     * 登录方法
     *
     * @param shopAdmin
     * @return
     */
    ShopAdmin login(ShopAdmin shopAdmin);

    /**
     * 注册方法
     *
     * @param shopAdmin
     */
    void adminRegister(ShopAdmin shopAdmin);

}
