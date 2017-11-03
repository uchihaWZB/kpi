package com.example.demo.service.impl;


import com.example.demo.mapper.dao.*;
import com.example.demo.model.EventResultPO;
import com.example.demo.model.QC_CommandPO;
import com.example.demo.model.T_STS_ConvertEventRecordPO;
import com.example.demo.service.QcEfficiencyAnalysisService;

import com.example.demo.utils.Constant;
import com.example.demo.vo.QcJobEfficiencyVO;
import com.example.demo.vo.QcProductivityOfVesselVO;
import com.example.demo.vo.QcTaskInfoVO;
import org.apache.commons.lang3.time.DateFormatUtils;
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

    @Autowired
    private BerthVesselDao berthVesselDao;

    @Autowired
    private T_STS_ConvertEventRecordDao t_sts_convertEventRecordDao;

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

        List<String> listVesselVisits = sts_shiptcgDao.getVesselVisitNames();
        System.out.println("listVesselVisitNames:        "+listVesselVisits.size());

        String vesselName = "";
        Double vesselProductivity = 0d;

        for (String vesselVisit : listVesselVisits) {

            //vesselName = berthVesselDao.getVesselNameByVesselVisit(vesselVisit);
            vesselProductivity = sts_shiptcgDao.getProductivityByVessleVisit(vesselVisit, startTime, endTime);

            Map<String, Object> map = new HashMap<>();
            map.put("vesselName", vesselVisit);
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
    public List<T_STS_ConvertEventRecordPO> getCraneInfoByQcId(@Param("qcId") String qcId,
                                                              @Param("eventLevel") String eventLevel,
                                                              @Param("startTime") String startTime,
                                                              @Param("endTime") String endTime) {

        return t_sts_convertEventRecordDao.getConvertEventResultPOBySTSId(qcId, eventLevel, startTime, endTime);

    }
}