package com.example.demo.vo;

import java.io.Serializable;

/**
 * 查询到的到访船次对应下的岸桥效率
 *
 * Created by lenovopc001 on 2017/8/31.
 */
public class QcProductivityOfVesselVO implements Serializable {

    private String qcId;

    private Double productivity;

    public QcProductivityOfVesselVO() {
    }

    public QcProductivityOfVesselVO(String qcId, Double productivity) {
        this.qcId = qcId;
        this.productivity = productivity;
    }

    public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId;
    }

    public Double getProductivity() {
        return productivity;
    }

    public void setProductivity(Double productivity) {
        this.productivity = productivity;
    }
}
