package com.furongsoft.Public.Services;

import com.alibaba.fastjson.JSON;
import com.furongsoft.Public.Model.MAlarm;
import com.furongsoft.Public.Model.PaginationResultByEuiGrid;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.DB;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Record;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Table;
import com.furongsoft.XspWeb.Utils.CellStyle;
import com.furongsoft.XspWeb.Utils.ExcelCell;
import com.furongsoft.XspWeb.Utils.LExportExcel;
import com.furongsoft.XspWeb.Utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/10/21.
 */
@Service
public class StatisticalService {
    @Autowired
    @Qualifier("BaseDao_system")
    public BaseDao baseDao;

    @Autowired
    public HistoricalService historicalService;

    /**
     * 获取电池组历史数据
     *
     * @return Excel
     */
    public String getBatteryPackHisReport(int page, int rows, String paramsJson) {
        List<Map<String, Object>> data = getHistoricalDataMap(paramsJson);
        List<Map<String, Object>> pageData = new ArrayList<>();
        if (data.size() > 0) {
            if (data.size() > (rows * page)) {
                pageData = data.subList((page - 1) * rows, rows * page);
            }
            else {
                pageData = data.subList((page - 1) * rows, data.size());
            }
        }
        return JSON.toJSONString(new PaginationResultByEuiGrid(data.size(), pageData));
    }

    /**
     * 获取电池组历史数据
     *
     * @param
     * @param
     * @return List<T>
     */
    private List<Map<String, Object>> getHistoricalDataMap(String paramsJson) {
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        System.out.println("开始 - " + sf.format(new Date()));
        Map paramsMap = JSON.parseObject(paramsJson, Map.class);
        Long id = Long.parseLong(paramsMap.get("id").toString());
        String startDate = paramsMap.get("startDate").toString();
        String endDate = paramsMap.get("endDate").toString();
        Boolean isV = Boolean.parseBoolean(paramsMap.get("isV").toString());
        Boolean isT = Boolean.parseBoolean(paramsMap.get("isT").toString());
        Boolean isR = Boolean.parseBoolean(paramsMap.get("isR").toString());

        String batteryDateTableName = "t_bpm_battery_data" + id;
        String batteryPackDateTableName = "t_bpm_battery_pack_data" + id;

        SqlRowSet batteryPackDatas = null;
        SqlRowSet batteryDatas = null;

        batteryPackDatas = getRecordToHisData(batteryPackDateTableName, startDate, endDate);
        batteryDatas = getRecordToHisData(batteryDateTableName, startDate, endDate);

        System.out.println("查询电池组数据和单体数据结束- " + sf.format(new Date()));
        List<Map<String, Object>> dataSourceMaps = new ArrayList<>();
        List<Record> records = baseDao.getDb().active("t_bpm_battery").where("battery_pack_id = ?", id);
        Integer batteryCount = records != null ? records.size() : 0;

        System.out.println("查询单体编号结束- " + sf.format(new Date()));
        while (batteryPackDatas.next()) {
            Map<String, Object> map = new HashMap<>();

            map.put("datetime", batteryPackDatas.getDate("time"));
            double current = batteryPackDatas.getDouble("current");
            if (current > 5)
                map.put("mode", "充电"); // 电流大于浮充上限值(浮充上限值暂定为5A)
            else if (current < -5)
                map.put("mode", "放电");// 电流大于浮充下限值(浮充上限值暂定为-5A)
            else if (current == 0)
                map.put("mode", "非充非放");// 电流等于0A
            else
                map.put("mode", "浮充");// 电流在浮充上限值（5A）和下限值(-5A)之间且不等于0A
            map.put("group_current", batteryPackDatas.getDouble("current") == 0 ? 0.0 : df.format(batteryPackDatas.getDouble("current")));
            map.put("group_temperature",batteryPackDatas.getDouble("environment_temperature") == 0 ? 0.0 : df.format(batteryPackDatas.getDouble("environment_temperature")));
            map.put("group_voltage",batteryPackDatas.getDouble("voltage") == 0 ? 0.0 : df.format(batteryPackDatas.getDouble("voltage")));
            for (int i = 0; i < batteryCount; i++) {
                if (isV) {
                    map.put("voltage" + records.get(i).get("id"), 0.0);
                }

                if (isT) {
                    map.put("temperature" + records.get(i).get("id"), 0.0);
                }

                if (isR) {
                    map.put("resistance" + records.get(i).get("id"), 0.0);
                }
            }
            dataSourceMaps.add(map);
        }

        System.out.println("电池组数据处理结束- " + sf.format(new Date()));
        while (batteryDatas.next()) {
            for (Map<String, Object> map : dataSourceMaps) {
                if (map.get("datetime").equals(batteryDatas.getDate("time"))) {
                    Long batteryId = batteryDatas.getLong("battery_id");
                    if (isV) {
                        map.put("voltage" + batteryId, batteryDatas.getDouble("voltage") == 0 ? 0.0 :df.format(batteryDatas.getDouble("voltage")));
                    }

                    if (isT) {
                        map.put("temperature" + batteryId, batteryDatas.getDouble("temperature")== 0 ? 0.0 :df.format(batteryDatas.getDouble("temperature")));
                    }

                    if (isR) {
                        map.put("resistance" + batteryId, batteryDatas.getDouble("resistance")== 0 ? 0.0 :df.format(batteryDatas.getDouble("resistance")));
                    }
                    break;
                }
            }
        }

        System.out.println("单体数据处理结束- " + sf.format(new Date()));
        return dataSourceMaps;
    }

