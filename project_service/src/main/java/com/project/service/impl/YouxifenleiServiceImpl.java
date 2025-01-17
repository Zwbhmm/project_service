//package com.project.service.impl;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.mapper.Wrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
//
//import com.project.dao.YouxifenleiDao;
//import com.project.model.YouxifenleiEntity;
//import com.project.model.view.YouxifenleiView;
//import com.project.model.vo.YouxifenleiVO;
//import com.project.util.PageUtils;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service("youxifenleiService")
//public class YouxifenleiServiceImpl extends ServiceImpl<YouxifenleiDao, YouxifenleiEntity> implements YouxifenleiService {
//
//
//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        Page<YouxifenleiEntity> page = this.selectPage(
//                new Query<YouxifenleiEntity>(params).getPage(),
//                new EntityWrapper<YouxifenleiEntity>()
//        );
//        return new PageUtils(page);
//    }
//
//    @Override
//	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxifenleiEntity> wrapper) {
//		  Page<YouxifenleiView> page =new Query<YouxifenleiView>(params).getPage();
//	        page.setRecords(baseMapper.selectListView(page,wrapper));
//	    	PageUtils pageUtil = new PageUtils(page);
//	    	return pageUtil;
// 	}
//
//    @Override
//	public List<YouxifenleiVO> selectListVO(Wrapper<YouxifenleiEntity> wrapper) {
// 		return baseMapper.selectListVO(wrapper);
//	}
//
//	@Override
//	public YouxifenleiVO selectVO(Wrapper<YouxifenleiEntity> wrapper) {
// 		return baseMapper.selectVO(wrapper);
//	}
//
//	@Override
//	public List<YouxifenleiView> selectListView(Wrapper<YouxifenleiEntity> wrapper) {
//		return baseMapper.selectListView(wrapper);
//	}
//
//	@Override
//	public YouxifenleiView selectView(Wrapper<YouxifenleiEntity> wrapper) {
//		return baseMapper.selectView(wrapper);
//	}
//
//}
