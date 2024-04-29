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
@RequestMapping("index/jd_detail")
public class IndexJdDetailController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	@Autowired
	JdVideoMapper jdVideoMapper;
	@Autowired
	VeoDisMapper veoDisMapper;
	@Autowired
	PraiseLogMapper praiseLogMapper;
	@Autowired
	UserMapper userMapper;
	//经典视频详情
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(ModelMap modelMap,Integer id, HttpServletRequest request) {
		Map<String,Object> rs = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		JdVideo jdVideo = jdVideoMapper.selectByPrimaryKey(id);//查询经典视频
		if(jdVideo==null){
			jdVideo = new JdVideo();
		}
		Map<String,Object> dataDetail = new HashMap<String,Object>();
		dataDetail.put("model",jdVideo);
		//将多张图片以list形式返回给前端
		List<String> fmImgList = new ArrayList<String>();
		if(jdVideo.getFmImg()!=null&&jdVideo.getFmImg().trim().equals("")==false){
			String [] fmImgSplit = jdVideo.getFmImg().split(";");
			for(String fmImgStr:fmImgSplit){
				if(fmImgStr.trim().equals("")==false){
					fmImgList.add(fmImgStr);
				}
			}
		}
		dataDetail.put("fmImgList",fmImgList);
		//将多张图片以list形式返回给前端
		List<String> veoUrlList = new ArrayList<String>();
		if(jdVideo.getVeoUrl()!=null&&jdVideo.getVeoUrl().trim().equals("")==false){
			String [] veoUrlSplit = jdVideo.getVeoUrl().split(";");
			for(String veoUrlStr:veoUrlSplit){
				if(veoUrlStr.trim().equals("")==false){
					veoUrlList.add(veoUrlStr);
				}
			}
		}
		dataDetail.put("veoUrlList",veoUrlList);
		//解释用户ID
		User userIdT = userMapper.selectByPrimaryKey(jdVideo.getUserId());
		if(userIdT==null){
			userIdT = new User();
		}
		dataDetail.put("userIdT",userIdT);
		rs.put("jdVideoDetail",dataDetail);
		Integer isPraise=0;//是否有点赞
		if(login!=null&&login.getLoginType()==2){//判断是否已登录
			PraiseLogExample praiseLogE = new  PraiseLogExample();
			PraiseLogExample.Criteria praiseLogC =praiseLogE.createCriteria();
			praiseLogC.andUidEqualTo(login.getId());//praise_log.uid=当前登录id
			praiseLogC.andJidEqualTo(jdVideo.getId());
			int praiseLogCount = (int)praiseLogMapper.countByExample(praiseLogE);
			if(praiseLogCount>0){
				isPraise=1;
			}
		}
		rs.put("isPraise", isPraise);
		rs.put("code",1);
		return rs;
	}
	//提交视频点赞接口
	@RequestMapping("submitPraise")
	@ResponseBody
	public Object submitPraise(HttpServletRequest request,Integer id){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//当前登录人信息
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		PraiseLogExample praiseLogE = new  PraiseLogExample();
		PraiseLogExample.Criteria praiseLogC =praiseLogE.createCriteria();
		praiseLogC.andUidEqualTo(login.getId());
		praiseLogC.andJidEqualTo(id);
		int praiseLogCount = (int)praiseLogMapper.countByExample(praiseLogE);
		if(praiseLogCount>0){//已点赞，要取消点赞
			praiseLogMapper.deleteByExample(praiseLogE);
			//更新统计经典视频表中的点赞数字段
			PraiseLogExample praiseLogE2 = new  PraiseLogExample();
			PraiseLogExample.Criteria praiseLogC2 =praiseLogE2.createCriteria();
			praiseLogC2.andJidEqualTo(id);
			int praiseLogCount2 = (int)praiseLogMapper.countByExample(praiseLogE2);
			JdVideo jdVideo = jdVideoMapper.selectByPrimaryKey(id);
			jdVideo.setPraiseNum(praiseLogCount2);
			jdVideoMapper.updateByPrimaryKeySelective(jdVideo);
			rs.put("code",1);
			rs.put("msg","取消点赞成功");
			return rs;
		}else{
			//没点赞，需要新建点赞并插入数据库
			PraiseLog praiseLog = new PraiseLog();
			praiseLog.setUid(login.getId());//登录id
			praiseLog.setCreateTime(sdf1.format(new Date()));//当前时间格式
			praiseLog.setJid(id);
			praiseLogMapper.insertSelective(praiseLog );
			//更新统计经典视频表中的点赞数字段
			PraiseLogExample praiseLogE2 = new  PraiseLogExample();
			PraiseLogExample.Criteria praiseLogC2 =praiseLogE2.createCriteria();
			praiseLogC2.andJidEqualTo(id);
			int praiseLogCount2 = (int)praiseLogMapper.countByExample(praiseLogE2);
			JdVideo jdVideo = jdVideoMapper.selectByPrimaryKey(id);
			jdVideo.setPraiseNum(praiseLogCount2);
			jdVideoMapper.updateByPrimaryKeySelective(jdVideo);
			rs.put("code",1);
			rs.put("msg","点赞成功");
			return rs;
		}
	}
	//分页查询视频评论列表接口
	@RequestMapping("getVeoDis")
	@ResponseBody
	public Object getVeoDis(HttpServletRequest request,Integer page,Integer id){
		Map<String,Object> rs  = new HashMap<String,Object>();
		Integer pageSize=10;
		VeoDisExample te = new VeoDisExample();
		VeoDisExample.Criteria tc = te.createCriteria();
		tc.andJidEqualTo(id);
		te.setOrderByClause("id desc");
		int count = (int)veoDisMapper.countByExample(te);
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
		List<VeoDis> tl = veoDisMapper.selectByExample(te);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(VeoDis t:tl){
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
	//提交视频评论接口
	@RequestMapping("submitVeoDis")
	@ResponseBody
	public Object submitVeoDis(HttpServletRequest request,Integer id,String ccontent){
		Map<String,Object> rs  = new HashMap<String,Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		if(login==null||login.getLoginType()!=2){
			rs.put("code",0);
			rs.put("msg","尚未登录");
			return rs;
		}
		if(ccontent==null||ccontent.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入视频评论内容");
			return rs;
		}
		VeoDis veoDis = new VeoDis();
		veoDis.setContent(ccontent);
		veoDis.setJid(id);//经典视频id
		veoDis.setUid(login.getId());//登录id
		veoDis.setCreateTime(sdf1.format(new Date()));//当前时间格式
		veoDisMapper.insertSelective(veoDis);
		rs.put("code",1);
		rs.put("msg","视频评论成功");
		return rs;
	}
}
