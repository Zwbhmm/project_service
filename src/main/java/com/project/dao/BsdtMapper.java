package com.project.dao;
import com.project.model.Bsdt;
import com.project.model.BsdtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface BsdtMapper {
	long countByExample(BsdtExample example);
	int deleteByExample(BsdtExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Bsdt record);
	int insertSelective(Bsdt record);
	List<Bsdt> selectByExample(BsdtExample example);
	Bsdt selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Bsdt record, @Param("example") BsdtExample example);
	int updateByExample(@Param("record") Bsdt record, @Param("example") BsdtExample example);
	int updateByPrimaryKeySelective(Bsdt record);
	int updateByPrimaryKey(Bsdt record);
}
