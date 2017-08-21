package com.example.demo.Controller.jsonobject;

import com.example.demo.model.QC_CommandPO;
import com.example.demo.utils.DateUtil;
import org.springframework.beans.BeanUtils;

/**
 * Created by gaochangqing on 2017/7/28.
 */
public class JsonQC_CommandPO extends QC_CommandPO {

    private String createTimedDisp;

    public JsonQC_CommandPO() {
        super();
    }

    public JsonQC_CommandPO(QC_CommandPO qC_CommandPO) {
        super();
        BeanUtils.copyProperties(qC_CommandPO,this);

        this.createTimedDisp = DateUtil.getTimeDisp(qC_CommandPO.getCreated());
    }

    public String getCreateTimedDisp() {
        return createTimedDisp;
    }

    public void setCreateTimedDisp(String createTimedDisp) {
        this.createTimedDisp = createTimedDisp;
    }
}
