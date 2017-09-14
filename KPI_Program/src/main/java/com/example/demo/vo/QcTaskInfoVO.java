package com.example.demo.vo;

/**
 * 记录岸桥任务层面作业耗时VO
 *
 * Created by lenovopc001 on 2017/9/12.
 */
public class QcTaskInfoVO {

    private String gapId;           // 耗时事件Id

    private String gapType;         // 耗时事件类型

    private String eventDesc;       // 耗时事件描述

    private Double eventConsume;    // 耗时事件总耗时

    public QcTaskInfoVO() {
    }

    public QcTaskInfoVO(String gapId, String gapType, String eventDesc, Double eventConsume) {
        this.gapId = gapId;
        this.gapType = gapType;
        this.eventDesc = eventDesc;
        this.eventConsume = eventConsume;
    }

    public String getGapId() {
        return gapId;
    }

    public void setGapId(String gapId) {
        this.gapId = gapId;
    }

    public String getGapType() {
        return gapType;
    }

    public void setGapType(String gapType) {
        this.gapType = gapType;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Double getEventConsume() {
        return eventConsume;
    }

    public void setEventConsume(Double eventConsume) {
        this.eventConsume = eventConsume;
    }
}
