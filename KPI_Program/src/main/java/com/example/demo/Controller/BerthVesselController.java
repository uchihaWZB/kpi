package com.example.demo.Controller;

import com.example.demo.model.BerthStatusPO;
import com.example.demo.service.BerthVesselAnalysisService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.page.PageList;
import com.example.demo.utils.page.PageRequest;
import com.example.demo.utils.page.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovopc001 on 2017/7/5.
 */

@Controller
@RequestMapping("/")
public class BerthVesselController {

    @Autowired
    private BerthVesselAnalysisService berthVesselAnalysisService;

    @RequestMapping("/vessel_efficiency_table")
    public String getAllBerthStatus(HttpServletRequest request, ModelMap modelMap) {

        PageList<BerthStatusPO> result = new PageList<BerthStatusPO>();
        List<BerthStatusPO> list = berthVesselAnalysisService.getAllBerthStatus();

        //数据库中获得记录数量
        int items = list.size();

        Paginator paginator = new Paginator();
        paginator.setItem(items);
        paginator.setPage(1);
        paginator.setItemsPerPage(10);

        result.setList(list);
        result.setPaginator(paginator);


        modelMap.put("list", result.getList());
        modelMap.put("paginator", result.getPaginator());
        return "berth_vessel/vessel_efficiency_table";
    }

    @RequestMapping(value = "/vessel_efficiency_analysis")
    public String vessel_efficiency_analysis() {
        return "berth_vessel/vessel_efficiency_analysis";
    }
}
