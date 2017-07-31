package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Model.BatteryPackSF;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 80653 on 2017/5/8.
 */
public class BatteryPackSFRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        BatteryPackSF batteryPackSF = new BatteryPackSF();
        batteryPackSF.setId(rs.getLong("id"));
        batteryPackSF.setBattery_pack_id(rs.getLong("battery_pack_id"));
        batteryPackSF.setCapacity(rs.getDouble("capacity"));
        batteryPackSF.setCharacter(rs.getBlob("character"));
        batteryPackSF.setBattery_resistance_level_base_line1(rs.getDouble("battery_resistance_level_base_line1"));
        batteryPackSF.setBattery_resistance_level_base_line2(rs.getDouble("battery_resistance_level_base_line2"));
        batteryPackSF.setBattery_teamperature_level_base_line1(rs.getDouble("battery_teamperature_level_base_line1"));
        batteryPackSF.setBattery_teamperature_level_base_line2(rs.getDouble("battery_teamperature_level_base_line2"));
        batteryPackSF.setBattery_voltage_level_base_line1(rs.getDouble("battery_voltage_level_base_line1"));
        batteryPackSF.setBattery_voltage_level_base_line2(rs.getDouble("battery_voltage_level_base_line2"));
        batteryPackSF.setThreshold_config(rs.getString("threshold_config"));
        batteryPackSF.setCheck_resistance_cycle(rs.getInt("check_resistance_cycle"));
        batteryPackSF.setVoltage_range(rs.getDouble("voltage_range"));
        return batteryPackSF;
    }
}
