<%--
  Created by IntelliJ IDEA.
  User: Linyudui
  Date: 2016/6/29
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title></title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
</head>
<body>
<style>
    .BatteryPack {
        width: 145px;
        height: 145px;
        background-color: #FFFFFF;
        margin: 0 15px 10px 0;
        float: left;
        border-radius: 10px;
        font-size: 15pt;
        padding: 10px;
        text-align: center;
        box-shadow: 0px 0px 2px 2px #CCC;
    }

    .BatteryPack_outer_ring {
        background-color: #E8ECEF;
        border-radius: 100%;
        width: 115px;
        height: 115px;
        margin: 0px 17px;
        float: left;
    }

    .BatteryPack_inner_ring {
        background-color: #00629f;
        border-radius: 100%;
        width: 100px;
        height: 100px;
        float: left;
        margin: 5px;
        border: 2px solid #FFFFFF;
    }

    .BatteryPack_content {
        width: 100%;
        height: 20px;
        margin-top: 82px;
    }

    .BatteryPack_content_voltage {
        width: 50%;
        height: 100%;
        float: left;
        text-align: left;
        font-size: small;
    }

    .BatteryPack_content_current {
        width: 50%;
        height: 100%;
        float: left;
        text-align: right;
        font-size: small;
    }

    .BatteryPack_ring_content {
        background-color: rgba(0, 0, 0, 0);
        *background-color: rgb(88, 191, 144);
        width: 80px;
        height: 80px;
        margin: 11px 0px 0 10px;
    }

    .BatteryPack_ring_content_ratio {
        background-color: rgba(0, 0, 0, 0);
        width: 100%;
        height: 45%;
        font-size: 30px;
        padding: 15px 0 0 0;
        color: #fff;
        text-align: center;
    }

    .BatteryPack_ring_content_start {
        background-color: rgba(0, 0, 0, 0);
        width: 100%;
        height: 35%;
        font-size: 9pt;
        padding: 0;
        color: #FFFFFF;
        text-align: center;
    }

    .BatteryPack_ring_content_ratio_value {
        background-color: rgba(0, 0, 0, 0);
        width: 70%;
        height: 98%;
        float: left;
        font-size: 23pt;
        font-weight: bold;
        color: #ffffff;
        padding: 0 0 0 5%;
        margin: -3px 0 0 0;
    }

    .BatteryPack_ring_content_ratio_value_b {
        background-color: rgba(0, 0, 0, 0);
        width: 70%;
        height: 100%;
        float: left;
        font-size: 18pt;
        font-weight: bold;
        color: #ffffff;
        padding: 0 0 0 0;
    }

    .BatteryPack_ring_content_ratio_unit {
        background-color: rgba(0, 0, 0, 0);
        width: 20%;
        height: 100%;
        float: left;
    }

    .BatteryPack_ring_content_ratio_unit_a {
        background-color: rgba(0, 0, 0, 0);
        width: 100%;
        height: 50%;
    }

    .BatteryPack_ring_content_ratio_unit_b {
        background-color: rgba(0, 0, 0, 0);
        width: 100%;
        height: 50%;
        color: #FFFFFF;
        font-size: 10pt;
        font-weight: bold;
    }

    .div-flag {
        float: left;
        width: 80px;
        height: 80px;
        border-radius: 100%;
        background-color: #fff;
        margin: 0 0 0 30px;
        box-shadow: 0px 0px 2px 2px #CCC;
        line-height: 30px;
        text-align: center;
        font-size: 16px;
    }

    .div-start {
        height: 185px;
        margin: 35px 0 0 25px;
    }

    .div-flag-panel {
        margin: 0 0 0 50px;
    }

    .tab-input {
        width: 100px;
        height: 30px;
        background-color: #2596d2;
        color: #fff;
        border: none;
        box-shadow: 2px 0px 2px 1px #CCC;
    }

    .tab-input-selected {
        background-color: #FFFFFF;
        color: #000000;
        outline: none;
    }

    .div-biankuang {
        width: 730px;
        height: 300px;
        box-shadow: 0px 0px 3px 3px #CCC;
    }

    .div-chart-content {
        width: 520px;
        height: 300px;
        background-color: #FFFFFF;
        float: left;
    }

    .div-grid-content {
        width: 210px;
        height: 300px;
        background-color: #FFFFFF;
        float: left;
    }

    .div-grid-content .datagrid-header td {
        background: #40526b;
        color: #fff;
    }

    .div-grid-content .datagrid-header td,
    .div-grid-content .datagrid-body td,
    .div-grid-content .datagrid-footer td {
        border: 1px solid #DCDCDC;
        border-left: none;
        border-bottom: none;
    }
