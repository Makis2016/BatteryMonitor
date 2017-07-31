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

    .div-content2 {
        width: 1240px;
        height: 520px;
        line-height: 520px;
        margin: auto;
    }

    .div-content-tool {
        width: 840px;
        height: 50px;
        margin-top: 30px;
        margin-bottom: 10px;
    }

    .div-content-content {
        width: 840px;
        height: 480px;
        *line-height: 480px;
        background-color: #ffffff;
    }

    .div-content-content2 {
        width: 1240px;
        height: 520px;
        line-height: 520px;
        background-color: #ffffff;
        margin-top: 30px;
    }

    .div-content-tool div {
        float: left;
    }

    .div-content-tool-dspan {
        width: 120px;
        height: 50px;
        line-height: 40px;
    }

    .input-text-a1 {
        width: 200px;
        height: 30px;
        line-height: 30px;
    }

    .input-text-b {
        width: 200px;
        height: 30px;
        line-height: 30px;
        margin-top: 8px;
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

    .heardTitle {
        background-color: #40526A;
        color: #ffffff;
        height: 30px;
        line-height: 30px;
    }

    .cdiv-table-content {
        height: 410px;
        width: 700px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 40px;
    }

    .cdiv-table-content .datagrid-header td {
        background: #A8B0BB;
        color: #fff;
    }

    .cdiv-table-content .datagrid-header td,
    .cdiv-table-content .datagrid-body td,
    .cdiv-table-content .datagrid-footer td {
        border: 1px solid #DCDCDC;
        border-left: none;
        border-bottom: none;
    }

    .cdiv-table-content2 {
        height: 470px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 20px;
        line-height: 0px;
    }

    .cdiv-table-content2 .datagrid-header td {
        background: #A8B0BB;
        color: #fff;
    }

    .cdiv-table-content2 .datagrid-header td,
    .cdiv-table-content2 .datagrid-body td,
    .cdiv-table-content2 .datagrid-footer td {
        border: 1px solid #DCDCDC;
        border-left: none;
        border-bottom: none;
    }

    #monthReport tr {
        height: 20px;
        line-height: 20px;
    }

    #monthReport td {
        height: 20px;
        line-height: 20px;
    }

    .returnBtnDiv {
        float: left;
        width: 20px;
        display: none;
    }

    .tab-div {
        float: left;
        position: relative;
        left: 40%;
    }

    #heardTitle2 div {
        float: left;
    }

    .heardTitle2-tab {
        width: 95%;
        text-align: center;
    }

    .panel-body .panel-body-noheader .layout-body{
        width: auto;
    }

    .panel .datagrid{
        width: auto;
    }

    .datagrid-view2{
        width: auto;
    }

    .datagrid-header{
        width: auto;
    }

    .datagrid-body{
        overflow-x: auto !important;
    }
