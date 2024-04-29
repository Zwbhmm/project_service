package com.project.service;

import com.baomidou.mybatisplus.service.IService;
import com.project.controller.LoginModel;
import com.project.model.NbaGame;


import java.util.Map;

public interface NbaGameService extends IService<NbaGame> {

     String add(NbaGame model, LoginModel login);
     String update(NbaGame model,LoginModel login);
     Map<String,Integer> getDataListCount(NbaGame queryModel, Integer pageSize, LoginModel login);
     Map<String,Object> getDataList(NbaGame queryModel,Integer page,Integer pageSize,LoginModel login);
     Map<String,Object> getNbaCompeteModel(NbaGame model,LoginModel login);
     void delete(Integer id);
}
