package com.furongsoft.Public.Dao.RowMapper;

import com.furongsoft.Public.Model.BatteryPackSF;
import com.furongsoft.Public.Model.MCircuit;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.CircuitInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 80653 on 2018/1/10.
 */
public class CircuitMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        MCircuit circuitInfo = new MCircuit();
        circuitInfo.setmId(rs.getLong("id"));
        return circuitInfo;
    }
}
