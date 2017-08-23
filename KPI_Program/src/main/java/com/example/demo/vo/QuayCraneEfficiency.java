package com.example.demo.vo;

import java.io.Serializable;

/**
 * 岸桥效率 Created by wangpeihu on 2017/3/20.
 */
public class QuayCraneEfficiency implements Serializable {
    // 桥吊号
    private String travelingCraneNo;
    // 平均等指令时间（分钟）
    private String waitOfCommandAvg;
    // 平均行大车时间（分钟）
    private String carWorkOfAvg;
    // 平均等待时间（分钟）
    private String waitOfAvg;
    // 平均作业时间（分钟）
    private String workOfAvg;

    public String getTravelingCraneNo() {
        return travelingCraneNo;
    }

    public QuayCraneEfficiency setTravelingCraneNo(String travelingCraneNo) {
        this.travelingCraneNo = travelingCraneNo;
        return this;
    }

    public String getWaitOfCommandAvg() {
        return waitOfCommandAvg;
    }

    public QuayCraneEfficiency setWaitOfCommandAvg(String waitOfCommandAvg) {
        this.waitOfCommandAvg = waitOfCommandAvg;
        return this;
    }

    public String getCarWorkOfAvg() {
        return carWorkOfAvg;
    }

    public QuayCraneEfficiency setCarWorkOfAvg(String carWorkOfAvg) {
        this.carWorkOfAvg = carWorkOfAvg;
        return this;
    }

    public String getWaitOfAvg() {
        return waitOfAvg;
    }

    public QuayCraneEfficiency setWaitOfAvg(String waitOfAvg) {
        this.waitOfAvg = waitOfAvg;
        return this;
    }

    public String getWorkOfAvg() {
        return workOfAvg;
    }

    public QuayCraneEfficiency setWorkOfAvg(String workOfAvg) {
        this.workOfAvg = workOfAvg;
        return this;
    }
}
