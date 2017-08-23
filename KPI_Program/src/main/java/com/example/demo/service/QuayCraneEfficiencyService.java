package com.example.demo.service;

import com.example.demo.utils.page.PageList;
import com.example.demo.utils.page.PageRequest;
import com.example.demo.vo.QuayCraneEfficiency;

/**
 * Created by wangpeihu on 2017/3/20.
 */
public interface QuayCraneEfficiencyService {

    PageList<QuayCraneEfficiency> table(PageRequest pageRequest);

}
