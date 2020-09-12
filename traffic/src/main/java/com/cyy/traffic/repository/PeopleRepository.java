package com.cyy.traffic.repository;

import com.cyy.traffic.entity.People;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: congyuyang
 * @Date: 2020-03-17 09:51
 */
public interface PeopleRepository extends JpaRepository<People, Integer> {
    // 按IMSI查询
    List<People> findByImsi(String imsi);
}

