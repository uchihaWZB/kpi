package com.example.demo.service.impl;

import com.example.demo.mapper.dao.BerthVesselDao;
import com.example.demo.model.BerthStatusPO;
import com.example.demo.service.BerthVesselAnalysisService;
import com.example.demo.utils.page.PageList;
import com.example.demo.utils.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WZB on 2017/7/5.
 *
 * 船舶泊位分析服务
 */

@Service("BerthVesselAnalysisService")
public class BerthVesselAnalysisServiceImpl implements BerthVesselAnalysisService{

    @Autowired
    private BerthVesselDao berthVesselDao;

    @Override
    public List<BerthStatusPO> getAllBerthStatus() {
        return berthVesselDao.getAllBerthStatusPO();
    }
}
