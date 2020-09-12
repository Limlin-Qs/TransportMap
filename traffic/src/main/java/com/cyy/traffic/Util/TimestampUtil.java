package com.cyy.traffic.Util;

import com.cyy.traffic.service.TimeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: congyuyang
 * @Date: 2020/5/22 上午8:28
 */
public class TimestampUtil {
    public static Date toDate(String timestamp) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat( "yyyyMMddHHmmss");
        Date date = sf.parse(timestamp);
        return date;
    }
}
