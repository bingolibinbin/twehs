package com.twehs.pojo.example;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentExample {

	protected String orderByClause;

	protected List oredCriteria;

	public ContentExample() {
		oredCriteria = new ArrayList();
	}

	protected ContentExample(ContentExample example) {
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

		public Criteria andToplineIsNull() {
			addCriterion("topline is null");
			return this;
		}

		public Criteria andToplineIsNotNull() {
			addCriterion("topline is not null");
			return this;
		}

		public Criteria andToplineEqualTo(Boolean value) {
			addCriterion("topline =", value, "topline");
			return this;
		}

		public Criteria andToplineNotEqualTo(Boolean value) {
			addCriterion("topline <>", value, "topline");
			return this;
		}

		public Criteria andToplineGreaterThan(Boolean value) {
			addCriterion("topline >", value, "topline");
			return this;
		}

		public Criteria andToplineGreaterThanOrEqualTo(Boolean value) {
			addCriterion("topline >=", value, "topline");
			return this;
		}

		public Criteria andToplineLessThan(Boolean value) {
			addCriterion("topline <", value, "topline");
			return this;
		}

		public Criteria andToplineLessThanOrEqualTo(Boolean value) {
			addCriterion("topline <=", value, "topline");
			return this;
		}

		public Criteria andToplineIn(List values) {
			addCriterion("topline in", values, "topline");
			return this;
		}

		public Criteria andToplineNotIn(List values) {
			addCriterion("topline not in", values, "topline");
			return this;
		}

		public Criteria andToplineBetween(Boolean value1, Boolean value2) {
			addCriterion("topline between", value1, value2, "topline");
			return this;
		}

		public Criteria andToplineNotBetween(Boolean value1, Boolean value2) {
			addCriterion("topline not between", value1, value2, "topline");
			return this;
		}

		public Criteria andRecommenderIsNull() {
			addCriterion("recommender is null");
			return this;
		}

		public Criteria andRecommenderIsNotNull() {
			addCriterion("recommender is not null");
			return this;
		}

		public Criteria andRecommenderEqualTo(Boolean value) {
			addCriterion("recommender =", value, "recommender");
			return this;
		}

		public Criteria andRecommenderNotEqualTo(Boolean value) {
			addCriterion("recommender <>", value, "recommender");
			return this;
		}

		public Criteria andRecommenderGreaterThan(Boolean value) {
			addCriterion("recommender >", value, "recommender");
			return this;
		}

		public Criteria andRecommenderGreaterThanOrEqualTo(Boolean value) {
			addCriterion("recommender >=", value, "recommender");
			return this;
		}

		public Criteria andRecommenderLessThan(Boolean value) {
			addCriterion("recommender <", value, "recommender");
			return this;
		}

		public Criteria andRecommenderLessThanOrEqualTo(Boolean value) {
			addCriterion("recommender <=", value, "recommender");
			return this;
		}

		public Criteria andRecommenderIn(List values) {
			addCriterion("recommender in", values, "recommender");
			return this;
		}

		public Criteria andRecommenderNotIn(List values) {
			addCriterion("recommender not in", values, "recommender");
			return this;
		}

		public Criteria andRecommenderBetween(Boolean value1, Boolean value2) {
			addCriterion("recommender between", value1, value2, "recommender");
			return this;
		}

		public Criteria andRecommenderNotBetween(Boolean value1, Boolean value2) {
			addCriterion("recommender not between", value1, value2,
					"recommender");
			return this;
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

		public Criteria andSourceIsNull() {
			addCriterion("source is null");
			return this;
		}

		public Criteria andSourceIsNotNull() {
			addCriterion("source is not null");
			return this;
		}

		public Criteria andSourceEqualTo(String value) {
			addCriterion("source =", value, "source");
			return this;
		}

		public Criteria andSourceNotEqualTo(String value) {
			addCriterion("source <>", value, "source");
			return this;
		}

		public Criteria andSourceGreaterThan(String value) {
			addCriterion("source >", value, "source");
			return this;
		}

		public Criteria andSourceGreaterThanOrEqualTo(String value) {
			addCriterion("source >=", value, "source");
			return this;
		}

		public Criteria andSourceLessThan(String value) {
			addCriterion("source <", value, "source");
			return this;
		}

		public Criteria andSourceLessThanOrEqualTo(String value) {
			addCriterion("source <=", value, "source");
			return this;
		}

		public Criteria andSourceLike(String value) {
			addCriterion("source like", value, "source");
			return this;
		}

		public Criteria andSourceNotLike(String value) {
			addCriterion("source not like", value, "source");
			return this;
		}

		public Criteria andSourceIn(List values) {
			addCriterion("source in", values, "source");
			return this;
		}

		public Criteria andSourceNotIn(List values) {
			addCriterion("source not in", values, "source");
			return this;
		}

		public Criteria andSourceBetween(String value1, String value2) {
			addCriterion("source between", value1, value2, "source");
			return this;
		}

		public Criteria andSourceNotBetween(String value1, String value2) {
			addCriterion("source not between", value1, value2, "source");
			return this;
		}

		public Criteria andAuthorIsNull() {
			addCriterion("author is null");
			return this;
		}

		public Criteria andAuthorIsNotNull() {
			addCriterion("author is not null");
			return this;
		}

		public Criteria andAuthorEqualTo(String value) {
			addCriterion("author =", value, "author");
			return this;
		}

		public Criteria andAuthorNotEqualTo(String value) {
			addCriterion("author <>", value, "author");
			return this;
		}

		public Criteria andAuthorGreaterThan(String value) {
			addCriterion("author >", value, "author");
			return this;
		}

		public Criteria andAuthorGreaterThanOrEqualTo(String value) {
			addCriterion("author >=", value, "author");
			return this;
		}

		public Criteria andAuthorLessThan(String value) {
			addCriterion("author <", value, "author");
			return this;
		}

		public Criteria andAuthorLessThanOrEqualTo(String value) {
			addCriterion("author <=", value, "author");
			return this;
		}

		public Criteria andAuthorLike(String value) {
			addCriterion("author like", value, "author");
			return this;
		}

		public Criteria andAuthorNotLike(String value) {
			addCriterion("author not like", value, "author");
			return this;
		}

		public Criteria andAuthorIn(List values) {
			addCriterion("author in", values, "author");
			return this;
		}

		public Criteria andAuthorNotIn(List values) {
			addCriterion("author not in", values, "author");
			return this;
		}

		public Criteria andAuthorBetween(String value1, String value2) {
			addCriterion("author between", value1, value2, "author");
			return this;
		}

		public Criteria andAuthorNotBetween(String value1, String value2) {
			addCriterion("author not between", value1, value2, "author");
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

		public Criteria andOrderIsNull() {
			addCriterion("order is null");
			return this;
		}

		public Criteria andOrderIsNotNull() {
			addCriterion("order is not null");
			return this;
		}

		public Criteria andOrderEqualTo(Integer value) {
			addCriterion("order =", value, "order");
			return this;
		}

		public Criteria andOrderNotEqualTo(Integer value) {
			addCriterion("order <>", value, "order");
			return this;
		}

		public Criteria andOrderGreaterThan(Integer value) {
			addCriterion("order >", value, "order");
			return this;
		}

		public Criteria andOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("order >=", value, "order");
			return this;
		}

		public Criteria andOrderLessThan(Integer value) {
			addCriterion("order <", value, "order");
			return this;
		}

		public Criteria andOrderLessThanOrEqualTo(Integer value) {
			addCriterion("order <=", value, "order");
			return this;
		}

		public Criteria andOrderIn(List values) {
			addCriterion("order in", values, "order");
			return this;
		}

		public Criteria andOrderNotIn(List values) {
			addCriterion("order not in", values, "order");
			return this;
		}

		public Criteria andOrderBetween(Integer value1, Integer value2) {
			addCriterion("order between", value1, value2, "order");
			return this;
		}

		public Criteria andOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("order not between", value1, value2, "order");
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

		public Criteria andSmallpicaddressIsNull() {
			addCriterion("smallpicaddress is null");
			return this;
		}

		public Criteria andSmallpicaddressIsNotNull() {
			addCriterion("smallpicaddress is not null");
			return this;
		}

		public Criteria andSmallpicaddressEqualTo(String value) {
			addCriterion("smallpicaddress =", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressNotEqualTo(String value) {
			addCriterion("smallpicaddress <>", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressGreaterThan(String value) {
			addCriterion("smallpicaddress >", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressGreaterThanOrEqualTo(String value) {
			addCriterion("smallpicaddress >=", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressLessThan(String value) {
			addCriterion("smallpicaddress <", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressLessThanOrEqualTo(String value) {
			addCriterion("smallpicaddress <=", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressLike(String value) {
			addCriterion("smallpicaddress like", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressNotLike(String value) {
			addCriterion("smallpicaddress not like", value, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressIn(List values) {
			addCriterion("smallpicaddress in", values, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressNotIn(List values) {
			addCriterion("smallpicaddress not in", values, "smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressBetween(String value1, String value2) {
			addCriterion("smallpicaddress between", value1, value2,
					"smallpicaddress");
			return this;
		}

		public Criteria andSmallpicaddressNotBetween(String value1,
				String value2) {
			addCriterion("smallpicaddress not between", value1, value2,
					"smallpicaddress");
			return this;
		}

		public Criteria andSmallpicnameIsNull() {
			addCriterion("smallpicname is null");
			return this;
		}

		public Criteria andSmallpicnameIsNotNull() {
			addCriterion("smallpicname is not null");
			return this;
		}

		public Criteria andSmallpicnameEqualTo(String value) {
			addCriterion("smallpicname =", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameNotEqualTo(String value) {
			addCriterion("smallpicname <>", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameGreaterThan(String value) {
			addCriterion("smallpicname >", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameGreaterThanOrEqualTo(String value) {
			addCriterion("smallpicname >=", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameLessThan(String value) {
			addCriterion("smallpicname <", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameLessThanOrEqualTo(String value) {
			addCriterion("smallpicname <=", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameLike(String value) {
			addCriterion("smallpicname like", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameNotLike(String value) {
			addCriterion("smallpicname not like", value, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameIn(List values) {
			addCriterion("smallpicname in", values, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameNotIn(List values) {
			addCriterion("smallpicname not in", values, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameBetween(String value1, String value2) {
			addCriterion("smallpicname between", value1, value2, "smallpicname");
			return this;
		}

		public Criteria andSmallpicnameNotBetween(String value1, String value2) {
			addCriterion("smallpicname not between", value1, value2,
					"smallpicname");
			return this;
		}

		public Criteria andSpecificationIsNull() {
			addCriterion("specification is null");
			return this;
		}

		public Criteria andSpecificationIsNotNull() {
			addCriterion("specification is not null");
			return this;
		}

		public Criteria andSpecificationEqualTo(String value) {
			addCriterion("specification =", value, "specification");
			return this;
		}

		public Criteria andSpecificationNotEqualTo(String value) {
			addCriterion("specification <>", value, "specification");
			return this;
		}

		public Criteria andSpecificationGreaterThan(String value) {
			addCriterion("specification >", value, "specification");
			return this;
		}

		public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
			addCriterion("specification >=", value, "specification");
			return this;
		}

		public Criteria andSpecificationLessThan(String value) {
			addCriterion("specification <", value, "specification");
			return this;
		}

		public Criteria andSpecificationLessThanOrEqualTo(String value) {
			addCriterion("specification <=", value, "specification");
			return this;
		}

		public Criteria andSpecificationLike(String value) {
			addCriterion("specification like", value, "specification");
			return this;
		}

		public Criteria andSpecificationNotLike(String value) {
			addCriterion("specification not like", value, "specification");
			return this;
		}

		public Criteria andSpecificationIn(List values) {
			addCriterion("specification in", values, "specification");
			return this;
		}

		public Criteria andSpecificationNotIn(List values) {
			addCriterion("specification not in", values, "specification");
			return this;
		}

		public Criteria andSpecificationBetween(String value1, String value2) {
			addCriterion("specification between", value1, value2,
					"specification");
			return this;
		}

		public Criteria andSpecificationNotBetween(String value1, String value2) {
			addCriterion("specification not between", value1, value2,
					"specification");
			return this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return this;
		}

		public Criteria andPriceEqualTo(BigDecimal value) {
			addCriterion("price =", value, "price");
			return this;
		}

		public Criteria andPriceNotEqualTo(BigDecimal value) {
			addCriterion("price <>", value, "price");
			return this;
		}

		public Criteria andPriceGreaterThan(BigDecimal value) {
			addCriterion("price >", value, "price");
			return this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("price >=", value, "price");
			return this;
		}

		public Criteria andPriceLessThan(BigDecimal value) {
			addCriterion("price <", value, "price");
			return this;
		}

		public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("price <=", value, "price");
			return this;
		}

		public Criteria andPriceIn(List values) {
			addCriterion("price in", values, "price");
			return this;
		}

		public Criteria andPriceNotIn(List values) {
			addCriterion("price not in", values, "price");
			return this;
		}

		public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price between", value1, value2, "price");
			return this;
		}

		public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("price not between", value1, value2, "price");
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