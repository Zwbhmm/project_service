package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface GrsAppService{
	/**
	分页查询个人赛申请数据总数
	*/
	public Map<String,Integer> getDataListCount(GrsApp queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询个人赛申请数据列表
	*/
	public Map<String,Object> getDataList(GrsApp queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装个人赛申请为前台展示的数据形式
	*/
	public Map<String,Object> getGrsAppModel(GrsApp model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(GrsApp model,LoginModel login);
	/**
	修改
	*/
	public String update(GrsApp model,LoginModel login);
	/**
	审核不通过
	*/
	public String shbtg(GrsApp model,LoginModel login);
}
