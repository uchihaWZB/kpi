package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WZB on 2017/7/19.
 *
 * 日期和时间的格式化工具类
 */
public class DateTimeUtils {

    /**
     * 得到 年-月-日 时:00 的日期格式
     *
     * @param   date
     * @return  Date
     */
    public static Date getYearMonthDayHour(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:00");

        Date dateResult = null;

        //todo 判空操作

        String dateStr = sdf.format(date);

        try {

            dateResult = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateResult;
    }
}
