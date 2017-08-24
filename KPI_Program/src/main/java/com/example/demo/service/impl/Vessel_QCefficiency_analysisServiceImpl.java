package com.example.demo.service.impl;

import com.example.demo.Controller.selectdata.VesselQCPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.Vessel_QCefficiency_analysisService;
import com.example.demo.mapper.dao.Vessel_QCefficiency_analysisDao;
import java.util.List;

/**
 * Created by gaochangqing on 2017/8/22.
 */
@Service("Vessel_QCefficiency_analysisService")
public class Vessel_QCefficiency_analysisServiceImpl implements Vessel_QCefficiency_analysisService{

    @Autowired
    private Vessel_QCefficiency_analysisDao vessel_QCefficiency_analysisDao;

    @Override
    public List<VesselQCPO> getVesselQC(@Param("vessel_voyage") String vessel_voyage){

        System.out.println(vessel_voyage+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        return vessel_QCefficiency_analysisDao.getVesselQC(vessel_voyage);
    };


}