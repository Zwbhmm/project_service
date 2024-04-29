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
public class NbascServiceImpl implements NbascService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	NbascMapper nbascMapper;
	/**
	新增
	*/
	@Override
	public String add(Nbasc model,LoginModel login){
		if(model.getDzsf()==null||model.getDzsf().equals("")){
			return "对阵双方为必填属性";
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
		if(model.getBsdd()==null||model.getBsdd().equals("")){
			return "比赛地点为必填属性";
		}
		if(model.getBsTime()==null||model.getBsTime().equals("")){
			return "比赛时间为必填属性";
		}
		model.setFbTime(sdf1.format(new Date()));//当前时间格式
		nbascMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Nbasc model,LoginModel login){
		Nbasc preModel = nbascMapper.selectByPrimaryKey(model.getId());
		if(model.getDzsf()==null||model.getDzsf().equals("")){
			return "对阵双方为必填属性";
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
		if(model.getBsdd()==null||model.getBsdd().equals("")){
			return "比赛地点为必填属性";
		}
		if(model.getBsTime()==null||model.getBsTime().equals("")){
			return "比赛时间为必填属性";
		}
		preModel.setDzsf(model.getDzsf());
		preModel.setFmImg(model.getFmImg());
		preModel.setBsdd(model.getBsdd());
		preModel.setBsTime(model.getBsTime());
		nbascMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询NBA赛程列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Nbasc queryModel,Integer pageSize,LoginModel login) {
		NbascExample se = new NbascExample();
		NbascExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDzsf()!=null&&queryModel.getDzsf().equals("")==false){
			sc.andDzsfLike("%"+queryModel.getDzsf()+"%");//模糊查询
		}
		int count = (int)nbascMapper.countByExample(se);
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
	*根据参数查询NBA赛程列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Nbasc queryModel,Integer page,Integer pageSize,LoginModel login) {
		NbascExample se = new NbascExample();
		NbascExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDzsf()!=null&&queryModel.getDzsf().equals("")==false){
			sc.andDzsfLike("%"+queryModel.getDzsf()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Nbasc> list = nbascMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Nbasc model:list){
			list2.add(getNbascModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装NBA赛程为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getNbascModel(Nbasc model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nbasc",model);
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
		nbascMapper.deleteByPrimaryKey(id);
	}
}
