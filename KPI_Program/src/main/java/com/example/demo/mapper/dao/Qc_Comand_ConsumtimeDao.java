package com.example.demo.mapper.dao;

import com.example.demo.vo.Ins_GapAnalysisVO;
import com.example.demo.vo.Ins_TimeAnalysisVO;
import com.example.demo.vo.consumTotalTimeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
@Mapper
public interface Qc_Comand_ConsumtimeDao {

    /**
     *获取作业和间隔耗时总计
     * */
    /*@Select(" select \n" +
            "       1 as consumType，\n" +
            "       '指令作业时间' as consumName，   \n" +
            "       t1.qc_id as qcid，   \n" +
            "       sum(\n" +
            "         (to_date(to_char((t2.updated),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "           to_date(to_char((t2.created),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60\n" +
            "       ) as consumTime\n" +
            "from \n" +
            "       T_STS_TROLLEY_TASK t1,\n" +
            "       T_STS_MT_COMMANDS t2\n" +
            "where\n" +
            "       t1.TASK_ID = t2.task_id\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "       and t1.qc_id = #{craneNum} \n" +
            "       and t2.mtmacrocmdtype in ('PickupShip','GroundVessel','PickupPlatform','GroundPlatform',\n" +
            "       'Park','PickupbackreackApron','GroundtoBackreackApron','PickupAgv','GroundtoAGV')\n" +
            "       and t2.macrocmdstate = 'FINISH'\n" +
            "group by\n" +
            "     t1.qc_id\n" +
            "union all\n" +
            "select \n" +
            "      2 as consumType，\n" +
            "      '指令间隔时间' as consumName，\n" +
            "      qcid as qcid，   \n" +
            "      sum(eventgaptime) as consumTime\n" +
            "from \n" +
            "      T_STS_EVENT_RESULT\n" +
            "where\n" +
            "      1=1\n" +
            "      and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "      and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "      and qcid = #{craneNum} \n" +
            "      and gapid in('COST152','COST153','GAP142','GAP143','GAP144','GAP132','GAP133',\n" +
            "       'GAP134','GAP137','GAP138','GAP139','GAP140','GAP141','GAP148','GAP149','GAP150',\n" +
            "       'GAP151','GAP154','GAP155','GAP156','GAP157','GAP158')   \n" +
            "group by \n" +
            "      qcid ")*/