</style>
<div class="easyui-layout minheightwidth" data-options="fit:true">
    <div id="westDetail" data-options="region:'west',split:true"
         style="width:600px;background-color: rgba(255, 255, 255,0);">
        <div id="groupStart" class="div-start">
            <div id="BatteryPack_1" class="BatteryPack"><span id="BPserial_number_1">热失控</span>
                <div id="BatteryPack_1_outer_ring" class="BatteryPack_outer_ring">
                    <div id="BatteryPack_1_inner_ring" class="BatteryPack_inner_ring">
                        <div id="BatteryPack_1_ring_content" class="BatteryPack_ring_content">
                            <div id="BatteryPack_1_ring_content_ratio" class="BatteryPack_ring_content_ratio"></div>
                            <div id="BatteryPack_1_ring_content_start" class="BatteryPack_ring_content_start"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="BatteryPack_2" class="BatteryPack"><span id="BPserial_number_2">剩余容量</span>
                <div id="BatteryPack_2_outer_ring" class="BatteryPack_outer_ring">
                    <div id="BatteryPack_2_inner_ring" class="BatteryPack_inner_ring">
                        <div id="BatteryPack_2_ring_content" class="BatteryPack_ring_content">
                            <div id="BatteryPack_2_ring_content_ratio" class="BatteryPack_ring_content_ratio"></div>
                            <div id="BatteryPack_2_ring_content_start" class="BatteryPack_ring_content_start"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="BatteryPack_3" class="BatteryPack"><span id="BPserial_number_3">健康状态</span>
                <div id="BatteryPack_3_outer_ring" class="BatteryPack_outer_ring">
                    <div id="BatteryPack_3_inner_ring" class="BatteryPack_inner_ring">
                        <div id="BatteryPack_3_ring_content" class="BatteryPack_ring_content">
                            <div id="BatteryPack_3_ring_content_ratio" class="BatteryPack_ring_content_ratio"></div>
                            <div id="BatteryPack_3_ring_content_start" class="BatteryPack_ring_content_start"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="div-flag-panel">
            <div id="startFlag" class="div-flag"></div>
            <div id="voltotal" class="div-flag"></div>
            <div id="curren" class="div-flag"></div>
            <div id="temp" class="div-flag"></div>
        </div>
    </div>
    <div id="centerDetail" data-options="region:'center',split:true"
         style="width:550px;background-color: rgba(255, 255, 255,0);">
        <div id="div-chart">
            <input class="tab-input tab-input-selected" id="btnT" type="button" value="温度"/>
            <input class="tab-input" id="btnR" type="button" value="内阻"/>
            <input class="tab-input" class="tab-input" id="btnV" type="button" value="电压"/>
            <div class="div-biankuang">
                <div id="batteryChart" class="div-chart-content">
                </div>
                <div class="div-grid-content">
                    <div style="width: 195px;height: 230px;padding: 50px 0 0 0">
                        <table id="batteryGrid"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var parameters = {
        Public: {
            mBatteryPackId: null,
            dataType: 0,
            myChart: null,
            batteryPackTimeout: false,
            isGroupDetailInit: false
        }
    };

    /* 电池组状态视图 */
    // 初始化数据
    function initBatteryPackStartData(obj) {
        // console.log(obj);
        $("#BatteryPack_2_ring_content_ratio").html(obj.mBatteryPack.mElectricity + "%");

        var mElectricitySarte = getmElectricityState(obj.mBatteryPack.mElectricity);
        $("#BatteryPack_2_ring_content_start").html(mElectricitySarte);

        $("#BatteryPack_1_inner_ring").css("background-image", "url(resources/images/reshikong.png)");

        var mThermalRunawayState = getmThermalRunawayState(obj.mBatteryPack.mThermalRunawayState);
        $("#BatteryPack_1_ring_content_start").html(mThermalRunawayState);

        $("#BatteryPack_1_inner_ring").css("background-repeat", "no-repeat");
        $("#BatteryPack_1_inner_ring").css("background-position", "20px 5px");
        $("#BatteryPack_1_inner_ring").css("background-size", "60px 65px");

        var mHealthyState = getmHealthyState(obj.mBatteryPack.mHealthyState);
        $("#BatteryPack_3_ring_content_start").html(mHealthyState);

        var monitorStatusImgSrc = getmCurrentState(obj.mMonitorStatus);
        $("#startFlag").css("background-image", monitorStatusImgSrc);

        $("#startFlag").css("background-repeat", "no-repeat");
        $("#startFlag").css("background-position", "20px 27px");
        $("#startFlag").css("background-size", "40px 40px");
        $("#voltotal").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">电压</span><span style="display:block">' + obj.mBatteryPack.mVoltage + 'V</span>');
        $("#curren").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">电流</span><span style="display:block">' + obj.mBatteryPack.mCurrent + 'A</span>');
        $("#temp").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">温度</span><span style="display:block">' + obj.mBatteryPack.mBatteryTemperature + '℃</span>');
    }

    // 获取电池组热失控状态
    function getmThermalRunawayState(mThermalRunawayState) {
        if (!mThermalRunawayState) {
            $("#BatteryPack_1_inner_ring").css("background-color", "#00A600");
            return "正常";
        }
        else {
            $("#BatteryPack_1_inner_ring").css("background-color", "#F75000");
            return "高危";
        }
    }

    // 获取电池组容量状态
    function getmElectricityState(mElectricity) {
        if (mElectricity > 80) {
            $("#BatteryPack_2_inner_ring").css("background-color","#00629f");
            return "较高";
        } else if (mElectricity > 50) {
            $("#BatteryPack_2_inner_ring").css("background-color","#0080FF");
            return "中等";
        } else if (mElectricity > 20) {
            $("#BatteryPack_2_inner_ring").css("background-color","#46A3FF");
            return "偏低";
        } else {
            $("#BatteryPack_2_inner_ring").css("background-color","#FF0000");
            return "低";
        }
    }

    // 获取电池组健康状态
    function getmHealthyState(mHealthyState) {
        if (mHealthyState == "NO_BATT_LIFE_ALARM") {//NoBattLifeAlarm
            $("#BatteryPack_3_inner_ring").css("background-color","#00A600");
            return "健康";
        }
        else if (mHealthyState == "BATT_LIFE_ALARM_1") {//BattLifeAlarm1
            $("#BatteryPack_3_inner_ring").css("background-color","#FFFF37");
            return "低于50%";
        }
        else if (mHealthyState == "BATT_LIFE_ALARM_2") {//BattLifeAlarm2
            $("#BatteryPack_3_inner_ring").css("background-color","#FF8000");
            return "低于30%";
        }
        else if (mHealthyState == "BATT_LIFE_ALARM_3") {//BattLifeAlarm3
            $("#BatteryPack_3_inner_ring").css("background-color","#FF0000");
            return "接近终止";
        }
        /*else if (mHealthyState == 4) {
         return "故障";
         }*/
        else {
            return "未知";
        }
    }

    // 获取电池组充放电状态
    function getmCurrentState(monitorStatus) {

        if (!monitorStatus || monitorStatus === "NoBatteryPack") {
            $("#startFlag").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">无电池组</span>');
            return '#';
        } else if (monitorStatus === "Charge") {
            $("#startFlag").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">充电</span>');
            return "url(resources/images/bigcongdian.png";
        } else if (monitorStatus === "Discharge") {
            $("#startFlag").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">放电</span>');
            return "url(resources/images/bigfangdian.png";
        } else if (monitorStatus === "FloatCharge") {
            $("#startFlag").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">浮充</span>');
            return "url(resources/images/bigcongdian.png";
        } else {
            $("#startFlag").html('<span style="margin-top:5px;display:block;line-height: 30px;color: #ccc;">非充非放</span>');
            return "url(resources/images/bigcongdian.png";
        }
    }

    /* 单体实时数据视图 */
    // 初始化Tab标签
    function initTabBtn(obj) {
        var oDivChart = document.getElementById("div-chart");
        if (oDivChart) {
            var aBtn = oDivChart.getElementsByTagName("input");
            for (var i = 0; i < aBtn.length; i++) {
                aBtn[i].index = i;
                aBtn[i].onclick = function () {
                    for (var i = 0; i < aBtn.length; i++) {
                        aBtn[i].className = "tab-input";
                    }
                    this.className = "tab-input tab-input-selected";
                    //initBatteryGrid();
                    var type = this.index;
                    //setBatteryGridShowColum(type);// 根据tabs显示相应列
                    parameters.Public.dataType = type;
                    var batteryRealTimeData = initChartOptionData(obj);
                    parameters.Public.myChart = initBatteryChart(batteryRealTimeData);
                }
            }
        }
    }

    // 设置单体Grid数据根据当前选择Tab
    function setBatteryGridShowColum(type) {
        // 选择温度标签
        if (type == 0) {
            $("#batteryGrid").datagrid('showColumn', 'mTemp');
            $("#batteryGrid").datagrid('hideColumn', 'mResistance');
            $("#batteryGrid").datagrid('hideColumn', 'mVoltage');

        }
        // 选择内阻标签
        else if (type == 1) {
            $("#batteryGrid").datagrid('hideColumn', 'mTemp');
            $("#batteryGrid").datagrid('showColumn', 'mResistance');
            $("#batteryGrid").datagrid('hideColumn', 'mVoltage');

        }
        // 选择电压标签
        else if (type == 2) {
            $("#batteryGrid").datagrid('hideColumn', 'mTemp');
            $("#batteryGrid").datagrid('hideColumn', 'mResistance');
            $("#batteryGrid").datagrid('showColumn', 'mVoltage');
        }
    }

    // 获取图表单体温度实时数据
    function getBatteryRealTimeTemp(obj) {
        var t1 = obj.data.mCircuits.mBatteryPack.mBatteryTeamperaturelevel1;
        var t2 = obj.data.mCircuits.mBatteryPack.mBatteryTeamperaturelevel2;
        var yMax = 70;
        var formatter = '{value}℃';
        var xAxis = [];
        var data = [];
        var data1 = [];
        var mBatteryList = obj.data.mBatteryPack.rows;
        var m = [];
        for(var i = 0; i < mBatteryList.length; i++){
            mBatteryList[i]['index'] = i+1;
            m.push(mBatteryList[i]);
        }
        m.sort(function(a,b){
            return b.mTemp -  a.mTemp
        })
        for (var i = 0; i < m.length; i++) {
            /*xAxis.push((i + 1)mBatteryList[i].mId + "号");*/
            xAxis.push(m[i].index + "号");
            var obj = {value:m[i].mTemp,isWarn:m[i].mAlarmState};
            data.push(m[i].mTemp);
            data1.push(obj);
        }

        var dataObj = {
            name: "实时温度",
            rData: data,
            xAxis: xAxis,
            yMax: yMax,
            formatter: formatter,
            alarmFlagData: data1,
            alarmFlag: [t1, t2]
        }

        return dataObj;
    }

    // 获取图表单体内阻实时数据
    function getBatteryRealTimeR(obj) {
        var r1 = obj.data.mCircuits.mBatteryPack.mBatteryResistance1;
        var r2 = obj.data.mCircuits.mBatteryPack.mBatteryResistance2;
        var yMax = 35;//700;
        var formatter = '{value}uΩ'
        var xAxis = [];
        var data = [];
        var data1 = [];
        var mBatteryList = obj.data.mBatteryPack.rows;
        var m = [];
        for(var i = 0; i < mBatteryList.length; i++){
            mBatteryList[i]['index'] = i+1;
            m.push(mBatteryList[i]);
        }
        m.sort(function(a,b){
            return b.mResistance -  a.mResistance
        })
        for (var i = 0; i < mBatteryList.length; i++) {
            xAxis.push(m[i].index + "号");
            var obj = {value:m[i].mResistance,isWarn:m[i].mAlarmState};
            data.push(m[i].mResistance);
            data1.push(obj);
        }

        var dataObj = {
            name: "实时内阻",
            rData: data,
            xAxis: xAxis,
            yMax: yMax,
            formatter: formatter,
            alarmFlagData: data1,
            alarmFlag: [r1, r2]
        }

        return dataObj;
    }

    // 获取图表单体电压实时数据
    function getBatteryRealTimeV(obj) {
        var v1 = obj.data.mCircuits.mBatteryPack.mBatteryVoltage1;
        var v2 = obj.data.mCircuits.mBatteryPack.mBatteryVoltage2;
        var formatter = '{value}V';
        var yMax = 35;//300;
        var xAxis = [];
        var data = [];
        var data1 = [];
        var mBatteryList = obj.data.mBatteryPack.rows;
        var m = [];
        for(var i = 0; i < mBatteryList.length; i++){
            mBatteryList[i]['index'] = i+1;
            m.push(mBatteryList[i]);
        }
        m.sort(function(a,b){
            return b.mVoltage -  a.mVoltage
        })
        for (var i = 0; i < mBatteryList.length; i++) {
            xAxis.push(m[i].index + "号");
            var obj = {value:m[i].mVoltage,isWarn:m[i].mAlarmState};
            data.push(m[i].mVoltage);
            data1.push(obj);
        }

        var dataObj = {
            name: "实时电压",
            rData: data,
            xAxis: xAxis,
            yMax: yMax,
            formatter: formatter,
            alarmFlagData: data1,
            alarmFlag: [v1, v2]
        }
        return dataObj;
    }

    // 获取图表单体实时数据
    function getBatteryRealTimeData(obj) {
        if (parameters.Public) {
            var dataObj = null;
            if (parameters.Public.dataType == 0) {
                dataObj = getBatteryRealTimeTemp(obj);
            }
            else if (parameters.Public.dataType == 1) {
                dataObj = getBatteryRealTimeR(obj);
            }
            else if (parameters.Public.dataType == 2) {
                dataObj = getBatteryRealTimeV(obj);
            }

            var realTimeData = {
                name: dataObj.name,
                xAxis: dataObj.xAxis,
                yMax: dataObj.yMax,
                formatter: dataObj.formatter,
                data: dataObj.rData,
                alarmFlagData: dataObj.alarmFlagData,
                alarmFlag: dataObj.alarmFlag
            }

            return realTimeData;
        }
    }

    // 获取设置图表数据配置
    function initChartOptionData(obj) {

        var realTimeData = getBatteryRealTimeData(obj);
        var _series = {
            name: realTimeData.name,
            type: 'line',
            smooth: true,
            z: 2,
            symbol: 'none',
            sampling: 'average',
            itemStyle: {
                normal: {
                    color: 'rgb(149, 197, 235)'
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgb(149, 197, 235)'
                    }, {
                        offset: 1,
                        color: 'rgb(255, 251, 253)'
                    }])
                }
            },
            data: realTimeData.data,
            markLine: {
                data: [
                    {
                        name: '二级告警线',
                        yAxis: realTimeData.alarmFlag[1],
                        itemStyle: {normal: {color: '#b70005'}}
                    },
                    {
                        name: '一级告警线',
                        yAxis: realTimeData.alarmFlag[0],
                        itemStyle: {normal: {color: '#f3eda3'}}
                    }
                ],
                clickable: false
            }
        }


        var initOption = {
            initSeries: _series,
            name: realTimeData.name,
            xAxis: realTimeData.xAxis,
            yMax: realTimeData.yMax,
            formatter: realTimeData.formatter,
            alarmFlagData: realTimeData.alarmFlagData,
            alarmFlag: realTimeData.alarmFlag
        }

        return initOption;
    }

    // 初始化单体图表根据配置数据
    function initBatteryChart(initOption) {

        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('batteryChart'));

        // 指定图表的配置项
        var option = {
            backgroundColor: '#ffffff',
            grid: {
                show: true,
                borderColor: '#FFFFFF',
                backgroundColor: '#FFFFFF'
            },
            tooltip: {
                trigger: 'axis',
                position: function (pt) {
                    return [pt[0], '10%'];
                },
                formatter: function (params) {
                    if (params && params[1] && params[1].name) {
                        var res = params[1].name;
                        res += '<br/>' + params[1].seriesName + ' : ' + params[1].value;
                        return res;
                    }
                    return '警告线';
                }
            }
            ,
            legend: {
                orient: 'horizontal', // 'vertical'
                x: '35', // 'center' | 'left' | {number},
                y: '15', // 'center' | 'bottom' | {number}
                padding: 10,    // [5, 10, 15, 20]
                itemGap: 20,
                data: [
                    {
                        name: initOption.name,
                        icon: 'image',//image://..
                        textStyle: {fontWeight: 'bold', color: '#000'}
                    },
                    {
                        name: '二级警告线',
                        icon: 'image',//image://..
                        textStyle: {fontWeight: 'bold', color: '#000'}
                    },
                    {
                        name: '一级警告线',
                        icon: 'image',//image://..
                        textStyle: {fontWeight: 'bold', color: '#000'}
                    }
                ],
                selectedMode: false
            },
            toolbox: {
                show: false,
                feature: {
                    dataZoom: {
                        yAxisIndex: 'none'
                    }
                }
            }
            ,
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: initOption.xAxis
            }
            ,
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: initOption.formatter
                },
                min: 0,
                /*max: initOption.yMax,*/ //y轴固定
                minTickInterval: 1, //y轴自适应 刻度上允许显示的最小值
                plotLines: [{
                    value: 0,
                    width: 1
                }]
            }
            ,
            dataZoom: [{
                id: 'dataZoomX',
                type: 'slider',
                xAxisIndex: [0],
                filterMode: 'filter',
                startValue: 0,
                endValue: 12,
                zoomLock: true
            }],
            series: [{
                name: '警告标示',
                type: 'bar',
                z: 3000,
                data: initOption.alarmFlagData,
                barWidth: 10,
                itemStyle: {
                    normal: {
                        color: function (params) {
//                            if (params.data >= initOption.alarmFlag[1]) {
//                                return '#b70005';
//                            }
//                            else if (params.data >= initOption.alarmFlag[0]) {
//                                return '#f3eda3';
//                            }
//                            else {
//                                return 'rgba(0,0,0,0)';
//                            }
                            if (params.data.isWarn) {
                                return '#b70005';
                            }
                            else {
                                return 'rgba(0,0,0,0)';
                            }
                        }
                    }
                }
            },
                initOption.initSeries,
                {
                    name: '一级警告线',
                    type: 'line',
                    itemStyle: {
                        normal: {color: '#f3eda3'}
                    }
                }, {
                    name: '二级警告线',
                    type: 'line',
                    itemStyle: {
                        normal: {color: '#b70005'}
                    }
                }
            ]
        }

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        return myChart;
    }

    // 初始化单体表格
    function initBatteryGrid() {
        var batteryGrid = new XspWeb.Controls.RemoteDataGrid();
        batteryGrid.Initialize("#batteryGrid", "${_RootPath}/RealTime/getBatteries", {
            fit: true,
            rownumbers: false,
            border: false,
            scrollbarSize: 0,
            pagination: false,
            showFooter: false,
            queryParams:{
                id: ${mCircuitId},
            }
        }).SetColumns([[{
            field: "mId",
            title: "序号",
            width: 45,
            formatter: function (value, row, index) {
                return index + 1;
            },
            align:'center'
        }, {
            field: "mTemp",
            title: "温度℃",
            width: 70
        }, {
            field: "mResistance",
            title: "内阻uΩ",
            width: 70

        }, {
            field: "mVoltage",
            title: "电压V",
            width: 55
        }]]);

        return batteryGrid;
    }

    // 定时器刷新数据方法(电池组和单体视图初始化后才执行)
    function refreshData(rec) {
        if (rec) {
            if (rec.code == 0) {
                // 设置电池组状态数据
                initBatteryPackStartData(rec.data.mCircuits);
                // 设置单体实时数据
                // chart
                var batteryRealTimeData = getBatteryRealTimeData(rec);
                var option = parameters.Public.myChart.getOption();
                option.series[0].data = batteryRealTimeData.alarmFlagData;
                option.series[1].data = batteryRealTimeData.data;
                option.xAxis[0].data = batteryRealTimeData.xAxis;
                parameters.Public.myChart.setOption(option);
                // grid
                $("#batteryGrid").datagrid("loadData",rec.data.mBatteryPack);
            }
        }
    }
    function compare(property){
        return function(a,b){
            var value1 = a[property];
            var value2 = b[property];
            return value1 - value2;
        }
    }

    // 初始化电池组状态和单体数据视图(页面加载初始化后才执行)
    function initBatteryPackGrid(rec) {
        // 初始化电池组状态视图
        initBatteryPackStartData(rec.data.mCircuits);

        // 初始化单体Tab
        initTabBtn(rec);
        // 初始化单体Grid
        initBatteryGrid();
       //$("#batteryGrid").datagrid("loadData", rec.data.mBatteryPack);
        //setBatteryGridShowColum(parameters.Public.dataType);// 根据tabs显示相应列

        // 初始化单体Chart
        var batteryRealTimeData = initChartOptionData(rec)
        parameters.Public.myChart = initBatteryChart(batteryRealTimeData);

        // 初始化结束标志
        parameters.Public.isGroupDetailInit = true;
    }

    // 初始化页面
    function initGroupDetailHtml() {
        var widthLeft = (document.body.clientWidth) * 1 / 2 - 120;
        var widthRight = (document.body.clientWidth) * 1 / 2;
        $("#westDetail").width(widthLeft);
        $("#centerDetail").width(widthRight);

        parameters.Public.dataType = 0;
        parameters.Public.mCircuitId = ${mCircuitId};
        parameters.Public.batteryPackTimeout = true;
    }

    // 页面加载后初始化
    $(function () {
        initGroupDetailHtml();
    })
</script>
</body>
</html>