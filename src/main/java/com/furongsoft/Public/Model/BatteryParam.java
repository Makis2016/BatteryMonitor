package com.furongsoft.Public.Model;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/26.
 * 单体参数信息
 */
public class BatteryParam
{
    /**
     * 单体编号
     */
    private Long no;
    /**
     * 是否屏蔽告警(true 屏蔽，false 不屏蔽)
     */
    private Boolean isAlarm;
    /**
     * 化学组成
     */
    private String chemicalComposition;
    /**
     * 单体数量
     */
    private Integer cellNum;
    /**
     * 单体初始容量
     */
    private Double initCapacity;
    /**
     * 单体名称
     */
    private String battery_name;
    /**
     * 生产厂商
     */
    private String producerName;
    /**
     * 生产日期
     */
    private String productionDate;
    /**
     * 首次使用时间
     */
    private String battery_firstUseDate;
    /**
     * 序列号
     */
    private String serialNum;
    /**
     * 条形码
     */
    private String barcode;
    /**
     * 版本信息
     */
    private String battery_version;
    /**
     * 单体类型
     * VoltLevel2V
     * VoltLevel12V
     */
    private String battery_specifications;
    /**
     * 浮充寿命
     */
    private Double floatChargeLife;
    /**
     * 循环寿命
     */
    private Double circleLife;
    /**
     * 浮充电压
     */
    private Double floatChargeVolt;
    /**
     * 匀充电压
     */
    private Double equalChargeVolt;
    /**
     * 容量校准点
     */
    private Double capacityCheckPoInt32;
    /**
     * 典型放电容量
     */
    private Double virtualCapacity;
    /**
     * 典型放电电流
     */
    private Double virtualAmp;
    /**
     * 充电效率
     */
    private Double chargeRate;
    /**
     * 数据刷新周期
     */
    private Double schedulingCycle;

    /**
     * 单体电池电压门限(高)
     */
    private Double voltageThresholdUp;
    /**
     * 单体电池电压门限(低)
     */
    private Double voltageThresholdDown;
    /**
     * 单体内阻门限(高)
     */
    private Double resistanceLevel1;
    /**
     * 单体内阻门限(低)
     */
    private Double resistanceLevel2;
    /**
     * 单体纹波电压门限
     */
    private Double battery_rippleVoltageLimit;
    /**
     * 单体极柱温度
     */
    private Double temperature;
    /**
     * 单体告警阈值配置JSON
     */
    private String thresholdConfig;

    public Long getNo()
    {
        return no;
    }

    public void setNo(Long no)
    {
        this.no = no;
    }

    public Boolean getIsAlarm()
    {
        return isAlarm;
    }

    public void setIsAlarm(Boolean alarm)
    {
        isAlarm = alarm;
    }

    public String getChemicalComposition()
    {
        return chemicalComposition;
    }

    public void setChemicalComposition(String chemicalComposition)
    {
        this.chemicalComposition = chemicalComposition;
    }

    public Integer getCellNum()
    {
        return cellNum;
    }

    public void setCellNum(Integer cellNum)
    {
        this.cellNum = cellNum;
    }

    public Double getInitCapacity()
    {
        return initCapacity;
    }

    public void setInitCapacity(Double initCapacity)
    {
        this.initCapacity = initCapacity;
    }

    public String getBattery_name()
    {
        return battery_name;
    }

    public void setBattery_name(String battery_name)
    {
        this.battery_name = battery_name;
    }

    public String getProducerName()
    {
        return producerName;
    }

    public void setProducerName(String producerName)
    {
        this.producerName = producerName;
    }

    public String getProductionDate()
    {
        return productionDate;
    }

    public void setProductionDate(String productionDate)
    {
        this.productionDate = productionDate;
    }

    public String getBattery_firstUseDate()
    {
        return battery_firstUseDate;
    }

    public void setBattery_firstUseDate(String battery_firstUseDate)
    {
        this.battery_firstUseDate = battery_firstUseDate;
    }

    public String getSerialNum()
    {
        return serialNum;
    }

