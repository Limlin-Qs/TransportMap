package com.cyy.traffic.service.impl;

import com.cyy.traffic.Util.TimestampUtil;
import com.cyy.traffic.entity.People;
import com.cyy.traffic.repository.PeopleRepository;
import com.cyy.traffic.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: congyuyang
 * @Date: 2020/5/22 上午10:19
 */
@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    PeopleRepository peopleRepository;


    @Override
    public List<People> selectTimeQuantum(String start_time, String end_time) throws ParseException {
        List<People> rs = new ArrayList<>();
        List<People> all = peopleRepository.findAll();
        TimestampUtil timestampUtil = new TimestampUtil();
        for (People people : all) {
            String timeStamp = people.getTimestamp();
            if (timestampUtil.toDate(timeStamp).after(TimestampUtil.toDate(start_time)) &&
                    timestampUtil.toDate(timeStamp).before(TimestampUtil.toDate(end_time))) {
                rs.add(people);
            }
        }
        return rs;
    }
}
