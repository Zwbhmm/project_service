package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface BsdtService{
	/**
	分页查询比赛动态数据总数
	*/
	public Map<String,Integer> getDataListCount(Bsdt queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询比赛动态数据列表
	*/
	public Map<String,Object> getDataList(Bsdt queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装比赛动态为前台展示的数据形式
	*/
	public Map<String,Object> getBsdtModel(Bsdt model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Bsdt model,LoginModel login);
	/**
	修改
	*/
	public String update(Bsdt model,LoginModel login);
}
