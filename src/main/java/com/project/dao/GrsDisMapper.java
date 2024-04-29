package com.project.dao;
import com.project.model.GrsDis;
import com.project.model.GrsDisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface GrsDisMapper {
	long countByExample(GrsDisExample example);
	int deleteByExample(GrsDisExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(GrsDis record);
	int insertSelective(GrsDis record);
	List<GrsDis> selectByExample(GrsDisExample example);
	GrsDis selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") GrsDis record, @Param("example") GrsDisExample example);
	int updateByExample(@Param("record") GrsDis record, @Param("example") GrsDisExample example);
	int updateByPrimaryKeySelective(GrsDis record);
	int updateByPrimaryKey(GrsDis record);
}
