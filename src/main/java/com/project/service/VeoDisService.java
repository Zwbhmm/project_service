package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface VeoDisService{
	/**
	分页查询视频评论数据总数
	*/
	public Map<String,Integer> getDataListCount(VeoDis queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询视频评论数据列表
	*/
	public Map<String,Object> getDataList(VeoDis queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装视频评论为前台展示的数据形式
	*/
	public Map<String,Object> getVeoDisModel(VeoDis model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
