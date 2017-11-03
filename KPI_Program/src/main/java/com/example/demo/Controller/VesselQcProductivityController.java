package com.example.demo.Controller;

import com.example.demo.mapper.dao.T_STS_ConvertEventRecordDao;
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
        timeDeal(vesselDate);

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

        // 以下变量用以统计不同指令及指令间隔类型的累计耗时情况
        Double insConsume = 0d;
        Double insGapConsume = 0d;

        Double insWaitToPoisotion = 0d;
        Double insWaitPT = 0d;
        Double insWaitExceptionHandle = 0d;
        Double insSTSMSPerformance = 0d;

        String qcId = request.getParameter("qcId");
        String vesselDate = request.getParameter("vesselDate");

        timeDeal(vesselDate);

        if (!StringUtils.isEmpty(qcId)) {

            List<T_STS_ConvertEventRecordPO> listTaskResults = qcEfficiencyAnalysisService.getCraneInfoByQcId(qcId,
                                                                                                                "Level01",
                                                                                                                 startTime,
                                                                                                                 endTime);
            List<T_STS_ConvertEventRecordPO> listInsResults = qcEfficiencyAnalysisService.getCraneInfoByQcId(qcId,
                                                                                                            "Level03",
                                                                                                             startTime,
                                                                                                             endTime);

            for (T_STS_ConvertEventRecordPO po : listTaskResults) {
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

            for (T_STS_ConvertEventRecordPO po : listInsResults) {
                switch (po.getGap_type()) {
                    case Constant.WAIT_TO_POISOTION :
                        insWaitToPoisotion += po.getEvent_gap();
                        break;
                    case Constant.WAIT_PT :
                        insWaitPT += po.getEvent_gap();
                        break;
                    case Constant.WAIT_EXCEPTION_HANDLE :
                        insWaitExceptionHandle += po.getEvent_gap();
                        break;
                    case Constant.STSMS_PERFORMANCE :
                        insSTSMSPerformance += po.getEvent_gap();
                        break;
                    case Constant.INSTRUCTION_COST :
                        insConsume += po.getEvent_gap();
                        break;
                }
            }

            gapTotalConsume = workQueueConsume + wiciConsume + ocrConsume + pfLockConsume + stsRebootConsume + mtManualConsume + otherFactorsConsume;
            taskTotalConsume = changeBayConsume + parkTaskConsume + normalTaskConsume;

            insGapConsume = insWaitToPoisotion + insWaitPT + insWaitExceptionHandle + insSTSMSPerformance;

            Map<String, Object> taskInfo = new HashMap<>();
            Map<String, Object> taskHaveInfo = new HashMap<>();
            Map<String, Object> taskGapInfo = new HashMap<>();

            Map<String, Object> insInfo = new HashMap<>();
            Map<String, Object> insHaveInfo = new HashMap<>();
            Map<String, Object> insGapInfo = new HashMap<>();

            taskInfo.put("taskTotalConsume", taskTotalConsume);
            taskInfo.put("gapTotalConsume", gapTotalConsume);

            insInfo.put("insConsume", insConsume);
            insInfo.put("insGapConsume", insGapConsume);

            taskGapInfo.put("waitWQConsume", workQueueConsume);
            taskGapInfo.put("waitWiCiConsume", wiciConsume);
            taskGapInfo.put("waitOcrCosume", ocrConsume);
            taskGapInfo.put("waitLockConsume", pfLockConsume);
            taskGapInfo.put("waitSTSMSrebootConsume", stsRebootConsume);
            taskGapInfo.put("waitMTConsume", mtManualConsume);
            taskGapInfo.put("otherConsume", otherFactorsConsume);

            insGapInfo.put("insWaitToPoisotion", insWaitToPoisotion);
            insGapInfo.put("insWaitPT", insWaitPT);
            insGapInfo.put("insWaitExceptionHandle", insWaitExceptionHandle);
            insGapInfo.put("insSTSMSPerformance", insSTSMSPerformance);


            taskHaveInfo.put("changeBayConsume", changeBayConsume);
            taskHaveInfo.put("parkConsume", parkTaskConsume);
            taskHaveInfo.put("normalConsume", normalTaskConsume);


            map.put("taskInfo", taskInfo);
            map.put("taskHaveInfo", taskHaveInfo);
            map.put("taskGapInfo", taskGapInfo);
            map.put("insInfo", insInfo);
            map.put("insGapInfo", insGapInfo);

        } else {
           return null;
        }

        return map;
    }

    /**
     * 处理前台传来的时间字符串
     *
     * @param timeToDeal
     */
    public void timeDeal(String timeToDeal) {
        if (!StringUtils.isEmpty(timeToDeal)) {

            String[] timePhase = StringUtils.split(timeToDeal, " - ");
            if (!StringUtils.isEmpty(timePhase[0])) {

                startTime = timePhase[0];
            }
            if (!StringUtils.isEmpty(timePhase[1])) {

                endTime = timePhase[1];
            }
        }
    }
}
