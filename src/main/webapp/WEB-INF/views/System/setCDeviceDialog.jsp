<%--
  Created by IntelliJ IDEA.
  User: LYD
  Date: 2016/10/3
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        #CodeBCU-div {
            display: block;
            margin: 10px;
        }

        .lab-span {
            width: 80px;
            text-align: right;
            height: 30px;
            line-height: 30px;
        }

        #point_1 {
            width: 60px;
        }

        #point_2 {
            width: 80px;
        }

        #point_3 {
            width: 120px;
        }

        .btn0 {
            margin: 0 0 0 230px;
            color: #ffffff;
            width: 70px;
            display: block;
            background-color: #2794d5;
        }

        .btnAdd {
            margin: 0 0 0 230px;
            color: #ffffff;
            width: 70px;
            background-color: #2794d5
        }

        .btnSel {
            margin: 0 0 0 230px;
            color: #ffffff;
            width: 70px;
            background-color: #2794d5
        }

        .btnDisabled {
            background-color: #ffffff;
            color: #cccccc;
        }
    </style>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
</head>
<body>
<div id="CodeBCU-div">
    <div>
        <span class="lab-span">区域：</span>
        <select id="point_1" class="easyui-combobox"></select>
        <select id="point_2" class="easyui-combobox"></select>
        <select id="point_3" class="easyui-combobox"></select>
    </div>
    <div>
        <span class="lab-span">回路：</span>
        <select id="circuit" class="easyui-combobox" style="width: 120px;"></select>
    </div>
    <div>
        <span class="lab-span">编号：</span>
        <input id="registerAddress" class="easyui-textbox" style="width: 116px;" type="text"/>
    </div>
    <div id="cDeviceType-div">
        <span class="lab-span">类型：</span>
        <select id="cDeviceType" class="easyui-combobox" style="width: 120px;"></select>
    </div>
    <div class="lab-span">
        <span id="msg" style="display: block;width: 200px;"></span>
    </div>
    <div style="line-height: 30px;height: 40px;">
        <input class="btnAdd" id="btnSendAddCmd"
               type="button" value="新增"/>
        <input class="btnSel" id="btnSendSelCmd"
               type="button" value="查询"/>
    </div>

    <%--新增 查询 信息 可以修改--%>
    <div>---------设备信息----------</div>
    <div id="sfbcu_info">
        <div style="margin: 10px 0 0 0;">
            <span class="lab-span">回路：</span>
            <select id="_circuit" class="easyui-combobox" style="width: 120px;"></select>
        </div>
        <div>
            <span class="lab-span">编号：</span>
            <input id="_registerAddress" class="easyui-textbox" style="width: 116px;" type="text"/>
        </div>
        <div>
            <span class="lab-span">MAC：</span>
            <span id="_mac"></span>
        </div>
        <div id="_cDeviceType-div">
            <span class="lab-span">类型：</span>
            <select id="_cDeviceType" class="easyui-combobox" style="width: 120px;"></select>
        </div>
        <div>
            <span id="_msg" class="lab-span"></span>
        </div>
        <div class="lab-span">
            <span id="msg2" style="display: block; width: 200px"></span>
        </div>
        <div style="line-height: 30px;height: 40px;">
            <input class="btn0" ;
                   id="btnSendUpdCmd" type="button" value="修改"/>
        </div>
    </div>
