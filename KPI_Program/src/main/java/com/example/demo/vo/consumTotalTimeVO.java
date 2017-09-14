package com.example.demo.vo;

/**
 * Created by gaochangqing on 2017/9/12.
 * 指令作业和间隔时间分析
 */
public class consumTotalTimeVO {

    //耗时类别
    private String consumType;

    //耗时名称
    private String consumName;

    //qcid
    private String qcid;

    //耗时
    private double consumTime;

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

    public double getConsumTime() {
        return consumTime;
    }

    public void setConsumTime(double consumTime) {
        this.consumTime = consumTime;
    }
}
