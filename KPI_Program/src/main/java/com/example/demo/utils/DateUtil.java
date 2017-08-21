package com.example.demo.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by gaochangqing on 2017/7/28.
 */
public class DateUtil {

    public static String getTimeDisp(Date time){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeDisp = formatter.format(time);

        return timeDisp;
    }

}
