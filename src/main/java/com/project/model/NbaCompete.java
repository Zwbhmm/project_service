package com.project.model;
public class NbaCompete {
	private Integer id;//ID
	private String bsName;//比赛名
	private String scoreIntro;//比分
	private String bsIntro;//比赛情况
	private String qyData;//球员数据
	private String createTime;//创建时间
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
	public String getScoreIntro(){
		return scoreIntro;
	}
	public void setScoreIntro(String scoreIntro){
		this.scoreIntro = scoreIntro == null ? null : scoreIntro.trim();
	}
	public String getBsIntro(){
		return bsIntro;
	}
	public void setBsIntro(String bsIntro){
		this.bsIntro = bsIntro == null ? null : bsIntro.trim();
	}
	public String getQyData(){
		return qyData;
	}
	public void setQyData(String qyData){
		this.qyData = qyData == null ? null : qyData.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public String getFmImg(){
		return fmImg;
	}
	public void setFmImg(String fmImg){
		this.fmImg = fmImg == null ? null : fmImg.trim();
	}
}
