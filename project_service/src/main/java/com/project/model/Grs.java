package com.project.model;
public class Grs {
	private Integer id;//ID
	private String bsName;//比赛名称
	private String bsTime;//比赛时间
	private String address;//比赛地点
	private String csdw;//参赛队伍
	private String createDate;//创建日期
	private String fmImg;//封面图
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
	public String getBsTime(){
		return bsTime;
	}
	public void setBsTime(String bsTime){
		this.bsTime = bsTime == null ? null : bsTime.trim();
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address == null ? null : address.trim();
	}
	public String getCsdw(){
		return csdw;
	}
	public void setCsdw(String csdw){
		this.csdw = csdw == null ? null : csdw.trim();
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
	public String getFmImg(){
		return fmImg;
	}
	public void setFmImg(String fmImg){
		this.fmImg = fmImg == null ? null : fmImg.trim();
	}
}
