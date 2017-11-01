package com.example.demo.mapper.dao;

import com.example.demo.model.EventResultPO;
import com.example.demo.vo.QcTaskInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 事件记录DAO
 *
 * 实际映射 表T_STS_CONVERT_EVENT_RECORD
 *
 * Created by lenovopc001 on 2017/9/11.
 */

@Mapper
public interface EventResultDao {

    /**
     * 根据 STS_ID 查询事件记录
     *
     * @param stsId
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT id,sts_id,event_gap,gap_Type,current_event_created\n"
            +"FROM T_STS_CONVERT_EVENT_RECORD\n"
            +"WHERE STS_ID = #{stsId}\n"
            +"AND TO_CHAR(CURRENT_EVENT_CREATED, 'yyyy-mm-dd hh24') >= #{startTime}\n"
            +"AND TO_CHAR(CURRENT_EVENT_CREATED, 'yyyy-mm-dd hh24') <= #{endTime}")
    List<EventResultPO> getEventResultPOBySTSId(@Param("stsId") String stsId,
                                                  @Param("startTime") String startTime,
                                                  @Param("endTime") String endTime);

    /**
     * 根据qcId（sts_id）查询某时间段下岸桥总耗时
     *
     * @param stsId
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT COUNT(EVENT_GAP)\n"
            +"FROM T_STS_CONVERT_EVENT_RECORD\n"
            +"WHERE STS_ID = #{stsId}\n"
            +"AND TO_CHAR(CURRENT_EVENT_CREATED, 'yyyy-mm-dd hh24') >= #{startTime}\n"
            +"AND TO_CHAR(CURRENT_EVENT_CREATED, 'yyyy-mm-dd hh24') <= #{endTime}")
    Double getTotalConsumeOfSTSByQcId(@Param("stsId") String stsId,
                                      @Param("startTime") String startTime,
                                      @Param("endTime") String endTime);

    /**
     * 根据 QC_ID 获取 岸桥任务 总耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT SUM(EVENT_GAP) as cost\n"
            +"FROM T_STS_CONVERT_EVENT_RECORD\n"
            +"WHERE STS_ID = #{qcId} AND GAP_ID LIKE '%COST%'")
    Double getQcCostTimeByQcId(@Param("qcId") String qcId);

    /**
     * 根据岸桥id获取 岸桥任务间隔 总耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT SUM(EVENT_GAP) as gap\n"
            +"FROM T_STS_CONVERT_EVENT_RECORD\n"
            +"WHERE STS_ID = #{qcId} AND GAP_ID LIKE '%GAP%'")
    Double getQcGapTimeByQcId(@Param("qcId") String qcId);

    /**
     * 根据岸桥id获取 岸桥任务间隔耗时的种类及其耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT "
            +    "GAP_ID, GAP_TYPE, EVENT_DESC, sum(EVENT_GAP) as eventconsume\n"
            +"FROM\n"
            +   "T_STS_CONVERT_EVENT_RECORD\n"
            +"WHERE\n"
            +   "STS_ID = #{qcId} AND GAP_ID LIKE '%GAP%'\n"
            +"GROUP BY\n"
            +   "GAP_ID, GAP_TYPE, EVENT_DESC")
    List<QcTaskInfoVO> getTaskEventGAPConsumeByQcId(@Param("qcId") String qcId);

    /**
     * 根据岸桥id获取 岸桥任务耗时的种类及其耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT "
            +    "GAP_ID, GAP_TYPE, EVENT_DESC, sum(EVENT_GAP) as eventconsume\n"
            +"FROM\n"
            +   "T_STS_CONVERT_EVENT_RECORD\n"
            +"WHERE\n"
            +   "STS_ID = #{qcId} AND GAP_ID LIKE '%COST%'\n"
            +"GROUP BY\n"
            +   "GAP_ID, GAP_TYPE, EVENT_DESC")
    List<QcTaskInfoVO> getTaskEventCOSTConsumeByQcId(@Param("qcId") String qcId);
}
