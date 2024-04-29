package com.project.model;
public class Qysj {
	private Integer id;//ID
	private String qyName;//球员名
	private String qyIntro;//球员介绍
	private String qyImg;//照片
	private String qyScore;//球员成绩
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getQyName(){
		return qyName;
	}
	public void setQyName(String qyName){
		this.qyName = qyName == null ? null : qyName.trim();
	}
	public String getQyIntro(){
		return qyIntro;
	}
	public void setQyIntro(String qyIntro){
		this.qyIntro = qyIntro == null ? null : qyIntro.trim();
	}
	public String getQyImg(){
		return qyImg;
	}
	public void setQyImg(String qyImg){
		this.qyImg = qyImg == null ? null : qyImg.trim();
	}
	public String getQyScore(){
		return qyScore;
	}
	public void setQyScore(String qyScore){
		this.qyScore = qyScore == null ? null : qyScore.trim();
	}
}
