<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/5 0005
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>实时数据</title>
</head>
<body>
<style>
    .div-conten {
        width: 840px;
        height: 100%;
        line-height: 100%;
        margin: auto;
    }

    .div-conten-tool {
        width: 840px;
        height: 50px;
        padding-top: 40px;
        padding-bottom: 10px;
    }

    .div-content-content {
        width: 840px;
        height: 500px;
        line-height: 500px;
        background-color: #ffffff;
    }

    .div-conten-tool div {
        float: left;
    }

    .div-conten-tool-dspan {
        width: 120px;
        height: 50px;
        line-height: 50px;
    }

    .input-text-a1 {
        width: 80px;
        height: 30px;
        line-height: 30px;
    }

    .input-text-a2 {
        width: 130px;
        height: 30px;
        line-height: 30px;
    }

    .input-text-b {
        width: 190px;
        height: 25px;
        line-height: 25px;
    }

    .input-button {
        width: 80px;
        height: 30px;
        line-height: 30px;
        background-color: #2596d2;
        color: #ffffff;
        border-radius: 5px;
        border: none;
        margin: 10px 0 0 10px;
    }

    .input-select-div {
        margin-left: 6px;
        margin-top: 15px;
    }

    #heardTitle {
        background-color: #40526A;
        color: #ffffff;
        height: 30px;
        line-height: 30px;
    }

    .cdiv-heard-content {
        height: 130px;
        width: 580px;
        line-height: 130px;
        margin-top: 20px;
        margin-left: auto;
        margin-right: auto;
    }

    .cdiv-heard-content-tr {
        width: 580px;
        height: 25px;
        line-height: 25px;
        text-align: left;
        float: left;
        font-size: 14px;
    }

    .cdiv-table-content {
        height: 280px;
        width: 700px;
        margin-left: auto;
        margin-right: auto;
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

    .msg-div {
        width: 200px;
        height: 40px;
        line-height: 40px;
        margin: auto;
        position: relative;
        top: 35%;
        color: #bfbaba;
        font-size: 30px;
    }

    .div-select {
        height: 50px;
        line-height: 50px;
    }

    #Areas {
        width: 200px;
        height: 30px;
        line-height: 30px;
    }
