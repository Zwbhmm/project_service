package com.project.model;
public class GrsDis {
	private Integer id;//ID
	private String content;//评论内容
	private Integer uid;//用户ID
	private Integer grsid;//个人赛ID
	private String createTime;//创建时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content == null ? null : content.trim();
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public Integer getGrsid(){
		return grsid;
	}
	public void setGrsid(Integer grsid){
		this.grsid = grsid;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
