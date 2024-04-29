package com.project.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.controller.LoginModel;
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
@RequestMapping("/login")
public class LoginController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	UserMapper userMapper;
	@Autowired
	AdminMapper adminMapper;
	/**
	退出接口
	*/
	@RequestMapping(value="sys_logout")
	@ResponseBody
	public Object sys_logout(ModelMap modelMap,String token,HttpServletRequest request){
		CacheManage.clearOnly(token);//删除登录token
		request.getSession().removeAttribute(CommonVal.sessionName);//删除登录session
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("code",1);
		return rs;
	}
	/**
	提交登录验证信息接口
	*/
	@RequestMapping("sysSubmit")
	@ResponseBody
	public Object sysSubmit(LoginModel user,String imgCode,String imgCodeToken,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String,Object> rs = new HashMap<String,Object>();
		//图片验证码验证，从session中查询验证码并校验
		if(imgCode==null||imgCode.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入图片验证码");
			return rs;
		}
		Cache codeCache = CacheManage.getCacheInfo(imgCodeToken);
		if(codeCache==null){
			rs.put("code",0);
			rs.put("msg","图片验证码错误");
		}
		String imgCode2 = codeCache.getValue().toString();
		if (!imgCode.toLowerCase().equals(imgCode2.toLowerCase())){//当前验证码存储session的值是否和输入的值一致
			rs.put("code",0);
			rs.put("msg","图片验证码错误");
			return rs;
		}
		if(user.getLoginType()==null){
			rs.put("code",0);
			rs.put("msg","请选择登录角色");
			return rs;
		}
		if(user.getName()==null||user.getName().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入登录名");
			return rs;
		}
		if(user.getPassword()==null||user.getPassword().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入密码");
			return rs;
		}
		if(user.getLoginType()==1){
			AdminExample te = new AdminExample();//验证管理员账号密码
			AdminExample.Criteria tc = te.createCriteria();
			tc.andLoginNameEqualTo(user.getName());//查询LoginName=用户名
			tc.andPasswordEqualTo(user.getPassword());//查询Password=输入的密码
			List<Admin> tl = adminMapper.selectByExample(te);
			if(tl.size()==0){//从数据库中查询不到账号
				rs.put("code",0);
				rs.put("msg","登录名或密码错误");
				return rs;
			}else{
				LoginModel login = new LoginModel();
				login.setId(tl.get(0).getId());
				login.setLoginType(1);
				login.setName(user.getName());
				String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
				CacheManage.putCache(uuid, new Cache(uuid,login,1000*60*60*24,false));
				rs.put("loginToken",uuid);
				rs.put("loginType",1);
				rs.put("loginId",tl.get(0).getId());
				rs.put("loginName",user.getName());
				rs.put("roleName","管理员");
				rs.put("code",1);
				rs.put("msg","登录成功");
				return rs;
			}
		}
		if(user.getLoginType()==2){
			UserExample te = new UserExample();//验证用户账号密码
			UserExample.Criteria tc = te.createCriteria();
			tc.andLoginNameEqualTo(user.getName());//查询LoginName=用户名
			tc.andPasswordEqualTo(user.getPassword());//查询Password=输入的密码
			List<User> tl = userMapper.selectByExample(te);
			if(tl.size()==0){//从数据库中查询不到账号
				rs.put("code",0);
				rs.put("msg","登录名或密码错误");
				return rs;
			}else{
				LoginModel login = new LoginModel();
				login.setId(tl.get(0).getId());
				login.setLoginType(2);
				login.setName(user.getName());
				String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
				CacheManage.putCache(uuid, new Cache(uuid,login,1000*60*60*24,false));
				rs.put("loginToken",uuid);
				rs.put("loginType",2);
				rs.put("loginId",tl.get(0).getId());
				rs.put("loginName",user.getName());
				rs.put("roleName","用户");
				rs.put("code",1);
				rs.put("msg","登录成功");
				return rs;
			}
		}
		rs.put("code",0);
		rs.put("msg","系统出错");
		return rs;
	}
	@RequestMapping(value="error")
	@ResponseBody
	public Object error(HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("code", 0);
		rs.put("msg", "尚未登录");
		return rs;
	}
	@RequestMapping(value="checkIsLogin")
	@ResponseBody
	public Object checkIsLogin(String loginToken,String roleName,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		Cache loginCache = CacheManage.getCacheInfo(loginToken);
		if(loginCache!=null){
			LoginModel login = (LoginModel)loginCache.getValue();
			rs.put("code", 1);
			rs.put("login", login);
			rs.put("loginToken", loginToken);
			rs.put("roleName", roleName);
			return rs;
		}
		rs.put("code", 0);
		rs.put("msg", "尚未登录");
		return rs;
	}
}
