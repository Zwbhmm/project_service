package com.project.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.controller.LoginModel;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.util.CommonVal;
import  com.project.model.*;
import com.project.dao.*;
import com.project.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/regist")
public class RegistController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	UserMapper userMapper;
	/**
	提交注册信息接口
	*/
	@RequestMapping("userRegistSubmit")
	@ResponseBody
	public Object userRegistSubmit(String imgCode,String imgCodeToken,String name,String password,String realName,String celPhone,Integer sex,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> rs = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		Cache codeCache = CacheManage.getCacheInfo(imgCodeToken);
		if(codeCache==null){
			rs.put("code",0);
			rs.put("msg","图片验证码错误");
		}
		String imgCode2 = codeCache.getValue().toString();
		if (!imgCode.toLowerCase().equals(imgCode2.toLowerCase())){//当前验证码存储session的值是否和输入的值一致
			rs.put("code",0);
			rs.put("msg", "图片验证码错误");
			return rs;
		}
		if(name==null||name.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入登录名");
			return rs;
		}
		if(name!=null){
			UserExample te=new UserExample();
			UserExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(name);
			int count = (int)userMapper.countByExample(te);
			if(count>0){
				rs.put("code",0);
				rs.put("msg",   "该账号已被注册，请用该账号登录");
				return rs;
			}
		}
		if(password==null||password.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入密码");
			return rs;
		}
		if(realName==null||realName.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入姓名");
			return rs;
		}
		if(celPhone==null||celPhone.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入联系电话");
			return rs;
		}
		if(celPhone!=null&&celPhone.trim().equals("")==false){
		Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
			Matcher m = p.matcher(celPhone);
			if( m.matches()==false){
				;
				rs.put("code",0);
				rs.put("msg",   "请填入正确的联系电话");
				return rs;
			}
		}
		if(sex==null){
			rs.put("code",0);
			rs.put("msg",   "请填入性别");
			return rs;
		}
		User model = new User();
		model.setLoginName(name);
		model.setPassword(password);
		model.setRealName(realName);
		model.setCelPhone(celPhone);
		model.setSex(sex);
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		userMapper.insertSelective(model);//注册成功，插入该账号进数据库，并返回提示
		rs.put("code",1);
		rs.put("msg",  "注册成功，请使用该账号密码登录");
		return rs;
	}
	@RequestMapping("getListData")
	@ResponseBody
	public Object getListData(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> usexList = DataListUtils.getUsexList();
		rs.put("usexList",usexList);
		return rs;
	}
}
