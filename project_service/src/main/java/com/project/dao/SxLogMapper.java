package com.project.dao;
import com.project.model.SxLog;
import com.project.model.SxLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface SxLogMapper {
	long countByExample(SxLogExample example);
	int deleteByExample(SxLogExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(SxLog record);
	int insertSelective(SxLog record);
	List<SxLog> selectByExample(SxLogExample example);
	SxLog selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") SxLog record, @Param("example") SxLogExample example);
	int updateByExample(@Param("record") SxLog record, @Param("example") SxLogExample example);
	int updateByPrimaryKeySelective(SxLog record);
	int updateByPrimaryKey(SxLog record);
}
