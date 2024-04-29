package com.project.model;
import java.util.ArrayList;
import java.util.List;
public class JdVideoExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public JdVideoExample() {
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
		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}
		public Criteria andTitleIsNotNull(){
			addCriterion("title is not null");
			return (Criteria) this;
		}
		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "Title");
			return (Criteria) this;
		}
		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}
		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}
		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
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
		public Criteria andVeoUrlIsNull() {
			addCriterion("veo_url is null");
			return (Criteria) this;
		}
		public Criteria andVeoUrlIsNotNull(){
			addCriterion("veo_url is not null");
			return (Criteria) this;
		}
		public Criteria andVeoUrlEqualTo(String value) {
			addCriterion("veo_url =", value, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlNotEqualTo(String value) {
			addCriterion("veo_url <>", value, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlGreaterThan(String value) {
			addCriterion("veo_url >", value, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlGreaterThanOrEqualTo(String value) {
			addCriterion("veo_url >=", value, "VeoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlLessThan(String value) {
			addCriterion("veo_url <", value, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlLessThanOrEqualTo(String value) {
			addCriterion("veo_url <=", value, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlIn(List<String> values) {
			addCriterion("veo_url in", values, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlNotIn(List<String> values) {
			addCriterion("veo_url not in", values, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlBetween(String value1, String value2) {
			addCriterion("veo_url between", value1, value2, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlNotBetween(String value1, String value2) {
			addCriterion("veo_url not between", value1, value2, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlLike(String value) {
			addCriterion("veo_url like", value, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoUrlNotLike(String value) {
			addCriterion("veo_url not like", value, "veoUrl");
			return (Criteria) this;
		}
		public Criteria andVeoIntroIsNull() {
			addCriterion("veo_intro is null");
			return (Criteria) this;
		}
		public Criteria andVeoIntroIsNotNull(){
			addCriterion("veo_intro is not null");
			return (Criteria) this;
		}
		public Criteria andVeoIntroEqualTo(String value) {
			addCriterion("veo_intro =", value, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroNotEqualTo(String value) {
			addCriterion("veo_intro <>", value, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroGreaterThan(String value) {
			addCriterion("veo_intro >", value, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroGreaterThanOrEqualTo(String value) {
			addCriterion("veo_intro >=", value, "VeoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroLessThan(String value) {
			addCriterion("veo_intro <", value, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroLessThanOrEqualTo(String value) {
			addCriterion("veo_intro <=", value, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroIn(List<String> values) {
			addCriterion("veo_intro in", values, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroNotIn(List<String> values) {
			addCriterion("veo_intro not in", values, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroBetween(String value1, String value2) {
			addCriterion("veo_intro between", value1, value2, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroNotBetween(String value1, String value2) {
			addCriterion("veo_intro not between", value1, value2, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroLike(String value) {
			addCriterion("veo_intro like", value, "veoIntro");
			return (Criteria) this;
		}
		public Criteria andVeoIntroNotLike(String value) {
			addCriterion("veo_intro not like", value, "veoIntro");
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
		public Criteria andPraiseNumIsNull() {
			addCriterion("praise_num is null");
			return (Criteria) this;
		}
		public Criteria andPraiseNumIsNotNull(){
			addCriterion("praise_num is not null");
			return (Criteria) this;
		}
		public Criteria andPraiseNumEqualTo(Integer value) {
			addCriterion("praise_num =", value, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumNotEqualTo(Integer value) {
			addCriterion("praise_num <>", value, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumGreaterThan(Integer value) {
			addCriterion("praise_num >", value, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("praise_num >=", value, "PraiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumLessThan(Integer value) {
			addCriterion("praise_num <", value, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumLessThanOrEqualTo(Integer value) {
			addCriterion("praise_num <=", value, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumIn(List<Integer> values) {
			addCriterion("praise_num in", values, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumNotIn(List<Integer> values) {
			addCriterion("praise_num not in", values, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumBetween(Integer value1, Integer value2) {
			addCriterion("praise_num between", value1, value2, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumNotBetween(Integer value1, Integer value2) {
			addCriterion("praise_num not between", value1, value2, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumLike(Integer value) {
			addCriterion("praise_num like", value, "praiseNum");
			return (Criteria) this;
		}
		public Criteria andPraiseNumNotLike(Integer value) {
			addCriterion("praise_num not like", value, "praiseNum");
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
