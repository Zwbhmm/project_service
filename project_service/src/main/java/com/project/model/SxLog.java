package com.project.model;
public class SxLog {
	private Integer id;//ID
	private String content;//聊天内容
	private Integer isRead;//是否已读
	private Integer type;//类型
	private Integer uid;//用户ID
	private Integer uid1;//用户ID
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
	public Integer getIsRead(){
		return isRead;
	}
	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}
	public Integer getType(){
		return type;
	}
	public void setType(Integer type){
		this.type = type;
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public Integer getUid1(){
		return uid1;
	}
	public void setUid1(Integer uid1){
		this.uid1 = uid1;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