    public void setSerialNum(String serialNum)
    {
        this.serialNum = serialNum;
    }

    public String getBarcode()
    {
        return barcode;
    }

    public void setBarcode(String barcode)
    {
        this.barcode = barcode;
    }

    public String getBattery_version()
    {
        return battery_version;
    }

    public void setBattery_version(String battery_version)
    {
        this.battery_version = battery_version;
    }

    public String getBattery_specifications()
    {
        return battery_specifications;
    }

    public void setBattery_specifications(String battery_specifications)
    {
        this.battery_specifications = battery_specifications;
    }

    public Double getFloatChargeLife()
    {
        return floatChargeLife;
    }

    public void setFloatChargeLife(Double floatChargeLife)
    {
        this.floatChargeLife = floatChargeLife;
    }

    public Double getCircleLife()
    {
        return circleLife;
    }

    public void setCircleLife(Double circleLife)
    {
        this.circleLife = circleLife;
    }

    public Double getFloatChargeVolt()
    {
        return floatChargeVolt;
    }

    public void setFloatChargeVolt(Double floatChargeVolt)
    {
        this.floatChargeVolt = floatChargeVolt;
    }

    public Double getEqualChargeVolt()
    {
        return equalChargeVolt;
    }

    public void setEqualChargeVolt(Double equalChargeVolt)
    {
        this.equalChargeVolt = equalChargeVolt;
    }

    public Double getCapacityCheckPoInt32()
    {
        return capacityCheckPoInt32;
    }

    public void setCapacityCheckPoInt32(Double capacityCheckPoInt32)
    {
        this.capacityCheckPoInt32 = capacityCheckPoInt32;
    }

    public Double getVirtualCapacity()
    {
        return virtualCapacity;
    }

    public void setVirtualCapacity(Double virtualCapacity)
    {
        this.virtualCapacity = virtualCapacity;
    }

    public Double getVirtualAmp()
    {
        return virtualAmp;
    }

    public void setVirtualAmp(Double virtualAmp)
    {
        this.virtualAmp = virtualAmp;
    }

    public Double getChargeRate()
    {
        return chargeRate;
    }

    public void setChargeRate(Double chargeRate)
    {
        this.chargeRate = chargeRate;
    }

    public Double getSchedulingCycle()
    {
        return schedulingCycle;
    }

    public void setSchedulingCycle(Double schedulingCycle)
    {
        this.schedulingCycle = schedulingCycle;
    }

    public Double getVoltageThresholdUp()
    {
        return voltageThresholdUp;
    }

    public void setVoltageThresholdUp(Double voltageThresholdUp)
    {
        this.voltageThresholdUp = voltageThresholdUp;
    }

    public Double getVoltageThresholdDown()
    {
        return voltageThresholdDown;
    }

    public void setVoltageThresholdDown(Double voltageThresholdDown)
    {
        this.voltageThresholdDown = voltageThresholdDown;
    }

    public Double getResistanceLevel1()
    {
        return resistanceLevel1;
    }

    public void setResistanceLevel1(Double resistanceLevel1)
    {
        this.resistanceLevel1 = resistanceLevel1;
    }

    public Double getResistanceLevel2()
    {
        return resistanceLevel2;
    }

    public void setResistanceLevel2(Double resistanceLevel2)
    {
        this.resistanceLevel2 = resistanceLevel2;
    }

    public Double getBattery_rippleVoltageLimit()
    {
        return battery_rippleVoltageLimit;
    }

    public void setBattery_rippleVoltageLimit(Double battery_rippleVoltageLimit)
    {
        this.battery_rippleVoltageLimit = battery_rippleVoltageLimit;
    }

    public Double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(Double temperature)
    {
        this.temperature = temperature;
    }

    public String getThresholdConfig()
    {
        return thresholdConfig;
    }

    public void setThresholdConfig(String thresholdConfig)
    {
        this.thresholdConfig = thresholdConfig;
    }

    public Boolean getAlarm()
    {
        return isAlarm;
    }

    public void setAlarm(Boolean alarm)
    {
        isAlarm = alarm;
    }
}