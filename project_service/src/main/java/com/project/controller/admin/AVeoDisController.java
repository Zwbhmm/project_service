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
@RequestMapping("/admin/veo_dis")
public class AVeoDisController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	VeoDisService veoDisService;
	@Autowired
	JdVideoMapper jdVideoMapper;
	@Autowired
	VeoDisMapper veoDisMapper;
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	UserMapper userMapper;
	/**
	* 根据查询条件分页查询视频评论数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(VeoDis model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return veoDisService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		VeoDis veoDis = veoDisMapper.selectByPrimaryKey(id);
		return veoDis;
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
		return rs;
	}
	/**
	* 根据查询条件分页查询视频评论数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(VeoDis model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return veoDisService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除视频评论接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		veoDisService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}
