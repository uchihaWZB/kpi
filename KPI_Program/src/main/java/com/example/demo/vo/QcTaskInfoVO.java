package com.example.demo.vo;

import java.util.Date;

/**
 * 记录岸桥任务层面作业耗时VO
 *
 * Created by lenovopc001 on 2017/9/12.
 */
public class QcTaskInfoVO {

    private Integer id;

    private String sts_id;

    private double event_gap;

    private String gap_Type;

    private Date current_event_created;

    public QcTaskInfoVO() {
    }

    public QcTaskInfoVO(Integer id, String sts_id, double event_gap, String gap_Type, Date current_event_created) {
        this.id = id;
        this.sts_id = sts_id;
        this.event_gap = event_gap;
        this.gap_Type = gap_Type;
        this.current_event_created = current_event_created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSts_id() {
        return sts_id;
    }

    public void setSts_id(String sts_id) {
        this.sts_id = sts_id;
    }

    public double getEvent_gap() {
        return event_gap;
    }

    public void setEvent_gap(double event_gap) {
        this.event_gap = event_gap;
    }

    public String getGap_Type() {
        return gap_Type;
    }

    public void setGap_Type(String gap_Type) {
        this.gap_Type = gap_Type;
    }

    public Date getCurrent_event_created() {
        return current_event_created;
    }

    public void setCurrent_event_created(Date current_event_created) {
        this.current_event_created = current_event_created;
    }
}
