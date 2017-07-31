package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Dao.Entities.BatteryPack;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/18.
 */
public class BatteryPackRowMapper implements RowMapper
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
        return batteryPack;
    }
}