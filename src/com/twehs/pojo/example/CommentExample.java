package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentExample {

	protected String orderByClause;

	protected List oredCriteria;

	public CommentExample() {
		oredCriteria = new ArrayList();
	}

	protected CommentExample(CommentExample example) {
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

		public Criteria andCommentidIsNull() {
			addCriterion("commentid is null");
			return this;
		}

		public Criteria andCommentidIsNotNull() {
			addCriterion("commentid is not null");
			return this;
		}

		public Criteria andCommentidEqualTo(Integer value) {
			addCriterion("commentid =", value, "commentid");
			return this;
		}

		public Criteria andCommentidNotEqualTo(Integer value) {
			addCriterion("commentid <>", value, "commentid");
			return this;
		}

		public Criteria andCommentidGreaterThan(Integer value) {
			addCriterion("commentid >", value, "commentid");
			return this;
		}

		public Criteria andCommentidGreaterThanOrEqualTo(Integer value) {
			addCriterion("commentid >=", value, "commentid");
			return this;
		}

		public Criteria andCommentidLessThan(Integer value) {
			addCriterion("commentid <", value, "commentid");
			return this;
		}

		public Criteria andCommentidLessThanOrEqualTo(Integer value) {
			addCriterion("commentid <=", value, "commentid");
			return this;
		}

		public Criteria andCommentidIn(List values) {
			addCriterion("commentid in", values, "commentid");
			return this;
		}

		public Criteria andCommentidNotIn(List values) {
			addCriterion("commentid not in", values, "commentid");
			return this;
		}

		public Criteria andCommentidBetween(Integer value1, Integer value2) {
			addCriterion("commentid between", value1, value2, "commentid");
			return this;
		}

		public Criteria andCommentidNotBetween(Integer value1, Integer value2) {
			addCriterion("commentid not between", value1, value2, "commentid");
			return this;
		}

		public Criteria andContentidIsNull() {
			addCriterion("contentid is null");
			return this;
		}

		public Criteria andContentidIsNotNull() {
			addCriterion("contentid is not null");
			return this;
		}

		public Criteria andContentidEqualTo(Integer value) {
			addCriterion("contentid =", value, "contentid");
			return this;
		}

		public Criteria andContentidNotEqualTo(Integer value) {
			addCriterion("contentid <>", value, "contentid");
			return this;
		}

		public Criteria andContentidGreaterThan(Integer value) {
			addCriterion("contentid >", value, "contentid");
			return this;
		}

		public Criteria andContentidGreaterThanOrEqualTo(Integer value) {
			addCriterion("contentid >=", value, "contentid");
			return this;
		}

		public Criteria andContentidLessThan(Integer value) {
			addCriterion("contentid <", value, "contentid");
			return this;
		}

		public Criteria andContentidLessThanOrEqualTo(Integer value) {
			addCriterion("contentid <=", value, "contentid");
			return this;
		}

		public Criteria andContentidIn(List values) {
			addCriterion("contentid in", values, "contentid");
			return this;
		}

		public Criteria andContentidNotIn(List values) {
			addCriterion("contentid not in", values, "contentid");
			return this;
		}

		public Criteria andContentidBetween(Integer value1, Integer value2) {
			addCriterion("contentid between", value1, value2, "contentid");
			return this;
		}

		public Criteria andContentidNotBetween(Integer value1, Integer value2) {
			addCriterion("contentid not between", value1, value2, "contentid");
			return this;
		}

		public Criteria andCommentscontentIsNull() {
			addCriterion("commentscontent is null");
			return this;
		}

		public Criteria andCommentscontentIsNotNull() {
			addCriterion("commentscontent is not null");
			return this;
		}

		public Criteria andCommentscontentEqualTo(String value) {
			addCriterion("commentscontent =", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentNotEqualTo(String value) {
			addCriterion("commentscontent <>", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentGreaterThan(String value) {
			addCriterion("commentscontent >", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentGreaterThanOrEqualTo(String value) {
			addCriterion("commentscontent >=", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentLessThan(String value) {
			addCriterion("commentscontent <", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentLessThanOrEqualTo(String value) {
			addCriterion("commentscontent <=", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentLike(String value) {
			addCriterion("commentscontent like", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentNotLike(String value) {
			addCriterion("commentscontent not like", value, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentIn(List values) {
			addCriterion("commentscontent in", values, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentNotIn(List values) {
			addCriterion("commentscontent not in", values, "commentscontent");
			return this;
		}

		public Criteria andCommentscontentBetween(String value1, String value2) {
			addCriterion("commentscontent between", value1, value2,
					"commentscontent");
			return this;
		}

		public Criteria andCommentscontentNotBetween(String value1,
				String value2) {
			addCriterion("commentscontent not between", value1, value2,
					"commentscontent");
			return this;
		}

		public Criteria andCommentorIsNull() {
			addCriterion("commentor is null");
			return this;
		}

		public Criteria andCommentorIsNotNull() {
			addCriterion("commentor is not null");
			return this;
		}

		public Criteria andCommentorEqualTo(String value) {
			addCriterion("commentor =", value, "commentor");
			return this;
		}

		public Criteria andCommentorNotEqualTo(String value) {
			addCriterion("commentor <>", value, "commentor");
			return this;
		}

		public Criteria andCommentorGreaterThan(String value) {
			addCriterion("commentor >", value, "commentor");
			return this;
		}

		public Criteria andCommentorGreaterThanOrEqualTo(String value) {
			addCriterion("commentor >=", value, "commentor");
			return this;
		}

		public Criteria andCommentorLessThan(String value) {
			addCriterion("commentor <", value, "commentor");
			return this;
		}

		public Criteria andCommentorLessThanOrEqualTo(String value) {
			addCriterion("commentor <=", value, "commentor");
			return this;
		}

		public Criteria andCommentorLike(String value) {
			addCriterion("commentor like", value, "commentor");
			return this;
		}

		public Criteria andCommentorNotLike(String value) {
			addCriterion("commentor not like", value, "commentor");
			return this;
		}

		public Criteria andCommentorIn(List values) {
			addCriterion("commentor in", values, "commentor");
			return this;
		}

		public Criteria andCommentorNotIn(List values) {
			addCriterion("commentor not in", values, "commentor");
			return this;
		}

		public Criteria andCommentorBetween(String value1, String value2) {
			addCriterion("commentor between", value1, value2, "commentor");
			return this;
		}

		public Criteria andCommentorNotBetween(String value1, String value2) {
			addCriterion("commentor not between", value1, value2, "commentor");
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

		public Criteria andCheckIsNull() {
			addCriterion("check is null");
			return this;
		}

		public Criteria andCheckIsNotNull() {
			addCriterion("check is not null");
			return this;
		}

		public Criteria andCheckEqualTo(Boolean value) {
			addCriterion("check =", value, "check");
			return this;
		}

		public Criteria andCheckNotEqualTo(Boolean value) {
			addCriterion("check <>", value, "check");
			return this;
		}

		public Criteria andCheckGreaterThan(Boolean value) {
			addCriterion("check >", value, "check");
			return this;
		}

		public Criteria andCheckGreaterThanOrEqualTo(Boolean value) {
			addCriterion("check >=", value, "check");
			return this;
		}

		public Criteria andCheckLessThan(Boolean value) {
			addCriterion("check <", value, "check");
			return this;
		}

		public Criteria andCheckLessThanOrEqualTo(Boolean value) {
			addCriterion("check <=", value, "check");
			return this;
		}

		public Criteria andCheckIn(List values) {
			addCriterion("check in", values, "check");
			return this;
		}

		public Criteria andCheckNotIn(List values) {
			addCriterion("check not in", values, "check");
			return this;
		}

		public Criteria andCheckBetween(Boolean value1, Boolean value2) {
			addCriterion("check between", value1, value2, "check");
			return this;
		}

		public Criteria andCheckNotBetween(Boolean value1, Boolean value2) {
			addCriterion("check not between", value1, value2, "check");
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