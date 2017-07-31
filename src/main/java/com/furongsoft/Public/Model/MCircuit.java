package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MCircuit
{
    private Long mId;
    private String mName;
    private Long mBatteryPackId;
    private int mElectricity;
    private Double mVoltage;
    private Double mCurrent;
    private String mMonitorStatus;
    private String mCircuitStatus;
    private MBatteryPack mBatteryPack;
    private String mAreaStr;


    public Long getmId()
    {
        return mId;
    }

    public void setmId(Long mId)
    {
        this.mId = mId;
    }

    public String getmName()
    {
        return mName;
    }

    public void setmName(String name)
    {
        this.mName = name;
    }

    public Long getmBatteryPackId()
    {
        return mBatteryPackId;
    }

    public void setmBatteryPackId(Long mBatteryPackId)
    {
        this.mBatteryPackId = mBatteryPackId;
    }

    public int getmElectricity()
    {
        return mElectricity;
    }

    public void setmElectricity(int mElectricity)
    {
        this.mElectricity = mElectricity;
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

    public String getmMonitorStatus()
    {
        return mMonitorStatus;
    }

    public void setmMonitorStatus(String mMonitorStatus)
    {
        this.mMonitorStatus = mMonitorStatus;
    }

    public String getmCircuitStatus()
    {
        return mCircuitStatus;
    }

    public void setmCircuitStatus(String mCircuitStatus)
    {
        this.mCircuitStatus = mCircuitStatus;
    }

    public MBatteryPack getmBatteryPack()
    {
        return mBatteryPack;
    }

    public void setmBatteryPack(MBatteryPack mBatteryPack)
    {
        this.mBatteryPack = mBatteryPack;
    }

    public String getmAreaStr()
    {
        return mAreaStr;
    }

    public void setmAreaStr(String mAreaStr)
    {
        this.mAreaStr = mAreaStr;
    }
}