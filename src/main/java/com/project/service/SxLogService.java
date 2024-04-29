package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface SxLogService{
	/**
	分页查询私信记录数据总数
	*/
	public Map<String,Integer> getDataListCount(SxLog queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询私信记录数据列表
	*/
	public Map<String,Object> getDataList(SxLog queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装私信记录为前台展示的数据形式
	*/
	public Map<String,Object> getSxLogModel(SxLog model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
