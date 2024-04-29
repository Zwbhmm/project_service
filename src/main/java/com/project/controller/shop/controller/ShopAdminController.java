package com.project.controller.shop.controller;

import com.project.model.shopEntity.ShopAdmin;
import com.project.service.shopService.ShopAdminService;
import com.project.util.shopUtils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/shopAdmin")
public class ShopAdminController {

    @Autowired
    private ShopAdminService adminService;

    /**
     * 管理员登录方法
     *
     * @param username
     * @param password
     * @param request
     * @return
     */
    @GetMapping("/login")
    public ShopAdmin login(String username, String password, HttpServletRequest request){

        //初始化登录方法
        HttpSession session = request.getSession();

        //把账号密码设置进admin对象中去
        ShopAdmin admin = new ShopAdmin();
        admin.setAdminName(username);
        admin.setAdminPassword(password);
        System.out.println(password);
        ShopAdmin current_admin = adminService.login(admin);

        //判断该admin对象是否存在
        if (current_admin == null) {
            //如果不存在直接返回null
            return null;
        } else {
            //存在的话就直接将该admin对象存入session进行共享操作
            session.setAttribute("admin",current_admin);
        }

        //System.out.println(current_admin);    //输出测试

        //返回一个登录的对象
        return current_admin;
    }

    /**
     * 判断我们的管理员是否已经登陆的方法
     *
     * @param request
     * @return
     */
    @GetMapping("/isLogin")
    public ShopAdmin isLogin(HttpServletRequest request){

        //初始化session
        HttpSession session = request.getSession();
        //获取存在session域中的admin对象
        ShopAdmin admin = (ShopAdmin) session.getAttribute("admin");

        //判断该admin对象是否存在
        if (admin == null || admin.getAdminId() == null) {
            //如果不存在的话就直接返回null
            return null;
        } else {
            //如果存在就返回admin对象
            return admin;
        }

    }

    /**
     * 判断我们的管理员是否已经登陆的方法
     *
     * @param request
     * @return
     */
    @GetMapping("/isLogins")
    public ShopAdmin isLogins(HttpServletRequest request){

        //初始化session
        HttpSession session = request.getSession();
        //获取存在session域中的admin对象
        ShopAdmin admin = (ShopAdmin) session.getAttribute("admin");

        //判断该admin对象是否存在
        if (admin == null || admin.getAdminId() == null) {
            //如果不存在的话就直接返回null
            return null;
        } else {
            //如果存在就返回admin对象
            return admin;
        }

    }

    /**
     * 退出管理员账号
     *
     * @param request
     * @return
     */
    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){

        //初始化session
        HttpSession session = request.getSession();
        //去除存储在session域中的admin对象
        try {
            session.removeAttribute("admin");
        } catch (Exception e) {
            return "ERROR";
        }

        return "OK";
    }

    /**
     * 注册方法
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/adminRegister")
    public String adminRegister(String username,String password){

        //管理员注册
        adminService.adminRegister(username,password);

        return "OK";
    }

}
