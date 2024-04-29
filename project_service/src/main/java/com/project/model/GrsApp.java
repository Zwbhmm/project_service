package com.project.model;
public class GrsApp {
	private Integer id;//ID
	private String bsName;//比赛名
	private String fmImg;//封面图
	private String bsTime;//比赛时间
	private String bsdd;//比赛地点
	private String bsIntro;//比赛介绍
	private Integer checkStatus;//审核状态
	private String checkRemark;//审核备注
	private Integer userId;//用户ID
	private String createDate;//创建日期
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getBsName(){
		return bsName;
	}
	public void setBsName(String bsName){
		this.bsName = bsName == null ? null : bsName.trim();
	}
	public String getFmImg(){
		return fmImg;
	}
	public void setFmImg(String fmImg){
		this.fmImg = fmImg == null ? null : fmImg.trim();
	}
	public String getBsTime(){
		return bsTime;
	}
	public void setBsTime(String bsTime){
		this.bsTime = bsTime == null ? null : bsTime.trim();
	}
	public String getBsdd(){
		return bsdd;
	}
	public void setBsdd(String bsdd){
		this.bsdd = bsdd == null ? null : bsdd.trim();
	}
	public String getBsIntro(){
		return bsIntro;
	}
	public void setBsIntro(String bsIntro){
		this.bsIntro = bsIntro == null ? null : bsIntro.trim();
	}
	public Integer getCheckStatus(){
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus){
		this.checkStatus = checkStatus;
	}
	public String getCheckRemark(){
		return checkRemark;
	}
	public void setCheckRemark(String checkRemark){
		this.checkRemark = checkRemark == null ? null : checkRemark.trim();
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}