</div>
<script>
    var mToDo = "${mToDo}";
    var parameters = {
        Action: {
            getPoint1Names: "${_RootPath}/getPoint1Names",
            getPoint2Names: "${_RootPath}/getPoint2Names?pid=",
            getPoint3Names: "${_RootPath}/getPoint3Names?pid="
        }
    };
    var ajaxCount = 0;
    var sfBCUData = null;

    function showMsg(value) {
        $("#msg").html(value);
        setTimeout(function () {
            $("#msg").html("");
        }, 1500);
    }

    function showMsg2(value) {
        $("#msg2").html(value);
        setTimeout(function () {
            $("#msg2").html("");
        }, 1500);
    }

    function sendAddCmd() {
        var circuitId = $("#circuit").combobox('getValue');
        if (!circuitId) {
            XspWeb.Misc.Tips("请选择一条回路");
            return;
        }

        var registerAddress = $("#registerAddress").val();
        if (!registerAddress) {
            XspWeb.Misc.Tips("请输入编号");
            return;
        }
        if (!Business.Misc.validateNumber(registerAddress)) {
            XspWeb.Misc.Tips("编号必须是数字");
            return;
        }

        var cDeviceType = $("#cDeviceType").combobox('getValue');
        if (!cDeviceType) {
            XspWeb.Misc.Tips("请选择设备类型");
            return;
        }

        $("#btnSendAddCmd").attr("disabled", "disabled");
        $("#btnSendAddCmd").addClass("btnDisabled");
        $("#btnSendAddCmd").val("新增中");
        $("#msg").html("下发命令中...");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/setSfBCUConfig",
            data: {
                circuitId: circuitId,
                bcuConfig: '{registerAddress:' + registerAddress + '}'
            },
            success: function (rec) {
                showMsg(rec.message);
                if (rec) {
                    if (rec.code === 0) {
                        getSfBCU();
                    }
                }
                $("#btnSendAddCmd").removeAttr("disabled");
                $("#btnSendAddCmd").removeClass("btnDisabled");
                $("#btnSendAddCmd").val("新增");
            }
        });
    }

    function sendSelCmd() {
        var circuitId = $("#circuit").combobox('getValue');
        if (!circuitId) {
            XspWeb.Misc.Tips("请选择一条回路");
            return;
        }

        var registerAddress = $("#registerAddress").val();
        if (!registerAddress) {
            XspWeb.Misc.Tips("请输入编号");
            return;
        }
        if (!Business.Misc.validateNumber(registerAddress)) {
            XspWeb.Misc.Tips("编号必须是数字");
            return;
        }

        $("#btnSendSelCmd").attr("disabled", "disabled");
        $("#btnSendSelCmd").addClass("btnDisabled");
        $("#btnSendSelCmd").val("查询中");
        $("#msg").html("下发命令中...");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfBCUConfig",
            data: {
                circuitId: circuitId,
                registerAddress: registerAddress
            },
            success: function (rec) {
                showMsg(rec.message);
                if (rec) {
                    if (rec.code === 0) {
                        getSfBCU();
                    }
                }
                $("#btnSendSelCmd").removeAttr("disabled");
                $("#btnSendSelCmd").removeClass("btnDisabled");
                $("#btnSendSelCmd").val("查询");
            }
        });
    }

    function sendUpdCmd() {
        var oldCircuitId = $("#circuit").combobox('getValue');
        if (!oldCircuitId) {
            XspWeb.Misc.Tips("请选择一条回路");
            return;
        }

        var oldRegisterAddress = $("#registerAddress").val();
        if (!oldRegisterAddress) {
            XspWeb.Misc.Tips("请输入编号");
            return;
        }
        if (!Business.Misc.validateNumber(oldRegisterAddress)) {
            XspWeb.Misc.Tips("编号必须是数字");
            return;
        }

        var newCircuitId = $("#_circuit").combobox('getValue');
        if (!newCircuitId) {
            XspWeb.Misc.Tips("请一条回路");
            return;
        }

        var newRegisterAddress = $("#_registerAddress").val();
        if (!newRegisterAddress) {
            XspWeb.Misc.Tips("请输入编号");
            return;
        }
        if (!Business.Misc.validateNumber(newRegisterAddress)) {
            XspWeb.Misc.Tips("编号必须是数字");
            return;
        }

        var newBCUType = $("#_cDeviceType").combobox('getValue');
        if (!newBCUType) {
            XspWeb.Misc.Tips("请选择设备类型");
            return;
        }

        $("#btnSendUpdCmd").attr("disabled", "disabled");
        $("#btnSendUpdCmd").addClass("btnDisabled");
        $("#btnSendUpdCmd").val("修改中");
        $("#msg2").html("下发命令中...");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/updateSfBCUConfig",
            data: {
                oldCircuitId: oldCircuitId,
                oldRegisterAddress: oldRegisterAddress,
                newCircuitId: newCircuitId,
                bcuConfig: '{registerAddress:' + newRegisterAddress + '}'
            },
            success: function (rec) {
                showMsg2(rec.message);
                if (rec) {
                    if (rec.code === 0) {
                        getSfBCUByEdit();
                    }
                }
                $("#btnSendUpdCmd").removeAttr("disabled");
                $("#btnSendUpdCmd").removeClass("btnDisabled");
                $("#btnSendUpdCmd").val("修改");
            }
        });
    }

    // 轮询获取深福BCU
    function getSfBCU() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfBCUConfigData",
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        sfBCUData = rec.data;
                        initCDeviceEditInfo();
                        $("#btnSendUpdCmd").removeAttr("disabled");
                        $("#btnSendUpdCmd").removeClass("btnDisabled");
                    }
                    else if (ajaxCount <= 3) {
                        ajaxCount++;
                        setTimeout(getSfBCU, 1000);
                    }
                    else {
                        ajaxCount = 0;
                        showMsg("等待超时");
                    }
                }
            }
        });
    }

    function initCDeviceEditInfo() {
        if (sfBCUData) {
            $("#_mac").html(sfBCUData.mac);
            $("#_registerAddress").val(sfBCUData.registerAddress);
            $("#_cDeviceType").combobox('select', sfBCUData.type);
            $("#_circuit").combobox('select', $("#circuit").combobox('getValue'));
        }
    }

    // 轮询获取深福BCU
    function getSfBCUByEdit() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfBCUConfigData",
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        $("#_mac").html(rec.data.mac);
                        $("#_registerAddress").val(rec.data.registerAddress);
                        $("#_cDeviceType").combobox('select', rec.data.type);
                        var registerAddress = parseInt($("#registerAddress").val()) + 1;
                        $("#registerAddress").val(registerAddress);
                        showMsg2("修改成功");
                    }
                    else if (ajaxCount <= 3) {
                        ajaxCount++;
                        setTimeout(getSfBCUByEdit, 1000);
                    }
                    else {
                        ajaxCount = 0;
                        showMsg2("修改失败");
                        $("#_circuit").combobox('select', $("#circuit").combobox('getValue'));
                        $("#_registerAddress").val($("#registerAddress").val());
                        $("#_cDeviceType").combobox('select', $("#cDeviceType").combobox('getValue'));
                    }
                }
            }
        });
    }

    // 初始化区域下拉框-联动-1级区域
    function initPoint1Combobox() {
        $("#point_1").combobox({
            url: parameters.Action.getPoint1Names,
            valueField: "id",
            textField: "name",
            editable: false,
            onSelect: function (record) {
                initPoint2Combobox(record);
                initCircuitCom(record.id);
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
            }
        });
    }

    // 初始化区域下拉框-联动-2级区域
    function initPoint2Combobox(record) {
        $("#point_2").combobox('clear');
        $("#point_2").combobox({
            url: parameters.Action.getPoint2Names + record.id,
            valueField: "id",
            textField: "name",
            editable: false,
            onSelect: function (record) {
                initPoint3Combobox(record);
                initCircuitCom(record.id);
            },
            onLoadSuccess: function () {
                $("#point_3").combobox({
                    url: parameters.Action.getPoint3Names + -1,
                    valueField: "id",
                    textField: "name",
                    editable: false
                });
            }
        });
    }

    // 初始化区域下拉框-联动-3级区域
    function initPoint3Combobox(record) {
        $("#point_3").combobox('clear');
        $("#point_3").combobox({
            url: parameters.Action.getPoint3Names + record.id,
            valueField: "id",
            textField: "name",
            editable: false,
            onSelect: function (record) {
                initCircuitCom(record.id);
            }
        });
    }

    function initCircuitCom(areaId) {
        var url = "${_RootPath}/System/getCircuitsByAreaId?areaId=" + areaId;
        $("#circuit").combobox({
            url: url,
            valueField: "id",
            textField: "name",
            editable: false
        });

        $("#_circuit").combobox({
            url: url,
            valueField: "id",
            textField: "name",
            editable: false
        });
    }

    function initCDeviceTypeCom() {
        var _cDeviceType = [['16', '内阻监控检测设备'], ['32', '端电压检测设备'], ['33', '端电流检测设备'], ['48', '温度检测设备']];
        $("#_cDeviceType").combobox({
            data: _cDeviceType,
            textField: 1,
            valueField: 0,
            editable: false
        });

        var cDeviceType = [['16', '内阻监控检测设备'], ['32', '端电压检测设备'], ['33', '端电流检测设备'], ['48', '温度检测设备']];
        $("#cDeviceType").combobox({
            data: cDeviceType,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#cDeviceType ").combobox('select', cDeviceType[0][0]);


    }

    function displayBtnByTodo() {
        if (mToDo) {
            if (mToDo === "add") {
                $("#btnSendSelCmd").css("display", "none");
            } else {
                $("#cDeviceType-div").css("display", "none");
                $("#btnSendAddCmd").css("display", "none");
            }
        }
    }

    function bindBtnEvent() {
        $("#btnSendAddCmd").click(sendAddCmd);
        $("#btnSendSelCmd").click(sendSelCmd);
        $("#btnSendUpdCmd").click(sendUpdCmd);
    }

    $(function () {
        $("#btnSendUpdCmd").attr("disabled", "disabled");
        $("#btnSendUpdCmd").addClass("btnDisabled");
        initPoint1Combobox();
        initCDeviceTypeCom();
        displayBtnByTodo();
        bindBtnEvent();
    });
</script>
</body>
</html>