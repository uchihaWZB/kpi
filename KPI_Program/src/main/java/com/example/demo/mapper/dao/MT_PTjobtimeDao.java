package com.example.demo.mapper.dao;

import com.example.demo.Controller.selectdata.QCHomework_time;
import com.example.demo.vo.MT_PTjobtime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
@Mapper
public interface MT_PTjobtimeDao {

    /**
     *获取MT和PT作业时间
     * */
    @Select("select\n" +
            "  t.type as type,\n" +
            "  t.qcid as qcid,\n" +
            "  t.createTime as createTime,\n" +
            "  t.jobtime as jobtime\n" +
            "from \n" +
            "  (\n" +
            "    select \n" +
            "      '1MT' as type,\n" +
            "      mtqcid as qcid,\n" +
            "      mtcmdstarttime as createTime,\n" +
            "      (to_date(to_char((mtcmdendtime),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "      to_date(to_char((mtcmdstarttime),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60 as jobtime\n" +
            "    from \n" +
            "      KPI_STS_MT\n" +
            "    where \n" +
            "      1=1\n" +
            "      and mtqcid = #{craneNum}\n" +
            "      and to_char(mtcmdstarttime,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "      and to_char(mtcmdstarttime,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "    UNION all\n" +
            "    select \n" +
            "      '2PT' as type,\n" +
            "      ptqcid as qcid,\n" +
            "      ptcmdstarttime as createTime,\n" +
            "      (to_date(to_char((ptcmdendtime),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "      to_date(to_char((ptcmdstarttime),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60 as jobtime\n" +
            "    from \n" +
            "    KPI_STS_PT\n" +
            "    where \n" +
            "      1=1\n" +
            "      and ptqcid = #{craneNum}\n" +
            "      and to_char(ptcmdstarttime,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "      and to_char(ptcmdstarttime,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "  )t\n" +
            "order by \n" +
            "      t.type,t.createTime desc\n")
    public List<MT_PTjobtime> getMT_PTjobtimedata(@Param("startDateTime") String startDateTime,@Param("endDateTime") String endDateTime,
                                                  @Param("craneNum") String craneNum);
}