</style>
<div class="easyui-layout minheightwidth" data-options="fit:true">
    <div data-options="region:'center'" style="background-color: rgb(232, 235, 239);text-align: center;border: none">
        <div id="div-content1" class="div-content" style="display:block;">
            <div class="div-content-tool">
                <div class="div-content-tool-dspan">区域名称：</div>
                <div>
                    <div class="input-text-div">
                        <input id="Areas" class="input-text-a1"/>
                    </div>
                </div>
                <div class="div-content-tool-dspan">电池组名称：</div>
                <div>
                    <div class="input-text-div">
                        <input id="BatteryPackNames" class="input-text-b"/>
                    </div>
                </div>
                <div>
                    <input id="selectBtn" class="input-button" type="button" value="搜索"/>
                </div>
            </div>
            <div class="div-content-content">
                <div id="heardTitle" class="heardTitle" style="display: block;">
                    <div id="returnBtnDiv" class="returnBtnDiv">
                        <a id="returnBtn" href="javascript:void(0);" style="color: #ffffff;"><<</a>
                    </div>
                    <span id="titleName"
                          style="display: block;float: left;margin-left: 340px;"></span>
                    <div id="downloadDiv" style="display: none;">
                        <input id="btnDownload" type="button" value="下载"
                               style="background: #2596d2;border: none;border-radius: 5px;width: 60px;height: 25px;color: #ffffff;margin: 3px 0px 0 115px;"/>
                    </div>
                </div>
                <div id="batteryPackGrid" class="cdiv-table-content" style="display: block;">
                    <table id="batteryGroupData"></table>
                </div>
                <div id="monthReport" class="cdiv-table-content" style="display: none;">
                    <table>
                        <tr>
                            <td>电池组运行情况：</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组总放电次数：<span id="disCCount"></span>次</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组总放电时间：<span id="disCTotalTime"></span>小时</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组累计总放电容量：<span id="disCTotalAh"></span>Ah</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组总投入运行时间：<span id="runTotalTime"></span>小时</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>本月电池组放电次数：<span id="disCCountByMonth"></span>次</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>本月电池组放电时间：<span id="disCTotalTimeByMonth"></span>小时</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>本月电池组累计放电容量：<span id="disCTotalAhByMonth"></span>Ah</td>
                        </tr>
                        <tr>
                            <td>电池组告警及处理：</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组累计总一级告警次数：<span id="level1AlarmCount"></span>次 ，已经处理次数：<span
                                    id="disLevel1AlarmCount"></span>次 。
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组累计总二级告警次数：<span id="level2AlarmCount"></span>次 ，已经处理次数：<span
                                    id="disLevel2AlarmCount"></span>次 。
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组累计总三级告警次数：<span id="level3AlarmCount"></span>次 ，已经处理次数：<span
                                    id="disLevel3AlarmCount"></span>次 。
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>本月电池组累计一级告警次数：<span id="level1AlarmCountByMonth"></span>次 ，已经处理次数：<span
                                    id="disLevel1AlarmCountByMonth"></span>次 。
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>本月电池组累计二级告警次数：<span id="level2AlarmCountByMonth"></span>次 ，已经处理次数：<span
                                    id="disLevel2AlarmCountByMonth"></span>次 。
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>本月电池组累计三级告警次数：<span id="level3AlarmCountByMonth"></span>次 ，已经处理次数：<span
                                    id="disLevel3AlarmCountByMonth"></span>次 。
                            </td>
                        </tr>
                        <tr>
                            <td>电池组目前状态及建议：</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><span id="state"></span></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>电池组还剩余<span id="proposal"></span></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div id="div-content2" class="div-content2" style="display: none;">
            <div class="div-content-content2">
                <div id="heardTitle2" class="heardTitle" style="display: block;">
                    <div><a id="returnBtn2" href="javascript:void(0)" style="color: #ffffff"><<</a></div>
                    <div id="heardTitle2-title" class="heardTitle2-tab">
                    </div>
                    <div>
                        <input id="btnDownload2" type="button" value="下载"
                               style="background: #2596d2;border: none;border-radius: 5px;width: 60px;height: 25px;color: #ffffff;margin: 3px 0px 0 -115px;"/>
                    </div>
                </div>
                <div id="batteryGrid" class="cdiv-table-content2" style="display: block;">
                    <table id="batteryData"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="display: none">
    <div id="monthReportParamDialog">
        <table>
            <tr>
                <td>年月：</td>
                <td>
                    <select id="year" style="width:80px;"></select>
                </td>
                <td>年</td>
                <td>
                    <select id="month" style="width:80px;"></select>
                </td>
                <td>月</td>
            </tr>
        </table>
    </div>

    <div id="historicalReportParamDialog">
        <table>
            <tr>
                <td>开始时间：</td>
                <td>
                    <input id="startDate" type="text" class="easyui-datebox">
                </td>
                <td></td>
            </tr>
            <tr>
                <td>结束时间：</td>
                <td>
                    <input id="endDate" type="text" class="easyui-datebox">
                </td>
            </tr>
        </table>
    </div>
