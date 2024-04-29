package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface UserService{
	/**
	分页查询用户数据总数
	*/
	public Map<String,Integer> getDataListCount(User queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询用户数据列表
	*/
	public Map<String,Object> getDataList(User queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装用户为前台展示的数据形式
	*/
	public Map<String,Object> getUserModel(User model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(User model,LoginModel login);
	/**
	修改
	*/
	public String update(User model,LoginModel login);
	/**
	修改
	*/
	public String update1(User model,LoginModel login);
}
