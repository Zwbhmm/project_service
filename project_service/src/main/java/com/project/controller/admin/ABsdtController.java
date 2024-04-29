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
@RequestMapping("/admin/bsdt")
public class ABsdtController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	BsdtService bsdtService;
	@Autowired
	BsdtMapper bsdtMapper;
	@Autowired
	AdminMapper adminMapper;
	/**
	* 根据查询条件分页查询比赛动态数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(Bsdt model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return bsdtService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}

	/**
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryDataDetail")
	@ResponseBody
	public Object queryDataDetail(Integer id, HttpServletRequest request) {
		Bsdt bsdt = bsdtMapper.selectByPrimaryKey(id);
		return bsdt;
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
	* 根据查询条件分页查询比赛动态数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(Bsdt model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return bsdtService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	查看详情接口
	*/
	@RequestMapping("getDetailData")
	@ResponseBody
	public Object detail1(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		Bsdt model = new Bsdt();
		model.setId(id);
		Bsdt preModel = bsdtMapper.selectByPrimaryKey(id);
		rs.put("detail", bsdtService.getBsdtModel(preModel,login));
		rs.put("code", 1);
		return rs;
	}
	/**
	删除比赛动态接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		bsdtService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	/**
	新增修改界面所需数据
	*/
	@RequestMapping("add")
	@ResponseBody
	public Object add(Bsdt model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("data",model);
		rs.put("code",1);
		return rs;
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(Bsdt model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = bsdtService.add(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","新增成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	新增修改界面所需数据
	*/
	@RequestMapping("update")
	@ResponseBody
	public Object update(Bsdt model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		Map<String,Object> rs = new HashMap<String,Object>();
		Bsdt data = bsdtMapper.selectByPrimaryKey(model.getId());
		if(data.getBsdw()!=null){
			data.setBsdw(data.getBsdw().replaceAll("'","\\\\'"));//wangeditor需要过滤掉'符号，否则初始化可能报错
		}
		rs.put("data",data);
		rs.put("code",1);
		return rs;
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(Bsdt model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = bsdtService.update(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
}