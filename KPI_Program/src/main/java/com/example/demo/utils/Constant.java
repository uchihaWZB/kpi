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

    /************岸桥任务间隔事件类型及所包含的GapId START************/

    public final static String WAIT_WORK_QUEUE = "等待WorkQueue耗时";
    public final static String WAIT_WI_CI = "等待WI/CI耗时";
    public final static String WAIT_OCR = "等待OCR耗时";
    public final static String WAIT_PF_LOCK = "等待台座锁定耗时";
    public final static String WAIT_STSMS_REBOOT = "等待STSMS重启耗时";
    public final static String MT_MANUAL_MODE = "等待主小车模式耗时";
    public final static String WAIT_STSMS_PERFORMANCE = "STSMS系统性能耗时";

    // 等待WQ事件
    public final static List<String> WAIT_WORK_QUEUE_TYPE = Arrays.asList("GAP015", "GAP017");

    // 等待WI/CI事件
    public final static List<String> WAIT_WI_CI_TYPE = Arrays.asList("GAP025", "GAP029", "GAP031", "GAP032", "GAP033", "GAP034",
                                                                    "GAP036", "GAP038", "GAP040", "GAP041", "GAP042", "GAP073", "GAP074",
                                                                    "GAP079", "GAP080", "GAP081", "GAP082", "GAP083", "GAP084", "GAP090",
                                                                    "GAP091", "GAP092", "GAP093", "GAP129");

    // 等待OCR事件
    public final static List<String> WAIT_OCR_TYPE = Arrays.asList("GAP027", "GAP075", "GAP085", "GAP114", "GAP115", "GAP116");

    // 等待台座锁定
    public final static List<String> WAIT_PF_LOCK_TYPE = Arrays.asList("GAP028", "GAP070", "GAP076", "GAP077", "GAP086", "GAP087", "GAP125");

    // 等待STSMS重启
    public final static List<String> WAIT_STSMS_REBOOT_TYPE = Arrays.asList("GAP001", "GAP004", "GAP012", "GAP016", "GAP119", "GAP126", "GAP130");

    // 等待主小车模式
    public final static List<String> MT_MANUAL_MODE_TYPE = Arrays.asList("GAP018", "GAP019", "GAP020", "GAP021", "GAP035");

    // STSMS系统性能耗时
    public final static List<String> WAIT_STSMS_PERFORMANCE_TYPE = Arrays.asList("GAP003", "GAP005", "GAP006", "GAP008", "GAP009",
                                                                                "GAP010", "GAP011", "GAP013", "GAP014", "GAP022", "GAP023",
                                                                                "GAP024", "GAP026", "GAP030", "GAP039", "GAP043", "GAP044",
                                                                                "GAP047", "GAP052", "GAP053", "GAP054", "GAP055", "GAP056",
                                                                                "GAP057", "GAP058", "GAP059", "GAP060", "GAP061", "GAP062",
                                                                                "GAP063", "GAP064", "GAP065", "GAP078", "GAP088", "GAP089",
                                                                                "GAP098", "GAP099", "GAP100", "GAP101", "GAP102", "GAP103",
                                                                                "GAP104", "GAP105", "GAP106", "GAP107", "GAP108", "GAP109",
                                                                                "GAP117", "GAP118", "GAP120", "GAP127", "GAP128");
    /************岸桥任务间隔事件类型及所包含的GapId END************/

    /************岸桥任务事件类型及所包含的GapId START************/

    public final static String CHANGE_BAY_COST = "换贝任务耗时";
    public final static String PARK_TASK_COST = "Park任务耗时";
    public final static String NORMAL_TASK_COST = "普通任务耗时";

    public final static List<String> CHANGE_BAY_COST_TYPE = Arrays.asList("COST007", "COST048", "COST049", "COST050", "COST051");

    public final static List<String> PARK_TASK_COST_TYPE = Arrays.asList("COST066", "COST067", "COST068", "COST069", "COST070",
                                                                        "COST071", "COST072", "COST111", "COST112", "COST113", "COST122",
                                                                        "COST123", "COST124");

    public final static List<String> NORMAL_TASK_COST_TYPE = Arrays.asList("COST094", "COST095", "COST096", "COST097");

    /************岸桥任务事件类型及所包含的GapId END************/
}
