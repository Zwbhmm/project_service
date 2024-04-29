package com.project.model;
public class Bsdt {
	private Integer id;//ID
	private String title;//标题
	private String fmImg;//封面图
	private String bsTime;//比赛时间
	private String bsdd;//比赛地点
	private String bsdw;//比赛队伍
	private String createDate;//创建日期
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title == null ? null : title.trim();
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
	public String getBsdw(){
		return bsdw;
	}
	public void setBsdw(String bsdw){
		this.bsdw = bsdw == null ? null : bsdw.trim();
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}
