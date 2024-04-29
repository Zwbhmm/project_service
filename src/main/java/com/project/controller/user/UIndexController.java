package com.project.controller.user;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.controller.LoginModel;
import com.project.util.CommonVal;
import  com.project.model.*;
import com.project.dao.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user/index")
public class UIndexController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	UserMapper userMapper;
	@Autowired
	ChatChatService chatChatService;
	@RequestMapping(value="getInitData")
	@ResponseBody
	public Object getInitData(HttpServletRequest request){
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		User user = userMapper.selectByPrimaryKey(login.getId());
		rs.put("user", user);
		int chatNewMsgNum = chatChatService.getTotalNewChatLog(login);
		rs.put("chatNewMsgNum",chatNewMsgNum);
		return rs;
	}
}
