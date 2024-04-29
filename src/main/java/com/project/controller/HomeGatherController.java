package com.project.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import com.project.dao.*;
import com.project.model.*;
import com.project.service.*;
import com.project.controller.*;
import com.project.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/home")
public class HomeGatherController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	JdVideoMapper jdVideoMapper;
	@Autowired
	PostMapper postMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	GrsMapper grsMapper;
	@RequestMapping(value="getHomeMsg")
	@ResponseBody
	public Object getHomeMsg(HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		if(login==null){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		String today = sdf2.format(new Date());
		//
		//查询用户数
		UserExample de1 = new UserExample();
		List<User> dl1 = userMapper.selectByExample(de1);
		rs.put("data1",dl1.size());
		//
		//查询个人赛数
		GrsExample de2 = new GrsExample();
		List<Grs> dl2 = grsMapper.selectByExample(de2);
		rs.put("data2",dl2.size());
		//
		//查询帖子数
		PostExample de3 = new PostExample();
		List<Post> dl3 = postMapper.selectByExample(de3);
		rs.put("data3",dl3.size());
		//
		//查询经典视频数
		JdVideoExample de4 = new JdVideoExample();
		List<JdVideo> dl4 = jdVideoMapper.selectByExample(de4);
		rs.put("data4",dl4.size());
		//
		//查询注册统计
		UserExample de5 = new UserExample();
		List<User> dl5 = userMapper.selectByExample(de5);
		List<Map<String,Object>> dlist5 = new ArrayList<Map<String,Object>>();
		String startDate5 = CommonUtils.getDiffDate(today,-7,sdf2,3);//起始日期是7天前
		List<String> allDate5 = DateCommonUtils.getEchartTimeList(startDate5, today, "yyyy-MM-dd", "yyyy-MM-dd", 3);//查询范围内的所有日期集合
		for(String date:allDate5){
			Integer  value  = 0;//数量
			for(User d:dl5){
				if(d.getCreateTime().contains(date)){
					value++;
				}
			}
			Map<String,Object> map =  new HashMap<String,Object>();
			map.put("title",date);
			map.put("value",value);
			dlist5.add(map);
		}
		rs.put("data5",dlist5);
		//
		//查询用户性别统计
		UserExample de6 = new UserExample();
		List<User> dl6 = userMapper.selectByExample(de6);
		List<Map<String,Object>> dlist6 = DataListUtils.getUsexList();
		for(Map<String,Object> map:dlist6){
			Integer  value  = 0;
			for(User d:dl6){
				if(map.get("id").toString().equals(d.getSex()+"")){
					value++;
				}
			}
			map.put("title",map.get("name").toString());
			map.put("value",value);
		}
		rs.put("data6",dlist6);
		rs.put("code",1);
		rs.put("msg","请求成功");
		return rs;
	}
}
