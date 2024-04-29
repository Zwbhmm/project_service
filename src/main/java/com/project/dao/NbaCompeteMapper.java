package com.project.dao;
import com.project.model.NbaCompete;
import com.project.model.NbaCompeteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface NbaCompeteMapper {
	long countByExample(NbaCompeteExample example);
	int deleteByExample(NbaCompeteExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(NbaCompete record);
	int insertSelective(NbaCompete record);
	List<NbaCompete> selectByExample(NbaCompeteExample example);
	NbaCompete selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") NbaCompete record, @Param("example") NbaCompeteExample example);
	int updateByExample(@Param("record") NbaCompete record, @Param("example") NbaCompeteExample example);
	int updateByPrimaryKeySelective(NbaCompete record);
	int updateByPrimaryKey(NbaCompete record);
}
