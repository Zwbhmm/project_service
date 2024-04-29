package com.project.model;
import java.util.ArrayList;
import java.util.List;
public class NbascExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public NbascExample() {
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
		public Criteria andDzsfIsNull() {
			addCriterion("dzsf is null");
			return (Criteria) this;
		}
		public Criteria andDzsfIsNotNull(){
			addCriterion("dzsf is not null");
			return (Criteria) this;
		}
		public Criteria andDzsfEqualTo(String value) {
			addCriterion("dzsf =", value, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfNotEqualTo(String value) {
			addCriterion("dzsf <>", value, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfGreaterThan(String value) {
			addCriterion("dzsf >", value, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfGreaterThanOrEqualTo(String value) {
			addCriterion("dzsf >=", value, "Dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfLessThan(String value) {
			addCriterion("dzsf <", value, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfLessThanOrEqualTo(String value) {
			addCriterion("dzsf <=", value, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfIn(List<String> values) {
			addCriterion("dzsf in", values, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfNotIn(List<String> values) {
			addCriterion("dzsf not in", values, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfBetween(String value1, String value2) {
			addCriterion("dzsf between", value1, value2, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfNotBetween(String value1, String value2) {
			addCriterion("dzsf not between", value1, value2, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfLike(String value) {
			addCriterion("dzsf like", value, "dzsf");
			return (Criteria) this;
		}
		public Criteria andDzsfNotLike(String value) {
			addCriterion("dzsf not like", value, "dzsf");
			return (Criteria) this;
		}
		public Criteria andBsddIsNull() {
			addCriterion("bsdd is null");
			return (Criteria) this;
		}
		public Criteria andBsddIsNotNull(){
			addCriterion("bsdd is not null");
			return (Criteria) this;
		}
		public Criteria andBsddEqualTo(String value) {
			addCriterion("bsdd =", value, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddNotEqualTo(String value) {
			addCriterion("bsdd <>", value, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddGreaterThan(String value) {
			addCriterion("bsdd >", value, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddGreaterThanOrEqualTo(String value) {
			addCriterion("bsdd >=", value, "Bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddLessThan(String value) {
			addCriterion("bsdd <", value, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddLessThanOrEqualTo(String value) {
			addCriterion("bsdd <=", value, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddIn(List<String> values) {
			addCriterion("bsdd in", values, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddNotIn(List<String> values) {
			addCriterion("bsdd not in", values, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddBetween(String value1, String value2) {
			addCriterion("bsdd between", value1, value2, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddNotBetween(String value1, String value2) {
			addCriterion("bsdd not between", value1, value2, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddLike(String value) {
			addCriterion("bsdd like", value, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsddNotLike(String value) {
			addCriterion("bsdd not like", value, "bsdd");
			return (Criteria) this;
		}
		public Criteria andBsTimeIsNull() {
			addCriterion("bs_time is null");
			return (Criteria) this;
		}
		public Criteria andBsTimeIsNotNull(){
			addCriterion("bs_time is not null");
			return (Criteria) this;
		}
		public Criteria andBsTimeEqualTo(String value) {
			addCriterion("bs_time =", value, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeNotEqualTo(String value) {
			addCriterion("bs_time <>", value, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeGreaterThan(String value) {
			addCriterion("bs_time >", value, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeGreaterThanOrEqualTo(String value) {
			addCriterion("bs_time >=", value, "BsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeLessThan(String value) {
			addCriterion("bs_time <", value, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeLessThanOrEqualTo(String value) {
			addCriterion("bs_time <=", value, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeIn(List<String> values) {
			addCriterion("bs_time in", values, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeNotIn(List<String> values) {
			addCriterion("bs_time not in", values, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeBetween(String value1, String value2) {
			addCriterion("bs_time between", value1, value2, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeNotBetween(String value1, String value2) {
			addCriterion("bs_time not between", value1, value2, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeLike(String value) {
			addCriterion("bs_time like", value, "bsTime");
			return (Criteria) this;
		}
		public Criteria andBsTimeNotLike(String value) {
			addCriterion("bs_time not like", value, "bsTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeIsNull() {
			addCriterion("fb_time is null");
			return (Criteria) this;
		}
		public Criteria andFbTimeIsNotNull(){
			addCriterion("fb_time is not null");
			return (Criteria) this;
		}
		public Criteria andFbTimeEqualTo(String value) {
			addCriterion("fb_time =", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotEqualTo(String value) {
			addCriterion("fb_time <>", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeGreaterThan(String value) {
			addCriterion("fb_time >", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeGreaterThanOrEqualTo(String value) {
			addCriterion("fb_time >=", value, "FbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeLessThan(String value) {
			addCriterion("fb_time <", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeLessThanOrEqualTo(String value) {
			addCriterion("fb_time <=", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeIn(List<String> values) {
			addCriterion("fb_time in", values, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotIn(List<String> values) {
			addCriterion("fb_time not in", values, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeBetween(String value1, String value2) {
			addCriterion("fb_time between", value1, value2, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotBetween(String value1, String value2) {
			addCriterion("fb_time not between", value1, value2, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeLike(String value) {
			addCriterion("fb_time like", value, "fbTime");
			return (Criteria) this;
		}
		public Criteria andFbTimeNotLike(String value) {
			addCriterion("fb_time not like", value, "fbTime");
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
