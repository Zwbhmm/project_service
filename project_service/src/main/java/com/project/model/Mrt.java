package com.project.model;
public class Mrt {
	private Integer id;//ID
	private String title;//标题
	private String fmImg;//封面图
	private String detail;//详情
	private String videoUrl;//名人堂视频
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
	public String getFmImg(){
		return fmImg;
	}
	public void setFmImg(String fmImg){
		this.fmImg = fmImg == null ? null : fmImg.trim();
	}
	public String getDetail(){
		return detail;
	}
	public void setDetail(String detail){
		this.detail = detail == null ? null : detail.trim();
	}
	public String getVideoUrl(){
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl == null ? null : videoUrl.trim();
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}
