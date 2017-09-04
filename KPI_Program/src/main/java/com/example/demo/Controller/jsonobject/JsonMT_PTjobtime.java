package com.example.demo.Controller.jsonobject;

import com.example.demo.utils.DateUtil;
import com.example.demo.vo.MT_PTjobtime;
import org.springframework.beans.BeanUtils;


/**
 * Created by gaochangqing on 2017/9/1.
 */
public class JsonMT_PTjobtime extends MT_PTjobtime {

    private String createTimedDisp;

    public JsonMT_PTjobtime(MT_PTjobtime MT_PTjobtime) {
        super();
        BeanUtils.copyProperties(MT_PTjobtime,this);

        this.createTimedDisp = DateUtil.getTimeDisp(MT_PTjobtime.getCreateTime());
    }

    public String getCreateTimedDisp() {
        return createTimedDisp;
    }

    public void setCreateTimedDisp(String createTimedDisp) {
        this.createTimedDisp = createTimedDisp;
    }
}
