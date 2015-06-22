package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeExample {

	protected String orderByClause;

	protected List oredCriteria;

	public TypeExample() {
		oredCriteria = new ArrayList();
	}

	protected TypeExample(TypeExample example) {
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

		public Criteria andTypeidIsNull() {
			addCriterion("typeid is null");
			return this;
		}

		public Criteria andTypeidIsNotNull() {
			addCriterion("typeid is not null");
			return this;
		}

		public Criteria andTypeidEqualTo(Integer value) {
			addCriterion("typeid =", value, "typeid");
			return this;
		}

		public Criteria andTypeidNotEqualTo(Integer value) {
			addCriterion("typeid <>", value, "typeid");
			return this;
		}

		public Criteria andTypeidGreaterThan(Integer value) {
			addCriterion("typeid >", value, "typeid");
			return this;
		}

		public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
			addCriterion("typeid >=", value, "typeid");
			return this;
		}

		public Criteria andTypeidLessThan(Integer value) {
			addCriterion("typeid <", value, "typeid");
			return this;
		}

		public Criteria andTypeidLessThanOrEqualTo(Integer value) {
			addCriterion("typeid <=", value, "typeid");
			return this;
		}

		public Criteria andTypeidIn(List values) {
			addCriterion("typeid in", values, "typeid");
			return this;
		}

		public Criteria andTypeidNotIn(List values) {
			addCriterion("typeid not in", values, "typeid");
			return this;
		}

		public Criteria andTypeidBetween(Integer value1, Integer value2) {
			addCriterion("typeid between", value1, value2, "typeid");
			return this;
		}

		public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
			addCriterion("typeid not between", value1, value2, "typeid");
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

		public Criteria andTypenameIsNull() {
			addCriterion("typename is null");
			return this;
		}

		public Criteria andTypenameIsNotNull() {
			addCriterion("typename is not null");
			return this;
		}

		public Criteria andTypenameEqualTo(String value) {
			addCriterion("typename =", value, "typename");
			return this;
		}

		public Criteria andTypenameNotEqualTo(String value) {
			addCriterion("typename <>", value, "typename");
			return this;
		}

		public Criteria andTypenameGreaterThan(String value) {
			addCriterion("typename >", value, "typename");
			return this;
		}

		public Criteria andTypenameGreaterThanOrEqualTo(String value) {
			addCriterion("typename >=", value, "typename");
			return this;
		}

		public Criteria andTypenameLessThan(String value) {
			addCriterion("typename <", value, "typename");
			return this;
		}

		public Criteria andTypenameLessThanOrEqualTo(String value) {
			addCriterion("typename <=", value, "typename");
			return this;
		}

		public Criteria andTypenameLike(String value) {
			addCriterion("typename like", value, "typename");
			return this;
		}

		public Criteria andTypenameNotLike(String value) {
			addCriterion("typename not like", value, "typename");
			return this;
		}

		public Criteria andTypenameIn(List values) {
			addCriterion("typename in", values, "typename");
			return this;
		}

		public Criteria andTypenameNotIn(List values) {
			addCriterion("typename not in", values, "typename");
			return this;
		}

		public Criteria andTypenameBetween(String value1, String value2) {
			addCriterion("typename between", value1, value2, "typename");
			return this;
		}

		public Criteria andTypenameNotBetween(String value1, String value2) {
			addCriterion("typename not between", value1, value2, "typename");
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