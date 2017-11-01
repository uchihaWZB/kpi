package com.example.demo.mapper.dao;

import com.example.demo.model.T_STS_ConvertEventRecordPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by lenovopc001 on 2017/10/27.
 */
@Mapper
@Entity
@Table(name = "T_STS_CONVERT_EVENT_RECORD")
public interface T_STS_ConvertEventRecordDao {

    @Select("SELECT * FROM T_STS_CONVERT_EVENT_RECORD")
    List<T_STS_ConvertEventRecordPO> getAll();

    /**
     * 根据 STS_ID 查询事件记录
     *
     * @param stsId
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT *\n"
            +"FROM T_STS_CONVERT_EVENT_RECORD\n"
            +"WHERE STS_ID = #{stsId}\n"
            +"AND TO_CHAR(CURRENT_EVENT_CREATED,'yyyy-mm-dd hh24:mi:ss') >= #{startTime}\n"
            +"AND TO_CHAR(CURRENT_EVENT_CREATED,'yyyy-mm-dd hh24:mi:ss') <= #{endTime}")
    List<T_STS_ConvertEventRecordPO> getConvertEventResultPOBySTSId(@Param("stsId") String stsId,
                                                                    @Param("startTime") String startTime,
                                                                    @Param("endTime") String endTime);
}
