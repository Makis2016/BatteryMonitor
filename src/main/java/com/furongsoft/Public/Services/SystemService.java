package com.furongsoft.Public.Services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.furongsoft.Public.CallServices.CallService;
import com.furongsoft.Public.Dao.Entities.BatteryPack;
import com.furongsoft.Public.Dao.Entities.Device;
import com.furongsoft.Public.Dao.Entities.SimpleDateForzTree;
import com.furongsoft.Public.Dao.Entities.User;
import com.furongsoft.Public.Dao.RowMapper.*;
import com.furongsoft.Public.Model.*;
import com.furongsoft.Public.Utils.Constant;
import com.furongsoft.Public.Utils.Misc;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import com.furongsoft.XspWeb.Security.Services.SecurityService;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.DB;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Record;
import com.furongsoft.XspWeb.Utils.StringUtils;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryPackThreshold;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryThreshold;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.ArrayOfBattery;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPackBatterySpecification;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.CircuitInfo;
import org.datacontract.schemas._2004._07.bpmservice.DataAccuracyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.*;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by LYD on 2016/10/6.
 */
@Service
public class SystemService {
    @Autowired
    public OperationLogSevcie operationLogSevcie;
    @Autowired
    @Qualifier("BaseDao_system")
    public BaseDao baseDao;
    @Autowired
    public SecurityService securityService;

    // 获取当前会话用户ID--用户设置
    public Long getUserId(ModelMap model) {
        Subject currentUser = (Subject) model.get("user");
        if (currentUser == null) {
            return null;
        }
        User user = (User) currentUser.getSession().getAttribute("userModel");
        return user.getId();
    }

    // 获取当前会话用户信息--个人信息管理
    public String getUserJson(ModelMap model) {
        Subject currentUser = (Subject) model.get("user");
        if (currentUser == null) {
            return null;
        }
        User user = securityService.getUser(currentUser.getPrincipal().toString());
        String userJson = JSON.toJSONString(user);
        return userJson;
    }

    // 获取电池组的单体信息--电池组管理
    public String getBatteriesJson(String json) {
        List<Battery> batteries = null;
        try {
            BatteryPack batteryPack = JSON.parseObject(json, BatteryPack.class);
            if (batteryPack != null) {
                batteries = baseDao.getJdbcTemplate()
                        .query("SELECT * FROM t_bpm_battery tbb,t_bpm_battery_sf_extension tbbse " +
                                        "WHERE tbb.id=tbbse.battery_id AND battery_pack_id = ? "
                                , new BatteryRowMapper(), batteryPack.getId());
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }

        return JSON.toJSONString(batteries);
    }

    /* 个人信息管理 */
    // 个人信息管理 - 改
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String editPersonInfo(String json) {
        Long operationId = operationLogSevcie.insertOperation("editPersonInfo", null);
        com.furongsoft.Public.Dao.Entities.User user = JSON
                .parseObject(json, com.furongsoft.Public.Dao.Entities.User.class);
        try {
            DB db = baseDao.getDb();
            Record record = db.active("t_sys_user").find(user.getId())
                    .set("name", user.getName())
                    .set("sex", user.getSex())
                    .set("affiliated_institutions", user.getAffiliated_institutions())
                    .set("point1_id", user.getPoint1_id())
                    .set("point2_id", user.getPoint2_id())
                    .set("point3_id", user.getPoint3_id())
                    .set("email", user.getEmail())
                    .set("tel_no", user.getTel_no())
                    .save();

            user.setId(record.getLong("id"));
            user.setName(record.getStr("name"));
            user.setSex(record.getInt("sex"));
            user.setPoint1_id(record.getLong("point1_id"));
            user.setPoint2_id(record.getLong("point2_id"));
            user.setPoint3_id(record.getLong("point3_id"));
            user.setEmail(record.getStr("email"));
            user.setTel_no(record.getStr("tel_no"));
            user.setAffiliated_institutions(record.getStr("affiliated_institutions"));

            operationLogSevcie.updateOperationResult(operationId);
            return Misc.convertAResultJson(Constant.updateSuccess, 0, user);
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.updateError, -1, null);
        }
    }

