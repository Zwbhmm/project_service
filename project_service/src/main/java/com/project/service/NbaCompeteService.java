package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface NbaCompeteService{
	/**
	分页查询NBA比赛数据总数
	*/
	public Map<String,Integer> getDataListCount(NbaCompete queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询NBA比赛数据列表
	*/
	public Map<String,Object> getDataList(NbaCompete queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装NBA比赛为前台展示的数据形式
	*/
	public Map<String,Object> getNbaCompeteModel(NbaCompete model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(NbaCompete model,LoginModel login);
	/**
	修改
	*/
	public String update(NbaCompete model,LoginModel login);
}
