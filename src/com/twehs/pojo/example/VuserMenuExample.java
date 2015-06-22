package com.twehs.pojo.example;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VuserMenuExample {

	protected String orderByClause;

	protected List oredCriteria;

	public VuserMenuExample() {
		oredCriteria = new ArrayList();
	}

	protected VuserMenuExample(VuserMenuExample example) {
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

		public Criteria andUseridIsNull() {
			addCriterion("userid is null");
			return this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userid is not null");
			return this;
		}

		public Criteria andUseridEqualTo(Integer value) {
			addCriterion("userid =", value, "userid");
			return this;
		}

		public Criteria andUseridNotEqualTo(Integer value) {
			addCriterion("userid <>", value, "userid");
			return this;
		}

		public Criteria andUseridGreaterThan(Integer value) {
			addCriterion("userid >", value, "userid");
			return this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("userid >=", value, "userid");
			return this;
		}

		public Criteria andUseridLessThan(Integer value) {
			addCriterion("userid <", value, "userid");
			return this;
		}

		public Criteria andUseridLessThanOrEqualTo(Integer value) {
			addCriterion("userid <=", value, "userid");
			return this;
		}

		public Criteria andUseridIn(List values) {
			addCriterion("userid in", values, "userid");
			return this;
		}

		public Criteria andUseridNotIn(List values) {
			addCriterion("userid not in", values, "userid");
			return this;
		}

		public Criteria andUseridBetween(Integer value1, Integer value2) {
			addCriterion("userid between", value1, value2, "userid");
			return this;
		}

		public Criteria andUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("userid not between", value1, value2, "userid");
			return this;
		}

		public Criteria andLogincodeIsNull() {
			addCriterion("logincode is null");
			return this;
		}

		public Criteria andLogincodeIsNotNull() {
			addCriterion("logincode is not null");
			return this;
		}

		public Criteria andLogincodeEqualTo(String value) {
			addCriterion("logincode =", value, "logincode");
			return this;
		}

		public Criteria andLogincodeNotEqualTo(String value) {
			addCriterion("logincode <>", value, "logincode");
			return this;
		}

		public Criteria andLogincodeGreaterThan(String value) {
			addCriterion("logincode >", value, "logincode");
			return this;
		}

		public Criteria andLogincodeGreaterThanOrEqualTo(String value) {
			addCriterion("logincode >=", value, "logincode");
			return this;
		}

		public Criteria andLogincodeLessThan(String value) {
			addCriterion("logincode <", value, "logincode");
			return this;
		}

		public Criteria andLogincodeLessThanOrEqualTo(String value) {
			addCriterion("logincode <=", value, "logincode");
			return this;
		}

		public Criteria andLogincodeLike(String value) {
			addCriterion("logincode like", value, "logincode");
			return this;
		}

		public Criteria andLogincodeNotLike(String value) {
			addCriterion("logincode not like", value, "logincode");
			return this;
		}

		public Criteria andLogincodeIn(List values) {
			addCriterion("logincode in", values, "logincode");
			return this;
		}

		public Criteria andLogincodeNotIn(List values) {
			addCriterion("logincode not in", values, "logincode");
			return this;
		}

		public Criteria andLogincodeBetween(String value1, String value2) {
			addCriterion("logincode between", value1, value2, "logincode");
			return this;
		}

		public Criteria andLogincodeNotBetween(String value1, String value2) {
			addCriterion("logincode not between", value1, value2, "logincode");
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

		public Criteria andMenuidIsNull() {
			addCriterion("menuid is null");
			return this;
		}

		public Criteria andMenuidIsNotNull() {
			addCriterion("menuid is not null");
			return this;
		}

		public Criteria andMenuidEqualTo(Integer value) {
			addCriterion("menuid =", value, "menuid");
			return this;
		}

		public Criteria andMenuidNotEqualTo(Integer value) {
			addCriterion("menuid <>", value, "menuid");
			return this;
		}

		public Criteria andMenuidGreaterThan(Integer value) {
			addCriterion("menuid >", value, "menuid");
			return this;
		}

		public Criteria andMenuidGreaterThanOrEqualTo(Integer value) {
			addCriterion("menuid >=", value, "menuid");
			return this;
		}

		public Criteria andMenuidLessThan(Integer value) {
			addCriterion("menuid <", value, "menuid");
			return this;
		}

		public Criteria andMenuidLessThanOrEqualTo(Integer value) {
			addCriterion("menuid <=", value, "menuid");
			return this;
		}

		public Criteria andMenuidIn(List values) {
			addCriterion("menuid in", values, "menuid");
			return this;
		}

		public Criteria andMenuidNotIn(List values) {
			addCriterion("menuid not in", values, "menuid");
			return this;
		}

		public Criteria andMenuidBetween(Integer value1, Integer value2) {
			addCriterion("menuid between", value1, value2, "menuid");
			return this;
		}

		public Criteria andMenuidNotBetween(Integer value1, Integer value2) {
			addCriterion("menuid not between", value1, value2, "menuid");
			return this;
		}

		public Criteria andMenunameIsNull() {
			addCriterion("menuname is null");
			return this;
		}

		public Criteria andMenunameIsNotNull() {
			addCriterion("menuname is not null");
			return this;
		}

		public Criteria andMenunameEqualTo(String value) {
			addCriterion("menuname =", value, "menuname");
			return this;
		}

		public Criteria andMenunameNotEqualTo(String value) {
			addCriterion("menuname <>", value, "menuname");
			return this;
		}

		public Criteria andMenunameGreaterThan(String value) {
			addCriterion("menuname >", value, "menuname");
			return this;
		}

		public Criteria andMenunameGreaterThanOrEqualTo(String value) {
			addCriterion("menuname >=", value, "menuname");
			return this;
		}

		public Criteria andMenunameLessThan(String value) {
			addCriterion("menuname <", value, "menuname");
			return this;
		}

		public Criteria andMenunameLessThanOrEqualTo(String value) {
			addCriterion("menuname <=", value, "menuname");
			return this;
		}

		public Criteria andMenunameLike(String value) {
			addCriterion("menuname like", value, "menuname");
			return this;
		}

		public Criteria andMenunameNotLike(String value) {
			addCriterion("menuname not like", value, "menuname");
			return this;
		}

		public Criteria andMenunameIn(List values) {
			addCriterion("menuname in", values, "menuname");
			return this;
		}

		public Criteria andMenunameNotIn(List values) {
			addCriterion("menuname not in", values, "menuname");
			return this;
		}

		public Criteria andMenunameBetween(String value1, String value2) {
			addCriterion("menuname between", value1, value2, "menuname");
			return this;
		}

		public Criteria andMenunameNotBetween(String value1, String value2) {
			addCriterion("menuname not between", value1, value2, "menuname");
			return this;
		}

		public Criteria andPidIsNull() {
			addCriterion("pid is null");
			return this;
		}

		public Criteria andPidIsNotNull() {
			addCriterion("pid is not null");
			return this;
		}

		public Criteria andPidEqualTo(Integer value) {
			addCriterion("pid =", value, "pid");
			return this;
		}

		public Criteria andPidNotEqualTo(Integer value) {
			addCriterion("pid <>", value, "pid");
			return this;
		}

		public Criteria andPidGreaterThan(Integer value) {
			addCriterion("pid >", value, "pid");
			return this;
		}

		public Criteria andPidGreaterThanOrEqualTo(Integer value) {
			addCriterion("pid >=", value, "pid");
			return this;
		}

		public Criteria andPidLessThan(Integer value) {
			addCriterion("pid <", value, "pid");
			return this;
		}

		public Criteria andPidLessThanOrEqualTo(Integer value) {
			addCriterion("pid <=", value, "pid");
			return this;
		}

		public Criteria andPidIn(List values) {
			addCriterion("pid in", values, "pid");
			return this;
		}

		public Criteria andPidNotIn(List values) {
			addCriterion("pid not in", values, "pid");
			return this;
		}

		public Criteria andPidBetween(Integer value1, Integer value2) {
			addCriterion("pid between", value1, value2, "pid");
			return this;
		}

		public Criteria andPidNotBetween(Integer value1, Integer value2) {
			addCriterion("pid not between", value1, value2, "pid");
			return this;
		}

		public Criteria andMenuurlIsNull() {
			addCriterion("menuurl is null");
			return this;
		}

		public Criteria andMenuurlIsNotNull() {
			addCriterion("menuurl is not null");
			return this;
		}

		public Criteria andMenuurlEqualTo(String value) {
			addCriterion("menuurl =", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlNotEqualTo(String value) {
			addCriterion("menuurl <>", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlGreaterThan(String value) {
			addCriterion("menuurl >", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlGreaterThanOrEqualTo(String value) {
			addCriterion("menuurl >=", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlLessThan(String value) {
			addCriterion("menuurl <", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlLessThanOrEqualTo(String value) {
			addCriterion("menuurl <=", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlLike(String value) {
			addCriterion("menuurl like", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlNotLike(String value) {
			addCriterion("menuurl not like", value, "menuurl");
			return this;
		}

		public Criteria andMenuurlIn(List values) {
			addCriterion("menuurl in", values, "menuurl");
			return this;
		}

		public Criteria andMenuurlNotIn(List values) {
			addCriterion("menuurl not in", values, "menuurl");
			return this;
		}

		public Criteria andMenuurlBetween(String value1, String value2) {
			addCriterion("menuurl between", value1, value2, "menuurl");
			return this;
		}

		public Criteria andMenuurlNotBetween(String value1, String value2) {
			addCriterion("menuurl not between", value1, value2, "menuurl");
			return this;
		}

		public Criteria andMenutypeIsNull() {
			addCriterion("menutype is null");
			return this;
		}

		public Criteria andMenutypeIsNotNull() {
			addCriterion("menutype is not null");
			return this;
		}

		public Criteria andMenutypeEqualTo(Integer value) {
			addCriterion("menutype =", value, "menutype");
			return this;
		}

		public Criteria andMenutypeNotEqualTo(Integer value) {
			addCriterion("menutype <>", value, "menutype");
			return this;
		}

		public Criteria andMenutypeGreaterThan(Integer value) {
			addCriterion("menutype >", value, "menutype");
			return this;
		}

		public Criteria andMenutypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("menutype >=", value, "menutype");
			return this;
		}

		public Criteria andMenutypeLessThan(Integer value) {
			addCriterion("menutype <", value, "menutype");
			return this;
		}

		public Criteria andMenutypeLessThanOrEqualTo(Integer value) {
			addCriterion("menutype <=", value, "menutype");
			return this;
		}

		public Criteria andMenutypeIn(List values) {
			addCriterion("menutype in", values, "menutype");
			return this;
		}

		public Criteria andMenutypeNotIn(List values) {
			addCriterion("menutype not in", values, "menutype");
			return this;
		}

		public Criteria andMenutypeBetween(Integer value1, Integer value2) {
			addCriterion("menutype between", value1, value2, "menutype");
			return this;
		}

		public Criteria andMenutypeNotBetween(Integer value1, Integer value2) {
			addCriterion("menutype not between", value1, value2, "menutype");
			return this;
		}

		public Criteria andOrdernumIsNull() {
			addCriterion("ordernum is null");
			return this;
		}

		public Criteria andOrdernumIsNotNull() {
			addCriterion("ordernum is not null");
			return this;
		}

		public Criteria andOrdernumEqualTo(Integer value) {
			addCriterion("ordernum =", value, "ordernum");
			return this;
		}

		public Criteria andOrdernumNotEqualTo(Integer value) {
			addCriterion("ordernum <>", value, "ordernum");
			return this;
		}

		public Criteria andOrdernumGreaterThan(Integer value) {
			addCriterion("ordernum >", value, "ordernum");
			return this;
		}

		public Criteria andOrdernumGreaterThanOrEqualTo(Integer value) {
			addCriterion("ordernum >=", value, "ordernum");
			return this;
		}

		public Criteria andOrdernumLessThan(Integer value) {
			addCriterion("ordernum <", value, "ordernum");
			return this;
		}

		public Criteria andOrdernumLessThanOrEqualTo(Integer value) {
			addCriterion("ordernum <=", value, "ordernum");
			return this;
		}

		public Criteria andOrdernumIn(List values) {
			addCriterion("ordernum in", values, "ordernum");
			return this;
		}

		public Criteria andOrdernumNotIn(List values) {
			addCriterion("ordernum not in", values, "ordernum");
			return this;
		}

		public Criteria andOrdernumBetween(Integer value1, Integer value2) {
			addCriterion("ordernum between", value1, value2, "ordernum");
			return this;
		}

		public Criteria andOrdernumNotBetween(Integer value1, Integer value2) {
			addCriterion("ordernum not between", value1, value2, "ordernum");
			return this;
		}

		public Criteria andIconIsNull() {
			addCriterion("icon is null");
			return this;
		}

		public Criteria andIconIsNotNull() {
			addCriterion("icon is not null");
			return this;
		}

		public Criteria andIconEqualTo(String value) {
			addCriterion("icon =", value, "icon");
			return this;
		}

		public Criteria andIconNotEqualTo(String value) {
			addCriterion("icon <>", value, "icon");
			return this;
		}

		public Criteria andIconGreaterThan(String value) {
			addCriterion("icon >", value, "icon");
			return this;
		}

		public Criteria andIconGreaterThanOrEqualTo(String value) {
			addCriterion("icon >=", value, "icon");
			return this;
		}

		public Criteria andIconLessThan(String value) {
			addCriterion("icon <", value, "icon");
			return this;
		}

		public Criteria andIconLessThanOrEqualTo(String value) {
			addCriterion("icon <=", value, "icon");
			return this;
		}

		public Criteria andIconLike(String value) {
			addCriterion("icon like", value, "icon");
			return this;
		}

		public Criteria andIconNotLike(String value) {
			addCriterion("icon not like", value, "icon");
			return this;
		}

		public Criteria andIconIn(List values) {
			addCriterion("icon in", values, "icon");
			return this;
		}

		public Criteria andIconNotIn(List values) {
			addCriterion("icon not in", values, "icon");
			return this;
		}

		public Criteria andIconBetween(String value1, String value2) {
			addCriterion("icon between", value1, value2, "icon");
			return this;
		}

		public Criteria andIconNotBetween(String value1, String value2) {
			addCriterion("icon not between", value1, value2, "icon");
			return this;
		}
	}
}