    // 个人信息管理 - 改密码
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String editPassword(String oldPass, String newPass, String json) {
        Long operationId = operationLogSevcie.insertOperation("editPassword", null);
        try {
            User user = JSON.parseObject(json, User.class);
            if (!user.getPassword().equals(Misc.generatePassword(user.getLogin_id(), oldPass))) {
                return Misc.convertAResultJson(Constant.updateError + "，原密码错误！", -1, null);
            }
            DB db = baseDao.getDb();
            db.active("t_sys_user").find(user.getId())
                    .set("password", Misc.generatePassword(user.getLogin_id(), newPass))
                    .save();

            operationLogSevcie.updateOperationResult(operationId);
            return Misc.convertAResultJson(Constant.updateSuccess, 0, null);
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.updateError, -1, null);
        }
    }

    /* 设备管理 */
    // 设备管理-增
    public String addDevice(String name, String type, String config) {
        Long operationId = operationLogSevcie.insertOperation("addDevice", null);
        try {
            if (CallService.AddDevice(name, type, config)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.addSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson(Constant.addError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    // 设备管理-删
    public String deleteDevice(Long id) {
        Long operationId = operationLogSevcie.insertOperation("deleteDevice", null);
        try {
            if (CallService.RemoveDevice(id)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.deleteSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson(Constant.deleteError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(Constant.operationError);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    // 设备管理-改
    public String updateDevice(Long id, String config) {
        Long operationId = operationLogSevcie.insertOperation("updateDevice", null);
        try {
            if (CallService.UpdateDevice(id, config)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.updateSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson(Constant.updateError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    // 设备管理-查
    @Transactional(propagation = Propagation.REQUIRED)
    public String getALLDevices(int page, int rows) {
        try {
            DB db = baseDao.getDb();
            List<Device> devices = db.active("t_bpm_device").where(
                    new DeviceRowMapper(), "status=?", 0);
            List<Device> deviceList = new ArrayList<>();
            if (devices != null && devices.size() > 0) {
                int startIndex = (page - 1) * rows;
                int endIndex = page * rows;
                if (devices.size() < endIndex) {
                    endIndex = devices.size();
                }
                for (int i = startIndex; i < endIndex; i++) {
                    deviceList.add(devices.get(i));
                }
                return JSON.toJSONString(
                        new PaginationResultByEuiGrid(devices.size(), deviceList));
            }

        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return "";
    }

    /* 电池组管理 */
    // 电池组管理 - 增
    @Transactional(propagation = Propagation.REQUIRED)
    public String addGridBatteryPack(String arrBatteryJson, String batteryPackParamsJson) {
        Long operationId = operationLogSevcie.insertOperation("addGridBatteryPack", null);
        try {
            org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPack batteryPack
                    = initBatteryPack(batteryPackParamsJson, arrBatteryJson);

            // 添加电池组
            if (CallService.AddBatteryPack(batteryPack)) {
                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.addSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson("未调用到接口," + Constant.addError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson("调用接口出错," + Constant.operationError, -1, null);
        }
    }

    // 电池组管理 - 删
    public String deleteBatteryPack(Long id) {
        Long operationId = operationLogSevcie.insertOperation("deleteBatteryPack", null);
        try {
            if (CallService.RemoveBatteryPack(id)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.deleteSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson(Constant.deleteError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    // 电池组管理 - 改
    @Transactional(propagation = Propagation.REQUIRED)
    public String editGridBatteryPack(String arrBatteryJson, String batteryPackParamsJson) {
        Long operationId = operationLogSevcie.insertOperation("editGridBatteryPack", null);
        try {
            org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPack batteryPack
                    = initBatteryPack(batteryPackParamsJson, arrBatteryJson);
            // 修改电池组
            if (CallService.UpdateBatteryPack(batteryPack)) {
                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.updateSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson("未调用到接口," + Constant.updateError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson("调用接口出错," + Constant.operationError, -1, null);
        }
    }

    // 电池组管理 - 查
    @Transactional(propagation = Propagation.REQUIRED)
    public String getGridBatteryPack(int page, int rows) {
        try {
            SqlRowSet srsTotal = baseDao.getJdbcTemplate()
                    .queryForRowSet("SELECt COUNT(id) AS total FROM t_bpm_battery_pack WHERE status=0 ");
            if (srsTotal.next()) {
                int total = srsTotal.getInt("total");

                List<BatteryPack> batteryList = baseDao.getJdbcTemplate()
                        .query("SELECT * FROM t_bpm_battery_pack AS tbbp," +
                                "t_bpm_battery_pack_sf_extension AS tbbpsfe " +
                                "WHERE tbbp.id = tbbpsfe.battery_pack_id " +
                                "AND tbbp.status=0 " +
                                "ORDER BY tbbp.create_time " +
                                "LIMIT " + ((page - 1) * rows) + "," + (page * rows), new DeviceBatteryPackRowMapper());
                return JSON.toJSONString(
                        new PaginationResultByEuiGrid(total, batteryList),
                        SerializerFeature.DisableCircularReferenceDetect);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return "";
    }

    /* 区域管理 */
    // 区域管理 - 增
//    public String addArea(String name, String charge_person, String email, Long pid) {
//        Long operationId = operationLogSevcie.insertOperation("addArea", null);
//        try {
//            String namespace = "http://schemas.datacontract.org/2004/07/BPMBusiness";
//            JAXBElement<String> xmlName = new JAXBElement<String>(
//                    new QName(namespace, "Name"), String.class, name);
//            JAXBElement<String> xmlChargePerson = new JAXBElement<String>(
//                    new QName(namespace, "ChargePerson"), String.class, charge_person);
//            JAXBElement<String> xmlEmail = new JAXBElement<String>(
//                    new QName(namespace, "Email"), String.class, email);
//            JAXBElement<Long> xmlPid = new JAXBElement<Long>(
//                    new QName(namespace, "ParentId"), Long.class, pid);
//
//            Area area = new Area();
//            area.setParentId(xmlPid);
//            area.setChargePerson(xmlChargePerson);
//            area.setName(xmlName);
//            area.setEmail(xmlEmail);
//            if (CallService.AddArea(area) > 0) {
//
//                operationLogSevcie.updateOperationResult(operationId);
//                return Misc.convertAResultJson(Constant.addSuccess, 0, null);
//            }
//            else {
//                return Misc.convertAResultJson(Constant.addError, -1, null);
//            }
//        }
//        catch (Exception e) {
//            Tracker.e(e);
//            return Misc.convertAResultJson(Constant.operationError, -1, null);
//        }
//    }

    // 区域管理 - 删
    public String deleteArea(Long id) {
//        Long operationId = operationLogSevcie.insertOperation("deleteArea", null);
//        try {
//            if (CallService.DeleteArea(id)) {
//
//                operationLogSevcie.updateOperationResult(operationId);
//                return Misc.convertAResultJson(Constant.deleteSuccess, 0, null);
//            }
//            else {
//                return Misc.convertAResultJson(Constant.deleteError, -1, null);
//            }
//        }
//        catch (Exception e) {
//            Tracker.e(Constant.operationError + "" + e);
//            return Misc.convertAResultJson(Constant.operationError, -1, null);
//        }
        return "";
    }

    // 区域管理 - 改
//    public String editArea(String name, String charge_person, String email, Long id, Long pid) {
//        Long operationId = operationLogSevcie.insertOperation("editArea", null);
//        try {
//            String namespace = "http://schemas.datacontract.org/2004/07/BPMBusiness";
//            JAXBElement<String> xmlName = new JAXBElement<String>(
//                    new QName(namespace, "Name"), String.class, name);
//            JAXBElement<String> xmlChargePerson = new JAXBElement<String>(
//                    new QName(namespace, "ChargePerson"), String.class, charge_person);
//            JAXBElement<String> xmlEmail = new JAXBElement<String>(
//                    new QName(namespace, "Email"), String.class, email);
//            JAXBElement<Long> xmlPid = new JAXBElement<Long>(
//                    new QName(namespace, "ParentId"), Long.class, pid);
//
//            Area area = new Area();
//            area.setId(id);
//            area.setParentId(xmlPid);
//            area.setChargePerson(xmlChargePerson);
//            area.setName(xmlName);
//            area.setEmail(xmlEmail);
//            if (CallService.UpdateArea(area)) {
//
//                operationLogSevcie.updateOperationResult(operationId);
//                return Misc.convertAResultJson(Constant.updateSuccess, 0, null);
//            }
//            else {
//                return Misc.convertAResultJson(Constant.updateError, -1, null);
//            }
//        }
//        catch (Exception e) {
//            Tracker.e(e);
//            return Misc.convertAResultJson(Constant.operationError, -1, null);
//        }
//    }

    /**
     * 回路管理 - 增
     */
    public String addCircuit(
            Long areaId,
            String groupName,
            Long batteryGroupId,
            Long deviceId,
            String dataAccuracy,
            String newAreaStr,
            Boolean isAddArea,
            String areaIdPath
            ) {
        Long operationId = operationLogSevcie.insertOperation("addCircuit", null);
        try {
            String namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel";

            DataAccuracyInfo oDataAccuracy = JSON.parseObject(dataAccuracy, DataAccuracyInfo.class);

            JAXBElement<DataAccuracyInfo> xmlDataAccuracy = new JAXBElement<DataAccuracyInfo>(
                    new QName(namespace, "DataAccuracyInfo"), DataAccuracyInfo.class, oDataAccuracy);
            JAXBElement<String> xmlName = new JAXBElement<String>(
                    new QName(namespace, "Name"), String.class, groupName);
            JAXBElement<Long> xmlDeviceId = new JAXBElement<Long>(
                    new QName(namespace, "MonitorId"), Long.class, deviceId);

            CircuitInfo circuit = new CircuitInfo();
            circuit.setName(xmlName);
//            Area area = this.getEditAreaOrAddArea(areaId, newAreaStr, isAddArea);
            circuit.setAreaId(areaId);
            circuit.setDataAccuracyInfo(xmlDataAccuracy);
            circuit.setBatteryPackId(batteryGroupId);
            circuit.setMonitorId(xmlDeviceId);
//            // 区域组合名称 demo 深圳-南山区-3级区域名称
            JAXBElement<String> xmlAreaName = new JAXBElement<String>(
                    new QName(namespace, "AreaName"), String.class,
                    getAreaNames(areaId));
            JAXBElement<String> xmlAreaIdPath = new JAXBElement<String>(
                    new QName(namespace, "AreaIdPath"), String.class,
                    areaIdPath);
            circuit.setAreaName(xmlAreaName);
            circuit.setAreaIdPath(xmlAreaIdPath);

            //User user = securityService.getUser(SecurityUtils.getSubject().getPrincipal().toString());

            if (CallService.AddCircuit(circuit, 1L)) {
                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.addSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson(Constant.addError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    /**
     * 回路管理 - 删
     */
    public String deleteCircuit(Long id) {
        Long operationId = operationLogSevcie.insertOperation("deleteCircuit", null);
        try {
            if (CallService.DeleteCircuit(id)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.deleteSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson(Constant.deleteError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    /**
     * 回路管理 - 改
     */
    public String editCircuit(
            Long id,
            Long areaId,
            String groupName,
            Long batteryGroupId,
            Long deviceId,
            String dataAccuracy,
            String newAreaStr,
            Boolean isAddArea,
            String areaIdPath) {
        Long operationId = operationLogSevcie.insertOperation("editCircuit", null);
        try {
            String namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.WebModel";

            DataAccuracyInfo oDataAccuracy = JSON.parseObject(dataAccuracy, DataAccuracyInfo.class);
            BatteryPack batteryPack = new BatteryPack();
            batteryPack.setId(batteryGroupId);

            JAXBElement<DataAccuracyInfo> xmlDataAccuracy = new JAXBElement<DataAccuracyInfo>(
                    new QName(namespace, "DataAccuracyInfo"), DataAccuracyInfo.class, oDataAccuracy);
            JAXBElement<String> xmlName = new JAXBElement<String>(
                    new QName(namespace, "Name"), String.class, groupName);
            JAXBElement<Long> xmlDeviceId = new JAXBElement<Long>(
                    new QName(namespace, "MonitorId"), Long.class, deviceId);

            CircuitInfo circuit = new CircuitInfo();
            circuit.setId(id);
            circuit.setName(xmlName);
//            Area area = this.getEditAreaOrAddArea(areaId, newAreaStr, isAddArea);
            circuit.setAreaId(areaId);
            circuit.setDataAccuracyInfo(xmlDataAccuracy);
            circuit.setBatteryPackId(batteryGroupId);
            circuit.setMonitorId(xmlDeviceId);
//            // 区域组合名称 demo 深圳-南山区-3级区域名称
            JAXBElement<String> xmlAreaName = new JAXBElement<String>(
                    new QName(namespace, "AreaName"), String.class,
                    getAreaNames(areaId));
            JAXBElement<String> xmlAreaIdPath = new JAXBElement<String>(
                    new QName(namespace, "AreaIdPath"), String.class,
                    areaIdPath);
            circuit.setAreaName(xmlAreaName);
            circuit.setAreaIdPath(xmlAreaIdPath);

            //User user = securityService.getUser(SecurityUtils.getSubject().getPrincipal().toString());
            if (CallService.UpdateCircuit(circuit,1L)) {
                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson(Constant.updateSuccess, 0, null);
            }
            else {
                return Misc.convertAResultJson(Constant.updateError, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    /**
     * 获取bcu列表-回路管理-test
     *
     * @param page       页码
     * @param rows       行数
     * @param paramsJson 参数JSON
     * @return JSONListStr
     */
    public String getBCUList(int page, int rows, String paramsJson) {
        List<MSfBCU> bcuList = new ArrayList<>();
        Map<String, Object> paramsMap = JSON.parseObject(paramsJson, Map.class);
        if ((page > 0) && (rows > 0)) {
            List<Record> batteryIdRecord = null;
            if ((paramsMap != null)
                    && (paramsMap.size() > 0)
                    && (paramsMap.containsKey("batteryPackId"))) {
                batteryIdRecord = baseDao.getDb().active("t_bpm_battery").where("battery_pack_id = ?", paramsMap.get("batteryPackId"));
            }

            if ((batteryIdRecord != null)
                    && (batteryIdRecord.size() > 0)) {

                int maxPageRows = batteryIdRecord.size();
                if (maxPageRows >= (page * rows)) {
                    maxPageRows = page * rows;
                }

                int startIndex = (page - 1) * rows;
                for (int i = startIndex; i < maxPageRows; i++) {
                    MSfBCU bcu = new MSfBCU();
                    bcu.setType((short) 1);
                    bcu.setRegisterAddress((i + 1));
                    bcu.setBattery_num((i + 1));
                    bcu.setOp("add");
                    bcu.setBattery_id(batteryIdRecord.get(i).getLong("id"));
                    bcu.setBattery_status(batteryIdRecord.get(i).getInt("status"));
                    bcu.setBattery_state(batteryIdRecord.get(i).getInt("state"));
                    bcu.setOldRegisterAddress((i + 1));
                    bcuList.add(bcu);
                }

                return JSON.toJSONString(new PaginationResultByEuiGrid(batteryIdRecord.size(), bcuList));
            }
        }
        return JSON.toJSONString(new PaginationResultByEuiGrid(bcuList.size(), bcuList));
    }

    /**
     * 获取电池组的单体参数信息-回路管理-test
     *
     * @param paramsJson 参数JSON
     * @return JSONListStr
     */
    public String getBatteriesByPackId(String paramsJson) {
        if (StringUtils.isNullOrEmpty(paramsJson)) {
            return JSON.toJSONString(new AResult("请传人参数", -1, null));
        }

        Map<String, Object> paramsMap = JSON.parseObject(paramsJson, Map.class);
        List<Battery> batteries = baseDao.getJdbcTemplate()
                .query("SELECT * FROM t_bpm_battery tbb,t_bpm_battery_sf_extension tbbse " +
                                "WHERE tbb.id=tbbse.battery_id AND tbb.battery_pack_id = ? ",
                        new BatteryRowMapper(), paramsMap.get("batteryPackId"));
        if ((batteries != null) && (batteries.size() > 0)) {
            return JSON.toJSONString(new AResult("", 0, batteries));
        }

        return JSON.toJSONString(new AResult(Constant.noneData, -1, null));
    }

    /**
     * 获取单体信息-回路管理-test
     *
     * @param id 单体ID
     * @return JSONStr
     */
    public String getBatteryById(Long id) {
        if (id == null) {
            return JSON.toJSONString(new AResult("无电池编号", -1, null));
        }

        List<Battery> batteryList = baseDao.getJdbcTemplate()
                .query("SELECT * FROM t_bpm_battery tbb,t_bpm_battery_sf_extension tbbse " +
                                "WHERE tbb.id=tbbse.battery_id AND tbb.id = ? ",
                        new BatteryRowMapper(), id);
        if ((batteryList != null) && (batteryList.size() > 0)) {
            return JSON.toJSONString(new AResult("", 0, batteryList.get(0)));
        }
        return JSON.toJSONString(new AResult(Constant.noneData, -1, null));
    }

    /**
     * 获取设备信息-回路管理-test
     *
     * @param paramsJson 参数JSON
     * @return JSONStr
     */
    public String getDeviceInfoById(String paramsJson) {
        if (StringUtils.isNullOrEmpty(paramsJson)) {
            return JSON.toJSONString(new AResult("请传人参数", -1, null));
        }

        Map<String, Object> paramsMap = JSON.parseObject(paramsJson, Map.class);
        DB db = baseDao.getDb();
        List<Device> deviceList = db.active("t_bpm_device").where(new DeviceRowMapper()
                , "id = ?", paramsMap.get("deviceId"));
        if ((deviceList != null) && (deviceList.size() > 0)) {
            return JSON.toJSONString(new AResult("", 0, deviceList.get(0)));
        }

        return JSON.toJSONString(new AResult(Constant.noneData, -1, null));
    }

    /**
     * 获取电池组参数信息-回路管理-test
     *
     * @param paramsJson 参数JSON
     * @return JSONStr
     */
    public String getBatteryPackById(String paramsJson) {
        if (StringUtils.isNullOrEmpty(paramsJson)) {
            return JSON.toJSONString(new AResult("请传人参数", -1, null));
        }

        Map<String, Object> paramsMap = JSON.parseObject(paramsJson, Map.class);
        List<BatteryPackParams> batteryPackParams = baseDao.getJdbcTemplate()
                .query("SELECT * FROM t_bpm_battery_pack tbbp," +
                                "t_bpm_battery_pack_sf_extension tbbpse " +
                                "WHERE tbbp.id = tbbpse.battery_pack_id " +
                                "AND tbbp.id = ?", new RowMapper<BatteryPackParams>() {
                            @Override
                            public BatteryPackParams mapRow(ResultSet rs, int rowNum) throws SQLException {
                                BatteryPackParams batteryPackParam = new BatteryPackParams();
                                batteryPackParam.setBatteryPack_id(rs.getLong("id"));
                                batteryPackParam.setBatteryPack_name(rs.getString("name"));
                                batteryPackParam.setCheckCycleTime(rs.getString("check_resistance_cycle"));
                                batteryPackParam.setBatteryCount(rs.getInt("battery_count"));
                                batteryPackParam.setThresholdConfig(rs.getString("threshold_config"));
                                batteryPackParam.setVoltageRange(rs.getDouble("voltage_range"));
                                batteryPackParam.setCapacity(rs.getDouble("capacity"));
                                batteryPackParam.setType(rs.getString("type"));
                                return batteryPackParam;
                            }
                        }
                        , paramsMap.get("batteryPackId"));
        if ((batteryPackParams != null) && (batteryPackParams.size() > 0)) {
            return JSON.toJSONString(new AResult("", 0, batteryPackParams.get(0)));
        }

        return JSON.toJSONString(new AResult(Constant.noneData, -1, null));
    }

    // 回路管理 - 查
    @Transactional(propagation = Propagation.REQUIRED)
    public String getCiruits(int page, int rows) {
        try {
            SqlRowSet srsTotal = baseDao.getJdbcTemplate()
                    .queryForRowSet("SELECt COUNT(id) AS total FROM t_bpm_circuit WHERE status=0");
            if (srsTotal.next()) {
                int total = srsTotal.getInt("total");
                SqlRowSet srs = baseDao.getJdbcTemplate()
                        .queryForRowSet("SELECT " +
                                "t1.id," +
                                "t1.`name`," +
                                "t1.monitor_id," +
                                "t2.`name` AS batteryPack," +
                                "t2.id AS batteryPackId," +
                                "t3.`id` AS areaId," +
                                "t4.* " +
                                "FROM " +
                                "t_bpm_circuit t1 LEFT JOIN " +
                                "t_bpm_battery_pack t2 ON t1.battery_pack_id = t2.id AND t2.status = 0 LEFT JOIN " +
                                "t_sys_area t3 ON t1.parent_id = t3.id " +
                                "LEFT JOIN t_bpm_data_accuracy t4 ON t4.circuit_id = t1.id " +
                                "WHERE t1.status=0 " +
                                "ORDER BY t1.id DESC LIMIT " + (page - 1) * rows + "," + page * rows);
                List<CircuitGridData> circuitGridDatas = new ArrayList<>();
                while (srs.next()) {
                    String area = getAreaStr(srs.getLong("areaId"));
                    CircuitGridData circuitGridData = new CircuitGridData();
                    circuitGridData.setId(srs.getLong("id"));
                    circuitGridData.setName(srs.getString("name"));
                    circuitGridData.setBatteryPackId(srs.getLong("batteryPackId"));
                    circuitGridData.setDeviceId(srs.getLong("monitor_id"));
                    circuitGridData.setArea(area);
                    circuitGridData.setAreaIds(getAreaIdStr(srs.getLong("areaId")));
                    circuitGridData.setBatteryPack(srs.getString("batteryPack"));
                    circuitGridData.setVolent(srs.getDouble("voltage"));
                    circuitGridData.setResistance(srs.getDouble("resistance"));
                    circuitGridData.setTemperature(srs.getDouble("temperature"));
                    circuitGridData.setPackVollent(srs.getDouble("pack_voltage"));
                    circuitGridData.setCurrent(srs.getDouble("current"));
                    circuitGridData.setEnvironTemperature(srs.getDouble("environment_temperature"));
                    circuitGridData.setRippleVoltage(srs.getDouble("ripple_voltage"));
                    circuitGridData.setLeakageCurrent(srs.getDouble("leakage_current"));
                    circuitGridDatas.add(circuitGridData);
                }
                return JSON.toJSONString(
                        new PaginationResultByEuiGrid(total, circuitGridDatas));
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return "";
    }

    /* 设置告警阈值参数 */
    //设置告警阈值参数 - 改
    @Transactional(propagation = Propagation.REQUIRED)
    public String updateAlarmDefaultParams(String defultAlarmParamsJson) {
        Long operationId = operationLogSevcie.insertOperation("updateAlarmDefaultParams", null);
        try {
            String[] attrName = {
                    "groupVoltageUp",
                    "groupVoltageDown",
                    "envirTeaperature",
                    "groupCurrentThreshold",
                    "groupRippleCurrent",
                    "groupRippleVoltage",
                    "groupLeakageCurrent",
                    "voltageThresholdUp",
                    "voltageThresholdDown",
                    "resistanceLevel1",
                    "resistanceLevel2",
                    "battery_rippleVoltageLimit",
                    "temperature"
            };
            AlarmDefaultConfig alarmDefaultConfig = JSON.parseObject(defultAlarmParamsJson
                    , AlarmDefaultConfig.class);
            DB db = baseDao.getDb();
            for (int i = 0; i < attrName.length; i++) {
                String funName = "get" + Misc.firstCharCapitalForStr(attrName[i]);
                String value = alarmDefaultConfig.getClass()
                        .getMethod(funName).invoke(alarmDefaultConfig).toString();
                List<Record> records = db
                        .active("t_bpm_default_params").where("name = ?", attrName[i]);
                if (records != null && records.size() > 0) {
                    Record record = records.get(0);
                    record.set("value", Double.parseDouble(value));
                    db.active("t_bpm_default_params").update(record);
                }
                else {
                    db.active("t_bpm_default_params").create("name:", attrName[i], "value:", Double.parseDouble(value));
                }
            }

            operationLogSevcie.updateOperationResult(operationId);
            return Misc.convertAResultJson(Constant.updateSuccess, 0, null);
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.updateError, -1, null);
        }
    }

    //设置告警阈值参数 - 查
    @Transactional(propagation = Propagation.REQUIRED)
    public String getAlarmDefaultParams() {
        try {
            DB db = baseDao.getDb();
            List<DefaultParams> defaultParamList = db.active("t_bpm_default_params").where(new RowMapper<DefaultParams>() {
                @Override
                public DefaultParams mapRow(ResultSet rs, int rowNum) throws SQLException {
                    DefaultParams defaultParams = new DefaultParams();
                    defaultParams.setName(rs.getString("name"));
                    defaultParams.setValue(rs.getDouble("value"));
                    return defaultParams;
                }
            }, "type = ?", "alarmThreshold");
            if (defaultParamList != null && defaultParamList.size() > 0) {
                return Misc.convertAResultJson("", 0, defaultParamList);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.noneData, -1, null);
        }
    }

    /* 下拉框数据管理 */
    // 根据名称模糊获取电池组
    @Transactional(propagation = Propagation.REQUIRED)
    public String getBatteryPackLikeName(String name) {
        try {
            String sql = "SELECT * FROM t_bpm_battery_pack tbbp " +
                    "LEFT JOIN t_bpm_battery_pack_sf_extension tbbpe " +
                    "ON tbbp.id = tbbpe.battery_pack_id " +
                    "WHERE tbbp.status=0 ";
            List<BatteryPack> batteryPacks;
            if (!StringUtils.isNullOrEmpty(name)) {
                String query = "AND tbbp.`name` LIKE '%?%'";
                sql += query;
                batteryPacks = baseDao.getJdbcTemplate()
                        .query(sql, new Object[] { name }, new BatteryPackRowMapper());
            }
            else {
                batteryPacks = baseDao.getJdbcTemplate()
                        .query(sql, new BatteryPackRowMapper());
            }

            if (batteryPacks != null && batteryPacks.size() > 0) {
                return JSON.toJSONString(new PaginationResultByEuiGrid(
                        batteryPacks.size(), batteryPacks));
            }
            else {
                return JSON.toJSONString("{}");
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return JSON.toJSONString("{}");
        }
    }

    /**
     * 获取当前回路使用的电池组和未被回路使用的电池组
     *
     * @param id 当前电池组ID
     * @return 当前回路使用的电池组和未被回路使用的电池组JSON
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public String getOwnAndOtherNotUseBatteryPack(Long id) {
        try {
            String sql = "SELECT * FROM t_bpm_battery_pack " +
                    "LEFT JOIN t_bpm_circuit ON t_bpm_battery_pack.id = t_bpm_circuit.battery_pack_id AND t_bpm_circuit.status=0,t_bpm_battery_pack_sf_extension " +
                    "WHERE ((t_bpm_circuit.battery_pack_id IS NULL) OR (t_bpm_circuit.battery_pack_id=?)) " +
                    "AND t_bpm_battery_pack.id = t_bpm_battery_pack_sf_extension.battery_pack_id AND t_bpm_battery_pack.status=0";

            List<BatteryPack> batteryPacks = baseDao.getJdbcTemplate()
                    .query(sql, new Object[] { id }, new BatteryPackRowMapper());

            if (batteryPacks != null && batteryPacks.size() > 0) {
                return Misc.convertAResultJson("", 0, batteryPacks);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.noneData, -1, null);
        }
    }

    // 获取未被回路使用的电池组
    @Transactional(propagation = Propagation.REQUIRED)
    public String getNoUseBatteryPack() {
        try {
            String sql = "SELECT * FROM t_bpm_battery_pack,t_bpm_battery_pack_sf_extension " +
                    "WHERE t_bpm_battery_pack.id = t_bpm_battery_pack_sf_extension.battery_pack_id " +
                    "AND t_bpm_battery_pack.status=0 AND t_bpm_battery_pack.id NOT IN (SELECT battery_pack_id FROM t_bpm_circuit WHERE status=0)";

            List<BatteryPack> batteryPacks = baseDao.getJdbcTemplate()
                    .query(sql, new BatteryPackRowMapper());

            if (batteryPacks != null && batteryPacks.size() > 0) {
                return Misc.convertAResultJson("", 0, batteryPacks);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.noneData, -1, null);
        }
    }

    // 获取被回路使用的电池组
    @Transactional(propagation = Propagation.REQUIRED)
    public String getUseBatteryPack() {
        try {
            String sql = "SELECT * FROM t_bpm_battery_pack,t_bpm_battery_pack_sf_extension " +
                    "WHERE t_bpm_battery_pack.id = t_bpm_battery_pack_sf_extension.battery_pack_id " +
                    "AND t_bpm_battery_pack.status=0 AND t_bpm_battery_pack.id IN (SELECT battery_pack_id FROM t_bpm_circuit WHERE status=0)";

            List<BatteryPack> batteryPacks = baseDao.getJdbcTemplate()
                    .query(sql, new BatteryPackRowMapper());

            if (batteryPacks != null && batteryPacks.size() > 0) {
                return Misc.convertAResultJson("", 0, batteryPacks);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.noneData, -1, null);
        }
    }

    // 获取被回路使用的单体
    @Transactional(propagation = Propagation.REQUIRED)
    public String getUseBattery() {
        try {
            String sql = "SELECT * FROM t_bpm_battery\n" +
                    "WHERE battery_pack_id IN (SELECT battery_pack_id FROM t_bpm_circuit WHERE status=0)";

            List<Battery> batteries = baseDao.getJdbcTemplate()
                    .query(sql, new BatteryRowMapper());

            if (batteries != null && batteries.size() > 0) {
                return Misc.convertAResultJson("", 0, batteries);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.noneData, -1, null);
        }
    }

    // 获取所有设备
    @Transactional(propagation = Propagation.REQUIRED)
    public String getDevices() {
        try {
            DB db = baseDao.getDb();
            List<Device> devices = db.active("t_bpm_device")
                    .where(new DeviceRowMapper(), "type = ? AND status=0", "SfDevice");
            if (devices != null && devices.size() > 0) {
                return Misc.convertAResultJson("", 0, devices);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.noneData, -1, null);
        }
    }

    // 获取回路根据区域
    @Transactional(propagation = Propagation.REQUIRED)
    public String getCiruitsByAreaId(long areaId) {
        try {
            String sql = "SELECT " +
                    "t1.id," +
                    "t1.`name`," +
                    "t1.monitor_id," +
                    "t2.`name` AS batteryPack," +
                    "t2.id AS batteryPackId," +
                    "t3.`id` AS areaId," +
                    "t4.* " +
                    "FROM " +
                    "t_bpm_circuit t1 LEFT JOIN " +
                    "t_bpm_battery_pack t2 ON t1.battery_pack_id = t2.id LEFT JOIN " +
                    "t_sys_area t3 ON t1.parent_id = t3.id " +
                    "LEFT JOIN t_bpm_data_accuracy t4 ON t4.circuit_id = t1.id " +
                    "WHERE t3.id = " + areaId + " " +
                    "ORDER BY t1.id DESC ";
            if (areaId == 0) {
                sql = "SELECT " +
                        "t1.id," +
                        "t1.`name`," +
                        "t1.monitor_id," +
                        "t2.`name` AS batteryPack," +
                        "t2.id AS batteryPackId," +
                        "t3.`id` AS areaId," +
                        "t4.* " +
                        "FROM " +
                        "t_bpm_circuit t1 LEFT JOIN " +
                        "t_bpm_battery_pack t2 ON t1.battery_pack_id = t2.id LEFT JOIN " +
                        "t_sys_area t3 ON t1.parent_id = t3.id " +
                        "LEFT JOIN t_bpm_data_accuracy t4 ON t4.circuit_id = t1.id " +
                        "ORDER BY t1.id DESC ";
            }
            SqlRowSet srs = baseDao.getJdbcTemplate()
                    .queryForRowSet(sql);
            List<CircuitGridData> circuitGridDatas = new ArrayList<>();
            while (srs.next()) {
                CircuitGridData circuitGridData = new CircuitGridData();
                circuitGridData.setId(srs.getLong("id"));
                circuitGridData.setName(srs.getString("name"));
                circuitGridDatas.add(circuitGridData);
            }
            return JSON.toJSONString(circuitGridDatas);

        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return "";
    }

    /*comboTree UI 数据源*/
    // 获取区域
    public String getAreaToComboTreeModel() {
        List<CombotreeData> combotreeDatas = new ArrayList<>();
        try {
            List<SimpleDateForzTree> simpleDateForzTrees = baseDao.getDb()
                    .active("t_sys_area").all(new AreaRowMapper());

            for (SimpleDateForzTree simpleDateForzTree : simpleDateForzTrees) {
                if (simpleDateForzTree.getPid() == 0) {
                    CombotreeData combotreeData = new CombotreeData();
                    combotreeData.setId(simpleDateForzTree.getId());
                    combotreeData.setText(simpleDateForzTree.getName());
                    combotreeData.setChildren(new ArrayList<CombotreeData>());

                    long id2 = simpleDateForzTree.getId();
                    for (SimpleDateForzTree simpleDateForzTree2 : simpleDateForzTrees) {
                        if (simpleDateForzTree2.getPid() == id2) {
                            CombotreeData combotreeData2 = new CombotreeData();
                            combotreeData2.setId(simpleDateForzTree2.getId());
                            combotreeData2.setText(simpleDateForzTree2.getName());
                            combotreeData2.setChildren(new ArrayList<CombotreeData>());

                            long id3 = simpleDateForzTree2.getId();
                            for (SimpleDateForzTree simpleDateForzTree3 : simpleDateForzTrees) {
                                if (simpleDateForzTree3.getPid() == id3) {
                                    CombotreeData combotreeData3 = new CombotreeData();
                                    combotreeData3.setId(simpleDateForzTree3.getId());
                                    combotreeData3.setText(simpleDateForzTree3.getName());
                                    combotreeData2.getChildren().add(combotreeData3);
                                }
                            }
                            combotreeData.getChildren().add(combotreeData2);
                        }
                    }
                    combotreeDatas.add(combotreeData);
                }
            }
        }
        catch (Exception e) {
            Tracker.e(Constant.operationError + "\n" + e);
        }
        finally {
            return JSON.toJSONString(combotreeDatas);
        }
    }

    /* 文件导入管理 */
    // 导入特性曲线
    public String importCharacteristicCurve(HttpServletRequest request) {
        String fileName = Misc.uploadFile(request, "upload");
        if (StringUtils.isNullOrEmpty(fileName)) {
            return JSON.toJSONString("文件上传失败");
        }
        else {
            return JSON.toJSONString(fileName);
        }
    }

    // 导入单体配置文件信息
    public String importBatterySettingConfig(HttpServletRequest request) {
        try {
            String strBatteryParam = "Battery_name,Barcode,ProductionDate," +
                    "Battery_firstUseDate,ProducerName,SerialNum," +
                    "ChemicalComposition,CellNum,InitCapacity,Battery_specifications," +
                    "Battery_rippleVoltageLimit,ResistanceLevel1,ResistanceLevel2," +
                    "Temperature,VoltageThresholdDown,VoltageThresholdUp," +
                    "CircleLife,FloatChargeLife,VirtualCapacity,VirtualAmp," +
                    "FloatChargeVolt,EqualChargeVolt,ChargeRate,CapacityCheckPoInt32," +
                    "SchedulingCycle,IsAlarm,Battery_version";

            String[] batteryFunName = strBatteryParam.split(",");
            String str = Misc.uploadFileToLineStr(request);
            if (!StringUtils.isNullOrEmpty(str)) {
                str = new String(str.getBytes(), "UTF8");
                String[] lines = str.split("\n");
                if (lines != null && lines.length > 0) {
                    List<BatteryParam> batteryParamList = new ArrayList<>();
                    for (int i = 0; i < lines.length; i++) {
                        String line = lines[i];
                        if (!StringUtils.isNullOrEmpty(line)) {
                            String[] params = line.split(",");
                            BatteryParam batteryParam = new BatteryParam();
                            for (int j = 0; j < params.length; j++) {
                                String param = params[j];
                                if (!StringUtils.isNullOrEmpty(param)) {
                                    Class clazz = batteryParam.getClass().getMethod(
                                            "get" + batteryFunName[j]).getReturnType();
                                    batteryParam.getClass().getMethod(
                                            "set" + batteryFunName[j], clazz)
                                            .invoke(batteryParam, convertToType(clazz, param));
                                }
                            }
                            batteryParamList.add(batteryParam);
                        }
                        System.out.println(line);
                    }
                    BatteryPackSetConfig batteryPackSetConfig = new BatteryPackSetConfig();
                    batteryPackSetConfig.setBatteryPackParams(null);
                    batteryPackSetConfig.setBatteryParamList(batteryParamList);
                    return JSON.toJSONString(batteryPackSetConfig);
                }
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return "";
    }

    // 导入电池组配置文件信息
    public String importBatteryPackSettingConfig(HttpServletRequest request) {
        try {
            String[] batteryPackFunName = { "BatteryPack_name", "BatteryCount", "Capacity",
                    "CheckCycleTime", "VoltageRange", "GroupVoltageUp", "GroupVoltageDown",
                    "GroupCurrentThreshold", "GroupRippleCurrent", "GroupLeakageCurrent",
                    "EnvirTeaperature", "GroupRippleVoltage", "Type",
                    "BatteryTeamperatureLevelBaseLine1", "BatteryTeamperatureLevelBaseLine2",
                    "BatteryVoltageLevelBaseLine1", "BatteryVoltageLevelBaseLine2",
                    "BatteryResistanceLevelBaseLine1", "BatteryResistanceLevelBaseLine2" };

            String strBatteryParam = "Battery_name,Barcode,ProductionDate," +
                    "Battery_firstUseDate,ProducerName,SerialNum," +
                    "ChemicalComposition,CellNum,InitCapacity,Battery_specifications," +
                    "Battery_rippleVoltageLimit,ResistanceLevel1,ResistanceLevel2," +
                    "Temperature,VoltageThresholdDown,VoltageThresholdUp," +
                    "CircleLife,FloatChargeLife,VirtualCapacity,VirtualAmp," +
                    "FloatChargeVolt,EqualChargeVolt,ChargeRate,CapacityCheckPoInt32," +
                    "SchedulingCycle,IsAlarm,Battery_version";
            String[] batteryFunName = strBatteryParam.split(",");

            String str = Misc.uploadFileToLineStr(request);
            if (!StringUtils.isNullOrEmpty(str)) {
                str = new String(str.getBytes(), "UTF8");
                String[] lines = str.split("\n");
                if (lines != null && lines.length > 0) {
                    BatteryPackParams batteryPackParams = new BatteryPackParams();
                    List<BatteryParam> batteryParamList = new ArrayList<>();
                    for (int i = 0; i < lines.length; i++) {
                        String line = lines[i];
                        if (!StringUtils.isNullOrEmpty(line)) {
                            String[] params = line.split(",");
                            if (i == 0) {
                                for (int j = 0; j < params.length; j++) {
                                    String param = params[j];
                                    if (!StringUtils.isNullOrEmpty(param)) {
                                        Class clazz = batteryPackParams.getClass().getMethod(
                                                "get" + batteryPackFunName[j]).getReturnType();
                                        batteryPackParams.getClass().getMethod(
                                                "set" + batteryPackFunName[j], clazz)
                                                .invoke(batteryPackParams, convertToType(clazz, param));
                                    }
                                }
                            }
                            else {
                                BatteryParam batteryParam = new BatteryParam();
                                for (int j = 0; j < params.length; j++) {
                                    String param = params[j];
                                    if (!StringUtils.isNullOrEmpty(param)) {
                                        Class clazz = batteryParam.getClass().getMethod(
                                                "get" + batteryFunName[j]).getReturnType();
                                        batteryParam.getClass().getMethod(
                                                "set" + batteryFunName[j], clazz)
                                                .invoke(batteryParam, convertToType(clazz, param));
                                    }
                                }
                                batteryParamList.add(batteryParam);
                            }
                        }
                        System.out.println(line);
                    }
                    BatteryPackSetConfig batteryPackSetConfig = new BatteryPackSetConfig();
                    batteryPackSetConfig.setBatteryPackParams(batteryPackParams);
                    batteryPackSetConfig.setBatteryParamList(batteryParamList);
                    return JSON.toJSONString(batteryPackSetConfig);
                }
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return "";
    }

    // 导入电池组告警DLL文件
    public String importBatteryPackAlarmDllFile(HttpServletRequest request) {
        Long operationId = operationLogSevcie.insertOperation("importBatteryPackAlarmDllFile", null);
        List<Byte> bytes = Misc.uploadFileToByteList(request);
        if (bytes != null && bytes.size() > 0) {
            if (CallService.loadBatteryPackAlarmDll(bytes)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson("上传成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("上传DLL文件失败", -1, false);
            }
        }
        else {
            return Misc.convertAResultJson("解析DLL文件失败", -1, false);
        }
    }

    // 导入单体告警DLL文件
    public String importBatteryAlarmDllFile(HttpServletRequest request) {
        Long operationId = operationLogSevcie.insertOperation("importBatteryAlarmDllFile", null);
        List<Byte> bytes = Misc.uploadFileToByteList(request);
        if (bytes != null && bytes.size() > 0) {
            if (CallService.loadBatteryAlarmDll(bytes)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson("上传成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("上传DLL文件失败", -1, false);
            }
        }
        else {
            return Misc.convertAResultJson("解析DLL文件失败", -1, false);
        }
    }

    // 导出电池组配置文件
    public void exportBatteryPackSettingConfig(
            String arrBatteryJson,
            String batteryPackParamsJson,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        String[] batteryPackFunName = { "batteryPack_name", "batteryCount", "capacity",
                "checkCycleTime", "voltageRange", "groupVoltageUp", "groupVoltageDown",
                "groupCurrentThreshold", "groupRippleCurrent", "groupLeakageCurrent",
                "envirTeaperature", "groupRippleVoltage", "type",
                "batteryTeamperatureLevelBaseLine1", "batteryTeamperatureLevelBaseLine2",
                "batteryVoltageLevelBaseLine1", "batteryVoltageLevelBaseLine2",
                "batteryResistanceLevelBaseLine1", "batteryResistanceLevelBaseLine2" };

        String strBatteryParam = "Battery_name,Barcode,ProductionDate," +
                "Battery_firstUseDate,ProducerName,SerialNum," +
                "ChemicalComposition,CellNum,InitCapacity,Battery_specifications," +
                "Battery_rippleVoltageLimit,ResistanceLevel1,ResistanceLevel2," +
                "Temperature,VoltageThresholdDown,VoltageThresholdUp," +
                "CircleLife,FloatChargeLife,VirtualCapacity,VirtualAmp," +
                "FloatChargeVolt,EqualChargeVolt,ChargeRate,CapacityCheckPoInt32," +
                "SchedulingCycle,IsAlarm,Battery_version";
        String[] batteryFunName = strBatteryParam.split(",");
        List<String> stringList = new ArrayList<>();
        String fileName = "";
        try {
            if (!StringUtils.isNullOrEmpty(batteryPackParamsJson)) {
                Map<String, Object> batteryPackParamMap = JSON.parseObject(batteryPackParamsJson, Map.class);
                StringBuffer batteryPackParams = new StringBuffer();
                for (int i = 0; i < batteryPackFunName.length; i++) {
                    String key = batteryPackFunName[i];
                    Object object = batteryPackParamMap.get(key);
                    String str = (object != null ? object.toString() : "");
                    batteryPackParams.append(str + ",");
                    if (i == 0) {
                        fileName = str + "配置";
                        fileName = fileName.replace("\uFEFF", "");
                    }
                }
                String batteryPackParam = batteryPackParams.toString();
                if (!StringUtils.isNullOrEmpty(batteryPackParam)) {
                    batteryPackParam = batteryPackParam.substring(0, batteryPackParam.length() - 1);
                    stringList.add(batteryPackParam);
                }

                if (!StringUtils.isNullOrEmpty(arrBatteryJson)) {
                    List<BatteryParam> batteryParamList = new ArrayList<>();
                    try {
                        batteryParamList = JSONArray.parseArray(arrBatteryJson, BatteryParam.class);
                    }
                    catch (Exception e) {
                        Tracker.e(e);
                    }

                    for (BatteryParam batteryParam : batteryParamList) {
                        StringBuffer params = new StringBuffer();
                        for (int j = 0; j < batteryFunName.length; j++) {
                            Object object = null;
                            try {
                                object = batteryParam.getClass().getMethod(
                                        "get" + batteryFunName[j]).invoke(batteryParam);
                            }
                            catch (Exception e) {
                                Tracker.e(e);
                            }

                            String str = (object != null ? object.toString() : "") + ",";
                            params.append(str);
                        }

                        String param = params.toString();
                        if (!StringUtils.isNullOrEmpty(param)) {
                            param = param.substring(0, param.length() - 1);
                            stringList.add(param);
                        }
                    }
                }
            }
            String filePath = Misc.wirteToFile(stringList, fileName);
            if (!StringUtils.isNullOrEmpty(filePath)) {
                Misc.DownLoad(filePath, fileName, httpServletRequest, httpServletResponse);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    /**
     * 导出特性曲线配置文件
     * @param id 电池组下标索引
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public void exportCharacterConfig(Long id ,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        List<BatteryPackSF> batteryPackSF = null;
        batteryPackSF = baseDao.getJdbcTemplate()
                .query("SELECT * FROM t_bpm_sfbattery_pack_alarm_data tbb " +
                                "WHERE tbb.battery_pack_id = ? "
                        , new BatteryPackSFRowMapper(), id);
        if(batteryPackSF.isEmpty() ){
            batteryPackSF = baseDao.getJdbcTemplate()
                    .query("SELECT * FROM t_bpm_battery_pack_sf_extension tbb " +
                                    "WHERE tbb.battery_pack_id = ? "
                            , new BatteryPackSFRowMapper(), id);
        }

        // 取出二进制对象
        Blob character = batteryPackSF.get(0).getCharacter();
        String fileName = "特线曲性" + "_" + new Date().getTime();
        String path = Misc.getBasePath() + "upload\\" + fileName + ".csv";
        try {
            InputStream inputStream = character.getBinaryStream();
            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            byte[] buf = new byte[8];
            int index = 0;
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            // byte转double 写入文件
            while ((inputStream.read(buf)) != -1) {
                String str = new String(buf);
                long value = 0;
                for (int i = 0; i < 8; i++) {
                    value |= ((long) (buf[i] & 0xff)) << (8 * i);
                }
                Double s = Double.longBitsToDouble(value);
                writer.write(s.toString());
                if (++index == 13) {
                    writer.write("\r\n");
                    index = 0;
                }
                else {
                    writer.write(",");
                }
            }

            inputStream.close();
            writer.close();

            Misc.DownLoad(path, fileName, httpServletRequest, httpServletResponse);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取电池组和单体动态库的版本号
     *
     * @return 版本信息JSON
     */
    public String getVersionNumberOfBPDLLAndBDLL() {
        Map<String, String> versionNumMap = new HashMap<>();
        versionNumMap.put("BPDLLVerSionNum", CallService.getBatteryPackDynamicVersion());
        versionNumMap.put("BDLLVerSionNum", CallService.getBatteryDynamicVersion());
        versionNumMap.put("ECUVersion", CallService.getECUAndVersion(1L));
        return JSON.toJSONString(versionNumMap);
    }

    /**
     * 获取ECU的版本号
     *
     * @return 版本信息JSON
     */
    public String getVersionNumberOfECU(Long circuitId) {
        Map<String, String> versionNumMap = new HashMap<>();
        versionNumMap.put("ECUVersion", CallService.getECUAndVersion(circuitId));
        return JSON.toJSONString(versionNumMap);
    }

    /**
     * 组网设备管理 -设置BCU编码
     *
     * @param circuitId 回路ID
     * @param bcuConfig BCU配置
     * @return 设置是否成功信息
     */
    public String setSfBCUConfig(Long circuitId, String bcuConfig) {
        Long operationId = operationLogSevcie.insertOperation("setSfECUConfig", null);
        try {
            if (CallService.setSfBCUConfig(circuitId, bcuConfig)) {
                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson("下发成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("下发失败", -1, true);
            }
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson("下发出错", -1, false);
        }
    }

    /**
     * 组网设备管理-更新BCU
     *
     * @param oldCircuitId       原回路ID
     * @param oldRegisterAddress 原编号
     * @param registerAddress    修改后编号
     * @param bcuConfig          BCU配置
     * @return 更新是否成功信息
     */
    public String updateSfBCUConfig(Long oldCircuitId, Integer oldRegisterAddress, Integer registerAddress, String bcuConfig) {
        Long operationId = operationLogSevcie.insertOperation("updateSfBCUConfig", null);
        try {
            if (CallService.updateSfBCUConfig(oldCircuitId, oldRegisterAddress, registerAddress, bcuConfig)) {
                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson("下发成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("下发失败", -1, true);
            }
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson("下发失败", -1, false);
        }
    }

    /**
     * 下发获取BCU命令
     *
     * @param circuitId       回路ID
     * @param registerAddress BCU编号
     * @return 下发是否成功信息
     */
    public String getSfBCUConfig(Long circuitId, Integer registerAddress) {
        try {
            if (CallService.getSfBCUConfig(circuitId, registerAddress)) {
                return Misc.convertAResultJson("下发成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("下发失败", -1, true);
            }
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson("下发失败", -1, false);
        }
    }

    /**
     * 获取BCU信息
     *
     * @return BCU信息JSON
     */
    public String getSfBCUConfigData() {
        try {
            MSfBCU sfBCU = CallService.getSfBCUConfigData();
            if (sfBCU != null) {
                return Misc.convertAResultJson("", 0, sfBCU);
            }
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    /**
     * 设置ECU深福设备-编辑回路和组网通讯设置-test
     *
     * @param circuitId  回路ID
     * @param paramsJson 参数JSON
     * @return 设置是否成功信息
     */
    public String setSfECUConfig(Long circuitId, String paramsJson) {
        Long operationId = operationLogSevcie.insertOperation("setSfECUConfig", null);
        try {
            if (CallService.setSfECUConfig(circuitId, paramsJson)) {
                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson("下发成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("下发失败", -1, true);
            }
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson("下发出错", -1, false);
        }
    }

    /**
     * 更新ECU
     *
     * @param oldCircuitId       原回路ID
     * @param oldRegisterAddress 原BCU编号
     * @param newCircuitId       新回路ID
     * @param paramsJson         参数JSON
     * @return 更新是否成功信息
     */
    public String updateSfECUConfig(Long oldCircuitId, Integer oldRegisterAddress, Long newCircuitId, String paramsJson) {
        Long operationId = operationLogSevcie.insertOperation("updateSfBCUConfig", null);
        try {
            if (CallService.updateSfECUConfig(oldCircuitId, oldRegisterAddress, newCircuitId, paramsJson)) {

                operationLogSevcie.updateOperationResult(operationId);
                return Misc.convertAResultJson("下发成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("下发失败", -1, true);
            }
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson("下发失败", -1, false);
        }
    }

    /**
     * 下发获取ECU命令
     *
     * @param circuitId       回路ID
     * @param registerAddress ECU编号
     * @return 下发是否成功信息
     */
    public String getSfECUConfig(Long circuitId, Integer registerAddress) {
        try {
            if (CallService.getSfECUConfig(circuitId, registerAddress)) {
                return Misc.convertAResultJson("下发成功", 0, true);
            }
            else {
                return Misc.convertAResultJson("下发失败", -1, true);
            }
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson("下发失败", -1, false);
        }
    }

    /**
     * 获取ECU信息
     *
     * @return ECU信息JSON
     */
    public String getSfECUConfigData() {
        try {
            MSfBCU sfBCU = CallService.getSfECUConfigData();
            if (sfBCU != null) {
                return Misc.convertAResultJson("", 0, sfBCU);
            }
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    /**
     * 获取动态告警库变量信息
     *
     * @param circuitId 回路编号
     * @return ECU信息JSON
     */
    public String getBatteryPackAlarmLibrary(Long circuitId) {
        return CallService.getBatteryPackAlarmLibrary(circuitId);
    }

    /**
     * 获取动态告警库变量信息
     *
     * @param circuitId 回路编号
     * @param index 电池下标
     * @return ECU信息JSON
     */
    public String getBatteryAlarmLibrary(Long circuitId,Long index) {
        return CallService.getBatteryAlarmLibrary(circuitId,index);
    }

    /**
     * 恢复电池
     *
     * @param circuitId 回路编号
     * @param batteryId 电池编号
     */
    public String recoveryBattery(Long circuitId, Long batteryId) {
        if (CallService.recoveryBattery(circuitId, batteryId))
            return JSON.toJSONString(new AResult("恢复成功", 0, null));
        return JSON.toJSONString(new AResult("恢复失败", 0, null));
    }

    /**
     * 拆除电池
     *
     * @param circuitId 回路编号
     * @param batteryId 电池编号
     */
    public String removeBattery(Long circuitId, Long batteryId) {
        if (CallService.removeBattery(circuitId, batteryId))
            return JSON.toJSONString(new AResult("拆除成功", 0, null));
        return JSON.toJSONString(new AResult("拆除失败", 0, null));
    }

    /*私有方法*/
    // 获取完整的区域名称字符串
    private String getAreaStr(long id) {
        DB db = baseDao.getDb();
        Record record = db.active("t_sys_area").find(id);
        if (record != null) {
            String areaStr = record.getStr("area_name");
            Integer areaId =  record.get("pid");
            if (areaId > 0) {
                areaStr = getAreaStr(areaId) + "-" + areaStr;
            }
            return areaStr;
        }
        return null;
    }

    /**
     * 获取多级区域组合名称
     *
     * @return 多级区域组合名称
     */
    private String getAreaNames(Long areaId) {
        return getAreaStr(areaId);
    }

    /**
     * 获取需要修改或新增的区域
     *
     * @return 区域
     */
//    private Area getEditAreaOrAddArea(Long areaId, String newAreaStr, Boolean isAddArea) {
//        String areaNamespace = "http://schemas.datacontract.org/2004/07/BPMBusiness";
//        Area area = new Area();
//        if (isAddArea != null && isAddArea) {
//            JAXBElement<Long> xmlParentId = new JAXBElement<Long>(
//                    new QName(areaNamespace, "ParentId"), Long.class, areaId);
//            area.setParentId(xmlParentId);
//
//            // 3级区域名称
//            JAXBElement<String> xmlNowAreaName = new JAXBElement<String>(
//                    new QName(areaNamespace, "Name"), String.class, newAreaStr);
//            area.setName(xmlNowAreaName);
//
//            // 添加区域
//            CallService.AddArea(area);
//        }
//        else {
//            area.setId(areaId);
//        }
//        return area;
//    }

    // 获取完整的区域编号字符串
    private String getAreaIdStr(long id) {
        DB db = baseDao.getDb();
        Record record = db.active("t_sys_area").find(id);
        if (record != null) {
            String ids = "" + record.getLong("id");
            Integer areaId =  record.get("pid");
            if (areaId > 0) {
                ids = getAreaIdStr(areaId) + "," + ids;
            }
            return ids;
        }
        return null;
    }

    // 初始化电池组信息---C#对象
    private org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPack initBatteryPack(
            String batteryPackParamsJson, String arrBatteryJson
    ) {
        // 参数转换
        BatteryPackParams batteryPackParams = JSON.parseObject(batteryPackParamsJson, BatteryPackParams.class);
        List<BatteryParam> batteryParamList = JSONArray.parseArray(arrBatteryJson, BatteryParam.class);

        // 命名空间
        String namespace = "http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Common";
        String namespace2 = "http://schemas.datacontract.org/2004/07/BPMDevices";

        // 电池组阈值配置
        String batteryPackConfig = batteryPackParams.getThresholdConfig();
        if (StringUtils.isNullOrEmpty(batteryPackConfig)) {
            BPConfig bpConfig = new BPConfig();
            bpConfig.setEnvirTeaperature(batteryPackParams.getEnvirTeaperature());
            bpConfig.setGroupCurrentThreshold(batteryPackParams.getGroupCurrentThreshold());
            bpConfig.setGroupLeakageCurrent(batteryPackParams.getGroupLeakageCurrent());
            bpConfig.setGroupRippleCurrent(batteryPackParams.getGroupRippleCurrent());
            bpConfig.setGroupRippleVoltage(batteryPackParams.getGroupRippleVoltage());
            bpConfig.setGroupVoltageDown(batteryPackParams.getGroupVoltageDown());
            bpConfig.setGroupVoltageUp(batteryPackParams.getGroupVoltageUp());
            batteryPackConfig = JSON.toJSONString(bpConfig);
        }

        // 电池组阙值对象实例化
        BatteryPackThreshold batteryPackThreshold = new BatteryPackThreshold();
        JAXBElement<String> xmlBatteryPackConfig = new JAXBElement<String>(
                new QName(namespace2, "Config"),
                String.class, batteryPackConfig);
        batteryPackThreshold.setConfig(xmlBatteryPackConfig);

        // 电池组实例化
        org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPack
                batteryPack = new org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPack();

        // 电池组ID
        batteryPack.setId(batteryPackParams.getBatteryPack_id());

        // 电池组名称
        JAXBElement<String> xmlName = new JAXBElement<String>(
                new QName(namespace, "Name"), String.class,
                batteryPackParams.getBatteryPack_name());
        batteryPack.setName(xmlName);

        // 电池组容量
        JAXBElement<Double> xmlCapacity = new JAXBElement<Double>(
                new QName(namespace, "Capacity"), Double.class,
                batteryPackParams.getCapacity());
        batteryPack.setCapacity(xmlCapacity);

        // 电池组类型
        if(batteryPackParams.getType().equals("0") ){
            batteryPack.setType(BatteryPackBatterySpecification.fromValue(
                    "VoltageLevel2V"));
        }else if(batteryPackParams.getType().equals("1")){
            batteryPack.setType(BatteryPackBatterySpecification.fromValue(
                    "VoltageLevel12V"));
        }
//        batteryPack.setType(BatteryPackBatterySpecification.fromValue(
//                Integer.parseInt(batteryPackParams.getType())));

        // 电池组阈值配置
        JAXBElement<BatteryPackThreshold> xmlBatteryPackThreshold = new JAXBElement<BatteryPackThreshold>(
                new QName(namespace, "BatteryGroupThreshold"),
                BatteryPackThreshold.class, batteryPackThreshold);
        batteryPack.setBatteryGroupThreshold(xmlBatteryPackThreshold);

        // 单体数量
        batteryPack.setBatteryCount(batteryPackParams.getBatteryCount());

        // 单体电压范围
        batteryPack.setVoltageRange(batteryPackParams.getVoltageRange());

        // 自动测试周期
        batteryPack.setCheckCycleTime(Integer.parseInt(
                batteryPackParams.getCheckCycleTime()));

        // 特性曲线
        String fileName = batteryPackParams.getBattery_characteristicCurve();
        if (!StringUtils.isNullOrEmpty(fileName)) {
            String filePath = Misc.getBasePath() + "upload/" + fileName;
            List<String> lines = Misc.readFileByLines(filePath);
            ArrayOfdouble arrayOfdouble = new ArrayOfdouble();
            List<Double> doubles = arrayOfdouble.getDouble();
            if (lines != null && lines.size() > 0) {
                for (String line : lines) {
                    System.out.println(line);
                    if (!StringUtils.isNullOrEmpty(line)) {
                        String[] strs = line.split(",");
                        for (String str : strs) {
                            try {
                                doubles.add(StringUtils.isNullOrEmpty(str.trim()) ? 0D : Double.parseDouble(str));
                            }
                            catch (Exception e) {
                                doubles.add(0D);
                                Tracker.e(e);
                            }

                        }
                    }
                }
            }

            if (doubles != null && doubles.size() > 0) {

                JAXBElement<ArrayOfdouble> xmlCharacter = new JAXBElement<ArrayOfdouble>(
                        new QName(namespace, "Character"), ArrayOfdouble.class, arrayOfdouble);
                batteryPack.setCharacter(xmlCharacter);
            }
        }

        // 告警基准线配置
        // 温度基线
        JAXBElement<Double> xmlBatteryTeamperatureLevelBaseLine1 = new JAXBElement<Double>(
                new QName(namespace, "BatteryTeamperatureLevelBaseLine1"), Double.class,
                batteryPackParams.getBatteryTeamperatureLevelBaseLine1());
        batteryPack.setBatteryTeamperatureLevelBaseLine1(xmlBatteryTeamperatureLevelBaseLine1);

        JAXBElement<Double> xmlBatteryTeamperatureLevelBaseLine2 = new JAXBElement<Double>(
                new QName(namespace, "BatteryTeamperatureLevelBaseLine2"), Double.class,
                batteryPackParams.getBatteryTeamperatureLevelBaseLine2());
        batteryPack.setBatteryTeamperatureLevelBaseLine2(xmlBatteryTeamperatureLevelBaseLine2);

        // 电压基线
        JAXBElement<Double> xmlBatteryVoltageLevelBaseLine1 = new JAXBElement<Double>(
                new QName(namespace, "BatteryVoltageLevelBaseLine1"), Double.class,
                batteryPackParams.getBatteryVoltageLevelBaseLine1());
        batteryPack.setBatteryVoltageLevelBaseLine1(xmlBatteryVoltageLevelBaseLine1);

        JAXBElement<Double> xmlBatteryVoltageLevelBaseLine2 = new JAXBElement<Double>(
                new QName(namespace, "BatteryVoltageLevelBaseLine2"), Double.class,
                batteryPackParams.getBatteryVoltageLevelBaseLine2());
        batteryPack.setBatteryVoltageLevelBaseLine2(xmlBatteryVoltageLevelBaseLine2);

        // 内阻基线
        JAXBElement<Double> xmlBatteryResistanceLevelBaseLine1 = new JAXBElement<Double>(
                new QName(namespace, "BatteryResistanceLevelBaseLine1"), Double.class,
                batteryPackParams.getBatteryResistanceLevelBaseLine1());
        batteryPack.setBatteryResistanceLevelBaseLine1(xmlBatteryResistanceLevelBaseLine1);

        JAXBElement<Double> xmlBatteryResistanceLevelBaseLine2 = new JAXBElement<Double>(
                new QName(namespace, "BatteryResistanceLevelBaseLine2"), Double.class,
                batteryPackParams.getBatteryResistanceLevelBaseLine2());
        batteryPack.setBatteryResistanceLevelBaseLine2(xmlBatteryResistanceLevelBaseLine2);

        // 单体信息配置
        ArrayOfBattery arrayOfBattery = new ArrayOfBattery();
        if(batteryParamList != null) {
            for (int i = 0; i < batteryParamList.size(); i++) {
                org.datacontract.schemas._2004._07.bpmdevices_vendor.Battery battery =
                        new org.datacontract.schemas._2004._07.bpmdevices_vendor.Battery();

                // 电池名称
                JAXBElement<String> xmlBName = new JAXBElement<String>(
                        new QName(namespace, "Name"), String.class, batteryParamList.get(i).getBattery_name());
                battery.setName(xmlBName);

                // 电池ID
                battery.setId(batteryParamList.get(i).getNo());

                // 电池阈值配置
                String batteryConfig = batteryParamList.get(i).getThresholdConfig();
                if (StringUtils.isNullOrEmpty(batteryConfig)) {
                    BConfig bConfig = new BConfig();
                    bConfig.setBattery_rippleVoltageLimit(batteryParamList.get(i).getBattery_rippleVoltageLimit());
                    bConfig.setResistanceLevel1(batteryParamList.get(i).getResistanceLevel1());
                    bConfig.setResistanceLevel2(batteryParamList.get(i).getResistanceLevel2());
                    bConfig.setTemperature(batteryParamList.get(i).getTemperature());
                    bConfig.setVoltageThresholdDown(batteryParamList.get(i).getVoltageThresholdDown());
                    bConfig.setVoltageThresholdUp(batteryParamList.get(i).getVoltageThresholdUp());
                    batteryConfig = JSON.toJSONString(bConfig);
                }

                // 电池阈值对象实例化
                BatteryThreshold batteryThreshold = new BatteryThreshold();
                JAXBElement<String> xmlBatteryConfig = new JAXBElement<String>(
                        new QName(namespace2, "Config")
                        , String.class, batteryConfig);
                batteryThreshold.setConfig(xmlBatteryConfig);

                // 电池阈值配置
                JAXBElement<BatteryThreshold> xmlBatteryThreshold = new JAXBElement<BatteryThreshold>(
                        new QName(namespace, "BatteryThreshold"), BatteryThreshold.class,
                        batteryThreshold);
                battery.setBatteryThreshold(xmlBatteryThreshold);

                // 单体条形码
                JAXBElement<String> xmlBarCode = new JAXBElement<String>(
                        new QName(namespace, "Barcode"), String.class,
                        batteryParamList.get(i).getBarcode());
                battery.setBarcode(xmlBarCode);

                // 生产厂商
                JAXBElement<String> xmlProducerName = new JAXBElement<String>(
                        new QName(namespace, "ProducerName"), String.class,
                        batteryParamList.get(i).getProducerName());
                battery.setProducerName(xmlProducerName);

                // 容量校准点
                JAXBElement<Double> xmlCapacityCheckPoInt32 = new JAXBElement<Double>(
                        new QName(namespace, "CapacityCheckPoInt32"), Double.class,
                        batteryParamList.get(i).getCapacityCheckPoInt32());
                battery.setCapacityCheckPoInt32(xmlCapacityCheckPoInt32);

                // 电池数量
                Integer cellNum = batteryParamList.get(i).getCellNum();
                JAXBElement<Integer> xmlCellNum = new JAXBElement<Integer>(
                        new QName(namespace, "CellNum"), Integer.class,
                        cellNum);
                battery.setCellNum(xmlCellNum);

                // 循环寿命
                JAXBElement<Double> xmlCircleLife = new JAXBElement<Double>(
                        new QName(namespace, "CircleLife"), Double.class,
                        batteryParamList.get(i).getCircleLife());
                battery.setCircleLife(xmlCircleLife);

                // 均充电压
                JAXBElement<Double> xmlEqualChargeVolt = new JAXBElement<Double>(
                        new QName(namespace, "EqualChargeVolt"), Double.class,
                        batteryParamList.get(i).getEqualChargeVolt());
                battery.setEqualChargeVolt(xmlEqualChargeVolt);

                // 浮充寿命
                JAXBElement<Double> xmlFloatChargeLife = new JAXBElement<Double>(
                        new QName(namespace, "FloatChargeLife"), Double.class,
                        batteryParamList.get(i).getFloatChargeLife());
                battery.setFloatChargeLife(xmlFloatChargeLife);

                // 浮充电压
                JAXBElement<Double> xmlFloatChargeVolt = new JAXBElement<Double>(
                        new QName(namespace, "FloatChargeVolt"), Double.class,
                        batteryParamList.get(i).getFloatChargeVolt());
                battery.setFloatChargeVolt(xmlFloatChargeVolt);

                // 电池容量
                JAXBElement<Double> xmlInitCapacity = new JAXBElement<Double>(
                        new QName(namespace, "InitCapacity"), Double.class,
                        batteryParamList.get(i).getInitCapacity());
                battery.setInitCapacity(xmlInitCapacity);

                // 日期类型
                try {
                    // 生产日期
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Calendar calendar = Calendar.getInstance();
                    String dateSource1 = batteryParamList.get(i).getProductionDate();
                    if (!StringUtils.isNullOrEmpty(dateSource1)) {
                        XMLGregorianCalendar xmlGregorianCalendar = new XMLGregorianCalendarImpl();
                        Date date = sf.parse(dateSource1);
                        calendar.setTime(date);
                        xmlGregorianCalendar.setYear(calendar.get(Calendar.YEAR));
                        xmlGregorianCalendar.setMonth(calendar.get(Calendar.MONTH) + 1);
                        xmlGregorianCalendar.setDay(calendar.get(Calendar.DATE));
                        xmlGregorianCalendar.setTime(calendar.get(Calendar.HOUR),
                                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));

                        JAXBElement<XMLGregorianCalendar> xmlProductionDate = new JAXBElement<XMLGregorianCalendar>(
                                new QName(namespace, "ProductionDate"), XMLGregorianCalendar.class,
                                xmlGregorianCalendar);
                        battery.setProductionDate(xmlProductionDate);
                    }

                    // 第一次使用日期
                    String dateSource2 = batteryParamList.get(i).getBattery_firstUseDate();
                    if (!StringUtils.isNullOrEmpty(dateSource2)) {
                        XMLGregorianCalendar xmlGregorianCalendar = new XMLGregorianCalendarImpl();
                        Date date = sf.parse(dateSource2);
                        calendar.setTime(date);
                        xmlGregorianCalendar.setYear(calendar.get(Calendar.YEAR));
                        xmlGregorianCalendar.setMonth(calendar.get(Calendar.MONTH) + 1);
                        xmlGregorianCalendar.setDay(calendar.get(Calendar.DATE));
                        xmlGregorianCalendar.setTime(calendar.get(Calendar.HOUR),
                                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
                        JAXBElement<XMLGregorianCalendar> xmlFirstTime = new JAXBElement<XMLGregorianCalendar>(
                                new QName(namespace, "FirstTime"), XMLGregorianCalendar.class,
                                xmlGregorianCalendar);
                        battery.setFirstTime(xmlFirstTime);
                    }

                }
                catch (Exception e) {
                    Tracker.e(e);
                }

                // 序列号
                JAXBElement<String> xmlSerialNum = new JAXBElement<String>(
                        new QName(namespace, "SerialNum"), String.class,
                        batteryParamList.get(i).getSerialNum());
                battery.setSerialNum(xmlSerialNum);

                // 化学组成
                JAXBElement<String> xmlChemicalComposition = new JAXBElement<String>(
                        new QName(namespace, "ChemicalComposition"), String.class,
                        batteryParamList.get(i).getChemicalComposition());
                battery.setChemicalComposition(xmlChemicalComposition);

                // 典型放电电流
                JAXBElement<Double> xmlVirtualAmp = new JAXBElement<Double>(
                        new QName(namespace, "VirtualAmp"), Double.class,
                        batteryParamList.get(i).getVirtualAmp());
                battery.setVirtualAmp(xmlVirtualAmp);

                // 典型放电容量
                JAXBElement<Double> xmlVirtualCapacity = new JAXBElement<Double>(
                        new QName(namespace, "VirtualCapacity"), Double.class,
                        batteryParamList.get(i).getVirtualCapacity());
                battery.setVirtualCapacity(xmlVirtualCapacity);

                // 电池规格
            /*battery.setVoltLevel(BatteryPackBatterySpecification.fromValue(
                    Integer.parseInt(batteryParamList.get(i).getBattery_specifications())));*/
                if (batteryParamList.get(i).getBattery_specifications().equals("0")) {
                    battery.setSpecification(BatteryPackBatterySpecification.fromValue(
                            "VoltageLevel2V"));
                }
                else if (batteryParamList.get(i).getBattery_specifications().equals("1")) {
                    battery.setSpecification(BatteryPackBatterySpecification.fromValue(
                            "VoltageLevel12V"));
                }

                // 电池充电率
                JAXBElement<Double> xmlChargeRate = new JAXBElement<Double>(
                        new QName(namespace, "ChargeRate"), Double.class,
                        batteryParamList.get(i).getChargeRate());
                battery.setChargeRate(xmlChargeRate);

                // 数据刷新周期
                JAXBElement<Double> xmlSchedulingCycle = new JAXBElement<Double>(
                        new QName(namespace, "SchedulingCycle"), Double.class,
                        batteryParamList.get(i).
                                getSchedulingCycle());
                battery.setSchedulingCycle(xmlSchedulingCycle);

                // 是否屏蔽告警
                battery.setIsAlarm(batteryParamList.get(i).getIsAlarm());

                arrayOfBattery.getBattery().add(battery);
            }
        }

        // 单体信息
        JAXBElement<ArrayOfBattery> xmlArrayOfBattery = new JAXBElement<ArrayOfBattery>(
                new QName(namespace, "Batteries"), ArrayOfBattery.class, arrayOfBattery);
        batteryPack.setBatteries(xmlArrayOfBattery);

        return batteryPack;
    }

    // 参数类型转换
    private Object convertToType(Class clazz, String param) {
        Integer I = 0;
        Double D = 0.0;
        Boolean B = false;
        if (clazz.getName().equals(I.getClass().getName())) {
            return Integer.parseInt(param);
        }
        else if (clazz.getName().equals(D.getClass().getName())) {
            return Double.parseDouble(param);
        }
        else if (clazz.getName().equals(B.getClass().getName())) {
            return Boolean.parseBoolean(param);
        }
        return param;
    }

    /**
     *  设置电流传感器
     * @param circuitId 回路ID
     * @param inputCurrent 输入电流
     * @param outputVoltage 输出电压
     * @return
     */
    public String setCurrentDucer(Long circuitId, Double inputCurrent, Double outputVoltage) {
        if (CallService.setCurrentDucer(circuitId,inputCurrent,outputVoltage))
            return JSON.toJSONString(new AResult("请求成功", 0, null));
        return JSON.toJSONString(new AResult("请求失败", 0, null));
    }

    /**
     *  检测内阻
     * @param circuitId 回路ID
     * @return
     */
    public String checkResistance(Long circuitId){
        if (CallService.checkResistance(circuitId))
            return JSON.toJSONString(new AResult("请求成功", 0, null));
        return JSON.toJSONString(new AResult("请求失败", 0, null));
    }
}