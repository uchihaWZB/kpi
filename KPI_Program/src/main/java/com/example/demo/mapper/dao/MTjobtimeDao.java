package com.example.demo.mapper.dao;

import com.example.demo.vo.MTjobtime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
@Mapper
public interface MTjobtimeDao {

    /**
     *获取MT和PT作业时间
     * */
    @Select("select \n" +
            "  t.flstate as type,\n" +
            "  t.createTime as createTime,\n" +
            "  t.jobtime as jobtime\n" +
            "from \n" +
            "  (select\n" +
            "    '10SL' as flstate,\n" +
            "    t2.flowmodel_st as createTime,\n" +
            "    (to_date(to_char((t2.FLOWMODEL_ET),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "         to_date(to_char((t2.FLOWMODEL_ST),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60 as jobtime          \n" +
            "  from \n" +
            "    KPI_STS_MT t1,\n" +
            "    KPI_STS_FM t2 \n" +
            "  where \n" +
            "    to_char(t2.flowmodel_st,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "    and to_char(t2.flowmodel_st,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "    and t1.accs_mt_id = t2.fmmtid\n" +
            "    and t2.flowmodelstate = 10\n" +
            "    and t2.fmqcid = #{craneNum}\n" +
            "    and t1.mtcmdstate in (2,4,6)\n" +
            "  UNION all \n" +
            "  select\n" +
            "    '12SL' as flstate,\n" +
            "    t4.flowmodel_st as createTime,\n" +
            "    (to_date(to_char((t4.FLOWMODEL_ET),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss') - \n" +
            "         to_date(to_char((t4.FLOWMODEL_ST),'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD hh24:mi:ss'))*24*60*60 as jobtime          \n" +
            "  from \n" +
            "    KPI_STS_MT t3,\n" +
            "    KPI_STS_FM t4 \n" +
            "  where \n" +
            "    to_char(t4.flowmodel_st,'YYYY-MM-DD hh24:mi:ss') > #{startDateTime}\n" +
            "    and to_char(t4.flowmodel_st,'YYYY-MM-DD hh24:mi:ss') < #{endDateTime}\n" +
            "    and t3.accs_mt_id = t4.fmmtid\n" +
            "    and t4.flowmodelstate = 12\n" +
            "    and t4.fmqcid = #{craneNum}\n" +
            "    and t3.mtcmdstate in (2,4,6)\n" +
            "  ) t\n" +
            "order by \n" +
            "      t.flstate,t.createTime ")
    public List<MTjobtime> getMTjobtimedata(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                            @Param("craneNum") String craneNum);
}
