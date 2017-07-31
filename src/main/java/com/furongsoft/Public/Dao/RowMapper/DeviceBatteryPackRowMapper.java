package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Dao.Entities.BatteryPack;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 80653 on 2017/6/15.
 */
public class DeviceBatteryPackRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        BatteryPack batteryPack = new BatteryPack();
        batteryPack.setId(rs.getLong("id"));
        batteryPack.setName(rs.getString("name"));
        batteryPack.setCheckCycleTime(rs.getInt("check_resistance_cycle"));
        batteryPack.setCount(rs.getString("battery_count"));
        batteryPack.setCreateTime(rs.getString("create_time"));
        batteryPack.setThresholdConfig(rs.getString("threshold_config"));
        batteryPack.setVoltageRange(rs.getString("voltage_range"));
        batteryPack.setCapacity(rs.getString("capacity"));
        batteryPack.setType(rs.getString("type"));
        batteryPack.setBatteryResistanceLevelBaseLine1(rs.getDouble("battery_resistance_level_base_line1"));
        batteryPack.setBatteryResistanceLevelBaseLine2(rs.getDouble("battery_resistance_level_base_line2"));
        batteryPack.setBatteryTeamperatureLevelBaseLine1(rs.getDouble("battery_teamperature_level_base_line1"));
        batteryPack.setBatteryTeamperatureLevelBaseLine2(rs.getDouble("battery_teamperature_level_base_line2"));
        batteryPack.setBatteryVoltageLevelBaseLine1(rs.getDouble("battery_voltage_level_base_line1"));
        batteryPack.setBatteryVoltageLevelBaseLine2(rs.getDouble("battery_voltage_level_base_line2"));
        return batteryPack;
    }
}