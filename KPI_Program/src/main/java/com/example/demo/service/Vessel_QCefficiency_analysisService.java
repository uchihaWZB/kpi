package com.example.demo.service;

import com.example.demo.Controller.selectdata.QCHomework_time;
import com.example.demo.Controller.selectdata.VesselList;
import com.example.demo.Controller.selectdata.VesselQCPO;
import com.example.demo.model.STS_SHIPTCGPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gaochangqing on 2017/8/22.
 */
public interface Vessel_QCefficiency_analysisService {

    /**
     * 获取船舶对应qc作业量
     * */
    public List<VesselQCPO> getVesselQC(@Param("vessel_voyage") String vessel_voyage,@Param("qcEfficiencyType") String qcEfficiencyType);

    /**
     * 查询船次
     * */
    public List<VesselList> getVessel_voyage(@Param("vesselInfo") String vesselInfo);

    /**
     * 获取桥吊对应耗时
     * */
    public List<QCHomework_time> getPieData(@Param("QCID") String QCID);
}
