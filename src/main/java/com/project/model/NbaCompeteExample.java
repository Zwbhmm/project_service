package com.project.model;
import java.util.ArrayList;
import java.util.List;
public class NbaCompeteExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public NbaCompeteExample() {
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
		public Criteria andBsNameIsNull() {
			addCriterion("bs_name is null");
			return (Criteria) this;
		}
		public Criteria andBsNameIsNotNull(){
			addCriterion("bs_name is not null");
			return (Criteria) this;
		}
		public Criteria andBsNameEqualTo(String value) {
			addCriterion("bs_name =", value, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameNotEqualTo(String value) {
			addCriterion("bs_name <>", value, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameGreaterThan(String value) {
			addCriterion("bs_name >", value, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameGreaterThanOrEqualTo(String value) {
			addCriterion("bs_name >=", value, "BsName");
			return (Criteria) this;
		}
		public Criteria andBsNameLessThan(String value) {
			addCriterion("bs_name <", value, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameLessThanOrEqualTo(String value) {
			addCriterion("bs_name <=", value, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameIn(List<String> values) {
			addCriterion("bs_name in", values, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameNotIn(List<String> values) {
			addCriterion("bs_name not in", values, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameBetween(String value1, String value2) {
			addCriterion("bs_name between", value1, value2, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameNotBetween(String value1, String value2) {
			addCriterion("bs_name not between", value1, value2, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameLike(String value) {
			addCriterion("bs_name like", value, "bsName");
			return (Criteria) this;
		}
		public Criteria andBsNameNotLike(String value) {
			addCriterion("bs_name not like", value, "bsName");
			return (Criteria) this;
		}
		public Criteria andScoreIntroIsNull() {
			addCriterion("score_intro is null");
			return (Criteria) this;
		}
		public Criteria andScoreIntroIsNotNull(){
			addCriterion("score_intro is not null");
			return (Criteria) this;
		}
		public Criteria andScoreIntroEqualTo(String value) {
			addCriterion("score_intro =", value, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroNotEqualTo(String value) {
			addCriterion("score_intro <>", value, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroGreaterThan(String value) {
			addCriterion("score_intro >", value, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroGreaterThanOrEqualTo(String value) {
			addCriterion("score_intro >=", value, "ScoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroLessThan(String value) {
			addCriterion("score_intro <", value, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroLessThanOrEqualTo(String value) {
			addCriterion("score_intro <=", value, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroIn(List<String> values) {
			addCriterion("score_intro in", values, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroNotIn(List<String> values) {
			addCriterion("score_intro not in", values, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroBetween(String value1, String value2) {
			addCriterion("score_intro between", value1, value2, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroNotBetween(String value1, String value2) {
			addCriterion("score_intro not between", value1, value2, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroLike(String value) {
			addCriterion("score_intro like", value, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andScoreIntroNotLike(String value) {
			addCriterion("score_intro not like", value, "scoreIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroIsNull() {
			addCriterion("bs_intro is null");
			return (Criteria) this;
		}
		public Criteria andBsIntroIsNotNull(){
			addCriterion("bs_intro is not null");
			return (Criteria) this;
		}
		public Criteria andBsIntroEqualTo(String value) {
			addCriterion("bs_intro =", value, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroNotEqualTo(String value) {
			addCriterion("bs_intro <>", value, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroGreaterThan(String value) {
			addCriterion("bs_intro >", value, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroGreaterThanOrEqualTo(String value) {
			addCriterion("bs_intro >=", value, "BsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroLessThan(String value) {
			addCriterion("bs_intro <", value, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroLessThanOrEqualTo(String value) {
			addCriterion("bs_intro <=", value, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroIn(List<String> values) {
			addCriterion("bs_intro in", values, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroNotIn(List<String> values) {
			addCriterion("bs_intro not in", values, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroBetween(String value1, String value2) {
			addCriterion("bs_intro between", value1, value2, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroNotBetween(String value1, String value2) {
			addCriterion("bs_intro not between", value1, value2, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroLike(String value) {
			addCriterion("bs_intro like", value, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andBsIntroNotLike(String value) {
			addCriterion("bs_intro not like", value, "bsIntro");
			return (Criteria) this;
		}
		public Criteria andQyDataIsNull() {
			addCriterion("qy_data is null");
			return (Criteria) this;
		}
		public Criteria andQyDataIsNotNull(){
			addCriterion("qy_data is not null");
			return (Criteria) this;
		}
		public Criteria andQyDataEqualTo(String value) {
			addCriterion("qy_data =", value, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataNotEqualTo(String value) {
			addCriterion("qy_data <>", value, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataGreaterThan(String value) {
			addCriterion("qy_data >", value, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataGreaterThanOrEqualTo(String value) {
			addCriterion("qy_data >=", value, "QyData");
			return (Criteria) this;
		}
		public Criteria andQyDataLessThan(String value) {
			addCriterion("qy_data <", value, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataLessThanOrEqualTo(String value) {
			addCriterion("qy_data <=", value, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataIn(List<String> values) {
			addCriterion("qy_data in", values, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataNotIn(List<String> values) {
			addCriterion("qy_data not in", values, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataBetween(String value1, String value2) {
			addCriterion("qy_data between", value1, value2, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataNotBetween(String value1, String value2) {
			addCriterion("qy_data not between", value1, value2, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataLike(String value) {
			addCriterion("qy_data like", value, "qyData");
			return (Criteria) this;
		}
		public Criteria andQyDataNotLike(String value) {
			addCriterion("qy_data not like", value, "qyData");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNotNull(){
			addCriterion("create_time is not null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("create_time >=", value, "CreateTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLike(String value) {
			addCriterion("create_time like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("create_time not like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andFmImgIsNull() {
			addCriterion("fm_img is null");
			return (Criteria) this;
		}
		public Criteria andFmImgIsNotNull(){
			addCriterion("fm_img is not null");
			return (Criteria) this;
		}
		public Criteria andFmImgEqualTo(String value) {
			addCriterion("fm_img =", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotEqualTo(String value) {
			addCriterion("fm_img <>", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgGreaterThan(String value) {
			addCriterion("fm_img >", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgGreaterThanOrEqualTo(String value) {
			addCriterion("fm_img >=", value, "FmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgLessThan(String value) {
			addCriterion("fm_img <", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgLessThanOrEqualTo(String value) {
			addCriterion("fm_img <=", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgIn(List<String> values) {
			addCriterion("fm_img in", values, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotIn(List<String> values) {
			addCriterion("fm_img not in", values, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgBetween(String value1, String value2) {
			addCriterion("fm_img between", value1, value2, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotBetween(String value1, String value2) {
			addCriterion("fm_img not between", value1, value2, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgLike(String value) {
			addCriterion("fm_img like", value, "fmImg");
			return (Criteria) this;
		}
		public Criteria andFmImgNotLike(String value) {
			addCriterion("fm_img not like", value, "fmImg");
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
