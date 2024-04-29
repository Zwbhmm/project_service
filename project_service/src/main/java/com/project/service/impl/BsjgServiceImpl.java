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
public class BsjgServiceImpl implements BsjgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	GrsMapper grsMapper;
	@Autowired
	BsjgMapper bsjgMapper;
	/**
	新增
	*/
	@Override
	public String add(Bsjg model,LoginModel login){
		if(model.getTeamName()==null||model.getTeamName().equals("")){
			return "得分队伍为必填属性";
		}
		if(model.getDfScore()==null){
			return "得分分数为必填属性";
		}
		if(model.getDfqy()==null||model.getDfqy().equals("")){
			return "得分球员为必填属性";
		}
		if(model.getZgqy()==null||model.getZgqy().equals("")){
			return "助攻球员为必填属性";
		}
		bsjgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Bsjg model,LoginModel login){
		Bsjg preModel = bsjgMapper.selectByPrimaryKey(model.getId());
		if(model.getTeamName()==null||model.getTeamName().equals("")){
			return "得分队伍为必填属性";
		}
		if(model.getDfScore()==null){
			return "得分分数为必填属性";
		}
		if(model.getDfqy()==null||model.getDfqy().equals("")){
			return "得分球员为必填属性";
		}
		if(model.getZgqy()==null||model.getZgqy().equals("")){
			return "助攻球员为必填属性";
		}
		preModel.setTeamName(model.getTeamName());
		preModel.setDfScore(model.getDfScore());
		preModel.setDfqy(model.getDfqy());
		preModel.setZgqy(model.getZgqy());
		bsjgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询比赛结果列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Bsjg queryModel,Integer pageSize,LoginModel login) {
		BsjgExample se = new BsjgExample();
		BsjgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getGrsid()!=null){
			sc.andGrsidEqualTo(queryModel.getGrsid());
		}
		if(queryModel.getTeamName()!=null&&queryModel.getTeamName().equals("")==false){
			sc.andTeamNameLike("%"+queryModel.getTeamName()+"%");//模糊查询
		}
		int count = (int)bsjgMapper.countByExample(se);
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
	*根据参数查询比赛结果列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Bsjg queryModel,Integer page,Integer pageSize,LoginModel login) {
		BsjgExample se = new BsjgExample();
		BsjgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getGrsid()!=null){
			sc.andGrsidEqualTo(queryModel.getGrsid());
		}
		if(queryModel.getTeamName()!=null&&queryModel.getTeamName().equals("")==false){
			sc.andTeamNameLike("%"+queryModel.getTeamName()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Bsjg> list = bsjgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Bsjg model:list){
			list2.add(getBsjgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装比赛结果为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getBsjgModel(Bsjg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bsjg",model);
		if(model.getGrsid()!=null){
			Grs grs = grsMapper.selectByPrimaryKey(model.getGrsid());//个人赛ID为外接字段，需要关联个人赛来解释该字段
			if(grs!=null){
				map.put("grsidStr",grs.getBsName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		bsjgMapper.deleteByPrimaryKey(id);
	}
}
