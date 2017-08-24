package com.example.demo.service.impl;


import com.example.demo.mapper.dao.Qc_CommandDao;
import com.example.demo.model.QC_CommandPO;
import com.example.demo.service.QcEfficiencyAnalysisService;

import com.example.demo.vo.QcJobEfficiencyVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WZB on 2017/7/19.
 */
@Service("QcEfficiencyAnalysisService")
public class QcEfficiencyAnalysisServiceImpl implements QcEfficiencyAnalysisService {

    @Autowired
    private Qc_CommandDao qc_CommandDao;

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
}
