package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface MrtService{
	/**
	分页查询NBA名人堂数据总数
	*/
	public Map<String,Integer> getDataListCount(Mrt queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询NBA名人堂数据列表
	*/
	public Map<String,Object> getDataList(Mrt queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装NBA名人堂为前台展示的数据形式
	*/
	public Map<String,Object> getMrtModel(Mrt model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Mrt model,LoginModel login);
	/**
	修改
	*/
	public String update(Mrt model,LoginModel login);
}
