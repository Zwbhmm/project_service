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
public class UserServiceImpl implements UserService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMapper userMapper;
	/**
	新增
	*/
	@Override
	public String add(User model,LoginModel login){
		if(model.getLoginName()==null||model.getLoginName().equals("")){
			return "登录名为必填属性";
		}
		if(model.getLoginName()!=null){
			UserExample te=new UserExample();
			UserExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(model.getLoginName());
			int count = (int)userMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 登录名 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getHeadImg()==null||model.getHeadImg().equals("")){
			return "头像为必填属性";
		}
		if(model.getHeadImg()!=null){
			String [] fileSplit = model.getHeadImg().split(";");
			if(fileSplit.length>1){
				return "头像的图片数量不能大于1";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		userMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(User model,LoginModel login){
		User preModel = userMapper.selectByPrimaryKey(model.getId());
		if(model.getLoginName()==null||model.getLoginName().equals("")){
			return "登录名为必填属性";
		}
		if(model.getLoginName()!=null){
			UserExample te=new UserExample();
			UserExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(model.getLoginName());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)userMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 登录名 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getHeadImg()==null||model.getHeadImg().equals("")){
			return "头像为必填属性";
		}
		if(model.getHeadImg()!=null){
			String [] fileSplit = model.getHeadImg().split(";");
			if(fileSplit.length>1){
				return "头像的图片数量不能大于1";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		preModel.setLoginName(model.getLoginName());
		preModel.setPassword(model.getPassword());
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setHeadImg(model.getHeadImg());
		preModel.setSex(model.getSex());
		userMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update1(User model,LoginModel login){
		User preModel = userMapper.selectByPrimaryKey(model.getId());
		if(model.getRealName()==null||model.getRealName().equals("")){
			return "姓名为必填属性";
		}
		if(model.getCelPhone()==null||model.getCelPhone().equals("")){
			return "联系电话为必填属性";
		}
		if(model.getCelPhone()!=null){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(model.getCelPhone());
			if( m.matches()==false){
				return "请输入正确的联系电话";
			}
		}
		if(model.getHeadImg()==null||model.getHeadImg().equals("")){
			return "头像为必填属性";
		}
		if(model.getHeadImg()!=null){
			String [] fileSplit = model.getHeadImg().split(";");
			if(fileSplit.length>1){
				return "头像的图片数量不能大于1";
			}
		}
		if(model.getSex()==null){
			return "性别为必填属性";
		}
		preModel.setRealName(model.getRealName());
		preModel.setCelPhone(model.getCelPhone());
		preModel.setHeadImg(model.getHeadImg());
		preModel.setSex(model.getSex());
		userMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询用户列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(User queryModel,Integer pageSize,LoginModel login) {
		UserExample se = new UserExample();
		UserExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		int count = (int)userMapper.countByExample(se);
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
	*根据参数查询用户列表数据
	*/
	@Override
	public Map<String,Object> getDataList(User queryModel,Integer page,Integer pageSize,LoginModel login) {
		UserExample se = new UserExample();
		UserExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getRealName()!=null&&queryModel.getRealName().equals("")==false){
			sc.andRealNameLike("%"+queryModel.getRealName()+"%");//模糊查询
		}
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<User> list = userMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(User model:list){
			list2.add(getUserModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装用户为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getUserModel(User model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user",model);
		List<String> headImgList = new ArrayList<String>();
		if(model.getHeadImg()!=null){
			String [] headImgSplit = model.getHeadImg().split(";");
			for(String tmpstr:headImgSplit ){
				if(tmpstr.equals("")==false){
					headImgList.add(tmpstr);
				}
			}
		}
		map.put("headImgList",headImgList);
		map.put("sexStr",DataListUtils.getUsexNameById(model.getSex()+""));//解释性别字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
}