    private SqlRowSet getRecordToHisData(String tableName, String startDate, String endDate) {
        String dateTimeWhere = "";
        if (!StringUtils.isNullOrEmpty(startDate) && !StringUtils.isNullOrEmpty(endDate)) {
            if (startDate.equals(endDate)) {
                dateTimeWhere = " WHERE DATE_FORMAT(time,'%Y-%m-%d') =  '" + startDate + "' ";
            }else{
                if (!StringUtils.isNullOrEmpty(startDate)) {
                    dateTimeWhere = " WHERE DATE_FORMAT(time,'%Y-%m-%d') >= '" + startDate + "'";
                }

                if (!StringUtils.isNullOrEmpty(endDate)) {
                    if (StringUtils.isNullOrEmpty(dateTimeWhere)) {
                        dateTimeWhere = " WHERE DATE_FORMAT(time,'%Y-%m-%d') <= '" + endDate + "'";
                    }
                    else {
                        dateTimeWhere += " AND DATE_FORMAT(time,'%Y-%m-%d') <= '" + endDate + "'";
                    }
                }
            }
        }
        else {
            if (!StringUtils.isNullOrEmpty(startDate)) {
                dateTimeWhere = " WHERE DATE_FORMAT(time,'%Y-%m-%d') >= '" + startDate + "'";
            }

            if (!StringUtils.isNullOrEmpty(endDate)) {
                if (StringUtils.isNullOrEmpty(dateTimeWhere)) {
                    dateTimeWhere = " WHERE DATE_FORMAT(time,'%Y-%m-%d') <= '" + endDate + "'";
                }
                else {
                    dateTimeWhere += " AND DATE_FORMAT(time,'%Y-%m-%d') <= '" + endDate + "'";
                }
            }
        }

        String sql = "SELECT * FROM " + tableName + dateTimeWhere;
        return baseDao.getJdbcTemplate().queryForRowSet(sql);
    }

    // 获取电池Id Json根据电池组Id
    public String getBatteryByBatteryPackId(Long id) {
        try {
            String sql = "SELECT * FROM t_bpm_battery tbb,t_bpm_battery_sf_extension tbbse " +
                    "WHERE tbb.id=tbbse.battery_id AND tbb.battery_pack_id =?";
            List<Map<String, Object>> maps = baseDao.getJdbcTemplate().query(sql, new Object[] { id },
                    new RowMapper<Map<String, Object>>() {
                        @Override
                        public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Map<String, Object> map = new HashMap<String, Object>();
                            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                String columnName = rs.getMetaData().getColumnLabel(i);
                                map.put(columnName, rs.getString(columnName));
                            }
                            return map;
                        }
                    });
            if (maps != null) {
                String rec = JSON.toJSONString(maps);
                return rec;
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return null;
    }

