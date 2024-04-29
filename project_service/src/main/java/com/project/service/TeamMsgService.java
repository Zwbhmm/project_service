package com.project.service;
import java.util.Map;
import com.project.controller.LoginModel;
import com.project.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface TeamMsgService{
	/**
	分页查询参赛队伍数据总数
	*/
	public Map<String,Integer> getDataListCount(TeamMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询参赛队伍数据列表
	*/
	public Map<String,Object> getDataList(TeamMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装参赛队伍为前台展示的数据形式
	*/
	public Map<String,Object> getTeamMsgModel(TeamMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(TeamMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(TeamMsg model,LoginModel login);
}
