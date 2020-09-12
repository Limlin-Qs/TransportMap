package com.cyy.traffic.service;

import com.cyy.traffic.entity.People;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author: congyuyang
 * @Date: 2020/5/22 上午10:13
 */
public interface TimeService {
    List<People> selectTimeQuantum(String start_time, String end_time) throws ParseException;
}
