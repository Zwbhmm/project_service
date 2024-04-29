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
public class MrtServiceImpl implements MrtService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	MrtMapper mrtMapper;
	/**
	新增
	*/
	@Override
	public String add(Mrt model,LoginModel login){
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
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
		if(model.getDetail()==null||model.getDetail().equals("")){
			return "详情为必填属性";
		}
		if(model.getVideoUrl()==null||model.getVideoUrl().equals("")){
			return "名人堂视频为必填属性";
		}
		if(model.getVideoUrl()!=null){
			String [] fileSplit = model.getVideoUrl().split(";");
			if(fileSplit.length>1){
				return "名人堂视频的视频数量不能大于1";
			}
		}
		model.setCreateDate(sdf2.format(new Date()));//当前日期格式
		mrtMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Mrt model,LoginModel login){
		Mrt preModel = mrtMapper.selectByPrimaryKey(model.getId());
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
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
		if(model.getDetail()==null||model.getDetail().equals("")){
			return "详情为必填属性";
		}
		if(model.getVideoUrl()==null||model.getVideoUrl().equals("")){
			return "名人堂视频为必填属性";
		}
		if(model.getVideoUrl()!=null){
			String [] fileSplit = model.getVideoUrl().split(";");
			if(fileSplit.length>1){
				return "名人堂视频的视频数量不能大于1";
			}
		}
		preModel.setTitle(model.getTitle());
		preModel.setFmImg(model.getFmImg());
		preModel.setDetail(model.getDetail());
		preModel.setVideoUrl(model.getVideoUrl());
		mrtMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询NBA名人堂列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Mrt queryModel,Integer pageSize,LoginModel login) {
		MrtExample se = new MrtExample();
		MrtExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getVideoUrl()!=null&&queryModel.getVideoUrl().equals("")==false){
			sc.andVideoUrlLike("%"+queryModel.getVideoUrl()+"%");//模糊查询
		}
		int count = (int)mrtMapper.countByExample(se);
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
	*根据参数查询NBA名人堂列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Mrt queryModel,Integer page,Integer pageSize,LoginModel login) {
		MrtExample se = new MrtExample();
		MrtExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getVideoUrl()!=null&&queryModel.getVideoUrl().equals("")==false){
			sc.andVideoUrlLike("%"+queryModel.getVideoUrl()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Mrt> list = mrtMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Mrt model:list){
			list2.add(getMrtModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装NBA名人堂为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getMrtModel(Mrt model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mrt",model);
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
		List<String> videoUrlList = new ArrayList<String>();
		if(model.getVideoUrl()!=null){
			String [] videoUrlSplit = model.getVideoUrl().split(";");
			for(String tmpstr:videoUrlSplit ){
				if(tmpstr.equals("")==false){
					videoUrlList.add(tmpstr);
				}
			}
		}
		map.put("videoUrlList",videoUrlList);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		mrtMapper.deleteByPrimaryKey(id);
	}
}
