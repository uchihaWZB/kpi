package com.example.demo.Controller;

import com.example.demo.Controller.common.JsonResult;
import com.example.demo.Controller.jsonobject.JsonMT_PTjobtime;
import com.example.demo.Controller.selectdata.QCHomework_time;
import com.example.demo.Controller.selectdata.VesselList;
import com.example.demo.Controller.selectdata.VesselQCPO;
import com.example.demo.service.MT_PTjobtimeService;
import com.example.demo.service.QcEfficiencyAnalysisService;
import com.example.demo.service.Vessel_QCefficiency_analysisService;
import com.example.demo.vo.MT_PTjobtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by gcq on 2017/9/1.
 */
@Controller
@RequestMapping("/")
public class qc_MTandPT_jobtimeController extends BaseAction {

    private static Logger logger = Logger.getLogger(qc_MTandPT_jobtimeController.class);

    @Autowired
    private MT_PTjobtimeService mT_PTjobtimeService;

    @RequestMapping(value = "qc_MTandPT_jobtime",method = RequestMethod.GET)
    public String getQcEfficiencyAnalysis() {

        System.out.println("+++++++++++++++主副小车作业时间++++++++++++++++++++");
        return "qc_MTandPT_jobtime";
    }

    @RequestMapping(value = "getMT_PTjobtimedata",method = RequestMethod.GET)
    public @ResponseBody JsonResult getMT_PTjobtimedata(String startDateTime,String endDateTime,String craneNum) {

        System.out.println("+++++++++++++++获取主副小车作业时间++++++++++++++++++++");
        /*// 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录warn级别的信息
        logger.info("This is warn message.");
        // 记录error级别的信息
        logger.error("This is error message.");*/

        List<JsonMT_PTjobtime> jsonMTjobtimeList = new LinkedList<JsonMT_PTjobtime>();
        List<JsonMT_PTjobtime> jsonPTjobtimeList = new LinkedList<JsonMT_PTjobtime>();
        List<MT_PTjobtime> MT_PTjobtimeList = mT_PTjobtimeService.getMT_PTjobtimedata(startDateTime,endDateTime,craneNum);

        System.out.println(startDateTime+"  YY  "+endDateTime+"   TTT  "+craneNum);
        if(!CollectionUtils.isEmpty(MT_PTjobtimeList)){

            for (MT_PTjobtime mT_PTjobtime:MT_PTjobtimeList){

                if(mT_PTjobtime.getType().equals("1MT")){

                    JsonMT_PTjobtime jsonMTjobtime = new JsonMT_PTjobtime(mT_PTjobtime);
                    jsonMTjobtimeList.add(jsonMTjobtime);
                }else {

                    JsonMT_PTjobtime jsonPTjobtime = new JsonMT_PTjobtime(mT_PTjobtime);
                    jsonPTjobtimeList.add(jsonPTjobtime);
                }
            }
        }

        //System.out.println(jsonMT_PTjobtimeList.get(0).getCreateTimedDisp());
        System.out.println(jsonMTjobtimeList.size());
        System.out.println(jsonPTjobtimeList.size());
        result.setResult("ok");
        result.getData().put("rowsMT",jsonMTjobtimeList);
        result.getData().put("rowsPT",jsonPTjobtimeList);
        return result;
    }




}
