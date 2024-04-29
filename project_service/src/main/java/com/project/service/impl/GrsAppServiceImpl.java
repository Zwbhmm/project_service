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
public class GrsAppServiceImpl implements GrsAppService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	GrsAppMapper grsAppMapper;
	@Autowired
	UserMapper userMapper;
	/**
	新增
	*/
	@Override
	public String add(GrsApp model,LoginModel login){
		if(model.getBsName()==null||model.getBsName().equals("")){
			return "比赛名为必填属性";
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
		if(model.getBsdd()==null||model.getBsdd().equals("")){
			return "比赛地点为必填属性";
		}
		if(model.getBsIntro()==null||model.getBsIntro().equals("")){
			return "比赛介绍为必填属性";
		}
		model.setCheckStatus(1);//默认待审核,
		model.setUserId(login.getId());//登录id
		model.setCreateDate(sdf2.format(new Date()));//当前日期格式
		grsAppMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(GrsApp model,LoginModel login){
		GrsApp preModel = grsAppMapper.selectByPrimaryKey(model.getId());
		if(model.getBsName()==null||model.getBsName().equals("")){
			return "比赛名为必填属性";
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
		if(model.getBsdd()==null||model.getBsdd().equals("")){
			return "比赛地点为必填属性";
		}
		if(model.getBsIntro()==null||model.getBsIntro().equals("")){
			return "比赛介绍为必填属性";
		}
		preModel.setBsName(model.getBsName());
		preModel.setFmImg(model.getFmImg());
		preModel.setBsTime(model.getBsTime());
		preModel.setBsdd(model.getBsdd());
		preModel.setBsIntro(model.getBsIntro());
		grsAppMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	审核不通过
	*/
	@Override
	public String shbtg(GrsApp model,LoginModel login){
		GrsApp preModel = grsAppMapper.selectByPrimaryKey(model.getId());
		if(model.getCheckRemark()==null||model.getCheckRemark().equals("")){
			return "审核备注为必填属性";
		}
		preModel.setCheckStatus(3);//审核状态设置为审核不通过
		preModel.setCheckRemark(model.getCheckRemark());
		grsAppMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询个人赛申请列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(GrsApp queryModel,Integer pageSize,LoginModel login) {
		GrsAppExample se = new GrsAppExample();
		GrsAppExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getBsName()!=null&&queryModel.getBsName().equals("")==false){
			sc.andBsNameLike("%"+queryModel.getBsName()+"%");//模糊查询
		}
		if(queryModel.getCheckStatus()!=null){
			sc.andCheckStatusEqualTo(queryModel.getCheckStatus());//查询审核状态等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		int count = (int)grsAppMapper.countByExample(se);
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
	*根据参数查询个人赛申请列表数据
	*/
	@Override
	public Map<String,Object> getDataList(GrsApp queryModel,Integer page,Integer pageSize,LoginModel login) {
		GrsAppExample se = new GrsAppExample();
		GrsAppExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getBsName()!=null&&queryModel.getBsName().equals("")==false){
			sc.andBsNameLike("%"+queryModel.getBsName()+"%");//模糊查询
		}
		if(queryModel.getCheckStatus()!=null){
			sc.andCheckStatusEqualTo(queryModel.getCheckStatus());//查询审核状态等于指定值
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<GrsApp> list = grsAppMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(GrsApp model:list){
			list2.add(getGrsAppModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装个人赛申请为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getGrsAppModel(GrsApp model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("grsApp",model);
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
		map.put("checkStatusStr",DataListUtils.getCheckStatusNameById(model.getCheckStatus()+""));//解释审核状态字段
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
		grsAppMapper.deleteByPrimaryKey(id);
	}
}
