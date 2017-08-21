package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovopc001 on 2017/7/18.
 */
@Entity
@Table(name = "QC_COMMANDS")
public class QC_CommandPO implements Serializable {

    private Integer commandGkey;            // 命令序列

    private Integer fkOrderGkey;            // 指令序列参考

    private Integer orderVersion;           // 指令版本

    private Integer commandVersion;         // 命令版本

    private String qcId;                    // 岸桥编号

    private String referenceId;             // 参考ID

    private String presumedContainerId;     //

    private String fkWorkQueue;             // 工作队列名称参考

    private String status;                  // 作业指令状态

    private String containerLastLocation;   // 集装箱最后的位置

    private String containerCurrLocation;   // 集装箱当前的位置

    private String containerOrigLocation;   // 集装箱初始的位置

    private Integer containerLength;        // 集装箱的长度

    private Integer transactionId;          // 交易ID

    private Integer measuredWeightKg;       //

    private String transactionRef;          //

    private Date created;                   // QC命令创建时间

    private Date updated;                   // QC命令更新时间

    private Integer quanOfWork;

    public QC_CommandPO() {
    }

    public QC_CommandPO(Integer commandGkey, Integer fkOrderGkey, Integer orderVersion, Integer commandVersion, String qcId, String referenceId, String presumedContainerId, String fkWorkQueue, String status, String containerLastLocation, String containerCurrLocation, String containerOrigLocation, Integer containerLength, Integer transactionId, Integer measuredWeightKg, String transactionRef, Date created, Date updated,Integer quanOfWork) {
        this.commandGkey = commandGkey;
        this.fkOrderGkey = fkOrderGkey;
        this.orderVersion = orderVersion;
        this.commandVersion = commandVersion;
        this.qcId = qcId;
        this.referenceId = referenceId;
        this.presumedContainerId = presumedContainerId;
        this.fkWorkQueue = fkWorkQueue;
        this.status = status;
        this.containerLastLocation = containerLastLocation;
        this.containerCurrLocation = containerCurrLocation;
        this.containerOrigLocation = containerOrigLocation;
        this.containerLength = containerLength;
        this.transactionId = transactionId;
        this.measuredWeightKg = measuredWeightKg;
        this.transactionRef = transactionRef;
        this.created = created;
        this.updated = updated;
        this.quanOfWork=quanOfWork;
    }

    public Integer getCommandGkey() {
        return commandGkey;
    }

    public void setCommandGkey(Integer commandGkey) {
        this.commandGkey = commandGkey;
    }

    public Integer getFkOrderGkey() {
        return fkOrderGkey;
    }

    public void setFkOrderGkey(Integer fkOrderGkey) {
        this.fkOrderGkey = fkOrderGkey;
    }

    public Integer getOrderVersion() {
        return orderVersion;
    }

    public void setOrderVersion(Integer orderVersion) {
        this.orderVersion = orderVersion;
    }

    public Integer getCommandVersion() {
        return commandVersion;
    }

    public void setCommandVersion(Integer commandVersion) {
        this.commandVersion = commandVersion;
    }

    public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getPresumedContainerId() {
        return presumedContainerId;
    }

    public void setPresumedContainerId(String presumedContainerId) {
        this.presumedContainerId = presumedContainerId;
    }

    public String getFkWorkQueue() {
        return fkWorkQueue;
    }

    public void setFkWorkQueue(String fkWorkQueue) {
        this.fkWorkQueue = fkWorkQueue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContainerLastLocation() {
        return containerLastLocation;
    }

    public void setContainerLastLocation(String containerLastLocation) {
        this.containerLastLocation = containerLastLocation;
    }

    public String getContainerCurrLocation() {
        return containerCurrLocation;
    }

    public void setContainerCurrLocation(String containerCurrLocation) {
        this.containerCurrLocation = containerCurrLocation;
    }

    public String getContainerOrigLocation() {
        return containerOrigLocation;
    }

    public void setContainerOrigLocation(String containerOrigLocation) {
        this.containerOrigLocation = containerOrigLocation;
    }

    public Integer getContainerLength() {
        return containerLength;
    }

    public void setContainerLength(Integer containerLength) {
        this.containerLength = containerLength;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getMeasuredWeightKg() {
        return measuredWeightKg;
    }

    public void setMeasuredWeightKg(Integer measuredWeightKg) {
        this.measuredWeightKg = measuredWeightKg;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getQuanOfWork() {
        return quanOfWork;
    }

    public void setQuanOfWork(Integer quanOfWork) {
        this.quanOfWork = quanOfWork;
    }
}
