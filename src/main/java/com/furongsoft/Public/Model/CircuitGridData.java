package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/8/22.
 */
public class CircuitGridData
{
    private Long id;
    private String name;
    private String batteryPack;
    private Long batteryPackId;
    private String area;
    private String areaIds;
    private long deviceId;
    private double volent;
    private double resistance;
    private double temperature;
    private double packVollent;
    private double current;
    private double environTemperature;
    private double rippleVoltage;
    private double leakageCurrent;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBatteryPack()
    {
        return batteryPack;
    }

    public void setBatteryPack(String batteryPack)
    {
        this.batteryPack = batteryPack;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getAreaIds()
    {
        return areaIds;
    }

    public void setAreaIds(String areaIds)
    {
        this.areaIds = areaIds;
    }

    public Long getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public double getVolent()
    {
        return volent;
    }

    public void setVolent(double volent)
    {
        this.volent = volent;
    }

    public double getResistance()
    {
        return resistance;
    }

    public void setResistance(double resistance)
    {
        this.resistance = resistance;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }

    public double getPackVollent()
    {
        return packVollent;
    }

    public void setPackVollent(double packVollent)
    {
        this.packVollent = packVollent;
    }

    public double getCurrent()
    {
        return current;
    }

    public void setCurrent(double current)
    {
        this.current = current;
    }

    public double getEnvironTemperature()
    {
        return environTemperature;
    }

    public void setEnvironTemperature(double environTemperature)
    {
        this.environTemperature = environTemperature;
    }

    public double getRippleVoltage()
    {
        return rippleVoltage;
    }

    public void setRippleVoltage(double rippleVoltage)
    {
        this.rippleVoltage = rippleVoltage;
    }

    public double getLeakageCurrent()
    {
        return leakageCurrent;
    }

    public void setLeakageCurrent(double leakageCurrent)
    {
        this.leakageCurrent = leakageCurrent;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getBatteryPackId()
    {
        return batteryPackId;
    }

    public Long getId()
    {
        return id;
    }

    public void setBatteryPackId(Long batteryPackId)
    {
        this.batteryPackId = batteryPackId;

    }

    public void setDeviceId(long deviceId)
    {
        this.deviceId = deviceId;
    }
}