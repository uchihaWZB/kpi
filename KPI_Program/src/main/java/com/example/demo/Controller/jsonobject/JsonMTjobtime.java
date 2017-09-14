package com.example.demo.Controller.jsonobject;

import com.example.demo.utils.DateUtil;
import com.example.demo.vo.MT_PTjobtime;
import com.example.demo.vo.MTjobtime;
import org.springframework.beans.BeanUtils;


/**
 * Created by gaochangqing on 2017/9/1.
 */
public class JsonMTjobtime extends MTjobtime {

    private String createTimedDisp;

    public JsonMTjobtime(MTjobtime MTjobtime) {
        super();
        BeanUtils.copyProperties(MTjobtime,this);

        this.createTimedDisp = DateUtil.getTimeDisp(MTjobtime.getCreateTime());
    }

    public String getCreateTimedDisp() {
        return createTimedDisp;
    }

    public void setCreateTimedDisp(String createTimedDisp) {
        this.createTimedDisp = createTimedDisp;
    }
}
