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
     * 根据岸桥id获取 岸桥任务总耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT SUM(eventgaptime) as cost\n"
            +"FROM T_STS_EVENT_RESULT\n"
            +"WHERE QCID = #{qcId} AND gapid LIKE '%COST%'")
    Double getQcCostTimeByQcId(@Param("qcId") String qcId);

    /**
     * 根据岸桥id获取 岸桥任务间隔总耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT SUM(eventgaptime) as gap\n"
            +"FROM T_STS_EVENT_RESULT\n"
            +"WHERE QCID = #{qcId} AND gapid LIKE '%GAP%'")
    Double getQcGapTimeByQcId(@Param("qcId") String qcId);

    /**
     * 根据岸桥id获取 岸桥任务间隔耗时的种类及其耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT "
            +    "gapid, gaptype, eventdesc, sum(eventgaptime) as eventconsume\n"
            +"FROM\n"
            +   "T_STS_EVENT_RESULT\n"
            +"WHERE\n"
            +   "QCID = #{qcId} AND gapid LIKE '%GAP%'\n"
            +"GROUP BY\n"
            +   "gapid, gaptype, eventdesc")
    List<QcTaskInfoVO> getTaskEventGAPConsumeByQcId(@Param("qcId") String qcId);

    /**
     * 根据岸桥id获取 岸桥任务耗时的种类及其耗时
     *
     * @param qcId
     * @return
     */
    @Select("SELECT "
            +    "gapid, gaptype, eventdesc, sum(eventgaptime) as eventconsume\n"
            +"FROM\n"
            +   "T_STS_EVENT_RESULT\n"
            +"WHERE\n"
            +   "QCID = #{qcId} AND gapid LIKE '%COST%'\n"
            +"GROUP BY\n"
            +   "gapid, gaptype, eventdesc")
    List<QcTaskInfoVO> getTaskEventCOSTConsumeByQcId(@Param("qcId") String qcId);
}
