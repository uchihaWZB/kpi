package com.example.demo.vo;

/**
 * 记录岸桥任务层面作业耗时VO
 *
 * Created by lenovopc001 on 2017/9/12.
 */
public class QcTaskInfoVO {

    private String gap_Id;           // 耗时事件Id

    private String gap_Type;         // 耗时事件类型

    private String event_Desc;       // 耗时事件描述

    private Double eventConsume;    // 耗时事件总耗时

    public QcTaskInfoVO() {
    }

    public QcTaskInfoVO(String gap_Id, String gap_Type, String event_Desc, Double eventConsume) {
        this.gap_Id = gap_Id;
        this.gap_Type = gap_Type;
        this.event_Desc = event_Desc;
        this.eventConsume = eventConsume;
    }

    public String getGap_Id() {
        return gap_Id;
    }

    public void setGap_Id(String gap_Id) {
        this.gap_Id = gap_Id;
    }

    public String getGap_Type() {
        return gap_Type;
    }

    public void setGap_Type(String gap_Type) {
        this.gap_Type = gap_Type;
    }

    public String getEvent_Desc() {
        return event_Desc;
    }

    public void setEvent_Desc(String event_Desc) {
        this.event_Desc = event_Desc;
    }

    public Double getEventConsume() {
        return eventConsume;
    }

    public void setEventConsume(Double eventConsume) {
        this.eventConsume = eventConsume;
    }
}
