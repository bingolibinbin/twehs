package com.twehs.pojo.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyExample {

	protected String orderByClause;

	protected List oredCriteria;

	public CompanyExample() {
		oredCriteria = new ArrayList();
	}

	protected CompanyExample(CompanyExample example) {
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

		public Criteria andCompanyidIsNull() {
			addCriterion("companyid is null");
			return this;
		}

		public Criteria andCompanyidIsNotNull() {
			addCriterion("companyid is not null");
			return this;
		}

		public Criteria andCompanyidEqualTo(Integer value) {
			addCriterion("companyid =", value, "companyid");
			return this;
		}

		public Criteria andCompanyidNotEqualTo(Integer value) {
			addCriterion("companyid <>", value, "companyid");
			return this;
		}

		public Criteria andCompanyidGreaterThan(Integer value) {
			addCriterion("companyid >", value, "companyid");
			return this;
		}

		public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
			addCriterion("companyid >=", value, "companyid");
			return this;
		}

		public Criteria andCompanyidLessThan(Integer value) {
			addCriterion("companyid <", value, "companyid");
			return this;
		}

		public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
			addCriterion("companyid <=", value, "companyid");
			return this;
		}

		public Criteria andCompanyidIn(List values) {
			addCriterion("companyid in", values, "companyid");
			return this;
		}

		public Criteria andCompanyidNotIn(List values) {
			addCriterion("companyid not in", values, "companyid");
			return this;
		}

		public Criteria andCompanyidBetween(Integer value1, Integer value2) {
			addCriterion("companyid between", value1, value2, "companyid");
			return this;
		}

		public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
			addCriterion("companyid not between", value1, value2, "companyid");
			return this;
		}

		public Criteria andCompanynameIsNull() {
			addCriterion("companyname is null");
			return this;
		}

		public Criteria andCompanynameIsNotNull() {
			addCriterion("companyname is not null");
			return this;
		}

		public Criteria andCompanynameEqualTo(String value) {
			addCriterion("companyname =", value, "companyname");
			return this;
		}

		public Criteria andCompanynameNotEqualTo(String value) {
			addCriterion("companyname <>", value, "companyname");
			return this;
		}

		public Criteria andCompanynameGreaterThan(String value) {
			addCriterion("companyname >", value, "companyname");
			return this;
		}

		public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
			addCriterion("companyname >=", value, "companyname");
			return this;
		}

		public Criteria andCompanynameLessThan(String value) {
			addCriterion("companyname <", value, "companyname");
			return this;
		}

		public Criteria andCompanynameLessThanOrEqualTo(String value) {
			addCriterion("companyname <=", value, "companyname");
			return this;
		}

		public Criteria andCompanynameLike(String value) {
			addCriterion("companyname like", value, "companyname");
			return this;
		}

		public Criteria andCompanynameNotLike(String value) {
			addCriterion("companyname not like", value, "companyname");
			return this;
		}

		public Criteria andCompanynameIn(List values) {
			addCriterion("companyname in", values, "companyname");
			return this;
		}

		public Criteria andCompanynameNotIn(List values) {
			addCriterion("companyname not in", values, "companyname");
			return this;
		}

		public Criteria andCompanynameBetween(String value1, String value2) {
			addCriterion("companyname between", value1, value2, "companyname");
			return this;
		}

		public Criteria andCompanynameNotBetween(String value1, String value2) {
			addCriterion("companyname not between", value1, value2,
					"companyname");
			return this;
		}

		public Criteria andProfessionIsNull() {
			addCriterion("profession is null");
			return this;
		}

		public Criteria andProfessionIsNotNull() {
			addCriterion("profession is not null");
			return this;
		}

		public Criteria andProfessionEqualTo(String value) {
			addCriterion("profession =", value, "profession");
			return this;
		}

		public Criteria andProfessionNotEqualTo(String value) {
			addCriterion("profession <>", value, "profession");
			return this;
		}

		public Criteria andProfessionGreaterThan(String value) {
			addCriterion("profession >", value, "profession");
			return this;
		}

		public Criteria andProfessionGreaterThanOrEqualTo(String value) {
			addCriterion("profession >=", value, "profession");
			return this;
		}

		public Criteria andProfessionLessThan(String value) {
			addCriterion("profession <", value, "profession");
			return this;
		}

		public Criteria andProfessionLessThanOrEqualTo(String value) {
			addCriterion("profession <=", value, "profession");
			return this;
		}

		public Criteria andProfessionLike(String value) {
			addCriterion("profession like", value, "profession");
			return this;
		}

		public Criteria andProfessionNotLike(String value) {
			addCriterion("profession not like", value, "profession");
			return this;
		}

		public Criteria andProfessionIn(List values) {
			addCriterion("profession in", values, "profession");
			return this;
		}

		public Criteria andProfessionNotIn(List values) {
			addCriterion("profession not in", values, "profession");
			return this;
		}

		public Criteria andProfessionBetween(String value1, String value2) {
			addCriterion("profession between", value1, value2, "profession");
			return this;
		}

		public Criteria andProfessionNotBetween(String value1, String value2) {
			addCriterion("profession not between", value1, value2, "profession");
			return this;
		}

		public Criteria andAreaIsNull() {
			addCriterion("area is null");
			return this;
		}

		public Criteria andAreaIsNotNull() {
			addCriterion("area is not null");
			return this;
		}

		public Criteria andAreaEqualTo(String value) {
			addCriterion("area =", value, "area");
			return this;
		}

		public Criteria andAreaNotEqualTo(String value) {
			addCriterion("area <>", value, "area");
			return this;
		}

		public Criteria andAreaGreaterThan(String value) {
			addCriterion("area >", value, "area");
			return this;
		}

		public Criteria andAreaGreaterThanOrEqualTo(String value) {
			addCriterion("area >=", value, "area");
			return this;
		}

		public Criteria andAreaLessThan(String value) {
			addCriterion("area <", value, "area");
			return this;
		}

		public Criteria andAreaLessThanOrEqualTo(String value) {
			addCriterion("area <=", value, "area");
			return this;
		}

		public Criteria andAreaLike(String value) {
			addCriterion("area like", value, "area");
			return this;
		}

		public Criteria andAreaNotLike(String value) {
			addCriterion("area not like", value, "area");
			return this;
		}

		public Criteria andAreaIn(List values) {
			addCriterion("area in", values, "area");
			return this;
		}

		public Criteria andAreaNotIn(List values) {
			addCriterion("area not in", values, "area");
			return this;
		}

		public Criteria andAreaBetween(String value1, String value2) {
			addCriterion("area between", value1, value2, "area");
			return this;
		}

		public Criteria andAreaNotBetween(String value1, String value2) {
			addCriterion("area not between", value1, value2, "area");
			return this;
		}

		public Criteria andWebsiteIsNull() {
			addCriterion("website is null");
			return this;
		}

		public Criteria andWebsiteIsNotNull() {
			addCriterion("website is not null");
			return this;
		}

		public Criteria andWebsiteEqualTo(String value) {
			addCriterion("website =", value, "website");
			return this;
		}

		public Criteria andWebsiteNotEqualTo(String value) {
			addCriterion("website <>", value, "website");
			return this;
		}

		public Criteria andWebsiteGreaterThan(String value) {
			addCriterion("website >", value, "website");
			return this;
		}

		public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
			addCriterion("website >=", value, "website");
			return this;
		}

		public Criteria andWebsiteLessThan(String value) {
			addCriterion("website <", value, "website");
			return this;
		}

		public Criteria andWebsiteLessThanOrEqualTo(String value) {
			addCriterion("website <=", value, "website");
			return this;
		}

		public Criteria andWebsiteLike(String value) {
			addCriterion("website like", value, "website");
			return this;
		}

		public Criteria andWebsiteNotLike(String value) {
			addCriterion("website not like", value, "website");
			return this;
		}

		public Criteria andWebsiteIn(List values) {
			addCriterion("website in", values, "website");
			return this;
		}

		public Criteria andWebsiteNotIn(List values) {
			addCriterion("website not in", values, "website");
			return this;
		}

		public Criteria andWebsiteBetween(String value1, String value2) {
			addCriterion("website between", value1, value2, "website");
			return this;
		}

		public Criteria andWebsiteNotBetween(String value1, String value2) {
			addCriterion("website not between", value1, value2, "website");
			return this;
		}

		public Criteria andConnectorIsNull() {
			addCriterion("connector is null");
			return this;
		}

		public Criteria andConnectorIsNotNull() {
			addCriterion("connector is not null");
			return this;
		}

		public Criteria andConnectorEqualTo(String value) {
			addCriterion("connector =", value, "connector");
			return this;
		}

		public Criteria andConnectorNotEqualTo(String value) {
			addCriterion("connector <>", value, "connector");
			return this;
		}

		public Criteria andConnectorGreaterThan(String value) {
			addCriterion("connector >", value, "connector");
			return this;
		}

		public Criteria andConnectorGreaterThanOrEqualTo(String value) {
			addCriterion("connector >=", value, "connector");
			return this;
		}

		public Criteria andConnectorLessThan(String value) {
			addCriterion("connector <", value, "connector");
			return this;
		}

		public Criteria andConnectorLessThanOrEqualTo(String value) {
			addCriterion("connector <=", value, "connector");
			return this;
		}

		public Criteria andConnectorLike(String value) {
			addCriterion("connector like", value, "connector");
			return this;
		}

		public Criteria andConnectorNotLike(String value) {
			addCriterion("connector not like", value, "connector");
			return this;
		}

		public Criteria andConnectorIn(List values) {
			addCriterion("connector in", values, "connector");
			return this;
		}

		public Criteria andConnectorNotIn(List values) {
			addCriterion("connector not in", values, "connector");
			return this;
		}

		public Criteria andConnectorBetween(String value1, String value2) {
			addCriterion("connector between", value1, value2, "connector");
			return this;
		}

		public Criteria andConnectorNotBetween(String value1, String value2) {
			addCriterion("connector not between", value1, value2, "connector");
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

		public Criteria andMobilenoIsNull() {
			addCriterion("mobileno is null");
			return this;
		}

		public Criteria andMobilenoIsNotNull() {
			addCriterion("mobileno is not null");
			return this;
		}

		public Criteria andMobilenoEqualTo(String value) {
			addCriterion("mobileno =", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoNotEqualTo(String value) {
			addCriterion("mobileno <>", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoGreaterThan(String value) {
			addCriterion("mobileno >", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoGreaterThanOrEqualTo(String value) {
			addCriterion("mobileno >=", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoLessThan(String value) {
			addCriterion("mobileno <", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoLessThanOrEqualTo(String value) {
			addCriterion("mobileno <=", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoLike(String value) {
			addCriterion("mobileno like", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoNotLike(String value) {
			addCriterion("mobileno not like", value, "mobileno");
			return this;
		}

		public Criteria andMobilenoIn(List values) {
			addCriterion("mobileno in", values, "mobileno");
			return this;
		}

		public Criteria andMobilenoNotIn(List values) {
			addCriterion("mobileno not in", values, "mobileno");
			return this;
		}

		public Criteria andMobilenoBetween(String value1, String value2) {
			addCriterion("mobileno between", value1, value2, "mobileno");
			return this;
		}

		public Criteria andMobilenoNotBetween(String value1, String value2) {
			addCriterion("mobileno not between", value1, value2, "mobileno");
			return this;
		}

		public Criteria andFaxIsNull() {
			addCriterion("fax is null");
			return this;
		}

		public Criteria andFaxIsNotNull() {
			addCriterion("fax is not null");
			return this;
		}

		public Criteria andFaxEqualTo(String value) {
			addCriterion("fax =", value, "fax");
			return this;
		}

		public Criteria andFaxNotEqualTo(String value) {
			addCriterion("fax <>", value, "fax");
			return this;
		}

		public Criteria andFaxGreaterThan(String value) {
			addCriterion("fax >", value, "fax");
			return this;
		}

		public Criteria andFaxGreaterThanOrEqualTo(String value) {
			addCriterion("fax >=", value, "fax");
			return this;
		}

		public Criteria andFaxLessThan(String value) {
			addCriterion("fax <", value, "fax");
			return this;
		}

		public Criteria andFaxLessThanOrEqualTo(String value) {
			addCriterion("fax <=", value, "fax");
			return this;
		}

		public Criteria andFaxLike(String value) {
			addCriterion("fax like", value, "fax");
			return this;
		}

		public Criteria andFaxNotLike(String value) {
			addCriterion("fax not like", value, "fax");
			return this;
		}

		public Criteria andFaxIn(List values) {
			addCriterion("fax in", values, "fax");
			return this;
		}

		public Criteria andFaxNotIn(List values) {
			addCriterion("fax not in", values, "fax");
			return this;
		}

		public Criteria andFaxBetween(String value1, String value2) {
			addCriterion("fax between", value1, value2, "fax");
			return this;
		}

		public Criteria andFaxNotBetween(String value1, String value2) {
			addCriterion("fax not between", value1, value2, "fax");
			return this;
		}

		public Criteria andPostcodeIsNull() {
			addCriterion("postcode is null");
			return this;
		}

		public Criteria andPostcodeIsNotNull() {
			addCriterion("postcode is not null");
			return this;
		}

		public Criteria andPostcodeEqualTo(String value) {
			addCriterion("postcode =", value, "postcode");
			return this;
		}

		public Criteria andPostcodeNotEqualTo(String value) {
			addCriterion("postcode <>", value, "postcode");
			return this;
		}

		public Criteria andPostcodeGreaterThan(String value) {
			addCriterion("postcode >", value, "postcode");
			return this;
		}

		public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
			addCriterion("postcode >=", value, "postcode");
			return this;
		}

		public Criteria andPostcodeLessThan(String value) {
			addCriterion("postcode <", value, "postcode");
			return this;
		}

		public Criteria andPostcodeLessThanOrEqualTo(String value) {
			addCriterion("postcode <=", value, "postcode");
			return this;
		}

		public Criteria andPostcodeLike(String value) {
			addCriterion("postcode like", value, "postcode");
			return this;
		}

		public Criteria andPostcodeNotLike(String value) {
			addCriterion("postcode not like", value, "postcode");
			return this;
		}

		public Criteria andPostcodeIn(List values) {
			addCriterion("postcode in", values, "postcode");
			return this;
		}

		public Criteria andPostcodeNotIn(List values) {
			addCriterion("postcode not in", values, "postcode");
			return this;
		}

		public Criteria andPostcodeBetween(String value1, String value2) {
			addCriterion("postcode between", value1, value2, "postcode");
			return this;
		}

		public Criteria andPostcodeNotBetween(String value1, String value2) {
			addCriterion("postcode not between", value1, value2, "postcode");
			return this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return this;
		}

		public Criteria andEmailIn(List values) {
			addCriterion("email in", values, "email");
			return this;
		}

		public Criteria andEmailNotIn(List values) {
			addCriterion("email not in", values, "email");
			return this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
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
	}
}