package com.project.model;
import java.util.ArrayList;
import java.util.List;
public class BsjgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public BsjgExample() {
		oredCriteria = new ArrayList<>();
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public boolean isDistinct() {
		return distinct;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
	}
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}
		public boolean isValid() {
			return criteria.size() > 0;
		}
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		public List<Criterion> getCriteria() {
			return criteria;
		}
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}
		public Criteria andIdIsNotNull(){
			addCriterion("id is not null");
			return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "Id");
			return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andTeamNameIsNull() {
			addCriterion("team_name is null");
			return (Criteria) this;
		}
		public Criteria andTeamNameIsNotNull(){
			addCriterion("team_name is not null");
			return (Criteria) this;
		}
		public Criteria andTeamNameEqualTo(String value) {
			addCriterion("team_name =", value, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameNotEqualTo(String value) {
			addCriterion("team_name <>", value, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameGreaterThan(String value) {
			addCriterion("team_name >", value, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
			addCriterion("team_name >=", value, "TeamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameLessThan(String value) {
			addCriterion("team_name <", value, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameLessThanOrEqualTo(String value) {
			addCriterion("team_name <=", value, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameIn(List<String> values) {
			addCriterion("team_name in", values, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameNotIn(List<String> values) {
			addCriterion("team_name not in", values, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameBetween(String value1, String value2) {
			addCriterion("team_name between", value1, value2, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameNotBetween(String value1, String value2) {
			addCriterion("team_name not between", value1, value2, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameLike(String value) {
			addCriterion("team_name like", value, "teamName");
			return (Criteria) this;
		}
		public Criteria andTeamNameNotLike(String value) {
			addCriterion("team_name not like", value, "teamName");
			return (Criteria) this;
		}
		public Criteria andDfScoreIsNull() {
			addCriterion("df_score is null");
			return (Criteria) this;
		}
		public Criteria andDfScoreIsNotNull(){
			addCriterion("df_score is not null");
			return (Criteria) this;
		}
		public Criteria andDfScoreEqualTo(Integer value) {
			addCriterion("df_score =", value, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreNotEqualTo(Integer value) {
			addCriterion("df_score <>", value, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreGreaterThan(Integer value) {
			addCriterion("df_score >", value, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("df_score >=", value, "DfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreLessThan(Integer value) {
			addCriterion("df_score <", value, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreLessThanOrEqualTo(Integer value) {
			addCriterion("df_score <=", value, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreIn(List<Integer> values) {
			addCriterion("df_score in", values, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreNotIn(List<Integer> values) {
			addCriterion("df_score not in", values, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreBetween(Integer value1, Integer value2) {
			addCriterion("df_score between", value1, value2, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("df_score not between", value1, value2, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreLike(Integer value) {
			addCriterion("df_score like", value, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfScoreNotLike(Integer value) {
			addCriterion("df_score not like", value, "dfScore");
			return (Criteria) this;
		}
		public Criteria andDfqyIsNull() {
			addCriterion("dfqy is null");
			return (Criteria) this;
		}
		public Criteria andDfqyIsNotNull(){
			addCriterion("dfqy is not null");
			return (Criteria) this;
		}
		public Criteria andDfqyEqualTo(String value) {
			addCriterion("dfqy =", value, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyNotEqualTo(String value) {
			addCriterion("dfqy <>", value, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyGreaterThan(String value) {
			addCriterion("dfqy >", value, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyGreaterThanOrEqualTo(String value) {
			addCriterion("dfqy >=", value, "Dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyLessThan(String value) {
			addCriterion("dfqy <", value, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyLessThanOrEqualTo(String value) {
			addCriterion("dfqy <=", value, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyIn(List<String> values) {
			addCriterion("dfqy in", values, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyNotIn(List<String> values) {
			addCriterion("dfqy not in", values, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyBetween(String value1, String value2) {
			addCriterion("dfqy between", value1, value2, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyNotBetween(String value1, String value2) {
			addCriterion("dfqy not between", value1, value2, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyLike(String value) {
			addCriterion("dfqy like", value, "dfqy");
			return (Criteria) this;
		}
		public Criteria andDfqyNotLike(String value) {
			addCriterion("dfqy not like", value, "dfqy");
			return (Criteria) this;
		}
		public Criteria andZgqyIsNull() {
			addCriterion("zgqy is null");
			return (Criteria) this;
		}
		public Criteria andZgqyIsNotNull(){
			addCriterion("zgqy is not null");
			return (Criteria) this;
		}
		public Criteria andZgqyEqualTo(String value) {
			addCriterion("zgqy =", value, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyNotEqualTo(String value) {
			addCriterion("zgqy <>", value, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyGreaterThan(String value) {
			addCriterion("zgqy >", value, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyGreaterThanOrEqualTo(String value) {
			addCriterion("zgqy >=", value, "Zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyLessThan(String value) {
			addCriterion("zgqy <", value, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyLessThanOrEqualTo(String value) {
			addCriterion("zgqy <=", value, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyIn(List<String> values) {
			addCriterion("zgqy in", values, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyNotIn(List<String> values) {
			addCriterion("zgqy not in", values, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyBetween(String value1, String value2) {
			addCriterion("zgqy between", value1, value2, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyNotBetween(String value1, String value2) {
			addCriterion("zgqy not between", value1, value2, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyLike(String value) {
			addCriterion("zgqy like", value, "zgqy");
			return (Criteria) this;
		}
		public Criteria andZgqyNotLike(String value) {
			addCriterion("zgqy not like", value, "zgqy");
			return (Criteria) this;
		}
		public Criteria andGrsidIsNull() {
			addCriterion("grsid is null");
			return (Criteria) this;
		}
		public Criteria andGrsidIsNotNull(){
			addCriterion("grsid is not null");
			return (Criteria) this;
		}
		public Criteria andGrsidEqualTo(Integer value) {
			addCriterion("grsid =", value, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidNotEqualTo(Integer value) {
			addCriterion("grsid <>", value, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidGreaterThan(Integer value) {
			addCriterion("grsid >", value, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidGreaterThanOrEqualTo(Integer value) {
			addCriterion("grsid >=", value, "Grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidLessThan(Integer value) {
			addCriterion("grsid <", value, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidLessThanOrEqualTo(Integer value) {
			addCriterion("grsid <=", value, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidIn(List<Integer> values) {
			addCriterion("grsid in", values, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidNotIn(List<Integer> values) {
			addCriterion("grsid not in", values, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidBetween(Integer value1, Integer value2) {
			addCriterion("grsid between", value1, value2, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidNotBetween(Integer value1, Integer value2) {
			addCriterion("grsid not between", value1, value2, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidLike(Integer value) {
			addCriterion("grsid like", value, "grsid");
			return (Criteria) this;
		}
		public Criteria andGrsidNotLike(Integer value) {
			addCriterion("grsid not like", value, "grsid");
			return (Criteria) this;
		}
	}
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;
		public String getCondition() {
			return condition;
		}
		public Object getValue() {
			return value;
		}
		public Object getSecondValue() {
			return secondValue;
		}
		public boolean isNoValue() {
			return noValue;
		}
		public boolean isSingleValue() {
			return singleValue;
		}
		public boolean isBetweenValue() {
			return betweenValue;
		}
		public boolean isListValue() {
			return listValue;
		}
		public String getTypeHandler() {
			return typeHandler;
		}
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
