package com.project.dao;
import com.project.model.PostDis;
import com.project.model.PostDisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface PostDisMapper {
	long countByExample(PostDisExample example);
	int deleteByExample(PostDisExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(PostDis record);
	int insertSelective(PostDis record);
	List<PostDis> selectByExample(PostDisExample example);
	PostDis selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") PostDis record, @Param("example") PostDisExample example);
	int updateByExample(@Param("record") PostDis record, @Param("example") PostDisExample example);
	int updateByPrimaryKeySelective(PostDis record);
	int updateByPrimaryKey(PostDis record);
}
