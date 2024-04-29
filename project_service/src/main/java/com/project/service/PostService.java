package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface PostService{
	/**
	分页查询帖子数据总数
	*/
	public Map<String,Integer> getDataListCount(Post queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询帖子数据列表
	*/
	public Map<String,Object> getDataList(Post queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装帖子为前台展示的数据形式
	*/
	public Map<String,Object> getPostModel(Post model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Post model,LoginModel login);
	/**
	修改
	*/
	public String update(Post model,LoginModel login);
}
