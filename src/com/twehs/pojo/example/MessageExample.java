package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageExample {

	protected String orderByClause;

	protected List oredCriteria;

	public MessageExample() {
		oredCriteria = new ArrayList();
	}

	protected MessageExample(MessageExample example) {
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

		public Criteria andMessageidIsNull() {
			addCriterion("messageid is null");
			return this;
		}

		public Criteria andMessageidIsNotNull() {
			addCriterion("messageid is not null");
			return this;
		}

		public Criteria andMessageidEqualTo(Integer value) {
			addCriterion("messageid =", value, "messageid");
			return this;
		}

		public Criteria andMessageidNotEqualTo(Integer value) {
			addCriterion("messageid <>", value, "messageid");
			return this;
		}

		public Criteria andMessageidGreaterThan(Integer value) {
			addCriterion("messageid >", value, "messageid");
			return this;
		}

		public Criteria andMessageidGreaterThanOrEqualTo(Integer value) {
			addCriterion("messageid >=", value, "messageid");
			return this;
		}

		public Criteria andMessageidLessThan(Integer value) {
			addCriterion("messageid <", value, "messageid");
			return this;
		}

		public Criteria andMessageidLessThanOrEqualTo(Integer value) {
			addCriterion("messageid <=", value, "messageid");
			return this;
		}

		public Criteria andMessageidIn(List values) {
			addCriterion("messageid in", values, "messageid");
			return this;
		}

		public Criteria andMessageidNotIn(List values) {
			addCriterion("messageid not in", values, "messageid");
			return this;
		}

		public Criteria andMessageidBetween(Integer value1, Integer value2) {
			addCriterion("messageid between", value1, value2, "messageid");
			return this;
		}

		public Criteria andMessageidNotBetween(Integer value1, Integer value2) {
			addCriterion("messageid not between", value1, value2, "messageid");
			return this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return this;
		}

		public Criteria andUsernameIn(List values) {
			addCriterion("username in", values, "username");
			return this;
		}

		public Criteria andUsernameNotIn(List values) {
			addCriterion("username not in", values, "username");
			return this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return this;
		}

		public Criteria andPhonenoIsNull() {
			addCriterion("phoneno is null");
			return this;
		}

		public Criteria andPhonenoIsNotNull() {
			addCriterion("phoneno is not null");
			return this;
		}

		public Criteria andPhonenoEqualTo(String value) {
			addCriterion("phoneno =", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoNotEqualTo(String value) {
			addCriterion("phoneno <>", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoGreaterThan(String value) {
			addCriterion("phoneno >", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoGreaterThanOrEqualTo(String value) {
			addCriterion("phoneno >=", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoLessThan(String value) {
			addCriterion("phoneno <", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoLessThanOrEqualTo(String value) {
			addCriterion("phoneno <=", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoLike(String value) {
			addCriterion("phoneno like", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoNotLike(String value) {
			addCriterion("phoneno not like", value, "phoneno");
			return this;
		}

		public Criteria andPhonenoIn(List values) {
			addCriterion("phoneno in", values, "phoneno");
			return this;
		}

		public Criteria andPhonenoNotIn(List values) {
			addCriterion("phoneno not in", values, "phoneno");
			return this;
		}

		public Criteria andPhonenoBetween(String value1, String value2) {
			addCriterion("phoneno between", value1, value2, "phoneno");
			return this;
		}

		public Criteria andPhonenoNotBetween(String value1, String value2) {
			addCriterion("phoneno not between", value1, value2, "phoneno");
			return this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return this;
		}

		public Criteria andAddressIn(List values) {
			addCriterion("address in", values, "address");
			return this;
		}

		public Criteria andAddressNotIn(List values) {
			addCriterion("address not in", values, "address");
			return this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
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

		public Criteria andMessagecontentIsNull() {
			addCriterion("messagecontent is null");
			return this;
		}

		public Criteria andMessagecontentIsNotNull() {
			addCriterion("messagecontent is not null");
			return this;
		}

		public Criteria andMessagecontentEqualTo(String value) {
			addCriterion("messagecontent =", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentNotEqualTo(String value) {
			addCriterion("messagecontent <>", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentGreaterThan(String value) {
			addCriterion("messagecontent >", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentGreaterThanOrEqualTo(String value) {
			addCriterion("messagecontent >=", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentLessThan(String value) {
			addCriterion("messagecontent <", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentLessThanOrEqualTo(String value) {
			addCriterion("messagecontent <=", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentLike(String value) {
			addCriterion("messagecontent like", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentNotLike(String value) {
			addCriterion("messagecontent not like", value, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentIn(List values) {
			addCriterion("messagecontent in", values, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentNotIn(List values) {
			addCriterion("messagecontent not in", values, "messagecontent");
			return this;
		}

		public Criteria andMessagecontentBetween(String value1, String value2) {
			addCriterion("messagecontent between", value1, value2,
					"messagecontent");
			return this;
		}

		public Criteria andMessagecontentNotBetween(String value1, String value2) {
			addCriterion("messagecontent not between", value1, value2,
					"messagecontent");
			return this;
		}
	}
}