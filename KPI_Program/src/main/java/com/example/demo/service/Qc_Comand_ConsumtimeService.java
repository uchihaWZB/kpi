package com.example.demo.service;

import com.example.demo.vo.Ins_GapAnalysisVO;
import com.example.demo.vo.Ins_TimeAnalysisVO;
import com.example.demo.vo.consumTotalTimeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
public interface Qc_Comand_ConsumtimeService {

    /**
     * 获取作业和间隔耗时总计
     * */
    public List<consumTotalTimeVO> getconsumTotalTimeData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                  @Param("craneNum") String craneNum);

    /**
     * 获取指令gap时间
     * */
    public List<Ins_GapAnalysisVO> getIns_GapData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                    @Param("craneNum") String craneNum);

    /**
     * 获取指令作业时间
     * */
    public List<Ins_TimeAnalysisVO> getInsTimeData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                   @Param("craneNum") String craneNum);

}
