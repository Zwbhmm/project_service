package com.project.model.vo;

import java.io.Serializable;


/**
 * 游戏分类
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-11-13 11:47:06
 */
public class YouxifenleiVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 游戏厂商
	 */
	
	private String youxichangshang;
				
	
	/**
	 * 设置：游戏厂商
	 */
	 
	public void setYouxichangshang(String youxichangshang) {
		this.youxichangshang = youxichangshang;
	}
	
	/**
	 * 获取：游戏厂商
	 */
	public String getYouxichangshang() {
		return youxichangshang;
	}
			
}
