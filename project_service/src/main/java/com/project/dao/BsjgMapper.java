package com.project.dao;
import com.project.model.Bsjg;
import com.project.model.BsjgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface BsjgMapper {
	long countByExample(BsjgExample example);
	int deleteByExample(BsjgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Bsjg record);
	int insertSelective(Bsjg record);
	List<Bsjg> selectByExample(BsjgExample example);
	Bsjg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Bsjg record, @Param("example") BsjgExample example);
	int updateByExample(@Param("record") Bsjg record, @Param("example") BsjgExample example);
	int updateByPrimaryKeySelective(Bsjg record);
	int updateByPrimaryKey(Bsjg record);
}
