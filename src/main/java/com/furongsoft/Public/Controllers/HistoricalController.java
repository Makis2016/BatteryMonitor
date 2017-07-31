package com.furongsoft.Public.Controllers;

import com.furongsoft.Public.Services.HistoricalService;
import com.furongsoft.XspWeb.Common.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/8/10.
 */
@Controller
@RequestMapping("/Historical")
@SessionAttributes("user")
public class HistoricalController extends BaseController
{
    @Autowired
    public HistoricalService historicalService;

    @RequestMapping(value = "/Data")
    @RequiresPermissions("lishishuju:show")
    public ModelAndView historicalData()
    {
        return makeModelAndView("Historical/data");
    }

    @RequestMapping(value = "/batteryGroupData")
    public ModelAndView batteryGroupData()
    {
        return makeModelAndView("Historical/batteryPackData");
    }

    @RequestMapping(value = "/alarmData")
    public ModelAndView alarmData()
    {
        return makeModelAndView("Historical/alarmData");
    }

    @RequestMapping(value = "/getAlarmByParams")
    @ResponseBody
    public void getAlarmByParams(int page, int rows, String paramsJson)
    {
        responseJson(historicalService.getAlarmByParams(page,rows,paramsJson));
    }

    @RequestMapping(value = "/getBatteryPackByParams")
    @ResponseBody
    public void getBatteryPackByParams(int page, int rows, String paramsJson)
    {
        responseJson(historicalService.getBatteryPackByParams(page, rows, paramsJson));
    }
}