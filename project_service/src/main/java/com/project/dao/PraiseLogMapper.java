package com.project.dao;
import com.project.model.PraiseLog;
import com.project.model.PraiseLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface PraiseLogMapper {
	long countByExample(PraiseLogExample example);
	int deleteByExample(PraiseLogExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(PraiseLog record);
	int insertSelective(PraiseLog record);
	List<PraiseLog> selectByExample(PraiseLogExample example);
	PraiseLog selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") PraiseLog record, @Param("example") PraiseLogExample example);
	int updateByExample(@Param("record") PraiseLog record, @Param("example") PraiseLogExample example);
	int updateByPrimaryKeySelective(PraiseLog record);
	int updateByPrimaryKey(PraiseLog record);
}
