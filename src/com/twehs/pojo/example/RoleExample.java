package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleExample {

	// 加上支持分页的代码
	protected String limitClauseStart;
	protected String limitClauseCount;

	public void setLimitClauseStart(String limitClauseStart) {
		this.limitClauseStart = limitClauseStart;
	}

	public void setLimitClauseCount(String limitClauseCount) {
		this.limitClauseCount = limitClauseCount;
	}

	protected String orderByClause;

	protected List oredCriteria;

	public RoleExample() {
		oredCriteria = new ArrayList();
	}

	protected RoleExample(RoleExample example) {
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

		public Criteria andRolenameIsNull() {
			addCriterion("rolename is null");
			return this;
		}

		public Criteria andRolenameIsNotNull() {
			addCriterion("rolename is not null");
			return this;
		}

		public Criteria andRolenameEqualTo(String value) {
			addCriterion("rolename =", value, "rolename");
			return this;
		}

		public Criteria andRolenameNotEqualTo(String value) {
			addCriterion("rolename <>", value, "rolename");
			return this;
		}

		public Criteria andRolenameGreaterThan(String value) {
			addCriterion("rolename >", value, "rolename");
			return this;
		}

		public Criteria andRolenameGreaterThanOrEqualTo(String value) {
			addCriterion("rolename >=", value, "rolename");
			return this;
		}

		public Criteria andRolenameLessThan(String value) {
			addCriterion("rolename <", value, "rolename");
			return this;
		}

		public Criteria andRolenameLessThanOrEqualTo(String value) {
			addCriterion("rolename <=", value, "rolename");
			return this;
		}

		public Criteria andRolenameLike(String value) {
			addCriterion("rolename like", value, "rolename");
			return this;
		}

		public Criteria andRolenameNotLike(String value) {
			addCriterion("rolename not like", value, "rolename");
			return this;
		}

		public Criteria andRolenameIn(List values) {
			addCriterion("rolename in", values, "rolename");
			return this;
		}

		public Criteria andRolenameNotIn(List values) {
			addCriterion("rolename not in", values, "rolename");
			return this;
		}

		public Criteria andRolenameBetween(String value1, String value2) {
			addCriterion("rolename between", value1, value2, "rolename");
			return this;
		}

		public Criteria andRolenameNotBetween(String value1, String value2) {
			addCriterion("rolename not between", value1, value2, "rolename");
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