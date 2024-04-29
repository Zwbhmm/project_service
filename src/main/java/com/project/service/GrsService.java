package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface GrsService{
	/**
	分页查询个人赛数据总数
	*/
	public Map<String,Integer> getDataListCount(Grs queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询个人赛数据列表
	*/
	public Map<String,Object> getDataList(Grs queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装个人赛为前台展示的数据形式
	*/
	public Map<String,Object> getGrsModel(Grs model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Grs model,LoginModel login);
	/**
	修改
	*/
	public String update(Grs model,LoginModel login);
}
