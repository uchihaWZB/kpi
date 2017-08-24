package com.example.demo.mapper.dao;

import com.example.demo.model.QC_CommandPO;

import com.example.demo.vo.QcJobEfficiencyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by WZB on 2017/7/18.
 */
@Mapper
public interface Qc_CommandDao {

    /**
     * 获得所有Qc_CommandPO记录
     *
     * @return List
     */
    //@Select("SELECT COMMAND_GKEY AS commandGkey FROM QC_COMMANDS")
    @Select("select " +
            "to_date(CONCAT(t.creatTime,':00:00'),'YYYY-MM-DD hh24:mi:ss') as created," +
            "t.qc_id as qcId," +
            "count(t.qc_id) as quanOfWork\n" +
            "    from\n" +
            "    (select qc_id,to_char(created,'YYYY-MM-DD HH24') as creatTime\n" +
            "    from QC_COMMANDS) t\n" +
            "    group by t.creatTime ,t.qc_id\n" +
            "    order by t.creatTime desc")
    public List<QC_CommandPO> getAllQcCommandPO();

    /**
     * 获得每个岸桥在固定时间段内的工作总量
     *
     * @return
     */
    @Select("SELECT "
            + "qcId, "
            + "created, "
            + "COUNT(DISTINCT(${qcEfficiencyType})) AS qcWorkCount\n"
            +"FROM\n"
            +" (SELECT ${qcEfficiencyType}, QC_ID AS qcId, TO_CHAR(CREATED, 'yyyy-mm-dd hh24') AS created\n"
            +"  FROM QC_COMMANDS)\n"
            +"WHERE "
            +"created >= #{startTime} AND "
            +"created <= #{endTime}"
            +"GROUP BY created,qcId\n"
            +"ORDER BY created,qcId")
    List<QcJobEfficiencyVO> getAllQcWorkEfficiencyCount(@Param("qcEfficiencyType") String qcEfficiencyType,
                                                        @Param("startTime") String startTime,
                                                        @Param("endTime") String endTime);

}
