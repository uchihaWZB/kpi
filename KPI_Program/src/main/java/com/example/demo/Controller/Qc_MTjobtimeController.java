package com.example.demo.Controller;

import com.example.demo.Controller.common.JsonResult;
import com.example.demo.Controller.jsonobject.JsonMTjobtime;
import com.example.demo.service.MTjobtimeService;
import com.example.demo.vo.MTjobtime;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
public class Qc_MTjobtimeController extends BaseAction {

    private static Logger logger = Logger.getLogger(Qc_MTjobtimeController.class);

    @Autowired
    private MTjobtimeService mTjobtimeService;

    @RequestMapping(value = "qc_MTjobtime",method = RequestMethod.GET)
    public String qc_MTjobtime() {

        System.out.println("+++++++++++++++主副小车作业时间++++++++++++++++++++");
        return "qc_MTjobtime";
    }

    @RequestMapping(value = "getMTjobtimedata",method = RequestMethod.GET)
    public @ResponseBody JsonResult getMTjobtimedata(String startDateTime,String endDateTime,String craneNum) {

        System.out.println("+++++++++++++++获取主副小车作业时间++++++++++++++++++++");
        /*// 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录warn级别的信息
        logger.info("This is warn message.");
        // 记录error级别的信息
        logger.error("This is error message.");*/

        List<JsonMTjobtime> jsonMTSLjobtimeList = new LinkedList<JsonMTjobtime>();
        List<JsonMTjobtime> jsonMTALjobtimeList = new LinkedList<JsonMTjobtime>();
        List<MTjobtime> MTjobtimeList = mTjobtimeService.getMTjobtimedata(startDateTime,endDateTime,craneNum);

        System.out.println(startDateTime+"  YY  "+endDateTime+"   TTT  "+craneNum);
        if(!CollectionUtils.isEmpty(MTjobtimeList)){

            for (MTjobtime mTjobtime:MTjobtimeList){

                if(mTjobtime.getType().equals("10SL")){

                    JsonMTjobtime jsonMTSLjobtime = new JsonMTjobtime(mTjobtime);
                    jsonMTSLjobtimeList.add(jsonMTSLjobtime);
                }else {

                    JsonMTjobtime jsonMTALjobtime = new JsonMTjobtime(mTjobtime);
                    jsonMTALjobtimeList.add(jsonMTALjobtime);
                }
            }
        }

        //System.out.println(jsonMT_PTjobtimeList.get(0).getCreateTimedDisp());
        System.out.println(jsonMTSLjobtimeList.size());
        System.out.println(jsonMTALjobtimeList.size());
        result.setResult("ok");
        result.getData().put("rowsMTSL",jsonMTSLjobtimeList);
        result.getData().put("rowsMTAL",jsonMTALjobtimeList);
        return result;
    }




}
