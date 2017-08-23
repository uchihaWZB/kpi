package com.example.demo.mapper.dao;

import com.example.demo.model.BerthStatusPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by WZB on 2017/7/5.
 *
 * BerthVesselDao 接口类
 */

@Mapper
public interface BerthVesselDao {

    /**
     * 获得所有BerthStatusPO记录
     *
     * @return List
     */
    @Select("SELECT * FROM BERTH_STATUS")
    List<BerthStatusPO> getAllBerthStatusPO();
}
