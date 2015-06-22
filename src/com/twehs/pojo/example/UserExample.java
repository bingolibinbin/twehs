package com.twehs.pojo.example;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExample {

	protected String limitClauseStart;

	public void setLimitClauseStart(String limitClauseStart) {
		this.limitClauseStart = limitClauseStart;
	}

	protected String limitClauseCount;

	public void setLimitClauseCount(String limitClauseCount) {
		this.limitClauseCount = limitClauseCount;
	}

	protected String orderByClause;

	protected List oredCriteria;

	public UserExample() {
		oredCriteria = new ArrayList();
	}

	protected UserExample(UserExample example) {
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

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return this;
		}

		public Criteria andPasswordIn(List values) {
			addCriterion("password in", values, "password");
			return this;
		}

		public Criteria andPasswordNotIn(List values) {
			addCriterion("password not in", values, "password");
			return this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
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

		public Criteria andRoleidIsNull() {
			addCriterion("roleid is null");
			return this;
		}

		public Criteria andRoleidIsNotNull() {
			addCriterion("roleid is not null");
			return this;
		}

		public Criteria andRoleidEqualTo(Integer value) {
			addCriterion("roleid =", value, "roleid");
			return this;
		}

		public Criteria andRoleidNotEqualTo(Integer value) {
			addCriterion("roleid <>", value, "roleid");
			return this;
		}

		public Criteria andRoleidGreaterThan(Integer value) {
			addCriterion("roleid >", value, "roleid");
			return this;
		}

		public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
			addCriterion("roleid >=", value, "roleid");
			return this;
		}

		public Criteria andRoleidLessThan(Integer value) {
			addCriterion("roleid <", value, "roleid");
			return this;
		}

		public Criteria andRoleidLessThanOrEqualTo(Integer value) {
			addCriterion("roleid <=", value, "roleid");
			return this;
		}

		public Criteria andRoleidIn(List values) {
			addCriterion("roleid in", values, "roleid");
			return this;
		}

		public Criteria andRoleidNotIn(List values) {
			addCriterion("roleid not in", values, "roleid");
			return this;
		}

		public Criteria andRoleidBetween(Integer value1, Integer value2) {
			addCriterion("roleid between", value1, value2, "roleid");
			return this;
		}

		public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
			addCriterion("roleid not between", value1, value2, "roleid");
			return this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return this;
		}

		public Criteria andStateEqualTo(Integer value) {
			addCriterion("state =", value, "state");
			return this;
		}

		public Criteria andStateNotEqualTo(Integer value) {
			addCriterion("state <>", value, "state");
			return this;
		}

		public Criteria andStateGreaterThan(Integer value) {
			addCriterion("state >", value, "state");
			return this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("state >=", value, "state");
			return this;
		}

		public Criteria andStateLessThan(Integer value) {
			addCriterion("state <", value, "state");
			return this;
		}

		public Criteria andStateLessThanOrEqualTo(Integer value) {
			addCriterion("state <=", value, "state");
			return this;
		}

		public Criteria andStateIn(List values) {
			addCriterion("state in", values, "state");
			return this;
		}

		public Criteria andStateNotIn(List values) {
			addCriterion("state not in", values, "state");
			return this;
		}

		public Criteria andStateBetween(Integer value1, Integer value2) {
			addCriterion("state between", value1, value2, "state");
			return this;
		}

		public Criteria andStateNotBetween(Integer value1, Integer value2) {
			addCriterion("state not between", value1, value2, "state");
			return this;
		}

		public Criteria andBzIsNull() {
			addCriterion("bz is null");
			return this;
		}

		public Criteria andBzIsNotNull() {
			addCriterion("bz is not null");
			return this;
		}

		public Criteria andBzEqualTo(String value) {
			addCriterion("bz =", value, "bz");
			return this;
		}

		public Criteria andBzNotEqualTo(String value) {
			addCriterion("bz <>", value, "bz");
			return this;
		}

		public Criteria andBzGreaterThan(String value) {
			addCriterion("bz >", value, "bz");
			return this;
		}

		public Criteria andBzGreaterThanOrEqualTo(String value) {
			addCriterion("bz >=", value, "bz");
			return this;
		}

		public Criteria andBzLessThan(String value) {
			addCriterion("bz <", value, "bz");
			return this;
		}

		public Criteria andBzLessThanOrEqualTo(String value) {
			addCriterion("bz <=", value, "bz");
			return this;
		}

		public Criteria andBzLike(String value) {
			addCriterion("bz like", value, "bz");
			return this;
		}

		public Criteria andBzNotLike(String value) {
			addCriterion("bz not like", value, "bz");
			return this;
		}

		public Criteria andBzIn(List values) {
			addCriterion("bz in", values, "bz");
			return this;
		}

		public Criteria andBzNotIn(List values) {
			addCriterion("bz not in", values, "bz");
			return this;
		}

		public Criteria andBzBetween(String value1, String value2) {
			addCriterion("bz between", value1, value2, "bz");
			return this;
		}

		public Criteria andBzNotBetween(String value1, String value2) {
			addCriterion("bz not between", value1, value2, "bz");
			return this;
		}
	}
}