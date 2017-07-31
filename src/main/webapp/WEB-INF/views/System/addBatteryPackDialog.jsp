<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>添加电池组</title>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <style>
        .batteryListBtn-td {
            line-height: 18px;
            border: 1px solid #CCCCCC;
            text-align: center;
        }

        .batteryListBtn-td-selected {
            border: 1px solid #2596d2;
            background-color: #2596d2;
        }

        .batteryListBtn-tr {
        }

        .batteryListBtn-a {
            *color: #0000EE;
        }

        .batteryListBtn-a-selected {
            color: #ffffff;
        }

        #battery_div span, #batteryPack_div span, #alarm_div span {
            font-size: 14px;
        }

        .batteryInfo_title {
            margin-top: 5px;
            width: 790px;
            height: 25px;
            line-height: 25px;
            text-align: left;
            float: left;
            color: #999999;
            margin-left: 50px;
            font-size: 15px;
        }

        .batteryList_title {
            width: 100%;
            height: 25px;
            line-height: 25px;
            text-align: left;
            float: left;
            color: #999999;
            font-size: 15px;
        }

        .alarm_title, .batteryPack_title {
            width: 450px;
            height: 25px;
            text-align: left;
            float: left;
            color: #999999;
            font-size: 15px;
        }

        .iptFile-div {
            width: 200px;
            position: relative;
            left: 80px;
            top: 24px;
        }

        .btn0 {
            width: 70px;
            height: 25px;
            background: #2596D2;
            text-align: center;
            color: #ffffff;
        }

        .disabled {
            background-color: #edf5f8;
            color: #ccc;
        }
    </style>
