package com.project.model;
import java.util.ArrayList;
import java.util.List;
public class GrsAppExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public GrsAppExample() {
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
		public Criteria andCheckStatusIsNull() {
			addCriterion("check_status is null");
			return (Criteria) this;
		}
		public Criteria andCheckStatusIsNotNull(){
			addCriterion("check_status is not null");
			return (Criteria) this;
		}
		public Criteria andCheckStatusEqualTo(Integer value) {
			addCriterion("check_status =", value, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusNotEqualTo(Integer value) {
			addCriterion("check_status <>", value, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusGreaterThan(Integer value) {
			addCriterion("check_status >", value, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("check_status >=", value, "CheckStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusLessThan(Integer value) {
			addCriterion("check_status <", value, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
			addCriterion("check_status <=", value, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusIn(List<Integer> values) {
			addCriterion("check_status in", values, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusNotIn(List<Integer> values) {
			addCriterion("check_status not in", values, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
			addCriterion("check_status between", value1, value2, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("check_status not between", value1, value2, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusLike(Integer value) {
			addCriterion("check_status like", value, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckStatusNotLike(Integer value) {
			addCriterion("check_status not like", value, "checkStatus");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkIsNull() {
			addCriterion("check_remark is null");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkIsNotNull(){
			addCriterion("check_remark is not null");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkEqualTo(String value) {
			addCriterion("check_remark =", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotEqualTo(String value) {
			addCriterion("check_remark <>", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkGreaterThan(String value) {
			addCriterion("check_remark >", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("check_remark >=", value, "CheckRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkLessThan(String value) {
			addCriterion("check_remark <", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkLessThanOrEqualTo(String value) {
			addCriterion("check_remark <=", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkIn(List<String> values) {
			addCriterion("check_remark in", values, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotIn(List<String> values) {
			addCriterion("check_remark not in", values, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkBetween(String value1, String value2) {
			addCriterion("check_remark between", value1, value2, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotBetween(String value1, String value2) {
			addCriterion("check_remark not between", value1, value2, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkLike(String value) {
			addCriterion("check_remark like", value, "checkRemark");
			return (Criteria) this;
		}
		public Criteria andCheckRemarkNotLike(String value) {
			addCriterion("check_remark not like", value, "checkRemark");
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
		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}
		public Criteria andCreateDateIsNotNull(){
			addCriterion("create_date is not null");
			return (Criteria) this;
		}
		public Criteria andCreateDateEqualTo(String value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotEqualTo(String value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThan(String value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
			addCriterion("create_date >=", value, "CreateDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThan(String value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThanOrEqualTo(String value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateIn(List<String> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotIn(List<String> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateBetween(String value1, String value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotBetween(String value1, String value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLike(String value) {
			addCriterion("create_date like", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotLike(String value) {
			addCriterion("create_date not like", value, "createDate");
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
