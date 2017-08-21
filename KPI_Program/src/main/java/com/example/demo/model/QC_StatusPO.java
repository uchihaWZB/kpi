package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 岸桥状态PO
 *
 * Created by lenovopc001 on 2017/8/11.
 */
public class QC_StatusPO implements Serializable{

    private String qcId;

    private Date created;

    public QC_StatusPO() {
    }

    public QC_StatusPO(String qcId, Date created) {
        this.qcId = qcId;
        this.created = created;
    }

    public String getQcId() {
        return qcId;
    }

    public void setQcId(String qcId) {
        this.qcId = qcId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
