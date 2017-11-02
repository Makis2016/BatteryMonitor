<%--
  Created by IntelliJ IDEA.
  User: Linyudui
  Date: 2016/7/21
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>设备管理</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <link rel="stylesheet" type="text/css" href="${_RootPath}/resources/xspweb/client/scripts/Controls/Samples/MapX/XspWeb/Client/Scripts/artDialog/skins/aero.css"/>
</head>
<body id="layout_main" class="easyui-layout minheightwidth" data-options="fit:true">
<style type="text/css">
    .tabs {
        height: 40px !important;
        line-height: 40px;
    }

    .tabs-header {
        border-color: #ffffff;
        height: 40px;
        background-color: rgba(255, 255, 255, 0);
    }

    .tabs li a.tabs-inner {
        height: 40px !important;
        line-height: 40px !important;
        width: 80px;
        color: #000000;
        background: #ffffff;
    }

    .tabs li.tabs-selected a.tabs-inner {
        border: none;
        color: #ffffff;
        background-color: #2B96D2;
    }

    .tabs li a.tabs-close {
        display: none;
    }

    .tabs-header, .tabs-scroller-left, .tabs-scroller-right, .tabs-tool, .tabs, .tabs-panels, .tabs li a.tabs-inner, .tabs li.tabs-selected a.tabs-inner, .tabs-header-bottom .tabs li.tabs-selected a.tabs-inner, .tabs-header-left .tabs li.tabs-selected a.tabs-inner, .tabs-header-right .tabs li.tabs-selected a.tabs-inner {
        border: none;
    }

    /*grid*/
    .panel-body {
        background-color: rgba(236, 239, 232, 0);
    }

    .datagrid-header td, .datagrid-body td, .datagrid-footer td {
        border-color: #cdcdcd;
        background-color: #ecefe8;
    }

    .datagrid-header td {
        background-color: #A8b0bb;
        color: #ffffff;
    }

    .datagrid-body td {
        background-color: #fff;
    }

    .tabs-wrap .tabs {
        width: auto;
        float: right;
    }

    @font-face {
        font-family: 'fzlt';
        src:url('/BatteryMonitor/resources/css/fzlt.ttf') format('truetype');
        font-weight: normal;
        font-style: normal;
    }
    body{
        font-family: 'fzlt'!important;
    }

    #version{
        width: 100% !important;
        height: 700px !important;
        border: none;
    }

