package com.example.demo.mapper.dao;

import com.example.demo.Controller.selectdata.VesselList;
import com.example.demo.Controller.selectdata.VesselQCPO;
import com.example.demo.model.STS_SHIPTCGPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by gcq on 2017/8/22.
 */
@Mapper
public interface Vessel_QCefficiency_analysisDao {

    /**
     * 获得所有Qc_CommandPO记录
     *
     * @return List
     */
    @Select(
            "select \n" +
                    "  s.qc_id,\n" +
                    "  round(sum(s.jobEff)/count(s.qc_id),2) as jobEff\n" +
                    "from\n" +
                    "  (select\n" +
                    "     t1.qc_id as qc_id,\n" +
                    "     ${qcEfficiencyType}/((to_date(max(to_char(t1.updated,'YYYY-MM-DD hh24:mi:ss')),'YYYY-MM-DD hh24:mi:ss') -\n" +
                    "     to_date(min(to_char(t1.created,'YYYY-MM-DD hh24:mi:ss')),'YYYY-MM-DD hh24:mi:ss'))*24) as jobEff\n" +
                    "   from \n" +
                    "       QC_COMMANDS t1,\n" +
                    "       QC_WORK_QUEUE_STATUS t2,\n" +
                    "       T_STS_SHIP_TCG t3\n" +
                    "   where\n" +
                    "       t1.work_queue = t2.work_queue\n" +
                    "       and t2.vessel_visit = t3.vessel_visit\n" +
                    "       and t2.vessel_visit = #{vessel_voyage}\n" +
                    "       group by \n" +
                    "       t1.work_queue,t1.qc_id\n" +
                    "   order by\n" +
                    "       t1.qc_id desc\n" +
                    ") s\n" +
                    "group by s.qc_id\n" +
                    "order by s.qc_id \n"
    )
    public List<VesselQCPO> getVesselQC(@Param("vessel_voyage") String vessel_voyage,@Param("qcEfficiencyType") String qcEfficiencyType);

    /**
     * 获得所有Qc_CommandPO记录
     *
     * @return List
     */
    @Select(
            " select distinct(vessel_visit) as vessel_visit\n" +
                    " from T_STS_SHIP_TCG\n" +
                    " where vessel_visit like '%'||#{vesselInfo}||'%'  "
    )
    public List<VesselList> getVessel_voyage(@Param("vesselInfo") String vesselInfo);

}
