package com.example.demo.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovopc001 on 2017/7/19.
 */
public class QcJobEfficiencyVO implements Serializable {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:00:00");

    //private Integer qcCommandId;

    private String qcId;            // 岸桥编号

    //private String status;          // 作业指令状态

    private String created;           // 岸桥命令创建时间

    Integer qcWorkCount;            // 岸桥工作效率（一段时间内总量）

    public QcJobEfficiencyVO() {
        super();
    }

    public QcJobEfficiencyVO(String qcId, String created, Integer qcWorkCount) {
        this.qcId = qcId;
        this.created = created + "时";
        this.qcWorkCount = qcWorkCount;
    }

    /*public Integer getQcCommandId() {
        return qcCommandId;
    }*/

    /*public void setQcCommandId(Integer qcCommandId) {
        this.qcCommandId = qcCommandId;
    }*/

    public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId;
    }

    /*public String getStatus() {
        return status;
    }*/

    /*public void setStatus(String status) {
        this.status = status;
    }*/

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created + "时";
    }

    public Integer getQcWorkCount() {
        return qcWorkCount;
    }

    public void setQcWorkCount(Integer qcWorkCount) {
        this.qcWorkCount = qcWorkCount;
    }
}
