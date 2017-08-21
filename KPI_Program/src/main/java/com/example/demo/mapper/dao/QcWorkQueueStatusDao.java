package com.example.demo.mapper.dao;

import com.example.demo.model.QcWorkQueueStatusPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lenovopc001 on 2017/7/17.
 */
@Mapper
public interface QcWorkQueueStatusDao {

    /**
     * 获得所有QcWorkQueueStatusPO记录
     *
     * @return List
     */
    @Select("SELECT * FROM QC_WORK_QUEUE_STATUS")
    List<QcWorkQueueStatusPO> getAllQcWorkQueueStatusPO();
}
