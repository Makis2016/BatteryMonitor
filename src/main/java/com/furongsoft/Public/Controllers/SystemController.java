package com.furongsoft.Public.Controllers;

import com.furongsoft.Public.CallServices.CallService;
import com.furongsoft.Public.Services.OperationLogSevcie;
import com.furongsoft.Public.Services.SystemService;
import com.furongsoft.XspWeb.Common.BaseController;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.Utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Linyudui on 2016/7/21.
 */
@Controller
@RequestMapping("/System")
@SessionAttributes("user")
public class SystemController extends BaseController {
    @Autowired
    public SystemService systemService;

    @Autowired
    public OperationLogSevcie operationLogSevcie;

    /* 用户设置 */
    @RequestMapping(value = "/systemManage")
    @RequiresPermissions("yonghushezhi:show")
    public ModelAndView systemManage(ModelMap model) {
        Long userId = systemService.getUserId(model);
        if (userId == null) {
            return makeModelAndView("XspWeb/Security/Login/unLogin");
        }
        return makeModelAndView("System/systemManage")
                .addObject("id", userId);
    }

    /* 区域管理 */
    @RequestMapping(value = "/addArea")
    @ResponseBody
    public void addArea(String name, String charge_person, String email, Long pid) {
//        responseJson(systemService.addArea(name, charge_person, email, pid));
    }

    @RequestMapping(value = "/deleteArea")
    @ResponseBody
    public void deleteArea(Long id) {
        responseJson(systemService.deleteArea(id));
    }

    @RequestMapping(value = "/editArea")
    @ResponseBody
    public void editArea(String name, String charge_person, String email, Long id, Long pid) {
//        responseJson(systemService.editArea(name, charge_person, email, id, pid));
    }

    /*版本信息及升级 - 告警dll文件管理*/
    @RequestMapping("/setAlarmDll")
    @RequiresPermissions("banbenxinxijishengji")
    public String setBatteryParams() {
        return "System/setAlarmDll";
    }

    @RequestMapping("/getVersionNumberOfBPDLLAndBDLL")
    @ResponseBody
    public void getVersionNumberOfBPDLLAndBDLL() {
        responseJson(systemService.getVersionNumberOfBPDLLAndBDLL());
    }

    @RequestMapping("/getVersionNumberOfECU")
    @ResponseBody
    public void getVersionNumberOfECU(Long circuitId) {
        responseJson(systemService.getVersionNumberOfECU(circuitId));
    }

    @RequestMapping("/importBatteryPackAlarmDllFile")
    @ResponseBody
    public void importBatteryPackAlarmDllFile(HttpServletRequest request) {
        responseJson(systemService.importBatteryPackAlarmDllFile(request));
    }

    @RequestMapping("/importBatteryAlarmDllFile")
    @ResponseBody
    public void importBatteryAlarmDllFile(HttpServletRequest request) {
        responseJson(systemService.importBatteryAlarmDllFile(request));
    }

    /*设备管理*/
    @RequestMapping("/setDeviceManagement")
    @RequiresPermissions("shebeiguanli")
    public String setDeviceManagement() {
        return "System/setDeviceManagement";
    }

    // 回路管理 ---设备管理
    @RequestMapping("/getCircuits")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void getCircuits(int page, int rows) {
        responseJson(systemService.getCiruits(page, rows));
    }

    @RequestMapping("/addCircuitDialog")
    public ModelAndView addCircuitDialog(Long areaId) {
        return makeModelAndView("System/addCircuitDialog")
                .addObject("areaId", areaId);
    }

    @RequestMapping(value = "/addCircuit")
    @ResponseBody
    public void addCircuit(
            Long areaId,
            String groupName,
            Long batteryGroupId,
            Long deviceId,
            String dataAccuracy,
            String newAreaStr,
            Boolean isAddArea,
            String areaIdPath
            ) {
        responseJson(systemService.addCircuit(areaId, groupName, batteryGroupId, deviceId, dataAccuracy, newAreaStr, isAddArea,areaIdPath));
    }

    @RequestMapping(value = "/deleteCircuit")
    @ResponseBody
    public void deleteCircuit(Long id) {
        responseJson(systemService.deleteCircuit(id));
    }

    @RequestMapping("/editCircuitDialog")
    public ModelAndView editCircuitDialog(String json) {
        return makeModelAndView("System/editCircuitDialog")
                .addObject("circuit", json);
    }

    @RequestMapping(value = "/editCircuit")
    @ResponseBody
    public void editCircuit(Long id, Long areaId, String groupName, Long batteryGroupId, Long deviceId, String dataAccuracy, String newAreaStr, Boolean isAddArea, String areaIdPath) {
        responseJson(systemService.editCircuit(id, areaId, groupName, batteryGroupId, deviceId, dataAccuracy, newAreaStr, isAddArea, areaIdPath));
    }

