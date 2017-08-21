package com.example.demo.mapper.dao;

import com.example.demo.model.QC_StatusPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lenovopc001 on 2017/8/11.
 */

@Mapper
public interface Qc_StatusDao {

    @Select("SELECT * FROM QC_STATUS")
    List<QC_StatusPO> getAllQcStatusPO();
}
