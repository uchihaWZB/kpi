package com.example.demo.service.impl;

import com.example.demo.utils.page.PageList;
import com.example.demo.utils.page.PageRequest;
import com.example.demo.utils.page.Paginator;
import com.example.demo.vo.QuayCraneEfficiency;
import com.example.demo.service.QuayCraneEfficiencyService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("quayCraneEfficiencyService")
public class QuayCraneEfficiencyServiceImpl implements QuayCraneEfficiencyService {
    // XXX 只是为了测试，生产环境严禁使用这种方式
    private List<QuayCraneEfficiency> list = new ArrayList<>();

    @PostConstruct
    private void initTestData() {
        this.list = Arrays.asList(
                new QuayCraneEfficiency().setTravelingCraneNo("W101").setWaitOfCommandAvg("0.03")
                        .setCarWorkOfAvg("0.08").setWaitOfAvg("1.07").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W102").setWaitOfCommandAvg("0.79")
                        .setCarWorkOfAvg("0.04").setWaitOfAvg("0.94").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W103").setWaitOfCommandAvg("0.59")
                        .setCarWorkOfAvg("0.05").setWaitOfAvg("0.8").setWorkOfAvg("2.03"),
                new QuayCraneEfficiency().setTravelingCraneNo("W104").setWaitOfCommandAvg("0.33")
                        .setCarWorkOfAvg("0.05").setWaitOfAvg("0.93").setWorkOfAvg("2.02"),
                new QuayCraneEfficiency().setTravelingCraneNo("W105").setWaitOfCommandAvg("0.41")
                        .setCarWorkOfAvg("0.05").setWaitOfAvg("0.9").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W106").setWaitOfCommandAvg("0.37")
                        .setCarWorkOfAvg("0.04").setWaitOfAvg("0.98").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W107").setWaitOfCommandAvg("0.43")
                        .setCarWorkOfAvg("0.04").setWaitOfAvg("0.63").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W108").setWaitOfCommandAvg("0.49")
                        .setCarWorkOfAvg("0.04").setWaitOfAvg("0.85").setWorkOfAvg("2"),
                new QuayCraneEfficiency().setTravelingCraneNo("W109").setWaitOfCommandAvg("0.38")
                        .setCarWorkOfAvg("0.03").setWaitOfAvg("0.64").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W110").setWaitOfCommandAvg("0.45")
                        .setCarWorkOfAvg("0.04").setWaitOfAvg("0.65").setWorkOfAvg("2"),
                new QuayCraneEfficiency().setTravelingCraneNo("W111").setWaitOfCommandAvg("0.4 ")
                        .setCarWorkOfAvg("0.04").setWaitOfAvg("0.85").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W112").setWaitOfCommandAvg("0.25")
                        .setCarWorkOfAvg("0.05").setWaitOfAvg("0.86").setWorkOfAvg("2.02"),
                new QuayCraneEfficiency().setTravelingCraneNo("W113").setWaitOfCommandAvg("0.52")
                        .setCarWorkOfAvg("0.04").setWaitOfAvg("1.15").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W114").setWaitOfCommandAvg("0.23")
                        .setCarWorkOfAvg("0.03").setWaitOfAvg("0.83").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W115").setWaitOfCommandAvg("0.18")
                        .setCarWorkOfAvg("0.03").setWaitOfAvg("0.71").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W116").setWaitOfCommandAvg("0.35")
                        .setCarWorkOfAvg("0.03").setWaitOfAvg("0.71").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W117").setWaitOfCommandAvg("0.28")
                        .setCarWorkOfAvg("0.03").setWaitOfAvg("0.68").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W118").setWaitOfCommandAvg("0.32")
                        .setCarWorkOfAvg("0.03").setWaitOfAvg("0.79").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("W119").setWaitOfCommandAvg("0.16")
                        .setCarWorkOfAvg("0.05").setWaitOfAvg("0.89").setWorkOfAvg("2.02"),
                new QuayCraneEfficiency().setTravelingCraneNo("W120").setWaitOfCommandAvg("0.2").setCarWorkOfAvg("0.06")
                        .setWaitOfAvg("1").setWorkOfAvg("2.02"),
                new QuayCraneEfficiency().setTravelingCraneNo("W121").setWaitOfCommandAvg("0.51")
                        .setCarWorkOfAvg("0.07").setWaitOfAvg("1.23").setWorkOfAvg("2.02"),
                new QuayCraneEfficiency().setTravelingCraneNo("W122").setWaitOfCommandAvg("0.37")
                        .setCarWorkOfAvg("0.03").setWaitOfAvg("0.66").setWorkOfAvg("2.01"),
                new QuayCraneEfficiency().setTravelingCraneNo("总计").setWaitOfCommandAvg("0.35").setCarWorkOfAvg("0.04")
                        .setWaitOfAvg("0.82").setWorkOfAvg("2.01"));
    }

    @Override
    public PageList<QuayCraneEfficiency> table(PageRequest pageRequest) {
        // XX 此处应该调用DAO层获取数据库的数据，此处只模拟数据
        // 计算出总量
        int items = list.size();
        // 分析是第几页，从第几到第几
        int page = pageRequest.getPage();
        if (page >= items) {
            return new PageList<QuayCraneEfficiency>();
        }
        if (page <= 0) {
            return new PageList<QuayCraneEfficiency>();
        }
        int itemPerSize = pageRequest.getItemsPerPage();
        int start = (page * itemPerSize) - itemPerSize;
        int end = (page * itemPerSize);
        if (end >= items - 1) {
            end = items - 1;
        }

        List<QuayCraneEfficiency> result = list.subList(start, end);

        PageList<QuayCraneEfficiency> pageList = new PageList<QuayCraneEfficiency>();

        pageList.setList(result);
        Paginator paginator = new Paginator();
        paginator.setItems(items);
        paginator.setPage(page);
        paginator.setItemsPerPage(itemPerSize);
        pageList.setPaginator(paginator);
        return pageList;
    }
}