    // 电池组管理 ---设备管理
    @RequestMapping("/getBatteryPacks")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void getBatteryPacks(int page, int rows) {
        responseJson(systemService.getGridBatteryPack(page, rows));
    }

    @RequestMapping("/addBatteryPackDialog")
    public ModelAndView addBatteryPackDialog() {
        return makeModelAndView("System/addBatteryPackDialog");
    }

    @RequestMapping("/addBatteryPack")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void addBatteryPack(String arrBatteryJson, String batteryPackParamsJson) {
        responseJson(systemService.addGridBatteryPack(arrBatteryJson, batteryPackParamsJson));
    }

    @RequestMapping(value = "/deleteBatteryPack")
    @ResponseBody
    public void deleteBatteryPack(Long id) {
        responseJson(systemService.deleteBatteryPack(id));
    }

    @RequestMapping("/editBatteryPackDialog")
    public ModelAndView editBatteryPackDialog(String json) {
        return makeModelAndView("System/editBatteryPackDialog")
                .addObject("batteryPackInfo", json)
                .addObject("batteriesInfo", systemService.getBatteriesJson(json));
    }

    @RequestMapping("/editBatteryPack")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void editBatteryPack(String arrBatteryJson, String batteryPackParamsJson) {
        responseJson(systemService.editGridBatteryPack(arrBatteryJson, batteryPackParamsJson));
    }

    // 电池组管理 ---导入文件
    @RequestMapping("/importBatterySettingConfig")
    @ResponseBody
    public void importBatterySettingConfig(HttpServletRequest request) {
        responseJson(systemService.importBatterySettingConfig(request));
    }

    @RequestMapping("/importBatteryPackSettingConfig")
    @ResponseBody
    public void importBatteryPackSettingConfig(HttpServletRequest request) {
        responseJson(systemService.importBatteryPackSettingConfig(request));
    }

    @RequestMapping("/importCharacteristicCurve")
    @ResponseBody
    public void importCharacteristicCurve(HttpServletRequest request) {
        responseJson(systemService.importCharacteristicCurve(request));
    }

