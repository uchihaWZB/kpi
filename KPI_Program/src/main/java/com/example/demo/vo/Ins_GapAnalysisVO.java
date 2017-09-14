package com.example.demo.vo;

import java.sql.Timestamp;

/**
 * Created by gaochangqing on 2017/9/12.
 * 指令间隔耗时
 */
public class Ins_GapAnalysisVO {

    //耗时类别
    private String consumType;

    //耗时名称
    private String consumName;

    //耗时
    private String qcid;

    private double gapTime;

    public String getConsumType() {
        return consumType;
    }

    public void setConsumType(String consumType) {
        this.consumType = consumType;
    }

    public String getConsumName() {
        return consumName;
    }

    public void setConsumName(String consumName) {
        this.consumName = consumName;
    }

    public String getQcid() {
        return qcid;
    }

    public void setQcid(String qcid) {
        this.qcid = qcid;
    }

    public double getGapTime() {
        return gapTime;
    }

    public void setGapTime(double gapTime) {
        this.gapTime = gapTime;
    }
}
