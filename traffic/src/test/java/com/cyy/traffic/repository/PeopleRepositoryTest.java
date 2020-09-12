package com.cyy.traffic.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: congyuyang
 * @Date: 2020-03-17 09:53
 */

@SpringBootTest
class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void findAll() {
        System.out.println(peopleRepository.findAll());
    }


}