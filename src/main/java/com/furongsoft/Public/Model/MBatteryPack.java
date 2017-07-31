package com.furongsoft.Public.Model;

import org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPackHealthyState;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8 0008.
 * 电池组信息(界面展示)
 */
public class MBatteryPack {
    /**
     * 电池组ID
     */
    private Long mId;
    /**
     * 电池组名称
     */
    private String mName;
    /**
     * 电池组容量
     */
    private double mElectricity;
    /**
     * 电压
     */
    private Double mVoltage;
    /**
     * 电流
     */
    private Double mCurrent;
    /**
     * 单体温度
     */
    private Double mBatteryTemperature;
    /**
     * 电池组健康状态
     */
    private BatteryPackHealthyState mHealthyState;
    /**
     * 是否热失控(true 是 false 否)
     */
    private Boolean mThermalRunawayState;
    /**
     * 一级温度告警线
     */
    private Double mBatteryTeamperaturelevel1;
    /**
     * 二级温度告警线
     */
    private Double mBatteryTeamperaturelevel2;
    /**
     * 一级电压告警线
     */
    private Double mBatteryVoltage1;
    /**
     * 二级电压告警线
     */
    private Double mBatteryVoltage2;
    /**
     * 一级内阻告警线
     */
    private Double mBatteryResistance1;
    /**
     * 二级内阻告警线
     */
    private Double mBatteryResistance2;
    /**
     * 单体列表
     */
    private List<MBattery> mBatteryList;
    /**
     * 内阻基准值
     */
    private Double mResistanceReference;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public double getmElectricity() {
        return mElectricity;
    }

    public void setmElectricity(double mElectricity) {
        this.mElectricity = mElectricity;
    }

    public Double getmVoltage() {
        return mVoltage;
    }

    public void setmVoltage(Double mVoltage) {
        this.mVoltage = mVoltage;
    }

    public Double getmCurrent() {
        return mCurrent;
    }

    public void setmCurrent(Double mCurrent) {
        this.mCurrent = mCurrent;
    }

    public List<MBattery> getmBatteryList() {
        return mBatteryList;
    }

    public void setmBatteryList(List<MBattery> mBatteryList) {
        this.mBatteryList = mBatteryList;
    }

    public Double getmBatteryTemperature() {
        return mBatteryTemperature;
    }

    public void setmBatteryTemperature(Double mBatteryTemperature) {
        this.mBatteryTemperature = mBatteryTemperature;
    }

    public BatteryPackHealthyState getmHealthyState() {
        return mHealthyState;
    }

    public void setmHealthyState(BatteryPackHealthyState mHealthyState) {
        this.mHealthyState = mHealthyState;
    }

    public Boolean getmThermalRunawayState() {
        return mThermalRunawayState;
    }

    public void setmThermalRunawayState(Boolean mThermalRunawayState) {
        this.mThermalRunawayState = mThermalRunawayState;
    }

    public Double getmBatteryTeamperaturelevel1() {
        return mBatteryTeamperaturelevel1;
    }

    public void setmBatteryTeamperaturelevel1(Double mBatteryTeamperaturelevel1) {
        this.mBatteryTeamperaturelevel1 = mBatteryTeamperaturelevel1;
    }

    public Double getmBatteryTeamperaturelevel2() {
        return mBatteryTeamperaturelevel2;
    }

    public void setmBatteryTeamperaturelevel2(Double mBatteryTeamperaturelevel2) {
        this.mBatteryTeamperaturelevel2 = mBatteryTeamperaturelevel2;
    }

    public Double getmBatteryVoltage1() {
        return mBatteryVoltage1;
    }

    public void setmBatteryVoltage1(Double mBatteryVoltage1) {
        this.mBatteryVoltage1 = mBatteryVoltage1;
    }

    public Double getmBatteryVoltage2() {
        return mBatteryVoltage2;
    }

    public void setmBatteryVoltage2(Double mBatteryVoltage2) {
        this.mBatteryVoltage2 = mBatteryVoltage2;
    }

    public Double getmBatteryResistance1() {
        return mBatteryResistance1;
    }

    public void setmBatteryResistance1(Double mBatteryResistance1) {
        this.mBatteryResistance1 = mBatteryResistance1;
    }

    public Double getmBatteryResistance2() {
        return mBatteryResistance2;
    }

    public void setmBatteryResistance2(Double mBatteryResistance2) {
        this.mBatteryResistance2 = mBatteryResistance2;
    }

    public Double getmResistanceReference() {
        return mResistanceReference;
    }

    public void setmResistanceReference(Double mResistanceReference) {
        this.mResistanceReference = mResistanceReference;
    }


}