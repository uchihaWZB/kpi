package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by WZB on 2017/7/17.
 */
@Entity
@Table(name = "bd_")
public class QcWorkQueueStatusPO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String workQueue;               //工作队列名称

    private String moveKind;                //移动指令类型

    private String aboveBellow;             //位于甲板位置：上 / 下

    private String vesselBay;               //船贝号

    private String qcBollard;               //岸桥_船系柱编号

    private Integer qcBollardOffsetCm;      //岸桥_船系柱偏移量

    private Double wqSeq;                   //WQ_SEQ

    private String configuration;           //队列配置与否

    private String wqStatus;                //岸桥作业工作状态

    private Date startTime;                 //岸桥作业开始时间

    private Date endTime;                   //岸桥作业结束时间

    private Date updated;                   //岸桥作业更新时间

    public QcWorkQueueStatusPO() {
    }

    public QcWorkQueueStatusPO(String workQueue, String moveKind, String aboveBellow, String vesselBay, String qcBollard, Integer qcBollardOffsetCm, Double wqSeq, String configuration, String wqStatus, Date startTime, Date endTime, Date updated) {
        this.workQueue = workQueue;
        this.moveKind = moveKind;
        this.aboveBellow = aboveBellow;
        this.vesselBay = vesselBay;
        this.qcBollard = qcBollard;
        this.qcBollardOffsetCm = qcBollardOffsetCm;
        this.wqSeq = wqSeq;
        this.configuration = configuration;
        this.wqStatus = wqStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.updated = updated;
    }

    public String getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(String workQueue) {
        this.workQueue = workQueue;
    }

    public String getMoveKind() {
        return moveKind;
    }

    public void setMoveKind(String moveKind) {
        this.moveKind = moveKind;
    }

    public String getAboveBellow() {
        return aboveBellow;
    }

    public void setAboveBellow(String aboveBellow) {
        this.aboveBellow = aboveBellow;
    }

    public String getVesselBay() {
        return vesselBay;
    }

    public void setVesselBay(String vesselBay) {
        this.vesselBay = vesselBay;
    }

    public String getQcBollard() {
        return qcBollard;
    }

    public void setQcBollard(String qcBollard) {
        this.qcBollard = qcBollard;
    }

    public Integer getQcBollardOffsetCm() {
        return qcBollardOffsetCm;
    }

    public void setQcBollardOffsetCm(Integer qcBollardOffsetCm) {
        this.qcBollardOffsetCm = qcBollardOffsetCm;
    }

    public Double getWqSeq() {
        return wqSeq;
    }

    public void setWqSeq(Double wqSeq) {
        this.wqSeq = wqSeq;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getWqStatus() {
        return wqStatus;
    }

    public void setWqStatus(String wqStatus) {
        this.wqStatus = wqStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
