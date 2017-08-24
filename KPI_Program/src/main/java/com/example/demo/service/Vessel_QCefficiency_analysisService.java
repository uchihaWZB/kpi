package com.example.demo.service;

import com.example.demo.Controller.selectdata.VesselQCPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gaochangqing on 2017/8/22.
 */
public interface Vessel_QCefficiency_analysisService {

    /**
     * 获取船舶对应qc作业量
     * */
    public List<VesselQCPO> getVesselQC(@Param("vessel_voyage") String vessel_voyage);
}
