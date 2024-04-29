package com.project.service.shopService;


import com.project.dao.shop.ShopAdminDao;
import com.project.model.shopEntity.ShopAdmin;
import com.project.util.shopUtils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员的service层
 */

@Service
public class ShopAdminService {

    @Autowired
    private ShopAdminDao adminDao;

    /**
     * 管理员登陆方法
     *
     * @param admin
     * @return
     */
    public ShopAdmin login(ShopAdmin admin){
        return adminDao.login(admin);
    }

    /**
     * 管理员注册方法
     *
     * @param username
     * @param password
     * @return
     */
    public void adminRegister(String username,String password){

        //实例化一个admin对象,然后设置账号和密码
        ShopAdmin admin = new ShopAdmin();
        admin.setAdminName(username);
        admin.setAdminPassword(Md5Utils.setMD5(password));

        //持久化操作
        adminDao.adminRegister(admin);

        ShopAdmin admin1 = new ShopAdmin();
        admin1.setAdminName("test");
        admin1.setAdminPassword("123456");
        adminDao.adminRegister(admin1);

    }

}
