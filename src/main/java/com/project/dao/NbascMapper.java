package com.project.dao;
import com.project.model.Nbasc;
import com.project.model.NbascExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface NbascMapper {
	long countByExample(NbascExample example);
	int deleteByExample(NbascExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Nbasc record);
	int insertSelective(Nbasc record);
	List<Nbasc> selectByExample(NbascExample example);
	Nbasc selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Nbasc record, @Param("example") NbascExample example);
	int updateByExample(@Param("record") Nbasc record, @Param("example") NbascExample example);
	int updateByPrimaryKeySelective(Nbasc record);
	int updateByPrimaryKey(Nbasc record);
}
