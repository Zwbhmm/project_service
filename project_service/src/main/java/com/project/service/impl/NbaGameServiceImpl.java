package com.project.service.impl;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.project.controller.LoginModel;
import com.project.model.NbaGame;
import com.project.service.NbaGameService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class NbaGameServiceImpl extends ServiceImpl<NbaGameMapper, NbaGame> implements NbaGameService{
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public String add(NbaGame model, LoginModel login) {
//
//        if(model.getBsName()==null||model.getBsName().equals("")){
//            return "比赛名为必填属性";
//        }
//        if(model.getFmImg()==null||model.getFmImg().equals("")){
//            return "封面图为必填属性";
//        }
//        if(model.getFmImg()!=null){
//            String [] fileSplit = model.getFmImg().split(";");
//            if(fileSplit.length>1){
//                return "封面图的图片数量不能大于1";
//            }
//        }
//        if(model.getScoreIntro()==null||model.getScoreIntro().equals("")){
//            return "比分为必填属性";
//        }
//        if(model.getBsIntro()==null||model.getBsIntro().equals("")){
//            return "比赛情况为必填属性";
//        }
//        if(model.getQyData()==null||model.getQyData().equals("")){
//            return "球员数据为必填属性";
//        }
//        model.setCreateTime(sdf1.format(new Date()));//当前时间格式
//        this.save(model);
        return "";
    }

    @Override
    public String update(NbaGame model, LoginModel login) {
//        NbaGame preModel = this.getById(model.getMatchId());
//        if(model.getBsName()==null||model.getBsName().equals("")){
//            return "比赛名为必填属性";
//        }
//        if(model.getFmImg()==null||model.getFmImg().equals("")){
//            return "封面图为必填属性";
//        }
//        if(model.getFmImg()!=null){
//            String [] fileSplit = model.getFmImg().split(";");
//            if(fileSplit.length>1){
//                return "封面图的图片数量不能大于1";
//            }
//        }
//        if(model.getScoreIntro()==null||model.getScoreIntro().equals("")){
//            return "比分为必填属性";
//        }
//        if(model.getBsIntro()==null||model.getBsIntro().equals("")){
//            return "比赛情况为必填属性";
//        }
//        if(model.getQyData()==null||model.getQyData().equals("")){
//            return "球员数据为必填属性";
//        }
//        preModel.setBsName(model.getBsName());
//        preModel.setFmImg(model.getFmImg());
//        preModel.setScoreIntro(model.getScoreIntro());
//        preModel.setBsIntro(model.getBsIntro());
//        preModel.setQyData(model.getQyData());
//        this.updateById(preModel);
//        nbaCompeteMapper.updateByPrimaryKey(preModel);//更新数据
        return "";
    }
    /**
     *根据参数查询NBA比赛列表总数
     */
    @Override
    public Map<String, Integer> getDataListCount(NbaGame queryModel, Integer pageSize, LoginModel login) {
//        LambdaQueryWrapper<NbaGame> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(queryModel.getMatchId()!=null,NbaGame::getMatchId,queryModel.getMatchId());
//        lambdaQueryWrapper.like(queryModel.getBsName()!=null,NbaGame::getBsName,queryModel.getBsName());
//        int count = this.count(lambdaQueryWrapper);



//        NbaCompeteExample se = new NbaCompeteExample();
//        NbaCompeteExample.Criteria sc = se.createCriteria();
//        se.setOrderByClause("id desc");//默认按照id倒序排序
//        if(queryModel.getMatchId()!=null){
//            sc.andIdEqualTo(queryModel.getMatchId());
//        }
//        if(queryModel.getBsName()!=null&&queryModel.getBsName().equals("")==false){
//            sc.andBsNameLike("%"+queryModel.getBsName()+"%");//模糊查询
//        }
//
//        int count = (int)nbaCompeteMapper.countByExample(se);
//        int totalPage = 0;
//        if ((count > 0) && ((count % pageSize) == 0)) {
//            totalPage = count / pageSize;
//        } else {
//            totalPage = (count / pageSize) + 1;
//        }
//        Map<String,Integer> rs = new HashMap<String,Integer>();
//        rs.put("count",count);//数据总数
//        rs.put("totalPage",totalPage);//总页数
        return null;
    }
    /**
     *根据参数查询NBA比赛列表数据
     */
    @Override
    public Map<String, Object> getDataList(NbaGame queryModel, Integer page, Integer pageSize, LoginModel login) {
//        LambdaQueryWrapper<NbaGame> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(queryModel.getMatchId()!=null,NbaGame::getMatchId,queryModel.getMatchId())
//                .like(queryModel.getBsName()!=null,NbaGame::getBsName,queryModel.getBsName())
//                .last("limit "+page+" , "+pageSize);
//       //todo
//        List<NbaGame> list = this.list(lambdaQueryWrapper);


//
//        NbaCompeteExample se = new NbaCompeteExample();
//        NbaCompeteExample.Criteria sc = se.createCriteria();
//        se.setOrderByClause("id desc");//默认按照id倒序排序
//        if(queryModel.getId()!=null){
//            sc.andIdEqualTo(queryModel.getId());
//        }
//        if(queryModel.getBsName()!=null&&queryModel.getBsName().equals("")==false){
//            sc.andBsNameLike("%"+queryModel.getBsName()+"%");//模糊查询
//        }
//        if(page!=null&&pageSize!=null){
//            se.setPageRows(pageSize);
//            se.setStartRow((page-1)*pageSize);
//        }
       // List<NbaCompete> list = nbaCompeteMapper.selectByExample(se);//执行查询语句
//        Map<String,Object> rs = new HashMap<String,Object>();
//        List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
//        for(NbaGame model:list){
//            list2.add(getNbaCompeteModel(model,login));
//        }
//        rs.put("list",list2);//数据列表
        return null;
    }
    /**
     封装NBA比赛为前台展示的数据形式
     */
    @Override
    public Map<String, Object> getNbaCompeteModel(NbaGame model, LoginModel login) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("nbaGame",model);
        List<String> fmImgList = new ArrayList<String>();
        if(model.getFmImg()!=null){
            String [] fmImgSplit = model.getFmImg().split(";");
            for(String tmpstr:fmImgSplit ){
                if(tmpstr.equals("")==false){
                    fmImgList.add(tmpstr);
                }
            }
        }
        map.put("fmImgList",fmImgList);
        return map;
    }

    @Override
    public void delete(Integer id) {
       this.delete(id);
    }
}
