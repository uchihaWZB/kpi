package com.example.demo.model;

import java.io.Serializable;

/**
 * Created by lenovopc001 on 2017/8/9.
 */
public class EventDefinePO implements Serializable {

    private Integer id;         // 事件定义Id

    private String eventName;   // 事件名

    private String description; // 事件描述

    public EventDefinePO() {
    }

    public EventDefinePO(Integer id, String eventName, String description) {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
