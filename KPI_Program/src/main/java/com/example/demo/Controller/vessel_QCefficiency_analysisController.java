package com.example.demo.Controller;

import com.example.demo.Controller.common.JsonResult;
import com.example.demo.Controller.jsonobject.JsonQC_CommandPO;
import com.example.demo.model.QC_CommandPO;
import com.example.demo.service.QcEfficiencyAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Controller.selectdata.VesselQCPO;
import com.example.demo.service.Vessel_QCefficiency_analysisService;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gcq on 2017/8/22.
 */
@Controller
@RequestMapping("/")
public class vessel_QCefficiency_analysisController extends BaseAction {

    @Autowired
    private QcEfficiencyAnalysisService qcEfficiencyAnalysisService;

    @Autowired
    private Vessel_QCefficiency_analysisService vessel_QCefficiency_analysisService;

    @RequestMapping(value = "vessel_QCefficiency_analysis",method = RequestMethod.GET)
    public String getQcEfficiencyAnalysis() {

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        return "vessel_QCefficiency_analysis";
    }

    @RequestMapping(value = "vessel_QCefficiency_analysisChart",method = RequestMethod.GET)
    public  @ResponseBody JsonResult vessel_QCefficiency_analysisChart(String vessel_voyage) {

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        result.getData().clear();
        System.out.println("vessel_voyage+++++++++   "+vessel_voyage);

        List<VesselQCPO>  vesselQCList  = vessel_QCefficiency_analysisService.getVesselQC();

        /*for (VesselQCPO vesselQCPO: vesselQCList){

            vesselQCPO.getQc_id();

        }*/

        result.setResult("ok");
        result.getData().put("rows",vesselQCList);

        return result;
    }

}
