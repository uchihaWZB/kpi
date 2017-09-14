package com.example.demo.vo;

/**
 * Created by gaochangqing on 2017/9/12.
 * 指令作业耗时
 */
public class Ins_TimeAnalysisVO {

    //耗时类别
    private String consumType;

    //耗时名称
    private String consumName;

    //qcid
    private String qcid;

    //耗时
    private double jobTime;

    public String getQcid() {
        return qcid;
    }

    public void setQcid(String qcid) {
        this.qcid = qcid;
    }

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

    public double getJobTime() {
        return jobTime;
    }

    public void setJobTime(double jobTime) {
        this.jobTime = jobTime;
    }
}
