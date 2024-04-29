package com.project.service.shopService;


import com.project.dao.shop.ShopUserDao;
import com.project.model.shopEntity.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopUserService {

    @Autowired
    private ShopUserDao shopUserDao;

    /**
     * 登录方法
     *
     * @param user
     * @return
     */
    public ShopUser login(ShopUser user){
        return shopUserDao.login(user);
    }

    /**
     * 查询所有的方法
     *
     * @return
     */
    public List<ShopUser> findAll(){
        return shopUserDao.findAll();
    }

    /**
     * 获取总的用户数
     *
     * @return
     */
    public Integer getAllUserCount(){
        return shopUserDao.getAllUserCount();
    }

    /**
     * 注册方法
     *
     * @param user
     */
    public void register(ShopUser user){
        shopUserDao.register(user);
    }

    /**
     * 查询用户名是否已经存在
     *
     * 存在    返回ShopUser
     * 不存在  返回null
     *
     * @param username
     * @return
     */
    public Boolean isExist(String username){

        //如果已经存在就返回true，如果不存在就返回false
        Boolean isExistOrNot = false;

        //判断是否能根据username查询到一个对象，如果对象不为空则说明该用户名的对象已经存在
        if (shopUserDao.isExist(username) != null) {
            //用户已存在
            isExistOrNot = true;
        } else {
            //用户不存在
            isExistOrNot = false;
        }
        return isExistOrNot;
    }

    /**
     * 根据username更新用户信息
     *
     * @param user
     */
    public void updateUserByUsername(ShopUser user){
        shopUserDao.updateUserByUsername(user);
    }

    /**
     * 根据用户id进行删除
     *
     * @param id
     */
    public void deleteByUserid(Integer id){
        shopUserDao.deleteByUserid(id);
    }

    /**
     * 根据用户id查询对象并返回
     *
     * @param userid
     * @return
     */
    public ShopUser getUserById(Integer userid){
        return shopUserDao.getUserById(userid);
    }

    /**
     * 根据用户id进行更新
     *
     * @param user
     */
    public void updateUserById(ShopUser user){
        shopUserDao.updateUserById(user);
    }

}