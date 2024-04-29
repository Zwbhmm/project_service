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
public class GrsServiceImpl implements GrsService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	GrsMapper grsMapper;
	/**
	新增
	*/
	@Override
	public String add(Grs model,LoginModel login){
		if(model.getBsName()==null||model.getBsName().equals("")){
			return "比赛名称为必填属性";
		}
		if(model.getFmImg()==null||model.getFmImg().equals("")){
			return "封面图为必填属性";
		}
		if(model.getFmImg()!=null){
			String [] fileSplit = model.getFmImg().split(";");
			if(fileSplit.length>1){
				return "封面图的图片数量不能大于1";
			}
		}
		if(model.getBsTime()==null||model.getBsTime().equals("")){
			return "比赛时间为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "比赛地点为必填属性";
		}
		if(model.getCsdw()==null||model.getCsdw().equals("")){
			return "参赛队伍为必填属性";
		}
		model.setCreateDate(sdf2.format(new Date()));//当前日期格式
		grsMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Grs model,LoginModel login){
		Grs preModel = grsMapper.selectByPrimaryKey(model.getId());
		if(model.getBsName()==null||model.getBsName().equals("")){
			return "比赛名称为必填属性";
		}
		if(model.getFmImg()==null||model.getFmImg().equals("")){
			return "封面图为必填属性";
		}
		if(model.getFmImg()!=null){
			String [] fileSplit = model.getFmImg().split(";");
			if(fileSplit.length>1){
				return "封面图的图片数量不能大于1";
			}
		}
		if(model.getBsTime()==null||model.getBsTime().equals("")){
			return "比赛时间为必填属性";
		}
		if(model.getAddress()==null||model.getAddress().equals("")){
			return "比赛地点为必填属性";
		}
		if(model.getCsdw()==null||model.getCsdw().equals("")){
			return "参赛队伍为必填属性";
		}
		preModel.setBsName(model.getBsName());
		preModel.setFmImg(model.getFmImg());
		preModel.setBsTime(model.getBsTime());
		preModel.setAddress(model.getAddress());
		preModel.setCsdw(model.getCsdw());
		grsMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询个人赛列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Grs queryModel,Integer pageSize,LoginModel login) {
		GrsExample se = new GrsExample();
		GrsExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getBsName()!=null&&queryModel.getBsName().equals("")==false){
			sc.andBsNameLike("%"+queryModel.getBsName()+"%");//模糊查询
		}
		int count = (int)grsMapper.countByExample(se);
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
	*根据参数查询个人赛列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Grs queryModel,Integer page,Integer pageSize,LoginModel login) {
		GrsExample se = new GrsExample();
		GrsExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getBsName()!=null&&queryModel.getBsName().equals("")==false){
			sc.andBsNameLike("%"+queryModel.getBsName()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Grs> list = grsMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Grs model:list){
			list2.add(getGrsModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装个人赛为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getGrsModel(Grs model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("grs",model);
		List<String> fmImgList = new ArrayList<String>();
		if(model.getFmImg()!=null){
			String [] fmImgSplit = model.getFmImg().split(";");
			for(String tmpstr:fmImgSplit ){
				if(tmpstr.equals("")==false){
					fmImgList.add(tmpstr);
				}
			}
		}
		map.put("fmImgList",fmImgList);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		grsMapper.deleteByPrimaryKey(id);
	}
}