    @Select(" select \n" +
            "       1 as consumType，\n" +
            "       '指令作业时间' as consumName，   \n" +
            "       t1.qc_id as qcid，   \n" +
            "       sum(\n" +
            "         (to_date(to_char((t2.updated),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "           to_date(to_char((t2.created),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60\n" +
            "       ) as consumTime\n" +
            "from \n" +
            "       T_STS_TROLLEY_TASK t1,\n" +
            "       T_STS_MT_COMMANDS t2\n" +
            "where\n" +
            "       t1.TASK_ID = t2.task_id\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "       and t1.qc_id = #{craneNum} \n" +
            "       and t2.mtmacrocmdtype in ('PickupShip','GroundVessel','PickupPlatform','GroundPlatform',\n" +
            "       'Park','PickupbackreackApron','GroundtoBackreackApron','PickupAgv','GroundtoAGV')\n" +
            "       and t2.macrocmdstate = 'FINISH'\n" +
            "group by\n" +
            "     t1.qc_id\n" +
            "union all\n" +
            "select \n" +
            "      2 as consumType，\n" +
            "      '指令间隔时间' as consumName，\n" +
            "      STS_ID as qcid，   \n" +
            "      sum(EVENT_GAP) as consumTime\n" +
            "from \n" +
            "      T_STS_CONVERT_EVENT_RECORD \n" +
            "where\n" +
            "      1=1\n" +
            "      and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "      and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "      and STS_ID = #{craneNum} \n" +
            "      and GAP_ID in('COST152','COST153','GAP142','GAP143','GAP144','GAP132','GAP133',\n" +
            "       'GAP134','GAP137','GAP138','GAP139','GAP140','GAP141','GAP148','GAP149','GAP150',\n" +
            "       'GAP151','GAP154','GAP155','GAP156','GAP157','GAP158')   \n" +
            "group by \n" +
            "      STS_ID ")
    List<consumTotalTimeVO> getconsumTotalTimeData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                          @Param("craneNum") String craneNum);

    /**
     *获取指令gap时间
     * */
    /*@Select("select \n" +
            "  1 as consumType，\n" +
            "  '等待目标位置' as consumName，\n" +
            "  qcid as qcid,\n" +
            "  sum(eventgaptime) as gapTime\n" +
            "from \n" +
            "  T_STS_EVENT_RESULT\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and qcid = #{craneNum} \n" +
            "  and gapid in('COST152')   \n" +
            "group by \n" +
            "  qcid\n" +
            "union all\n" +
            "select \n" +
            "  2 as consumType，\n" +
            "  '等待门架避让' as consumName，\n" +
            "  qcid as qcid,\n" +
            "  sum(eventgaptime) as gapTime\n" +
            "from \n" +
            "  T_STS_EVENT_RESULT\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and qcid = #{craneNum} \n" +
            "  and gapid in('COST153')   \n" +
            "group by \n" +
            "  qcid\n" +
            "union all\n" +
            "select \n" +
            "  3 as consumType，\n" +
            "  '等待异常处理' as consumName，\n" +
            "  qcid as qcid,\n" +
            "  sum(eventgaptime) as gapTime\n" +
            "from \n" +
            "  T_STS_EVENT_RESULT\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and qcid = #{craneNum} \n" +
            "  and gapid in('GAP142','GAP143','GAP144')   \n" +
            "group by \n" +
            "  qcid\n" +
            "union all\n" +
            "select \n" +
            "  4 as consumType，\n" +
            "  '系统性能耗时' as consumName，\n" +
            "  qcid as qcid,\n" +
            "  sum(eventgaptime) as gapTime\n" +
            "from \n" +
            "  T_STS_EVENT_RESULT\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(currenteventcreated,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and qcid = #{craneNum} \n" +
            "  and gapid in('GAP132','GAP133','GAP134','GAP137','GAP138',\n" +
            "  'GAP139','GAP140','GAP141','GAP148','GAP149','GAP150','GAP151',\n" +
            "  'GAP154','GAP155','GAP156','GAP157','GAP158')   \n" +
            "group by \n" +
            "  qcid ")*/

    /*@Select("select \n" +
            "  1 as consumType，\n" +
            "  '等待目标位置' as consumName，\n" +
            "  STS_ID as qcid,\n" +
            "  sum(EVENT_GAP) as gapTime\n" +
            "from \n" +
            "  T_STS_CONVERT_EVENT_RECORD\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and STS_ID = #{craneNum} \n" +
            "  and GAP_ID in('COST152')   \n" +
            "group by \n" +
            "  STS_ID\n" +
            "union all\n" +
            "select \n" +
            "  2 as consumType，\n" +
            "  '等待门架避让' as consumName，\n" +
            "  STS_ID as qcid,\n" +
            "  sum(EVENT_GAP) as gapTime\n" +
            "from \n" +
            "  T_STS_CONVERT_EVENT_RECORD\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and STS_ID = #{craneNum} \n" +
            "  and GAP_ID in('COST153')   \n" +
            "group by \n" +
            "  STS_ID\n" +
            "union all\n" +
            "select \n" +
            "  3 as consumType，\n" +
            "  '等待异常处理' as consumName，\n" +
            "  STS_ID as qcid,\n" +
            "  sum(EVENT_GAP) as gapTime\n" +
            "from \n" +
            "  T_STS_CONVERT_EVENT_RECORD\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and STS_ID = #{craneNum} \n" +
            "  and GAP_ID in('GAP142','GAP143','GAP144')   \n" +
            "group by \n" +
            "  STS_ID\n" +
            "union all\n" +
            "select \n" +
            "  4 as consumType，\n" +
            "  '系统性能耗时' as consumName，\n" +
            "  STS_ID as qcid,\n" +
            "  sum(EVENT_GAP) as gapTime\n" +
            "from \n" +
            "  T_STS_CONVERT_EVENT_RECORD\n" +
            "where\n" +
            "  1=1\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "  and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  and STS_ID = #{craneNum} \n" +
            "  and GAP_ID in('GAP132','GAP133','GAP134','GAP137','GAP138',\n" +
            "  'GAP139','GAP140','GAP141','GAP148','GAP149','GAP150','GAP151',\n" +
            "  'GAP154','GAP155','GAP156','GAP157','GAP158')   \n" +
            "group by \n" +
            "  STS_ID ")*/
    @Select( "            select \n" +
            "              1 as consumType，\n" +
            "              '等待目标位置' as consumName，\n" +
            "              STS_ID as qcid,\n" +
            "              sum(EVENT_GAP) as gapTime\n" +
            "            from \n" +
            "              T_STS_CONVERT_EVENT_RECORD\n" +
            "            where\n" +
            "              1=1\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "              and STS_ID = #{craneNum} \n" +
            "              and event_level = 'Level03' \n" +
            "              and gap_type ='WAITTOPOSITION'  \n" +
            "            group by \n" +
            "              STS_ID\n" +
            "            union all\n" +
            "            select \n" +
            "              2 as consumType，\n" +
            "              '等待门架避让' as consumName，\n" +
            "              STS_ID as qcid,\n" +
            "              sum(EVENT_GAP) as gapTime\n" +
            "            from \n" +
            "              T_STS_CONVERT_EVENT_RECORD\n" +
            "            where\n" +
            "              1=1\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "              and STS_ID = #{craneNum} \n" +
            "              and event_level = 'Level03' \n" +
            "              and gap_type ='WAITPT'   \n" +
            "            group by \n" +
            "              STS_ID\n" +
            "            union all\n" +
            "            select \n" +
            "              3 as consumType，\n" +
            "              '等待异常处理' as consumName，\n" +
            "              STS_ID as qcid,\n" +
            "              sum(EVENT_GAP) as gapTime\n" +
            "            from \n" +
            "              T_STS_CONVERT_EVENT_RECORD\n" +
            "            where\n" +
            "              1=1\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "              and STS_ID = #{craneNum} \n" +
            "              and event_level = 'Level03' \n" +
            "              and gap_type ='EXCEPTIONHANDLE'   \n" +
            "            group by \n" +
            "              STS_ID\n" +
            "            union all\n" +
            "            \n" +
            "            select \n" +
            "              4 as consumType，\n" +
            "              '其他因素耗时' as consumName，\n" +
            "              STS_ID as qcid,\n" +
            "              sum(EVENT_GAP) as gapTime\n" +
            "            from \n" +
            "              T_STS_CONVERT_EVENT_RECORD\n" +
            "            where\n" +
            "              1=1\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "              and STS_ID = #{craneNum} \n" +
            "              and event_level = 'Level03' \n" +
            "              and gap_type ='INSOTHERFACTOR'   \n" +
            "            group by \n" +
            "              STS_ID \n" +
            "            union all\n" +
            "            select \n" +
            "              5 as consumType，\n" +
            "              '指令执行耗时' as consumName，\n" +
            "              STS_ID as qcid,\n" +
            "              sum(EVENT_GAP) as gapTime\n" +
            "            from \n" +
            "              T_STS_CONVERT_EVENT_RECORD\n" +
            "            where\n" +
            "              1=1\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "              and to_char(CURRENT_EVENT_CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "              and STS_ID = #{craneNum} \n" +
            "              and event_level = 'Level03' \n" +
            "              and gap_type ='INSTRUCTIONCOST'  \n" +
            "            group by \n" +
            "              STS_ID  ")
    List<Ins_GapAnalysisVO> getIns_GapData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                  @Param("craneNum") String craneNum);

    /**
     *获取指令作业时间
     * */
    @Select(" select \n" +
            "       1 as consumType，\n" +
            "       '船上抓放箱指令' as consumName，   \n" +
            "       t1.qc_id as qcid，   \n" +
            "       sum(\n" +
            "         (to_date(to_char((t2.updated),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "           to_date(to_char((t2.created),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60\n" +
            "       ) as jobTime\n" +
            "from \n" +
            "       T_STS_TROLLEY_TASK t1,\n" +
            "       T_STS_MT_COMMANDS t2\n" +
            "where\n" +
            "       t1.TASK_ID = t2.task_id\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "       and t1.qc_id = #{craneNum}\n" +
            "       and t2.mtmacrocmdtype in ('PickupShip','GroundVessel')\n" +
            "       and t2.macrocmdstate = 'FINISH'\n" +
            "group by\n" +
            "     t1.qc_id \n" +
            "union all\n" +
            "select \n" +
            "       2 as consumType，\n" +
            "       '平台抓放箱指令' as consumName，\n" +
            "       t1.qc_id as qcid，   \n" +
            "       sum(\n" +
            "         (to_date(to_char((t2.updated),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "           to_date(to_char((t2.created),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60\n" +
            "       ) as jobTime\n" +
            "from \n" +
            "       T_STS_TROLLEY_TASK t1,\n" +
            "       T_STS_MT_COMMANDS t2\n" +
            "where\n" +
            "       t1.TASK_ID = t2.task_id\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "       and t1.qc_id = #{craneNum}\n" +
            "       and t2.mtmacrocmdtype in('PickupPlatform','GroundPlatform')\n" +
            "       and t2.macrocmdstate = 'FINISH'\n" +
            "group by\n" +
            "     t1.qc_id \n" +
            "union all\n" +
            "select \n" +
            "       3 as consumType，\n" +
            "       'Park指令' as consumName，   \n" +
            "       t1.qc_id as qcid，   \n" +
            "       sum(\n" +
            "         (to_date(to_char((t2.updated),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "           to_date(to_char((t2.created),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60\n" +
            "       ) as jobTime\n" +
            "from \n" +
            "       T_STS_TROLLEY_TASK t1,\n" +
            "       T_STS_MT_COMMANDS t2\n" +
            "where\n" +
            "       t1.TASK_ID = t2.task_id\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "       and t1.qc_id = #{craneNum}\n" +
            "       and t2.mtmacrocmdtype = 'Park'\n" +
            "       and t2.macrocmdstate = 'FINISH'\n" +
            "group by\n" +
            "     t1.qc_id \n" +
            "union all\n" +
            "select \n" +
            "       4 as consumType，\n" +
            "       'Apron抓放箱指令' as consumName，  \n" +
            "       t1.qc_id as qcid，   \n" +
            "       sum(\n" +
            "         (to_date(to_char((t2.updated),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "           to_date(to_char((t2.created),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60\n" +
            "       ) as jobTime\n" +
            "from \n" +
            "       T_STS_TROLLEY_TASK t1,\n" +
            "       T_STS_MT_COMMANDS t2\n" +
            "where\n" +
            "       t1.TASK_ID = t2.task_id\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "       and t1.qc_id = #{craneNum}\n" +
            "       and t2.mtmacrocmdtype in('PickupbackreackApron','GroundtoBackreackApron')\n" +
            "       and t2.macrocmdstate = 'FINISH'\n" +
            "group by\n" +
            "     t1.qc_id\n" +
            "union all\n" +
            "select \n" +
            "       5 as consumType，\n" +
            "       'AGV抓放箱指令' as consumName，  \n" +
            "       t1.qc_id as qcid，   \n" +
            "       sum(\n" +
            "         (to_date(to_char((t2.updated),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "           to_date(to_char((t2.created),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60\n" +
            "       ) as jobTime\n" +
            "from \n" +
            "       T_STS_TROLLEY_TASK t1,\n" +
            "       T_STS_MT_COMMANDS t2\n" +
            "where\n" +
            "       t1.TASK_ID = t2.task_id\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "       and to_char(t2.CREATED,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "       and t1.qc_id = #{craneNum}\n" +
            "       and t2.mtmacrocmdtype in('PickupAgv','GroundtoAGV')\n" +
            "       and t2.macrocmdstate = 'FINISH'\n" +
            "group by\n" +
            "     t1.qc_id ")
    List<Ins_TimeAnalysisVO> getInsTimeData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                   @Param("craneNum") String craneNum);

}
