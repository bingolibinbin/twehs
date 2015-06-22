package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleMenuExample {

	protected String orderByClause;

	protected List oredCriteria;

	public RoleMenuExample() {
		oredCriteria = new ArrayList();
	}

	protected RoleMenuExample(RoleMenuExample example) {
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
	}
}