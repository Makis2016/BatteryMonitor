package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/8/11.
 */
public class MBattery
{
    private Long mId;
    private Double mVoltage;
    private Double mCurrent;
    private Double mResistance;
    private Double mTemp;
    private Double mResistanceReference;
    private Boolean mAlarmState;

    public Long getmId()
    {
        return mId;
    }

    public void setmId(Long mId)
    {
        this.mId = mId;
    }

    public Double getmVoltage()
    {
        return mVoltage;
    }

    public void setmVoltage(Double mVoltage)
    {
        this.mVoltage = mVoltage;
    }

    public Double getmCurrent()
    {
        return mCurrent;
    }

    public void setmCurrent(Double mCurrent)
    {
        this.mCurrent = mCurrent;
    }

    public Double getmResistance()
    {
        return mResistance;
    }

    public void setmResistance(Double mResistance)
    {
        this.mResistance = mResistance;
    }

    public Double getmTemp()
    {
        return mTemp;
    }

    public void setmTemp(Double mTemp)
    {
        this.mTemp = mTemp;
    }

    public Double getmResistanceReference()
    {
        return mResistanceReference;
    }

    public void setmResistanceReference(Double mResistanceReference)
    {
        this.mResistanceReference = mResistanceReference;
    }

    public Boolean getmAlarmState() {
        return mAlarmState;
    }

    public void setmAlarmState(Boolean mAlarmState) {
        this.mAlarmState = mAlarmState;
    }
}