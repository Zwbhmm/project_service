package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface JdVideoService{
	/**
	分页查询经典视频数据总数
	*/
	public Map<String,Integer> getDataListCount(JdVideo queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询经典视频数据列表
	*/
	public Map<String,Object> getDataList(JdVideo queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装经典视频为前台展示的数据形式
	*/
	public Map<String,Object> getJdVideoModel(JdVideo model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(JdVideo model,LoginModel login);
	/**
	修改
	*/
	public String update(JdVideo model,LoginModel login);
}
