package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface AdminService{
	/**
	分页查询管理员数据总数
	*/
	public Map<String,Integer> getDataListCount(Admin queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询管理员数据列表
	*/
	public Map<String,Object> getDataList(Admin queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装管理员为前台展示的数据形式
	*/
	public Map<String,Object> getAdminModel(Admin model,LoginModel login);
}
