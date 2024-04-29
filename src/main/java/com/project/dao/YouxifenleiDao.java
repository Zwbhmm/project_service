package com.project.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.project.model.YouxifenleiEntity;
import com.project.model.view.YouxifenleiView;
import com.project.model.vo.YouxifenleiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 游戏分类
 *
 * @author
 * @email
 * @date 2020-11-13 11:47:06
 */
public interface YouxifenleiDao extends BaseMapper<YouxifenleiEntity> {

	List<YouxifenleiVO> selectListVO(@Param("ew") Wrapper<YouxifenleiEntity> wrapper);

	YouxifenleiVO selectVO(@Param("ew") Wrapper<YouxifenleiEntity> wrapper);

	List<YouxifenleiView> selectListView(@Param("ew") Wrapper<YouxifenleiEntity> wrapper);

	List<YouxifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<YouxifenleiEntity> wrapper);

	YouxifenleiView selectView(@Param("ew") Wrapper<YouxifenleiEntity> wrapper);

}
