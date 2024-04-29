package com.project.dao;
import com.project.model.GrsApp;
import com.project.model.GrsAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface GrsAppMapper {
	long countByExample(GrsAppExample example);
	int deleteByExample(GrsAppExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(GrsApp record);
	int insertSelective(GrsApp record);
	List<GrsApp> selectByExample(GrsAppExample example);
	GrsApp selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") GrsApp record, @Param("example") GrsAppExample example);
	int updateByExample(@Param("record") GrsApp record, @Param("example") GrsAppExample example);
	int updateByPrimaryKeySelective(GrsApp record);
	int updateByPrimaryKey(GrsApp record);
}
