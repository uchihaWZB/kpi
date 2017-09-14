package com.example.demo.service.impl;

import com.example.demo.mapper.dao.Qc_Comand_ConsumtimeDao;
import com.example.demo.service.Qc_Comand_ConsumtimeService;
import com.example.demo.vo.Ins_GapAnalysisVO;
import com.example.demo.vo.Ins_TimeAnalysisVO;
import com.example.demo.vo.consumTotalTimeVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
@Service("Qc_Comand_ConsumtimeService")
public class Qc_Comand_ConsumtimeServiceImpl implements Qc_Comand_ConsumtimeService {

    @Autowired
    private Qc_Comand_ConsumtimeDao qc_Comand_ConsumtimeDao;

    public List<consumTotalTimeVO> getconsumTotalTimeData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                  @Param("craneNum") String craneNum){

        return qc_Comand_ConsumtimeDao.getconsumTotalTimeData(startDateTime,endDateTime,craneNum);
    }

    public List<Ins_GapAnalysisVO> getIns_GapData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                  @Param("craneNum") String craneNum){

        return qc_Comand_ConsumtimeDao.getIns_GapData(startDateTime,endDateTime,craneNum);
    }

    public List<Ins_TimeAnalysisVO> getInsTimeData(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                                   @Param("craneNum") String craneNum){

        return qc_Comand_ConsumtimeDao.getInsTimeData(startDateTime,endDateTime,craneNum);
    }

}
