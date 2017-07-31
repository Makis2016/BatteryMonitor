package com.furongsoft.Public.Model;

/**
 * Created by LYD on 2016/8/29.
 */
public class BPConfig
{
    private Double GroupVoltageUp;
    private Double GroupVoltageDown;
    private Double EnvirTeaperature;
    private Double GroupCurrentThreshold;
    private Double GroupRippleCurrent;
    private Double GroupRippleVoltage;
    private Double GroupLeakageCurrent;

    public Double getGroupVoltageUp()
    {
        return GroupVoltageUp;
    }

    public void setGroupVoltageUp(Double groupVoltageUp)
    {
        GroupVoltageUp = groupVoltageUp;
    }

    public Double getGroupVoltageDown()
    {
        return GroupVoltageDown;
    }

    public void setGroupVoltageDown(Double groupVoltageDown)
    {
        GroupVoltageDown = groupVoltageDown;
    }

    public Double getEnvirTeaperature()
    {
        return EnvirTeaperature;
    }

    public void setEnvirTeaperature(Double envirTeaperature)
    {
        EnvirTeaperature = envirTeaperature;
    }

    public Double getGroupCurrentThreshold()
    {
        return GroupCurrentThreshold;
    }

    public void setGroupCurrentThreshold(Double groupCurrentThreshold)
    {
        GroupCurrentThreshold = groupCurrentThreshold;
    }

    public Double getGroupRippleCurrent()
    {
        return GroupRippleCurrent;
    }

    public void setGroupRippleCurrent(Double groupRippleCurrent)
    {
        GroupRippleCurrent = groupRippleCurrent;
    }

    public Double getGroupRippleVoltage()
    {
        return GroupRippleVoltage;
    }

    public void setGroupRippleVoltage(Double groupRippleVoltage)
    {
        GroupRippleVoltage = groupRippleVoltage;
    }

    public Double getGroupLeakageCurrent()
    {
        return GroupLeakageCurrent;
    }

    public void setGroupLeakageCurrent(Double groupLeakageCurrent)
    {
        GroupLeakageCurrent = groupLeakageCurrent;
    }
}