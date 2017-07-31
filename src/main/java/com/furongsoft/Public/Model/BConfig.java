package com.furongsoft.Public.Model;

/**
 * Created by LYD on 2016/8/29.
 */
public class BConfig
{
    private Double VoltageThresholdUp;
    private Double VoltageThresholdDown;
    private Double ResistanceLevel1;
    private Double ResistanceLevel2;
    private Double Battery_rippleVoltageLimit;
    private Double Temperature;

    public Double getVoltageThresholdUp()
    {
        return VoltageThresholdUp;
    }

    public void setVoltageThresholdUp(Double voltageThresholdUp)
    {
        VoltageThresholdUp = voltageThresholdUp;
    }

    public Double getVoltageThresholdDown()
    {
        return VoltageThresholdDown;
    }

    public void setVoltageThresholdDown(Double voltageThresholdDown)
    {
        VoltageThresholdDown = voltageThresholdDown;
    }

    public Double getResistanceLevel1()
    {
        return ResistanceLevel1;
    }

    public void setResistanceLevel1(Double resistanceLevel1)
    {
        ResistanceLevel1 = resistanceLevel1;
    }

    public Double getResistanceLevel2()
    {
        return ResistanceLevel2;
    }

    public void setResistanceLevel2(Double resistanceLevel2)
    {
        ResistanceLevel2 = resistanceLevel2;
    }

    public Double getBattery_rippleVoltageLimit()
    {
        return Battery_rippleVoltageLimit;
    }

    public void setBattery_rippleVoltageLimit(Double battery_rippleVoltageLimit)
    {
        Battery_rippleVoltageLimit = battery_rippleVoltageLimit;
    }

    public Double getTemperature()
    {
        return Temperature;
    }

    public void setTemperature(Double temperature)
    {
        Temperature = temperature;
    }
}