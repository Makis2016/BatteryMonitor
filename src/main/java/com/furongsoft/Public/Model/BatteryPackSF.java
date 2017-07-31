package com.furongsoft.Public.Model;


import java.sql.Blob;

/**
 * Created by 80653 on 2017/5/8.
 */
public class BatteryPackSF {

    /**
     * ID
     */
    private Long id ;

    /**
     * 电池组索引
     */
    private Long battery_pack_id;

    /**
     * 电池容量(单位:AH)
     */
    private Double capacity;

    /**
     * 内阻检测周期(单位:分钟)
     */
    private Integer check_resistance_cycle;

    /**
     * 单体电池电压范围(单位:V)
     */
    private Double voltage_range;

    /**
     * 阈值配置
     */
    private String threshold_config;

    /**
     * 单体1级温度基准线(单位:℃)
     */
    private Double battery_teamperature_level_base_line1;

    /**
     * 单体2级温度基准线(单位:℃)
     */
    private Double battery_teamperature_level_base_line2;

    /**
     * 单体1级电压基准线(单位:V)
     */
    private Double battery_voltage_level_base_line1;

    /**
     * 单体2级电压基准线(单位:V)
     */
    private Double battery_voltage_level_base_line2;

    /**
     * 单体1级内阻基准线(单位:mΩ)
     */
    private Double battery_resistance_level_base_line1;

    /**
     * 单体2级内阻基准线(单位:mΩ)
     */
    private Double battery_resistance_level_base_line2;

    /**
     * 特性曲线(二维数组)
     */
    private Blob character;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBattery_pack_id() {
        return battery_pack_id;
    }

    public void setBattery_pack_id(Long battery_pack_id) {
        this.battery_pack_id = battery_pack_id;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Integer getCheck_resistance_cycle() {
        return check_resistance_cycle;
    }

    public void setCheck_resistance_cycle(Integer check_resistance_cycle) {
        this.check_resistance_cycle = check_resistance_cycle;
    }

    public Double getVoltage_range() {
        return voltage_range;
    }

    public void setVoltage_range(Double voltage_range) {
        this.voltage_range = voltage_range;
    }

    public String getThreshold_config() {
        return threshold_config;
    }

    public void setThreshold_config(String threshold_config) {
        this.threshold_config = threshold_config;
    }

    public Double getBattery_teamperature_level_base_line1() {
        return battery_teamperature_level_base_line1;
    }

    public void setBattery_teamperature_level_base_line1(Double battery_teamperature_level_base_line1) {
        this.battery_teamperature_level_base_line1 = battery_teamperature_level_base_line1;
    }

    public Double getBattery_teamperature_level_base_line2() {
        return battery_teamperature_level_base_line2;
    }

    public void setBattery_teamperature_level_base_line2(Double battery_teamperature_level_base_line2) {
        this.battery_teamperature_level_base_line2 = battery_teamperature_level_base_line2;
    }

    public Double getBattery_voltage_level_base_line1() {
        return battery_voltage_level_base_line1;
    }

    public void setBattery_voltage_level_base_line1(Double battery_voltage_level_base_line1) {
        this.battery_voltage_level_base_line1 = battery_voltage_level_base_line1;
    }

    public Double getBattery_voltage_level_base_line2() {
        return battery_voltage_level_base_line2;
    }

    public void setBattery_voltage_level_base_line2(Double battery_voltage_level_base_line2) {
        this.battery_voltage_level_base_line2 = battery_voltage_level_base_line2;
    }

    public Double getBattery_resistance_level_base_line1() {
        return battery_resistance_level_base_line1;
    }

    public void setBattery_resistance_level_base_line1(Double battery_resistance_level_base_line1) {
        this.battery_resistance_level_base_line1 = battery_resistance_level_base_line1;
    }

    public Double getBattery_resistance_level_base_line2() {
        return battery_resistance_level_base_line2;
    }

    public void setBattery_resistance_level_base_line2(Double battery_resistance_level_base_line2) {
        this.battery_resistance_level_base_line2 = battery_resistance_level_base_line2;
    }

    public Blob getCharacter() {
        return character;
    }

    public void setCharacter(Blob character) {
        this.character = character;
    }
}
