<%--
  Created by IntelliJ IDEA.
  User: Linyudui
  Date: 2016/7/21
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>告警阈值设置</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>

</head>
<body id="layout_main" class="easyui-layout minheightwidth" data-options="fit:true">
<style type="text/css">
    #alarmThreshold {
        width: 100%;
        height: 100%;
        background-color: #FFFFFF;
        overflow: auto;
    }
</style>
<div id="alarmThreshold">
    <div>
        <input id="btnSure" type="button" value="保存"
               style="margin: 10px 0 0 10px;width: 100px;height: 40px;border-radius: 10px;background-color: #2693ce;color: #fff"/>
    </div>
    <div id="alarm_div" style="width: 450px;height: 495px;float: left;margin-top: 30px;margin-left: 100px;">
        <div style="width: 450px;height: 80px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>电池组端电压门限：</span></div>
            <div style="float: left;border: 1px solid #999999;">
                <input onchange="inputOnChangeEvent(this)" id="groupVoltageUp" type="text"
                       style="width: 170px;height: 19px;line-height: 19px;border: none;float: left;"/>
                <span style="display: block;color: #999999;width: 28px;float: left;line-height: 25px;height: 25px;">高</span>
            </div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>V</span></div>
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;"></div>
            <div style="float: left;margin-top:5px;border: 1px solid #999999;">
                <input onchange="inputOnChangeEvent(this)" id="groupVoltageDown" type="text"
                       style="width: 170px;height: 19px;line-height: 19px;border: none;float: left;"/>
                <span style="display: block;color: #999999;width: 28px;float: left;line-height: 25px;height: 25px;">低</span>
            </div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>V</span></div>
        </div>
        <div style="width: 450px;height: 80px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>单体电池电压门限：</span></div>
            <div style="float: left;border: 1px solid #999999;">
                <input onchange="inputOnChangeEvent(this)" id="voltageThresholdUp" type="text"
                       style="width: 170px;height: 19px;line-height: 19px;border: none;float: left;"/>
                <span style="display: block;color: #999999;width: 28px;float: left;line-height: 25px;height: 25px;">高</span>
            </div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>V</span></div>
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;"></div>
            <div style="float: left;margin-top:5px;border: 1px solid #999999;">
                <input onchange="inputOnChangeEvent(this)" id="voltageThresholdDown" type="text"
                       style="width: 170px;height: 19px;line-height: 19px;border: none;float: left;"/>
                <span style="display: block;color: #999999;width: 28px;float: left;line-height: 25px;height: 25px;">低</span>
            </div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>V</span></div>
        </div>
        <div style="width: 450px;height: 80px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>单体内阻门限：</span></div>
            <div style="float: left;border: 1px solid #999999;">
                <input onchange="inputOnChangeEvent(this)" id="resistanceLevel1" type="text"
                       style="width: 160px;height: 19px;line-height: 19px;border: none;float: left;"/>
                <span style="display: block;color: #999999;width: 38px;float: left;line-height: 25px;height: 25px;">一级</span>
            </div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>%</span></div>
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;"></div>
            <div style="float: left;margin-top:5px;border: 1px solid #999999;">
                <input onchange="inputOnChangeEvent(this)" id="resistanceLevel2" type="text"
                       style="width: 160px;height: 19px;line-height: 19px;border: none;float: left;"/>
                <span style="display: block;color: #999999;width: 38px;float: left;line-height: 25px;height: 25px;">二级</span>
            </div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>%</span></div>
        </div>
        <div style="width: 450px;height: 32px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>单体纹波电压门限：</span></div>
            <div style="float: left;">
                <input onchange="inputOnChangeEvent(this)" id="battery_rippleVoltageLimit" type="text"
                       style="width: 200px;height: 19px;line-height: 19px;"/></div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>%</span></div>
        </div>
        <div style="width: 450px;height: 32px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>单体极柱温度：</span></div>
            <div style="float: left;">
                <input onchange="inputOnChangeEvent(this)" id="temperature" type="text"
                       style="width: 200px;height: 19px;line-height: 19px;"/></div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>°C</span></div>
        </div>
        <div style="width: 450px;height: 32px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>环境温度门限：</span></div>
            <div style="float: left;">
                <input onchange="inputOnChangeEvent(this)" id="envirTeaperature" type="text"
                       style="width: 200px;height: 19px;line-height: 19px;"/></div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>°C</span></div>
        </div>
        <div style="width: 450px;height: 32px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>电池组端电流门限：</span></div>
            <div style="float: left;">
                <input onchange="inputOnChangeEvent(this)" id="groupCurrentThreshold" type="text"
                       style="width: 200px;height: 19px;line-height: 19px;"/></div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>A</span></div>
        </div>
        <div style="width: 450px;height: 32px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>电池组纹波电流门限：</span></div>
            <div style="float: left;">
                <input onchange="inputOnChangeEvent(this)" id="groupRippleCurrent" type="text"
                       style="width: 200px;height: 19px;line-height: 19px;"/></div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>%</span></div>
        </div>
        <div style="width: 450px;height: 32px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>电池组纹波电压门限：</span></div>
            <div style="float: left;">
                <input onchange="inputOnChangeEvent(this)" id="groupRippleVoltage" type="text"
                       style="width: 200px;height: 19px;line-height: 19px;"/></div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>%</span></div>
        </div>
        <div style="width: 450px;height: 32px;float: left;">
            <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                <span>电池组绝缘泄漏电流门限：</span></div>
            <div style="float: left;">
                <input onchange="inputOnChangeEvent(this)" id="groupLeakageCurrent"
                       type="text"
                       style="width: 200px;height: 19px;line-height: 19px;"/></div>
            <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                <span>mA</span></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var parameters = {
        Action: {
            getAlarmDefaultParams: "${_RootPath}/System/getAlarmDefaultParams",
            updateAlarmDefaultParams: "${_RootPath}/System/updateAlarmDefaultParams"
        },
        defaultAlarmParams: null,
        arrNFNByAlarmID: [
            {id: "groupVoltageUp", name: "电池组端电压上限"},
            {id: "groupVoltageDown", name: "电池组端电压下限"},
            {id: "envirTeaperature", name: "环境温度门限"},
            {id: "groupCurrentThreshold", name: "电池组端电流门限"},
            {id: "groupRippleCurrent", name: "电池组纹波电流门限"},
            {id: "groupRippleVoltage", name: "电池组纹波电压门限"},
            {id: "groupLeakageCurrent", name: "电池组绝缘泄漏电流门限"},
            {id: "voltageThresholdUp", name: "单体电池电压上限"},
            {id: "voltageThresholdDown", name: "单体电池电压下限"},
            {id: "resistanceLevel1", name: "单体内阻上限"},
            {id: "resistanceLevel2", name: "单体内阻下限"},
            {id: "battery_rippleVoltageLimit", name: "单体纹波电压门限"},
            {id: "temperature", name: "单体极柱温度"}
        ]
    }

    function inputOnChangeEvent(obj) {
        parameters.defaultAlarmParams[obj.id] = obj.value;
    }

    function initAlarmThreshold() {
        parameters.defaultAlarmParams = {};
        XspWeb.Misc.Ajax({
            action: parameters.Action.getAlarmDefaultParams,
            success: function (rec) {
                if (rec.code === 0) {
                    var data = rec.data;
                    if (data) {
                        for (var i = 0; i < data.length; i++) {
                            var objInput = $("#" + data[i].name);
                            if (objInput) {
                                objInput.val(data[i].value);
                            }
                            parameters.defaultAlarmParams[data[i].name] = data[i].value;
                        }
                    }
                }
            }
        });
    }

    function isNFNByAlarmID() {
        for (var i = 0; i < parameters.arrNFNByAlarmID.length; i++) {
            var obj = parameters.arrNFNByAlarmID[i];
            if ((!parameters.defaultAlarmParams[obj.id]) || (parameters.defaultAlarmParams[obj.id] === "")) {
                return obj.name + "是必填项不可为空！";
            }
        }
        return null;
    }

    function initBtnSureEvent() {
        $("#btnSure").click(function () {
            var isNull = isNFNByAlarmID();
            if (isNull) {
                XspWeb.Misc.Tips(isNull);
                return;
            }

            var defultAlarmParamsJson = JSON.stringify(parameters.defaultAlarmParams)
            XspWeb.Misc.Ajax({
                action: parameters.Action.updateAlarmDefaultParams,
                data: {
                    defultAlarmParamsJson: defultAlarmParamsJson
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                }
            });
        });
    }

    $(function () {
        initAlarmThreshold();
        initBtnSureEvent();
    })
</script>
</body>
</html>