</div>
<script>
    var parameters = {
        Action: {
            getBatteryPackLikeName: "${_RootPath}/System/getBatteryPackLikeName",
            getBatteryPackMonthReport: "${_RootPath}/Statistical/getBatteryPackMonthReport",
            getBatteryByBatteryPackId: "${_RootPath}/Statistical/getBatteryByBatteryPackId",
            getBatteryPackHisReport: "${_RootPath}/Statistical/getBatteryPackHisReport"
        },
        monthReportDataSource: null,
        historcalReportColumns: null,
        hisBatteryParamJson: null
    };

    function monthReportDialog(row) {
        XspWeb.Misc.Dialog($("#monthReportParamDialog"), {
            title: "月报查询下载",
            width: 300,
            height: 120,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "查询",
                handler: function () {
                    var year = $("#year").combobox("getValue");
                    var month = $("#month").combobox("getValue");
                    var startDate = year + "-" + month + "-01 " + "00:00:00";
                    var endDate = year + "-" + month + "-31 " + "00:00:00";
                    getMonthReport(row, startDate, endDate);
                }
            }]
        });
    }

    function getMonthReport(row, startDate, endDate) {
        $("#batteryPackGrid").attr("style", "display:none;");
        $("#monthReport").attr("style", "display:block;margin-top:5px;");
        $("#returnBtnDiv").css("display", "block");
        $("#titleName").html(row.name + " " + startDate + " 月报");
        $("#downloadDiv").attr("style", "display:block;");
        var params = [];
        params.push('"startDate":"' + startDate + '"');
        params.push('"endDate":"' + endDate + '"');
        params.push('"id":"' + row.id + '"');
        params.push('"name":"' + row.name + '"');
        XspWeb.Misc.Ajax({
            action: parameters.Action.getBatteryPackMonthReport,
            data: {
                paramsJson: "{" + params.join(",") + "}"
            },
            success: function (data) {
                if (data) {
                    parameters.monthReportDataSource = data;
                    parameters.monthReportDataSource.name = row.name;
                    parameters.monthReportDataSource.year = startDate.substr(0, 4);
                    parameters.monthReportDataSource.month = startDate.substr(5, 2);
                    loadMonthReportData();
                }
            }
        });
        $("#monthReportParamDialog").dialog("close");
    }

    function loadMonthReportData() {
        if (parameters.monthReportDataSource) {
            for (var i in parameters.monthReportDataSource) {
                $("#" + i).html(parameters.monthReportDataSource[i]);
            }
        }
    }

    function historicalReportDialog(row) {

        XspWeb.Misc.Dialog($("#historicalReportParamDialog"), {
            title: "历史数据查询下载",
            width: 320,
            height: 150,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "查询",
                handler: function () {
                    var startDate = $('#startDate').datebox('getValue');
                    var endDate = $('#endDate').datebox('getValue');
                    getHisReport(row, startDate, endDate);

                }
            }]
        });
    }

    function getHisReport(row, startDate, endDate) {
        $("#heardTitle2-title").html(row.name + " 历史数据(" + startDate + "至" + endDate + ")");
        $("#div-content1").attr("style", "display:none;");
        $("#div-content2").attr("style", "display:block;");
        var isV = $("#V_" + row.id)[0].checked;
        var isT = $("#T_" + row.id)[0].checked;
        var isR = $("#R_" + row.id)[0].checked;

        XspWeb.Misc.Ajax({
            action: parameters.Action.getBatteryByBatteryPackId,
            data: {
                id: row.id
            },
            success: function (data) {
                if (data) {
                    parameters.hisBatteryPackId = row.id;
                    parameters.isV = isV;
                    parameters.isT = isT;
                    parameters.isR = isR;
                    var columns = [{
                        field: "datetime",
                        title: "日期时间",
                        width: 200,
                        formatter: function (value, row, index) {
                            if (value === '<div style="text-align:center;color:#CCCCCC">没有相关记录！</div>') {
                                return value;
                            }

                            if(typeof value === 'number'){
                                var date = new Date(value);
                        return XspWeb.Misc.DateFormat(date, "yyyy-MM-dd hh:mm:ss");
                            }

                            return value;
                        }
                    }, {
                        field: "mode",
                        title: "模式",
                        width: 60,
                        formatter: function (value, row, index) {
                            return value;
                            if (value === "Charge")
                                return "充电";
                            else if (value === "Discharge")
                                return "放电";
                            else
                                return "";
                        }
                    }, {
                        field: "group_current",
                        title: "电流",
                        width: 80
                    }, {
                        field: "group_voltage",
                        title: "组端电压",
                        width: 80
                    }, {
                        field: "group_temperature",
                        title: "环境温度",
                        width: 80
                    }];

                    for (var i = 0; i < data.length; i++) {
                        if (isV) {
                            columns.push(
                                    {
                                        field: "voltage" + data[i].id,
                                        title: "电压" + (i + 1),
                                        width: 60
                                    }
                            );
                        }

                        if (isT) {
                            columns.push(
                                    {
                                        field: "temperature" + data[i].id,
                                        title: "温度" + (i + 1),
                                        width: 60
                                    }
                            );
                        }

                        if (isR) {
                            columns.push(
                                    {
                                        field: "resistance" + data[i].id,
                                        title: "内阻" + (i + 1),
                                        width: 60
                                    }
                            );
                        }
                    }
                    parameters.historcalReportColumns = JSON.stringify(columns);
                    loadBatteryGridData(columns, row, startDate, endDate, isV, isT, isR);
                }
            }
        });

        $("#historicalReportParamDialog").dialog("close");
    }

    function loadBatteryGridData(columns, row, startDate, endDate, isV, isT, isR) {
        var arrParam = [];
        arrParam.push('"id":' + row.id);
        arrParam.push('"startDate":"' + startDate + '"');
        arrParam.push('"endDate":"' + endDate + '"');
        arrParam.push('"isV":' + isV);
        arrParam.push('"isT":' + isT);
        arrParam.push('"isR":' + isR);
        parameters.hisBatteryParamJson = "{" + arrParam.join(",") + "}";
        console.log(columns,isV,isT,isR);
        var batteryGrid = initBatteryGrid(columns);
        batteryGrid.LoadRemoteData({
            paramsJson: parameters.hisBatteryParamJson
        });
    }

    function initBatteryGrid(columns) {
        var batteryGrid = new XspWeb.Controls.RemoteDataGrid();
        console.log(columns);
        var isFit = true;
        if(columns.length > 20){
            isFit = false;
        }
        batteryGrid.Initialize("#batteryData", parameters.Action.getBatteryPackHisReport, {
            fitColumns: isFit,
            scrollbarSize: 0,
            border: false,
            pagination: true,
            pageSize: 20,
            pageList: [10, 20, 30, 40],
            onLoadSuccess: function (data) {
                if (data.total === 0) {
                    $(this).datagrid('appendRow',
                            {datetime: '<div style="text-align:center;color:#CCCCCC">没有相关记录！</div>'})
                            .datagrid('mergeCells', {index: 0, field: 'datetime', colspan: columns.length});
//                    $(this).datagrid('insertRow',{
//                        row:{}
//                    });
//                    $("tr[datagrid-row-index='0']").css({"visibility":"hidden"});
                }
            }
        }).SetColumns([columns]);

        return batteryGrid;
    }

    function initBatteryPackGrid() {
        var batteryPackGrid = new XspWeb.Controls.RemoteDataGrid();
        batteryPackGrid.Initialize("#batteryGroupData", "${_RootPath}/Historical/getBatteryPackByParams", {
            fit: true,
            border: false,
            pagination: true,
            pageSize: 20,
            pageList: [10, 20, 30, 40],
            onLoadSuccess: function (data) {
                if (data.total === 0) {
                    $(this).datagrid('appendRow',
                            {id: '<div style="text-align:center;color:#cccccc">没有相关记录！</div>'})
                            .datagrid('mergeCells', {index: 0, field: 'id', colspan: 6})
                }
            }
        }).SetColumns([[{
            field: "id",
            title: "编号",
            width: 40
        }, {
            field: "name",
            title: "名称",
            width: 100
        }, {
            title: "电压",
            field: "BtnV",
            ContentType: "button",
            width: 60,
            formatter: function (value, row, index) {
                return "<input id='V_" + row.id + "' type='checkbox'/>";
            }
        }, {
            title: "温度",
            field: "BtnT",
            ContentType: "button",
            width: 60,
            formatter: function (value, row, index) {
                return "<input id='T_" + row.id + "' type='checkbox'/>";
            }
        }, {
            title: "内阻",
            field: "BtnR",
            ContentType: "button",
            width: 60,
            formatter: function (value, row, index) {
                return "<input id='R_" + row.id + "' type='checkbox'/>";
            }
        }, {
            title: "月报下载",
            field: "Btn1",
            ContentType: "button",
            text: "月报查询下载",
            width: 80,
            handler: function (index, row) {
                monthReportDialog(row);
            }
        }, {
            title: "历史数据下载",
            field: "Btn2",
            ContentType: "button",
            text: "历史数据查询下载",
            width: 80,
            handler: function (index, row) {
                historicalReportDialog(row);
            }
        }]]);

        return batteryPackGrid;
    }

    function initAreaComboTree() {
        $('#Areas').combotree({
            url: "${_RootPath}/System/getAreaToComboTreeModel",
            multiple: true,
            checkbox: true
        });
    }

    function initBatteryPackComboGrid(name) {
        var url = "${_RootPath}/System/getBatteryPackLikeName?name=" + name;
        $('#BatteryPackNames').combogrid({
            multiple: true,
            panelWidth: 220,
            idField: 'id',
            textField: 'name',
            url: url,
            columns: [[
                {field: 'id', title: '编号', width: 60, hidden: true},
                {field: 'name', title: '名称', width: 200, align: 'center'}
            ]],
            onChange: function (newValue, oldValue) {
                console.log(newValue,oldValue);
                if (newValue && newValue.length > 0) {
                    var grid = $('#BatteryPackNames').combogrid('grid');
                    var data = grid.datagrid('getData');
                    var arrSelected = [];
                    console.log(data.rows);
                    if (data && data.rows) {
                        for (var i in data.rows) {//selectRow
                            var id = data.rows[i].id;
                                if(id == newValue){
                                    grid.datagrid('selectRow', i);
                                    arrSelected.push(data.rows[i]);
                                }
                        }
                        if (arrSelected && arrSelected.length > 0) {
                            $('#BatteryPackNames').combogrid("setValues", arrSelected);
                            arrSelected.length = 0;
                        }
                    }
                }
            }
        });
    }

    function initYearCombobox() {
        var years = [];
        var date = new Date;
        var nowYear = date.getFullYear();
        for (var i = 2010; i <= nowYear; i++) {
            years.push([i, i]);
        }
        $("#year").combobox({
            data: years,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#year").combobox('select', years[0][0]);

    }

    function initMonthCombobox() {
        var months = [];
        for (var i = 1; i < 13; i++) {
            var str = i;
            if (i < 10) {
                str = "0" + i;
            }
            months.push([str, str]);
        }
        $("#month").combobox({
            data: months,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#month").combobox('select', months[0][0]);
    }

    function initQueryParams() {
        var areaComboTree = $('#Areas').combotree('tree');
        var batteryPackNameComboGrid = $('#BatteryPackNames').combogrid('grid');

        var arrArea = areaComboTree.tree('getChecked');
        var arrBatteryPackIds = batteryPackNameComboGrid.datagrid("getSelections");

        var params = [];
        if (arrArea && arrArea.length > 0) {
            var areaIds = [];
            for (var i = 0; i < arrArea.length; i++) {
                areaIds.push(arrArea[i].id);
            }
            params.push('"areaIds":"' + areaIds.join(',') + '"');
        }

        if (arrBatteryPackIds && arrBatteryPackIds.length > 0) {
            var batteryPackIds = [];
            for (var i = 0; i < arrBatteryPackIds.length; i++) {
                batteryPackIds.push(arrBatteryPackIds[i].id);
            }
            params.push('"batteryPackIds":"' + batteryPackIds.join(',') + '"');
        }

        var paramsJson = '{' + params.join(',') + '}';
        return paramsJson;
    }

    function getBatteryPackByParams(batteryPack) {
        var paramsJson = initQueryParams();
        loadGridData(batteryPack, paramsJson);
    }

    function loadGridData(batteryPack, paramsJson) {
        batteryPack.LoadRemoteData({
            paramsJson: paramsJson
        });
    }

    function downloadMonthReport() {
        if (parameters.monthReportDataSource) {
            XspWeb.Misc.Download(
                    '${_RootPath}/Statistical/downloadBatteryPackMonthReport', {
                        dateSourceJson: JSON.stringify(parameters.monthReportDataSource)
                    });
        }
    }

    function downloadHisReport() {
        if (parameters.historcalReportColumns) {
            XspWeb.Misc.Download(
                    '${_RootPath}/Statistical/downloadBatteryPackHisReport', {
                        paramsJson: parameters.hisBatteryParamJson,
                        dataColumnJson: parameters.historcalReportColumns
                    })
            ;
        }
    }

    function returnBatteryPackDataGrid() {
        $("#batteryPackGrid").attr("style", "display:block;");
        $("#monthReport").attr("style", "display:none;margin-top:5px;");
        $("#returnBtnDiv").css("display", "none");
        $("#titleName").html("");
        $("#downloadDiv").attr("style", "display:none;");
    }

    function returnBatteryPackDataGrid2() {
        $("#div-content1").attr("style", "display:block;");
        $("#div-content2").attr("style", "display:none;");
        parameters.hisBatteryParamJson = null;
        parameters.historcalReportColumns = null;
    }

    function bindBtnEvent(batteryPack) {
        $("#selectBtn").click(function () {
            getBatteryPackByParams(batteryPack);
        });

        $("#returnBtn").click(returnBatteryPackDataGrid);
        $("#returnBtn2").click(returnBatteryPackDataGrid2);
        $("#btnDownload").click(downloadMonthReport);
        $("#btnDownload2").click(downloadHisReport);
    }

    $(function () {
        var batteryPack = initBatteryPackGrid();
        loadGridData(batteryPack, "");
        initBatteryPackComboGrid("");
        initAreaComboTree();
        initYearCombobox();
        initMonthCombobox();
        bindBtnEvent(batteryPack);
    });

</script>
</body>
</html>