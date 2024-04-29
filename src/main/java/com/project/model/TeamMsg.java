package com.project.model;
public class TeamMsg {
	private Integer id;//ID
	private String dwName;//队伍名
	private String dwLogo;//队徽
	private String dwIntro;//队伍介绍
	private Integer userId;//用户ID
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getDwName(){
		return dwName;
	}
	public void setDwName(String dwName){
		this.dwName = dwName == null ? null : dwName.trim();
	}
	public String getDwLogo(){
		return dwLogo;
	}
	public void setDwLogo(String dwLogo){
		this.dwLogo = dwLogo == null ? null : dwLogo.trim();
	}
	public String getDwIntro(){
		return dwIntro;
	}
	public void setDwIntro(String dwIntro){
		this.dwIntro = dwIntro == null ? null : dwIntro.trim();
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
}