</style>
<div class="easyui-layout minheightwidth" data-options="fit:true">
    <div data-options="region:'center'" style="background-color: rgb(232, 235, 239);text-align: center;">
        <div class="div-conten">
            <div class="div-conten-tool">
                <div class="div-conten-tool-dspan">区域搜索：</div>
                <div class="div-select">
                    <div style="margin-top: 15px;">
                        <input id="Areas"/>
                    </div>
                </div>
                <div class="div-conten-tool-dspan">电池组搜索：</div>
                <div class="div-select">
                    <div style="margin-top: 15px;">
                        <select id="batteryPackName" class="input-text-b"></select>
                    </div>
                </div>
                <div><input id="heightSelectBtn" class="input-button" type="button" value="搜索"/>
                </div>
            </div>
            <div class="div-content-content">
                <div id="heardTitle"></div>
                <div id="msg-div" class="msg-div">请搜索电池组</div>
                <div id="cdiv-heard-content" class="cdiv-heard-content">
                    <div class="cdiv-heard-content-tr">
                        <div style="width: 85%;float: left"><span>时间：</span><span id="nowDate"></span></div>
                        <div style="float: left;width: 80px;height: 25px;text-align: right;">
                            <%--<input type="button" value="下载"
                                   style="height: 25px;width: 60px;background-color: #2596d2;color: #fff;border: none;border-radius: 5px;"/>--%>
                        </div>
                    </div>
                    <div class="cdiv-heard-content-tr"><span>组电压：</span><span id="mVoltage">120V</span></div>
                    <div class="cdiv-heard-content-tr"><span>电流：</span><span id="mCurrent">100A</span></div>
                    <div class="cdiv-heard-content-tr"><span>环境温度：</span><span id="mBatteryTemperature">35C</span></div>
                    <shiro:hasPermission name="debug">
                        <div class="cdiv-heard-content-tr"><span>基准值：</span><span id="mBatteryPackJZZ"></span></div>
                    </shiro:hasPermission>
                </div>
                <div id="cdiv-table-content" class="cdiv-table-content">
                    <div style="float:left;width: 60px;height: 280px;">
                        <input id="upperGroup" type="button"
                               style="border-color: #ffffff;background-color:#fff;color:#2596d2;width: 40px;height: 40px;position: relative;top: 45%;"
                               value="<<"/>
                    </div>
                    <div style="width:580px;height: 280px;float: left">
                        <table id="batteryGroupRealTimeData"></table>
                    </div>
                    <div style="float: right;width: 60px;height: 280px;">
                        <input id="nextGroup" type="button"
                               style="border-color: #ffffff;background-color:#fff;color:#2596d2;width: 40px;height: 40px;position: relative;top: 45%;"
                               value=">>"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var parameters = {
        Action: {
            getBatteryPackByParams: "${_RootPath}/RealTime/getBatteryPackByParams",
            getPoint1Names: "${_RootPath}/getPoint1Names",
            getPoint2Names: "${_RootPath}/getPoint2Names?pid=",
            getPoint3Names: "${_RootPath}/getPoint3Names?pid="
        },
        dataIndex: 0,
        dataSource: null
    };

    /* 本页面上的区域*/
    function initAreaComboTree() {
        $('#Areas').combotree({
            url: "${_RootPath}/System/getAreaToComboTreeModel",
            multiple: false,
            checkbox: false
        });
    }

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

    // 获取当前时间
    function CurentTime() {
        var now = new Date();

        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日

        var hh = now.getHours();            //时
        var mm = now.getMinutes();          //分
        var ss = now.getSeconds();          //秒

        var clock = year + "-";

        if (month < 10)
            clock += "0";

        clock += month + "-";

        if (day < 10)
            clock += "0";

        clock += day + " ";

        if (hh < 10)
            clock += "0";

        clock += hh + ":";
        if (mm < 10) clock += '0';

        clock += mm + ":";
        if (ss < 10) {
            clock += '0';
        }
        clock += ss;

        return clock;
    }

    function nextGroup() {
        if (parameters.dataIndex < parameters.dataSource.mBatteryPackName.length - 1) {
            parameters.dataIndex++;
            initGridDataView();
        }
    }

    function upperGroup() {
        if (parameters.dataIndex > 0) {
            parameters.dataIndex--;
            initGridDataView();
        }
    }

    function initBatteryGrid() {
        var batteryGrid = new XspWeb.Controls.RemoteDataGrid();
        batteryGrid.Initialize("#batteryGroupRealTimeData", parameters.Action.getBatteryPackByParams, {
            fit: true,
            rownumbers: false,
            border: false,
            scrollbarSize: 0,
            pagination: false,
            showFooter: false,
            onLoadSuccess: function (data) {
                $("#msg-div").css("display", "none");
                $("#cdiv-heard-content").css("display", "block");
                $("#cdiv-table-content").css("display", "block");
            }
        }).SetColumns([[{
            field: "mId",
            title: "电池编号",
            width: 40
        }, {
            field: "mResistance",
            title: "内阻",
            width: 80
        }, {
            field: "mVoltage",
            title: "实时电压",
            width: 80
        }, {
            field: "mTemp",
            title: "实时温度",
            width: 80
        }
            <shiro:hasPermission name="debug">
            , {
                field: "mResistanceReference",
                title: "基准值",
                width: 80
            }
            </shiro:hasPermission>
        ]]);

        return batteryGrid;
    }

    function selectByArea() {
        var areaId = getAreaId();
        if (!areaId) {
            XspWeb.Misc.Tips("请选择区域");
            return;
        }
        var json = '{areaId:"' + areaId + '"}';
        loadBatteryGridDataByAjax(json);
    }

    function selectByBatteryPackId() {
        var id = $("#batteryPackName").combobox("getValue");
        if (!id) {
            XspWeb.Misc.Tips("请选择电池组");
            return;
        }
        var json = '{batteryPackId:"' + id + '"}';
        loadBatteryGridDataByAjax(json);
    }

    // 获取选中区域Ids
    function getAreaId() {
        var areaId = $('#Areas').combotree('getValue');
        return areaId;
    }

    function selectByParams() {
        var arrJson = [];
        var areaId = getAreaId();
        if (areaId) {
            arrJson.push('areaId:"' + areaId + '"');
        }

        var batteryPackId = $("#batteryPackName").combobox("getValue");
        if (batteryPackId) {
            arrJson.push('batteryPackId:"' + batteryPackId + '"');
        }

        var json = '{' + arrJson.join(',') + '}';
        loadBatteryGridDataByAjax(json);

    }

    function loadBatteryGridDataByAjax(paramsJson) {
        $("#msg-div").html("搜索中......");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/RealTime/getBatteryPackByParams",
            data: {
                paramsJson: paramsJson
            },
            success: function (rec) {
                if (rec) {
                    parameters.dataSource = rec;
                    parameters.dataSource.time = CurentTime();
                    initGridDataView();
                }
                else {
                    $("#heardTitle").html("实时数据");
                    $("#cdiv-heard-content").css("display", "none");
                    $("#cdiv-table-content").css("display", "none");
                    $("#msg-div").css("display", "block");
                    $("#msg-div").html("暂无数据");
                }
            }
        });
    }

    function initBatteryPackInfo() {
        $("#heardTitle").html(parameters.dataSource.mAreaStr + " " + parameters.dataSource.mBatteryPackName[parameters.dataIndex] + " 实时数据");
        $("#nowDate").html(parameters.dataSource.time);
        $("#mVoltage").html(parameters.dataSource.mBatteryPackVoltage[parameters.dataIndex] + " V");
        $("#mCurrent").html(parameters.dataSource.mBatteryPackCurrent[parameters.dataIndex] + " A");
        $("#mBatteryTemperature").html(parameters.dataSource.mBatteryPackTemperature[parameters.dataIndex] + "°C");
        <shiro:hasPermission name="debug">
        $("#mBatteryPackJZZ").html(parameters.dataSource.mResistanceReference[parameters.dataIndex]);
        </shiro:hasPermission>
    }

    function initGridDataView() {
        if (parameters.dataSource) {
            initBatteryPackInfo();
            initBatteryGrid();
            $("#batteryGroupRealTimeData").datagrid("loadData", parameters.dataSource.mBatteryGridDataList[parameters.dataIndex]);
            if (parameters.dataIndex === 0) {
                $("#upperGroup").attr("disabled", "disabled");
            } else {
                $("#upperGroup").removeAttr("disabled");
            }

            if (parameters.dataIndex === parameters.dataSource.mBatteryPackName.length - 1) {
                $("#nextGroup").attr("disabled", "disabled");
            } else {
                $("#nextGroup").removeAttr("disabled");
            }
        }
    }

    function initRealTimeDataHtml() {
        initAreaComboTree();
        initBatteryPackCom();
        $("#msg-div").css("display", "block");
        $("#cdiv-heard-content").css("display", "none");
        $("#cdiv-table-content").css("display", "none");
        bindBtnEvent();
    }

    function bindBtnEvent() {
        $("#heightSelectBtn").click(selectByParams);

        $("#nextGroup").click(nextGroup);
        $("#upperGroup").click(upperGroup);
    }

    $(function () {
        initRealTimeDataHtml();
    })
</script>
</body>
</html>