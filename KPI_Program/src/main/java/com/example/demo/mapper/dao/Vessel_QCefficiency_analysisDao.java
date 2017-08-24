package com.example.demo.mapper.dao;

import com.example.demo.Controller.selectdata.VesselQCPO;
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
            "select\n" +
                    "     t1.qc_id as qc_id,\n" +
                    "     round(count(t1.command_gkey)/((to_date(max(to_char(t1.updated,'YYYY-MM-DD hh24:mi:ss')),'YYYY-MM-DD hh24:mi:ss') -\n" +
                    "     to_date(min(to_char(t1.created,'YYYY-MM-DD hh24:mi:ss')),'YYYY-MM-DD hh24:mi:ss'))*24),2) as jobEff\n" +
                    "from \n" +
                    "  QC_COMMANDS t1,\n" +
                    "  QC_ORDERS t2,\n" +
                    "  WORK_INSTRUCTION_STATUS t3,\n" +
                    "  QC_WORK_QUEUE_STATUS t4\n" +
                    "where\n" +
                    "  t1.order_gkey = t2.order_gkey\n" +
                    "  and t2.container_wi_ref = t3.container_wi_ref\n" +
                    "  and t3.work_queue = t4.work_queue\n" +
                    "  and t4.vessel_visit = #{vessel_voyage}\n" +
                    "group by \n" +
                    "     t1.qc_id\n" +
                    "order by\n" +
                    "     t1.qc_id desc\n"
    )
    public List<VesselQCPO> getVesselQC(@Param("vessel_voyage") String vessel_voyage);

}
