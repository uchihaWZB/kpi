package com.example.demo.Controller;

import com.example.demo.utils.page.PageList;
import com.example.demo.utils.page.PageRequest;
import com.example.demo.vo.QuayCraneEfficiency;
import com.example.demo.service.QuayCraneEfficiencyService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wangpeihu on 2017/3/17.
 */
@Controller
@RequestMapping("/")
public class QuayCraneEfficiencyController {

    @Autowired
    private QuayCraneEfficiencyService quayCraneEfficiencyService;

    @RequestMapping(value = "qc_efficiency_table", method = RequestMethod.GET)
    public String table(HttpServletRequest request, PageRequest pageRequest, ModelMap modelMap) {

        PageList<QuayCraneEfficiency> result = quayCraneEfficiencyService.table(pageRequest);
        modelMap.put("list", result.getList());
        modelMap.put("paginator", result.getPaginator());
        return "qc_efficiency_table";
    }
}
