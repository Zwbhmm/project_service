package com.project.model;
public class JdVideo {
	private Integer id;//ID
	private String title;//标题
	private String fmImg;//封面图
	private String veoUrl;//视频链接
	private String veoIntro;//视频介绍
	private Integer userId;//用户ID
	private String createDate;//创建日期
	private Integer praiseNum;//点赞数
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
	public String getVeoUrl(){
		return veoUrl;
	}
	public void setVeoUrl(String veoUrl){
		this.veoUrl = veoUrl == null ? null : veoUrl.trim();
	}
	public String getVeoIntro(){
		return veoIntro;
	}
	public void setVeoIntro(String veoIntro){
		this.veoIntro = veoIntro == null ? null : veoIntro.trim();
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
	public Integer getPraiseNum(){
		return praiseNum;
	}
	public void setPraiseNum(Integer praiseNum){
		this.praiseNum = praiseNum;
	}
}
