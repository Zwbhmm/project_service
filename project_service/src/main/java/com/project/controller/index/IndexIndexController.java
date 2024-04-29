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
@RequestMapping("index/index")
public class IndexIndexController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	BsdtMapper bsdtMapper;
	@Autowired
	MrtMapper mrtMapper;
	@Autowired
	JdVideoMapper jdVideoMapper;
	@Autowired
	PostMapper postMapper;
	@Autowired
	NbaCompeteMapper nbaCompeteMapper;
	@Autowired
	BannerMapper bannerMapper;
	@Autowired
	NbascMapper nbascMapper;
	@Autowired
	QysjMapper qysjMapper;
	@Autowired
	GrsMapper grsMapper;
	//首页
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		NbaCompeteExample ne = new NbaCompeteExample();
		NbaCompeteExample.Criteria nc = ne.createCriteria();
		ne.setOrderByClause("id desc");
		int nlSize=10;
		ne.setPageRows(nlSize);//每页数量
		ne.setStartRow(0);//第一页
		List<NbaCompete> nl=nbaCompeteMapper.selectByExample(ne);
		rs.put("nl",nl);
		NbascExample ne1 = new NbascExample();
		NbascExample.Criteria nc1 = ne1.createCriteria();
		ne1.setOrderByClause("id desc");
		int nl1Size=8;
		ne1.setPageRows(nl1Size);//每页数量
		ne1.setStartRow(0);//第一页
		List<Nbasc> nl1=nbascMapper.selectByExample(ne1);
		rs.put("nl1",nl1);
		QysjExample qe = new QysjExample();
		QysjExample.Criteria qc = qe.createCriteria();
		qe.setOrderByClause("id desc");
		int qlSize=8;
		qe.setPageRows(qlSize);//每页数量
		qe.setStartRow(0);//第一页
		List<Qysj> ql=qysjMapper.selectByExample(qe);
		rs.put("ql",ql);
		GrsExample ge = new GrsExample();
		GrsExample.Criteria gc = ge.createCriteria();
		ge.setOrderByClause("id desc");
		int glSize=8;
		ge.setPageRows(glSize);//每页数量
		ge.setStartRow(0);//第一页
		List<Grs> gl=grsMapper.selectByExample(ge);
		rs.put("gl",gl);
		BsdtExample be = new BsdtExample();
		BsdtExample.Criteria bc = be.createCriteria();
		be.setOrderByClause("id desc");
		int blSize=8;
		be.setPageRows(blSize);//每页数量
		be.setStartRow(0);//第一页
		List<Bsdt> bl=bsdtMapper.selectByExample(be);
		rs.put("bl",bl);
		MrtExample me = new MrtExample();
		MrtExample.Criteria mc = me.createCriteria();
		me.setOrderByClause("id desc");
		int mlSize=8;
		me.setPageRows(mlSize);//每页数量
		me.setStartRow(0);//第一页
		List<Mrt> ml=mrtMapper.selectByExample(me);
		rs.put("ml",ml);
		JdVideoExample je = new JdVideoExample();
		JdVideoExample.Criteria jc = je.createCriteria();
		je.setOrderByClause("praise_num desc");
		int jlSize=8;
		je.setPageRows(jlSize);//每页数量
		je.setStartRow(0);//第一页
		List<JdVideo> jl=jdVideoMapper.selectByExample(je);
		List<Map<String,Object>> jlList = new ArrayList<Map<String,Object>>();
		for(JdVideo tmp:jl){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("model",tmp);
			jlList.add(amap);
		}
		rs.put("jl",jlList);
		PostExample pe = new PostExample();
		PostExample.Criteria pc = pe.createCriteria();
		pe.setOrderByClause("id desc");
		int plSize=8;
		pe.setPageRows(plSize);//每页数量
		pe.setStartRow(0);//第一页
		List<Post> pl=postMapper.selectByExample(pe);
		List<Map<String,Object>> plList = new ArrayList<Map<String,Object>>();
		for(Post tmp:pl){
			Map<String,Object> amap = new HashMap<String,Object>();
			amap.put("model",tmp);
			plList.add(amap);
		}
		rs.put("pl",plList);
		BannerExample be1 = new BannerExample();
		BannerExample.Criteria bc1 = be1.createCriteria();
		be1.setOrderByClause("id desc");
		int bl1Size=8;
		be1.setPageRows(bl1Size);//每页数量
		be1.setStartRow(0);//第一页
		List<Banner> bl1=bannerMapper.selectByExample(be1);
		rs.put("bl1",bl1);
		rs.put("code",1);
		return rs;
	}
}
