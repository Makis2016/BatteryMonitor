package com.furongsoft.Public.Services;

import com.alibaba.fastjson.JSON;
import com.furongsoft.Public.Dao.Entities.BatteryPack;
import com.furongsoft.Public.Dao.RowMapper.AlarmRowMapper;
import com.furongsoft.Public.Dao.RowMapper.BatteryPackRowMapper;
import com.furongsoft.Public.Model.MAlarm;
import com.furongsoft.Public.Model.PaginationResultByEuiGrid;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import com.furongsoft.XspWeb.Utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/18.
 */
@Service
public class HistoricalService
{
    @Autowired
    @Qualifier("BaseDao_system")
    public BaseDao baseDao;

    public String getBatteryPackByParams(int page, int rows, String paramsJson)
    {
        String sql = initBatteryPackSQLByParams(paramsJson);
        List<BatteryPack> batteryPacks = new ArrayList<>();
        Integer total = 0;
        if (!StringUtils.isNullOrEmpty(sql)) {
            String totalSQL = "SELECT COUNT(0) AS total FROM t_bpm_battery_pack";
            int startIndex = (page - 1) * rows;
            int maxRows = page * rows;
            sql += " LIMIT ?,?";
            SqlRowSet srs = baseDao.getJdbcTemplate().queryForRowSet(totalSQL);
            if (srs.next()) {
                total = srs.getInt("total");
                batteryPacks = baseDao.getJdbcTemplate()
                    .query(sql, new Object[]{startIndex, maxRows}, new BatteryPackRowMapper());
            }
        }
        return JSON.toJSONString(new PaginationResultByEuiGrid(
            total, batteryPacks));
    }

    public String getAlarmByParams(int page, int rows, String paramsJson)
    {
        List<MAlarm> mAlarmList = new ArrayList<>();
        String sql = initAlarmSQLByParams(paramsJson);
        Integer total = 0;
        if (!StringUtils.isNullOrEmpty(sql)) {
            String totalSQL = "SELECT COUNT(0) AS total FROM (" + sql + ")t";
            sql += " LIMIT " + ((page - 1) * rows) + "," + (page * rows);
            SqlRowSet srs = baseDao.getJdbcTemplate().queryForRowSet(totalSQL);
            if (srs.next()) {
                total = srs.getInt("total");
                mAlarmList = baseDao.getJdbcTemplate().query(sql, new AlarmRowMapper());
            }
        }
        return JSON.toJSONString(new PaginationResultByEuiGrid(total, mAlarmList));

    }

    public String getDateSourceJson(String paramsJson)
    {
        List<MAlarm> mAlarmList = new ArrayList<>();
        String sql = initAlarmSQLByParams(paramsJson);
        if (!StringUtils.isNullOrEmpty(sql)) {
            mAlarmList = baseDao.getJdbcTemplate().query(sql, new AlarmRowMapper());
        }
        return JSON.toJSONString(mAlarmList);
    }

    /**
     * 初始化获取历史数据SQL语句
     *
     * @param paramsJson
     * @return sql
     */
    private String initBatteryPackSQLByParams(String paramsJson)
    {
        String sql = "SELECT * FROM t_bpm_battery_pack tbbp " +
            "LEFT JOIN t_bpm_battery_pack_sf_extension tbbpe " +
            "ON tbbp.id = tbbpe.battery_pack_id " +
            "LEFT JOIN t_bpm_circuit tbc " +
            "ON tbbp.id=tbc.battery_pack_id AND tbc.status = 0 " +
            "WHERE 1 = 1 ";
        if (!StringUtils.isNullOrEmpty(paramsJson)) {
            Map paramMap = JSON.parseObject(paramsJson, Map.class);
            if (paramMap != null && paramMap.size() > 0) {
                Object oAreaIds = paramMap.get("areaIds");
                if (oAreaIds != null) {
                    sql += " AND tbc.parent_id IN (" + oAreaIds + ")";
                }

                Object oBatteryPackIds = paramMap.get("batteryPackIds");
                if (oBatteryPackIds != null) {
                    sql += " AND tbbp.id IN (" + oBatteryPackIds + ")";
                }
            }
        }
        return sql;
    }

    /**
     * 初始化获取历史单体告警数据SQL语句
     *
     * @param paramsJson
     * @return sql
     */
    private String initAlarmSQLByParams(String paramsJson)
    {
        if (!StringUtils.isNullOrEmpty(paramsJson)) {
            String sql = "SELECT\n" +
                "\ttba.source_id AS id,\n" +
                "\ttba.alarm_id,\n" +
                "\ttba.alarm_message,\n" +
                "\ttba.area_name,\n" +
                "\ttba.end_time,\n" +
                "\ttba.start_time,\n" +
                "\ttba.source_id,\n" +
                "\ttba.`level`,\n" +
                "\ttba.maintain_advise,\n" +
                "\ttba.manual_operationed\n" +
                "FROM\n" +
                "\tt_bpm_alarm tba,\n" +
                "\tt_bpm_alarm_config tbac\n" +
                "WHERE\n" +
                "\ttba.alarm_id = tbac.id\n";
            Map paramMap = JSON.parseObject(paramsJson, Map.class);
            if (paramMap != null && paramMap.size() > 0) {
                Object oBatteryPackId = paramMap.get("batteryPackId");
                if (oBatteryPackId != null) {
                    sql += "  AND tba.battery_pack_id = " + oBatteryPackId;
                }

                Object oStartDate = paramMap.get("startDate");
                if (oStartDate != null) {
                    sql += " AND DATE_FORMAT(tba.start_time,'%Y-%m-%d') >= '" + oStartDate + "'";
                }

                Object oEndDate = paramMap.get("endDate");
                if (oEndDate != null) {
                    sql += " AND DATE_FORMAT(tba.end_time,'%Y-%m-%d') <= '" + oEndDate + "'";
                }

//                return sql + " GROUP BY tba.end_time";
                return sql;
            }
            return null;

        }
        else {
            return null;
        }
    }
}