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
 * Created by lenovopc001 on 2017/9/11.
 */

@Mapper
public interface EventResultDao {

    @Select("SELECT * FROM T_STS_EVENT_RESULT")
    List<EventResultPO> getAllEventResultPO();

    /**
     * 根据岸桥id获取 岸桥任务 总耗时
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
