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
@RequestMapping("index/grs_detail")
public class IndexGrsDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	GrsDisMapper grsDisMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	GrsMapper grsMapper;
	@Autowired
	BsjgMapper bsjgMapper;
	//个人赛详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		Grs grs = grsMapper.selectByPrimaryKey(id);//查询个人赛
		if(grs==null){
			grs = new Grs();
		}
		rs.put("grsDetail",grs);
		BsjgExample be = new BsjgExample();
		BsjgExample.Criteria bc = be.createCriteria();
		bc.andGrsidEqualTo(id);
		be.setOrderByClause("id desc");
		int blSize=10;
		be.setPageRows(blSize);//每页数量
		be.setStartRow(0);//第一页
		List<Bsjg> bl=bsjgMapper.selectByExample(be);
		List<Map<String,Object>> blList = new ArrayList<Map<String,Object>>();
		for(Bsjg tmp:bl){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("model",tmp);
			blList.add(amap);
		}
		rs.put("bl",blList);
		rs.put("code",1);
		return rs;
	}
	//分页查询个人赛评论列表接口
	@RequestMapping("getGrsDis")
	@ResponseBody
	public Object getGrsDis(HttpServletRequest request,Integer page,Integer id){
		Map<String,Object> rs  = new HashMap<String,Object>();
		Integer pageSize=8;
		GrsDisExample te = new GrsDisExample();
		GrsDisExample.Criteria tc = te.createCriteria();
		tc.andGrsidEqualTo(id);
		te.setOrderByClause("id desc");
		int count = (int)grsDisMapper.countByExample(te);
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
		List<GrsDis> tl = grsDisMapper.selectByExample(te);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(GrsDis t:tl){
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
	//提交个人赛评论接口
	@RequestMapping("submitGrsDis")
	@ResponseBody
	public Object submitGrsDis(HttpServletRequest request,Integer id,String ccontent){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if(ccontent==null||ccontent.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入个人赛评论内容");
			return rs;
		}
		GrsDis grsDis = new GrsDis();
		grsDis.setContent(ccontent);
		grsDis.setGrsid(id);//个人赛id
		grsDis.setUid(login.getId());//登录id
		grsDis.setCreateTime(sdf1.format(new Date()));//当前时间格式
		grsDisMapper.insertSelective(grsDis);
		rs.put("code",1);
		rs.put("msg","个人赛评论成功");
		return rs;
	}
}
