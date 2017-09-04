package com.example.demo.service.impl;

import com.example.demo.mapper.dao.MT_PTjobtimeDao;
import com.example.demo.service.MT_PTjobtimeService;
import com.example.demo.vo.MT_PTjobtime;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaochangqing on 2017/9/1.
 */
@Service("MT_PTjobtimeService")
public class MT_PTjobtimeServiceImpl implements MT_PTjobtimeService{

    @Autowired
    private MT_PTjobtimeDao mT_PTjobtimeDao;

    public List<MT_PTjobtime> getMT_PTjobtimedata(@Param("startDateTime") String startDateTime,@Param("endDateTime") String endDateTime,
                                                  @Param("craneNum") String craneNum){

        return mT_PTjobtimeDao.getMT_PTjobtimedata(startDateTime,endDateTime,craneNum);
    }

}
