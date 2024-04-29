package com.project.dao;
import com.project.model.TeamMsg;
import com.project.model.TeamMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface TeamMsgMapper {
	long countByExample(TeamMsgExample example);
	int deleteByExample(TeamMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(TeamMsg record);
	int insertSelective(TeamMsg record);
	List<TeamMsg> selectByExample(TeamMsgExample example);
	TeamMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") TeamMsg record, @Param("example") TeamMsgExample example);
	int updateByExample(@Param("record") TeamMsg record, @Param("example") TeamMsgExample example);
	int updateByPrimaryKeySelective(TeamMsg record);
	int updateByPrimaryKey(TeamMsg record);
}
