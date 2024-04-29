//package com.project.service.impl;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.project.dao.*;
//import com.project.model.*;
//import com.project.service.*;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import com.project.util.*;
//import org.springframework.ui.ModelMap;
//import java.util.*;
//import com.project.service.*;
//import com.project.controller.LoginModel;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.text.ParseException;
//import java.io.IOException;
//@Service
//public class VeoDisServiceImpl implements VeoDisService{
//	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
//	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
//	@Autowired
//	JdVideoMapper jdVideoMapper;
//	@Autowired
//	VeoDisMapper veoDisMapper;
//	@Autowired
//	UserMapper userMapper;
//	/**
//	*根据参数查询视频评论列表总数
//	*/
//	@Override
//	public Map<String,Integer> getDataListCount(VeoDis queryModel,Integer pageSize,LoginModel login) {
//		VeoDisExample se = new VeoDisExample();
//		VeoDisExample.Criteria sc = se.createCriteria();
//		se.setOrderByClause("id desc");//默认按照id倒序排序
//		if(queryModel.getId()!=null){
//			sc.andIdEqualTo(queryModel.getId());
//		}
//		if(queryModel.getContent()!=null&&queryModel.getContent().equals("")==false){
//			sc.andContentLike("%"+queryModel.getContent()+"%");//模糊查询
//		}
//		if(queryModel.getUid()!=null){
//			sc.andUidEqualTo(queryModel.getUid());
//		}
//		int count = (int)veoDisMapper.countByExample(se);
//		int totalPage = 0;
//		if ((count > 0) && ((count % pageSize) == 0)) {
//			totalPage = count / pageSize;
//		} else {
//			totalPage = (count / pageSize) + 1;
//		}
//		Map<String,Integer> rs = new HashMap<String,Integer>();
//		rs.put("count",count);//数据总数
//		rs.put("totalPage",totalPage);//总页数
//		return rs;
//	}
//	/**
//	*根据参数查询视频评论列表数据
//	*/
//	@Override
//	public Map<String,Object> getDataList(VeoDis queryModel,Integer page,Integer pageSize,LoginModel login) {
//		VeoDisExample se = new VeoDisExample();
//		VeoDisExample.Criteria sc = se.createCriteria();
//		se.setOrderByClause("id desc");//默认按照id倒序排序
//		if(queryModel.getId()!=null){
//			sc.andIdEqualTo(queryModel.getId());
//		}
//		if(queryModel.getContent()!=null&&queryModel.getContent().equals("")==false){
//			sc.andContentLike("%"+queryModel.getContent()+"%");//模糊查询
//		}
//		if(queryModel.getUid()!=null){
//			sc.andUidEqualTo(queryModel.getUid());
//		}
//		if(page!=null&&pageSize!=null){
//			se.setPageRows(pageSize);
//			se.setStartRow((page-1)*pageSize);
//		}
//		List<VeoDis> list = veoDisMapper.selectByExample(se);//执行查询语句
//		Map<String,Object> rs = new HashMap<String,Object>();
//		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
//		for(VeoDis model:list){
//			list2.add(getVeoDisModel(model,login));
//		}
//		rs.put("list",list2);//数据列表
//		return rs;
//	}
//	/**
//	封装视频评论为前台展示的数据形式
//	*/
//	@Override
//	public Map<String,Object> getVeoDisModel(VeoDis model,LoginModel login){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("veoDis",model);
//		if(model.getJid()!=null){
//			JdVideo jdVideo = jdVideoMapper.selectByPrimaryKey(model.getJid());//视频ID为外接字段，需要关联经典视频来解释该字段
//			if(jdVideo!=null){
//				map.put("jidStr",jdVideo.getTitle());
//			}
//		}
//		if(model.getUid()!=null){
//			User user = userMapper.selectByPrimaryKey(model.getUid());//用户ID为外接字段，需要关联用户来解释该字段
//			if(user!=null){
//				map.put("uidStr",user.getLoginName());
//			}
//		}
//		return map;
//	}
//	/**
//	* 删除数据
//	*/
//	@Override
//	public void delete(Integer id) {
//		veoDisMapper.deleteByPrimaryKey(id);
//	}
//}
