package com.project.model;
public class Nbasc {
	private Integer id;//ID
	private String dzsf;//对阵双方
	private String bsdd;//比赛地点
	private String bsTime;//比赛时间
	private String fbTime;//发布时间
	private String fmImg;//封面图
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getDzsf(){
		return dzsf;
	}
	public void setDzsf(String dzsf){
		this.dzsf = dzsf == null ? null : dzsf.trim();
	}
	public String getBsdd(){
		return bsdd;
	}
	public void setBsdd(String bsdd){
		this.bsdd = bsdd == null ? null : bsdd.trim();
	}
	public String getBsTime(){
		return bsTime;
	}
	public void setBsTime(String bsTime){
		this.bsTime = bsTime == null ? null : bsTime.trim();
	}
	public String getFbTime(){
		return fbTime;
	}
	public void setFbTime(String fbTime){
		this.fbTime = fbTime == null ? null : fbTime.trim();
	}
	public String getFmImg(){
		return fmImg;
	}
	public void setFmImg(String fmImg){
		this.fmImg = fmImg == null ? null : fmImg.trim();
	}
}
