package com.project.model;

import lombok.Data;

@Data
public class NbaGame {

	private Integer matchId;//ID

	private String bsName;//比赛名
	private String scoreIntro;//比分
	private String bsIntro;//比赛情况
	private String qyData;//球员数据
	private String createTime;//创建时间
	private String fmImg;//封面图
}
