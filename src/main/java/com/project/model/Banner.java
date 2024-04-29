package com.project.model;
public class Banner {
	private Integer id;//ID
	private String banner;//轮播图
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getBanner(){
		return banner;
	}
	public void setBanner(String banner){
		this.banner = banner == null ? null : banner.trim();
	}
}
