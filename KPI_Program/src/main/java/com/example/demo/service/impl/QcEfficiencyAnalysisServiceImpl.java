package com.example.demo.service.impl;


import com.example.demo.mapper.dao.Qc_CommandDao;
import com.example.demo.mapper.dao.STS_SHIPTCGDao;
import com.example.demo.model.QC_CommandPO;
import com.example.demo.service.QcEfficiencyAnalysisService;

import com.example.demo.vo.QcJobEfficiencyVO;
import com.example.demo.vo.QcProductivityOfVesselVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WZB on 2017/7/19.
 */
@Service("QcEfficiencyAnalysisService")
public class QcEfficiencyAnalysisServiceImpl implements QcEfficiencyAnalysisService {

    @Autowired
    private Qc_CommandDao qc_CommandDao;

    @Autowired
    private STS_SHIPTCGDao sts_shiptcgDao;

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
    public List<Map<String, Object>> getAllVesselProductivity() {
        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        List<String> listVesselVisitNames = sts_shiptcgDao.getVesselVisitNames();
        Double vesselProductivity = 0d;

        for (String name : listVesselVisitNames) {

            vesselProductivity = sts_shiptcgDao.getProductivityByVessleVisit(name);
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
}