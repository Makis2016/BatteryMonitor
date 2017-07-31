package com.furongsoft.Public.Dao.Entities;

/**
 * Created by Administrator on 2016/8/18.
 */
public class BatteryPack
{
    private long id;
    private String name;
    private String count;
    private String capacity;
    private String createTime;
    private Integer checkCycleTime;
    private String voltageRange;
    private String thresholdConfig;
    private String type;
    private Double batteryTeamperatureLevelBaseLine1;
    private Double batteryTeamperatureLevelBaseLine2;
    private Double batteryVoltageLevelBaseLine1;
    private Double batteryVoltageLevelBaseLine2;
    private Double batteryResistanceLevelBaseLine1;
    private Double batteryResistanceLevelBaseLine2;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getCount()
    {
        return count;
    }

    public void setCount(String count)
    {
        this.count = count;
    }

    public Integer getCheckCycleTime()
    {
        return checkCycleTime;
    }

    public void setCheckCycleTime(Integer checkCycleTime)
    {
        this.checkCycleTime = checkCycleTime;
    }

    public String getVoltageRange()
    {
        return voltageRange;
    }

    public void setVoltageRange(String voltageRange)
    {
        this.voltageRange = voltageRange;
    }

    public String getThresholdConfig()
    {
        return thresholdConfig;
    }

    public void setThresholdConfig(String thresholdConfig)
    {
        this.thresholdConfig = thresholdConfig;
    }

    public String getCapacity()
    {
        return capacity;
    }

    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Double getBatteryTeamperatureLevelBaseLine1()
    {
        return batteryTeamperatureLevelBaseLine1;
    }

    public void setBatteryTeamperatureLevelBaseLine1(Double batteryTeamperatureLevelBaseLine1)
    {
        this.batteryTeamperatureLevelBaseLine1 = batteryTeamperatureLevelBaseLine1;
    }

    public Double getBatteryTeamperatureLevelBaseLine2()
    {
        return batteryTeamperatureLevelBaseLine2;
    }

    public void setBatteryTeamperatureLevelBaseLine2(Double batteryTeamperatureLevelBaseLine2)
    {
        this.batteryTeamperatureLevelBaseLine2 = batteryTeamperatureLevelBaseLine2;
    }

    public Double getBatteryVoltageLevelBaseLine1()
    {
        return batteryVoltageLevelBaseLine1;
    }

    public void setBatteryVoltageLevelBaseLine1(Double batteryVoltageLevelBaseLine1)
    {
        this.batteryVoltageLevelBaseLine1 = batteryVoltageLevelBaseLine1;
    }

    public Double getBatteryVoltageLevelBaseLine2()
    {
        return batteryVoltageLevelBaseLine2;
    }

    public void setBatteryVoltageLevelBaseLine2(Double batteryVoltageLevelBaseLine2)
    {
        this.batteryVoltageLevelBaseLine2 = batteryVoltageLevelBaseLine2;
    }

    public Double getBatteryResistanceLevelBaseLine1()
    {
        return batteryResistanceLevelBaseLine1;
    }

    public void setBatteryResistanceLevelBaseLine1(Double batteryResistanceLevelBaseLine1)
    {
        this.batteryResistanceLevelBaseLine1 = batteryResistanceLevelBaseLine1;
    }

    public Double getBatteryResistanceLevelBaseLine2()
    {
        return batteryResistanceLevelBaseLine2;
    }

    public void setBatteryResistanceLevelBaseLine2(Double batteryResistanceLevelBaseLine2)
    {
        this.batteryResistanceLevelBaseLine2 = batteryResistanceLevelBaseLine2;
    }
}