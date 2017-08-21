package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovopc001 on 2017/8/9.
 */
public class EventRecordPO implements Serializable {

    private Integer id;             // 事件记录Id

    private Integer eventId;        // 事件定义Id

    private String stsId;           // 岸桥Id

    private String equipType;       // 设备类型

    private String workQueue;       // WORK_QUEUE

    private Integer taskId;         // 任务Id

    private Integer instructionId;  // 指令Id

    private Date created;           // 事件记录创建时间

    private String content;         // 事件记录内容

    public EventRecordPO() {
    }

    public EventRecordPO(Integer id, Integer eventId, String stsId, String equipType, String workQueue, Integer taskId, Integer instructionId, Date created, String content) {
        this.id = id;
        this.eventId = eventId;
        this.stsId = stsId;
        this.equipType = equipType;
        this.workQueue = workQueue;
        this.taskId = taskId;
        this.instructionId = instructionId;
        this.created = created;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getStsId() {
        return stsId;
    }

    public void setStsId(String stsId) {
        this.stsId = stsId;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(String workQueue) {
        this.workQueue = workQueue;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(Integer instructionId) {
        this.instructionId = instructionId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
