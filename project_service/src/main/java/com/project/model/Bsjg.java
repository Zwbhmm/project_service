package com.project.model;
public class Bsjg {
	private Integer id;//ID
	private String teamName;//得分队伍
	private Integer dfScore;//得分分数
	private String dfqy;//得分球员
	private String zgqy;//助攻球员
	private Integer grsid;//个人赛ID
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTeamName(){
		return teamName;
	}
	public void setTeamName(String teamName){
		this.teamName = teamName == null ? null : teamName.trim();
	}
	public Integer getDfScore(){
		return dfScore;
	}
	public void setDfScore(Integer dfScore){
		this.dfScore = dfScore;
	}
	public String getDfqy(){
		return dfqy;
	}
	public void setDfqy(String dfqy){
		this.dfqy = dfqy == null ? null : dfqy.trim();
	}
	public String getZgqy(){
		return zgqy;
	}
	public void setZgqy(String zgqy){
		this.zgqy = zgqy == null ? null : zgqy.trim();
	}
	public Integer getGrsid(){
		return grsid;
	}
	public void setGrsid(Integer grsid){
		this.grsid = grsid;
	}
}
