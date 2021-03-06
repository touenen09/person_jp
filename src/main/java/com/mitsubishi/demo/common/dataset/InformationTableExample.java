package com.mitsubishi.demo.common.dataset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationTableExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public InformationTableExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
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

		public Criteria andKey1IsNull() {
			addCriterion("KEY1 is null");
			return (Criteria) this;
		}

		public Criteria andKey1IsNotNull() {
			addCriterion("KEY1 is not null");
			return (Criteria) this;
		}

		public Criteria andKey1EqualTo(String value) {
			addCriterion("KEY1 =", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1NotEqualTo(String value) {
			addCriterion("KEY1 <>", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1GreaterThan(String value) {
			addCriterion("KEY1 >", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1GreaterThanOrEqualTo(String value) {
			addCriterion("KEY1 >=", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1LessThan(String value) {
			addCriterion("KEY1 <", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1LessThanOrEqualTo(String value) {
			addCriterion("KEY1 <=", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1Like(String value) {
			addCriterion("KEY1 like", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1NotLike(String value) {
			addCriterion("KEY1 not like", value, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1In(List<String> values) {
			addCriterion("KEY1 in", values, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1NotIn(List<String> values) {
			addCriterion("KEY1 not in", values, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1Between(String value1, String value2) {
			addCriterion("KEY1 between", value1, value2, "key1");
			return (Criteria) this;
		}

		public Criteria andKey1NotBetween(String value1, String value2) {
			addCriterion("KEY1 not between", value1, value2, "key1");
			return (Criteria) this;
		}

		public Criteria andKey2IsNull() {
			addCriterion("KEY2 is null");
			return (Criteria) this;
		}

		public Criteria andKey2IsNotNull() {
			addCriterion("KEY2 is not null");
			return (Criteria) this;
		}

		public Criteria andKey2EqualTo(String value) {
			addCriterion("KEY2 =", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2NotEqualTo(String value) {
			addCriterion("KEY2 <>", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2GreaterThan(String value) {
			addCriterion("KEY2 >", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2GreaterThanOrEqualTo(String value) {
			addCriterion("KEY2 >=", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2LessThan(String value) {
			addCriterion("KEY2 <", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2LessThanOrEqualTo(String value) {
			addCriterion("KEY2 <=", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2Like(String value) {
			addCriterion("KEY2 like", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2NotLike(String value) {
			addCriterion("KEY2 not like", value, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2In(List<String> values) {
			addCriterion("KEY2 in", values, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2NotIn(List<String> values) {
			addCriterion("KEY2 not in", values, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2Between(String value1, String value2) {
			addCriterion("KEY2 between", value1, value2, "key2");
			return (Criteria) this;
		}

		public Criteria andKey2NotBetween(String value1, String value2) {
			addCriterion("KEY2 not between", value1, value2, "key2");
			return (Criteria) this;
		}

		public Criteria andKey3IsNull() {
			addCriterion("KEY3 is null");
			return (Criteria) this;
		}

		public Criteria andKey3IsNotNull() {
			addCriterion("KEY3 is not null");
			return (Criteria) this;
		}

		public Criteria andKey3EqualTo(String value) {
			addCriterion("KEY3 =", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3NotEqualTo(String value) {
			addCriterion("KEY3 <>", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3GreaterThan(String value) {
			addCriterion("KEY3 >", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3GreaterThanOrEqualTo(String value) {
			addCriterion("KEY3 >=", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3LessThan(String value) {
			addCriterion("KEY3 <", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3LessThanOrEqualTo(String value) {
			addCriterion("KEY3 <=", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3Like(String value) {
			addCriterion("KEY3 like", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3NotLike(String value) {
			addCriterion("KEY3 not like", value, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3In(List<String> values) {
			addCriterion("KEY3 in", values, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3NotIn(List<String> values) {
			addCriterion("KEY3 not in", values, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3Between(String value1, String value2) {
			addCriterion("KEY3 between", value1, value2, "key3");
			return (Criteria) this;
		}

		public Criteria andKey3NotBetween(String value1, String value2) {
			addCriterion("KEY3 not between", value1, value2, "key3");
			return (Criteria) this;
		}

		public Criteria andValueShortIsNull() {
			addCriterion("VALUE_SHORT is null");
			return (Criteria) this;
		}

		public Criteria andValueShortIsNotNull() {
			addCriterion("VALUE_SHORT is not null");
			return (Criteria) this;
		}

		public Criteria andValueShortEqualTo(String value) {
			addCriterion("VALUE_SHORT =", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortNotEqualTo(String value) {
			addCriterion("VALUE_SHORT <>", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortGreaterThan(String value) {
			addCriterion("VALUE_SHORT >", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortGreaterThanOrEqualTo(String value) {
			addCriterion("VALUE_SHORT >=", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortLessThan(String value) {
			addCriterion("VALUE_SHORT <", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortLessThanOrEqualTo(String value) {
			addCriterion("VALUE_SHORT <=", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortLike(String value) {
			addCriterion("VALUE_SHORT like", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortNotLike(String value) {
			addCriterion("VALUE_SHORT not like", value, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortIn(List<String> values) {
			addCriterion("VALUE_SHORT in", values, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortNotIn(List<String> values) {
			addCriterion("VALUE_SHORT not in", values, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortBetween(String value1, String value2) {
			addCriterion("VALUE_SHORT between", value1, value2, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueShortNotBetween(String value1, String value2) {
			addCriterion("VALUE_SHORT not between", value1, value2, "valueShort");
			return (Criteria) this;
		}

		public Criteria andValueLongIsNull() {
			addCriterion("VALUE_LONG is null");
			return (Criteria) this;
		}

		public Criteria andValueLongIsNotNull() {
			addCriterion("VALUE_LONG is not null");
			return (Criteria) this;
		}

		public Criteria andValueLongEqualTo(String value) {
			addCriterion("VALUE_LONG =", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongNotEqualTo(String value) {
			addCriterion("VALUE_LONG <>", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongGreaterThan(String value) {
			addCriterion("VALUE_LONG >", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongGreaterThanOrEqualTo(String value) {
			addCriterion("VALUE_LONG >=", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongLessThan(String value) {
			addCriterion("VALUE_LONG <", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongLessThanOrEqualTo(String value) {
			addCriterion("VALUE_LONG <=", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongLike(String value) {
			addCriterion("VALUE_LONG like", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongNotLike(String value) {
			addCriterion("VALUE_LONG not like", value, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongIn(List<String> values) {
			addCriterion("VALUE_LONG in", values, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongNotIn(List<String> values) {
			addCriterion("VALUE_LONG not in", values, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongBetween(String value1, String value2) {
			addCriterion("VALUE_LONG between", value1, value2, "valueLong");
			return (Criteria) this;
		}

		public Criteria andValueLongNotBetween(String value1, String value2) {
			addCriterion("VALUE_LONG not between", value1, value2, "valueLong");
			return (Criteria) this;
		}

		public Criteria andDescrShortIsNull() {
			addCriterion("DESCR_SHORT is null");
			return (Criteria) this;
		}

		public Criteria andDescrShortIsNotNull() {
			addCriterion("DESCR_SHORT is not null");
			return (Criteria) this;
		}

		public Criteria andDescrShortEqualTo(String value) {
			addCriterion("DESCR_SHORT =", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortNotEqualTo(String value) {
			addCriterion("DESCR_SHORT <>", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortGreaterThan(String value) {
			addCriterion("DESCR_SHORT >", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortGreaterThanOrEqualTo(String value) {
			addCriterion("DESCR_SHORT >=", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortLessThan(String value) {
			addCriterion("DESCR_SHORT <", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortLessThanOrEqualTo(String value) {
			addCriterion("DESCR_SHORT <=", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortLike(String value) {
			addCriterion("DESCR_SHORT like", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortNotLike(String value) {
			addCriterion("DESCR_SHORT not like", value, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortIn(List<String> values) {
			addCriterion("DESCR_SHORT in", values, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortNotIn(List<String> values) {
			addCriterion("DESCR_SHORT not in", values, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortBetween(String value1, String value2) {
			addCriterion("DESCR_SHORT between", value1, value2, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrShortNotBetween(String value1, String value2) {
			addCriterion("DESCR_SHORT not between", value1, value2, "descrShort");
			return (Criteria) this;
		}

		public Criteria andDescrLongIsNull() {
			addCriterion("DESCR_LONG is null");
			return (Criteria) this;
		}

		public Criteria andDescrLongIsNotNull() {
			addCriterion("DESCR_LONG is not null");
			return (Criteria) this;
		}

		public Criteria andDescrLongEqualTo(String value) {
			addCriterion("DESCR_LONG =", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongNotEqualTo(String value) {
			addCriterion("DESCR_LONG <>", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongGreaterThan(String value) {
			addCriterion("DESCR_LONG >", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongGreaterThanOrEqualTo(String value) {
			addCriterion("DESCR_LONG >=", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongLessThan(String value) {
			addCriterion("DESCR_LONG <", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongLessThanOrEqualTo(String value) {
			addCriterion("DESCR_LONG <=", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongLike(String value) {
			addCriterion("DESCR_LONG like", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongNotLike(String value) {
			addCriterion("DESCR_LONG not like", value, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongIn(List<String> values) {
			addCriterion("DESCR_LONG in", values, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongNotIn(List<String> values) {
			addCriterion("DESCR_LONG not in", values, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongBetween(String value1, String value2) {
			addCriterion("DESCR_LONG between", value1, value2, "descrLong");
			return (Criteria) this;
		}

		public Criteria andDescrLongNotBetween(String value1, String value2) {
			addCriterion("DESCR_LONG not between", value1, value2, "descrLong");
			return (Criteria) this;
		}

		public Criteria andInteger1IsNull() {
			addCriterion("INTEGER1 is null");
			return (Criteria) this;
		}

		public Criteria andInteger1IsNotNull() {
			addCriterion("INTEGER1 is not null");
			return (Criteria) this;
		}

		public Criteria andInteger1EqualTo(BigDecimal value) {
			addCriterion("INTEGER1 =", value, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1NotEqualTo(BigDecimal value) {
			addCriterion("INTEGER1 <>", value, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1GreaterThan(BigDecimal value) {
			addCriterion("INTEGER1 >", value, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1GreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("INTEGER1 >=", value, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1LessThan(BigDecimal value) {
			addCriterion("INTEGER1 <", value, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1LessThanOrEqualTo(BigDecimal value) {
			addCriterion("INTEGER1 <=", value, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1In(List<BigDecimal> values) {
			addCriterion("INTEGER1 in", values, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1NotIn(List<BigDecimal> values) {
			addCriterion("INTEGER1 not in", values, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1Between(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTEGER1 between", value1, value2, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger1NotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTEGER1 not between", value1, value2, "integer1");
			return (Criteria) this;
		}

		public Criteria andInteger2IsNull() {
			addCriterion("INTEGER2 is null");
			return (Criteria) this;
		}

		public Criteria andInteger2IsNotNull() {
			addCriterion("INTEGER2 is not null");
			return (Criteria) this;
		}

		public Criteria andInteger2EqualTo(BigDecimal value) {
			addCriterion("INTEGER2 =", value, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2NotEqualTo(BigDecimal value) {
			addCriterion("INTEGER2 <>", value, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2GreaterThan(BigDecimal value) {
			addCriterion("INTEGER2 >", value, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2GreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("INTEGER2 >=", value, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2LessThan(BigDecimal value) {
			addCriterion("INTEGER2 <", value, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2LessThanOrEqualTo(BigDecimal value) {
			addCriterion("INTEGER2 <=", value, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2In(List<BigDecimal> values) {
			addCriterion("INTEGER2 in", values, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2NotIn(List<BigDecimal> values) {
			addCriterion("INTEGER2 not in", values, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2Between(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTEGER2 between", value1, value2, "integer2");
			return (Criteria) this;
		}

		public Criteria andInteger2NotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTEGER2 not between", value1, value2, "integer2");
			return (Criteria) this;
		}

		public Criteria andDate1IsNull() {
			addCriterion("DATE1 is null");
			return (Criteria) this;
		}

		public Criteria andDate1IsNotNull() {
			addCriterion("DATE1 is not null");
			return (Criteria) this;
		}

		public Criteria andDate1EqualTo(Date value) {
			addCriterion("DATE1 =", value, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1NotEqualTo(Date value) {
			addCriterion("DATE1 <>", value, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1GreaterThan(Date value) {
			addCriterion("DATE1 >", value, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1GreaterThanOrEqualTo(Date value) {
			addCriterion("DATE1 >=", value, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1LessThan(Date value) {
			addCriterion("DATE1 <", value, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1LessThanOrEqualTo(Date value) {
			addCriterion("DATE1 <=", value, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1In(List<Date> values) {
			addCriterion("DATE1 in", values, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1NotIn(List<Date> values) {
			addCriterion("DATE1 not in", values, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1Between(Date value1, Date value2) {
			addCriterion("DATE1 between", value1, value2, "date1");
			return (Criteria) this;
		}

		public Criteria andDate1NotBetween(Date value1, Date value2) {
			addCriterion("DATE1 not between", value1, value2, "date1");
			return (Criteria) this;
		}

		public Criteria andDate2IsNull() {
			addCriterion("DATE2 is null");
			return (Criteria) this;
		}

		public Criteria andDate2IsNotNull() {
			addCriterion("DATE2 is not null");
			return (Criteria) this;
		}

		public Criteria andDate2EqualTo(Date value) {
			addCriterion("DATE2 =", value, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2NotEqualTo(Date value) {
			addCriterion("DATE2 <>", value, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2GreaterThan(Date value) {
			addCriterion("DATE2 >", value, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2GreaterThanOrEqualTo(Date value) {
			addCriterion("DATE2 >=", value, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2LessThan(Date value) {
			addCriterion("DATE2 <", value, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2LessThanOrEqualTo(Date value) {
			addCriterion("DATE2 <=", value, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2In(List<Date> values) {
			addCriterion("DATE2 in", values, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2NotIn(List<Date> values) {
			addCriterion("DATE2 not in", values, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2Between(Date value1, Date value2) {
			addCriterion("DATE2 between", value1, value2, "date2");
			return (Criteria) this;
		}

		public Criteria andDate2NotBetween(Date value1, Date value2) {
			addCriterion("DATE2 not between", value1, value2, "date2");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeIsNull() {
			addCriterion("ADD_UPDATE_DATETIME is null");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeIsNotNull() {
			addCriterion("ADD_UPDATE_DATETIME is not null");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeEqualTo(Date value) {
			addCriterion("ADD_UPDATE_DATETIME =", value, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeNotEqualTo(Date value) {
			addCriterion("ADD_UPDATE_DATETIME <>", value, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeGreaterThan(Date value) {
			addCriterion("ADD_UPDATE_DATETIME >", value, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ADD_UPDATE_DATETIME >=", value, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeLessThan(Date value) {
			addCriterion("ADD_UPDATE_DATETIME <", value, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeLessThanOrEqualTo(Date value) {
			addCriterion("ADD_UPDATE_DATETIME <=", value, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeIn(List<Date> values) {
			addCriterion("ADD_UPDATE_DATETIME in", values, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeNotIn(List<Date> values) {
			addCriterion("ADD_UPDATE_DATETIME not in", values, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeBetween(Date value1, Date value2) {
			addCriterion("ADD_UPDATE_DATETIME between", value1, value2, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andAddUpdateDatetimeNotBetween(Date value1, Date value2) {
			addCriterion("ADD_UPDATE_DATETIME not between", value1, value2, "addUpdateDatetime");
			return (Criteria) this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("USERID is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("USERID is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(String value) {
			addCriterion("USERID =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(String value) {
			addCriterion("USERID <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(String value) {
			addCriterion("USERID >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(String value) {
			addCriterion("USERID >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(String value) {
			addCriterion("USERID <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(String value) {
			addCriterion("USERID <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLike(String value) {
			addCriterion("USERID like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotLike(String value) {
			addCriterion("USERID not like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<String> values) {
			addCriterion("USERID in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<String> values) {
			addCriterion("USERID not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(String value1, String value2) {
			addCriterion("USERID between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(String value1, String value2) {
			addCriterion("USERID not between", value1, value2, "userid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table INFORMATION_TABLE
	 * @mbg.generated  Tue Oct 17 17:31:01 CST 2017
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
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INFORMATION_TABLE
     *
     * @mbg.generated do_not_delete_during_merge Tue Oct 17 17:13:29 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}