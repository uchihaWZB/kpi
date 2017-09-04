package com.example.demo.service;

import com.example.demo.vo.MT_PTjobtime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
public interface MT_PTjobtimeService{

    /**
     * 获取MT和PT作业时间
     * */
    public List<MT_PTjobtime> getMT_PTjobtimedata(@Param("startDateTime") String startDateTime,@Param("endDateTime") String endDateTime,
                                                  @Param("craneNum") String craneNum);

}
