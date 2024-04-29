package com.project.dao;
import com.project.model.VeoDis;
import com.project.model.VeoDisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface VeoDisMapper {
	long countByExample(VeoDisExample example);
	int deleteByExample(VeoDisExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(VeoDis record);
	int insertSelective(VeoDis record);
	List<VeoDis> selectByExample(VeoDisExample example);
	VeoDis selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") VeoDis record, @Param("example") VeoDisExample example);
	int updateByExample(@Param("record") VeoDis record, @Param("example") VeoDisExample example);
	int updateByPrimaryKeySelective(VeoDis record);
	int updateByPrimaryKey(VeoDis record);
}
