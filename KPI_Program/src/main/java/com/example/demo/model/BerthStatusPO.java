package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by WZB on 2017/7/5.
 */
@Entity
@Table(name = "BERTH_STATUS")
public class BerthStatusPO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vesselVisit;             //船舶单次进入岸桥编号


    private String vesselCallSign;          //船舶标志


    private String vesselName;              //船舶名


    private String bowBollard;              //船舶首-系柱编号


    private Integer bowBollardOffsetCm;     //船舶首-系柱偏移量


    private String sternBollard;            //船舶尾-系柱编号


    private Integer sternBollardOffsetCm;   //船舶尾-系柱偏移量


    private String vesselClassification;    //船舶级别


    private String vesselVisitPhase;        //船舶到访时段


    private Date updated;                   //更新时间

    public BerthStatusPO() {
    }

    public BerthStatusPO(String vesselVisit, String vesselCallSign, String vesselName, String bowBollard, Integer bowBollardOffsetCm, String sternBollard, Integer sternBollardOffsetCm, String vesselClassification, String vesselVisitPhase, Date updated) {
        this.vesselVisit = vesselVisit;
        this.vesselCallSign = vesselCallSign;
        this.vesselName = vesselName;
        this.bowBollard = bowBollard;
        this.bowBollardOffsetCm = bowBollardOffsetCm;
        this.sternBollard = sternBollard;
        this.sternBollardOffsetCm = sternBollardOffsetCm;
        this.vesselClassification = vesselClassification;
        this.vesselVisitPhase = vesselVisitPhase;
        this.updated = updated;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vesselVisit", unique = true, nullable = false)
    public String getVesselVisit() {
        return vesselVisit;
    }

    public void setVesselVisit(String vesselVisit) {
        this.vesselVisit = vesselVisit;
    }

    public String getVesselCallSign() {
        return vesselCallSign;
    }

    public void setVesselCallSign(String vesselCallSign) {
        this.vesselCallSign = vesselCallSign;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getBowBollard() {
        return bowBollard;
    }

    public void setBowBollard(String bowBollard) {
        this.bowBollard = bowBollard;
    }

    public Integer getBowBollardOffsetCm() {
        return bowBollardOffsetCm;
    }

    public void setBowBollardOffsetCm(Integer bowBollardOffsetCm) {
        this.bowBollardOffsetCm = bowBollardOffsetCm;
    }

    public String getSternBollard() {
        return sternBollard;
    }

    public void setSternBollard(String sternBollard) {
        this.sternBollard = sternBollard;
    }

    public Integer getSternBollardOffsetCm() {
        return sternBollardOffsetCm;
    }

    public void setSternBollardOffsetCm(Integer sternBollardOffsetCm) {
        this.sternBollardOffsetCm = sternBollardOffsetCm;
    }

    public String getVesselClassification() {
        return vesselClassification;
    }

    public void setVesselClassification(String vesselClassification) {
        this.vesselClassification = vesselClassification;
    }

    public String getVesselVisitPhase() {
        return vesselVisitPhase;
    }

    public void setVesselVisitPhase(String vesselVisitPhase) {
        this.vesselVisitPhase = vesselVisitPhase;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
