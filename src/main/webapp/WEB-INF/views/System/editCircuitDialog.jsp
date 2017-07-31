<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>添加回路</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <style>
        .sjfd-span-a {
            width: 120px;
            height: 30px;
            line-height: 30px;
            display: block;
            float: left;
            text-align: right;
            font-size: 14px;
        }

        .sjfd-span-b {
            width: 120px;
            height: 30px;
            line-height: 30px;
            display: block;
            float: left;
            text-align: right;
            font-size: 14px;
        }

        .btn0 {
            width: 70px;
            height: 25px;
            background-color: #2596D2;
            text-align: center;
            color: #ffffff;
        }

        .btn1 {
            height: 30px;
            line-height: 30px;
            background-color: #2596d2;
            color: #ffffff;
        }

        .disabled {
            background-color: #edf5f8;
            color: #ccc;
        }
    </style>
</head>
<body>
<div id="addGroupHtml" style="display: block">
    <div style="height: 70px;width: 800px;display: block;float: left">
        <div style="float: left"><span
                style="width: 80px;height: 30px;line-height: 30px;display: block;float:left;font-size: 15px;font-weight: bold;margin: 30px 0 0 60px;">
                    回路名称：
                </span>
            <input id="circuitName" type="text" class="easyui-textbox"
                   style="width:220px;display: block;height: 25px;line-height: 25px;float: left;margin: 28px 0 0 0;"/>
        </div>
        <div id="areaHtml" style="display: block;float: right;">
            <div style="margin: 28px 0 0 0;">
                <span style="font-size: 14px;height: 30px;line-height: 30px;">所在区域：</span>
                <select id="point_1" class="easyui-combobox" style="width: 60px;"></select>
                <select id="point_2" class="easyui-combobox" style="width: 80px;"></select>
                <select id="point_3" class="easyui-combobox" style="width: 120px;"></select>
            </div>
        </div>
    </div>
    <div style="height: 435px;width: 400px;display: block;float: left">
        <div style="width: 100%; height: 35px;">
            <div class="sjfd-span-a" style="width: 130px;color: #999999">数据分度设置</div>
            <div class="sjfd-span-a" style="text-align: right;width: 80px;">单体电压:</div>
            <div class="sjfd-span-a">
                <select id="batteryV"
                        class="easyui-combobox"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-a" style="width: 40px;text-align: center">mV
            </div>
        </div>
        <div style="width: 100%; height: 35px;">
            <div class="sjfd-span-b" style="width: 210px;">单体内阻:</div>
            <div class="sjfd-span-b">
                <select class="easyui-combobox" id="batteryR"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-b"
                 style="width: 40px;text-align: center">uΩ
            </div>
        </div>
        <div style="width: 100%;height: 35px;">
            <div class="sjfd-span-b" style="width: 210px;">单体极柱温度:</div>
            <div class="sjfd-span-b">
                <select class="easyui-combobox" id="batteryJZT"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-b"
                 style="width: 40px;text-align: center">℃
            </div>
        </div>
        <div style="width: 100%;height: 35px;">
            <div class="sjfd-span-b" style="width: 210px;">组端电压:</div>
            <div class="sjfd-span-b">
                <select class="easyui-combobox" id="groupV"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-b"
                 style="width: 40px;text-align: center">mV
            </div>
        </div>
        <div style="width: 100%;height: 35px;">
            <div class="sjfd-span-b" style="width: 210px;">组端电流:</div>
            <div class="sjfd-span-b">
                <select class="easyui-combobox" id="groupA"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-b"
                 style="width: 40px;text-align: center">mA
            </div>
        </div>
        <div style="width: 100%;height: 35px;">
            <div class="sjfd-span-b" style="width: 210px;">组端环境温度:</div>
            <div class="sjfd-span-b">
                <select class="easyui-combobox" id="groupHJT"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-b"
                 style="width: 40px;text-align: center">℃
            </div>
        </div>
        <div style="width: 100%;height: 35px;">
            <div class="sjfd-span-b" style="width: 210px;">组端纹波电压:</div>
            <div class="sjfd-span-b">
                <select class="easyui-combobox" id="groupBWV"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-b"
                 style="width: 40px;text-align: center">mV
            </div>
        </div>
        <div style="width: 100%;height: 35px;">
            <div class="sjfd-span-b" style="width: 210px;">组端绝缘泄露电流:</div>
            <div class="sjfd-span-b">
                <select class="easyui-combobox" id="groupJUXLA"
                        style="width: 100px;height: 30px;line-height: 30px;display: block;float: left;"></select>
            </div>
            <div class="sjfd-span-b"
                 style="width: 40px;text-align: center">mA
            </div>
        </div>
    </div>
    <div style="height: 435px;width: 380px;display: block;float: left">
        <div style="width:370px;height: 95px;">
            <div style="width: 370px;height: 40px;line-height: 40px;">
                <div style="width: 150px;float: left;text-align: right;font-size: 14px;">管理电池组名称：</div>
                <div style="width: 170px;float: left;"><select id="batteryPackName" class="easyui-combobox"
                                                               style="width: 170px;height: 30px;line-height: 30px;"></select>
                </div>
            </div>
            <div style="width: 370px;height: 50px;line-height:50px;color: #999999;font-size: 13px;">
                <div style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">单体电池数量：</div>
                <div style="width: 140px;float: left;height: 25px;line-height: 25px;"><span id="lab_bc_value">50</span>
                </div>
                <div style="width: 30px;float: left;height: 25px;line-height: 25px;">
                    <span style="color: #2596d2"></span>
                </div>
                <div style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">自动测试周期：</div>
                <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                        id="lab_atc_value">3600Min</span></div>
            </div>
        </div>
        <div style="width: 400px;height: 300px;">
            <div style="width: 400px;height: 40px;line-height: 40px;">
                <div style="width: 150px;float: left;text-align: right;font-size: 14px;">监控设备名称：</div>
                <div style="width: 170px;float: left;">
                    <select id="deviceName" class="easyui-combobox"
                            style="width: 170px;height: 30px;line-height: 30px;"></select>
                </div>
                <div style="float: right">
                    <input type="button" value="ECU编号" id="btnLoadECU" class="btn1" style="display:none;"/>
                </div>
            </div>
            <div style="width: 370px;height: 255px;line-height:40px;color: #999999;font-size: 13px;">
                <div id="div_cfg_1">
                    <div id="lab_cfg_1"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">设备类型：
                    </div>
                    <div style="width: 140px;float: left;height: 25px;line-height: 25px;">
                        <span id="lab_cfg_value_1"></span></div>
                    <div style="width: 30px;float: left;height: 25px;line-height: 25px;">
                        <span style="color: #2596d2"></span>
                    </div>
                </div>

                <div id="div_cfg_2">
                    <div id="lab_cfg_2"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">串口端口号：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_2"></span></div>
                </div>

                <div id="div_cfg_3">
                    <div id="lab_cfg_3"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">Modbux总线地址：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_3"></span></div>
                </div>

                <div id="div_cfg_4">
                    <div id="lab_cfg_4"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">波特率：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_4"></span></div>
                </div>

                <div id="div_cfg_5">
                    <div id="lab_cfg_5"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">校验位：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_5"></span></div>
                </div>

                <div id="div_cfg_6">
                    <div id="lab_cfg_6"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">数据位：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_6"></span></div>
                </div>

                <div id="div_cfg_7">
                    <div id="lab_cfg_7"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">停止位：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_7"></span></div>
                </div>

                <div id="div_cfg_8">
                    <div id="lab_cfg_8"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">读取超时：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_8"></span></div>
                </div>

                <div id="div_cfg_9" style="display: none;">
                    <div id="lab_cfg_9"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">写入超时：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_9"></span>
                    </div>
                </div>

                <div id="div_cfg_10" style="display: none;">
                    <div id="lab_cfg_10"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">电池组采样率：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_10"></span>
                    </div>
                </div>

                <div id="div_cfg_11">
                    <div id="lab_cfg_11"
                         style="width: 150px;float: left;height: 25px;line-height: 25px;text-align: right;">单体采样率：
                    </div>
                    <div style="width: 200px;float: left;height: 25px;line-height: 25px;"><span
                            id="lab_cfg_value_11"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="text-align: center;float:left;width:100%;">
        <input class="btn0" type="button" id="btnSure" value="确定"/>
    </div>
