package com.furongsoft.Public.Services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.furongsoft.Public.CallServices.CallService;
import com.furongsoft.Public.Model.*;
import com.furongsoft.Public.Utils.Constant;
import com.furongsoft.Public.Utils.Misc;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by LYD on 2016/10/6.
 */
@Service
public class RealTimeService
{
    @Autowired
    @Qualifier("BaseDao_system")
    public BaseDao baseDao;

    public String getAlarm()
    {
        try {
            List<MAlarm> alarmList = CallService.GetRealTimeAlarm();
            return JSON.toJSONString(
                new PaginationResultByEuiGrid(alarmList.size(), alarmList));
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            List<MAlarm> alarmList = new ArrayList<>();
            return JSON.toJSONString(
                new PaginationResultByEuiGrid(0, alarmList));
        }
    }

    public String getCircuits(Long areaId)
    {
        try {
            List<MCircuit> mCircuitList = CallService.convertMCircuitByCircuits(areaId);

            if (mCircuitList != null && mCircuitList.size() > 0) {
                MRealTimeData mRealTimeData = new MRealTimeData();
                mRealTimeData.setmCircuits(mCircuitList);
                return Misc.convertAResultJson("", 0, mRealTimeData);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    public String getCircuit(long id)
    {
        try {
            MCircuit mCircuit = CallService.convertMCircuitById(id);
            MRealTimeData mRealTimeData = new MRealTimeData();

            if (mCircuit != null) {
                mRealTimeData.setmCircuits(mCircuit);
                mRealTimeData.setmBatteryPack(new PaginationResultByEuiGrid(mCircuit.getmBatteryPack().getmBatteryList().size(), mCircuit.getmBatteryPack().getmBatteryList()));
                return Misc.convertAResultJson("", 0, mRealTimeData);
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    public String getBatteries(long id)
    {
        try {
            MBatteryPack mBatteryPack = CallService.convertMCircuitById(id).getmBatteryPack();
            if (mBatteryPack != null) {
                return JSON.toJSONString(
                    new PaginationResultByEuiGrid(mBatteryPack.getmBatteryList().size(), mBatteryPack.getmBatteryList()));
            }
            else {
                return Misc.convertAResultJson(Constant.noneData, -1, null);
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return Misc.convertAResultJson(Constant.operationError, -1, null);
        }
    }

    public String getBatteryPackByParams(String paramsJson)
    {
        Map paramMap = JSON.parseObject(paramsJson, Map.class);
        if (paramMap != null && paramMap.size() > 0) {
            String rec = getBatteryPackJson(paramMap);
            return rec;
        }
        return "";
    }

    private String getBatteryPackJson(Map paramMap)
    {
        String rec = "";
        Object oAreaId = paramMap.get("areaId");
        Object oBatteryPackId = paramMap.get("batteryPackId");
        Object oBatteryId = paramMap.get("batteryId");
        Long areaId = oAreaId != null ? Long.parseLong(oAreaId.toString()) : 0L;
        Long batteryPackId = oBatteryPackId != null ? Long.parseLong(oBatteryPackId.toString()) : 0L;
        Long batteryId = oBatteryId != null ? Long.parseLong(oBatteryId.toString()) : 0L;

        List<MCircuit> mCircuitList = CallService.GetCircuitList(areaId, batteryPackId, batteryId);
        if (mCircuitList != null && mCircuitList.size() > 0) {
            MCircuit mCircuit = mCircuitList.get(0);
            RealTimeData realTimeData = new RealTimeData(mCircuitList.size());
            realTimeData.setmAreaStr(mCircuit.getmAreaStr());

            for (int i = 0; i < mCircuitList.size(); i++) {
                realTimeData.getmBatteryPackName()[i] = mCircuitList.get(i).getmBatteryPack().getmName();
                realTimeData.getmBatteryPackVoltage()[i] = mCircuitList.get(i).getmVoltage();
                realTimeData.getmBatteryPackCurrent()[i] = mCircuitList.get(i).getmCurrent();
                realTimeData.getmBatteryPackTemperature()[i] = mCircuitList.get(i).getmBatteryPack().getmBatteryTemperature();
                realTimeData.getmResistanceReference()[i] = mCircuitList.get(i).getmBatteryPack().getmResistanceReference();
            }

            List<PaginationResultByEuiGrid> paginationResultByEuiGrids = new ArrayList<>();
            for (int i = 0; i < mCircuitList.size(); i++) {
                MBatteryPack mBatteryPack = mCircuitList.get(i).getmBatteryPack();
                paginationResultByEuiGrids.add(
                    new PaginationResultByEuiGrid(
                        mBatteryPack.getmBatteryList().size(),
                        mBatteryPack.getmBatteryList()));
            }

            realTimeData.setmBatteryGridDataList(paginationResultByEuiGrids);

            rec = JSON.toJSONString(realTimeData, SerializerFeature.DisableCircularReferenceDetect);
        }

        return rec;
    }
}