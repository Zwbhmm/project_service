package com.project.controller.admin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.project.dao.*;
import com.project.model.*;
import com.project.service.impl.*;
import com.project.util.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.project.controller.LoginModel;
import com.project.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/admin/grs_app")
public class AGrsAppController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	GrsAppService grsAppService;
	@Autowired
	GrsAppMapper grsAppMapper;
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	UserMapper userMapper;
	public void getList(Map<String,Object> rs ,LoginModel login){
		rs.put("checkStatusList",DataListUtils.getCheckStatusList());//返回check_status列表
	}
	/**
	* 根据查询条件分页查询个人赛申请数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(GrsApp model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return grsAppService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		GrsApp grsApp = grsAppMapper.selectByPrimaryKey(id);
		return grsApp;
	}
	/**
	* 查询页面所需要的数据
	*/
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(String loginToken,HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		Admin admin = adminMapper.selectByPrimaryKey(login.getId());
		rs.put("user",admin);
		getList( rs,login);//获取数据列表并返回给前台
		return rs;
	}
	/**
	* 根据查询条件分页查询个人赛申请数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(GrsApp model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return grsAppService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	查看详情接口
	*/
	@RequestMapping("getDetailData")
	@ResponseBody
	public Object detail1(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		GrsApp model = new GrsApp();
		model.setId(id);
		GrsApp preModel = grsAppMapper.selectByPrimaryKey(id);
		rs.put("detail", grsAppService.getGrsAppModel(preModel,login));
		rs.put("code", 1);
		return rs;
	}
	/**
	删除个人赛申请接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		grsAppService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	/**
	新增修改界面所需数据
	*/
	@RequestMapping("shbtg")
	@ResponseBody
	public Object shbtg(GrsApp model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		Map<String,Object> rs = new HashMap<String,Object>();
		getList( rs,login);//获取前台需要用到的数据列表并返回给前台
		GrsApp data = grsAppMapper.selectByPrimaryKey(model.getId());
		if(data.getBsIntro()!=null){
			data.setBsIntro(data.getBsIntro().replaceAll("'","\\\\'"));//wangeditor需要过滤掉'符号，否则初始化可能报错
		}
		rs.put("data",data);
		rs.put("code",1);
		return rs;
	}
	/**
	审核不通过提交信息接口
	*/
	@RequestMapping("shbtg_submit")
	@ResponseBody
	public Object shbtg_submit(GrsApp model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = grsAppService.shbtg(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","审核不通过成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	@RequestMapping(value = "shtg")
	@ResponseBody
	public Object shtg(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		GrsApp model = grsAppMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该个人赛申请已不存在");
			return rs;
		}
		model.setCheckStatus(2);
		grsAppMapper.updateByPrimaryKey(model);
		rs.put("code", 1);
		rs.put("msg","审核通过成功");
		return rs;
	}
}