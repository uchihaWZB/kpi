package com.example.demo.Controller;

import com.example.demo.model.EventResultPO;
import com.example.demo.model.T_STS_ConvertEventRecordPO;
import com.example.demo.service.QcEfficiencyAnalysisService;
import com.example.demo.service.Vessel_QCefficiency_analysisService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.returnMessage.ReturnMsg;
import com.example.demo.vo.QcProductivityOfVesselVO;
import com.example.demo.vo.QcTaskInfoVO;
import org.apache.commons.lang3.time.DateFormatUtils;
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

    private String startTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd 00:00:00");         // 预设查询开始时间
    private String endTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");           // 预设查询结束时间

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
     * 根据船次工作的各种参数查询船时效率
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryByParams", method = RequestMethod.GET)
    @ResponseBody
    public ReturnMsg<List<Map<String, Object>>> getVesselQcProByTime(HttpServletRequest request, HttpServletResponse response) {
        ReturnMsg<List<Map<String, Object>>> rm = new ReturnMsg<>();

        List<Map<String, Object>> listVesselPros = new ArrayList<>();

        String vesselDate = request.getParameter("vesselDate");

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

    /**
     * 根据qc_id 获取特定岸桥下的任务作业信息
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/qcTaskEventConsume", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTaskEventConsumeByQcId(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<>();

        // 以下变量用以统计不同任务及任务间隔类型的累计耗时情况
        Double workQueueConsume = 0d;
        Double wiciConsume = 0d;
        Double ocrConsume = 0d;
        Double pfLockConsume = 0d;
        Double stsRebootConsume = 0d;
        Double mtManualConsume = 0d;
        Double otherFactorsConsume = 0d;

        Double changeBayConsume = 0d;
        Double parkTaskConsume = 0d;
        Double normalTaskConsume = 0d;

        Double taskTotalConsume = 0.0d;
        Double gapTotalConsume = 0.0d;

        String qcId = request.getParameter("qcId");
        String vesselDate = request.getParameter("vesselDate");

        if (!StringUtils.isEmpty(vesselDate)) {

            String[] vesselTime = StringUtils.split(vesselDate, " - ");
            if (!StringUtils.isEmpty(vesselTime[0])) {

                startTime = vesselTime[0];
            }
            if (!StringUtils.isEmpty(vesselTime[1])) {

                endTime = vesselTime[1];
            }
        }

        if (!StringUtils.isEmpty(qcId)) {

            List<T_STS_ConvertEventRecordPO> listEventResultPOs = qcEfficiencyAnalysisService.getTaskInfoByQcId(qcId, startTime, endTime);

            for (T_STS_ConvertEventRecordPO po : listEventResultPOs) {
                switch (po.getGap_type()) {
                    case Constant.WAIT_WORK_QUEUE :
                        workQueueConsume += po.getEvent_gap();
                        break;
                    case Constant.WAIT_WI_CI :
                        wiciConsume += po.getEvent_gap();
                        break;
                    case Constant.WAIT_OCR :
                        ocrConsume += po.getEvent_gap();
                        break;
                    case Constant.WAIT_PF_LOCK :
                        pfLockConsume += po.getEvent_gap();
                        break;
                    case Constant.WAIT_STSMS_REBOOT :
                        stsRebootConsume += po.getEvent_gap();
                        break;
                    case Constant.MT_MANUAL_MODE :
                        mtManualConsume += po.getEvent_gap();
                        break;
                    case Constant.OTHER_FACTORS :
                        otherFactorsConsume += po.getEvent_gap();
                        break;
                    case Constant.CHANGE_BAY_COST :
                        changeBayConsume += po.getEvent_gap();
                        break;
                    case Constant.PARK_TASK_COST :
                        parkTaskConsume += po.getEvent_gap();
                        break;
                    case Constant.NORMAL_TASK_COST :
                        normalTaskConsume += po.getEvent_gap();
                        break;
                }
            }

            gapTotalConsume = workQueueConsume + wiciConsume + ocrConsume + pfLockConsume + stsRebootConsume + mtManualConsume + otherFactorsConsume;
            taskTotalConsume = changeBayConsume + parkTaskConsume + normalTaskConsume;

            Map<String, Object> jsonTotal = new HashMap<>();
            Map<String, Object> jsonTask = new HashMap<>();
            Map<String, Object> jsonGap = new HashMap<>();

            jsonTotal.put("taskTotalConsume", taskTotalConsume);
            jsonTotal.put("gapTotalConsume", gapTotalConsume);

            jsonGap.put("waitWQConsume", workQueueConsume);
            jsonGap.put("waitWiCiConsume", wiciConsume);
            jsonGap.put("waitOcrCosume", ocrConsume);
            jsonGap.put("waitLockConsume", pfLockConsume);
            jsonGap.put("waitSTSMSrebootConsume", stsRebootConsume);
            jsonGap.put("waitMTConsume", mtManualConsume);
            jsonGap.put("otherConsume", otherFactorsConsume);

            jsonTask.put("changeBayConsume", changeBayConsume);
            jsonTask.put("parkConsume", parkTaskConsume);
            jsonTask.put("normalConsume", normalTaskConsume);


            map.put("totalInfo", jsonTotal);
            map.put("taskInfo", jsonTask);
            map.put("gapInfo", jsonGap);

        } else {
           return null;
        }

        return map;
    }

    /**
     * 根据qc_id 获取特定岸桥下的指令作业信息
     */
    @RequestMapping(value = "/qcInstrctionEvenConsume", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getInstrctionEventConsumeByQcId(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<>();

        return result;
    }
}
