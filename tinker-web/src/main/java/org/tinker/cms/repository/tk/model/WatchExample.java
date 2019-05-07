package org.tinker.cms.repository.tk.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WatchExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
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
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlIsNull() {
            addCriterion("main_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlIsNotNull() {
            addCriterion("main_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlEqualTo(String value) {
            addCriterion("main_picture_url =", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlNotEqualTo(String value) {
            addCriterion("main_picture_url <>", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlGreaterThan(String value) {
            addCriterion("main_picture_url >", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("main_picture_url >=", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlLessThan(String value) {
            addCriterion("main_picture_url <", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("main_picture_url <=", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlLike(String value) {
            addCriterion("main_picture_url like", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlNotLike(String value) {
            addCriterion("main_picture_url not like", value, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlIn(List<String> values) {
            addCriterion("main_picture_url in", values, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlNotIn(List<String> values) {
            addCriterion("main_picture_url not in", values, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlBetween(String value1, String value2) {
            addCriterion("main_picture_url between", value1, value2, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlNotBetween(String value1, String value2) {
            addCriterion("main_picture_url not between", value1, value2, "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsIsNull() {
            addCriterion("sub_picture_urls is null");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsIsNotNull() {
            addCriterion("sub_picture_urls is not null");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsEqualTo(String value) {
            addCriterion("sub_picture_urls =", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsNotEqualTo(String value) {
            addCriterion("sub_picture_urls <>", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsGreaterThan(String value) {
            addCriterion("sub_picture_urls >", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("sub_picture_urls >=", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsLessThan(String value) {
            addCriterion("sub_picture_urls <", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsLessThanOrEqualTo(String value) {
            addCriterion("sub_picture_urls <=", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsLike(String value) {
            addCriterion("sub_picture_urls like", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsNotLike(String value) {
            addCriterion("sub_picture_urls not like", value, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsIn(List<String> values) {
            addCriterion("sub_picture_urls in", values, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsNotIn(List<String> values) {
            addCriterion("sub_picture_urls not in", values, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsBetween(String value1, String value2) {
            addCriterion("sub_picture_urls between", value1, value2, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsNotBetween(String value1, String value2) {
            addCriterion("sub_picture_urls not between", value1, value2, "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeIsNull() {
            addCriterion("last_modifed_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeIsNotNull() {
            addCriterion("last_modifed_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeEqualTo(LocalDateTime value) {
            addCriterion("last_modifed_time =", value, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeNotEqualTo(LocalDateTime value) {
            addCriterion("last_modifed_time <>", value, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeGreaterThan(LocalDateTime value) {
            addCriterion("last_modifed_time >", value, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("last_modifed_time >=", value, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeLessThan(LocalDateTime value) {
            addCriterion("last_modifed_time <", value, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("last_modifed_time <=", value, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeIn(List<LocalDateTime> values) {
            addCriterion("last_modifed_time in", values, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeNotIn(List<LocalDateTime> values) {
            addCriterion("last_modifed_time not in", values, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("last_modifed_time between", value1, value2, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifedTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("last_modifed_time not between", value1, value2, "lastModifedTime");
            return (Criteria) this;
        }

        public Criteria andOpertorIsNull() {
            addCriterion("opertor is null");
            return (Criteria) this;
        }

        public Criteria andOpertorIsNotNull() {
            addCriterion("opertor is not null");
            return (Criteria) this;
        }

        public Criteria andOpertorEqualTo(String value) {
            addCriterion("opertor =", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorNotEqualTo(String value) {
            addCriterion("opertor <>", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorGreaterThan(String value) {
            addCriterion("opertor >", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorGreaterThanOrEqualTo(String value) {
            addCriterion("opertor >=", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorLessThan(String value) {
            addCriterion("opertor <", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorLessThanOrEqualTo(String value) {
            addCriterion("opertor <=", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorLike(String value) {
            addCriterion("opertor like", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorNotLike(String value) {
            addCriterion("opertor not like", value, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorIn(List<String> values) {
            addCriterion("opertor in", values, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorNotIn(List<String> values) {
            addCriterion("opertor not in", values, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorBetween(String value1, String value2) {
            addCriterion("opertor between", value1, value2, "opertor");
            return (Criteria) this;
        }

        public Criteria andOpertorNotBetween(String value1, String value2) {
            addCriterion("opertor not between", value1, value2, "opertor");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andSubjectLikeInsensitive(String value) {
            addCriterion("upper(subject) like", value.toUpperCase(), "subject");
            return (Criteria) this;
        }

        public Criteria andBrandLikeInsensitive(String value) {
            addCriterion("upper(brand) like", value.toUpperCase(), "brand");
            return (Criteria) this;
        }

        public Criteria andTypeLikeInsensitive(String value) {
            addCriterion("upper(type) like", value.toUpperCase(), "type");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andMainPictureUrlLikeInsensitive(String value) {
            addCriterion("upper(main_picture_url) like", value.toUpperCase(), "mainPictureUrl");
            return (Criteria) this;
        }

        public Criteria andSubPictureUrlsLikeInsensitive(String value) {
            addCriterion("upper(sub_picture_urls) like", value.toUpperCase(), "subPictureUrls");
            return (Criteria) this;
        }

        public Criteria andTagsLikeInsensitive(String value) {
            addCriterion("upper(tags) like", value.toUpperCase(), "tags");
            return (Criteria) this;
        }

        public Criteria andStateLikeInsensitive(String value) {
            addCriterion("upper(state) like", value.toUpperCase(), "state");
            return (Criteria) this;
        }

        public Criteria andOpertorLikeInsensitive(String value) {
            addCriterion("upper(opertor) like", value.toUpperCase(), "opertor");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}