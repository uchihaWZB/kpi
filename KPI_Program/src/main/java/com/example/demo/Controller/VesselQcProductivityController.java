package com.example.demo.Controller;

import com.example.demo.service.QcEfficiencyAnalysisService;
import com.example.demo.service.Vessel_QCefficiency_analysisService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.returnMessage.ReturnMsg;
import com.example.demo.vo.QcProductivityOfVesselVO;
import com.example.demo.vo.QcTaskInfoVO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.*;

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

    private String startTime = "0000-00-00 00";         // 预设查询开始时间
    private String endTime = "9999-99-99 99";           // 预设查询结束时间

    private DecimalFormat df = new DecimalFormat("#.00");

    /**
     * @description 初始化 船时效率 界面
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String initVesselQcProductivity(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<Map<String, Object>> listMap = new ArrayList<>();

        listMap = qcEfficiencyAnalysisService.getAllVesselProductivity(startTime, endTime);

        model.addAttribute("vesselQcProductivitys", listMap);

        return "vessel_qc_productivity";
    }

    /**
     * 根据船次工作时间查询船时效率
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryByTime", method = RequestMethod.GET)
    @ResponseBody
    public ReturnMsg<List<Map<String, Object>>> getVesselQcProByTime(HttpServletRequest request, HttpServletResponse response) {
        ReturnMsg<List<Map<String, Object>>> rm = new ReturnMsg<>();

        List<Map<String, Object>> listVesselPros = new ArrayList<>();

        String vesselDate = request.getParameter("vesselDate");

        String startTime = "0000-00-00 00";         // 预设开始时间
        String endTime = "9999-99-99 99";           // 预设结束时间

        // 根据船时岸桥工作时间进行筛选
        if (!StringUtils.isEmpty(vesselDate)) {

            String[] vesselTime = StringUtils.split(vesselDate, " - ");
            if (!StringUtils.isEmpty(vesselTime[0])) {

                startTime = vesselTime[0];
            }
            if (!StringUtils.isEmpty(vesselTime[1])) {

                endTime = vesselTime[1];
            }
        }
        listVesselPros = qcEfficiencyAnalysisService.getAllVesselProductivity(startTime, endTime);

        rm.setResult(listVesselPros);

        return rm;
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

    @RequestMapping(value = "/qcTaskEventConsume", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTaskEventConsumeByQcId(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<>();

        String qcId = request.getParameter("qcId");

        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(qcId)) {

            map = qcEfficiencyAnalysisService.getQcTaskEventConsumeByQcId(qcId);
        } else {
            ;
        }

        List<QcTaskInfoVO> listTaskCost = (ArrayList)map.get("listTaskCost");
        List<QcTaskInfoVO> listTaskGap = (ArrayList)map.get("listTaskGap");

        Double workQueueConsume = 0d;
        Double wiciConsume = 0d;
        Double ocrConsume = 0d;
        Double pfLockConsume = 0d;
        Double stsRebootConsume = 0d;
        Double mtManualConsume = 0d;
        Double stsPerformanceConsume = 0d;

        Double changeBayConsume = 0d;
        Double parkTaskConsume = 0d;
        Double normalTaskConsume = 0d;

        for (QcTaskInfoVO vo : listTaskGap) {
            if (Constant.WAIT_WORK_QUEUE_TYPE.contains(vo.getGapId())) {

                workQueueConsume += vo.getEventConsume();
            } else if (Constant.WAIT_WI_CI_TYPE.contains(vo.getGapId())) {

                wiciConsume += vo.getEventConsume();
            } else if (Constant.WAIT_OCR_TYPE.contains(vo.getGapId())) {

                ocrConsume += vo.getEventConsume();
            } else if (Constant.WAIT_PF_LOCK_TYPE.contains(vo.getGapId())) {

                pfLockConsume += vo.getEventConsume();
            } else if (Constant.WAIT_STSMS_REBOOT_TYPE.contains(vo.getGapId())) {

                stsRebootConsume += vo.getEventConsume();
            } else if (Constant.MT_MANUAL_MODE_TYPE.contains(vo.getGapId())) {

                mtManualConsume += vo.getEventConsume();
            } else if (Constant.WAIT_STSMS_PERFORMANCE_TYPE.contains(vo.getGapId())) {

                stsPerformanceConsume += vo.getEventConsume();
            }
        }

        for (QcTaskInfoVO vo : listTaskCost) {
            if (Constant.CHANGE_BAY_COST_TYPE.contains(vo.getGapId())) {

                changeBayConsume += vo.getEventConsume();
            } else if (Constant.PARK_TASK_COST_TYPE.contains(vo.getGapId())) {

                parkTaskConsume += vo.getEventConsume();
            } else if (Constant.NORMAL_TASK_COST_TYPE.contains(vo.getGapId())) {

                normalTaskConsume += vo.getEventConsume();
            }
        }

        List<Map<String, Object>> listGapResult = new ArrayList<>();
        List<Map<String, Object>> listCostResult = new ArrayList<>();

        if (workQueueConsume.compareTo(0.00d) > 0) {
            Map<String, Object> wqMap = new HashMap<>();
            wqMap.put("name", Constant.WAIT_WORK_QUEUE);
            wqMap.put("value", df.format(workQueueConsume));
            listGapResult.add(wqMap);
        }
        if (ocrConsume.compareTo(0.00d) > 0) {
            Map<String, Object> ocrMap = new HashMap<>();
            ocrMap.put("name", Constant.WAIT_OCR);
            ocrMap.put("value", df.format(ocrConsume));
            listGapResult.add(ocrMap);
        }
        if (wiciConsume.compareTo(0.00d) > 0) {
            Map<String, Object> wiciMap = new HashMap<>();
            wiciMap.put("name", Constant.WAIT_WI_CI);
            wiciMap.put("value", df.format(wiciConsume));
            listGapResult.add(wiciMap);
        }
        if (pfLockConsume.compareTo(0.00d) > 0) {
            Map<String, Object> pfMap = new HashMap<>();
            pfMap.put("name", Constant.WAIT_PF_LOCK);
            pfMap.put("value", df.format(pfLockConsume));
            listGapResult.add(pfMap);
        }
        if (stsRebootConsume.compareTo(0.00d) > 0) {
            Map<String, Object> stsRebootMap = new HashMap<>();
            stsRebootMap.put("name", Constant.WAIT_STSMS_REBOOT);
            stsRebootMap.put("value", df.format(stsRebootConsume));
            listGapResult.add(stsRebootMap);
        }
        if (mtManualConsume.compareTo(0.00d) > 0) {
            Map<String, Object> mtMap = new HashMap<>();
            mtMap.put("name", Constant.MT_MANUAL_MODE);
            mtMap.put("value", df.format(mtManualConsume));
            listGapResult.add(mtMap);
        }
        if (stsPerformanceConsume.compareTo(0.00d) > 0) {
            Map<String, Object> stsPerformanceMap = new HashMap<>();
            stsPerformanceMap.put("name", Constant.WAIT_STSMS_PERFORMANCE);
            stsPerformanceMap.put("value", df.format(stsPerformanceConsume));
            listGapResult.add(stsPerformanceMap);
        }
        if (changeBayConsume.compareTo(0.00d) > 0) {
            Map<String, Object> changeBayMap = new HashMap<>();
            changeBayMap.put("name", Constant.CHANGE_BAY_COST);
            changeBayMap.put("value", df.format(changeBayConsume));
            listCostResult.add(changeBayMap);
        }
        if (parkTaskConsume.compareTo(0.00d) > 0) {
            Map<String, Object> parkMap = new HashMap<>();
            parkMap.put("name", Constant.PARK_TASK_COST);
            parkMap.put("value", df.format(parkTaskConsume));
            listCostResult.add(parkMap);
        }
        if (normalTaskConsume.compareTo(0.00d) > 0) {
            Map<String, Object> normalMap = new HashMap<>();
            normalMap.put("name", Constant.NORMAL_TASK_COST);
            normalMap.put("value", df.format(normalTaskConsume));
            listCostResult.add(normalMap);
        }

        result.put("allTaskCostConsume", listCostResult);
        result.put("allTaskGapConsume", listGapResult);
        result.put("totalTaskCost", map.get("taskCost"));
        result.put("totalTaskGap", map.get("taskGap"));

        return result;
    }
}
