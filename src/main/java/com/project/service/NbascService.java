package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface NbascService{
	/**
	分页查询NBA赛程数据总数
	*/
	public Map<String,Integer> getDataListCount(Nbasc queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询NBA赛程数据列表
	*/
	public Map<String,Object> getDataList(Nbasc queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装NBA赛程为前台展示的数据形式
	*/
	public Map<String,Object> getNbascModel(Nbasc model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Nbasc model,LoginModel login);
	/**
	修改
	*/
	public String update(Nbasc model,LoginModel login);
}
