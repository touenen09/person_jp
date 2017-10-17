package com.mitsubishi.demo.common.dataset;

import java.util.ArrayList;
import java.util.List;

public class PersonTableExample {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the
	 * database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public PersonTableExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the
	 * database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
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

		public Criteria andPersonNumIsNull() {
			addCriterion("PERSON_NUM is null");
			return (Criteria) this;
		}

		public Criteria andPersonNumIsNotNull() {
			addCriterion("PERSON_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andPersonNumEqualTo(String value) {
			addCriterion("PERSON_NUM =", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumNotEqualTo(String value) {
			addCriterion("PERSON_NUM <>", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumGreaterThan(String value) {
			addCriterion("PERSON_NUM >", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumGreaterThanOrEqualTo(String value) {
			addCriterion("PERSON_NUM >=", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumLessThan(String value) {
			addCriterion("PERSON_NUM <", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumLessThanOrEqualTo(String value) {
			addCriterion("PERSON_NUM <=", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumLike(String value) {
			addCriterion("PERSON_NUM like", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumNotLike(String value) {
			addCriterion("PERSON_NUM not like", value, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumIn(List<String> values) {
			addCriterion("PERSON_NUM in", values, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumNotIn(List<String> values) {
			addCriterion("PERSON_NUM not in", values, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumBetween(String value1, String value2) {
			addCriterion("PERSON_NUM between", value1, value2, "personNum");
			return (Criteria) this;
		}

		public Criteria andPersonNumNotBetween(String value1, String value2) {
			addCriterion("PERSON_NUM not between", value1, value2, "personNum");
			return (Criteria) this;
		}

		public Criteria andPhotoIsNull() {
			addCriterion("PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andPhotoIsNotNull() {
			addCriterion("PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoEqualTo(String value) {
			addCriterion("PHOTO =", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoNotEqualTo(String value) {
			addCriterion("PHOTO <>", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoGreaterThan(String value) {
			addCriterion("PHOTO >", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoGreaterThanOrEqualTo(String value) {
			addCriterion("PHOTO >=", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoLessThan(String value) {
			addCriterion("PHOTO <", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoLessThanOrEqualTo(String value) {
			addCriterion("PHOTO <=", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoLike(String value) {
			addCriterion("PHOTO like", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoNotLike(String value) {
			addCriterion("PHOTO not like", value, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoIn(List<String> values) {
			addCriterion("PHOTO in", values, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoNotIn(List<String> values) {
			addCriterion("PHOTO not in", values, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoBetween(String value1, String value2) {
			addCriterion("PHOTO between", value1, value2, "photo");
			return (Criteria) this;
		}

		public Criteria andPhotoNotBetween(String value1, String value2) {
			addCriterion("PHOTO not between", value1, value2, "photo");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andDepartmentIsNull() {
			addCriterion("DEPARTMENT is null");
			return (Criteria) this;
		}

		public Criteria andDepartmentIsNotNull() {
			addCriterion("DEPARTMENT is not null");
			return (Criteria) this;
		}

		public Criteria andDepartmentEqualTo(String value) {
			addCriterion("DEPARTMENT =", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotEqualTo(String value) {
			addCriterion("DEPARTMENT <>", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentGreaterThan(String value) {
			addCriterion("DEPARTMENT >", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
			addCriterion("DEPARTMENT >=", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentLessThan(String value) {
			addCriterion("DEPARTMENT <", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentLessThanOrEqualTo(String value) {
			addCriterion("DEPARTMENT <=", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentLike(String value) {
			addCriterion("DEPARTMENT like", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotLike(String value) {
			addCriterion("DEPARTMENT not like", value, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentIn(List<String> values) {
			addCriterion("DEPARTMENT in", values, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotIn(List<String> values) {
			addCriterion("DEPARTMENT not in", values, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentBetween(String value1, String value2) {
			addCriterion("DEPARTMENT between", value1, value2, "department");
			return (Criteria) this;
		}

		public Criteria andDepartmentNotBetween(String value1, String value2) {
			addCriterion("DEPARTMENT not between", value1, value2, "department");
			return (Criteria) this;
		}

		public Criteria andJobIsNull() {
			addCriterion("JOB is null");
			return (Criteria) this;
		}

		public Criteria andJobIsNotNull() {
			addCriterion("JOB is not null");
			return (Criteria) this;
		}

		public Criteria andJobEqualTo(String value) {
			addCriterion("JOB =", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobNotEqualTo(String value) {
			addCriterion("JOB <>", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobGreaterThan(String value) {
			addCriterion("JOB >", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobGreaterThanOrEqualTo(String value) {
			addCriterion("JOB >=", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobLessThan(String value) {
			addCriterion("JOB <", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobLessThanOrEqualTo(String value) {
			addCriterion("JOB <=", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobLike(String value) {
			addCriterion("JOB like", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobNotLike(String value) {
			addCriterion("JOB not like", value, "job");
			return (Criteria) this;
		}

		public Criteria andJobIn(List<String> values) {
			addCriterion("JOB in", values, "job");
			return (Criteria) this;
		}

		public Criteria andJobNotIn(List<String> values) {
			addCriterion("JOB not in", values, "job");
			return (Criteria) this;
		}

		public Criteria andJobBetween(String value1, String value2) {
			addCriterion("JOB between", value1, value2, "job");
			return (Criteria) this;
		}

		public Criteria andJobNotBetween(String value1, String value2) {
			addCriterion("JOB not between", value1, value2, "job");
			return (Criteria) this;
		}

		public Criteria andGradeIsNull() {
			addCriterion("GRADE is null");
			return (Criteria) this;
		}

		public Criteria andGradeIsNotNull() {
			addCriterion("GRADE is not null");
			return (Criteria) this;
		}

		public Criteria andGradeEqualTo(String value) {
			addCriterion("GRADE =", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotEqualTo(String value) {
			addCriterion("GRADE <>", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeGreaterThan(String value) {
			addCriterion("GRADE >", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeGreaterThanOrEqualTo(String value) {
			addCriterion("GRADE >=", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeLessThan(String value) {
			addCriterion("GRADE <", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeLessThanOrEqualTo(String value) {
			addCriterion("GRADE <=", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeLike(String value) {
			addCriterion("GRADE like", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotLike(String value) {
			addCriterion("GRADE not like", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeIn(List<String> values) {
			addCriterion("GRADE in", values, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotIn(List<String> values) {
			addCriterion("GRADE not in", values, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeBetween(String value1, String value2) {
			addCriterion("GRADE between", value1, value2, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotBetween(String value1, String value2) {
			addCriterion("GRADE not between", value1, value2, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeStepIsNull() {
			addCriterion("GRADE_STEP is null");
			return (Criteria) this;
		}

		public Criteria andGradeStepIsNotNull() {
			addCriterion("GRADE_STEP is not null");
			return (Criteria) this;
		}

		public Criteria andGradeStepEqualTo(String value) {
			addCriterion("GRADE_STEP =", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepNotEqualTo(String value) {
			addCriterion("GRADE_STEP <>", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepGreaterThan(String value) {
			addCriterion("GRADE_STEP >", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepGreaterThanOrEqualTo(String value) {
			addCriterion("GRADE_STEP >=", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepLessThan(String value) {
			addCriterion("GRADE_STEP <", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepLessThanOrEqualTo(String value) {
			addCriterion("GRADE_STEP <=", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepLike(String value) {
			addCriterion("GRADE_STEP like", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepNotLike(String value) {
			addCriterion("GRADE_STEP not like", value, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepIn(List<String> values) {
			addCriterion("GRADE_STEP in", values, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepNotIn(List<String> values) {
			addCriterion("GRADE_STEP not in", values, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepBetween(String value1, String value2) {
			addCriterion("GRADE_STEP between", value1, value2, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andGradeStepNotBetween(String value1, String value2) {
			addCriterion("GRADE_STEP not between", value1, value2, "gradeStep");
			return (Criteria) this;
		}

		public Criteria andLocationIsNull() {
			addCriterion("LOCATION is null");
			return (Criteria) this;
		}

		public Criteria andLocationIsNotNull() {
			addCriterion("LOCATION is not null");
			return (Criteria) this;
		}

		public Criteria andLocationEqualTo(String value) {
			addCriterion("LOCATION =", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotEqualTo(String value) {
			addCriterion("LOCATION <>", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThan(String value) {
			addCriterion("LOCATION >", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationGreaterThanOrEqualTo(String value) {
			addCriterion("LOCATION >=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThan(String value) {
			addCriterion("LOCATION <", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLessThanOrEqualTo(String value) {
			addCriterion("LOCATION <=", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationLike(String value) {
			addCriterion("LOCATION like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotLike(String value) {
			addCriterion("LOCATION not like", value, "location");
			return (Criteria) this;
		}

		public Criteria andLocationIn(List<String> values) {
			addCriterion("LOCATION in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotIn(List<String> values) {
			addCriterion("LOCATION not in", values, "location");
			return (Criteria) this;
		}

		public Criteria andLocationBetween(String value1, String value2) {
			addCriterion("LOCATION between", value1, value2, "location");
			return (Criteria) this;
		}

		public Criteria andLocationNotBetween(String value1, String value2) {
			addCriterion("LOCATION not between", value1, value2, "location");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the
	 * database table PERSON_TABLE
	 * 
	 * @mbg.generated Tue Oct 17 15:14:57 CST 2017
	 */
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

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the
	 * database table PERSON_TABLE
	 *
	 * @mbg.generated do_not_delete_during_merge Tue Oct 17 14:59:16 CST 2017
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}
}