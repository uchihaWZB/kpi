package com.example.demo.mapper.dao;

import com.example.demo.model.BerthStatusPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据 vesselVisit 获取 vesselName
     *
     * @param vessel_visit
     * @return
     */
    @Select("SELECT VESSEL_NAME FROM BERTH_STATUS WHERE VESSEL_VISIT = #{vessel_visit}")
    String getVesselNameByVesselVisit(@Param("vessel_visit") String vessel_visit);
}
