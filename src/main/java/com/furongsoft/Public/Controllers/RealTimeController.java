package com.furongsoft.Public.Controllers;

import com.furongsoft.Public.Services.RealTimeService;
import com.furongsoft.XspWeb.Common.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/RealTime")
@SessionAttributes("user")
public class RealTimeController extends BaseController
{
    @Autowired
    public RealTimeService realTimeService;

    @RequestMapping(value = "/Data")
    @RequiresPermissions("shishishuju:show")
    public ModelAndView RealTimeData()
    {
        return makeModelAndView("RealTime/data");
    }

    @RequestMapping(value = "/groupDetail")
    public ModelAndView groupDetail(long circuitId)
    {
        return makeModelAndView("RealTime/groupDetail")
            .addObject("mCircuitId", circuitId);
    }

    @RequestMapping(value = "/batteryGroup")
    public ModelAndView batteryGroup()
    {
        return makeModelAndView("RealTime/batteryGroup");
    }

    @RequestMapping(value = "/getAlarm")
    @ResponseBody
    public void getAlarm()
    {
        responseJson(realTimeService.getAlarm());
    }

    @RequestMapping(value = "/getCircuits")
    @ResponseBody
    public void getCircuits(Long areaId)
    {
        responseJson(realTimeService.getCircuits(areaId));
    }

    @RequestMapping(value = "/getCircuit")
    @ResponseBody
    public void getCircuit(long id)
    {
        responseJson(realTimeService.getCircuit(id));
    }

    @RequestMapping(value = "/getBatteries")
    @ResponseBody
    public void getBatteries(long id)
    {
        responseJson(realTimeService.getBatteries(id));
    }

    @RequestMapping(value = "/getBatteryPackByParams")
    @ResponseBody
    public void getBatteryPackByParams(String paramsJson)
    {
        responseJson(realTimeService.getBatteryPackByParams(paramsJson));
    }
}