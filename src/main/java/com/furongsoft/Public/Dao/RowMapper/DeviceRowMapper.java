package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Dao.Entities.Device;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/18.
 */
public class DeviceRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Device device = new Device();
        device.setId(rs.getLong("id"));
        device.setName(rs.getString("name"));
        device.setType(rs.getString("type"));
        device.setConfig(rs.getString("config"));
        return device;
    }
}
