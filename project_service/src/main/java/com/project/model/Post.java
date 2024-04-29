package com.project.model;
public class Post {
	private Integer id;//ID
	private String title;//标题
	private String postContent;//帖子内容
	private Integer userId;//用户ID
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
	public String getPostContent(){
		return postContent;
	}
	public void setPostContent(String postContent){
		this.postContent = postContent == null ? null : postContent.trim();
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}
