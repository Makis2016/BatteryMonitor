package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Model.BatteryPackSF;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 80653 on 2017/11/8.
 */
public class BatteryPackCharacterMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        BatteryPackSF batteryPackSF = new BatteryPackSF();
        batteryPackSF.setId(rs.getLong("id"));
        batteryPackSF.setBattery_pack_id(rs.getLong("battery_pack_id"));
        batteryPackSF.setCharacter(rs.getBlob("character"));
        return batteryPackSF;
    }
}
