package com.project.controller.chat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.dao.*;
import com.project.service.*;
import com.project.model.*;
import com.project.controller.*;
import com.project.util.PageUtils;
import com.project.util.*;
import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.HashSet;
import java.util.Set;
import java.text.SimpleDateFormat;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/chat")
public class ChatChatController {
	@Autowired
	SxLogMapper sxLogMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	ChatChatService chatChatService;
	private String defaultImg = "http://"+CommonVal.hostPort+"/project_service/static/pcchat/img/em_02.jpg";
	/**
	**/
	@RequestMapping(value = "chat")
	@ResponseBody
	public Object index(ModelMap modelMap,Integer targetId,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		modelMap.addAttribute("login", login);
		Map<String,Object> rs = new HashMap<String,Object>();
		if(login==null){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if(targetId!=null&&targetId.equals(login.getId())){
			rs.put("errCode",0);
			rs.put("errMsg","不能和自己聊天");
			return rs;
		}
		User user = userMapper.selectByPrimaryKey(login.getId());
		rs.put("userName",login.getName());
		rs.put("userImg",user.getHeadImg());
		if(targetId!=null){
			User user2 = userMapper.selectByPrimaryKey(targetId);
			rs.put("targetId",targetId);
			rs.put("targetName",user2.getLoginName());
			rs.put("targetImg",user2.getHeadImg());
		}
		int newMsgNum = chatChatService.getTotalNewChatLog(login);
		rs.put("newMsgNum",newMsgNum);
		rs.put("basePath","localhost:8080/project_service");
		rs.put("targetId",targetId);
		rs.put("code",1);
		return rs;
	}
	/**
	* 加载历史联系人
	* @return
	*/
	@RequestMapping(value = "getChatLog")
	@ResponseBody
	public Object loadChatLog( HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession()
		.getAttribute(CommonVal.sessionName);
		List<Map<String,Object>> logs = new ArrayList<Map<String,Object>>();
		SxLogExample ce = new SxLogExample();
		SxLogExample.Criteria cc = ce.createCriteria();
		cc.andUidEqualTo(login.getId());//我发给朋友的消息
		ce.setOrderByClause("id asc");
		List<SxLog> cl = sxLogMapper.selectByExample(ce);
		SxLogExample ce2 = new SxLogExample();
		SxLogExample.Criteria cc2 = ce2.createCriteria();
		cc2.andUid1EqualTo(login.getId());//朋友发给我的消息
		ce2.setOrderByClause("id asc");
		List<SxLog> cl2 = sxLogMapper.selectByExample(ce2);
		cl.addAll(cl2);
		Collections.sort(cl, new Comparator<SxLog>() {
			@Override
			public int compare(SxLog map1, SxLog map2) {
				return map2.getCreateTime().compareTo(map1.getCreateTime());
			}
		});//按最新聊天记录排序
		Set<Integer> uids = new HashSet<Integer>();//存储所有最近联系人
		for(SxLog c:cl){
			if(c.getUid1().equals(login.getId())==false){
				uids.add(c.getUid1());
			}
			if(c.getUid().equals(login.getId())==false){
				uids.add(c.getUid());
			}
		}
		for(Integer uid:uids){
			User chat = userMapper.selectByPrimaryKey(uid);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uname", chat.getLoginName());
			map.put("uimg", chat.getHeadImg());
			map.put("uid", chat.getId());
			SxLogExample ce3 = new SxLogExample();
			SxLogExample.Criteria cc3 = ce3.createCriteria();
			cc3.andUid1EqualTo(login.getId());
			cc3.andUidEqualTo(uid);
			cc3.andIsReadEqualTo(2);//未读
			int count= (int)sxLogMapper.countByExample(ce3);
			map.put("newLogsCount",count);
			map.put("newLog","");
			map.put("newLogTime","2000-01-01 00:00:00");
			for(SxLog c:cl){
				if(c.getUid().equals(uid)){
					map.put("newLogTime",c.getCreateTime());
					if(c.getContent()!=null&&c.getContent().trim().equals("")==false&&c.getContent().length()>8){
						map.put("newLog",c.getContent().substring(0,8)+"...");
					}else{
						map.put("newLog",c.getContent());
					}
					break;
				}
			}
			logs.add(map);
		}
		Collections.sort(logs, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> map1, Map<String,Object> map2) {
				return map1.get("newLogTime").toString().compareTo(map2.get("newLogTime").toString());
			}
		});//按最新聊天记录排序
		return logs;
	}
	/**
	*点某个联系人进行聊天
	* @return
	*/
	@RequestMapping(value = "viewUserLogs")
	@ResponseBody
	public Object viewUserLogs( HttpServletRequest request,Integer id){
		LoginModel login = (LoginModel) request.getSession()
		.getAttribute(CommonVal.sessionName);
		List<Map<String,Object>> logs = new ArrayList<Map<String,Object>>();
		//查询发给我或者我发过去的消息
		SxLogExample ce = new SxLogExample();
		SxLogExample.Criteria cc = ce.createCriteria();
		cc.andUidEqualTo(login.getId());
		cc.andUid1EqualTo(id);
		List<SxLog> cl = sxLogMapper.selectByExample(ce);
		SxLogExample ce2 = new SxLogExample();
		SxLogExample.Criteria cc2 = ce2.createCriteria();
		cc2.andUid1EqualTo(login.getId());
		cc2.andUidEqualTo(id);
		cl.addAll(sxLogMapper.selectByExample(ce2));
		Collections.sort(cl, new Comparator<SxLog>() {
			@Override
			public int compare(SxLog map1, SxLog map2) {
				return map1.getCreateTime().compareTo(map2.getCreateTime());
			}
		});//按最新聊天记录排序
		for(SxLog log:cl){
			User chat = userMapper.selectByPrimaryKey(log.getUid1());
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uname", chat.getLoginName());
			if(log.getUid().equals(login.getId())){
				map.put("sendType", 1);
			}
			if(log.getUid().equals(login.getId())==false){
				map.put("sendType", 2);
			}
			map.put("log", log.getContent());
			map.put("createTime", log.getCreateTime());
			logs.add(map);//别人发给我的信息
		}
		setRead(  request, id);//所有和他的聊天记录已读
		return logs;
	}
	/**
	*设置跟某个人的聊天记录为已读
	* @return
	*/
	@RequestMapping(value = "setRead")
	@ResponseBody
	public Object setRead( HttpServletRequest request,Integer id){
		LoginModel login = (LoginModel) request.getSession()
		.getAttribute(CommonVal.sessionName);
		SxLogExample ce = new SxLogExample();
		SxLogExample.Criteria cc = ce.createCriteria();
		cc.andUid1EqualTo(login.getId());
		cc.andUidEqualTo(id);
		cc.andIsReadEqualTo(2);
		SxLog log = new SxLog();
		log.setIsRead(1);//更新为已读状态
		sxLogMapper.updateByExampleSelective(log, ce);
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("code", 1);
		return rs;
	}
}
