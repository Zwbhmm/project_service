package com.project.dao;
import com.project.model.Grs;
import com.project.model.GrsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface GrsMapper {
	long countByExample(GrsExample example);
	int deleteByExample(GrsExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Grs record);
	int insertSelective(Grs record);
	List<Grs> selectByExample(GrsExample example);
	Grs selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Grs record, @Param("example") GrsExample example);
	int updateByExample(@Param("record") Grs record, @Param("example") GrsExample example);
	int updateByPrimaryKeySelective(Grs record);
	int updateByPrimaryKey(Grs record);
}
