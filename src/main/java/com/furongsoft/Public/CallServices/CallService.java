package com.furongsoft.Public.CallServices;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.furongsoft.Public.Dao.Entities.*;
import com.furongsoft.Public.Model.*;
import com.furongsoft.Public.Model.User;
import com.furongsoft.Public.Utils.BpmServiceUtil;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import com.furongsoft.XspWeb.Utils.StringUtils;
import com.google.common.primitives.Bytes;
import org.apache.shiro.SecurityUtils;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryPackThreshold;
import org.datacontract.schemas._2004._07.bpmdevices.BatteryThreshold;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.*;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.Battery;
import org.datacontract.schemas._2004._07.bpmdevices_vendor.BatteryPack;
import org.datacontract.schemas._2004._07.bpmservice.BatteryPackInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.tempuri.IBPMWebInterface;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class CallService {
    @Autowired
    @Qualifier("BaseDao_system")
    public static BaseDao baseDao;

    /// <summary>
    /// 获取区域下所有回路信息
    /// </summary>
    /// <param name="id">该区域下的区域索引</param>
    /// <returns>该区域下的所有回路信息</returns>
    public static List<MCircuit> convertMCircuitByCircuits(Long areaId) {
        long s = System.currentTimeMillis();
        ArrayOfCircuitInfo arrayOfCircuit = BpmServiceUtil.GetService().getCircuits(areaId);
        System.out.print("tt========================d================:"+(System.currentTimeMillis()-s)/1000+"   ");
        if (arrayOfCircuit != null) {
            List<CircuitInfo> circuitList = arrayOfCircuit.getCircuitInfo();
            if (circuitList != null && circuitList.size() > 0) {
                List<MCircuit> mCircuitList = new ArrayList<>();
                for (int i = 0; i < circuitList.size(); i++) {
                    MCircuit mCircuit = getMCircuit(circuitList.get(i));
                    mCircuitList.add(mCircuit);
                }
                return mCircuitList;
            }
        }
        return null;
    }

    /// <summary>
    /// 获取单个回路的信息
    /// </summary>
    /// <param name="id">回路索引</param>
    /// <returns>回路信息结果</returns>
    public static MCircuit GetCircuit(Long id) {
        CircuitInfo circuitInfo = BpmServiceUtil.GetService().getCircuit(id);
        MCircuit mCircuit = getMCircuit(circuitInfo);
        return mCircuit;
    }

    public static MCircuit getMCircuit(CircuitInfo circuitInfo) {
        MCircuit mCircuit = new MCircuit();
        mCircuit.setmId(circuitInfo.getId());
        mCircuit.setmName(circuitInfo.getName().getValue());
        mCircuit.setmAreaStr(circuitInfo.getAreaName().getValue());
        //mCircuit.setmCircuitStatus(circuitList.get(i).getStatus().value());
        mCircuit.setmMonitorStatus(circuitInfo.getMonitorState().value());

        BatteryPackInfo batteryPack = circuitInfo.getBatteryPackInfo().getValue();
        if (batteryPack != null) {
            mCircuit.setmBatteryPackId(circuitInfo.getBatteryPackInfo().getValue().getId());
            mCircuit.setmCurrent(circuitInfo.getBatteryPackInfo().getValue().getCurrent().getValue());
            mCircuit.setmVoltage(circuitInfo.getBatteryPackInfo().getValue().getVoltage().getValue());
            Double electricity = circuitInfo.getBatteryPackInfo().getValue().getSOC().doubleValue();
            Integer tempElectrcity = 0;
            if (electricity.isNaN()) {
                tempElectrcity = 0;
            }
            if (electricity > 0) {
                String result = String.format("%.2f", electricity);
                result = Double.parseDouble(result) * 100 + "";
                tempElectrcity = Integer.parseInt(result.substring(0,result.indexOf(".")));
            }
            mCircuit.setmElectricity(tempElectrcity);

            mCircuit.setmBatteryPack(getMBatteryPack(batteryPack));
        }
        else {
            mCircuit.setmCurrent(0.0);
            mCircuit.setmVoltage(0.0);
            mCircuit.setmMonitorStatus("NoBatteryPack");
        }

        return mCircuit;
    }

    /// <summary>
    /// 根据回路索引删除内存中的回路
    /// </summary>
    /// <param name="id">回路索引</param>
    /// <returns>删除的结果</returns>
    public static Boolean DeleteCircuit(Long id) {
//        com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
//                SecurityUtils.getSubject().getSession().getAttribute("userModel");
        return BpmServiceUtil.GetService().removeCircuit(id, 1L);
    }

    /// <summary>
    /// 更新缓存链表中回路数据
    /// </summary>
    /// <param name="circuit">回路数据</param>
    /// <returns>是否更新成功</returns>
    public static Boolean UpdateCircuit(CircuitInfo circuit, Long userId) {
        return BpmServiceUtil.GetService().updateCircuit(circuit, userId);
    }

    /// <summary>
    /// 往缓存中增加回路对象
    /// </summary>
    /// <param name="circuit">回路数据</param>
    /// <returns>增加回路是否成功的结果</returns>
    public static Boolean AddCircuit(CircuitInfo circuit, Long userId) {
        return BpmServiceUtil.GetService().addCircuit(circuit, userId);
    }

    /// <summary>
    /// 获取所有区域
    /// </summary>
    /// <returns>所有区域</returns>
    //List<Area> GetAllAreas();
    public static List<SimpleDateForzTree> convertToSimpleDateForzTree() {
//        ArrayOfArea allAreas = BpmServiceUtil
//                .GetService().getAllAreas();
//        List<Area> areaList = allAreas.getArea();
//        if (areaList != null && areaList.size() > 0) {
//            List<SimpleDateForzTree> simpleDateForzTrees = new ArrayList<>();
//            for (Area area : areaList) {
//                SimpleDateForzTree simpleDateForzTree = new SimpleDateForzTree();
//                simpleDateForzTree.setName(area.getName().getValue());
//                simpleDateForzTree.setPid(area.getParentId().getValue());
//                simpleDateForzTree.setId(area.getId());
//                simpleDateForzTree.setCharge_person(area.getChargePerson().getValue());
//                simpleDateForzTree.setEmail(area.getEmail().getValue());
//                simpleDateForzTree.setTel_no(area.getPhoneNum().getValue());
//                simpleDateForzTrees.add(simpleDateForzTree);
//            }
//            return simpleDateForzTrees;
//        }
        return null;
    }

    /// <summary>
    /// 往区域链表中区域对象
    /// </summary>
    /// <param name="area">区域信息</param>
    /// <returns>新增区域是否成功</returns>
//    public static long AddArea(Area area) {
//        return BpmServiceUtil.GetService().addArea(area);
//    }

    /// <summary>
    /// 更新区域链表的区域数据
    /// </summary>
    /// <param name="area">区域数据</param>
    /// <returns>更新是否成功</returns>
//    public static Boolean UpdateArea(Area area) {
//        return BpmServiceUtil.GetService().updateArea(area);
//    }

    /// <summary>
    /// 从缓存链表中删除区域
    /// </summary>
    /// <param name="id">区域索引</param>
    /// <returns>是否删除成功</returns>
//    public static Boolean DeleteArea(Long id) {
//        com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
//                SecurityUtils.getSubject().getSession().getAttribute("userModel");
//        return BpmServiceUtil.GetService().removeArea(id, user.getId());
//    }

    /// <summary>
    /// 从缓存回路中获取电池组数据
    /// </summary>
    /// <param name="id">电池组索引</param>
    /// <returns>找到电池组对象,未找到为null</returns>
    public static MCircuit convertMCircuitById(Long id) {
        CircuitInfo circuitInfo = BpmServiceUtil.GetService().getCircuit(id);
        return getMCircuit(circuitInfo);
    }

    public static MBatteryPack getMBatteryPack(BatteryPackInfo batteryPack) {
        if (batteryPack != null) {
            MBatteryPack mBatteryPack = new MBatteryPack();
            mBatteryPack.setmId(batteryPack.getId());
            mBatteryPack.setmName(batteryPack.getName().getValue());
            mBatteryPack.setmCurrent(batteryPack.getCurrent().getValue());
            mBatteryPack.setmVoltage(batteryPack.getVoltage().getValue());
            mBatteryPack.setmBatteryTemperature(batteryPack.getEnvironmentTemperature().getValue());
            mBatteryPack.setmHealthyState(batteryPack.getSOH());
//            mBatteryPack.setmThermalRunawayState(batteryPack.isHotState());
            Double electricity = batteryPack.getSOC().doubleValue();
            Integer tempElectrcity = 0;
            if (electricity.isNaN()) {
                tempElectrcity = 0;
            }
            if (electricity > 0) {
                String result = String.format("%.2f", electricity);
                Double temp = Double.parseDouble(result) * 100;
                result = temp.toString();
                if (temp >= 10)
                    tempElectrcity = Integer.parseInt(result.substring(0,result.indexOf(".")));
                else
                    tempElectrcity = Integer.parseInt(result.substring(0, 1));
            }
            mBatteryPack.setmElectricity(tempElectrcity);

            Double tempValue = batteryPack.getBatteryTeamperatureLevelBaseLine1().getValue();
            tempValue = tempValue == null ? 0D : tempValue;
            mBatteryPack.setmBatteryTeamperaturelevel1(tempValue);

            tempValue = batteryPack.getBatteryTeamperatureLevelBaseLine2().getValue();
            tempValue = tempValue == null ? 0D : tempValue;
            mBatteryPack.setmBatteryTeamperaturelevel2(tempValue);

            tempValue = batteryPack.getBatteryVoltageLevelBaseLine1().getValue();
            tempValue = tempValue == null ? 0D : tempValue;
            mBatteryPack.setmBatteryVoltage1(tempValue);

            tempValue = batteryPack.getBatteryVoltageLevelBaseLine2().getValue();
            tempValue = tempValue == null ? 0D : tempValue;
            mBatteryPack.setmBatteryVoltage2(tempValue);

            tempValue = batteryPack.getBatteryResistanceLevelBaseLine1().getValue();
            tempValue = tempValue == null ? 0D : tempValue;
            mBatteryPack.setmBatteryResistance1(tempValue);

            tempValue = batteryPack.getBatteryResistanceLevelBaseLine2().getValue();
            tempValue = tempValue == null ? 0D : tempValue;
            mBatteryPack.setmBatteryResistance2(tempValue);

            //mBatteryPack.setmResistanceReference(batteryPack.getResistanceReference());

            List<MBattery> mBatteries = new ArrayList<>();
            int i = 0;
            Random d = new Random();
            for (Battery battery : batteryPack.getBatteries().getValue().getBattery()) {

                i++;
                if (battery.getId() <= 0) {
                    break;
                }
                MBattery mBattery = new MBattery();
                mBattery.setmId(battery.getId());
                mBattery.setmCurrent(0.0);
                mBattery.setmVoltage(battery.getVoltage().getValue());
                mBattery.setmTemp(battery.getTemperature().getValue());
                mBattery.setmResistance(battery.getResistance().getValue());
                mBattery.setmResistanceReference(battery.getResistanceBaseValue().getValue());
//                mBattery.setmVoltage(i*1.0*d.nextInt(9));
//                mBattery.setmTemp(i*2.0*d.nextInt(9));
//                mBattery.setmResistance(i*3.0*d.nextInt(9));
//                mBattery.setmResistanceReference(battery.getResistanceReference());
                mBattery.setmAlarmState(battery.isAlarmState());
                mBatteries.add(mBattery);
            }
            mBatteryPack.setmBatteryList(mBatteries);
            return mBatteryPack;
        }
        return null;
    }

    /// <summary>
    /// 增加电池组
    /// </summary>
    /// <param name="batteryPack">电池组</param>
    /// <returns>true成功,false 失败</returns>
    public static Boolean AddBatteryPack(BatteryPack batteryPack) {
//        com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
//                SecurityUtils.getSubject().getSession().getAttribute("userModel");
        return BpmServiceUtil.GetService().addBatteryPack(batteryPack, 1L);
    }

    /// <summary>
    /// 更新电池组
    /// </summary>
    /// <param name="batteryPack">电池组</param>
    /// <returns>true成功,false 失败</returns>
    public static Boolean UpdateBatteryPack(BatteryPack batteryPack) {
//        com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
//                SecurityUtils.getSubject().getSession().getAttribute("userModel");
        return BpmServiceUtil.GetService().updateBatteryPack(batteryPack, 1L);
    }

    /// <summary>
    /// 从缓存中获取电池组
    /// </summary>
    /// <param name="id">电池组索引</param>
    /// <returns>成功返回回路下电池组,否则null</returns>
    public static BatteryPackInfo GetBatteryPackInfo(Long id) {
        return BpmServiceUtil.GetService().getBatteryPack(id);
    }

    /// <summary>
    /// 设置回路电池组
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <param name="batteryPackId">电池组索引</param>
    /// <returns>回路设置电池组是否成功</returns>
    public static Boolean SetCircuitBatteryPack(Long circuitId, Long batteryPackId) {
        return BpmServiceUtil.GetService().setCircuitBatteryPack(circuitId, batteryPackId);
    }

    /// <summary>
    /// 删除回路下电池组
    /// </summary>
    /// <param name="id">电池组索引</param>
    /// <returns>是否删除成功</returns>
    public static Boolean RemoveCircuitBatteryPack(Long id) {
        return BpmServiceUtil.GetService().removeCircuitBatteryPack(id);
    }

    /// <summary>
    /// 删除数据库中电池组
    /// </summary>
    /// <param name="id">电池组索引</param>
    /// <returns>是否删除成功</returns>
    public static Boolean RemoveBatteryPack(Long id) {
        return BpmServiceUtil.GetService().removeBatteryPack(id);
    }

    /// <summary>
    /// 获取电池组里面所有单体电池的信息
    /// </summary>
    /// <param name="batteryPackId">电池组索引</param>
    /// <returns>电池数组</returns>
    public static List<Battery> GetBatteries(Long batteryPackId) {
        return BpmServiceUtil.GetService().getBatteries(batteryPackId).getBattery();
    }

    /// <summary>
    /// 增加设备
    /// </summary>
    /// <param name="name">设备类型</param>
    /// <param name="category">设备分类</param>
    /// <param name="type">设备名称</param>
    /// <param name="config">设备配置</param>
    /// <param name="userId">用户索引</param>
    /// <returns>成功true,失败false</returns>
    public static Boolean AddDevice(String name, String type, String config) {
//        com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
//                SecurityUtils.getSubject().getSession().getAttribute("userModel");
        return BpmServiceUtil.GetService().addDevice(name, 0, type, config, 1l);
    }

    /// <summary>
    /// 删除设备
    /// </summary>
    /// <param name="device">设备对象</param>
    /// <returns>删除结果true删除成功,false删除失败</returns>
    public static Boolean RemoveDevice(Long id) {
//        com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
//                SecurityUtils.getSubject().getSession().getAttribute("userModel");
        return BpmServiceUtil.GetService().removeDevice(id, 1l);
    }

    /// <summary>
    /// 更新设备
    /// </summary>
    /// <param name="id">设备索引</param>
    /// <param name="config">配置</param>
    /// <returns>更新结果true更新成功,false更新失败</returns>
    public static Boolean UpdateDevice(Long id, String config) throws Exception {
        try {
//            com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
//                    SecurityUtils.getSubject().getSession().getAttribute("userModel");
            return BpmServiceUtil.GetService().updateDevice(id, config, 1l);
        }
        catch (Exception e) {
            Tracker.e(e);
            if (e.getClass().equals("java.lang.NullPointerException")) {
                throw new Exception("服务未启动");
            }
            return false;
        }
    }

    /// <summary>
    /// 删除回路下的设备
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <param name="name">设备类型</param>
    /// <returns>删除结果</returns>
    public static Boolean RemoveCircuitDevice(Long circuitId, Long deviceId) {
        return BpmServiceUtil.GetService().removeCircuitDevice(circuitId, deviceId);
    }

    /// <summary>
    /// 获取电池阈值
    /// </summary>
    /// <param name="batteryPackId">电池组索引</param>
    /// <param name="batteryId">电池索引</param>
    /// <returns>电池阈值</returns>
    public static BatteryThreshold GetBatteryThreshold(Long batteryPackId, Long batteryId) {
        return BpmServiceUtil.GetService().getBatteryThreshold(batteryPackId, batteryId);
    }

    /// <summary>
    /// 更新电池阈值
    /// </summary>
    /// <param name="batteryPackId">电池组索引</param>
    /// <param name="batteryId">电池索引</param>
    /// <param name="batteryThreshold">电池阈值</param>
    /// <returns>成功true,失败false</returns>
    public static Boolean UpdateBatteryThreshold(Long batteryPackId, Long batteryId, BatteryThreshold batteryThreshold) {
        return BpmServiceUtil.GetService().updateBatteryThreshold(batteryPackId, batteryId, batteryThreshold);
    }

    /// <summary>
    /// 获取电池组阈值配置
    /// </summary>
    /// <param name="batteryPackId"> 电池组索引</param>
    /// <returns>电池组阈值配置</returns>
    public static BatteryPackThreshold GetBatteryGroupThreshold(Long batteryPackId) {
        return BpmServiceUtil.GetService().getBatteryGroupThreshold(batteryPackId);
    }


    /// <summary>
    /// 更新电池组阈值配置
    /// </summary>
    /// <param name="batteryPackId">电池组索引</param>
    /// <param name="BatterygroupThreshold">电池组阈值</param>
    /// <returns>成功true,失败false</returns>
    public static Boolean UpdateBatteryGroupThreshold(Long batteryPackId, BatteryPackThreshold batteryGroupThreshold) {
        return BpmServiceUtil.GetService().updateBatteryGroupThreshold(batteryPackId, batteryGroupThreshold);
    }

    /// <summary>
    /// 单选叶子区域后呈现该区域下所有电池组实时信息。
    /// </summary>
    /// <param name="AreaId">区域索引</param>
    /// <returns>区域下所有电池组实时信息</returns>
    public static List<BatteryPack> GetBatteryPackByArea(Long areaId) {
        List<BatteryPack> batteryPacks = BpmServiceUtil.GetService().getBatteryPackByArea(areaId).getBatteryPack();
        return batteryPacks;
    }

    /// <summary>
    /// 获取实时告警
    /// </summary>
    /// <returns>获取所有实时告警链表</returns>
    public static List<MAlarm> GetRealTimeAlarm() {
        List<Alarm> alarmList = BpmServiceUtil.GetService().getRealTimeAlarm().getAlarm();
        List<MAlarm> mAlarms = new ArrayList<>();
        if (alarmList != null && alarmList.size() > 0) {
            int i = 0;
            for (Alarm alarm : alarmList) {
                ++i;
                MAlarm mAlarm = new MAlarm();
                mAlarm.AlarmId = alarm.getMAlarmId().value();
                mAlarm.AlarmMessage = alarm.getMAlarmMessage().getValue();
                mAlarm.AreaName = alarm.getMAreaName().getValue();
                mAlarm.Id = alarm.getMId() > 0 ? alarm.getMId() : i;
                mAlarm.Level = alarm.getMLevel().value();
                mAlarm.MaintainAdvise = alarm.getMMaintainAdvise().getValue();
                XMLGregorianCalendar xmlSCdate = alarm.getMStrarTime();
                mAlarm.StrarTime = xmlSCdate.getMonth() + "月"
                        + xmlSCdate.getDay() + "日 "
                        + xmlSCdate.getHour() + ":"
                        + xmlSCdate.getMinute() + ":"
                        + xmlSCdate.getSecond();
                XMLGregorianCalendar xmlECdate = alarm.getMEndTime();
                mAlarm.EndTime = xmlECdate.getMonth() + "月"
                        + xmlECdate.getDay() + "日 "
                        + xmlECdate.getHour() + ":"
                        + xmlECdate.getMinute() + ":"
                        + xmlECdate.getSecond();
                mAlarm.CircuitId = alarm.getMCircuitId();
                mAlarms.add(mAlarm);
            }
        }
        return mAlarms;
    }

    /// <summary>
    /// 加载电池组告警动态库文件
    /// </summary>
    /// <param name="streamByte">文件byte</param>
    /// <returns>加载的结果</returns>
    public static Boolean loadBatteryPackAlarmDll(List<Byte> streamByte) {
        byte[] bytes = Bytes.toArray(streamByte);
        return BpmServiceUtil.GetService().loadBatteryPackAlarmDll(bytes);
    }

    /// <summary>
    /// 加载单体告警动态库文件
    /// </summary>
    /// <param name="streamByte">文件byte</param>
    /// <returns>加载的结果</returns>
    public static Boolean loadBatteryAlarmDll(List<Byte> streamByte) {
        byte[] bytes = Bytes.toArray(streamByte);
        return BpmServiceUtil.GetService().loadBatteryAlarmDll(bytes);
    }

    /// <summary>
    /// 获取BCU信息
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <param name="registerAddress">Modbus寄存器地址</param>
    /// <returns>操作结果</returns>
    public static Boolean getSfBCUConfig(Long circuitId, Integer registerAddress) {
        return BpmServiceUtil.GetService().getSfBCUConfig(circuitId, registerAddress);
    }

    /// <summary>
    /// 编号BCU
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <param name="registerAddress">Modbus寄存器地址</param>
    /// <param name="bcuType">BCU类型</param>
    /// <returns>操作结果</returns>
    public static Boolean setSfBCUConfig(Long circuitId, String bcuConfig) {
        //return false;
        SfBCU sfBCU = JSON.parseObject(bcuConfig, SfBCU.class);
        QName _SfBCUMac_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", "Mac");
        byte[] b = new byte[8];
        JAXBElement<byte[]> mac = new JAXBElement<byte[]>(_SfBCUMac_QNAME, byte[].class, SfBCU.class, b);
        return BpmServiceUtil.GetService().setSfBCUConfig(circuitId, sfBCU);
    }

    /// <summary>
    /// 更新深福BCU设备参数命令
    /// </summary>
    /// <param name="oldCircuitId">旧回路索引</param>
    /// <param name="oldRegisterAddress">旧寄存器地址</param>
    /// <param name="newCircuitId">新回路索引</param>
    /// <param name="bcu">BCU参数</param>
    /// <returns>下发结果</returns>
    public static Boolean updateSfBCUConfig(
            Long oldCircuitId,
            Integer oldRegisterAddress,
            Integer registerAddress,
            String bcuConfig) {
        QName _SfBCUMac_QNAME = new QName("http://schemas.datacontract.org/2004/07/BPMDevices.Vendor.Shenfu", "Mac");
        JSONObject sfBCUObject = JSON.parseObject(bcuConfig);
        //SfBCU sfBCU1 = JSON.parseObject(bcuConfig, SfBCU.class);
        String[] sMac = sfBCUObject.getString("mac").split(":");
        byte[] bMac = new byte[8];
        for(int i=0 ;i< sMac.length;i++){
            int s = Integer.parseInt(sMac[i]);
            bMac[i] = (byte) s;
        }
        JAXBElement<byte[]> mac = new JAXBElement<byte[]>(_SfBCUMac_QNAME, byte[].class, SfBCU.class, ((byte[]) bMac));
        SfBCU sfBCU = new SfBCU();
        sfBCU.setMac(mac);
        sfBCU.setPANId(sfBCUObject.getIntValue("panId"));
        sfBCU.setChannel(sfBCUObject.getShort("channel"));
        sfBCU.setZigBeeLocal(sfBCUObject.getIntValue("zigBeeLocal"));
        sfBCU.setType(sfBCUObject.getShort("type"));
        sfBCU.setRegisterAddress(sfBCUObject.getIntValue("registerAddress"));
        return BpmServiceUtil.GetService().updateSfBCUConfig(oldCircuitId,
                sfBCU,registerAddress,oldRegisterAddress);
    }

    /// <summary>
    /// 获取BCU信息
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <returns>BCU对象</returns>
    public static MSfBCU getSfBCUConfigData() {
        SfBCU sfBCU = BpmServiceUtil.GetService().getSfBCUConfigData();
        MSfBCU mSfBCU = null;
        if (sfBCU != null) {
            mSfBCU = new MSfBCU();
            byte[] macBytes = sfBCU.getMac().getValue();
            if (macBytes != null) {
                String mac = "";
                for (int i = 0; i < macBytes.length; i++) {
                    String hex = Integer.toHexString(macBytes[i] & 0xFF);
                    if (i == macBytes.length - 1) {
                        mac += hex;
                    }
                    else {
                        mac += hex + ":";
                    }
                }
                mSfBCU.setMac(mac.toUpperCase());
            }
            mSfBCU.setAddress(sfBCU.getAddress());
            mSfBCU.setBaudRate(sfBCU.getBaudRate());
            mSfBCU.setChannel(sfBCU.getChannel());
            mSfBCU.setIdStatus(sfBCU.getIdStatus());
            mSfBCU.setLength(sfBCU.getLength());
            mSfBCU.setRegisterAddress(sfBCU.getRegisterAddress());
            mSfBCU.setRefresh(sfBCU.isIsRefresh());
            mSfBCU.setType(sfBCU.getType());
            mSfBCU.setSerialNumber(sfBCU.getSerialNumber());
            mSfBCU.setPanId(sfBCU.getPANId());
            byte[] reserveBytes = sfBCU.getReserve().getValue();
            if (macBytes != null) {
                String reserve = "";
                for (int i = 0; i < reserveBytes.length; i++) {
                    String hex = Integer.toHexString(reserveBytes[i] & 0xFF);
                    reserve += hex;
                }
                mSfBCU.setReserve(reserve);
            }
            mSfBCU.setZigBeeGoal(sfBCU.getZigBeeTarget());
            mSfBCU.setZigBeeLocal(sfBCU.getZigBeeLocal());
        }
        return mSfBCU;
    }

    /// <summary>
    /// 获取深福ECU设备参数命令
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <param name="registerAddress">寄存器地址</param>
    /// <returns>下发结果</returns>
    public static Boolean getSfECUConfig(Long circuitId, Integer registerAddress) {
        IBPMWebInterface webInterface = BpmServiceUtil.GetService();
        if (webInterface != null) {
            return false;
//            return webInterface.getSfECUConfig(circuitId, registerAddress);
        }
        else {
            return false;
        }
    }

    /// <summary>
    /// 编号ECU
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <param name="registerAddress">Modbus寄存器地址</param>
    /// <param name="bcuType">BCU类型</param>
    /// <returns>操作结果</returns>
    public static Boolean setSfECUConfig(Long circuitId, String paramsJson) {
        if (StringUtils.isNullOrEmpty(paramsJson)) {
            return false;
        }

        try {
            SfECU sfECU = JSON.parseObject(paramsJson, SfECU.class);
            IBPMWebInterface webInterface = BpmServiceUtil.GetService();
            if (webInterface != null) {
                return webInterface.setSfECUConfig(circuitId, sfECU);
            }
            else {
                return false;
            }
            //return false;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    /// <summary>
    /// 更新深福ECU设备参数命令
    /// </summary>
    /// <param name="oldCircuitId">旧回路索引</param>
    /// <param name="oldRegisterAddress">旧寄存器地址</param>
    /// <param name="newCircuitId">新回路索引</param>
    /// <param name="bcu">BCU参数</param>
    /// <returns>下发结果</returns>
    public static Boolean updateSfECUConfig(Long oldCircuitId, Integer oldRegisterAddress, Long newCircuitId, String paramsJson) {
        if (StringUtils.isNullOrEmpty(paramsJson)) {
            return false;
        }

        try {
            SfECU sfECU = JSON.parseObject(paramsJson, SfECU.class);
            IBPMWebInterface webInterface = BpmServiceUtil.GetService();
            if (webInterface != null) {
                return false;
               // return webInterface.updateSfECUConfig(oldCircuitId, oldRegisterAddress, newCircuitId, sfECU);
            }
            else {
                return false;
            }
            //return false;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    /// <summary>
    /// 获取ECU信息
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <returns>BCU对象</returns>
    public static MSfBCU getSfECUConfigData() {
        SfECU sfECU = null;
        IBPMWebInterface webInterface = BpmServiceUtil.GetService();
        if (webInterface != null) {
            sfECU = webInterface.getSfECUConfigData();
        }

        MSfBCU mSfBCU = null;
        if (sfECU != null) {
            mSfBCU = new MSfBCU();
            byte[] macBytes = sfECU.getMac().getValue();
            if (macBytes != null) {
                String mac = "";
                for (int i = 0; i < macBytes.length; i++) {
                    String hex = Integer.toHexString(macBytes[i] & 0xFF);
                    if (i == macBytes.length - 1) {
                        mac += hex;
                    }
                    else {
                        mac += hex + ":";
                    }
                }
                mSfBCU.setMac(mac.toUpperCase());
            }
            mSfBCU.setAddress(sfECU.getAddress());
            mSfBCU.setBaudRate(sfECU.getBaudRate());
            mSfBCU.setChannel(sfECU.getChannel());
            mSfBCU.setIdStatus(sfECU.getIdStatus());
            mSfBCU.setLength(sfECU.getLength());
            mSfBCU.setRegisterAddress(sfECU.getRegisterAddress());
            mSfBCU.setRefresh(sfECU.isIsRefresh());
            mSfBCU.setType(sfECU.getType());
            mSfBCU.setSerialNumber(sfECU.getSerialNumber());
            byte[] reserveBytes = sfECU.getReserve().getValue();
            if (macBytes != null) {
                String reserve = "";
                for (int i = 0; i < reserveBytes.length; i++) {
                    String hex = Integer.toHexString(reserveBytes[i] & 0xFF);
                    reserve += hex;
                }
                mSfBCU.setReserve(reserve);
            }
            mSfBCU.setZigBeeGoal(sfECU.getZigBeeTarget());
            mSfBCU.setZigBeeLocal(sfECU.getZigBeeLocal());
        }
        return mSfBCU;
    }

    /// <summary>
    /// 获取bpm信息
    /// </summary>
    /// <param name="areaId">区域索引</param>
    /// <param name="batteryPackId">电池组索引</param>
    /// <param name="batteryId">电池索引</param>
    /// <returns>回路列表</returns>
    public static List<MCircuit> GetCircuitList(Long areaId, Long batteryPackId, Long batteryId) {
        try {
            ArrayOfCircuitInfo arrayOfCircuit = BpmServiceUtil.GetService().getCircuitList(areaId, batteryPackId, batteryId);
            List<CircuitInfo> circuitList = arrayOfCircuit.getCircuitInfo();
            if (circuitList != null && circuitList.size() > 0) {
                List<MCircuit> mCircuitList = new ArrayList<>();
                for (int i = 0; i < circuitList.size(); i++) {
                    MCircuit mCircuit = getMCircuit(circuitList.get(i));
                    mCircuitList.add(mCircuit);
                }
                return mCircuitList;
            }
            return null;
        }
        catch (Exception e) {
            Tracker.e(e);
            return null;
        }
    }

    /// <summary>
    /// 获取电池组动态库版本
    /// </summary>
    /// <returns></returns>
    public static String getBatteryPackDynamicVersion() {
        if (BpmServiceUtil.GetService() != null) {
            return BpmServiceUtil.GetService().getBatteryPackCalcAlarmDllVersion();
        }
        else {
            return "未知";
        }
    }

    /// <summary>
    /// 获取单体电池动态库版本
    /// </summary>
    /// <returns></returns>
    public static String getBatteryDynamicVersion() {

        if (BpmServiceUtil.GetService() != null) {
            return BpmServiceUtil.GetService().getBatteryCalcAlarmDllVersion();
        }
        else {
            return "未知";
        }
    }

    /// <summary>
    /// 获取电池组告警库变量信息
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    /// <returns>动态库json</returns>
    public static String getBatteryPackAlarmLibrary(Long circuitId) {
        if (BpmServiceUtil.GetService() != null) {
            return BpmServiceUtil.GetService().getBatteryPackAlarmCalcAssemblyObject(circuitId);
        }
        else {
            return "未连接到服务端,请联系管理员";
        }
    }

    /// <summary>
    /// 获取单体电池告警库变量信息
    /// </summary>
    /// <param name="circuitId">回路索引</param>
    ///<param name="index">电池下标</param>
    /// <returns>动态库json</returns>
    public static String getBatteryAlarmLibrary(Long circuitId,Long index) {
        if (BpmServiceUtil.GetService() != null) {
            return BpmServiceUtil.GetService().getBatteryAlarmCalcAssemblyObject(circuitId,index);
        }
        else {
            return "未连接到服务端,请联系管理员";
        }
    }

    /// <summary>
    /// 获取单体电池动态库版本
    /// </summary>
    /// <returns></returns>
    public static String getECUAndVersion(Long circuitId) {
        try {
            if (BpmServiceUtil.GetService() != null) {
                String ecu = BpmServiceUtil.GetService().getECUVersion(circuitId);
                return ecu;
            }
            else {
                return "未知";
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return "未知";
    }

    /// <summary>
    /// 获取单体电池动态库版本
    /// </summary>
    /// <returns></returns>
    public static Boolean removeBattery(Long circuitId, Long batteryId) {
        try {
            if (BpmServiceUtil.GetService() != null) {
                com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
                        SecurityUtils.getSubject().getSession().getAttribute("userModel");
                return BpmServiceUtil.GetService().disableBattery(circuitId, batteryId, user.getId());
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return false;
    }

    /// <summary>
    /// 获取单体电池动态库版本
    /// </summary>
    /// <returns></returns>
    public static Boolean recoveryBattery(Long circuitId, Long batteryId) {
        try {
            if (BpmServiceUtil.GetService() != null) {
                //return false;
                com.furongsoft.Public.Dao.Entities.User user = (com.furongsoft.Public.Dao.Entities.User)
                        SecurityUtils.getSubject().getSession().getAttribute("userModel");
                return BpmServiceUtil.GetService().recoveryBattery(circuitId, batteryId,user.getId());
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return false;
    }
}