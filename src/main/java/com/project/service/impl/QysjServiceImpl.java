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
public class QysjServiceImpl implements QysjService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	QysjMapper qysjMapper;
	/**
	新增
	*/
	@Override
	public String add(Qysj model,LoginModel login){
		if(model.getQyName()==null||model.getQyName().equals("")){
			return "球员名为必填属性";
		}
		if(model.getQyIntro()==null||model.getQyIntro().equals("")){
			return "球员介绍为必填属性";
		}
		if(model.getQyImg()==null||model.getQyImg().equals("")){
			return "照片为必填属性";
		}
		if(model.getQyImg()!=null){
			String [] fileSplit = model.getQyImg().split(";");
			if(fileSplit.length>1){
				return "照片的图片数量不能大于1";
			}
		}
		if(model.getQyScore()==null||model.getQyScore().equals("")){
			return "球员成绩为必填属性";
		}
		qysjMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Qysj model,LoginModel login){
		Qysj preModel = qysjMapper.selectByPrimaryKey(model.getId());
		if(model.getQyName()==null||model.getQyName().equals("")){
			return "球员名为必填属性";
		}
		if(model.getQyIntro()==null||model.getQyIntro().equals("")){
			return "球员介绍为必填属性";
		}
		if(model.getQyImg()==null||model.getQyImg().equals("")){
			return "照片为必填属性";
		}
		if(model.getQyImg()!=null){
			String [] fileSplit = model.getQyImg().split(";");
			if(fileSplit.length>1){
				return "照片的图片数量不能大于1";
			}
		}
		if(model.getQyScore()==null||model.getQyScore().equals("")){
			return "球员成绩为必填属性";
		}
		preModel.setQyName(model.getQyName());
		preModel.setQyIntro(model.getQyIntro());
		preModel.setQyImg(model.getQyImg());
		preModel.setQyScore(model.getQyScore());
		qysjMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询NBA球员列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Qysj queryModel,Integer pageSize,LoginModel login) {
		QysjExample se = new QysjExample();
		QysjExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getQyName()!=null&&queryModel.getQyName().equals("")==false){
			sc.andQyNameLike("%"+queryModel.getQyName()+"%");//模糊查询
		}
		int count = (int)qysjMapper.countByExample(se);
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
	*根据参数查询NBA球员列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Qysj queryModel,Integer page,Integer pageSize,LoginModel login) {
		QysjExample se = new QysjExample();
		QysjExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getQyName()!=null&&queryModel.getQyName().equals("")==false){
			sc.andQyNameLike("%"+queryModel.getQyName()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Qysj> list = qysjMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Qysj model:list){
			list2.add(getQysjModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装NBA球员为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getQysjModel(Qysj model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("qysj",model);
		List<String> qyImgList = new ArrayList<String>();
		if(model.getQyImg()!=null){
			String [] qyImgSplit = model.getQyImg().split(";");
			for(String tmpstr:qyImgSplit ){
				if(tmpstr.equals("")==false){
					qyImgList.add(tmpstr);
				}
			}
		}
		map.put("qyImgList",qyImgList);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		qysjMapper.deleteByPrimaryKey(id);
	}
}
