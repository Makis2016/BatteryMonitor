package com.furongsoft.Public.Model;

/**
 * Created by Administrator on 2016/8/26.
 * 电池组参数
 */
public class BatteryPackParams
{
    /**
     * 电池组ID
     */
    private Long batteryPack_id;
    /**
     * 电池组名称
     */
    private String batteryPack_name;
    /**
     * 单体个数
     */
    private Integer batteryCount;
    /**
     * 电池组规格
     * VoltLevel2V
     * VoltLevel12V
     */
    private String type;
    /**
     * 电池组容量
     */
    private Double capacity;
    /**
     * 单体电池电压范围
     */
    private Double voltageRange;
    /**
     * 自动测试周期
     */
    private String checkCycleTime;
    /**
     * 特性曲线csv
     */
    private String battery_characteristicCurve;

    /**
     * 电池组端电压门限（高）
     */
    private Double groupVoltageUp;
    /**
     * 电池组端电压门限（低）
     */
    private Double groupVoltageDown;
    /**
     * 环境温度门限
     */
    private Double envirTeaperature;
    /**
     * 电池组端电流门限
     */
    private Double groupCurrentThreshold;
    /**
     * 电池组纹波电流门限
     */
    private Double groupRippleCurrent;
    /**
     * 电池组纹波电压门限
     */
    private Double groupRippleVoltage;
    /**
     * 电池组绝缘泄漏电流门限
     */
    private Double groupLeakageCurrent;
    /**
     * 电池组告警阈值配置JSON
     */
    private String thresholdConfig;

    /**
     * 一级温度告警线
     */
    private Double batteryTeamperatureLevelBaseLine1;
    /**
     * 二级温度告警线
     */
    private Double batteryTeamperatureLevelBaseLine2;
    /**
     * 一级电压告警线
     */
    private Double batteryVoltageLevelBaseLine1;
    /**
     * 二级电压告警线
     */
    private Double batteryVoltageLevelBaseLine2;
    /**
     * 一级内阻告警线
     */
    private Double batteryResistanceLevelBaseLine1;
    /**
     * 二级内阻告警线
     */
    private Double batteryResistanceLevelBaseLine2;

    public Long getBatteryPack_id()
    {
        return batteryPack_id;
    }

    public void setBatteryPack_id(Long batteryPack_id)
    {
        this.batteryPack_id = batteryPack_id;
    }

    public String getBatteryPack_name()
    {
        return batteryPack_name;
    }

    public void setBatteryPack_name(String batteryPack_name)
    {
        this.batteryPack_name = batteryPack_name;
    }

    public Integer getBatteryCount()
    {
        return batteryCount;
    }

    public void setBatteryCount(Integer batteryCount)
    {
        this.batteryCount = batteryCount;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Double getCapacity()
    {
        return capacity;
    }

    public void setCapacity(Double capacity)
    {
        this.capacity = capacity;
    }

    public Double getVoltageRange()
    {
        return voltageRange;
    }

    public void setVoltageRange(Double voltageRange)
    {
        this.voltageRange = voltageRange;
    }

    public String getCheckCycleTime()
    {
        return checkCycleTime;
    }

    public void setCheckCycleTime(String checkCycleTime)
    {
        this.checkCycleTime = checkCycleTime;
    }

    public String getBattery_characteristicCurve()
    {
        return battery_characteristicCurve;
    }

    public void setBattery_characteristicCurve(String battery_characteristicCurve)
    {
        this.battery_characteristicCurve = battery_characteristicCurve;
    }

    public Double getGroupVoltageUp()
    {
        return groupVoltageUp;
    }

    public void setGroupVoltageUp(Double groupVoltageUp)
    {
        this.groupVoltageUp = groupVoltageUp;
    }

    public Double getGroupVoltageDown()
    {
        return groupVoltageDown;
    }

    public void setGroupVoltageDown(Double groupVoltageDown)
    {
        this.groupVoltageDown = groupVoltageDown;
    }

    public Double getEnvirTeaperature()
    {
        return envirTeaperature;
    }

    public void setEnvirTeaperature(Double envirTeaperature)
    {
        this.envirTeaperature = envirTeaperature;
    }

    public Double getGroupCurrentThreshold()
    {
        return groupCurrentThreshold;
    }

    public void setGroupCurrentThreshold(Double groupCurrentThreshold)
    {
        this.groupCurrentThreshold = groupCurrentThreshold;
    }

    public Double getGroupRippleCurrent()
    {
        return groupRippleCurrent;
    }

    public void setGroupRippleCurrent(Double groupRippleCurrent)
    {
        this.groupRippleCurrent = groupRippleCurrent;
    }

    public Double getGroupRippleVoltage()
    {
        return groupRippleVoltage;
    }

    public void setGroupRippleVoltage(Double groupRippleVoltage)
    {
        this.groupRippleVoltage = groupRippleVoltage;
    }

    public Double getGroupLeakageCurrent()
    {
        return groupLeakageCurrent;
    }

    public void setGroupLeakageCurrent(Double groupLeakageCurrent)
    {
        this.groupLeakageCurrent = groupLeakageCurrent;
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

    public String getThresholdConfig()
    {
        return thresholdConfig;
    }

    public void setThresholdConfig(String thresholdConfig)
    {
        this.thresholdConfig = thresholdConfig;
    }
}