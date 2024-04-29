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
public class TeamMsgServiceImpl implements TeamMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMapper userMapper;
	@Autowired
	TeamMsgMapper teamMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(TeamMsg model,LoginModel login){
		if(model.getDwName()==null||model.getDwName().equals("")){
			return "队伍名为必填属性";
		}
		if(model.getDwLogo()==null||model.getDwLogo().equals("")){
			return "队徽为必填属性";
		}
		if(model.getDwLogo()!=null){
			String [] fileSplit = model.getDwLogo().split(";");
			if(fileSplit.length>1){
				return "队徽的图片数量不能大于1";
			}
		}
		if(model.getDwIntro()==null||model.getDwIntro().equals("")){
			return "队伍介绍为必填属性";
		}
		model.setUserId(login.getId());//登录id
		teamMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(TeamMsg model,LoginModel login){
		TeamMsg preModel = teamMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getDwName()==null||model.getDwName().equals("")){
			return "队伍名为必填属性";
		}
		if(model.getDwLogo()==null||model.getDwLogo().equals("")){
			return "队徽为必填属性";
		}
		if(model.getDwLogo()!=null){
			String [] fileSplit = model.getDwLogo().split(";");
			if(fileSplit.length>1){
				return "队徽的图片数量不能大于1";
			}
		}
		if(model.getDwIntro()==null||model.getDwIntro().equals("")){
			return "队伍介绍为必填属性";
		}
		preModel.setDwName(model.getDwName());
		preModel.setDwLogo(model.getDwLogo());
		preModel.setDwIntro(model.getDwIntro());
		teamMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询参赛队伍列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(TeamMsg queryModel,Integer pageSize,LoginModel login) {
		TeamMsgExample se = new TeamMsgExample();
		TeamMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDwName()!=null&&queryModel.getDwName().equals("")==false){
			sc.andDwNameLike("%"+queryModel.getDwName()+"%");//模糊查询
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		int count = (int)teamMsgMapper.countByExample(se);
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
	*根据参数查询参赛队伍列表数据
	*/
	@Override
	public Map<String,Object> getDataList(TeamMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		TeamMsgExample se = new TeamMsgExample();
		TeamMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDwName()!=null&&queryModel.getDwName().equals("")==false){
			sc.andDwNameLike("%"+queryModel.getDwName()+"%");//模糊查询
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<TeamMsg> list = teamMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(TeamMsg model:list){
			list2.add(getTeamMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装参赛队伍为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getTeamMsgModel(TeamMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("teamMsg",model);
		List<String> dwLogoList = new ArrayList<String>();
		if(model.getDwLogo()!=null){
			String [] dwLogoSplit = model.getDwLogo().split(";");
			for(String tmpstr:dwLogoSplit ){
				if(tmpstr.equals("")==false){
					dwLogoList.add(tmpstr);
				}
			}
		}
		map.put("dwLogoList",dwLogoList);
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
		teamMsgMapper.deleteByPrimaryKey(id);
	}
}
