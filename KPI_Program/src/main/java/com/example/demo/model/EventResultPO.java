package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件结果记录PO
 *
 * Created by lenovopc001 on 2017/9/11.
 */
public class EventResultPO implements Serializable {

    private String qcId;

    private Double eventGapTime;

    private String eventDesc;

    private Date currentEventCreated;

    private Long currentEventId;

    private Date nextEventCreated;

    private Long nextEventId;

    private String gapId;

    private String gapType;

    public EventResultPO() {
    }

    public EventResultPO(String qcId, Double eventGapTime, String eventDesc, Date currentEventCreated, Long currentEventId, Date nextEventCreated, Long nextEventId, String gapId, String gapType) {
        this.qcId = qcId;
        this.eventGapTime = eventGapTime;
        this.eventDesc = eventDesc;
        this.currentEventCreated = currentEventCreated;
        this.currentEventId = currentEventId;
        this.nextEventCreated = nextEventCreated;
        this.nextEventId = nextEventId;
        this.gapId = gapId;
        this.gapType = gapType;
    }

    public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId;
    }

    public Double getEventGapTime() {
        return eventGapTime;
    }

    public void setEventGapTime(Double eventGapTime) {
        this.eventGapTime = eventGapTime;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Date getCurrentEventCreated() {
        return currentEventCreated;
    }

    public void setCurrentEventCreated(Date currentEventCreated) {
        this.currentEventCreated = currentEventCreated;
    }

    public Long getCurrentEventId() {
        return currentEventId;
    }

    public void setCurrentEventId(Long currentEventId) {
        this.currentEventId = currentEventId;
    }

    public Date getNextEventCreated() {
        return nextEventCreated;
    }

    public void setNextEventCreated(Date nextEventCreated) {
        this.nextEventCreated = nextEventCreated;
    }

    public Long getNextEventId() {
        return nextEventId;
    }

    public void setNextEventId(Long nextEventId) {
        this.nextEventId = nextEventId;
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
}
