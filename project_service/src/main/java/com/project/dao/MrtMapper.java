package com.project.dao;
import com.project.model.Mrt;
import com.project.model.MrtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface MrtMapper {
	long countByExample(MrtExample example);
	int deleteByExample(MrtExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Mrt record);
	int insertSelective(Mrt record);
	List<Mrt> selectByExample(MrtExample example);
	Mrt selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Mrt record, @Param("example") MrtExample example);
	int updateByExample(@Param("record") Mrt record, @Param("example") MrtExample example);
	int updateByPrimaryKeySelective(Mrt record);
	int updateByPrimaryKey(Mrt record);
}
