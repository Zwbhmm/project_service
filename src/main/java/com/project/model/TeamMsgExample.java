package com.project.model;
import java.util.ArrayList;
import java.util.List;
public class TeamMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public TeamMsgExample() {
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
		public Criteria andDwNameIsNull() {
			addCriterion("dw_name is null");
			return (Criteria) this;
		}
		public Criteria andDwNameIsNotNull(){
			addCriterion("dw_name is not null");
			return (Criteria) this;
		}
		public Criteria andDwNameEqualTo(String value) {
			addCriterion("dw_name =", value, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameNotEqualTo(String value) {
			addCriterion("dw_name <>", value, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameGreaterThan(String value) {
			addCriterion("dw_name >", value, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameGreaterThanOrEqualTo(String value) {
			addCriterion("dw_name >=", value, "DwName");
			return (Criteria) this;
		}
		public Criteria andDwNameLessThan(String value) {
			addCriterion("dw_name <", value, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameLessThanOrEqualTo(String value) {
			addCriterion("dw_name <=", value, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameIn(List<String> values) {
			addCriterion("dw_name in", values, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameNotIn(List<String> values) {
			addCriterion("dw_name not in", values, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameBetween(String value1, String value2) {
			addCriterion("dw_name between", value1, value2, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameNotBetween(String value1, String value2) {
			addCriterion("dw_name not between", value1, value2, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameLike(String value) {
			addCriterion("dw_name like", value, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwNameNotLike(String value) {
			addCriterion("dw_name not like", value, "dwName");
			return (Criteria) this;
		}
		public Criteria andDwLogoIsNull() {
			addCriterion("dw_logo is null");
			return (Criteria) this;
		}
		public Criteria andDwLogoIsNotNull(){
			addCriterion("dw_logo is not null");
			return (Criteria) this;
		}
		public Criteria andDwLogoEqualTo(String value) {
			addCriterion("dw_logo =", value, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoNotEqualTo(String value) {
			addCriterion("dw_logo <>", value, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoGreaterThan(String value) {
			addCriterion("dw_logo >", value, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoGreaterThanOrEqualTo(String value) {
			addCriterion("dw_logo >=", value, "DwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoLessThan(String value) {
			addCriterion("dw_logo <", value, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoLessThanOrEqualTo(String value) {
			addCriterion("dw_logo <=", value, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoIn(List<String> values) {
			addCriterion("dw_logo in", values, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoNotIn(List<String> values) {
			addCriterion("dw_logo not in", values, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoBetween(String value1, String value2) {
			addCriterion("dw_logo between", value1, value2, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoNotBetween(String value1, String value2) {
			addCriterion("dw_logo not between", value1, value2, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoLike(String value) {
			addCriterion("dw_logo like", value, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwLogoNotLike(String value) {
			addCriterion("dw_logo not like", value, "dwLogo");
			return (Criteria) this;
		}
		public Criteria andDwIntroIsNull() {
			addCriterion("dw_intro is null");
			return (Criteria) this;
		}
		public Criteria andDwIntroIsNotNull(){
			addCriterion("dw_intro is not null");
			return (Criteria) this;
		}
		public Criteria andDwIntroEqualTo(String value) {
			addCriterion("dw_intro =", value, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroNotEqualTo(String value) {
			addCriterion("dw_intro <>", value, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroGreaterThan(String value) {
			addCriterion("dw_intro >", value, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroGreaterThanOrEqualTo(String value) {
			addCriterion("dw_intro >=", value, "DwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroLessThan(String value) {
			addCriterion("dw_intro <", value, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroLessThanOrEqualTo(String value) {
			addCriterion("dw_intro <=", value, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroIn(List<String> values) {
			addCriterion("dw_intro in", values, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroNotIn(List<String> values) {
			addCriterion("dw_intro not in", values, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroBetween(String value1, String value2) {
			addCriterion("dw_intro between", value1, value2, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroNotBetween(String value1, String value2) {
			addCriterion("dw_intro not between", value1, value2, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroLike(String value) {
			addCriterion("dw_intro like", value, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andDwIntroNotLike(String value) {
			addCriterion("dw_intro not like", value, "dwIntro");
			return (Criteria) this;
		}
		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}
		public Criteria andUserIdIsNotNull(){
			addCriterion("user_id is not null");
			return (Criteria) this;
		}
		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "UserId");
			return (Criteria) this;
		}
		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdLike(Integer value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}
		public Criteria andUserIdNotLike(Integer value) {
			addCriterion("user_id not like", value, "userId");
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