</style>
<div id="Device" style="height: 100%;width: 100%;background-color: rgba(0, 0, 0, 0);">
    <div id="tabMenu_3" style="height: 100%;background-color: rgba(0, 0, 0, 0);">

        <div title="回路管理">
            <div style="width: 90%;height: 90%;padding: 10px 0 0 0px;margin: auto;">
                <input id="btnAddGroup" type="button" value="新增"
                       style="border-width: 1px;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 80px;height: 35px; background-color: #2B96D2; cursor: pointer;font-family: 'fzlt'!important"/>
                <div id="d_Group" style="width: 100%;height: 100%;">
                    <table id="t_Group"></table>
                </div>
            </div>
        </div>

        <div title="电池组管理">
            <div style="width: 90%;height: 90%;padding: 10px 0 0 0px;margin: auto;">
                <input id="btnAddBatteryPack" type="button" value="新增"
                       style="border-width: 1px;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 80px;height: 35px; background-color: #2B96D2;cursor: pointer;font-family: 'fzlt'!important"/>
                <div id="d_batteryGroup" style="width: 100%;height: 100%;">
                    <table id="t_batteryGroup"></table>
                </div>
            </div>
        </div>

        <div title="通讯设备管理">
            <div style="width: 90%;height: 90%;padding: 10px 0 0 0px;margin: auto;">
                <div>
                    <input id="btnAddDevice" type="button" value="新增监控设备"
                           style="border-width: 1px;float: left;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 100px;height: 35px; background-color: #2B96D2;margin-right: 10px;cursor: pointer;font-family: 'fzlt'!important"/>
                    <%--<input todo="add" id="btnAddCDevice" type="button" value="新增组网设备"--%>
                           <%--style="border-width: 1px;float: left;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 100px;height: 35px; background-color: #2794D5;margin-right: 10px;cursor: pointer"/>--%>
                    <%--<input todo="select" id="btnSelectCDevice" type="button" value="查询组网设备"--%>
                           <%--style="border-width: 1px;float: left;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 100px;height: 35px; background-color: #2794D5;cursor: pointer"/>--%>
                </div>
                <div id="d_Device" style="width: 100%;height: 100%;overflow: hidden">
                    <table id="t_Device"></table>
                </div>
            </div>
        </div>

        <div title="版本信息">
            <div style="width: 90%;height: 90%;padding: 10px 0 0 0px;margin: auto;">
                <div style="width: 100%;height: 100%;overflow: hidden">
                    <div id="version" class="easyui-panel"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    /* tabs初始化 */
    function initDeviceManageTabs() {
        window.tabMenu = new XspWeb.Controls.Tabs("#tabMenu_3");
        tabMenu.Initialize({
            closable: false,
            onSelect: function (title, index) {
                if (index == 0) {
                    loadCircuitDataByAjax();
                } else if (index == 1) {
                    loadBatteryPackDataByAjax();
                } else if (index == 2) {
                    loadDeviceDataByAjax();
                }else if(index == 3){
                    loadVersionPage();
                }
            }
        });

        tabMenu.SelectTab(2);
        tabMenu.SelectTab(1);
        tabMenu.SelectTab(3);
        tabMenu.SelectTab(0);
    }

    function loadVersionPage(){
        $("#version").panel({
            href: '${_RootPath}/System/setAlarmDll'
        });
    }

    /* 回路管理 */
    function initCircuitGrid() {
        var gridCircuit = new XspWeb.Controls.RemoteDataGrid();
        gridCircuit.Initialize("#t_Group", "${_RootPath}/System/getCircuits", {
            border: false,
            fit: true,
            scrollbarSize: 0,
            pageSize: 20,
            pageList: [20]
        }).SetColumns([[{
            field: "id",
            title: "ID",
            width: 30
        }, {
            field: "name",
            title: "回路名称",
            width: 80
        }, {
            field: "batteryPack",
            title: "管理电池组",
            width: 80
        }, {
            field: "area",
            title: "所属区域",
            width: 80
        }, {
            field: "BtnEdit",
            ContentType: "button",
            text: "编辑",
            width: 40,
            handler: function (index, row) {
                editCiruitDialog(gridCircuit, row);
            }
        }, {
            field: "BtnEdit2",
            ContentType: "button",
            text: "组网编辑",
            width: 40,
            handler: function (index, row) {
                editCiruitDialog2(gridCircuit, row);
            }
        }, {
            field: "BtnDelete",
            ContentType: "button",
            text: "删除",
            width: 40,
            handler: function (index, row) {
                deleteCiruit(gridCircuit, row);
            }
        }, {
            field: "BtnShowAlarmDllParamView",
            text: "查看告警库参数",
            ContentType: "button",
            width: 80,
            handler: function (index, row) {
                var showAlarmDllForParam = new XspWeb.Controls.Dialog("addGroupDialog");
                showAlarmDllForParam.SetUrl("${_RootPath}/System/alarmDllForParam?circuitId=" + row.id)
                        .SetCallback({
                            name: "showAlarmDllForParam",
                            callback: function () {
                                showAlarmDllForParam.Hide();
                                if(window.alarmDll_timer){
                                    alert(window.alarmDll_timer);
                                    clearInterval(window.alarmDll_timer);
                                }
                            }
                        }).Show({
                    title: "实时查看动态告警库参数",
                    width: 850,
                    height: 565,
                    maximizable: false,
                    minimizable: false
                }, true);
            }
        }]]);

        return gridCircuit;
    }

    function addCircuitDialog() {
        var addGroupDialog = new XspWeb.Controls.Dialog("addGroupDialog");
        addGroupDialog.SetUrl("${_RootPath}/System/addCircuitDialog?areaId=" + 0)
                .SetCallback({
                    name: "addGroupSuccess",
                    callback: function () {
                        addGroupDialog.Hide();
                        $("#t_Group").datagrid("reload");
                    }
                }).Show({
            title: "新增回路",
            width: 850,
            height: 565,
            maximizable: false,
            minimizable: false
        }, true);
    }

    function deleteCiruit(gridCircuit, row) {
        XspWeb.Misc.Confirm("确定删除 " + row.name + " 回路吗?", function () {
            XspWeb.Misc.Ajax({
                action: "${_RootPath}/System/deleteCircuit",
                data: {
                    id: row.id
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code === 0) {
                        gridCircuit.LoadRemoteData();
                    }
                }
            });
        });
    }

    function editCiruitDialog(gridCircuit, row) {
        var objJson = JSON.stringify(row);
        var updGroupDialog = new XspWeb.Controls.Dialog("updGroupDialog");
        updGroupDialog.SetUrl("${_RootPath}/System/editCircuitDialog?json=" + objJson)
                .SetCallback({
                    name: "updGroupSuccess",
                    callback: function () {
                        updGroupDialog.Hide();
                        gridCircuit.LoadRemoteData();
                    }
                }).Show({
            title: "修改回路",
            width: 850,
            height: 565,
            maximizable: false,
            minimizable: false
        }, true);
    }

    function loadCircuitGridData() {
        var circuitGrid = initCircuitGrid();
        circuitGrid.LoadRemoteData();
    }

    function loadCircuitDataByAjax() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getCircuits",
            data: {
                page: 1,
                rows: 20
            },
            success: function (data) {
                if (data) {
                    $("#t_Group").datagrid('loadData', data);
                }
            }
        });
    }

    // test
    function editCiruitDialog2(gridCircuit, row) {
        var paramsJson = JSON.stringify(row);
        var editCiruitDialog2 = new XspWeb.Controls.Dialog("editCiruitDialog2");
        console.log(row);
        editCiruitDialog2.SetUrl("${_RootPath}/System/editCircuitANDNetWorking?paramsJson=" + paramsJson+"&circuitId="+row.id)
                .SetCallback({
                    name: "editCiruitDialog2",
                    callback: function () {
                        editCiruitDialog2.Hide();
                        gridCircuit.LoadRemoteData();
                    }
                }).Show({
            title: "编辑回路",
            width: 1000,
            height: 565,
            maximizable: false,
            minimizable: false
        }, true);
    }

    /* 电池组管理 */
    function initBatteryPackGrid() {
        var gridBatteryPack = new XspWeb.Controls.RemoteDataGrid();
        gridBatteryPack.Initialize("#t_batteryGroup", "${_RootPath}/System/getBatteryPacks", {
            border: false,
            fit: true,
            scrollbarSize: 0,
            pageSize: 20,
            pageList: [20]
        }).SetColumns([[{
            field: "id",
            hidden: true,
            width: 30
        }, {
            field: "name",
            title: "电池组名称",
            width: 60
        }, {
            field: "count",
            title: "单体数量",
            width: 60
        }, {
            field: "voltageRange",
            title: "单体电压范围",
            width: 80
        }, {
            field: "checkCycleTime",
            title: "自动测试周期",
            width: 80
        }, {
            field: "thresholdConfi",
            title: "单体电压范围",
            hidden: true,
            width: 120
        }, {
            field: "BtnEdit",
            ContentType: "button",
            text: "编辑",
            width: 40,
            handler: function (index, row) {
                editBatteryPackDialog(gridBatteryPack, row);
            }
        }, {
            field: "BtnDelete",
            ContentType: "button",
            text: "删除",
            width: 40,
            handler: function (index, row) {
                deleteBatteryPack(gridBatteryPack, row);
            }
        }]]);

        return gridBatteryPack;

    }

    function addBatteryPackDialog() {
        var addBatteryGroupDialog = new XspWeb.Controls.Dialog("addBatteryGroupDialog");
        addBatteryGroupDialog.SetUrl("${_RootPath}/System/addBatteryPackDialog").SetCallback({
            name: "addBatteryGroupSuccess",
            callback: function () {
                addBatteryGroupDialog.Hide();
                $("#t_batteryGroup").datagrid('reload');
            }
        }).Show({
            title: "新增电池组",
            width: 1350,
            height: 500,
            maximizable: false,
            minimizable: false
        }, true);
    }

    function deleteBatteryPack(gridBatteryPack, row) {
        XspWeb.Misc.Confirm("确定删除" + row.name + "电池组吗?", function () {
            XspWeb.Misc.Ajax({
                action: "${_RootPath}/System/deleteBatteryPack",
                data: {
                    id: row.id
                },
                success: function (data) {
                    XspWeb.Misc.Tips(data.message);
                    gridBatteryPack.LoadRemoteData();
                }
            })
        });
    }

    function editBatteryPackDialog(gridBatteryPack, row) {
        var objJson = JSON.stringify(row);
        var editBatteryGroupDialog = new XspWeb.Controls.Dialog("editBatteryGroupDialog");
        editBatteryGroupDialog.SetUrl("${_RootPath}/System/editBatteryPackDialog?json=" + objJson).SetCallback({
            name: "editBatteryGroupSuccess",
            callback: function () {
                editBatteryGroupDialog.Hide();
                gridBatteryPack.LoadRemoteData();
            }
        }).Show({
            title: "修改电池组",
            width: 1350,
            height: 500,
            maximizable: false,
            minimizable: false
        }, true);
    }

    function loadBatteryPackGridData() {
        var gridBatteryPack = initBatteryPackGrid();
        gridBatteryPack.LoadRemoteData();
    }

    function loadBatteryPackDataByAjax() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getBatteryPacks",
            data: {
                page: 1,
                rows: 20
            },
            success: function (data) {
                if (data) {
                    $("#t_batteryGroup").datagrid("loadData", data);
                }
            }
        });
    }

    /* 设备管理 */
    function initDeviceGrid() {
        var gridDevice = new XspWeb.Controls.RemoteDataGrid();
        gridDevice.Initialize("#t_Device", "${_RootPath}/System/getALLDevices", {
            border: false,
            fit: true,
            scrollbarSize: 0,
            pageSize: 20,
            pageList: [20]
        }).SetColumns([[{
            field: "id",
            hidden: true,
            width: 30
        }, {
            field: "name",
            title: "设备名称",
            width: 60
        }, {
            field: "type",
            title: "设备类型",
            width: 60
        }, {
            field: "config",
            title: "配置",
            hidden: true,
            width: 260
        }, {
            field: "BtnEdit",
            ContentType: "button",
            text: "编辑",
            width: 40,
            handler: function (index, row) {
                editDeviceHtml(gridDevice, row);
            }
        }, {
            field: "BtnDelete",
            ContentType: "button",
            text: "删除",
            width: 40,
            handler: function (index, row) {
                deleteDevice(gridDevice, row);
            }
        }]]);

        return gridDevice;

    }

    function addDeviceHtml() {
        var addDeviceDialog = new XspWeb.Controls.Dialog("addDeviceDialog");
        addDeviceDialog.SetUrl("${_RootPath}/System/setDeviceDialog")
                .SetCallback({
                    name: "addDeviceSuccess",
                    callback: function () {
                        addDeviceDialog.Hide();
                        $("#t_Device").datagrid("reload");
                    }
                }).Show({
            title: "新增监控设备",
            width: 330,
            height: 460,
            maximizable: false,
            minimizable: false
        }, true);
    }

    function deleteDevice(gridDevice, row) {
        XspWeb.Misc.Confirm("确定删除" + row.name + "设备吗?", function () {
            XspWeb.Misc.Ajax({
                action: "${_RootPath}/System/deleteDevice",
                data: {
                    id: row.id
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    gridDevice.LoadRemoteData();
                }
            })
        });
    }

    function editDeviceHtml(gridDevice, row) {
        var deviceId = row.id;
        var deviceName = row.name;
        var deviceType = row.type;
        var deviceCfg = row.config;
        var editDeviceDialog = new XspWeb.Controls.Dialog("editDeviceDialog");
        editDeviceDialog.SetUrl("${_RootPath}/System/setDeviceDialog?deviceId=" + deviceId + "&deviceName=" + deviceName + "&deviceType=" + deviceType + "&deviceCfg=" + deviceCfg)
                .SetCallback({
                    name: "editDeviceSuccess",
                    callback: function () {
                        editDeviceDialog.Hide();
                        gridDevice.LoadRemoteData();
                    }
                }).Show({
            title: "编辑监控设备",
            width: 330,
            height: 460,
            maximizable: false,
            minimizable: false
        }, true);
    }

    function setCDeviceHtml() {
        var title = "新增组网设备";
        var todo = $(this).attr("todo");
        if (todo === "select") {
            title = "查询组网设备";
        }

        var setCDeviceDialog = new XspWeb.Controls.Dialog("setCDeviceDialog");
        setCDeviceDialog.SetUrl("${_RootPath}/System/setCDeviceDialog?todo=" + todo)
                .Show({
                    title: title,
                    width: 400,
                    height: 460,
                    maximizable: false,
                    minimizable: false
                }, true);
    }

    function loadDeviceGridData() {
        var gridDevice = initDeviceGrid();
        gridDevice.LoadRemoteData();
    }

    function loadDeviceDataByAjax() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getALLDevices",
            data: {
                page: 1,
                rows: 20
            },
            success: function (data) {
                if (data) {
                    $("#t_Device").datagrid("loadData", data);
                }
            }
        });
    }

    // 绑定按钮事件
    function bindBtnEvent() {
        $("#btnAddGroup").click(addCircuitDialog);

        $("#btnAddBatteryPack").click(addBatteryPackDialog);

        $("#btnAddDevice").click(addDeviceHtml);
        $("#btnAddCDevice").click(setCDeviceHtml);
        $("#btnSelectCDevice").click(setCDeviceHtml);
    }

    $(function () {
        initDeviceManageTabs();

        loadCircuitGridData();

        loadBatteryPackGridData();

        loadDeviceGridData();

        bindBtnEvent();
    });
</script>
</body>
</html>