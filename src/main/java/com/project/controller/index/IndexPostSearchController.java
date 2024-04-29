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
@RequestMapping("index/post_search")
public class IndexPostSearchController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	PostMapper postMapper;
	//论坛
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("code",1);
		return rs;
	}
	//获取帖子列表数据
	@RequestMapping("queryPostList")
	@ResponseBody
	public Object queryPostList(HttpServletRequest request,Integer page,String title){
		PostExample qe = new PostExample();
		PostExample.Criteria qc = qe.createCriteria();
		if(title!=null&&title.trim().equals("")==false){
			qc.andTitleLike("%"+title+"%");
		}
		qe.setOrderByClause("id desc");
		int pageSize=10;
		int count = (int) postMapper.countByExample(qe);
		int totalPage = 0;
		if (page != null) {
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			qe.setPageRows(pageSize);//每页数量
			qe.setStartRow((page - 1) * pageSize);//第几页
		}
		List<Post> ql=postMapper.selectByExample(qe);
		List<Map<String,Object>> qlList = new ArrayList<Map<String,Object>>();
		for(Post tmp:ql){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("model",tmp);
			qlList.add(amap);
		}
		Map<String,Object> rs = new HashMap<String,Object>();
		rs.put("count",count);
		rs.put("pageSize",pageSize);
		rs.put("totalPage",totalPage);
		rs.put("list",qlList);
		return rs;
	}
}
