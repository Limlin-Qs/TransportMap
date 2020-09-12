package com.cyy.traffic.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: congyuyang
 * @Date: 2020-03-17 09:41
 */
@Entity
@Data
public class People {
    @Id
    private Integer id;
    private String timestamp;
    private String imsi;
    private String longitude;
    private String latitude;
}
