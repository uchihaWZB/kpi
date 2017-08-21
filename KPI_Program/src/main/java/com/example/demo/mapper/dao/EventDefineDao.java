package com.example.demo.mapper.dao;

import com.example.demo.model.EventDefinePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 事件定义 DAO 接口类
 *
 * Created by lenovopc001 on 2017/8/9.
 */

@Mapper
public interface EventDefineDao {

    /**
     * 获得所有事件定义信息
     * @return
     */
    @Select("SELECT * FROM STS_EVENT_DEFINE")
    List<EventDefinePO> getAllEventDefine();

    /**
     * 根据事件Id获得对应的事件名
     * @param eventId
     * @return
     */
    @Select("SELECT "
            + "EVENT_NAME\n"
            + "FROM\n"
            + "STS_EVENT_DEFINE\n"
            + "WHERE\n"
            + "EVENT_ID = #{eventId}")
    String getEventNameById(int eventId);

}
