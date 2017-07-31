package com.furongsoft.Public.Model;

import java.util.List;

/**
 * Created by Administrator on 2016/9/1.
 */
public class BatteryPackSetConfig
{
    private BatteryPackParams batteryPackParams;
    private List<BatteryParam> batteryParamList;

    public BatteryPackParams getBatteryPackParams()
    {
        return batteryPackParams;
    }

    public void setBatteryPackParams(BatteryPackParams batteryPackParams)
    {
        this.batteryPackParams = batteryPackParams;
    }

    public List<BatteryParam> getBatteryParamList()
    {
        return batteryParamList;
    }

    public void setBatteryParamList(List<BatteryParam> batteryParamList)
    {
        this.batteryParamList = batteryParamList;
    }
}