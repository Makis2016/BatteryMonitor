package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Dao.Entities.Device;
import com.furongsoft.Public.Model.OperationLog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/26.
 */
public class OperationLogRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        OperationLog operationLog = new OperationLog();
        operationLog.setId(rs.getLong("id"));
        operationLog.setLogin_name(rs.getString("login_name"));
        operationLog.setOperation(rs.getString("operation"));
        operationLog.setOperation_result(rs.getString("operation_result"));
        operationLog.setTime(rs.getString("time"));
        return operationLog;
    }
}