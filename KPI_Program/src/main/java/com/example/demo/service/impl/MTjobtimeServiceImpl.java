package com.example.demo.service.impl;

import com.example.demo.mapper.dao.MT_PTjobtimeDao;
import com.example.demo.mapper.dao.MTjobtimeDao;
import com.example.demo.service.MTjobtimeService;
import com.example.demo.vo.MT_PTjobtime;
import com.example.demo.vo.MTjobtime;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
@Service("MTjobtimeService")
public class MTjobtimeServiceImpl implements MTjobtimeService {

    @Autowired
    private MTjobtimeDao mTjobtimeDao;

    public List<MTjobtime> getMTjobtimedata(@Param("startDateTime") String startDateTime, @Param("endDateTime") String endDateTime,
                                            @Param("craneNum") String craneNum){

        return mTjobtimeDao.getMTjobtimedata(startDateTime,endDateTime,craneNum);
    }

}
