package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface BannerService{
	/**
	分页查询轮播图数据总数
	*/
	public Map<String,Integer> getDataListCount(Banner queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询轮播图数据列表
	*/
	public Map<String,Object> getDataList(Banner queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装轮播图为前台展示的数据形式
	*/
	public Map<String,Object> getBannerModel(Banner model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Banner model,LoginModel login);
	/**
	修改
	*/
	public String update(Banner model,LoginModel login);
}
