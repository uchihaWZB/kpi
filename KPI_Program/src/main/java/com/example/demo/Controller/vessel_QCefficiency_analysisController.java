package com.example.demo.Controller;

import com.example.demo.Controller.common.JsonResult;
import com.example.demo.Controller.jsonobject.JsonQC_CommandPO;
import com.example.demo.Controller.selectdata.QCHomework_time;
import com.example.demo.Controller.selectdata.VesselList;
import com.example.demo.model.QC_CommandPO;
import com.example.demo.model.STS_SHIPTCGPO;
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

        System.out.println("+++++++++++++++船时效率分析++++++++++++++++++++");
        return "vessel_QCefficiency_analysis";
    }

    @RequestMapping(value = "vessel_QCefficiency_analysisChart1",method = RequestMethod.GET)
    public  @ResponseBody JsonResult vessel_QCefficiency_analysisChart(String vessel_voyage,String qcEfficiencyType) {

        System.out.println("++++++++++++加载船时效率分析++++++++++++");
        result.getData().clear();
        //System.out.println("vessel_voyage+++++++++   "+vessel_voyage);

        if("1".equals(qcEfficiencyType)){

            qcEfficiencyType = "count(DISTINCT(t1.command_gkey))";
        }else if("2".equals(qcEfficiencyType)){

            qcEfficiencyType = "count(DISTINCT(t1.transaction_id))";
        }else {
            qcEfficiencyType = "0";
        }

        List<VesselQCPO>  vesselQCList  = vessel_QCefficiency_analysisService.getVesselQC(vessel_voyage,qcEfficiencyType.toString());

        result.setResult("ok");
        result.getData().put("rows",vesselQCList);
        return result;
    }

    @RequestMapping(value = "vessel_voyageList",method = RequestMethod.GET)
    public @ResponseBody JsonResult vessel_voyageList(String vesselInfo) {

        System.out.println("++++++++++++加载船次信息++++++++++++");
        //System.out.println(vesselInfo);

        List<VesselList> vessel_voyageList = vessel_QCefficiency_analysisService.getVessel_voyage(vesselInfo);


        System.out.println(vessel_voyageList.get(0).getVessel_visit());
        System.out.println(vessel_voyageList.size()+"UUUUUUUUUUUUUU");

        result.getData().put("rows",vessel_voyageList);
        return result;
    }

    @RequestMapping(value = "getPieData",method = RequestMethod.GET)
    public @ResponseBody JsonResult getPieData(String QCID) {

        System.out.println("++++++++++++加载task耗时信息++++++++++++");
        //System.out.println(vesselInfo);

        List<QCHomework_time> pieDataList = vessel_QCefficiency_analysisService.getPieData(QCID);


        result.setResult("ok");
        result.getData().put("rows",pieDataList);
        return result;
    }



}
