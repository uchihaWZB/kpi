package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by gaochangqing on 2017/8/25.
 */
@Entity
@Table(name = "T_STS_SHIP_TCG")
public class STS_SHIPTCGPO {

    private String VESSEL_NAME;

    private String VESSEL_VISIT;

    private String ABOVE_BELOW;

    private Integer BAY_NO;

    private String BERTHING_DIR;
    private Integer ACCS_SHIP_ID;
    private Integer MAX_COLUMN_NO;
    private Integer MIN_COLUMN_NO;
    private String COLUMN_POS_INFO;
    private Timestamp CREATED;

    public STS_SHIPTCGPO(String VESSEL_NAME, String VESSEL_VISIT, String ABOVE_BELOW, Integer BAY_NO, String BERTHING_DIR, Integer ACCS_SHIP_ID, Integer MAX_COLUMN_NO, Integer MIN_COLUMN_NO, String COLUMN_POS_INFO, Timestamp CREATED) {
        this.VESSEL_NAME = VESSEL_NAME;
        this.VESSEL_VISIT = VESSEL_VISIT;
        this.ABOVE_BELOW = ABOVE_BELOW;
        this.BAY_NO = BAY_NO;
        this.BERTHING_DIR = BERTHING_DIR;
        this.ACCS_SHIP_ID = ACCS_SHIP_ID;
        this.MAX_COLUMN_NO = MAX_COLUMN_NO;
        this.MIN_COLUMN_NO = MIN_COLUMN_NO;
        this.COLUMN_POS_INFO = COLUMN_POS_INFO;
        this.CREATED = CREATED;
    }

    public String getVESSEL_NAME() {
        return VESSEL_NAME;
    }

    public void setVESSEL_NAME(String VESSEL_NAME) {
        this.VESSEL_NAME = VESSEL_NAME;
    }

    public String getVESSEL_VISIT() {
        return VESSEL_VISIT;
    }

    public void setVESSEL_VISIT(String VESSEL_VISIT) {
        this.VESSEL_VISIT = VESSEL_VISIT;
    }

    public String getABOVE_BELOW() {
        return ABOVE_BELOW;
    }

    public void setABOVE_BELOW(String ABOVE_BELOW) {
        this.ABOVE_BELOW = ABOVE_BELOW;
    }

    public Integer getBAY_NO() {
        return BAY_NO;
    }

    public void setBAY_NO(Integer BAY_NO) {
        this.BAY_NO = BAY_NO;
    }

    public String getBERTHING_DIR() {
        return BERTHING_DIR;
    }

    public void setBERTHING_DIR(String BERTHING_DIR) {
        this.BERTHING_DIR = BERTHING_DIR;
    }

    public Integer getACCS_SHIP_ID() {
        return ACCS_SHIP_ID;
    }

    public void setACCS_SHIP_ID(Integer ACCS_SHIP_ID) {
        this.ACCS_SHIP_ID = ACCS_SHIP_ID;
    }

    public Integer getMAX_COLUMN_NO() {
        return MAX_COLUMN_NO;
    }

    public void setMAX_COLUMN_NO(Integer MAX_COLUMN_NO) {
        this.MAX_COLUMN_NO = MAX_COLUMN_NO;
    }

    public Integer getMIN_COLUMN_NO() {
        return MIN_COLUMN_NO;
    }

    public void setMIN_COLUMN_NO(Integer MIN_COLUMN_NO) {
        this.MIN_COLUMN_NO = MIN_COLUMN_NO;
    }

    public String getCOLUMN_POS_INFO() {
        return COLUMN_POS_INFO;
    }

    public void setCOLUMN_POS_INFO(String COLUMN_POS_INFO) {
        this.COLUMN_POS_INFO = COLUMN_POS_INFO;
    }

    public Timestamp getCREATED() {
        return CREATED;
    }

    public void setCREATED(Timestamp CREATED) {
        this.CREATED = CREATED;
    }
}
