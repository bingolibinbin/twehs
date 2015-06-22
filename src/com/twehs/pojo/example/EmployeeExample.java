package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeExample {

	protected String orderByClause;

	protected List oredCriteria;

	public EmployeeExample() {
		oredCriteria = new ArrayList();
	}

	protected EmployeeExample(EmployeeExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public List getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
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
	}

	public static class Criteria {
		protected List criteriaWithoutValue;

		protected List criteriaWithSingleValue;

		protected List criteriaWithListValue;

		protected List criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList();
			criteriaWithSingleValue = new ArrayList();
			criteriaWithListValue = new ArrayList();
			criteriaWithBetweenValue = new ArrayList();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List values,
				String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List list = new ArrayList();
			list.add(value1);
			list.add(value2);
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andEmployeeidIsNull() {
			addCriterion("employeeid is null");
			return this;
		}

		public Criteria andEmployeeidIsNotNull() {
			addCriterion("employeeid is not null");
			return this;
		}

		public Criteria andEmployeeidEqualTo(Integer value) {
			addCriterion("employeeid =", value, "employeeid");
			return this;
		}

		public Criteria andEmployeeidNotEqualTo(Integer value) {
			addCriterion("employeeid <>", value, "employeeid");
			return this;
		}

		public Criteria andEmployeeidGreaterThan(Integer value) {
			addCriterion("employeeid >", value, "employeeid");
			return this;
		}

		public Criteria andEmployeeidGreaterThanOrEqualTo(Integer value) {
			addCriterion("employeeid >=", value, "employeeid");
			return this;
		}

		public Criteria andEmployeeidLessThan(Integer value) {
			addCriterion("employeeid <", value, "employeeid");
			return this;
		}

		public Criteria andEmployeeidLessThanOrEqualTo(Integer value) {
			addCriterion("employeeid <=", value, "employeeid");
			return this;
		}

		public Criteria andEmployeeidIn(List values) {
			addCriterion("employeeid in", values, "employeeid");
			return this;
		}

		public Criteria andEmployeeidNotIn(List values) {
			addCriterion("employeeid not in", values, "employeeid");
			return this;
		}

		public Criteria andEmployeeidBetween(Integer value1, Integer value2) {
			addCriterion("employeeid between", value1, value2, "employeeid");
			return this;
		}

		public Criteria andEmployeeidNotBetween(Integer value1, Integer value2) {
			addCriterion("employeeid not between", value1, value2, "employeeid");
			return this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return this;
		}

		public Criteria andTitleIn(List values) {
			addCriterion("title in", values, "title");
			return this;
		}

		public Criteria andTitleNotIn(List values) {
			addCriterion("title not in", values, "title");
			return this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return this;
		}

		public Criteria andContentIn(List values) {
			addCriterion("content in", values, "content");
			return this;
		}

		public Criteria andContentNotIn(List values) {
			addCriterion("content not in", values, "content");
			return this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return this;
		}

		public Criteria andDisplayIsNull() {
			addCriterion("display is null");
			return this;
		}

		public Criteria andDisplayIsNotNull() {
			addCriterion("display is not null");
			return this;
		}

		public Criteria andDisplayEqualTo(Boolean value) {
			addCriterion("display =", value, "display");
			return this;
		}

		public Criteria andDisplayNotEqualTo(Boolean value) {
			addCriterion("display <>", value, "display");
			return this;
		}

		public Criteria andDisplayGreaterThan(Boolean value) {
			addCriterion("display >", value, "display");
			return this;
		}

		public Criteria andDisplayGreaterThanOrEqualTo(Boolean value) {
			addCriterion("display >=", value, "display");
			return this;
		}

		public Criteria andDisplayLessThan(Boolean value) {
			addCriterion("display <", value, "display");
			return this;
		}

		public Criteria andDisplayLessThanOrEqualTo(Boolean value) {
			addCriterion("display <=", value, "display");
			return this;
		}

		public Criteria andDisplayIn(List values) {
			addCriterion("display in", values, "display");
			return this;
		}

		public Criteria andDisplayNotIn(List values) {
			addCriterion("display not in", values, "display");
			return this;
		}

		public Criteria andDisplayBetween(Boolean value1, Boolean value2) {
			addCriterion("display between", value1, value2, "display");
			return this;
		}

		public Criteria andDisplayNotBetween(Boolean value1, Boolean value2) {
			addCriterion("display not between", value1, value2, "display");
			return this;
		}

		public Criteria andOperatetimeIsNull() {
			addCriterion("operatetime is null");
			return this;
		}

		public Criteria andOperatetimeIsNotNull() {
			addCriterion("operatetime is not null");
			return this;
		}

		public Criteria andOperatetimeEqualTo(Date value) {
			addCriterion("operatetime =", value, "operatetime");
			return this;
		}

		public Criteria andOperatetimeNotEqualTo(Date value) {
			addCriterion("operatetime <>", value, "operatetime");
			return this;
		}

		public Criteria andOperatetimeGreaterThan(Date value) {
			addCriterion("operatetime >", value, "operatetime");
			return this;
		}

		public Criteria andOperatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("operatetime >=", value, "operatetime");
			return this;
		}

		public Criteria andOperatetimeLessThan(Date value) {
			addCriterion("operatetime <", value, "operatetime");
			return this;
		}

		public Criteria andOperatetimeLessThanOrEqualTo(Date value) {
			addCriterion("operatetime <=", value, "operatetime");
			return this;
		}

		public Criteria andOperatetimeIn(List values) {
			addCriterion("operatetime in", values, "operatetime");
			return this;
		}

		public Criteria andOperatetimeNotIn(List values) {
			addCriterion("operatetime not in", values, "operatetime");
			return this;
		}

		public Criteria andOperatetimeBetween(Date value1, Date value2) {
			addCriterion("operatetime between", value1, value2, "operatetime");
			return this;
		}

		public Criteria andOperatetimeNotBetween(Date value1, Date value2) {
			addCriterion("operatetime not between", value1, value2,
					"operatetime");
			return this;
		}
	}
}