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

/**
 * 后台管理员管理轮播图
 */
@Service
public class BannerServiceImpl implements BannerService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	BannerMapper bannerMapper;
	/**
	新增
	*/
	@Override
	public String add(Banner model,LoginModel login){
		if(model.getBanner()==null||model.getBanner().equals("")){
			return "轮播图为必填属性";
		}
		if(model.getBanner()!=null){
			String [] fileSplit = model.getBanner().split(";");
			if(fileSplit.length>1){
				return "轮播图的图片数量不能大于1";
			}
		}
		bannerMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Banner model,LoginModel login){
		Banner preModel = bannerMapper.selectByPrimaryKey(model.getId());
		if(model.getBanner()==null||model.getBanner().equals("")){
			return "轮播图为必填属性";
		}
		if(model.getBanner()!=null){
			String [] fileSplit = model.getBanner().split(";");
			if(fileSplit.length>1){
				return "轮播图的图片数量不能大于1";
			}
		}
		preModel.setBanner(model.getBanner());
		bannerMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}

	/**
	 * 根据参数查询轮播图列表总数(返回数据总数和总页数)
	 * @param queryModel
	 * @param pageSize
	 * @param login
	 * @return
	 */
	@Override
	public Map<String,Integer> getDataListCount(Banner queryModel,Integer pageSize,LoginModel login) {
		BannerExample se = new BannerExample();
		BannerExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)bannerMapper.countByExample(se);
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
	*根据参数查询轮播图列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Banner queryModel,Integer page,Integer pageSize,LoginModel login) {
		BannerExample se = new BannerExample();
		BannerExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<Banner> list = bannerMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Banner model:list){
			list2.add(getBannerModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装轮播图为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getBannerModel(Banner model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("banner",model);
		List<String> bannerList = new ArrayList<String>();
		if(model.getBanner()!=null){
			String [] bannerSplit = model.getBanner().split(";");
			for(String tmpstr:bannerSplit ){
				if(tmpstr.equals("")==false){
					bannerList.add(tmpstr);
				}
			}
		}
		map.put("bannerList",bannerList);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		bannerMapper.deleteByPrimaryKey(id);
	}
}
