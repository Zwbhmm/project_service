package com.project.model;
public class PraiseLog {
	private Integer id;//ID
	private Integer uid;//用户ID
	private Integer jid;//视频ID
	private String createTime;//点赞时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public Integer getJid(){
		return jid;
	}
	public void setJid(Integer jid){
		this.jid = jid;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