</head>
<body>
<div id="addBatteryPackHtml" style="display: block;overflow: hidden;">
    <div style="width: 460px;height: 945px;float: left;">
        <div id="batteryPack_div" style="width: 450px;height: 230px;float: left;margin-top: 10px;margin-left: 50px;">
            <div class="batteryPack_title" style="margin-bottom: 3px;">
                电池组信息<a style="font-size: 12px;" href="javascript:void(0);" onclick="importSettingConfigDialog(0)">
                导入配置</a>
            </div>
            <div style="width: 450px;height: 30px;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组名称：</span></div>
                <div style="float: left;">
                    <input onchange="batteryPackInputOnChangeEvent(this)" id="batteryPack_name" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
            <div style="width: 450px;height: 30px;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池节数：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="batteryCount" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>(0~300)</span></div>
            </div>
            <div style="width: 450px;height: 30px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组类型：</span></div>
                <div style="float: left;">
                    <input id="type" type="text" style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>V</span></div>
            </div>
            <div style="width: 450px;height: 30px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组容量：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="capacity" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>Ah</span></div>
            </div>
            <div style="width: 450px;height: 30px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>单节电池额定电压：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="voltageRange" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;" value="2"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>V</span></div>
            </div>
            <div style="width: 450px;height: 30px;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>内阻自动检测周期：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="checkCycleTime" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;" value="3600"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>Min</span></div>
            </div>

            <div style="width: 450px;height: 30px;">
                <div style="width: 200px;height: 19px;line-height: 25px;text-align: right;float: left;">
                    <span>特性曲线：</span></div>
                <div style="float: left;margin-top: 2px;">
                    <input id="battery_characteristicCurve" onclick="batteryPackInputOnChangeEvent(this)" type="button"
                           value="导入"
                           style="color: #ffffff;width: 100px;height: 22px;line-height: 22px;background-color: #2397d3"/>
                </div>
            </div>
        </div>

        <div id="alarm_div" style="width: 450px;height: 687px;float: left;margin-top: 0px;margin-left: 50px;">
            <div class="alarm_title">告警阈值</div>
            <div style="width: 450px;height: 80px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组端电压门限：</span></div>
                <div style="float: left;border: 1px solid #999999;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="groupVoltageUp" type="text"
                           style="width: 170px;height: 19px;line-height: 19px;border: none;float: left;"/>
                    <span style="display: block;color: #999999;width: 28px;float: left;line-height: 25px;height: 25px;">高</span>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>V</span></div>
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;"></div>
                <div style="float: left;margin-top:5px;border: 1px solid #999999;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="groupVoltageDown" type="text"
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
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="voltageThresholdUp" type="text"
                           style="width: 170px;height: 19px;line-height: 19px;border: none;float: left;"/>
                    <span style="display: block;color: #999999;width: 28px;float: left;line-height: 25px;height: 25px;">高</span>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>V</span></div>
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;"></div>
                <div style="float: left;margin-top:5px;border: 1px solid #999999;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="voltageThresholdDown" type="text"
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
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="resistanceLevel1" type="text"
                           style="width: 160px;height: 19px;line-height: 19px;border: none;float: left;"/>
                    <span style="display: block;color: #999999;width: 38px;float: left;line-height: 25px;height: 25px;">一级</span>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>%</span></div>
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;"></div>
                <div style="float: left;margin-top:5px;border: 1px solid #999999;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="resistanceLevel2" type="text"
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
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="battery_rippleVoltageLimit"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>%</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池极柱温度：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="temperature" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>℃</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>环境温度门限：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="envirTeaperature" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>℃</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组端电流门限：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="groupCurrentThreshold"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>A</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组纹波电流门限：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="groupRippleCurrent"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>%</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组纹波电压门限：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="groupRippleVoltage"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>%</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池组绝缘泄漏电流门限：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="groupLeakageCurrent"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>mA</span></div>
            </div>

            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>一级温度告警线：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)"
                           id="batteryTeamperatureLevelBaseLine1"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>℃</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>二级温度告警线：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)"
                           id="batteryTeamperatureLevelBaseLine2"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>℃</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>一级电压告警线：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="batteryVoltageLevelBaseLine1"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>V</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>二级电压告警线：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)" id="batteryVoltageLevelBaseLine2"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>V</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>一级内阻告警线：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)"
                           id="batteryResistanceLevelBaseLine1"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>uΩ</span></div>
            </div>
            <div style="width: 450px;height: 32px;float: left;">
                <div style="width: 200px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>二级内阻告警线：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryPackInputOnChangeEvent(this)"
                           id="batteryResistanceLevelBaseLine2"
                           type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>uΩ</span></div>
            </div>
        </div>
    </div>

    <div id="battery_div" style="width: 850px;height: 945px;float: left;">
        <div id="batteryList" style="width: 790px;height: 25px;float: left;margin-top: 10px;margin-left: 50px;">
            <div class="batteryList_title">
                单体电池列表
            </div>
            <div id="batteryListBtnDiv" style="width: 100%;float: left;">
                <table id="batteryListBtn" style="width: 100%;border: 1px solid #c3c3c3;">
                </table>
            </div>
        </div>

        <div class="batteryInfo_title" id="battery_title">
            单体电池基本信息
        </div>
        <div style="width: 400px;height: 285px;float: left;margin-top: 0px;margin-left: 50px;">
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>单体电池名称：</span></div>
                <div style="float: left;">
                    <input onchange="batteryInputOnChangeEvent(this)" id="battery_name" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>生产厂商名称：</span></div>
                <div style="float: left;">
                    <input onchange="batteryInputOnChangeEvent(this)" id="producerName" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>生产日期：</span></div>
                <div style="float: left;">
                    <input id="productionDate" type="text"
                           class="easyui-datetimebox" style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>首次使用日期：</span></div>
                <div style="float: left;">
                    <input id="battery_firstUseDate" type="text"
                           class="easyui-datetimebox" style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>序列号：</span></div>
                <div style="float: left;">
                    <input onchange="batteryInputOnChangeEvent(this)" id="serialNum" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>条形码编号：</span></div>
                <div style="float: left;">
                    <input onchange="batteryInputOnChangeEvent(this)" id="barcode" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>化学组成：</span></div>
                <div style="float: left;">
                    <input id="chemicalComposition" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>单体数量：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="cellNum" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>均充电压：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="equalChargeVolt" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> V</span></div>
            </div>
            <div style="width: 395px;height: 26px;float: left;display: none;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>版本信息：</span></div>
                <div style="float: left;">
                    <input onchange="batteryInputOnChangeEvent(this)" id="battery_version" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
            <div style="width: 395px;height: 26px;float: left;">
                <div style="width: 150px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>是否屏蔽告警：</span></div>
                <div style="float: left;">
                    <input onchange="batteryInputOnChangeEvent(this)" id="isAlarm" type="checkbox"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
            </div>
        </div>

        <div style="width: 390px;height: 285px;float: left;margin-top: 0px;">
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池容量：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="initCapacity" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>Ah</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池规格：</span></div>
                <div style="float: left;">
                    <input id="battery_specifications" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span>(2V/12V)</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>设计浮充寿命：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="floatChargeLife" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> 月</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>设计循环寿命：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="circleLife" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> 次</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>浮充电压：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="floatChargeVolt" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> V</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>容量校准点：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="capacityCheckPoInt32" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> Min</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>典型放电容量：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="virtualCapacity" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> Ah</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>典型放电电流：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="virtualAmp" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> A</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>电池充电效率：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="chargeRate" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/></div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> %</span></div>
            </div>
            <div style="width: 390px;height: 26px;float: left;">
                <div style="width: 120px;height: 19px;line-height: 19px;text-align: right;float: left;">
                    <span>数据刷新周期：</span></div>
                <div style="float: left;">
                    <input test="true" onchange="batteryInputOnChangeEvent(this)" id="schedulingCycle" type="text"
                           style="width: 200px;height: 19px;line-height: 19px;"/>
                </div>
                <div style="width: 25px;height: 19px;line-height: 19px;float: left;">
                    <span> Min</span></div>
            </div>
        </div>
    </div>
