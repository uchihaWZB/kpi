package com.example.demo.Controller;

import com.example.demo.service.QcEfficiencyAnalysisService;
import com.example.demo.service.Vessel_QCefficiency_analysisService;
import com.example.demo.utils.returnMessage.ReturnMsg;
import com.example.demo.vo.QcProductivityOfVesselVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * @description 船舶-岸桥作业效率Controller
 *
 * @author WZB
 * @date   2017-08-30
 */

@Controller
@RequestMapping("vessel_qc_productivity")
public class VesselQcProductivityController {

    @Autowired
    private QcEfficiencyAnalysisService qcEfficiencyAnalysisService;

    /**
     * @description 初始化 船时效率 界面
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String initVesselQcProductivity(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Map<String, Object>> listMap = new ArrayList<>();

        listMap = qcEfficiencyAnalysisService.getAllVesselProductivity();

        model.addAttribute("vesselQcProductivitys", listMap);

        return "vessel_qc_productivity";
    }

    /**
     * 获得选定到访船次下的岸桥作业效率
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/qcProOfVessel", method = RequestMethod.GET)
    @ResponseBody
    public ReturnMsg<List<QcProductivityOfVesselVO>> getQcProductivityOfVessel(HttpServletRequest request, HttpServletResponse response) {
        ReturnMsg<List<QcProductivityOfVesselVO>> rm = new ReturnMsg<>();

        List<QcProductivityOfVesselVO> listQcProOfVessels = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();

        String vesselName = request.getParameter("vesselName");

        listQcProOfVessels = qcEfficiencyAnalysisService.getAllQcProductivityByVesselName(vesselName);

        rm.setResult(listQcProOfVessels);

        return rm;
    }
}