    // 电池组管理 ---导出文件
    @RequestMapping("/exportBatteryPackSettingConfig")
    public void exportBatteryPackSettingConfig(String arrBatteryJson, String batteryPackParamsJson, HttpServletRequest request, HttpServletResponse response) {
        try {
            systemService.exportBatteryPackSettingConfig(
                    arrBatteryJson, batteryPackParamsJson, request, response);
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    @RequestMapping("/exportCharacterConfig")
    public void exportCharacterConfig(Long id, HttpServletRequest request, HttpServletResponse response) {
        try {
            systemService.exportCharacterConfig(
                    id, request, response);
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    // 监控设备管理 ---设备管理
    @RequestMapping("/getALLDevices")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void getALLDevices(int page, int rows) {
        responseJson(systemService.getALLDevices(page, rows));
    }

    @RequestMapping("/setDeviceDialog")
    public ModelAndView setDeviceDialog(Long deviceId, String deviceName, String deviceType, String deviceCfg) {
        return makeModelAndView("System/setDeviceDialog")
                .addObject("mDeviceId", deviceId)
                .addObject("mDeviceName", deviceName)
                .addObject("mDeviceType", deviceType)
                .addObject("mDeviceCfg", deviceCfg);
    }

    @RequestMapping(value = "/addDevice")
    @ResponseBody
    public void addDevice(String name, String type, String config) {
        responseJson(systemService.addDevice(name, type, config));
    }

    @RequestMapping(value = "/deleteDevice")
    @ResponseBody
    public void deleteDevice(Long id) {
        responseJson(systemService.deleteDevice(id));
    }

    @RequestMapping(value = "/updateDevice")
    @ResponseBody
    public void updateDevice(Long id, String config) {
        responseJson(systemService.updateDevice(id, config));
    }

    // 监控设备子设备管理 ---监控设备管理
    @RequestMapping("/setCDeviceDialog")
    public ModelAndView setCDeviceDialog(String todo) {
        return makeModelAndView("System/setCDeviceDialog").addObject("mToDo", todo);
    }

    @RequestMapping(value = "/setSfBCUConfig")
    @ResponseBody
    public void setSfBCUConfig(Long circuitId, String bcuConfig) {
        responseJson(systemService.setSfBCUConfig(circuitId, bcuConfig));
    }

    @RequestMapping(value = "/getSfBCUConfig")
    @ResponseBody
    public void getSfBCUConfig(Long circuitId, Integer registerAddress) {
        responseJson(systemService.getSfBCUConfig(circuitId, registerAddress));
    }

    @RequestMapping(value = "/updateSfBCUConfig")
    @ResponseBody
    public void updateSfBCUConfig(Long oldCircuitId, Integer oldRegisterAddress, Integer registerAddress, String bcuConfig) {
        responseJson(systemService.updateSfBCUConfig(oldCircuitId, oldRegisterAddress, registerAddress, bcuConfig));
    }

    @RequestMapping(value = "/getSfBCUConfigData")
    @ResponseBody
    public void getSfBCUConfigData() {
        responseJson(systemService.getSfBCUConfigData());
    }


    /*个人信息管理*/
    @RequestMapping("/setPersonalInformation")
    @RequiresPermissions("gerenxinxi")
    public ModelAndView setPersonalInformation(ModelMap model) {
        String userJson = systemService.getUserJson(model);
        if (StringUtils.isNullOrEmpty(userJson)) {
            return makeModelAndView("XspWeb/Security/Login/unLogin");
        }
        return makeModelAndView("System/setPersonalInformation")
                .addObject("userJson", userJson);
    }

    @RequestMapping("/editPersonInfo")
    @ResponseBody
    public void editPersonInfo(String json) {
        responseJson(systemService.editPersonInfo(json));
    }

    @RequestMapping("/editPassword")
    @ResponseBody
    public void editPassword(String oldPass, String newPass, String json) {
        responseJson(systemService.editPassword(oldPass, newPass, json));
    }

    /* 系统操作记录查询 */
    @RequestMapping("/operationLog")
    @RequiresPermissions("xitongcaozuojilu")
    public String operationLog() {
        return "System/operationLog";
    }

    @RequestMapping("/getOperationLog")
    @ResponseBody
    public void getOperationLog(String paramJson) {
        responseJson(operationLogSevcie.getOperationLog(paramJson));
    }

    /*combobox UI 数据源*/
    // 获取监控设备
    @RequestMapping("/getAllDevices")
    @ResponseBody
    public void getAllDevices() {
        responseJson(systemService.getDevices());
    }

    // 获取未被回路使用的电池组
    @RequestMapping("/getNotUseBatteryPack")
    @ResponseBody
    public void getNotUseBatteryPack() {
        responseJson(systemService.getNoUseBatteryPack());
    }

    // 获取被自身回路使用和其它未被使用的电池组
    @RequestMapping("/getOwnAndOtherNotUseBatteryPack")
    @ResponseBody
    public void getOwnAndOtherNotUseBatteryPack(Long id) {
        responseJson(systemService.getOwnAndOtherNotUseBatteryPack(id));
    }

    // 获取被回路使用的电池组
    @RequestMapping("/getUseBatteryPack")
    @ResponseBody
    public void getUseBatteryPack() {
        responseJson(systemService.getUseBatteryPack());
    }

    // 获取被回路使用的单体
    @RequestMapping("/getUseBattery")
    @ResponseBody
    public void getUseBattery() {
        responseJson(systemService.getUseBattery());
    }

    // 获取区域回路
    @RequestMapping("/getCircuitsByAreaId")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void getCircuitsByAreaId(long areaId) {
        responseJson(systemService.getCiruitsByAreaId(areaId));
    }

    /*comboGrid UI 数据源*/
    // 根据名称模糊获取电池组
    @RequestMapping("/getBatteryPackLikeName")
    @ResponseBody
    public void getBatteryPackLikeName(String name) {
        responseJson(systemService.getBatteryPackLikeName(name));
    }

    /*comboTree UI 数据源*/
    // 获取区域
    @RequestMapping("/getAreaToComboTreeModel")
    @ResponseBody
    public void getAreaToComboTreeModel() {
        responseJson(systemService.getAreaToComboTreeModel());
    }

    /*未启用的页面*/
    // 通讯组网设置
    @RequestMapping("/setComNetworkParams")
    @RequiresPermissions("tongxunzuwangshezhi")
    public String setComNetworkParams() {
        return "System/setComNetworkParams";
    }

    /*设置告警阈值参数*/
    @RequestMapping("/setAlarmThreshold")
    @RequiresPermissions("gaojingyuzhicanshu")
    public String setAlarmThreshold() {
        return "System/setAlarmThreshold";
    }

    @RequestMapping("/getAlarmDefaultParams")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void getAlarmDefaultParams() {
        responseJson(systemService.getAlarmDefaultParams());
    }

    @RequestMapping("/updateAlarmDefaultParams")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateAlarmDefaultParams(String defultAlarmParamsJson) {
        responseJson(systemService.updateAlarmDefaultParams(defultAlarmParamsJson));
    }

    /**
     * 编辑回路和组网通讯设置-test
     */
    @RequestMapping("/editCircuitANDNetWorking")
    public ModelAndView editCircuitANDNetWorking(String paramsJson,Long circuitId) {
        String deviceJson = systemService.getDeviceInfoById(paramsJson);
        String batteryPackJson = systemService.getBatteryPackById(paramsJson);
        String batteriesJson = systemService.getBatteriesByPackId(paramsJson);
        String versionECU = CallService.getECUAndVersion(circuitId);
        return new ModelAndView("System/editCircuitANDNetWorking")
                .addObject("circuit", paramsJson)
                .addObject("deviceInfo", deviceJson)
                .addObject("batteryPackInfo", batteryPackJson)
                .addObject("batteriesInfo", batteriesJson)
                .addObject("versionECU", versionECU);
    }

    /**
     * 获取BCU数据列表-编辑回路和组网通讯设置-test
     */
    @RequestMapping("/getBCUList")
    @ResponseBody
    public void getBCUList(int page, int rows, String paramsJson) {
        responseJson(systemService.getBCUList(page, rows, paramsJson));
    }

    /**
     * 获取单体信息根据ID-编辑回路和组网通讯设置-test
     */
    @RequestMapping("/getBatteryDataById")
    @ResponseBody
    public void getBatteryDataById(Long id) {
        responseJson(systemService.getBatteryById(id));
    }

    /**
     * 设置ECU深福设备-编辑回路和组网通讯设置-test
     */
    @RequestMapping(value = "/setSfECUConfig")
    @ResponseBody
    public void setSfECUConfig(Long circuitId, String paramsJson) {
        responseJson(systemService.setSfECUConfig(circuitId, paramsJson));
    }

    @RequestMapping(value = "/getSfECUConfig")
    @ResponseBody
    public void getSfECUConfig(Long circuitId, Integer registerAddress) {
        responseJson(systemService.getSfECUConfig(circuitId, registerAddress));
    }

    @RequestMapping(value = "/updateSfECUConfig")
    @ResponseBody
    public void updateSfECUConfig(Long oldCircuitId, Integer oldRegisterAddress, Long newCircuitId, String paramsJson) {
        responseJson(systemService.updateSfECUConfig(oldCircuitId, oldRegisterAddress, newCircuitId, paramsJson));
    }

    /**
     * 获取ECU深福设备-编辑回路和组网通讯设置-test
     */
    @RequestMapping(value = "/getSfECUConfigData")
    @ResponseBody
    public void getSfECUConfigData() {
        responseJson(systemService.getSfECUConfigData());
    }

    /**
     * 获取动态告警库变量信息
     *
     * @param circuitId 回路编号
     */
    @RequestMapping(value = "/getBatteryPackAlarmLibrary")
    @ResponseBody
    public void getBatteryPackAlarmLibrary(Long circuitId) {
        String rec = systemService.getBatteryPackAlarmLibrary(circuitId);
        if (StringUtils.isNullOrEmpty(rec)) {
            responseJson("{\"message\":\"无数据！\"}");
        }
        else {
            responseJson(rec);
        }
    }

    /**
     * 获取动态告警库变量信息
     *
     * @param circuitId 回路编号
     * @param index 电池下标
     */
    @RequestMapping(value = "/getBatteryAlarmLibrary")
    @ResponseBody
    public void getBatteryAlarmLibrary(Long circuitId,Long index) {
        String rec = systemService.getBatteryAlarmLibrary(circuitId,index);
        if (StringUtils.isNullOrEmpty(rec)) {
            responseJson("{\"message\":\"无数据！\"}");
        }
        else {
            responseJson(rec);
        }
    }

    /**
     * 动态告警库变量信息页面
     *
     * @return
     */
    @RequestMapping("/alarmDllForParam")
    @RequiresPermissions("debug")
    public ModelAndView getAlarmDllForParam(Long circuitId) {
        return new ModelAndView("System/alarmDllForParam")
                .addObject("circuitId", circuitId);
    }

    /**
     * 动态告警库变量信息页面
     *
     * @return
     */
    @RequestMapping("/alarmDllBatteryForParam")
    @RequiresPermissions("debug")
    public ModelAndView getAlarmDllBatteryForParam(Long circuitId,Long index) {
        return new ModelAndView("System/alarmDllBatteryForParam")
                .addObject("circuitId", circuitId).addObject("index",index);
    }

    /**
     * 恢复电池
     *
     * @param circuitId 回路编号
     * @param batteryId 电池编号
     */
    @RequestMapping(value = "/recoveryBattery")
    @ResponseBody
    public void recoveryBattery(Long circuitId, Long batteryId) {
        responseJson(systemService.recoveryBattery(circuitId, batteryId));
    }

    /**
     * 拆除电池
     *
     * @param circuitId 回路编号
     * @param batteryId 电池编号
     */
    @RequestMapping(value = "/removeBattery")
    @ResponseBody
    public void removeBattery(Long circuitId, Long batteryId) {
        responseJson(systemService.removeBattery(circuitId, batteryId));
    }
}