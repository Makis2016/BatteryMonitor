<%--
  Created by IntelliJ IDEA.
  User: LYD
  Date: 2016/10/3
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <style>
        .window {
            background: #ffffff;
            padding: 0;
        }

        .window .window-header {
            background: #000000;
            padding: 0px 0px 6px 0px;
        }

        .window-header .panel-tool a {
            display: block;
        }

        .window, .window .window-body {
            border: none;
            border-bottom: 1px solid;
            border-right: 1px solid;
            border-left: 1px solid;
        }

        .window-shadow {
            background: none;
        }

        .panel-title {
            padding: 6px 0 0px 0;
            color: #ffffff;
        }

        .dialog-button {
            border-top: none;
            background: #fff;
            text-align: center;
        }

        #deviceDialog a.l-btn span span.l-btn-text {
            color: #fff;
        }

        #deviceDialog a.l-btn span.l-btn-left {
            background: #2596D5;
        }

        #deviceDialog a.l-btn {
            background: #2596d5;
            border-radius: 0 0 0 0;
        }

        .lab_cfg {
            width: 140px;
            text-align: right;
            display: block;
            float: left;
            height: 25px;
            line-height: 25px;
        }

        .config-div {
            width: 270px;
            height: 30px;
            text-align: center;
            line-height: 30px;
        }

        .cfg_value {
            width: 120px;
            float: left;
            height: 25px;
            line-height: 25px;
        }

        .btn0 {
            width: 70px;
            height: 25px;
            background-color: #2596D2;
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
<div id="deviceDialog" style="background-color: #ffffff;margin-top: 15px;height: 360px;">
    <div class="config-div">
        <span class="lab_cfg">设备名称:</span>
        <input id="name" type="text" class="cfg_value"/>
    </div>

    <div class="config-div">
        <span class="lab_cfg">设备类型:</span>
        <div class="cfg_value">
            <select id="type" class="easyui-combobox" style="width: 120px;"></select>
        </div>
    </div>

    <div class="config-div" id="config_1" style="display: none;">
        <span class="lab_cfg" id="lab_cfg1"></span>
        <div class="cfg_value">
            <input id="cfg_value_1" type="text" class="cfg_value"/>
        </div>
    </div>

    <div class="config-div" id="config_2" style="display: none;">
        <span class="lab_cfg" id="lab_cfg2"></span>
        <div class="cfg_value">
            <input id="cfg_value_2" type="text" class="cfg_value"/>
        </div>
    </div>

    <div class="config-div" id="config_3" style="display: none;">
        <span class="lab_cfg" id="lab_cfg3"></span>
        <div class="cfg_value">
            <input id="cfg_value_3" type="text" class="cfg_value"/>
        </div>
    </div>

    <div class="config-div" id="config_4" style="display: none;">
        <span class="lab_cfg" id="lab_cfg4"></span>
        <div class="cfg_value">
            <input id="cfg_value_4" type="text" class="cfg_value"/>
        </div>
    </div>

    <div class="config-div" id="config_5" style="display: none;">
        <span class="lab_cfg" id="lab_cfg5"></span>
        <div class="cfg_value">
            <input id="cfg_value_5" type="text" class="cfg_value"/>
        </div>
    </div>

    <div class="config-div" id="config_6" style="display: none;">
        <span class="lab_cfg" id="lab_cfg6"></span>
        <div class="cfg_value">
            <input id="cfg_value_6" type="text" class="cfg_value"/>
        </div>
    </div>

    <div class="config-div" id="config_7" style="display: none;">
        <span class="lab_cfg" id="lab_cfg7"></span>
        <div class="cfg_value" style="width: auto">
            <input id="cfg_value_7" type="text" class="cfg_value"/>
            <span id="cfg_value_7_unit" class="unit"></span>
        </div>
    </div>

    <div class="config-div" id="config_8" style="display: none;">
        <span class="lab_cfg" id="lab_cfg8"></span>
        <div class="cfg_value" style="width: auto">
            <input id="cfg_value_8" type="text" class="cfg_value"/>
            <span id="cfg_value_8_unit" class="unit"></span>
        </div>
    </div>

    <div class="config-div" id="config_9" style="display: none;">
        <span class="lab_cfg" id="lab_cfg9">电池组采样频率:</span>
        <div class="cfg_value" style="width: auto">
            <input id="cfg_value_9" type="text" class="cfg_value" style="width: 100px;"/>
            <span class="unit">ms</span>
        </div>
    </div>

    <div class="config-div" id="config_10" style="display: none;">
        <span class="lab_cfg" id="lab_cfg10">单体采样频率:</span>
        <div class="cfg_value" style="width: auto">
            <input id="cfg_value_10" type="text" class="cfg_value" style="width: 100px;"/>
            <span class="unit">ms</span>
        </div>
    </div>
</div>
<div class="btn-div" style="text-align: center">
    <input class="btn0" id="btnSure" type="button" value="确定"/>
</div>
<script>
    // 编辑设备原始值
    var mDeviceId = "${mDeviceId}";
    var mDeviceName = "${mDeviceName}";
    var mDeviceType = "${mDeviceType}";
    var mDeviceCfg = '${mDeviceCfg}';

    // 设备类型对应html
    var typeData = [['HwACDC', '{"Ip":"Ip地址:","Port":"端口号:","BatteryPackSamplingTime":"电池组采样率:","BatterySamplingTime":"单体采样率:"}'],
        ['HwDCDC', '{"Address":"地址:","Port":"端口号:","BatteryPackSamplingTime":"电池组采样率:","BatterySamplingTime":"单体采样率:"}'],
        ['Fbs8100', '{"Ip":"Ip地址:","Port":"端口号:","BatteryPackCount":"电池组数量:","BatteryCountPerPack":"单体数量:","BatteryPackSamplingTime":"电池组采样率:","BatterySamplingTime":"单体采样率:"}'],
        ['SfDevice', '{"Address":"ModBus总线地址:","Port":"端口号:","BaudRate":"波特率:","Parity":"校验位:",' +
        '"DataBits":"数据位:","StopBits":"停止位:","ReadTimeout":"读取超时:","WriteTimeout":"写入超时:",' +
        '"BatteryPackSamplingTime":"电池组采样率:","BatterySamplingTime":"单体采样率:"}']];

    // 添加设备
    function addDevice() {
        var name = $("#name").val();
        if (!name) {
            XspWeb.Misc.Tips("请输入设备名称");
            return;
        }

        var type = $("#type").combobox("getText");
        if (!type) {
            XspWeb.Misc.Tips("请选择设备类型");
            return;
        }

        var json = formatJson(type);
        if (!json) {
            return;
        }

        $("#btnSure").attr("disabled", "disabled");
        $("#btnSure").addClass("disabled");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/addDevice",
            data: {
                name: name,
                type: type,
                config: json
            },
            success: function (rec) {
                XspWeb.Misc.Tips(rec.message);
                if (rec.code === 0) {
                    if (typeof XspWeb.Controls.Dialog.Callbacks.addDeviceSuccess === "function")
                        XspWeb.Controls.Dialog.Callbacks.addDeviceSuccess();
                }
                $("#btnSure").removeAttr("disabled");
                $("#btnSure").removeClass("disabled");
            }
        });
    }

    // 编辑设备
    function editDevice() {
        var json = formatJson(mDeviceType);
        if (!json) {
            return;
        }

        $("#btnSure").attr("disabled", "disabled");
        $("#btnSure").addClass("disabled");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/updateDevice",
            data: {
                id: mDeviceId,
                config: json
            },
            success: function (rec) {
                XspWeb.Misc.Tips(rec.message);
                if (rec.code === 0) {
                    if (typeof XspWeb.Controls.Dialog.Callbacks.editDeviceSuccess === "function")
                        XspWeb.Controls.Dialog.Callbacks.editDeviceSuccess();
                }
                $("#btnSure").removeAttr("disabled");
                $("#btnSure").removeClass("disabled");
            }
        });
    }

    // 初始化更新内容
    function initEditInputValue() {
        if (mDeviceName) {
            $("#name").val(mDeviceName);
            $("#name").attr("disabled", "disabled");

            if (mDeviceCfg && mDeviceType) {
                $("#type").combobox({disabled: true});
                var config = JSON.parse(mDeviceCfg);

                if (mDeviceType === "HwACDC") {
                    $("#type").combobox('select', typeData[0][1]);
                    $("#cfg_value_1").val(config.Ip);
                    $("#cfg_value_2").combobox('setValue', config.Port);
                } else if (mDeviceType === "HwDCDC") {
                    $("#type").combobox('select', typeData[1][1]);
                    $("#cfg_value_1").val(config.Address);
                    $("#cfg_value_2").combobox('setValue', config.Port);
                } else if (mDeviceType === "Fbs8100") {
                    $("#type").combobox('select', typeData[2][1]);
                    $("#cfg_value_1").val(config.Ip);
                    $("#cfg_value_2").combobox('setValue', config.Port);
                    $("#cfg_value_7").val(config.BatteryPackCount);
                    $("#cfg_value_8").val(config.BatteryCountPerPack);
                } else {
                    $("#type").combobox('select', typeData[3][1]);
                    $("#cfg_value_1").val(config.Address);
                    $("#cfg_value_2").combobox('setValue', config.Port);
                    $("#cfg_value_3").combobox('setValue', config.BaudRate);
                    $("#cfg_value_4").combobox('setValue', config.Parity);
                    $("#cfg_value_5").combobox('setValue', config.DataBits);
                    $("#cfg_value_6").combobox('setValue', config.StopBits);
                    $("#cfg_value_7").val(config.ReadTimeout);
                    $("#cfg_value_8").val(config.WriteTimeout);
                }
                $("#cfg_value_9").val(config.BatteryPackSamplingTime);
                $("#cfg_value_10").val(config.BatterySamplingTime);
            }
        }
    }

    // 初始化配置下拉框数据-端口号、波特率、校验位、数据位、停止位
    function initConfigCombobox() {
        var portData = [];
        for (var i = 1; i < 100; i++) {
            var obj = {};
            obj.text = "COM" + i;
            obj.value = i;
            portData.push(obj);
        }
        $("#cfg_value_2").combobox({
            data: portData,
            textField: "text",
            valueField: "value",
            editable: true
        });

        var baudRateData = [{text: "9600", value: "9600"},
            {text: "19200", value: "19200"}, {text: "38400", value: "38400"},
            {text: "57600", value: "57600"}];
        $("#cfg_value_3").combobox({
            data: baudRateData,
            textField: "text",
            valueField: "value",
            editable: false
        });

        var parityData = [{text: "None", value: 0}, {text: "Odd", value: 1},
            {text: "Even", value: 2}, {text: "Mark", value: 3}, {text: "Space", value: 4}];
        $("#cfg_value_4").combobox({
            data: parityData,
            textField: "text",
            valueField: "value",
            editable: false
        });

        var dataBitsData = [{text: 1, value: 1}, {text: 2, value: 2},
            {text: 3, value: 3}, {text: 4, value: 4}, {text: 5, value: 5},
            {text: 6, value: 6}, {text: 7, value: 7}, {text: 8, value: 8}];
        $("#cfg_value_5").combobox({
            data: dataBitsData,
            textField: "text",
            valueField: "value",
            editable: false
        });

        var stopBitsData = [{text: "None", value: 0}, {text: "One", value: 1},
            {text: "Two", value: 2}, {text: "OnePointFive", value: 3}];
        $("#cfg_value_6").combobox({
            data: stopBitsData,
            textField: "text",
            valueField: "value",
            editable: false
        });
    }

    // 初始化设备类型下拉框和显示内容
    function initTypeComAndHtml() {
        $("#type").combobox({
            data: typeData,
            textField: 0,
            valueField: 1,
            editable: false,
            onSelect: function (data) {
                for (var i = 1; i <= 10; i++) {
                    $("#config_" + i).attr("style", "display:none");
                    if (i > 1 && i < 7) {
                        $("#cfg_value_" + i).combobox('setValue', "");
                    }
                    else
                        $("#cfg_value_" + i).val("");
                }

                var obj = JSON.parse(data[1]);
                var labCount = 0;
                if (data[0] === "HwACDC") {
                    labCount = 2;
                    $("#lab_cfg1").html(obj.Ip);
                    $("#lab_cfg2").html(obj.Port);
                } else if (data[0] === "HwDCDC") {
                    labCount = 2;
                    $("#lab_cfg1").html(obj.Address);
                    $("#lab_cfg2").html(obj.Port);
                } else if (data[0] === "Fbs8100") {
                    $("#lab_cfg1").html(obj.Ip);
                    $("#config_" + 1).attr("style", "display:block");
                    $("#lab_cfg2").html(obj.Port);
                    $("#config_" + 2).attr("style", "display:block");
                    $("#lab_cfg7").html(obj.BatteryPackCount);
                    $("#config_" + 7).attr("style", "display:block");
                    $("#cfg_value_7_unit").html("");
                    $("#cfg_value_7").removeAttr("style");
                    $("#lab_cfg8").html(obj.BatteryCountPerPack);
                    $("#config_" + 8).attr("style", "display:block");
                    $("#cfg_value_8_unit").html("");
                    $("#cfg_value_8").removeAttr("style");
                } else {
                    labCount = 8;
                    $("#lab_cfg1").html(obj.Address);
                    $("#cfg_value_1").val("0")
                    $("#lab_cfg2").html(obj.Port);
                    $("#lab_cfg3").html(obj.BaudRate);
                    $("#cfg_value_3").combobox('setValue', "9600");
                    $("#lab_cfg4").html(obj.Parity);
                    $("#cfg_value_4").combobox('setValue', "1");
                    $("#lab_cfg5").html(obj.DataBits);
                    $("#cfg_value_5").combobox('setValue', "1");
                    $("#lab_cfg6").html(obj.StopBits);
                    $("#cfg_value_6").combobox('setValue', "1");
                    $("#lab_cfg7").html(obj.ReadTimeout);
                    $("#cfg_value_7").val("1000");
                    $("#cfg_value_7_unit").html("ms");
                    $("#cfg_value_7").attr("style","width:100px;");
                    $("#lab_cfg8").html(obj.WriteTimeout);
                    $("#cfg_value_8").val("1000")
                    $("#cfg_value_8_unit").html("ms");
                    $("#cfg_value_8").attr("style","width:100px;");
                }
                for (var i = 1; i <= labCount; i++) {
                    $("#config_" + i).attr("style", "display:block");
                }

                $("#lab_cfg9").html(obj.BatteryPackSamplingTime);
                $("#cfg_value_9").val("5000")
                $("#lab_cfg10").html(obj.BatterySamplingTime);
                $("#cfg_value_10").val("60000")
                for (var i = 9; i < 11; i++) {
                    $("#config_" + i).attr("style", "display:block");
                }
            }
        });

        $("#type").combobox('select', typeData[3][1]);
    }

    // 封装配置configJson
    function formatJson(type) {
        var jsonArr = [];
        if (type === "HwACDC") {
            var Ip = $("#cfg_value_1").val();
            if (!Ip) {
                XspWeb.Misc.Tips("IP地址未填!");
                return;
            }
            if (!Business.Misc.validateIP(Ip)) {
                XspWeb.Misc.Tips("IP地址输入有误!");
                return;
            }
            jsonArr.push('"Ip":"' + Ip + '"');

            var Port = $("#cfg_value_2").combobox('getValue');
            if (!Port) {
                XspWeb.Misc.Tips("端口号未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Port)) {
                XspWeb.Misc.Tips("端口号输入有误!");
                return;
            }
            jsonArr.push('"Port":' + Port);

        } else if (type === "HwDCDC") {
            var Address = $("#cfg_value_1").val();
            if (!Address) {
                XspWeb.Misc.Tips("地址未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Address)) {
                XspWeb.Misc.Tips("地址输入有误!");
                return;
            }
            jsonArr.push('"Address":' + Address);

            var Port = $("#cfg_value_2").combobox('getValue');
            if (!Port) {
                XspWeb.Misc.Tips("端口号未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Port)) {
                XspWeb.Misc.Tips("端口号输入有误!");
                return;
            }
            jsonArr.push('"Port":' + Port);

        } else if (type === "Fbs8100") {
            var Ip = $("#cfg_value_1").val();
            if (!Ip) {
                XspWeb.Misc.Tips("Ip未填!");
                return;
            }
            if (!Business.Misc.validateIP(Ip)) {
                XspWeb.Misc.Tips("IP地址输入有误!");
                return;
            }
            jsonArr.push('"Ip":"' + Ip + '"');

            var Port = $("#cfg_value_2").combobox('getValue');
            if (!Port) {
                XspWeb.Misc.Tips("端口号未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Port)) {
                XspWeb.Misc.Tips("端口号输入有误!");
                return;
            }
            jsonArr.push('"Port":' + Port);

            var BatteryPackCount = $("#cfg_value_7").val();
            if (!BatteryPackCount) {
                XspWeb.Misc.Tips("电池组数量未填!");
                return;
            }
            if (!Business.Misc.validateNumber(BatteryPackCount)) {
                XspWeb.Misc.Tips("电池组数量输入有误!");
                return;
            }
            jsonArr.push('"BatteryPackCount":' + BatteryPackCount);

            var BatteryCountPerPack = $("#cfg_value_8").val();
            if (!BatteryCountPerPack) {
                XspWeb.Misc.Tips("单体数量未填!");
                return;
            }
            if (!Business.Misc.validateNumber(BatteryCountPerPack)) {
                XspWeb.Misc.Tips("单体数量输入有误!");
                return;
            }
            jsonArr.push('"BatteryCountPerPack":' + BatteryCountPerPack);

        } else {
            var Address = $("#cfg_value_1").val();
            if (!Address) {
                XspWeb.Misc.Tips("地址未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Address)) {
                XspWeb.Misc.Tips("地址输入有误!");
                return;
            }
            jsonArr.push('"Address":' + Address);

            var Port = $("#cfg_value_2").combobox('getValue');
            if (!Port) {
                XspWeb.Misc.Tips("端口号未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Port)) {
                XspWeb.Misc.Tips("端口号输入有误!");
                return;
            }
            jsonArr.push('"Port":' + Port);

            var BaudRate = $("#cfg_value_3").combobox('getValue');
            if (!Business.Misc.validateNumber(BaudRate)) {
                XspWeb.Misc.Tips("波特率输入有误!");
                return;
            }
            jsonArr.push('"BaudRate":' + BaudRate);

            var Parity = $("#cfg_value_4").combobox('getValue');
            if (!Business.Misc.validateNumber(Parity)) {
                XspWeb.Misc.Tips("校验位输入有误!");
                return;
            }
            jsonArr.push('"Parity":' + Parity);

            var DataBits = $("#cfg_value_5").combobox('getValue');
            if (!Business.Misc.validateNumber(DataBits)) {
                XspWeb.Misc.Tips("数据位输入有误!");
                return;
            }
            jsonArr.push('"DataBits":' + DataBits);

            var StopBits = $("#cfg_value_6").combobox('getValue');
            if (!Business.Misc.validateNumber(StopBits)) {
                XspWeb.Misc.Tips("停止位输入有误!");
                return;
            }
            jsonArr.push('"StopBits":' + StopBits);

            var ReadTimeout = $("#cfg_value_7").val();
            if (!Business.Misc.validateNumber(ReadTimeout)) {
                XspWeb.Misc.Tips("读取超时时间输入有误!");
                return;
            }
            jsonArr.push('"ReadTimeout":' + ReadTimeout);

            var WriteTimeout = $("#cfg_value_8").val();
            if (!Business.Misc.validateNumber(WriteTimeout)) {
                XspWeb.Misc.Tips("写入超时时间输入有误!");
                return;
            }
            jsonArr.push('"WriteTimeout":' + WriteTimeout);
        }

        var BatteryPackSamplingTime = $("#cfg_value_9").val();
        if (!Business.Misc.validateNumber(BatteryPackSamplingTime)) {
            XspWeb.Misc.Tips("电池组采样率输入有误!");
            return;
        }
        jsonArr.push('"BatteryPackSamplingTime":' + BatteryPackSamplingTime);

        var BatterySamplingTime = $("#cfg_value_10").val();
        if (!Business.Misc.validateNumber(BatterySamplingTime)) {
            XspWeb.Misc.Tips("单体采样率输入有误!");
            return;
        }
        jsonArr.push('"BatterySamplingTime":' + BatterySamplingTime);

        return "{" + jsonArr.join(",") + "}";
    }

    // 初始化页面
    function initSetDeviceHtml() {
        initConfigCombobox();
        initTypeComAndHtml();
        if (mDeviceId && mDeviceName && mDeviceType) {
            initEditInputValue();
            $("#btnSure").click(editDevice);
        } else {
            $("#btnSure").click(addDevice);
        }
    }

    $(function () {
        initSetDeviceHtml();
    });
</script>
</body>
</html>