</div>
<script type="text/javascript">
    var parameters = {
        Action: {
            getPoint1Names: "${_RootPath}/getPoint1Names",
            getPoint2Names: "${_RootPath}/getPoint2Names?pid=",
            getPoint3Names: "${_RootPath}/getPoint3Names?pid="
        },
        circuit:${circuit},
        devicesCfgLabNames: [
            [
                {name: "设备类型：", value: "type"},
                {name: "IP地址：", value: "Ip"},
                {name: "端口号：", value: "Port"},
                {name: "电池组采样率：", value: "BatteryPackSamplingTime"},
                {name: "单体采样率：", value: "BatterySamplingTime"}
            ], [
                {name: "设备类型：", value: "type"},
                {name: "地址：", value: "Address"},
                {name: "端口号：", value: "Port"},
                {name: "电池组采样率：", value: "BatteryPackSamplingTime"},
                {name: "单体采样率：", value: "BatterySamplingTime"}
            ], [
                {name: "设备类型：", value: "type"},
                {name: "IP地址：", value: "Ip"},
                {name: "端口号：", value: "Port"},
                {name: "电池组数量：", value: "BatteryPackCount"},
                {name: "单体数量：", value: "BatteryCountPerPack"},
                {name: "电池组采样率：", value: "BatteryPackSamplingTime"},
                {name: "单体采样率：", value: "BatterySamplingTime"}
            ], [
                {name: "设备类型：", value: "type"},
                {name: "端口号：", value: "Port"},
                {name: "ModBus总线地址：", value: "Address"},
                {name: "波特率：", value: "BaudRate"},
                {name: "校验位：", value: "Parity"},
                {name: "数据位：", value: "DataBits"},
                {name: "停止位：", value: "StopBits"},
                {name: "读取超时：", value: "ReadTimeout"},
                {name: "写入超时：", value: "WriteTimeout"},
                {name: "电池组采样率：", value: "BatteryPackSamplingTime"},
                {name: "单体采样率：", value: "BatterySamplingTime"}
            ]
        ]
    };

    function initDataAccuracyCom() {

        var batteryV = [['1', '1'], ['10', '10'], ['100', '100']];
        $("#batteryV").combobox({
            data: batteryV,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#batteryV ").combobox('select', parameters.circuit.volent);

        var batteryR = [['1', '1'], ['10', '10'], ['100', '100']];
        $("#batteryR").combobox({
            data: batteryR,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#batteryR ").combobox('select', parameters.circuit.resistance);

        var batteryJZT = [['0.1', '0.1'], ['1', '1']];
        $("#batteryJZT").combobox({
            data: batteryJZT,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#batteryJZT ").combobox('select', parameters.circuit.temperature);

        var groupV = [['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupV").combobox({
            data: groupV,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupV ").combobox('select', parameters.circuit.packVollent);


        var groupA = [['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupA").combobox({
            data: groupA,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupA ").combobox('select', parameters.circuit.current);

        var groupHJT = [['0.1', '0.1'], ['1', '1']];
        $("#groupHJT").combobox({
            data: groupHJT,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupHJT ").combobox('select', parameters.circuit.environTemperature);

        var groupBWV = [['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupBWV").combobox({
            data: groupBWV,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupBWV ").combobox('select', parameters.circuit.rippleVoltage);

        var groupJUXLA = [['1', '1'], ['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupJUXLA").combobox({
            data: groupJUXLA,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupJUXLA ").combobox('select', parameters.circuit.leakageCurrent);
    }

    function initPoint1Com() {
        var areaId = parameters.circuit.areaIds.split(",");
        $("#point_1").combobox({
            url: parameters.Action.getPoint1Names,
            valueField: "id",
            textField: "name",
            editable: false,
            onSelect: function (record) {
                initPoint2Com(record, areaId);
            },
            onLoadSuccess: function () {
                $("#point_2").combobox({
                    url: parameters.Action.getPoint2Names + -1,
                    valueField: "id",
                    textField: "name",
                    editable: false
                });
                $("#point_3").combobox({
                    url: parameters.Action.getPoint3Names + -1,
                    valueField: "id",
                    textField: "name",
                    editable: false
                });

                if (areaId && areaId.length >= 1)
                    $("#point_1").combobox('select', parseInt(areaId[0]));
            }
        });
    }

    function initPoint2Com(record, areaId) {
        $("#point_2").combobox('clear');
        $("#point_2").combobox({
            url: parameters.Action.getPoint2Names + record.id,
            valueField: "id",
            textField: "name",
            editable: false,
            onSelect: function (record) {
                initPoint3Com(record, areaId);
            },
            onLoadSuccess: function () {
                $("#point_3").combobox({
                    url: parameters.Action.getPoint3Names + -1,
                    valueField: "id",
                    textField: "name",
                    editable: false
                });
                var data = $("#point_2").combobox('getData');
                for (var i = 0; i < data.length; i++) {
                    if (areaId && areaId.length >= 2) {
                        if (data[i].id == areaId[1]) {
                            $("#point_2").combobox('select', parseInt(areaId[1]));
                        }
                    }
                }
            }
        });
    }

    function initPoint3Com(record, areaId) {
        $("#point_3").combobox('clear');
        $("#point_3").combobox({
            url: parameters.Action.getPoint3Names + record.id,
            valueField: "id",
            textField: "name",
            editable: true,
            onLoadSuccess: function () {
                var data = $("#point_3").combobox('getData');
                for (var i = 0; i < data.length; i++) {
                    if (areaId && areaId.length >= 3) {
                        if (data[i].id == areaId[2]) {
                            $("#point_3").combobox('select', parseInt(areaId[2]));
                        }
                    }
                }
            }
        });
    }

    function initBatteryPackCom() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getOwnAndOtherNotUseBatteryPack",
            data: {
                id: parameters.circuit.batteryPackId
            },
            success: function (rec) {
                if (rec && rec.code == 0) {
                    $("#batteryPackName").combobox({
                        data: rec.data,
                        textField: "name",
                        valueField: "id",
                        editable: false,
                        onSelect: function (data) {
                            $("#lab_bc_value").html(data.count);
                            $("#lab_atc_value").html(data.checkCycleTime + " Min");
                        }
                    });

                    if (parameters.circuit.batteryPackId && parameters.circuit.batteryPackId > 0) {
                        $("#batteryPackName").combobox('select', parameters.circuit.batteryPackId);
                    } else {
                        $("#batteryPackName").combobox('select', rec.data[0].id);
                    }

                }
            }
        });
    }

    function initDeviceCom() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getAllDevices",
            success: function (rec) {
                if (rec && rec.code == 0) {
                    $("#deviceName").combobox({
                        data: rec.data,
                        textField: "name",
                        valueField: "id",
                        editable: false,
                        onSelect: function (data) {
                            showSelectedDeviceTypeData(data);
                        }
                    });

                    if (parameters.circuit.batteryPackId && parameters.circuit.deviceId > 0) {
                        $("#deviceName").combobox('select', parameters.circuit.deviceId);
                    } else {
                        $("#deviceName").combobox('select', rec.data[0].id);
                    }

                }
            }
        });
    }

    // 显示选中的设备配置
    function showSelectedDeviceTypeData(data) {
        for (var i = 1; i <= 11; i++) {
            $("#div_cfg_" + i).css("display", "none");
        }
        var config = JSON.parse(data.config);
        var div_count = 0;
        if (data.type === "SfDevice") {
            div_count = 11;
            for (var i = 1; i <= 11; i++) {
                $("#lab_cfg_" + i).html(parameters.devicesCfgLabNames[3][i - 1].name);
            }
            $("#lab_cfg_value_1").html("SfDevice");
            $("#lab_cfg_value_2").html(config.Port ? config.Port : 0);
            $("#lab_cfg_value_3").html(config.Address ? config.Address : 0);
            $("#lab_cfg_value_4").html(config.BaudRate ? config.BaudRate : 0);
            $("#lab_cfg_value_5").html(config.Parity ? config.Parity : 0);
            $("#lab_cfg_value_6").html(config.DataBits ? config.DataBits : 0);
            $("#lab_cfg_value_7").html(config.StopBits ? config.StopBits : 0);
            $("#lab_cfg_value_8").html(config.ReadTimeout ? config.ReadTimeout : 0);
            $("#lab_cfg_value_9").html(config.WriteTimeout ? config.WriteTimeout : 0);
            $("#lab_cfg_value_10").html(config.BatteryPackSamplingTime ? config.BatteryPackSamplingTime : 0);
            $("#lab_cfg_value_11").html(config.BatterySamplingTime ? config.BatterySamplingTime : 0);
        } else if (data.type === "HwACDC") {
            div_count = 5;
            for (var i = 1; i <= 5; i++) {
                $("#lab_cfg_" + i).html(parameters.devicesCfgLabNames[0][i - 1].name);
            }

            $("#lab_cfg_value_1").html("HwACDC");
            $("#lab_cfg_value_2").html(config.Ip ? config.Ip : 0);
            $("#lab_cfg_value_3").html(config.Port ? config.Port : 0);
            $("#lab_cfg_value_4").html(config.BatteryPackSamplingTime ? config.BatteryPackSamplingTime : 0);
            $("#lab_cfg_value_5").html(config.BatterySamplingTime ? config.BatterySamplingTime : 0);
        } else if (data.type === "HwDCDC") {
            div_count = 5;
            for (var i = 1; i <= 5; i++) {
                $("#lab_cfg_" + i).html(parameters.devicesCfgLabNames[1][i - 1].name);
            }

            $("#lab_cfg_value_1").html("HwDCDC");
            $("#lab_cfg_value_2").html(config.Address ? config.Address : 0);
            $("#lab_cfg_value_3").html(config.Port ? config.Port : 0);
            $("#lab_cfg_value_4").html(config.BatteryPackSamplingTime ? config.BatteryPackSamplingTime : 0);
            $("#lab_cfg_value_5").html(config.BatterySamplingTime ? config.BatterySamplingTime : 0);
        } else if (data.type === "Fbs8100") {
            div_count = 7;
            for (var i = 1; i <= 7; i++) {
                $("#lab_cfg_" + i).html(parameters.devicesCfgLabNames[2][i - 1].name);
            }

            $("#lab_cfg_value_1").html("Fbs8100");
            $("#lab_cfg_value_2").html(config.Ip ? config.Ip : 0);
            $("#lab_cfg_value_3").html(config.Port ? config.Port : 0);
            $("#lab_cfg_value_4").html(config.BatteryPackCount ? config.BatteryPackCount : 0);
            $("#lab_cfg_value_5").html(config.BatteryCountPerPack ? config.BatteryCountPerPack : 0);
            $("#lab_cfg_value_6").html(config.BatteryPackSamplingTime ? config.BatteryPackSamplingTime : 0);
            $("#lab_cfg_value_7").html(config.BatterySamplingTime ? config.BatterySamplingTime : 0);
        }

        for (var i = 1; i <= div_count; i++) {
            $("#div_cfg_" + i).css("display", "block");
        }
    }

    function dataAccuracyFormatJson() {

        var jsonArr = [];
        var Voltage = $("#batteryV").combobox("getValue");
        jsonArr.push("\"Voltage\":\"" + Voltage + "\"");

        var Resistance = $("#batteryR").combobox("getValue");
        jsonArr.push("\"Resistance\":\"" + Resistance + "\"");

        var Temperature = $("#batteryJZT").combobox("getValue");
        jsonArr.push("\"Temperature\":\"" + Temperature + "\"");

        var PackVoltage = $("#groupV").combobox("getValue");
        jsonArr.push("\"PackVoltage\":\"" + PackVoltage + "\"");

        var Current = $("#groupA").combobox("getValue");
        jsonArr.push("\"Current\":\"" + Current + "\"");

        var EnvironmentTemperature = $("#groupHJT").combobox("getValue");
        jsonArr.push("\"EnvironmentTemperature\":\"" + EnvironmentTemperature + "\"");

        var RippleVoltage = $("#groupBWV").combobox("getValue");
        jsonArr.push("\"RippleVoltage\":\"" + RippleVoltage + "\"");

        var LeakageCurrent = $("#groupJUXLA").combobox("getValue");
        jsonArr.push("\"LeakageCurrent\":\"" + LeakageCurrent + "\"");

        return "{" + jsonArr.join(",") + "}";
    }

    function getAreaId() {
        var areaId = ${areaId}+0;
        if (areaId === 0) {
            areaId = $("#point_3").combobox("getValue");
            var point3List = $("#point_3").combobox("getData");
            var isNewArea = true;
            for(var i=0;i<point3List.length;i++){
                if(point3List[i].id == areaId){
                    isNewArea = false;
                    break;
                }
            }

            if ((areaId === "") || (isNewArea)) {
                areaId = $("#point_2").combobox("getValue");
                if ((areaId === "") || (isNaN(parseInt(areaId)))) {
                    areaId = $("#point_1").combobox("getValue");
                }
            }
        }
        return areaId;
    }

    function editCircuit() {
        var areaIdPath = '';

        if($("#point_1").combobox("getValue")){
            areaIdPath += $("#point_1").combobox("getValue");
        }
        if($("#point_2").combobox("getValue")){
            areaIdPath += ',';
            areaIdPath += $("#point_2").combobox("getValue");
        }
        if($("#point_3").combobox("getValue")){
            areaIdPath += ',';
            areaIdPath += $("#point_3").combobox("getValue");
        }
        var circuitName = $("#circuitName").val();
        if (!circuitName) {
            XspWeb.Misc.Tips("回路名称不可以省略！");
            return;
        }

        var batteryGroupId = $("#batteryPackName").combobox("getValue");
        var deviceName = $("#deviceName").combobox("getText");
        var deviceId = $("#deviceName").combobox("getValue");
        var dataAccuracy = dataAccuracyFormatJson();

        var areaId = getAreaId();
        if (!areaId || areaId === 0) {
            XspWeb.Misc.Tips("区域必须选择！(至少选择一级)");
            return;
        }

        var newAreaStr = $("#point_3").combobox("getValue");
        if (newAreaStr == areaId) {
            newAreaStr = "";
        }

        var isAddArea = false;
        if((newAreaStr) && (newAreaStr != areaId))
        {
            isAddArea = true;
        }

        $("#btnSure").attr("disabled", "disabled");
        $("#btnSure").addClass("disabled");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/editCircuit",
            data: {
                id: parameters.circuit.id,
                areaId: areaId,
                groupName: circuitName,
                batteryGroupId: batteryGroupId,
                deviceId: deviceId,
                dataAccuracy: dataAccuracy,
                newAreaStr: newAreaStr,
                isAddArea: isAddArea,
                areaIdPath:areaIdPath
            },
            success: function (rec) {
                if (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code == 0) {
                        if (typeof XspWeb.Controls.Dialog.Callbacks.updGroupSuccess === "function")
                            XspWeb.Controls.Dialog.Callbacks.updGroupSuccess();
                    }
                }
                $("#btnSure").removeAttr("disabled");
                $("#btnSure").removeClass("disabled");
            }
        });
    }

    // 获取combox选中数据源
    function getComSelectedData(obj, data) {
        var flag = obj.combobox("getValue");
        var selectedData = null;
        for (var i in data) {
            for (var j in data[i]) {
                if (data[i][j] == flag) {
                    selectedData = data[i];
                    break;
                }
            }
            if (selectedData) {
                break;
            }
        }
        return selectedData;
    }

    var ajaxCount = 0;
    function loadECU() {
        var data = $("#deviceName").combobox('getData');
        var selectedData = getComSelectedData($("#deviceName"), data);
        var address;
        if (selectedData) {
            var config = JSON.parse(selectedData.config);
            if (config) {
                address = config.Address;
            }
        }
        if (!address) {
            XspWeb.Misc.Tips("ModBus总线地址错误,请检查并修改");
            return;
        }

        $("#btnLoadECU").attr("disabled", "disabled");
        $("#btnLoadECU").addClass("disabled");
        $("#btnLoadECU").val("编号中...");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/setECUNumber",
            data: {
                address: address
            },
            success: function (rec) {
                if (rec.code === 0) {
                    getSfECU();
                } else {
                    XspWeb.Misc.Tips(rec.message);
                    $("#btnLoadECU").val("ECU编号");
                    $("#btnLoadECU").removeAttr("disabled");
                    $("#btnLoadECU").removeClass("disabled");
                }
            },
            error: function () {
                $("#btnLoadECU").val("ECU编号");
                $("#btnLoadECU").removeAttr("disabled");
                $("#btnLoadECU").removeClass("disabled");
            }
        });
    }

    // 轮询获取深福ECU
    function getSfECU() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfBCUConfigData",
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        $("#btnLoadECU").val("编号成功");
                        $("#btnLoadECU").css("color", "black");
                        ajaxCount = 0;
                    }
                    else if (ajaxCount <= 3) {
                        ajaxCount++;
                        setTimeout(getSfECU, 1000);
                    }
                    else {
                        ajaxCount = 0;
                        $("#btnLoadECU").val("ECU编号");
                        $("#btnLoadECU").removeAttr("disabled");
                        $("#btnLoadECU").removeClass("disabled");
                    }
                }
            },
            error: function () {
                $("#btnLoadECU").removeAttr("disabled");
                $("#btnLoadECU").removeClass("disabled");
            }
        });
    }

    function bindBtnEvent() {
        $("#btnSure").click(editCircuit);
        $("#btnLoadECU").click(loadECU);
    }

    function initHtml() {
        $("#circuitName").val(parameters.circuit.name);
        initDataAccuracyCom();
        initBatteryPackCom();
        initDeviceCom();
        initPoint1Com();
        bindBtnEvent();
    }

    $(function () {
        initHtml();
    })
</script>
</body>
</html>