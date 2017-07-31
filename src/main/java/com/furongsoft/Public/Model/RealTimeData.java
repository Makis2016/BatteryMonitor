package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/10/12.
 */
public class RealTimeData
{
    private String mAreaStr;
    private String[] mBatteryPackName;
    private Double[] mBatteryPackVoltage;
    private Double[] mBatteryPackCurrent;
    private Double[] mBatteryPackTemperature;
    private Double[] mResistanceReference;
    private Object mBatteryGridDataList;

    public RealTimeData(int size){
        this.mBatteryPackName = new String[size];
        this.mBatteryPackVoltage = new Double[size];
        this.mBatteryPackCurrent = new Double[size];
        this.mBatteryPackTemperature = new Double[size];
        this.mResistanceReference = new Double[size];
    }

    public String getmAreaStr()
    {
        return mAreaStr;
    }

    public void setmAreaStr(String mAreaStr)
    {
        this.mAreaStr = mAreaStr;
    }

    public String[] getmBatteryPackName()
    {
        return mBatteryPackName;
    }

    public void setmBatteryPackName(String[] mBatteryPackName)
    {
        this.mBatteryPackName = mBatteryPackName;
    }

    public Double[] getmBatteryPackVoltage()
    {
        return mBatteryPackVoltage;
    }

    public void setmBatteryPackVoltage(Double[] mBatteryPackVoltage)
    {
        this.mBatteryPackVoltage = mBatteryPackVoltage;
    }

    public Double[] getmBatteryPackCurrent()
    {
        return mBatteryPackCurrent;
    }

    public void setmBatteryPackCurrent(Double[] mBatteryPackCurrent)
    {
        this.mBatteryPackCurrent = mBatteryPackCurrent;
    }

    public Double[] getmBatteryPackTemperature()
    {
        return mBatteryPackTemperature;
    }

    public void setmBatteryPackTemperature(Double[] mBatteryPackTemperature)
    {
        this.mBatteryPackTemperature = mBatteryPackTemperature;
    }

    public Object getmBatteryGridDataList()
    {
        return mBatteryGridDataList;
    }

    public void setmBatteryGridDataList(Object mBatteryGridDataList)
    {
        this.mBatteryGridDataList = mBatteryGridDataList;
    }

    public Double[] getmResistanceReference()
    {
        return mResistanceReference;
    }

    public void setmResistanceReference(Double[] mResistanceReference)
    {
        this.mResistanceReference = mResistanceReference;
    }
}