package com.example.demo.service;

import com.example.demo.Controller.selectdata.VesselList;
import com.example.demo.model.QC_CommandPO;
//import com.sun.tools.javac.util.List;
import java.util.List;
import java.util.Map;

import com.example.demo.vo.QcJobEfficiencyVO;
import com.example.demo.vo.QcProductivityOfVesselVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.swing.plaf.ListUI;

/**
 * Created by WZB on 2017/7/18.
 *
 * 岸桥效率分析业务
 */

public interface QcEfficiencyAnalysisService {

    /**
     * 获取所有QC_CommandPO记录
     */
    List<QC_CommandPO> getAllQcCommandPO();

    /**
     * 获得每个岸桥在固定时间段内的工作总量
     */
    List<QcJobEfficiencyVO> getAllQcWorkEfficiencyCount(@Param("qcEfficiencyType") String qcEfficiencyType,
                                                               @Param("startTime") String startTime,
                                                               @Param("endTime") String endTime);

    /**
     * 获取所有到访船次的工作效率
     *
     * @return
     */
    List<Map<String, Object>> getAllVesselProductivity(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据船到访名查询该船次下的岸桥作业效率
     *
     * @param vesselName 船到访名
     * @return
     */
    List<QcProductivityOfVesselVO> getAllQcProductivityByVesselName(@Param("vesselName") String vesselName);

    /**
     * 根据qcId查询该岸桥下的任务层面事件类型及其耗时
     *
     * @param qcId
     * @return
     */
    Map<String, Object> getQcTaskEventConsumeByQcId(@Param("qcId") String qcId);
}
