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
@RequestMapping("index/post_detail")
public class IndexPostDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	PostMapper postMapper;
	@Autowired
	PostDisMapper postDisMapper;
	@Autowired
	UserMapper userMapper;
	//帖子详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		Post post = postMapper.selectByPrimaryKey(id);//查询帖子
		if(post==null){
			post = new Post();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		dataDetail.put("model",post);
		//解释用户ID
		User userIdT = userMapper.selectByPrimaryKey(post.getUserId());
		if(userIdT==null){
			userIdT = new User();
		}
		dataDetail.put("userIdT",userIdT);
		rs.put("postDetail",dataDetail);
		rs.put("code",1);
		return rs;
	}
	//分页查询帖子评论列表接口
	@RequestMapping("getPostDis")
	@ResponseBody
	public Object getPostDis(HttpServletRequest request,Integer page,Integer id){
		Map<String,Object> rs  = new HashMap<String,Object>();
		Integer pageSize=10;
		PostDisExample te = new PostDisExample();
		PostDisExample.Criteria tc = te.createCriteria();
		tc.andPoidEqualTo(id);
		te.setOrderByClause("id desc");
		int count = (int)postDisMapper.countByExample(te);
		int totalPage = 0;
		if ((page != null) && (pageSize != null)) { //分页
			if ((count > 0) && ((count % pageSize) == 0)) {
				totalPage = count / pageSize;
			} else {
				totalPage = (count / pageSize) + 1;
			}
			te.setPageRows(pageSize);//设置每页数量
			te.setStartRow((page - 1) * pageSize);//设置当前第几页
		}
		List<PostDis> tl = postDisMapper.selectByExample(te);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(PostDis t:tl){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("model",t);
			User uidT=userMapper.selectByPrimaryKey(t.getUid());
			map.put("uidT",uidT);
			list.add(map);
		}
		rs.put("list",list);
		rs.put("count",count);
		rs.put("totalPage",totalPage);
		rs.put("pageSize",pageSize);
		return rs;
	}
	//提交帖子评论接口
	@RequestMapping("submitPostDis")
	@ResponseBody
	public Object submitPostDis(HttpServletRequest request,Integer id,String ccontent){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if(ccontent==null||ccontent.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入帖子评论内容");
			return rs;
		}
		PostDis postDis = new PostDis();
		postDis.setContent(ccontent);
		postDis.setPoid(id);//帖子id
		postDis.setUid(login.getId());//登录id
		postDis.setCreateTime(sdf1.format(new Date()));//当前时间格式
		postDisMapper.insertSelective(postDis);
		rs.put("code",1);
		rs.put("msg","帖子评论成功");
		return rs;
	}
}