</div>
<div style="text-align: center;float:left;width:100%;height: 40px;">
    <input type="button" id="btnSure" value="确定"
           class="btn0"/>
</div>

<div style="display: none;">
    <div id="uploadDialog">
        <div style="width: 200px;left: 80px;top: 24px;">
            <form id="from1" enctype="multipart/form-data"
                  method="post">
                配置文件：<input type="file" name="file1"/>
            </form>
        </div>
    </div>
</div>
<script>
    var parameters = {
        Action: {
            getAlarmDefaultParams: "${_RootPath}/System/getAlarmDefaultParams",
            addGridBatteryPack: "${_RootPath}/System/addBatteryPack"
        },
        batteryPackParams: null,
        arrBattery: null,
        battery: null,
        arrNFNByBatteryPackID: [
            {id: "batteryPack_name", name: "电池组名称"},
            {id: "batteryCount", name: "电池节数"},
            {id: "type", name: "电池组类型"},
            {id: "capacity", name: "电池组容量"},
            {id: "voltageRange", name: "单节电池额定电压"},
            {id: "checkCycleTime", name: "内阻自动检测周期"},
            {id: "battery_characteristicCurve", name: "特性曲线"},
            {id: "groupVoltageUp", name: "电池组端电压上限"},
            {id: "groupVoltageDown", name: "电池组端电压下限"},
            {id: "envirTeaperature", name: "环境温度门限"},
            {id: "groupCurrentThreshold", name: "电池组端电流门限"},
            {id: "groupRippleCurrent", name: "电池组纹波电流门限"},
            {id: "groupRippleVoltage", name: "电池组纹波电压门限"},
            {id: "groupLeakageCurrent", name: "电池组绝缘泄漏电流门限"}
            /*,{id: "batteryTeamperatureLevelBaseLine1", name: "电池温度一级告警线"},
             {id: "batteryTeamperatureLevelBaseLine2", name: "电池温度二级告警线"},
             {id: "batteryVoltageLevelBaseLine1", name: "电池电压一级告警线"},
             {id: "batteryVoltageLevelBaseLine2", name: "电池电压二级告警线"},
             {id: "batteryResistanceLevelBaseLine1", name: "电池内阻一级告警线"},
             {id: "batteryResistanceLevelBaseLine2", name: "电池内阻二级告警线"}*/],
        arrNFNByBatteryID: [
            /*{id: "battery_name", name: "单体电池名称"},
             {id: "producerName", name: "生产厂商名称"},
             {id: "productionDate", name: "生产日期"},
             {id: "battery_firstUseDate", name: "首次使用日期"},
             {id: "serialNum", name: "序列号"},
             {id: "barcode", name: "条形码编号"},*/
            {id: "chemicalComposition", name: "化学组成"},
            {id: "cellNum", name: "单体数量"},
            /*{id: "battery_version", name: "版本信息"},*/
            {id: "initCapacity", name: "电池容量"},
            {id: "battery_specifications", name: "电池规格"},
            /* {id: "floatChargeLife", name: "设计浮充寿命"},
             {id: "circleLife", name: "设计循环寿命"},
             {id: "floatChargeVolt", name: "浮充电压"},
             {id: "equalChargeVolt", name: "均充电压"},
             {id: "capacityCheckPoInt32", name: "容量校准点"},
             {id: "virtualCapacity", name: "典型放电容量"},
             {id: "virtualAmp", name: "典型放电电流"},
             {id: "chargeRate", name: "电池充电效率"},
             {id: "schedulingCycle", name: "数据刷新周期"}*/
            {id: "voltageThresholdUp", name: "单体电池电压上限"},
            {id: "voltageThresholdDown", name: "单体电池电压下限"},
            {id: "resistanceLevel1", name: "单体内阻上限"},
            {id: "resistanceLevel2", name: "单体内阻下限"},
            {id: "battery_rippleVoltageLimit", name: "单体纹波电压门限"},
            {id: "temperature", name: "电池极柱温度"}],
        arrDefaultByBatteryPackID: [
            {id: "batteryPack_name"},
            {id: "batteryCount"},
            {id: "type"},
            {id: "capacity"},
            {id: "voltageRange"},
            {id: "checkCycleTime"},
            {id: "battery_characteristicCurve"},
            {id: "groupVoltageUp"},
            {id: "groupVoltageDown"},
            {id: "envirTeaperature"},
            {id: "groupCurrentThreshold"},
            {id: "groupRippleCurrent"},
            {id: "groupRippleVoltage"},
            {id: "groupLeakageCurrent"},
            {id: "batteryTeamperatureLevelBaseLine1"},
            {id: "batteryTeamperatureLevelBaseLine2"},
            {id: "batteryVoltageLevelBaseLine1"},
            {id: "batteryVoltageLevelBaseLine2"},
            {id: "batteryResistanceLevelBaseLine1"},
            {id: "batteryResistanceLevelBaseLine2"}],
        arrDefaultByBatteryID: [
            {id: "battery_name"},
            {id: "producerName"},
            {id: "productionDate"},
            {id: "battery_firstUseDate"},
            {id: "serialNum"},
            {id: "barcode"},
            {id: "chemicalComposition"},
            {id: "cellNum"},
            //{id: "battery_version"},
            {id: "initCapacity"},
            {id: "battery_specifications"},
            {id: "floatChargeLife"},
            {id: "circleLife"},
            {id: "floatChargeVolt"},
            {id: "equalChargeVolt"},
            {id: "capacityCheckPoInt32"},
            {id: "virtualCapacity"},
            {id: "virtualAmp"},
            {id: "chargeRate"},
            {id: "schedulingCycle"},
            {id: "voltageThresholdUp"},
            {id: "voltageThresholdDown"},
            {id: "resistanceLevel1"},
            {id: "resistanceLevel2"},
            {id: "battery_rippleVoltageLimit"},
            {id: "temperature"}]
    };

    // 电池组信息改变事件
    function batteryPackInputOnChangeEvent(obj) {

        if ($(obj).attr("test")) {
            if (Business.Misc.validateNumber(obj.value)) {
                if (obj.id === "batteryCount") {
                    var count = parseInt(obj.value);
                    if (count >= 0 && count <= 300) {
                        if (count > 0) {
                            setDefaultBatteryInfo(count);

                            createBatteyTableBtn(count < 60 ? 60 : count);
                            setBatteryCssAndEvent(count);
                            seletedBattery(1, count);
                        }
                    } else {
                        XspWeb.Misc.Tips("电池节数有误");
                        $("#" + obj.id).val("");
                        return;
                    }
                }

                parameters.batteryPackParams[obj.id] = obj.value;
            } else {
                $("#" + obj.id).val("");
                XspWeb.Misc.Tips("输入有误");
            }
        }
        else {
            if (obj.id === "battery_characteristicCurve") {
                importCharacteristicCurveDialog(obj.id);
                return;
            }

            parameters.batteryPackParams[obj.id] = obj.value;
        }
    }

    // 单体信息输入验证
    function batteryInputValidation(obj) {
        // 电池名称 厂家名称 --- 字符长度验证
        if ((obj.id === "battery_name") || (obj.id === "producerName")) {
            if (obj.value.length > 64) {
                XspWeb.Misc.Tips("输入长度有误,请重新输入");
                $("#" + obj.id).val("");
                return false;
            }
        }
        // 序列号和条形码编号最长32字符
        else if ((obj.id === "serialNum") || (obj.id === "barcode")) {
            if (obj.value.length > 32) {
                XspWeb.Misc.Tips("输入长度有误,请重新输入");
                $("#" + obj.id).val("");
                return false;
            }
        }
        // 电池容量：0~65535Ah;浮充寿命(0~65535月)和循环寿命（0~65535次）
        else if ((obj.id === "initCapacity") ||
                (obj.id === "floatChargeLife") ||
                (obj.id === "circleLife")) {
            if (obj.value < 0 || obj.value > 655535) {
                XspWeb.Misc.Tips("输入有误,请重新输入");
                $("#" + obj.id).val("");
                return false;
            }
        }
        // 正确或不需要验证
        return true;
    }

    // 单体信息改变事件
    function batteryInputOnChangeEvent(obj) {
        if ((parameters.battery) && (batteryInputValidation(obj))) {
            if (obj.id === "isAlarm") {
                parameters.battery[obj.id] = obj.checked;
            }
            else if ($(obj).attr("test")) {
                if (obj.id === "floatChargeVolt"
                        || obj.id === "equalChargeVolt"
                        || obj.id === "capacityCheckPoInt32"
                        || obj.id === "virtualCapacity"
                        || obj.id === "virtualAmp") {

                    if (Business.Misc.validateFloatNumber(obj.value)) {
                        var value = parseFloat(obj.value);
                        parameters.battery[obj.id] = value.toFixed(2);
                        $("#" + obj.id).val(value.toFixed(2));
                    } else {
                        $("#" + obj.id).val("");
                        XspWeb.Misc.Tips("输入有误");
                    }

                } else {

                    if (Business.Misc.validateFloatNumber(obj.value)) {
                        parameters.battery[obj.id] = obj.value;
                    } else {
                        $("#" + obj.id).val("");
                        XspWeb.Misc.Tips("输入有误");
                    }
                }
            }
            else {
                parameters.battery[obj.id] = obj.value;
            }
        }
    }

    // 电池组类型下拉框
    function batteryPackCombobox() {
        var data = [{"value": "0", "text": "2V"}, {"value": "1", "text": "12V"}];
        $("#type").combobox({
            data: data,
            textField: "text",
            valueField: "value",
            editable: false,
            onSelect: function (record) {
                if (record)
                    parameters.batteryPackParams.type = record.value;
            }
        });
    }

    // 单体规格下拉框
    function batteryCombobox() {
        var data = [{"value": "0", "text": "2V"}, {"value": "1", "text": "12V"}];
        $("#battery_specifications").combobox({
            data: data,
            textField: "text",
            valueField: "value",
            editable: false,
            onSelect: function (record) {
                if (record && parameters.battery) {
                    parameters.battery.battery_specifications = record.value;
                }
            }
        });
    }

    // 化学组成下拉框
    function initChemicalComposition() {
        var data = [{"value": "BattTypeLithium", "text": "锂电池"},
            {"value": "BattTypeNicad", "text": "镍铬电池"},
            {"value": "BattTypeLeadacid", "text": "铅酸电池"}];
        $("#chemicalComposition").combobox({
            data: data,
            textField: "text",
            valueField: "value",
            editable: false,
            onSelect: function (record) {
                if (record && parameters.battery) {
                    parameters.battery.chemicalComposition = record.value;
                }
            }
        });
    }

    // 初始化日期控件
    function initDateTimeBox() {
        $("#productionDate").datetimebox({
            onChange: function (value) {
                if (parameters.battery) {
                    parameters.battery.productionDate = value;
                }
            }
        });

        $("#battery_firstUseDate").datetimebox({
            onChange: function (value) {
                if (parameters.battery) {
                    parameters.battery.battery_firstUseDate = value;
                }
            }
        });
    }

    // 生成按钮列表
    function createBatteyTableBtn(count) {
        $("#batteryListBtn").html("");

        var rows = Math.ceil(count / 20);
        $("#batteryListBtn").attr("style", "height:" + rows * 24 + "px;width:100%;border: 1px solid #c3c3c3;");
        $("#batteryListBtnDiv").attr("style", "height:" + rows * 24 + "px;width:100%;float: left;");
        $("#batteryList").attr("style", "width: 90%;height: " + (rows * 24 + 25) + "px;float: left;margin-top: 10px;margin-left: 50px;");

        for (var i = 1; i <= rows; i++) {
            var btnBatteryListTable_tr = VElement("tr", {"id": "tr_" + i});
            $("#batteryListBtn").append(btnBatteryListTable_tr.render());

            for (var j = (i - 1) * 20 + 1; j <= i * 20; j++) {
                var btnBatteryListTable_td = VElement("td", {"id": "td_" + j, "class": "batteryListBtn-td"});
                $("#tr_" + i).append(btnBatteryListTable_td.render());
                $("#td_" + j).html("XX");
            }
        }
    }

    // 设置单体按钮样式和事件
    function setBatteryCssAndEvent(count) {
        for (var i = 1; i <= count; i++) {
            var batteryListTable_a = VElement("a", {
                "id": "a_" + i,
                "href": "javascript:void(0);",
                "class": "batteryListBtn-a",
                "onclick": "seletedBattery(" + i + "," + count + ")",
            });
            $("#td_" + i).html("");
            $("#td_" + i).append(batteryListTable_a.render());
            $("#a_" + i).html(i);

        }
        for (var j = count + 1; j <= 300; j++) {
            $("#td_" + j).html("XX");
        }
    }

    // 选中j单体
    function seletedBattery(j, count) {
        $("#battery_title").html(j + "号电池信息  " +
                '<a style="font-size: 12px;" href="javascript:void(0);" ' +
                'onclick="importSettingConfigDialog(' + j + ')">导入配置</a>');

        for (var k = 1; k <= count; k++) {
            $("#td_" + k).removeClass("batteryListBtn-td-selected");
            $("#a_" + k).removeClass("batteryListBtn-a-selected");
        }
        $("#td_" + j).addClass("batteryListBtn-td-selected");
        $("#a_" + j).addClass("batteryListBtn-a-selected");
        parameters.battery = parameters.arrBattery[j - 1];
        setBatteryInputVal(parameters.battery);
    }

    // 设置单体默认信息
    function setDefaultBatteryInfo(count) {

        if (parameters.arrBattery) {
            var len = parameters.arrBattery.length;
            if (len >= count) {
                for (var i = count; i < len; i++) {
                    parameters.arrBattery.pop();
                }
            }
            else {
                var arrTemp = new Array(count);
                for (var i = 0; i < len; i++) {
                    arrTemp[i] = parameters.arrBattery[i];
                }
                parameters.arrBattery = arrTemp;
                for (var i = len; i < count; i++) {
                    parameters.arrBattery[i] = {};
                    parameters.arrBattery[i].no = i + 1;
                    parameters.arrBattery[i].isAlarm = false;
                    for (var j = 0; j < parameters.arrDefaultByBatteryID.length; j++) {
                        var objBattery = parameters.arrDefaultByBatteryID[j];
                        parameters.arrBattery[i][objBattery.id] = null;
                    }
                }
            }
        } else {
            parameters.arrBattery = new Array(count);
            for (var i = 0; i < count; i++) {
                parameters.arrBattery[i] = {};
                parameters.arrBattery[i].no = i + 1;
                parameters.arrBattery[i].isAlarm = false;
                for (var j = 0; j < parameters.arrDefaultByBatteryID.length; j++) {
                    var objBattery = parameters.arrDefaultByBatteryID[j];
                    parameters.arrBattery[i][objBattery.id] = null;
                }
            }
        }

    }

    // 设置电池组默认信息
    function setDefaultBatteryPackInfo() {
        parameters.batteryPackParams = {};
        for (var i = 0; i < parameters.arrDefaultByBatteryPackID.length; i++) {
            var id = parameters.arrDefaultByBatteryPackID[i].id;
            if (id === "battery_characteristicCurve") {
                parameters.batteryPackParams[id] = null;
            }
            else if (id === "type") {
                parameters.batteryPackParams[id] = $("#" + id).combobox('getValue');
            }
            else {
                parameters.batteryPackParams[id] = $("#" + id).val();
            }
        }
    }

    // 设置电池组输入框的值
    function setBatteryPackInputVal() {
        if (parameters.batteryPackParams) {
            for (var i = 0; i < parameters.arrDefaultByBatteryPackID.length; i++) {
                var id = parameters.arrDefaultByBatteryPackID[i].id;
                if (id === "type") {
                    $("#" + id).combobox('select', parameters.batteryPackParams[id]);
                }
                else if (id !== "battery_characteristicCurve") {
                    $("#" + id).val(parameters.batteryPackParams[id]);
                }
            }
        }
    }

    // 设置单体输入框的值
    function setBatteryInputVal(battery) {
        if (battery) {
            $("#battery_name").val(battery.battery_name);
            $("#producerName").val(battery.producerName);
            $("#productionDate").datetimebox('setValue', battery.productionDate);
            $("#battery_firstUseDate").datetimebox('setValue', battery.battery_firstUseDate);
            $("#serialNum").val(battery.serialNum);
            $("#barcode").val(battery.barcode);
            $("#chemicalComposition").combobox('setValue', battery.chemicalComposition);
            $("#cellNum").val(battery.cellNum);
            //$("#battery_version").val(battery.battery_version);
            $("#initCapacity").val(battery.initCapacity);
            $("#battery_specifications").combobox('select', battery.battery_specifications);
            $("#floatChargeLife").val(battery.floatChargeLife);
            $("#circleLife").val(battery.circleLife);
            $("#floatChargeVolt").val(battery.floatChargeVolt);
            $("#equalChargeVolt").val(battery.equalChargeVolt);
            $("#capacityCheckPoInt32").val(battery.capacityCheckPoInt32);
            $("#virtualCapacity").val(battery.virtualCapacity);
            $("#virtualAmp").val(battery.virtualAmp);
            $("#chargeRate").val(battery.chargeRate);
            $("#schedulingCycle").val(battery.schedulingCycle);
            $("#isAlarm").attr("checked", battery.isAlarm ? true : false);
            $("#voltageThresholdUp").val(battery.voltageThresholdUp);
            $("#voltageThresholdDown").val(battery.voltageThresholdDown);
            $("#resistanceLevel1").val(battery.resistanceLevel1);
            $("#resistanceLevel2").val(battery.resistanceLevel2);
            $("#battery_rippleVoltageLimit").val(battery.battery_rippleVoltageLimit);
            $("#temperature").val(battery.temperature);
        }
    }

    // 设置告警阈值参数默认值
    function initAlarmThreshold() {
        if (!parameters.batteryPackParams)
            parameters.batteryPackParams = {};

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
                            for (var j = 0; j < parameters.arrDefaultByBatteryPackID.length; j++) {
                                if (parameters.arrDefaultByBatteryPackID[j].id === data[i].name) {
                                    parameters.batteryPackParams[data[i].name] = data[i].value;
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    // 导入配置文件Dialog（batteryNo:单体编号 等于0导入电池组配置，大于0导入该单体配置）
    function importSettingConfigDialog(batteryNo) {
        var obj = $("#uploadDialog");
        XspWeb.Misc.Dialog(obj, {
            title: "导入",
            width: 400,
            height: 150,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "确定",
                handler: function () {
                    importSettingConfigAjax(batteryNo);
                }
            }]
        });
    }

    // 导入配置文件
    function importSettingConfigAjax(batteryNo) {
        var url = '${_RootPath}/System/importBatterySettingConfig'
        if (!batteryNo && batteryNo == 0) {
            url = '${_RootPath}/System/importBatteryPackSettingConfig';
        }
        var formData = new FormData($("#from1")[0]);
        $.ajax({
            url: url,
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (rec) {
                if (rec) {
                    /* 单体配置 */
                    if (batteryNo) {
                        // 设置单体信息
                        parameters.arrBattery[batteryNo - 1] = rec.batteryParamList[0];
                        parameters.battery = parameters.arrBattery[batteryNo - 1];
                        setBatteryInputVal(parameters.battery);
                    }
                    /* 电池组配置 */
                    else {
                        // 设置电池组信息
                        parameters.batteryPackParams = rec.batteryPackParams;
                        setBatteryPackInputVal();

                        // 设置单体信息
                        parameters.arrBattery = rec.batteryParamList;

                        var count = rec.batteryPackParams.batteryCount;
                        createBatteyTableBtn(count < 60 ? 60 : count);
                        setBatteryCssAndEvent(count);
                        seletedBattery(1, count);
                    }
                    $("#uploadDialog").dialog('close');
                }
            }
        });
    }

    // 导入特性曲线Dialog ---id 电池组属性id
    function importCharacteristicCurveDialog(id) {
        XspWeb.Misc.Dialog($("#uploadDialog"), {
            title: "导入",
            width: 400,
            height: 150,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "确定",
                handler: function () {
                    importCharacteristicCurveAjax(id);
                }
            }]
        });
    }

    // 导入特性曲线 ---id：单体编号
    function importCharacteristicCurveAjax(id) {
        var url = '${_RootPath}/System/importCharacteristicCurve';
        var formData = new FormData($("#from1")[0]);
        $.ajax({
            url: url,
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (rec) {
                if (rec) {
                    parameters.batteryPackParams[id] = rec;
                    $("#uploadDialog").dialog('close');
                }
            }
        });
    }

    // 判断电池组参数完整性
    function isNFNByBatteryPackID() {
        for (var i = 0; i < parameters.arrNFNByBatteryPackID.length; i++) {
            var obj = parameters.arrNFNByBatteryPackID[i];
            if ((!parameters.batteryPackParams[obj.id]) || (parameters.batteryPackParams[obj.id] === "")) {
                return obj.name + "是必填项不可为空！";
            }
        }
        return null;
    }

    // 判断单体参数完整性
    function isNFNByBatteryID() {
        if (parameters.arrBattery && parameters.arrBattery.length > 0) {
            for (var j = 0; j < parameters.arrBattery.length; j++) {
                var batteryObj = parameters.arrBattery[j];
                for (var i = 0; i < parameters.arrNFNByBatteryID.length; i++) {
                    var obj = parameters.arrNFNByBatteryID[i];
                    if ((!batteryObj[obj.id]) || (batteryObj[obj.id] === "")) {
                        return batteryObj.no + "号电池信息不完整：" + obj.name + "不可为空！";
                    }
                }
            }
            return null;
        }
        return null;
    }

    // 添加电池组
    function addBatteryPack() {
        var isNull = isNFNByBatteryPackID();
        if (isNull) {
            XspWeb.Misc.Tips(isNull);
            return;
        }
        isNull = isNFNByBatteryID();
        if (isNull) {
            XspWeb.Misc.Tips(isNull);
            return;
        }

        var arrBatteryJson = JSON.stringify(parameters.arrBattery);
        var batteryPackParamsJson = JSON.stringify(parameters.batteryPackParams);
        $("#btnSure").attr("disabled", "disabled");
        $("#btnSure").addClass("disabled");
        XspWeb.Misc.Ajax({
            action: parameters.Action.addGridBatteryPack,
            data: {
                arrBatteryJson: arrBatteryJson,
                batteryPackParamsJson: batteryPackParamsJson
            },
            success: function (rec) {
                if (rec.code === 0) {
                    XspWeb.Misc.Tips(rec.message);
                    if (typeof XspWeb.Controls.Dialog.Callbacks.addBatteryGroupSuccess === "function")
                        XspWeb.Controls.Dialog.Callbacks.addBatteryGroupSuccess();
                } else {
                    XspWeb.Misc.Tips(rec.message);
                }
                $("#btnSure").removeClass("disabled");
                $("#btnSure").removeAttr("disabled");
            }
        });
    }

    // 绑定按钮事件
    function bindBtnEvent() {
        $("#btnSure").click(addBatteryPack);
    }

    $(function () {
        batteryPackCombobox();
        batteryCombobox();
        initChemicalComposition();
        initDateTimeBox();
        initAlarmThreshold();

        setDefaultBatteryPackInfo();
        createBatteyTableBtn(60);
        bindBtnEvent();
    })
</script>
</body>
</html>