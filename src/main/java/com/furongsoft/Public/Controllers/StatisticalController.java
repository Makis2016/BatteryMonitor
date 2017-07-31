package com.furongsoft.Public.Controllers;

import com.furongsoft.Public.Services.StatisticalService;
import com.furongsoft.XspWeb.Common.BaseController;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.Utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/21.
 */
@Controller
@RequestMapping("Statistical")
public class StatisticalController extends BaseController
{
    @Autowired
    public StatisticalService statisticalService;

    @RequestMapping("getBatteryPackMonthReport")
    @ResponseBody
    public void getBatteryPackMonthReport(String paramsJson)
    {
        responseJson(statisticalService.getBatteryPackMonthReport(paramsJson));
    }

    @RequestMapping("downloadBatteryPackMonthReport")
    public void downloadBatteryPackMonthReport(String dateSourceJson, HttpServletResponse response)
    {
        try {
            statisticalService.downloadBatteryPackMonthReport(dateSourceJson, response);
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    @RequestMapping("getBatteryPackHisReport")
    @ResponseBody
    public void getBatteryPackHisReport(int page, int rows, String paramsJson)
    {
        String data = statisticalService.getBatteryPackHisReport(page, rows, paramsJson);
        responseJson(data);
    }

    @RequestMapping("getBatteryByBatteryPackId")
    @ResponseBody
    public void getBatteryByBatteryPackId(Long id)
    {
        String str = statisticalService.getBatteryByBatteryPackId(id);
        if(StringUtils.isNullOrEmpty(str))
            str = "";
        responseJson(str);
    }

    @RequestMapping(value = "downloadBatteryPackHisReport", method = RequestMethod.POST)
    public void downloadBatteryPackHisReport(String paramsJson, String dataColumnJson, HttpServletResponse response)
    {
        try {
            statisticalService.downloadBatteryPackHisReport(paramsJson, dataColumnJson, response);
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    @RequestMapping("downloadHisAlarmReport")
    public void downloadHisAlarmReport(String paramsJson, String dateSourceJson, HttpServletResponse response)
    {
        try {
            statisticalService.downloadHisAlarmReport(paramsJson, dateSourceJson, response);
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }
}