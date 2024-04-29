package com.project.dao;
import com.project.model.JdVideo;
import com.project.model.JdVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface JdVideoMapper {
	long countByExample(JdVideoExample example);
	int deleteByExample(JdVideoExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(JdVideo record);
	int insertSelective(JdVideo record);
	List<JdVideo> selectByExample(JdVideoExample example);
	JdVideo selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") JdVideo record, @Param("example") JdVideoExample example);
	int updateByExample(@Param("record") JdVideo record, @Param("example") JdVideoExample example);
	int updateByPrimaryKeySelective(JdVideo record);
	int updateByPrimaryKey(JdVideo record);
}
