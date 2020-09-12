package com.cyy.traffic.controller;

import com.cyy.traffic.entity.People;
import com.cyy.traffic.repository.PeopleRepository;
import com.cyy.traffic.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author: congyuyang
 * @Date: 2020-03-17 10:17
 */
@RestController
@RequestMapping("/people")
public class PeopleHandler {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    TimeService timeService;

    //查询所有
    @GetMapping("/findAll")
    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    //分页处理
    @GetMapping("/findAll/{page}/{size}")
    public Page<People> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return peopleRepository.findAll(request);
    }

    //按IMSI查询
    @GetMapping("/findByImsi/{imsi}")
    public List<People> findByImsi(@PathVariable("imsi") String imsi) {
        return peopleRepository.findByImsi(imsi);
    }

    //按时间段查询
    @GetMapping("/findByTimeQuantum/{startTime}/{endTime}")
    public List<People> findByTimeQuantum(@PathVariable String startTime, @PathVariable String endTime) throws ParseException {
        return timeService.selectTimeQuantum(startTime, endTime);
    }
}
