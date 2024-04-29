package com.project.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.project.model.NbaGame;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NbaGameMapper extends BaseMapper<NbaGame> {
}
