package com.project.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dao.*;
import com.project.model.*;
import com.project.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.project.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.project.service.*;
import com.project.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.io.IOException;
@Service
public class PostServiceImpl implements PostService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	PostMapper postMapper;
	@Autowired
	UserMapper userMapper;
	/**
	新增
	*/
	@Override
	public String add(Post model,LoginModel login){
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getPostContent()==null||model.getPostContent().equals("")){
			return "帖子内容为必填属性";
		}
		model.setUserId(login.getId());//登录id
		model.setCreateDate(sdf2.format(new Date()));//当前日期格式
		postMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Post model,LoginModel login){
		Post preModel = postMapper.selectByPrimaryKey(model.getId());
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getPostContent()==null||model.getPostContent().equals("")){
			return "帖子内容为必填属性";
		}
		preModel.setTitle(model.getTitle());
		preModel.setPostContent(model.getPostContent());
		postMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询帖子列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Post queryModel,Integer pageSize,LoginModel login) {
		PostExample se = new PostExample();
		PostExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		int count = (int)postMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询帖子列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Post queryModel,Integer page,Integer pageSize,LoginModel login) {
		PostExample se = new PostExample();
		PostExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Post> list = postMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Post model:list){
			list2.add(getPostModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装帖子为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getPostModel(Post model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("post",model);
		if(model.getUserId()!=null){
			User user = userMapper.selectByPrimaryKey(model.getUserId());//用户ID为外接字段，需要关联用户来解释该字段
			if(user!=null){
				map.put("userIdStr",user.getLoginName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		postMapper.deleteByPrimaryKey(id);
	}
}