    /**
     * 下载电池组历史数据
     *
     * @return Excel
     */
    public void downloadBatteryPackHisReport(String paramsJson, String dataColumnJson, HttpServletResponse response) {
        try {
            List<Map<String, Object>> dataColumnMaps = JSON.parseObject(dataColumnJson, ArrayList.class);
            List<Map<String, Object>> dataSourceMaps = getHistoricalDataMap(paramsJson);
            SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<ExcelCell[]> dataList = new ArrayList<ExcelCell[]>();
            if (dataColumnMaps != null && dataColumnMaps.size() > 0) {
                int columnCount = dataColumnMaps.size();
                if ((columnCount - 5) <= 250) {
                    ExcelCell[] excelCells = new ExcelCell[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        Object title = dataColumnMaps.get(i).get("title");
                        String columnName = title != null ? title.toString() : "";
                        if (!StringUtils.isNullOrEmpty(columnName)) {
                            ExcelCell excelCell = new ExcelCell(columnName);
                            excelCells[i] = excelCell;
                        }
                    }
                    dataList.add(excelCells);

                    if (dataSourceMaps != null && dataSourceMaps.size() > 0) {
                        for (Map<String, Object> map : dataSourceMaps) {
                            excelCells = new ExcelCell[columnCount];
                            for (int i = 0; i < columnCount; i++) {
                                Object field = dataColumnMaps.get(i).get("field");
                                String key = field != null ? field.toString() : "";
                                if (!StringUtils.isNullOrEmpty(key)) {
                                    if(key.equals("datetime")){
                                        ExcelCell excelCell = new ExcelCell();
                                        excelCell.setText(ss.format(map.get(key)));
                                        excelCells[i] = excelCell;
                                    }else{
                                        ExcelCell excelCell = new ExcelCell();
                                        excelCell.setText(map.get(key));
                                        excelCells[i] = excelCell;
                                    }
                                }
                            }
                            dataList.add(excelCells);
                        }
                    }
                }
                else {
                    int columnNum = ((columnCount - 5) % 250 == 0) ? ((columnCount - 5) / 250) : ((columnCount - 5) / 250 + 1);
                    for (int t_index = 0; t_index < columnNum; t_index++) {
                        ExcelCell[] excelCells = new ExcelCell[255];
                        int i = 0;
                        if (t_index == 0) {
                            for (; i < 5; i++) {
                                Object title = dataColumnMaps.get(i).get("title");
                                String columnName = title != null ? title.toString() : "";
                                if (!StringUtils.isNullOrEmpty(columnName)) {
                                    ExcelCell excelCell = new ExcelCell(columnName);
                                    excelCells[i] = excelCell;
                                }
                            }
                        }

                        for (int x = t_index * 250 + 5; x < (t_index + 1) * 250 + 5; x++, i++) {
                            Object title = dataColumnMaps.get(x).get("title");
                            String columnName = title != null ? title.toString() : "";
                            if (!StringUtils.isNullOrEmpty(columnName)) {
                                ExcelCell excelCell = new ExcelCell(columnName);
                                excelCells[i] = excelCell;
                            }
                        }
                        dataList.add(excelCells);

                        if ((dataSourceMaps != null) && (dataSourceMaps.size() > 0)) {
                            for (Map<String, Object> map : dataSourceMaps) {
                                excelCells = new ExcelCell[255];
                                i = 0;
                                if (t_index == 0) {
                                    for (; i < 5; i++) {
                                        Object field = dataColumnMaps.get(i).get("field");
                                        String key = field != null ? field.toString() : "";
                                        if (!StringUtils.isNullOrEmpty(key)) {
                                            ExcelCell excelCell = new ExcelCell();
                                            excelCell.setText(map.get(key));
                                            excelCells[i] = excelCell;
                                        }
                                    }
                                }

                                for (int x = t_index * 250 + 5; x < (t_index + 1) * 250 + 5; x++, i++) {
                                    Object field = dataColumnMaps.get(x).get("field");
                                    String key = field != null ? field.toString() : "";
                                    if (!StringUtils.isNullOrEmpty(key)) {
                                        ExcelCell excelCell = new ExcelCell();
                                        excelCell.setText(map.get(key));
                                        excelCells[i] = excelCell;
                                    }
                                }
                                dataList.add(excelCells);
                            }
                        }
                    }
                }

            }

            LExportExcel lExportExcel = new LExportExcel(dataList);
            lExportExcel.export(response);
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    /**
     * 获取电池组月报
     *
     * @param paramsJson
     * @return Excel
     */
    public String getBatteryPackMonthReport(String paramsJson) {
        Map<String, Object> map = getDataSourceMap(paramsJson);
        return JSON.toJSONString(map);
    }

    /**
     * 下载电池组月报
     *
     * @param dateSourceJson
     * @return Excel
     */
    public Boolean downloadBatteryPackMonthReport(String dateSourceJson, HttpServletResponse response) {
        try {

            // 数据源
            Map dateSourceMap = JSON.parseObject(dateSourceJson, Map.class);

            // 封装数据源
            List<ExcelCell[]> dataList = new ArrayList<ExcelCell[]>();
            ExcelCell[] excelCells;

            for (int y = 0; y < 20; y++) {
                excelCells = new ExcelCell[2];
                for (int x = 0; x < 2; x++) {
                    ExcelCell excelCell = initMonthlyReportCells(x, y, dateSourceMap);
                    excelCells[x] = excelCell;
                }
                dataList.add(excelCells);
            }

            CellStyle cellStyle = new CellStyle();
            cellStyle.setFontBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            if (dataList.size() > 1) {
                dataList.get(1)[0].setCellStyle(cellStyle);
            }
            LExportExcel lExportExcel = new LExportExcel(dataList);
            lExportExcel.export(response);
            return true;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    /**
     * 下载电池组历史告警
     *
     * @param dateSourceJson
     * @return Excel
     */
    public void downloadHisAlarmReport(String paramsJson, String dateSourceJson, HttpServletResponse response) {
        try {
            String[] names = { "Id", "AreaName", "StrarTime", "AlarmId", "AlarmMessage" };
            String[] nameStrs = { "电池组编号", "告警位置", "告警时间", "告警编号", "告警信息", "目前状态" };
            if (!StringUtils.isNullOrEmpty(dateSourceJson)) {
                int len = dateSourceJson.length();
                String flag = dateSourceJson.substring(len - 1, len);
                if (!flag.equals("]")) {
                    dateSourceJson = historicalService.getDateSourceJson(paramsJson);
                }
            }

            List<Map> dateSourceMaps = JSON.parseObject(dateSourceJson, ArrayList.class);
            List<ExcelCell[]> dataList = new ArrayList<ExcelCell[]>();
            ExcelCell[] excelCells = new ExcelCell[nameStrs.length];
            for (int i = 0; i < nameStrs.length; i++) {
                ExcelCell excelCell = new ExcelCell(nameStrs[i]);
                excelCells[i] = excelCell;
            }
            dataList.add(excelCells);

            for (int i = 0; i < dateSourceMaps.size(); i++) {
                Map map = dateSourceMaps.get(i);
                excelCells = new ExcelCell[nameStrs.length];
                for (int j = 0; j < names.length; j++) {
                    ExcelCell excelCell = new ExcelCell(map.get(names[j]));
                    excelCells[j] = excelCell;
                }
                ExcelCell excelCell = new ExcelCell();
                if (map.get("EndTime") != null && map.get("EndTime").toString() != "") {
                    excelCell.setText("已消除");
                }
                else {
                    excelCell.setText("未消除");
                }
                excelCells[names.length] = excelCell;
                dataList.add(excelCells);
            }


            CellStyle cellStyle = new CellStyle();
            cellStyle.setFontBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            if (dataList.size() > 1) {
                dataList.get(1)[0].setCellStyle(cellStyle);
            }
            LExportExcel lExportExcel = new LExportExcel(dataList);
            lExportExcel.export(response);
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    // 设置获取数据源
    private Map getDataSourceMap(String paramsJson) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> paramsMap = JSON.parseObject(paramsJson, Map.class);
        String StartDate =  paramsMap.get("startDate").toString();
        if (paramsMap != null && paramsMap.size() > 0) {
            String tableName = "t_bpm_battery_pack_data" + paramsMap.get("id");
            DB db = baseDao.getDb();
            Table table = db.active(tableName);

            // 电池组总放数据源
            List<Record> recordList0 = table.where("current < ?", -0.5);

            // 电池组本月放数据源
            List<Record> recordList1 = table.where("current < ? AND time >= ? " +
                            "AND time <= ?", -0.5, paramsMap.get("startDate"),
                    paramsMap.get("endDate"));

            // 电池组总投入运行数据源
            List<Record> records = table.all();
            // 电池组本月放数据源
            List<Record> recordList2 = table.where(" time >= ? " +
                            "AND time <= ?",  paramsMap.get("startDate"),
                    paramsMap.get("endDate"));
            // 总放电次数
            int disCCount = 0;
            boolean flag = false;
            for (Record record : records) {
                Double current = 0.0;
                if(record.get("current") !=null){
                     current =  record.getDouble("current");
                }
                if(current < 0 ){
                    flag = true;
                    continue;
                }else{
                    if(flag){
                        disCCount ++;
                        flag =false;
                    }
                }
            }

            // 本月总放电次数
            int disCCountByMonth = 0;
            flag = false;
            for (Record record : recordList2) {
                Double current = 0.0;
                if(record.get("current") !=null){
                    current =  record.getDouble("current");
                }
                if(current < 0 ){
                    flag = true;
                    continue;
                }else{
                    if(flag){
                        disCCountByMonth ++;
                        flag =false;
                    }
                }
            }

            /* 电池组运行情况 */
            // 电池组总放电次数
            map.put("disCCount", disCCount);

            // 电池组总放电时间
            Double disCTotalTime = recordList0.size() / 60D;
            map.put("disCTotalTime", keepTwoDecimal(disCTotalTime));

            // 电池组累计总放电容量
            Double disCurrentCount = 0D;
            for (Record record : recordList0) {
                Object oVal = record.get("current");
                Double dVal = oVal != null ? Double.parseDouble(oVal.toString()) : 0D;
                disCurrentCount += dVal;
            }
            Double disCTotalAh = disCurrentCount / 60D;
            map.put("disCTotalAh", keepTwoDecimal(disCTotalAh));

            // 电池组总投入运行时间
            Double runTotalTime = records.size() / 60D;
            map.put("runTotalTime", keepTwoDecimal(runTotalTime));

            // 本月电池组放电次数
            map.put("disCCountByMonth", disCCountByMonth);

            // 本月电池组放电时间
            Double disCTotalTimeByMonth = recordList1.size() / 60D;
            map.put("disCTotalTimeByMonth", keepTwoDecimal(disCTotalTimeByMonth));

            // 本月电池组累计放电容量
            Double disCurrentCountByMonth = 0D;
            for (Record record : recordList1) {
                Object oVal = record.get("current");
                Double dVal = oVal != null ? Double.parseDouble(oVal.toString()) : 0D;
                disCurrentCountByMonth += dVal;
            }
            Double disCTotalAhByMonth = disCurrentCountByMonth / 60D;
            map.put("disCTotalAhByMonth", keepTwoDecimal(disCTotalAhByMonth));

            // 告警总记录
            Table table1 = db.active("t_bpm_alarm");
            List<Record> alarmList = table1.where("  battery_pack_id = ?",paramsMap.get("id"));
            int level1AlarmCount = 0; // 电池组累计总一级告警次数
            int level2AlarmCount = 0; // 电池组累计总二级告警次数
            int level3AlarmCount = 0; // 电池组累计总三级告警次数
            int disLevel1AlarmCount = 0; // 已处理一级告警次数
            int disLevel2AlarmCount = 0; // 已处理二级告警次数
            int disLevel3AlarmCount = 0; // 已处理三级告警次数
            for (Record record : alarmList) {
                int level = record.getInt("level");
                if(level == 1){ // 一级告警
                    level1AlarmCount++;
                    Date s = record.get("end_time");
                    if(record.get("end_time") != null){ // 已做处理
                        disLevel1AlarmCount++;
                    }
                }else if(level == 2){ // 二级告警
                    level2AlarmCount++;
                    if(record.get("end_time") != null){ // 已做处理
                        disLevel2AlarmCount++;
                    }
                }else{ // 三级告警
                    level3AlarmCount++;
                    if(record.get("end_time") != null){ // 已做处理
                        disLevel3AlarmCount++;
                    }
                }
            }

            // 本月告警记录
            List<Record> alarmListByMonth =  table1.where("  battery_pack_id = ? AND start_time >= ? AND start_time <= ?",
                    paramsMap.get("id"),paramsMap.get("startDate"),paramsMap.get("endDate"));
            int level1AlarmCountByMonth = 0; // 电池组本月累计一级告警次数
            int level2AlarmCountByMonth = 0; // 电池组本月累计二级告警次数
            int level3AlarmCountByMonth = 0; // 电池组本月累计三级告警次数
            int disLevel1AlarmCountByMonth = 0; // 本月已处理一级告警次数
            int disLevel2AlarmCountByMonth = 0; // 本月已处理二级告警次数
            int disLevel3AlarmCountByMonth = 0; // 本月已处理三级告警次数
            for (Record record : alarmListByMonth) {
                int level = record.getInt("level");
                if(level == 1){
                    level1AlarmCountByMonth++;
                    if(record.get("end_time") != null){
                        disLevel1AlarmCountByMonth++;
                    }
                }else if(level == 2){
                    level2AlarmCountByMonth++;
                    if(record.get("end_time") != null){
                        disLevel2AlarmCountByMonth++;
                    }
                }else{
                    level3AlarmCountByMonth++;
                    if(record.get("end_time") != null){
                        disLevel3AlarmCountByMonth++;
                    }
                }
            }
            /*电池组告警及处理*/
            // 电池组累计总一级告警次数
            map.put("level1AlarmCount", level1AlarmCount);
            // 已经处理次数
            map.put("disLevel1AlarmCount", disLevel1AlarmCount);

            // 电池组累计总二级告警次数
            map.put("level2AlarmCount", level2AlarmCount);
            // 已经处理次数
            map.put("disLevel2AlarmCount", disLevel2AlarmCount);

            // 电池组累计总三级告警次数
            map.put("level3AlarmCount", level3AlarmCount);
            // 已经处理次数
            map.put("disLevel3AlarmCount", disLevel3AlarmCount);

            // 本月电池组累计一级告警次数
            map.put("level1AlarmCountByMonth", level1AlarmCountByMonth);
            // 已经处理次数
            map.put("disLevel1AlarmCountByMonth", disLevel1AlarmCountByMonth);

            // 本月电池组累计二级告警次数
            map.put("level2AlarmCountByMonth", level2AlarmCountByMonth);
            // 已经处理次数
            map.put("disLevel2AlarmCountByMonth", disLevel2AlarmCountByMonth);

            // 本月电池组累计三级告警次数
            map.put("level3AlarmCountByMonth", level3AlarmCountByMonth);
            // 已经处理次数
            map.put("disLevel3AlarmCountByMonth", disLevel3AlarmCountByMonth);

            /*电池组目前状态及建议*/
            // 状态
            Double monthCount = runTotalTime / 24 / 30;
            String stateMessage = String.format("电池已经投入运行%s个月", keepTwoDecimal(monthCount));
            map.put("state", stateMessage);
            // 建议
            map.put("proposal", "电池组还剩余0条告警未处理，建议尽快评估和处理");
        }


        return map;
    }

    private String keepTwoDecimal(Object val) {
        return String.format("%.2f", val);
    }

    // 设置月报单元格数据
    private ExcelCell initMonthlyReportCells(int x, int y, Map dateSourceMap) {
        ExcelCell excelCell = new ExcelCell();
        if (y == 0 && x == 0) {
            excelCell.setText(dateSourceMap.get("name")
                    + "电池组" + dateSourceMap.get("year")
                    + "年" + dateSourceMap.get("month") + "月报告");
            excelCell.setX(x);
            excelCell.setLx(x + 1);
            excelCell.setY(y);
            excelCell.setLy(y + 1);
        }
        else if (y == 2 && x == 0) {
            excelCell.setText("电池组运行情况：");
        }
        else if (y == 10 && x == 0) {
            excelCell.setText("电池组告警及处理：");
        }
        else if (y == 17 && x == 0) {
            excelCell.setText("电池组目前状态及建议：");
        }
        else if (y == 3 && x == 1) {
            excelCell.setText("电池组总放电次数：" + dateSourceMap.get("disCCount") + "次");
        }
        else if (y == 4 && x == 1) {
            excelCell.setText("电池组总放电时间：" + dateSourceMap.get("disCTotalTime") + "小时");
        }
        else if (y == 5 && x == 1) {
            excelCell.setText("电池组累计总放电容量：" + dateSourceMap.get("disCTotalAh") + "Ah");
        }
        else if (y == 6 && x == 1) {
            excelCell.setText("电池组总投入运行时间：" + dateSourceMap.get("runTotalTime") + "小时");
        }
        else if (y == 7 && x == 1) {
            excelCell.setText("本月电池组放电次数：" + dateSourceMap.get("disCCountByMonth") + "次");
        }
        else if (y == 8 && x == 1) {
            excelCell.setText("本月电池组放电时间：" + dateSourceMap.get("disCTotalTimeByMonth") + "小时");
        }
        else if (y == 9 && x == 1) {
            excelCell.setText("本月电池组累计放电容量：" + dateSourceMap.get("disCTotalAhByMonth") + "Ah");
        }
        else if (y == 11 && x == 1) {
            excelCell.setText("电池组累计总一级告警次数：" +
                    dateSourceMap.get("level1AlarmCount") + "次  ，已经处理次数：" +
                    dateSourceMap.get("disLevel1AlarmCount") + "次。");
        }
        else if (y == 12 && x == 1) {
            excelCell.setText("电池组累计总二级告警次数：" +
                    dateSourceMap.get("level2AlarmCount") + "次，已经处理次数： " +
                    dateSourceMap.get("disLevel2AlarmCount") + "次。");
        }
        else if (y == 13 && x == 1) {
            excelCell.setText("电池组累计总三级告警次数：" +
                    dateSourceMap.get("level3AlarmCount") + "次，已经处理次数： " +
                    dateSourceMap.get("disLevel3AlarmCount") + "次。");
        }
        else if (y == 14 && x == 1) {
            excelCell.setText("本月电池组累计一级告警次数：" +
                    dateSourceMap.get("level1AlarmCountByMonth") + " 次，已经处理次数：" +
                    dateSourceMap.get("disLevel1AlarmCountByMonth") + "次。");
        }
        else if (y == 15 && x == 1) {
            excelCell.setText("本月电池组累计二级告警次数：" +
                    dateSourceMap.get("level2AlarmCountByMonth") + " 次，已经处理次数：" +
                    dateSourceMap.get("disLevel2AlarmCountByMonth") + "次。");
        }
        else if (y == 16 && x == 1) {
            excelCell.setText("本月电池组累计三级告警次数：" +
                    dateSourceMap.get("level3AlarmCountByMonth") + " 次，已经处理次数：" +
                    dateSourceMap.get("disLevel3AlarmCountByMonth") + "次。");
        }
        else if (y == 18 && x == 1) {
            excelCell.setText(dateSourceMap.get("state"));
        }
        else if (y == 19 && x == 1) {
            excelCell.setText(dateSourceMap.get("proposal"));
        }
        else {
            excelCell.setText("");
        }

        return excelCell;
    }
}