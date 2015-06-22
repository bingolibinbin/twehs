package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodificationExample {

	protected String orderByClause;

	protected List oredCriteria;

	public NodificationExample() {
		oredCriteria = new ArrayList();
	}

	protected NodificationExample(NodificationExample example) {
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

		public Criteria andNotificationidIsNull() {
			addCriterion("notificationid is null");
			return this;
		}

		public Criteria andNotificationidIsNotNull() {
			addCriterion("notificationid is not null");
			return this;
		}

		public Criteria andNotificationidEqualTo(Integer value) {
			addCriterion("notificationid =", value, "notificationid");
			return this;
		}

		public Criteria andNotificationidNotEqualTo(Integer value) {
			addCriterion("notificationid <>", value, "notificationid");
			return this;
		}

		public Criteria andNotificationidGreaterThan(Integer value) {
			addCriterion("notificationid >", value, "notificationid");
			return this;
		}

		public Criteria andNotificationidGreaterThanOrEqualTo(Integer value) {
			addCriterion("notificationid >=", value, "notificationid");
			return this;
		}

		public Criteria andNotificationidLessThan(Integer value) {
			addCriterion("notificationid <", value, "notificationid");
			return this;
		}

		public Criteria andNotificationidLessThanOrEqualTo(Integer value) {
			addCriterion("notificationid <=", value, "notificationid");
			return this;
		}

		public Criteria andNotificationidIn(List values) {
			addCriterion("notificationid in", values, "notificationid");
			return this;
		}

		public Criteria andNotificationidNotIn(List values) {
			addCriterion("notificationid not in", values, "notificationid");
			return this;
		}

		public Criteria andNotificationidBetween(Integer value1, Integer value2) {
			addCriterion("notificationid between", value1, value2,
					"notificationid");
			return this;
		}

		public Criteria andNotificationidNotBetween(Integer value1,
				Integer value2) {
			addCriterion("notificationid not between", value1, value2,
					"notificationid");
			return this;
		}

		public Criteria andNotificationIsNull() {
			addCriterion("notification is null");
			return this;
		}

		public Criteria andNotificationIsNotNull() {
			addCriterion("notification is not null");
			return this;
		}

		public Criteria andNotificationEqualTo(String value) {
			addCriterion("notification =", value, "notification");
			return this;
		}

		public Criteria andNotificationNotEqualTo(String value) {
			addCriterion("notification <>", value, "notification");
			return this;
		}

		public Criteria andNotificationGreaterThan(String value) {
			addCriterion("notification >", value, "notification");
			return this;
		}

		public Criteria andNotificationGreaterThanOrEqualTo(String value) {
			addCriterion("notification >=", value, "notification");
			return this;
		}

		public Criteria andNotificationLessThan(String value) {
			addCriterion("notification <", value, "notification");
			return this;
		}

		public Criteria andNotificationLessThanOrEqualTo(String value) {
			addCriterion("notification <=", value, "notification");
			return this;
		}

		public Criteria andNotificationLike(String value) {
			addCriterion("notification like", value, "notification");
			return this;
		}

		public Criteria andNotificationNotLike(String value) {
			addCriterion("notification not like", value, "notification");
			return this;
		}

		public Criteria andNotificationIn(List values) {
			addCriterion("notification in", values, "notification");
			return this;
		}

		public Criteria andNotificationNotIn(List values) {
			addCriterion("notification not in", values, "notification");
			return this;
		}

		public Criteria andNotificationBetween(String value1, String value2) {
			addCriterion("notification between", value1, value2, "notification");
			return this;
		}

		public Criteria andNotificationNotBetween(String value1, String value2) {
			addCriterion("notification not between", value1, value2,
					"notification");
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
	}
}