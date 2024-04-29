package com.project.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
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
import java.util.HashSet;
import java.util.Set;
import java.text.SimpleDateFormat;
@Service
public class ChatChatServiceImpl  implements ChatChatService {
	@Autowired
	SxLogMapper sxLogMapper;
	@Autowired
	UserMapper userMapper;
	@Override
	public int getTotalNewChatLog(LoginModel login){
		int totalNum=0;
		if(login==null){
			return totalNum;
		}
		SxLogExample ce3 = new SxLogExample();
		SxLogExample.Criteria cc3 = ce3.createCriteria();
		cc3.andUid1EqualTo(login.getId());
		cc3.andIsReadEqualTo(2);//未读
		totalNum= (int)sxLogMapper.countByExample(ce3);
		return totalNum;
	}
}
