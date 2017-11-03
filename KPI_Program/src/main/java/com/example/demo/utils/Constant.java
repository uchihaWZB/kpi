package com.example.demo.utils;

import java.util.*;
/**
 * Created by WZB on 2017/7/5.
 *
 * 系统中用到的常量
 */
public class Constant {

    //数据库表常量
    public final static String BERTH_STATUS = "BERTH_STATUS";

    //Web层响应数据分页-每页的项数
    public final static Integer PAGE_HAVE_ITEMS = 10;

    //Web层相应数据分页-当前页码
    public final static Integer PAGE_CURRENT = 1;

    /************登录出错常量信息 START************/

    public final static String NEED_LOGIN_NAME_AND_PASSWORD = "用户登录名或密码不能为空！";

    public final static String NOT_HAVE_LOGIN_NAME = "用户不存在！";

    public final static String NOT_CORRECT_LOGIN_PASSWORD = "用户密码不正确！";

    /************登录出错常量信息 END*************/

    /************岸桥主小车任务事件类型************/

    public final static String WAIT_WORK_QUEUE = "WAITWQ";                      // 等待WQ
    public final static String WAIT_WI_CI = "WAITWICI";                         // 等待WI/CI
    public final static String WAIT_OCR = "WAITOCR";                            // 等待OCR
    public final static String WAIT_PF_LOCK = "WAITLOCK";                       // 等待台座锁定
    public final static String WAIT_STSMS_REBOOT = "STSMSREBOOT";               // 等待STSMS重启
    public final static String MT_MANUAL_MODE = "MTMANUALMODE";                 // 等待主小车模式
    public final static String OTHER_FACTORS = "OTHERFACTORS";                  // 其他因素

    public final static String CHANGE_BAY_COST = "CHANGEBAYCOST";               // 换贝任务
    public final static String PARK_TASK_COST = "PARKTASKCOST";                 // Park任务
    public final static String NORMAL_TASK_COST = "NORMALTASKCOST";             // 普通任务

    /************岸桥主小车指令事件类型************/

    public final static String WAIT_PT = "WAITPT";                              // 等待门架小车避让
    public final static String WAIT_TO_POISOTION = "WAITTO_POISOTION";          // 等待下一个目标位置
    public final static String WAIT_EXCEPTION_HANDLE = "WAITEXCEPTIONHANDLE";   // 等待异常处理时间
    public final static String STSMS_PERFORMANCE = "STSMSPERFORMANCE";          // 系统性能耗时
    public final static String INSTRUCTION_COST = "INSTRUCTIONCOST";            // 指令执行耗时
}
