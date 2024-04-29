package com.project.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.project.model.ZhoubianshangchengEntity;
import com.project.model.view.ZhoubianshangchengView;
import com.project.model.vo.ZhoubianshangchengVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 周边商城
 *
 * @author
 * @email
 * @date 2020-11-13 11:47:06
 */
public interface ZhoubianshangchengDao extends BaseMapper<ZhoubianshangchengEntity> {

	List<ZhoubianshangchengVO> selectListVO(@Param("ew") Wrapper<ZhoubianshangchengEntity> wrapper);

	ZhoubianshangchengVO selectVO(@Param("ew") Wrapper<ZhoubianshangchengEntity> wrapper);

	List<ZhoubianshangchengView> selectListView(@Param("ew") Wrapper<ZhoubianshangchengEntity> wrapper);

	List<ZhoubianshangchengView> selectListView(Pagination page,@Param("ew") Wrapper<ZhoubianshangchengEntity> wrapper);

	ZhoubianshangchengView selectView(@Param("ew") Wrapper<ZhoubianshangchengEntity> wrapper);

}
