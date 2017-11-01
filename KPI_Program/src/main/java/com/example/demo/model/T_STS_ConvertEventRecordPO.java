package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovopc001 on 2017/10/27.
 */
public class T_STS_ConvertEventRecordPO implements Serializable {

    private Integer id;

    private String sts_id;

    private Double event_gap;

    private String event_desc;

    private String gap_type;

    private String gap_id;

    private Integer last_update_id;

    private String current_event_id;

    private Date current_event_created;

    private String next_event_id;

    private Date next_event_created;

    private String event_level;

    public T_STS_ConvertEventRecordPO() {
    }

    public T_STS_ConvertEventRecordPO(Integer id, String sts_id, Double event_gap, String event_desc, String gap_type, String gap_id, Integer last_update_id, String current_event_id, Date current_event_created, String next_event_id, Date next_event_created, String event_level) {
        this.id = id;
        this.sts_id = sts_id;
        this.event_gap = event_gap;
        this.event_desc = event_desc;
        this.gap_type = gap_type;
        this.gap_id = gap_id;
        this.last_update_id = last_update_id;
        this.current_event_id = current_event_id;
        this.current_event_created = current_event_created;
        this.next_event_id = next_event_id;
        this.next_event_created = next_event_created;
        this.event_level = event_level;
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

    public Double getEvent_gap() {
        return event_gap;
    }

    public void setEvent_gap(Double event_gap) {
        this.event_gap = event_gap;
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc;
    }

    public String getGap_type() {
        return gap_type;
    }

    public void setGap_type(String gap_type) {
        this.gap_type = gap_type;
    }

    public String getGap_id() {
        return gap_id;
    }

    public void setGap_id(String gap_id) {
        this.gap_id = gap_id;
    }

    public Integer getLast_update_id() {
        return last_update_id;
    }

    public void setLast_update_id(Integer last_update_id) {
        this.last_update_id = last_update_id;
    }

    public String getCurrent_event_id() {
        return current_event_id;
    }

    public void setCurrent_event_id(String current_event_id) {
        this.current_event_id = current_event_id;
    }

    public Date getCurrent_event_created() {
        return current_event_created;
    }

    public void setCurrent_event_created(Date current_event_created) {
        this.current_event_created = current_event_created;
    }

    public String getNext_event_id() {
        return next_event_id;
    }

    public void setNext_event_id(String next_event_id) {
        this.next_event_id = next_event_id;
    }

    public Date getNext_event_created() {
        return next_event_created;
    }

    public void setNext_event_created(Date next_event_created) {
        this.next_event_created = next_event_created;
    }

    public String getEvent_level() {
        return event_level;
    }

    public void setEvent_level(String event_level) {
        this.event_level = event_level;
    }
}
