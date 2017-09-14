package com.example.demo.vo;

import java.sql.Timestamp;

/**
 * Created by gaochangqing on 2017/9/1.
 */
public class MTjobtime {

    private String type;

    private String qcid;

    private Timestamp createTime;

    private double jobtime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQcid() {
        return qcid;
    }

    public void setQcid(String qcid) {
        this.qcid = qcid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public double getJobtime() {
        return jobtime;
    }

    public void setJobtime(double jobtime) {
        this.jobtime = jobtime;
    }
}
