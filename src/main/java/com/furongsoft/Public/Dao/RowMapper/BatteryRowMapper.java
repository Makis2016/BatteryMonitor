package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Model.Battery;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/12.
 */
public class BatteryRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Battery battery = new Battery();
        battery.setId(rs.getLong("id"));// 电池索引
        battery.setBattery_name(rs.getString("name"));// 单体电池名称
        battery.setBarcode(rs.getString("barcode"));// 条码
        int isAlarm = rs.getInt("is_shield_alarm");// 是否告警(0不告警，1告警)
        if (isAlarm > 0) {
            battery.setAlarm(true);// 是否告警(0不告警，1告警)
        }
        else {
            battery.setAlarm(false);// 是否告警(0不告警，1告警)
        }

        battery.setBattery_specifications(rs.getString("type"));// 电池规格
        battery.setBattery_firstUseDate(rs.getString("first_time"));// 首次使用时间
        battery.setCapacityCheckPoInt32(rs.getDouble("capacity_check_point"));// 容量标准点
        battery.setVirtualAmp(rs.getDouble("virtual_amp"));// 典型放电电流
        battery.setVirtualCapacity(rs.getDouble("virtual_capacity"));// 典型容量
        battery.setThresholdConfig(rs.getString("threshold_config"));// 阈值配置
        battery.setSchedulingCycle(rs.getDouble("scheduling_cycle"));// 调度周期
        battery.setProductionDate(rs.getString("produce_time"));// 创建时间
        battery.setProducerName(rs.getString("producer"));// 生产商
        battery.setFloatChargeVolt(rs.getDouble("float_charge_volt"));// 浮充电压
        battery.setFloatChargeLife(rs.getDouble("design_float_life"));// 设计浮充寿命
        battery.setEqualChargeVolt(rs.getDouble("equal_charge_volt"));// 均充电压
        battery.setDesignVoltage(rs.getDouble("design_voltage"));// 设计电压
        battery.setChargeRate(rs.getDouble("charge_rate"));// 充电效率
        battery.setCellNum(rs.getInt("cell_count"));// 单体数量
        battery.setSerialNum(rs.getString("serial_no"));// 序列号
        battery.setInitCapacity(rs.getDouble("init_capacity"));// 电池容量
        battery.setChemicalComposition(rs.getString("chemical_composition"));// 化学组成
        battery.setCircleLife(rs.getDouble("design_cycle_life"));// 设计循环次数
        battery.setBattery_pack_id(rs.getLong("battery_pack_id")); // 电池组ID
        return battery;
    }
}