package com.example.demo.service;

import com.example.demo.model.BerthStatusPO;
import com.example.demo.utils.page.PageList;
import com.example.demo.utils.page.PageRequest;

import java.util.List;

/**
 * Created by WZB on 2017/7/5.
 *
 * 船舶泊位分析服务
 */
public interface BerthVesselAnalysisService {

    //船舶、泊位效率分析大表
    //PageList<BerthStatusPO> table(PageRequest pageRequest);

    //获取所有船舶、泊位的状态记录
    List<BerthStatusPO> getAllBerthStatus();
}
