package com.project.dao;
import com.project.model.Qysj;
import com.project.model.QysjExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface QysjMapper {
	long countByExample(QysjExample example);
	int deleteByExample(QysjExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Qysj record);
	int insertSelective(Qysj record);
	List<Qysj> selectByExample(QysjExample example);
	Qysj selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Qysj record, @Param("example") QysjExample example);
	int updateByExample(@Param("record") Qysj record, @Param("example") QysjExample example);
	int updateByPrimaryKeySelective(Qysj record);
	int updateByPrimaryKey(Qysj record);
}
