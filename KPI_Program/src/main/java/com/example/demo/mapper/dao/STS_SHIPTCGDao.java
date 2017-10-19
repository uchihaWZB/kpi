package com.example.demo.mapper.dao;

import com.example.demo.Controller.selectdata.VesselList;
import com.example.demo.vo.QcProductivityOfVesselVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * STS_SHIPTCGPO 数据接口
 * DAO层
 *
 * @author WZB
 * @date 2017-08-30
 */

@Mapper
public interface STS_SHIPTCGDao {

    /**
     * @decription 获取T_STS_SHIP_TCG表中不重复的vessel_visit
     *
     * @return
     */
    @Select("SELECT DISTINCT(vessel_visit) FROM T_STS_SHIP_TCG")
    List<String> getVesselVisitNames();

    /**
     * @description 根据船到访编号查询该船次的工作效率
     *
     * @param vesselVisit 船到访编号
     * @return
     */
    @Select("SELECT "
            +   "ROUND(COUNT(T1.work_queue) / ((MAX(T1.updated) - MIN(T1.created)) * 24), 2) as vessel_qc_productivity\n"
            +"FROM\n"
            +   "QC_COMMANDS T1,"
            +   "QC_WORK_QUEUE_STATUS T2\n"
            +"WHERE\n"
            +   "T1.work_queue = T2.work_queue\n"
            +"AND\n"
            +   "TO_CHAR(T1.created, 'yyyy-mm-dd hh24') >= #{startTime} and TO_CHAR(T1.created, 'yyyy-mm-dd hh24') <= #{endTime}\n"
            +"AND\n"
            +   "T2.vessel_visit = #{vesselVisit}")
    Double getProductivityByVessleVisit(@Param("vesselVisit") String vesselVisit,
                                        @Param("startTime") String startTime,
                                        @Param("endTime") String endTime);

    /**
     * 根据船到访名查询该船次下的岸桥作业效率
     *
     * @param vesselName 船到访名
     * @return
     */
    @Select("SELECT "
            +   "T3.qc_id AS qcId,"
            +   "ROUND(COUNT(DISTINCT(T3.command_gkey)) / ((MAX(T3.updated) - MIN(T3.created)) * 24), 2) AS productivity\n"
            +"FROM\n"
            +   "(SELECT T1.command_gkey, T1.qc_id, T1.created, T1.updated\n"
            +    "FROM QC_COMMANDS T1, QC_WORK_QUEUE_STATUS T2\n"
            +    "WHERE T1.work_queue = T2.work_queue AND T2.vessel_visit = #{vesselName}) T3\n"
            +"GROUP BY T3.qc_id\n"
            +"ORDER BY T3.qc_id")
    List<QcProductivityOfVesselVO> getAllQcProductivityByVesselName(@Param("vesselName") String vesselName);
}
