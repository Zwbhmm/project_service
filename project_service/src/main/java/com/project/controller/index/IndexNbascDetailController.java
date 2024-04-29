package com.project.controller.index;
import com.project.controller.*;
import com.project.dao.*;
import com.project.model.*;
import com.project.service.*;
import com.project.util.*;
import com.project.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.DecimalFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import java.text.DecimalFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("index/nbasc_detail")
public class IndexNbascDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	NbascMapper nbascMapper;
	//NBA赛程详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		Nbasc nbasc = nbascMapper.selectByPrimaryKey(id);//查询NBA赛程
		if(nbasc==null){
			nbasc = new Nbasc();
		}
		rs.put("nbascDetail",nbasc);
		rs.put("code",1);
		return rs;
	}
}
