package com.example.demo.Controller;

import com.example.demo.Controller.common.JsonResult;
import com.example.demo.Controller.jsonobject.JsonQC_CommandPO;
import com.example.demo.model.QC_CommandPO;
import com.example.demo.service.QcEfficiencyAnalysisService;

import java.util.*;

import com.example.demo.utils.SystemUtils;
import com.example.demo.utils.returnMessage.ReturnMsg;
import com.example.demo.vo.QcJobEfficiencyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WZB on 2017/7/19.
 */
@Controller
@RequestMapping("/")
public class QcEfficiencyAnalysisController extends BaseAction{

    @Autowired
    private QcEfficiencyAnalysisService qcEfficiencyAnalysisService;

    @RequestMapping(value = "qc_efficiency_analysis",method = RequestMethod.GET)
    public String getQcEfficiencyAnalysis(Model model) {
        //ReturnMsg<Map<String, Object>> returnMsg = new ReturnMsg();

        //Map<String, Object> resultInfo = new HashMap<String, Object>();

        //获得所有岸桥的工作效率记录
        List<QcJobEfficiencyVO> qcJobEfficiencyVOS = qcEfficiencyAnalysisService.getAllQcWorkEfficiencyCount();

        List<String> listQcIds = new ArrayList<String>();
        List<String> listCreateds = new ArrayList<String>();

        // 循环将QC_Id和Created取出，并进行去重
        for (QcJobEfficiencyVO temp : qcJobEfficiencyVOS) {
            listQcIds.add(temp.getQcId());
            listCreateds.add(temp.getCreated());
        }
        SystemUtils.removeDuplicate(listQcIds);             // 去重QC_id记录，并递增排序
        SystemUtils.removeDuplicate(listCreateds);          // 去重创建时间记录，并递增排序

        int qcIdSize = listQcIds.size();
        int createdSize = listCreateds.size();

        // 用二维数组来表示每个岸桥的各时间段工作量
        // 一维：每个岸桥编号；二维：单个岸桥对应到每个时间段的工作量
        Integer QcSeriesLabels[][] = new Integer[qcIdSize][createdSize];

        // 每个时间段内所有岸桥的总工作效率
        Integer QcCountSeries[] = new Integer[createdSize];

        // 初始化数组
        SystemUtils.initTwoArray(QcSeriesLabels);
        SystemUtils.initOneArray(QcCountSeries);

        // 外层循环：遍历作为横坐标的时间值
        for (int x_index = 0, x_len = createdSize; x_index < x_len; x_index++) {

            // 中层循环：遍历每条qcJobEfficiencyVOS记录
            for (int qcJob_index = 0, qcJob_len = qcJobEfficiencyVOS.size(); qcJob_index < qcJob_len; qcJob_index++) {

                // 将当前qcJobEfficiencyVOS记录中的 时间 与 当前索引时间 进行比较，不符直接进入下一中层循环
                if (qcJobEfficiencyVOS.get(qcJob_index).getCreated().equals(listCreateds.get(x_index))) {

                    // 内层循环：遍历qcId索引
                    for (int qcId_index = 0, qcId_len = listQcIds.size(); qcId_index < qcId_len; qcId_index++) {

                        // 比较当前qcJobEfficiencyVOS记录中的 qcId 是否等于 当前qcId索引 的值
                        if (qcJobEfficiencyVOS.get(qcJob_index).getQcId().equals(listQcIds.get(qcId_index))) {

                            QcSeriesLabels[qcId_index][x_index] = qcJobEfficiencyVOS.get(qcJob_index).getQcWorkCount();

                            // 统计每个时间段内所有岸桥工作效率之和
                            QcCountSeries[x_index] += qcJobEfficiencyVOS.get(qcJob_index).getQcWorkCount();
                        } else {

                            continue;
                        }
                    }
                } else {

                    continue;
                }
            }
        }

        model.addAttribute("qcIds", listQcIds);
        model.addAttribute("qcCreateds", listCreateds);
        model.addAttribute("qcSeriesLabels", QcSeriesLabels);
        model.addAttribute("qcCountSeries", QcCountSeries);
        model.addAttribute("qcJobs", qcJobEfficiencyVOS);

        return "qc_efficiency_analysis";
    }

    @RequestMapping(value = "qc_efficiency_analysisChart",method = RequestMethod.GET)
    public @ResponseBody JsonResult qc_efficiency_analysisChart(HttpServletRequest request, HttpServletResponse response) {




        result.getData().clear();
        String name = request.getParameter("name");
        List<JsonQC_CommandPO> jsonQC_CommandPOList = new LinkedList<JsonQC_CommandPO>();

        List<String> resultQcIds = new ArrayList<String>();

        List<QC_CommandPO> qC_CommandPOList = qcEfficiencyAnalysisService.getAllQcCommandPO();

        //获得所有岸桥的工作效率记录
        /*List<QcJobEfficiencyVO> qcJobEfficiencyVOS = qcEfficiencyAnalysisService.getAllQcWorkEfficiencyCount();

        List<String> listQcIds = new ArrayList<String>();

        for (QcJobEfficiencyVO temp : qcJobEfficiencyVOS) {
            listQcIds.add(temp.getQcId());
        }

        SystemUtils.removeDuplicate(listQcIds);

        resultInfo.put("qcIds",listQcIds);*/



        System.out.println("***************************************");
        if(!CollectionUtils.isEmpty(qC_CommandPOList)){

            for(QC_CommandPO qC_CommandPO : qC_CommandPOList){

                JsonQC_CommandPO JsonQC_CommandPO = new JsonQC_CommandPO(qC_CommandPO);
                jsonQC_CommandPOList.add(JsonQC_CommandPO);
            }
        }

        //System.out.println("size:"+jsonQC_CommandPOList.size());
        System.out.println("name:  " + name);
        result.setResult("ok");
        result.getData().put("rows",jsonQC_CommandPOList);

        return result;
    }
}
