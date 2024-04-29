package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface PraiseLogService{
	/**
	分页查询视频点赞数据总数
	*/
	public Map<String,Integer> getDataListCount(PraiseLog queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询视频点赞数据列表
	*/
	public Map<String,Object> getDataList(PraiseLog queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装视频点赞为前台展示的数据形式
	*/
	public Map<String,Object> getPraiseLogModel(PraiseLog model,LoginModel login);
}
