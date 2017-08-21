package com.example.demo.mapper.dao;

import com.example.demo.model.EventRecordPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 事件记录 DAO 接口类
 *
 * Created by lenovopc001 on 2017/8/9.
 */

@Mapper
public interface EventRecordDao {

    /**
     * 获得所有事件记录的信息
     * @return
     */
    @Select("SELECT * FROM STS_EVENT_RECORD")
    List<EventRecordPO> getAllEventRecord();

    /**
     * 根据事件记录Id获得对应EventRecordPO记录
     *
     * @param id
     * @return
     */
    @Select("SELECT "
                + "*\n"
           +"FROM\n"
                + "STS_EVENT_RECORD\n"
           +"WHERE\n"
                + "ID = #{id}")
    EventRecordPO getEventRecordPOById(int id);
}
