<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <title></title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
</head>
<body>
<style>
    .div-content {
        width: 840px;
        height: 100%;
        line-height: 100%;
        margin: auto;
    }

    .div-content-tool {
        width: 840px;
        height: 50px;
        padding-top: 30px;
        padding-bottom: 10px;
    }

    .div-content-content {
        width: 840px;
        height: 480px;
        *line-height: 480px;
        background-color: #ffffff;
    }

    .div-content-tool div {
        float: left;
    }

    .div-content-tool-dspan {
        width: 120px;
        height: 50px;
        line-height: 40px;
    }

    .input-text-b {
        width: 160px;
        height: 30px;
        line-height: 30px;
    }

    .input-text-div {
        margin-top: 8px;
    }

    .input-button {
        width: 80px;
        height: 30px;
        line-height: 30px;
        background-color: #2596d2;
        color: #ffffff;
        border-radius: 5px;
        border: none;
        margin: 3px 0 0 10px;
    }

    #heardTitle {
        background-color: #40526A;
        color: #ffffff;
        height: 30px;
        line-height: 30px;
    }

    .cdiv-table-conten {
        height: 410px;
        width: 820px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 20px;
    }

    .cdiv-table-conten .datagrid-header td {
        background: #A8B0BB;
        color: #fff;
    }

    .cdiv-table-conten .datagrid-header td,
    .cdiv-table-conten .datagrid-body td,
    .cdiv-table-conten .datagrid-footer td {
        border: 1px solid #DCDCDC;
        border-left: none;
        border-bottom: none;
    }

    #btnDownload {
        background: #2596d2;
        border: none;
        border-radius: 5px;
        width: 60px;
        height: 25px;
        color: #ffffff;
        margin-right: 10px;
        margin-top: 2px;
    }
</style>
<div class="easyui-layout minheightwidth" data-options="fit:true">
    <div data-options="region:'center'" style="background-color: rgb(232, 235, 239);text-align: center;border: none">
        <div class="div-content">
            <div class="div-content-tool">
                <div class="div-content-tool-dspan">开始时间：</div>
                <div class="div-select">
                    <div>
                        <div class="input-text-div">
                            <input id="startDate" type="text" class="easyui-datebox" style="width: 100px;">
                        </div>
                    </div>
                </div>
                <div class="div-content-tool-dspan">结束时间：</div>
                <div class="div-select">
                    <div>
                        <div class="input-text-div">
                            <input id="endDate" type="text" class="easyui-datebox" style="width: 100px;">
                        </div>
                    </div>
                </div>
                <div class="div-content-tool-dspan">电池组名称：</div>
                <div class="div-select">
                    <div>
                        <div class="input-text-div">
                            <select id="batteryPackName" class="input-text-b"></select>
                        </div>
                    </div>
                </div>
                <div><input id="selectBtn" class="input-button" type="button" value="搜索"/>
                </div>
            </div>
            <div class="div-content-content">
                <div id="heardTitle">
                    <span id="titleName"
                          style="display: block;float: left;margin-left: 340px;"></span>
                    <div style="height: 30px;text-align: right;">
                        <input id="btnDownload" type="button" value="下载"/>
                    </div>
                </div>
                <div id="cdiv-table-content" class="cdiv-table-conten">
                    <div style="width:820px;height: 410px;float: left">
                        <table id="alarmData"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="display: none;">
    <div id="msgDialog">加载中......</div>
</div>
<script>
    var parameters = {
        Action: {
            getAlarmByParams: "${_RootPath}/Historical/getAlarmByParams"
        },
        dataSource: null,
        paramsJson: null
    };

    /*本页面上的电池组下拉框*/
    // 初始化电池组下拉框
    function initBatteryPackCom() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getUseBatteryPack",
            success: function (rec) {
                if (rec && rec.code == 0) {
                    $("#batteryPackName").combobox({
                        data: rec.data,
                        textField: "name",
                        valueField: "id",
                        editable: false
                    });
                }
            }
        });
    }

    function initAlarmGrid() {
        $('#alarmData').datagrid({
            url: parameters.Action.getAlarmByParams,
            fit: true,
            border: false,
            pagination: true,
            pageSize:20,
            pageList:[10,20,30,40],
            loadMsg: "搜索中...",
            columns: [[{
                field: "Id",
                title: "电池组编号",
                align: 'center',
                width: 65
            }, {
                field: "AreaName",
                title: "告警位置",
                align: 'center',
                width: 120
            }, {
                field: "StrarTime",
                title: "告警时间",
                align: 'center',
                width: 180
            }, {
                field: "AlarmId",
                title: "告警编号",
                align: 'center',
                width: 65
            }, {
                field: "AlarmMessage",
                title: "告警信息",
                align: 'center',
                width: 300
            }, {
                field: "ManualOperationed",
                title: "目前状态",
                align: 'center',
                width: 100,
                formatter: function (value, row, index) {
                    if (row.EndTime) {
                        return "已消除";
                    }
                    else {
                        return "未消除";
                    }
                }
            }]],
            onLoadSuccess: function (data) {
                if (data.total === 0) {
                    $(this).datagrid('appendRow',
                            {Id: '<div style="text-align:center;color:#CCCCCC">没有相关记录！</div>'})
                            .datagrid('mergeCells', {index: 0, field: 'Id', colspan: 6});
                }
                else {
                    parameters.dataSource = data.rows;
                }
            }
        });
    }

    function selectByParams() {
        var arrParams = [];
        var startDate = $('#startDate').datebox('getValue');
        if (startDate) {
            arrParams.push('"startDate":"' + startDate + '"');
        }

        var endDate = $('#endDate').datebox('getValue');
        if (endDate) {
            arrParams.push('"endDate":"' + endDate + '"');
        }

        var batteryPackId = $("#batteryPackName").combobox("getValue");
        if (batteryPackId) {
            arrParams.push('"batteryPackId":"' + batteryPackId + '"');
        }

        var json = "{" + arrParams.join(",") + "}";
        parameters.paramsJson = json;
        loadAlarmGridData(json);
    }

    function loadAlarmGridData(paramsJson) {
        $("#alarmData").datagrid("load", {
            paramsJson: paramsJson
        });
    }

    function initHistoricalDataHtml() {
        initBatteryPackCom();
        initAlarmGrid();
        bindBtnEvent();
    }

    function downloadHisAlarm() {
        if (parameters.dataSource) {
            XspWeb.Misc.Download(
                    '${_RootPath}/Statistical/downloadHisAlarmReport', {
                        paramsJson: parameters.paramsJson,
                        dateSourceJson: JSON.stringify(parameters.dataSource)
                    });
        }
    }

    function bindBtnEvent() {
        $("#selectBtn").click(selectByParams);
        $("#btnDownload").click(downloadHisAlarm);
    }

    $(function () {
        initHistoricalDataHtml();
    })
</script>
</body>
</html>
