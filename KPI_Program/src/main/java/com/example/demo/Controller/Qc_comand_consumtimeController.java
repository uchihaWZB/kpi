package com.example.demo.Controller;

import com.example.demo.Controller.common.JsonResult;
import com.example.demo.service.Qc_Comand_ConsumtimeService;
import com.example.demo.vo.Ins_GapAnalysisVO;
import com.example.demo.vo.Ins_TimeAnalysisVO;
import com.example.demo.vo.consumTotalTimeVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gcq on 2017/9/1.
 */
@Controller
@RequestMapping("/")
public class Qc_comand_consumtimeController extends BaseAction {

    private static Logger logger = Logger.getLogger(Qc_comand_consumtimeController.class);

    @Autowired
    private Qc_Comand_ConsumtimeService qc_Comand_ConsumtimeService;

    @RequestMapping(value = "qc_comand_consumtime",method = RequestMethod.GET)
    public String qc_comand_consumtime() {

        logger.info("+++++++++++++++岸桥指令层耗时分析++++++++++++++++++++");

        return "qc_comand_consumtime";
    }

    @RequestMapping(value = "consumTotalTimeAnalysis",method = RequestMethod.GET)
    public @ResponseBody JsonResult consumTotalTimeAnalysis(String startDateTime,String endDateTime,String craneNum){

        logger.info("+++++++++++++++耗时总计分析++++++++++++++++++++");

        List<consumTotalTimeVO> consumTotalList = qc_Comand_ConsumtimeService.getconsumTotalTimeData(startDateTime,endDateTime,craneNum);

        System.out.println(consumTotalList.size()+"    YYY");
        result.getData().put("consumTotalList",consumTotalList);
        result.setResult("ok");
        return result;
    }

    @RequestMapping(value = "insGapAnalysis",method = RequestMethod.GET)
    public @ResponseBody JsonResult insGapAnalysis(String startDateTime,String endDateTime,String craneNum){

        logger.info("+++++++++++++++指令gap耗时分析++++++++++++++++++++");

        List<Ins_GapAnalysisVO> Ins_GapList = qc_Comand_ConsumtimeService.getIns_GapData(startDateTime,endDateTime,craneNum);

        System.out.println(Ins_GapList.size());
        result.getData().put("Ins_GapList",Ins_GapList);
        result.setResult("ok");
        return result;
    }

    @RequestMapping(value = "InsTimeAnalysis",method = RequestMethod.GET)
    public @ResponseBody JsonResult InsTimeAnalysis(String startDateTime,String endDateTime,String craneNum){

        logger.info("+++++++++++++++指令时间分析++++++++++++++++++++");

        List<Ins_TimeAnalysisVO> Ins_TimeList = qc_Comand_ConsumtimeService.getInsTimeData(startDateTime,endDateTime,craneNum);

        System.out.println(Ins_TimeList.size());

        result.getData().put("Ins_TimeList",Ins_TimeList);
        result.setResult("ok");
        return result;
    }
}
