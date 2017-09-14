package com.example.demo.service.impl;


import com.example.demo.mapper.dao.EventResultDao;
import com.example.demo.mapper.dao.Qc_CommandDao;
import com.example.demo.mapper.dao.STS_SHIPTCGDao;
import com.example.demo.model.QC_CommandPO;
import com.example.demo.service.QcEfficiencyAnalysisService;

import com.example.demo.utils.Constant;
import com.example.demo.vo.QcJobEfficiencyVO;
import com.example.demo.vo.QcProductivityOfVesselVO;
import com.example.demo.vo.QcTaskInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by WZB on 2017/7/19.
 */
@Service("QcEfficiencyAnalysisService")
public class QcEfficiencyAnalysisServiceImpl implements QcEfficiencyAnalysisService {

    @Autowired
    private Qc_CommandDao qc_CommandDao;

    @Autowired
    private STS_SHIPTCGDao sts_shiptcgDao;

    @Autowired
    private EventResultDao eventResultDao;

    @Override
    public List<QC_CommandPO> getAllQcCommandPO() {

        return qc_CommandDao.getAllQcCommandPO();
    }

    @Override
    public List<QcJobEfficiencyVO> getAllQcWorkEfficiencyCount(@Param("qcEfficiencyType") String qcEfficiencyType,
                                                               @Param("startTime") String startTime,
                                                               @Param("endTime") String endTime) {

        return qc_CommandDao.getAllQcWorkEfficiencyCount(qcEfficiencyType, startTime, endTime);
    }

    @Override
    public List<Map<String, Object>> getAllVesselProductivity(@Param("startTime") String startTime, @Param("endTime") String endTime) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        List<String> listVesselVisitNames = sts_shiptcgDao.getVesselVisitNames();
        Double vesselProductivity = 0d;

        for (String name : listVesselVisitNames) {

            vesselProductivity = sts_shiptcgDao.getProductivityByVessleVisit(name, startTime, endTime);
            map.put("vesselName", name);
            map.put("vesselProductivity", vesselProductivity);

            listMap.add(map);
        }

        return listMap;
    }

    @Override
    public List<QcProductivityOfVesselVO> getAllQcProductivityByVesselName(@Param("vesselName") String vesselName) {
        return sts_shiptcgDao.getAllQcProductivityByVesselName(vesselName);
    }

    @Override
    public Map<String, Object> getQcTaskEventConsumeByQcId(@Param("qcId") String qcId) {
        Map<String, Object> result = new HashMap<>();

        Double taskCost = eventResultDao.getQcCostTimeByQcId(qcId);

        Double taskGap = eventResultDao.getQcGapTimeByQcId(qcId);

        List<QcTaskInfoVO> listTaskCost = eventResultDao.getTaskEventCOSTConsumeByQcId(qcId);

        List<QcTaskInfoVO> listTaskGap = eventResultDao.getTaskEventGAPConsumeByQcId(qcId);

        result.put("taskCost", taskCost);
        result.put("taskGap", taskGap);
        result.put("listTaskCost", listTaskCost);
        result.put("listTaskGap", listTaskGap);

        return result;
    }
}