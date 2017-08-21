package com.example.demo.service;

import com.example.demo.model.QC_CommandPO;
//import com.sun.tools.javac.util.List;
import java.util.List;

import com.example.demo.vo.QcJobEfficiencyVO;
import org.springframework.stereotype.Service;

/**
 * Created by WZB on 2017/7/18.
 *
 * 岸桥效率分析业务
 */

public interface QcEfficiencyAnalysisService {

    /**
     * 获取所有QC_CommandPO记录
     */
    public List<QC_CommandPO> getAllQcCommandPO();

    /**
     * 获得每个岸桥在固定时间段内的工作总量
     */
    public List<QcJobEfficiencyVO> getAllQcWorkEfficiencyCount();
}
