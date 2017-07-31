package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Model.MAlarm;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/10/18.
 */
public class AlarmRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        MAlarm mAlarm = new MAlarm();
        mAlarm.AlarmId = rs.getString("alarm_id");
        mAlarm.AlarmMessage = rs.getString("alarm_message");
        mAlarm.AreaName = rs.getString("area_name");
        mAlarm.Id = rs.getLong("id");
        mAlarm.Level = rs.getString("level");
        mAlarm.MaintainAdvise = rs.getString("maintain_advise");
        mAlarm.StrarTime = rs.getString("start_time");
        mAlarm.EndTime = rs.getString("end_time");
        return mAlarm;
    }
}