<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
</head>
<body class="easyui-layout,fit:true">
<style>
    .sure {
        width: 80px;
        margin-top: 5px;
        height: 30px;
        background-color: #2794d5;
        color: #ffffff;
    }

    .tool-div {
        height: 30px;
    }

    .tool-content {
        width: 100%;
        background-color: #f0f1f9;
        display: block;
    }

    .set-table {
        font-size: 12px;
        margin-left: 30px;
    }

    .title {
        display: block;
        font-size: 14px;
        width: 250px;
        padding-left: 10px;
        padding-top: 10px;
        padding-bottom: 5px;
    }

    .set-fd {
        cursor: pointer;
        width: 100%;
        height: 2px;
        border: #6ec19e solid 1px;
    }
</style>
<div data-options="region:'north'" style="height: 30px;background-color: #f0f1f9;">
    <div id="tool-div" class="tool-div">
        <table class="table1">
            <tr>
                <td><span>回路名称:</span></td>
                <td><input id="circuitName" name="circuitName" class="easyui-textbox" style="width:200px;"></td>
                <td><input id="ecuA_radio" name="ecu" type="radio" value="0" checked="true">无中线</td>
                <td><input id="ecuB_radio" name="ecu" type="radio" value="1">有中线</td>
                <td><a href="javascript:;" id="btn_batteryPack" iconCls="icon-edit" class="easyui-linkbutton"
                       style="width:74px" flag="collapse">电池组</a>
                </td>
                <td><a href="javascript:;" id="btn_device" iconCls="icon-edit" class="easyui-linkbutton"
                       style="width:62px" flag="collapse">设备</a></td>
                <td><a href="javascript:;" id="btn_shrink" iconCls="icon-remove" class="easyui-linkbutton"
                       style="width:62px;display: none;">收缩</a></td>
                <td><a href="javascript:;" id="btn_sensor" iconCls="icon-remove" class="easyui-linkbutton"
                       style="width:98px;">电流传感器</a></td>
            </tr>
        </table>
    </div>
</div>
<div id="tool-content" class="tool-content">
    <div id="ecuA" style="display: block;">
        <span class="title" style="width: 100%">ecuA-配置 <input type="button" id="set_ecuA" value="设置">
            <span>ECU版本：</span><span id="ECUVN1">${versionECU}</span>
            <input type="button" id="refresh_ecuA" value="刷新">
        </span>
        <table class="set-table">
            <tr>
                <td>电压:</td>
                <td><input id="ecuAV0" name="ecuAV0" class="easyui-combobox" style="width: 60px;"></td>
                <td>对应地址：</td>
                <td id="ecuAV0_address">xxxx</td>
                <td>无线通道1：</td>
                <td><input id="ecuA0_canel1" name="ecuA0_canel1" class="easyui-combobox" style="width: 60px;"></td>
                <td>协调器1PANID1：</td>
                <td><input id="ecuA0_panid1" name="ecuA0_panid1" class="easyui-textbox" disabled style="width: 60px;"></td>
                <td>协调器1PANID2：</td>
                <td><input id="ecuA0_panid2" name="ecuA0_panid2" class="easyui-textbox" disabled style="width: 60px;"></td>
            </tr>
            <tr>
                <td>电流:</td>
                <td><input id="ecuAI0" name="ecuAI0" class="easyui-combobox" style="width: 60px;"></td>
                <td>对应地址：</td>
                <td id="ecuAI0_address">xxxx</td>
                <td>无线通道2：</td>
                <td><input id="ecuA0_canel2" name="ecuA0_canel2" class="easyui-combobox" style="width: 60px;"></td>
                <td>协调器2PANID1：</td>
                <td><input id="ecuA0_panid3" name="ecuA0_panid3" class="easyui-textbox" disabled style="width: 60px;"></td>
                <td>协调器2PANID2：</td>
                <td><input id="ecuA0_panid4" name="ecuA0_panid4" class="easyui-textbox" disabled style="width: 60px;"></td>
            </tr>
            <tr>
                <td>环境温度:</td>
                <td>1</td>
                <td>对应地址：</td>
                <td id="ecuAT_address">620</td>
                <td>无线通道3：</td>
                <td><input id="ecuA0_canel3" name="ecuA0_canel3" class="easyui-combobox" style="width: 60px;"></td>
                <td>协调器3PANID1：</td>
                <td><input id="ecuA0_panid5" name="ecuA0_panid5" class="easyui-textbox" disabled style="width: 60px;"></td>
                <td>协调器3PANID2：</td>
                <td><input id="ecuA0_panid6" name="ecuA0_panid6" class="easyui-textbox" disabled style="width: 60px;"></td>
            </tr>
        </table>
    </div>
    <div id="ecuB" style="display: none;">
        <span class="title" style="width:100%">ecuB-配置 <input type="button" id="set_ecuB" value="设置">
            <span>ECU版本：</span><span id="ECUVN2">${versionECU}</span>
            <input type="button" id="refresh_ecuB" value="刷新">
        </span>
        <table class="set-table">
            <tr>
                <td>(正)电压:</td>
                <td><input id="ecuBV1" name="ecuBV1" class="easyui-combobox" style="width: 60px;"></td>
                <td>对应地址：</td>
                <td id="ecuBV1_address">xxxx</td>
                <td>(负)电压:</td>
                <td><input id="ecuBV2" name="ecuBV2" class="easyui-combobox" style="width: 60px;"></td>
                <td>对应地址：</td>
                <td id="ecuBV2_address">xxxx</td>
                <td>无线通道1：</td>
                <td><input id="ecuB0_canel1" name="ecuB0_canel1" class="easyui-combobox" style="width: 60px;"></td>
                <td>协调器1PANID1：</td>
                <td><input id="ecuB0_panid1" name="ecuB0_panid1" class="easyui-textbox" disabled style="width: 60px;"></td>
                <td>协调器1PANID2：</td>
                <td><input id="ecuB0_panid2" name="ecuB0_panid2" class="easyui-textbox" disabled style="width: 60px;"></td>
            </tr>
            <tr>
                <td>(正)电流:</td>
                <td><input id="ecuBI1" name="ecuBI1" class="easyui-combobox" style="width: 60px;"></td>
                <td>对应地址：</td>
                <td id="ecuBI1_address">xxxx</td>
                <td>(负)电流:</td>
                <td><input id="ecuBI2" name="ecuBI2" class="easyui-combobox" style="width: 60px;"></td>
                <td>对应地址：</td>
                <td id="ecuBI2_address">xxxx</td>
                <td>无线通道2：</td>
                <td><input id="ecuB0_canel2" name="ecuB0_canel2" class="easyui-combobox" style="width: 60px;"></td>
                <td>协调器2PANID1：</td>
                <td><input id="ecuB0_panid3" name="ecuB0_panid3" class="easyui-textbox" disabled style="width: 60px;"></td>
                <td>协调器2PANID2：</td>
                <td><input id="ecuB0_panid4" name="ecuB0_panid4" class="easyui-textbox" disabled style="width: 60px;"></td>
            </tr>
            <tr>
                <td>环境温度:</td>
                <td>1</td>
                <td>对应地址：</td>
                <td id="ecuBT_address">620</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>无线通道3：</td>
                <td><input id="ecuB0_canel3" name="ecuB0_canel3" class="easyui-combobox"  style="width: 60px;"></td>
                <td>协调器3PANID1：</td>
                <td><input id="ecuB0_panid5" name="ecuB0_panid5" class="easyui-textbox" disabled style="width: 60px;"></td>
                <td>协调器3PANID2：</td>
                <td><input id="ecuB0_panid6" name="ecuB0_panid6" class="easyui-textbox" disabled style="width: 60px;"></td>
            </tr>
        </table>
    </div>
    <div id="batteryPack" style="display: none;">
        <span class="title">电池组信息 <input type="button" id="set_batteryPack" value="设置"><input type="button" value="检测内阻" style="margin-left: 10px" onclick="checkResistance()"></span>
        <table class="set-table">
            <tr>
                <td>电池组名称：</td>
                <td><input onchange="batteryPackParamChangeEvent(this)" id="batteryPack_name" name="batteryPack_name"
                           class="easyui-textbox" style="width:100px;">
                </td>
                <td>电池组类型：</td>
                <td><input id="type" name="type" style="width:100px;"></td>
                <td>电池电压范围：</td>
                <td><input onchange="batteryPackParamChangeEvent(this)" test="true" id="voltageRange"
                           name="voltageRange" class="easyui-textbox" style="width:100px;">
                </td>
                <td style="display: none;">测试模式：<span id="testMode" testMode="auto">自动</span></td>
            </tr>
            <td>电池节数：</td>
            <td><input onchange="batteryPackParamChangeEvent(this)" test="true" disabled="disabled"
                       id="batteryCount" name="batteryCount" class="easyui-textbox"
                       style="width:100px;"></td>
            <td>电池组容量：</td>
            <td><input onchange="batteryPackParamChangeEvent(this)" test="true" id="capacity" name="capacity"
                       class="easyui-textbox" style="width:100px;"></td>
            <td>自动测试周期：</td>
            <td><input onchange="batteryPackParamChangeEvent(this)" test="true" id="checkCycleTime"
                       name="checkCycleTime" class="easyui-textbox" style="width:100px;">
            </td>
            <td style="display: none;">
                <input id="btnAutoTest" type="button" value="自动" title="根据自动周期进行循环测试"/>
                <input id="btnTest" type="button" value="手动" title="手动点击一次测试一次"/>
            </td>
            </tr>
            <tr>
                <td>特性曲线：</td>
                <td><a href="javascript:;" id="battery_characteristicCurve" class="easyui-linkbutton">导入</a></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td style="display: none;"></td>
            </tr>
        </table>
        <a>
            <div id="set_fd" flag="collapse" class="set-fd" title="展开分度设置"></div>
        </a>
        <div id="fd" style="display: none;">
            <span class="title">数据分度设置</span>
            <table class="set-table">
                <tr>
                    <td>单体电压:</td>
                    <td><input id="batteryV" name="batteryV" class="easyui-combobox" style="width: 60px;"></td>
                    <td>单体内阻:</td>
                    <td><input id="batteryR" name="batteryR" class="easyui-combobox" style="width: 60px;"></td>
                    <td>单体极柱温度:</td>
                    <td><input id="batteryJZT" name="batteryJZT" class="easyui-combobox" style="width: 60px;"></td>
                </tr>
                <tr>
                    <td>组端电压:</td>
                    <td><input id="groupV" name="groupV" class="easyui-combobox" style="width: 60px;"></td>
                    <td>组端电流:</td>
                    <td><input id="groupA" name="groupA" class="easyui-combobox" style="width: 60px;"></td>
                    <td>组端环境温度:</td>
                    <td><input id="groupHJT" name="groupHJT" class="easyui-combobox" style="width: 60px;"></td>
                </tr>
                <tr>
                    <td>组端纹波电压:</td>
                    <td><input id="groupBWV" name="groupBWV" class="easyui-combobox" style="width: 60px;"></td>
                    <td colspan="2">组端绝缘泄露电流:</td>
                    <td colspan="2"><input id="groupJUXLA" name="groupJUXLA" class="easyui-combobox"
                                           style="width: 60px;">
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div id="device" style="display: none">
        <span class="title">设备信息<input type="button" id="set_device" value="设置"></span>
        <table class="set-table">
            <tr>
                <td>设备名称：</td>
                <td><input id="device_name" name="device_name" class="easyui-textbox" style="width:100px;"></td>
                <td>ModBus总线地址：</td>
                <td><input id="address" name="address" class="easyui-textbox" style="width:100px;"></td>
                <td>端口号：</td>
                <td><input id="port" name="port" class="easyui-textbox" style="width:100px;"></td>
                <%--<td>波特率：</td>
                <td><input id="baudRate" name="baudRate" class="easyui-textbox" style="width:100px;"></td>--%>
                <td>读取超时：</td>
                <td><input id="readTimeout" name="readTimeout" class="easyui-textbox" style="width:100px;"></td>
                <td>写入超时：</td>
                <td><input id="writeTimeout" name="writeTimeout" class="easyui-textbox" style="width:100px;"></td>
            </tr>
        </table>
    </div>
    <div id="sensorDiv" style="display: none;">
        <table class="set-table">
            <tr>
                <td>充电电流传感器额定输入电流：</td>
                <td><input id="inputCurrent"  class="easyui-textbox" style="width:100px;"></td>
                <td>充电电流传感器额定输出电压：</td>
                <td><input id="outputVoltage"  class="easyui-textbox" style="width:100px;"></td>
                <td><input type="button" value="设置传感器" onclick="setCurrentDucer()"></td>
            </tr>
            <tr>
                <td>放电电流传感器额定输入电流：</td>
                <td><input id="inputCurrent2"  class="easyui-textbox" style="width:100px;"></td>
                <td>放电电流传感器额定输出电压：</td>
                <td><input id="outputVoltage2"  class="easyui-textbox" style="width:100px;"></td>
                <td><input type="button" value="获取传感器" onclick="getCurrentDucer()"></td>
            </tr>
        </table>
    </div>
</div>
<div id="bcu_grid_content" data-options="region:'center'" style="height: 470px;display: none;">
    <table id="dg"></table>
</div>
<div data-options="region:'south'" style="text-align: center;">
    <input class="sure" type="button" id="btnSure" value="确定"/>
</div>
<div style="display: none;">
    <div id="uploadDialog">
        <div style="width: 200px;left: 80px;top: 24px;">
            <form id="from1" enctype="multipart/form-data"
                  method="post">
                上传文件1：<input type="file" name="file1"/>
            </form>
        </div>
    </div>
    <div id="checkResistance">
        <div style="left: 80px;top: 24px;text-align: center;margin: 30px auto;">
            请确认是否要测试内阻
        </div>
    </div>
</div>
<script src="${_RootPath}/resources/scripts/datagrid-detailview.js" type="text/javascript"></script>
<script type="text/javascript">

    /**
     * 提交参数
     */
    var submitData = {

        /**
         * 单体数组参数
         */
        batteries: null,

        /**
         * 电池组参数
         */
        batteryPack: null
    };

    /**
     * 回传参数
     */
    var parameters = {

        /**
         * 回路信息
         */
        circuit:${circuit},

        /**
         * 设备信息
         */
        deviceInfo:${deviceInfo},

        /**
         * 电池组信息
         */
        batteryPackInfo:${batteryPackInfo},

        /**
         * 单体数组信息
         */
        batteriesInfo:${batteriesInfo}
    };

    console.log(parameters);

    /**
     * 是否初始化列表
     */
    var isBcuGridInit = false;

    /**
     * 列表修改行索引
     */
    var editIndex;

    /**
     * 列表中操作下拉框数据源
     */
    var op = [{"op_flag": "add", "op_text": "增加"}, {"op_flag": "edit", "op_text": "修改"}];

    /**
     * ecuA电压下拉框数据源
     */
    var ecuAV0_data = [{"value": 1, "text": 1}, {"value": 2, "text": 2}, {"value": 3, "text": 3}, {
        "value": 4,
        "text": 4
    }, {"value": 5, "text": 5}, {"value": 6, "text": 6}];

    /**
     * ecuA电流下拉框数据源
     */
    var ecuAI0_data = [{"value": 1, "text": 1}, {"value": 2, "text": 2}, {"value": 3, "text": 3}, {
        "value": 4,
        "text": 4
    }, {"value": 5, "text": 5}, {"value": 6, "text": 6}];

    /**
     * ecuB正电压下拉框数据源
     */
    var ecuBV1_data = [{"value": 1, "text": 1}, {"value": 2, "text": 2}, {"value": 3, "text": 3}, {
        "value": 4,
        "text": 4
    }, {"value": 5, "text": 5}, {"value": 6, "text": 6}];

    /**
     * ecuB负电压下拉框数据源
     */
    var ecuBV2_data = [{"value": 1, "text": 1}, {"value": 2, "text": 2}, {"value": 3, "text": 3}, {
        "value": 4,
        "text": 4
    }, {"value": 5, "text": 5}, {"value": 6, "text": 6}];

    /**
     * ecuB正电流下拉框数据源
     */
    var ecuBI1_data = [{"value": 1, "text": 1}, {"value": 2, "text": 2}, {"value": 3, "text": 3}, {
        "value": 4,
        "text": 4
    }, {"value": 5, "text": 5}, {"value": 6, "text": 6}];

    /**
     * ecuB负电流下拉框数据源
     */
    var ecuBI2_data = [{"value": 1, "text": 1}, {"value": 2, "text": 2}, {"value": 3, "text": 3}, {
        "value": 4,
        "text": 4
    }, {"value": 5, "text": 5}, {"value": 6, "text": 6}];


    var ecuA0_canel1_data = [{"index":0,"value":'0B',"text":'0B'},{"index":1,"value":'0C',"text":'0C'},{"index":2,"value":'0D',"text":'0D'},{"index":3,"value":'0E',"text":'0E'}
    ,{"index":4,"value":'0F',"text":'0F'},{"index":5,"value":'10',"text":'10'},{"index":6,"value":'11',"text":'11'},{"index":7,"value":'12',"text":'12'},{"index":8,"value":'13',"text":'13'},
        {"index":9,"value":'14',"text":'14'},{"index":10,"value":'15',"text":'15'},{"index":11,"value":'16',"text":'16'},{"index":12,"value":'17',"text":'17'},{"index":13,"value":'18',"text":'18'},
        {"index":14,"value":'19',"text":'19'},{"index":15,"value":'1A',"text":'1A'}];

    var ecuA0_canel2_data = [{"index":0,"value":'0B',"text":'0B'},{"index":1,"value":'0C',"text":'0C'},{"index":2,"value":'0D',"text":'0D'},{"index":3,"value":'0E',"text":'0E'}
        ,{"index":4,"value":'0F',"text":'0F'},{"index":5,"value":'10',"text":'10'},{"index":6,"value":'11',"text":'11'},{"index":7,"value":'12',"text":'12'},{"index":8,"value":'13',"text":'13'},
        {"index":9,"value":'14',"text":'14'},{"index":10,"value":'15',"text":'15'},{"index":11,"value":'16',"text":'16'},{"index":12,"value":'17',"text":'17'},{"index":13,"value":'18',"text":'18'},
        {"index":14,"value":'19',"text":'19'},{"index":15,"value":'1A',"text":'1A'}];

    var ecuA0_canel3_data = [{"index":0,"value":'0B',"text":'0B'},{"index":1,"value":'0C',"text":'0C'},{"index":2,"value":'0D',"text":'0D'},{"index":3,"value":'0E',"text":'0E'}
        ,{"index":4,"value":'0F',"text":'0F'},{"index":5,"value":'10',"text":'10'},{"index":6,"value":'11',"text":'11'},{"index":7,"value":'12',"text":'12'},{"index":8,"value":'13',"text":'13'},
        {"index":9,"value":'14',"text":'14'},{"index":10,"value":'15',"text":'15'},{"index":11,"value":'16',"text":'16'},{"index":12,"value":'17',"text":'17'},{"index":13,"value":'18',"text":'18'},
        {"index":14,"value":'19',"text":'19'},{"index":15,"value":'1A',"text":'1A'}];

    var ecuB0_canel1_data =[{"index":0,"value":'0B',"text":'0B'},{"index":1,"value":'0C',"text":'0C'},{"index":2,"value":'0D',"text":'0D'},{"index":3,"value":'0E',"text":'0E'}
        ,{"index":4,"value":'0F',"text":'0F'},{"index":5,"value":'10',"text":'10'},{"index":6,"value":'11',"text":'11'},{"index":7,"value":'12',"text":'12'},{"index":8,"value":'13',"text":'13'},
        {"index":9,"value":'14',"text":'14'},{"index":10,"value":'15',"text":'15'},{"index":11,"value":'16',"text":'16'},{"index":12,"value":'17',"text":'17'},{"index":13,"value":'18',"text":'18'},
        {"index":14,"value":'19',"text":'19'},{"index":15,"value":'1A',"text":'1A'}];

    var ecuB0_canel2_data = [{"index":0,"value":'0B',"text":'0B'},{"index":1,"value":'0C',"text":'0C'},{"index":2,"value":'0D',"text":'0D'},{"index":3,"value":'0E',"text":'0E'}
        ,{"index":4,"value":'0F',"text":'0F'},{"index":5,"value":'10',"text":'10'},{"index":6,"value":'11',"text":'11'},{"index":7,"value":'12',"text":'12'},{"index":8,"value":'13',"text":'13'},
        {"index":9,"value":'14',"text":'14'},{"index":10,"value":'15',"text":'15'},{"index":11,"value":'16',"text":'16'},{"index":12,"value":'17',"text":'17'},{"index":13,"value":'18',"text":'18'},
        {"index":14,"value":'19',"text":'19'},{"index":15,"value":'1A',"text":'1A'}];

    var ecuB0_canel3_data = [{"index":0,"value":'0B',"text":'0B'},{"index":1,"value":'0C',"text":'0C'},{"index":2,"value":'0D',"text":'0D'},{"index":3,"value":'0E',"text":'0E'}
        ,{"index":4,"value":'0F',"text":'0F'},{"index":5,"value":'10',"text":'10'},{"index":6,"value":'11',"text":'11'},{"index":7,"value":'12',"text":'12'},{"index":8,"value":'13',"text":'13'},
        {"index":9,"value":'14',"text":'14'},{"index":10,"value":'15',"text":'15'},{"index":11,"value":'16',"text":'16'},{"index":12,"value":'17',"text":'17'},{"index":13,"value":'18',"text":'18'},
        {"index":14,"value":'19',"text":'19'},{"index":15,"value":'1A',"text":'1A'}];

    var panid1_data = ['0B0B','0C0C','0D0D','0E0E','0F0F','1010','1111','1212','1313','1414','1515','1616','1717','1818','1919','1A1A'];

    var panid2_data = ['0B1B','0C1C','0D1D','0E1E','0F1F','1020','1121','1222','1323','1424','1525','1626','1727','1828','1929','1A2A'];


    /**
     * 设备信息视图-初始化内容
     */
    function initDeviceInfoView() {
        if (parameters.deviceInfo.code == 0) {
            var data = parameters.deviceInfo.data;
            if (data) {
                var config = JSON.parse(data.config);
                $("#device_name").val(data.name);
                $("#port").val(config.Port ? config.Port : 0);
                $("#address").val(config.Address ? config.Address : 0);
                /*$("#baudRate").val(config.BaudRate ? config.BaudRate : 0);*/
                $("#readTimeout").val(config.ReadTimeout ? config.ReadTimeout : 0);
                $("#writeTimeout").val(config.WriteTimeout ? config.WriteTimeout : 0);
            }
        }
    }

    function setCurrentDucer(){

        var circuitId = parameters.circuit.id;
        if (!Business.Misc.validateNumber($('#inputCurrent').val())) {
            XspWeb.Misc.Tips("充电电流传感器额定输入电流必须是数字");
            return;
        }

        if (!Business.Misc.validateNumber($('#outputVoltage').val())) {
            XspWeb.Misc.Tips("充电电流传感器额定输出电压必须是数字");
            return;
        }

        if (!Business.Misc.validateNumber($('#inputCurrent2').val())) {
            XspWeb.Misc.Tips("放电电流传感器额定输入电流必须是数字");
            return;
        }

        if (!Business.Misc.validateNumber($('#outputVoltage2').val())) {
            XspWeb.Misc.Tips("放电电流传感器额定输出电压必须是数字");
            return;
        }

        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/setCurrentDucer",
            data: {
                circuitId: circuitId,
                chargeInputCurrent:$('#inputCurrent').val(),
                chargeOutputVoltage:$('#outputVoltage').val(),
                dischargeInputCurrent:$('#inputCurrent2').val(),
                dischargeOutputVoltage:$('#outputVoltage2').val()
            },
            success: function (rec) {
                XspWeb.Misc.Tips(rec.message);
            }
        });
    }

    function getCurrentDucer(){
        var circuitId = parameters.circuit.id;
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getCurrentDucer",
            data: {
                circuitId: circuitId,
            },
            success: function (rec) {
                if(rec.data != null){
                    $('#inputCurrent').val(rec.data.chargeInputCurrent);
                    $('#outputVoltage').val(rec.data.chargeOutputVoltage),
                    $('#inputCurrent2').val(rec.data.dischargeInputCurrent),
                    $('#outputVoltage2').val(rec.data.dischargeOutputVoltage)
                }else{
                    XspWeb.Misc.Tips(rec.message);
                }
            }
        });
    }

    function checkResistance() {
        var obj = $("#checkResistance");

        XspWeb.Misc.Dialog(obj, {
            title: "提示",
            width: 400,
            height: 150,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "确定",
                handler: function () {
                    var circuitId = parameters.circuit.id;
                    console.log(circuitId);
                    XspWeb.Misc.Ajax({
                        action: "${_RootPath}/System/checkResistance",
                        data: {
                            circuitId: circuitId
                        },
                        success: function (rec) {
                            XspWeb.Misc.Tips(rec.message);
                            if (rec.code == 0) {
                                obj.dialog('close');
                            }
                        }
                    });
                }
            }]
        });
    }

    /**
     * 电池组信息视图-初始化内容
     */
    function initBatteryPackInfoView() {
        if (parameters.batteryPackInfo.code == 0) {
            var data = parameters.batteryPackInfo.data;
            if (data) {
                $("#batteryPack_name").val(data.batteryPack_name);
                $("#batteryCount").val(data.batteryCount);
                $("#type").combobox('setValue', data.type);
                $("#voltageRange").val(data.voltageRange);
                $("#checkCycleTime").val(data.checkCycleTime);
                $("#capacity").val(data.capacity);
            }
        }
    }

    /**
     * 初始化电池组参数
     */
    function initBatteryPackEditInfo() {
        if (parameters.batteryPackInfo.code === 0) {
            submitData.batteryPack = parameters.batteryPackInfo.data;
            // console.log(submitData.batteryPack);
        }
    }

    /**
     * 初始化电池组单体参数
     */
    function initBatteriesEditInfo(count) {
        if ((parameters.batteriesInfo.code === 0) && (parameters.batteriesInfo.data.length === count)) {
            submitData.batteries = parameters.batteriesInfo.data;
            for (var i = 0; i < submitData.batteries.length; i++) {
                submitData.batteries[i].no = submitData.batteries[i].id;
                submitData.batteries[i].isAlarm = submitData.batteries[i].alarm;
            }
            // console.log(submitData.batteries);
        }
    }


    /**
     * 电池组类型下拉框
     * */
    function batteryPackCombobox() {
        var data = [{"value": 0, "text": "2V"}, {"value": 1, "text": "12V"}];
        $("#type").combobox({
            data: data,
            textField: "text",
            valueField: "value",
            editable: false,
            onSelect: function (record) {
                if (record)
                    submitData.batteryPack.type = record.value;
                // console.log(submitData.batteryPack);
            }
        });
    }

    /**
     * 单体规格下拉框
     * */
    function batteryCombobox(index) {
        var data = [{"value": 0, "text": "2V"}, {"value": 1, "text": "12V"}];
        $("#battery_specifications_" + (index + 1)).combobox({
            data: data,
            textField: "text",
            valueField: "value",
            editable: false,
            onSelect: function (record) {
                if (record && submitData.batteries) {
                    submitData.batteries[index].battery_specifications = record.value;
                }
            }
        });
    }

    /**
     * 化学组成下拉框
     * */
    function initChemicalComposition(index) {
        var data = [{"value": "BattTypeLithium", "text": "锂电池"},
            {"value": "BattTypeNicad", "text": "镍铬电池"},
            {"value": "BattTypeLeadacid", "text": "铅酸电池"}];
        $("#chemicalComposition_" + (index + 1)).combobox({
            data: data,
            textField: "text",
            valueField: "value",
            editable: false,
            onSelect: function (record) {
                if (record && submitData.batteries) {
                    submitData.batteries[index].chemicalComposition = record.value;
                }
            }
        });
    }

    /**
     * 列表初始化
     */
    function initCircuitGrid() {
        var testGrid = new XspWeb.Controls.RemoteDataGrid();
        testGrid.Initialize("#dg", "${_RootPath}/System/getBCUList", {
                border: false,
                fit: true,
                scrollbarSize: 0,
                pageSize: 500,
                pageList: [10, 20, 30, 40, 60, 80, 100, 500],
                onClickCell: onClickCell,
                view: detailview,
                detailFormatter: function (index, row) {
                    var html = '<span class="title">' + (index + 1) + '号单体信息' +
                        '<input onchange="batteryParamChangeEvent(this,' + index + ')" id="isAlarm_' + (index + 1) + '" type="checkbox" title="是否屏蔽告警">' + '</span>' +
                        '<table class="set-table">' +
                        '<tr>' +
                        '<td>电池名称：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="battery_name_' + (index + 1) + '" name="battery_name" style="width:80px;"></td>' +
                        '<td>厂商名称：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="producerName_' + (index + 1) + '" name="producerName" style="width:80px;"></td>' +
                        '<td>生产日期：</td>' +
                        '<td><input id="productionDate_' + (index + 1) + '" name="productionDate" style="width:80px;"></td>' +
                        '<td>首次使用日期：</td>' +
                        '<td><input id="battery_firstUseDate_' + (index + 1) + '" name="battery_firstUseDate" style="width:80px;"></td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>序列号：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="serialNum_' + (index + 1) + '" name="serialNum" style="width:80px;"></td>' +
                        '<td>条形码编号：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="barcode_' + (index + 1) + '" name="barcode" style="width:80px;"></td>' +
                        '<td>电池规格：</td>' +
                        '<td><input id="battery_specifications_' + (index + 1) + '" name="battery_specifications" style="width:80px;">(2V/12V)</td>' +
                        '<td>电池容量：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="initCapacity_' + (index + 1) + '" name="initCapacity" style="width:80px;">Ah</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>化学组成：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="chemicalComposition_' + (index + 1) + '" name="chemicalComposition" style="width:80px;"></td>' +
                        '<td>浮充电压：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="floatChargeVolt_' + (index + 1) + '" name="floatChargeVolt" style="width:80px;" test="true">V</td>' +
                        '<td>设计浮充寿命：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="floatChargeLife_' + (index + 1) + '" name="floatChargeLife" style="width:80px;">月</td>' +
                        '<td>设计循环寿命：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="circleLife_' + (index + 1) + '" name="circleLife" style="width:80px;">次</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>容量校准点：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="capacityCheckPoInt32_' + (index + 1) + '" name="capacityCheckPoInt32" style="width:80px;" test="true">Ah</td>' +
                        '<td>均充电压：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="equalChargeVolt_' + (index + 1) + '" name="equalChargeVolt" style="width:80px;" test="true">V</td>' +
                        '<td>典型放电容量：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="virtualCapacity_' + (index + 1) + '" name="virtualCapacity" style="width:80px;" test="true">Ah</td>' +
                        '<td>典型放电电流：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="virtualAmp_' + (index + 1) + '" name="virtualAmp" style="width:80px;" test="true">A</td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>单体数量：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="cellNum_' + (index + 1) + '" name="cellNum" style="width:80px;"></td>' +
                        '<td>充电效率：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="chargeRate_' + (index + 1) + '" name="chargeRate" style="width:80px;">%</td>' +
                        '<td>数据刷新周期：</td>' +
                        '<td><input onchange="batteryParamChangeEvent(this,' + index + ')" id="schedulingCycle_' + (index + 1) + '" name="schedulingCycle" style="width:80px;">Min</td>' +
                        '</tr>' +
                        '</table>';
                    return '<div style="height: 160px;width: 100%;background-color: #f0f1f9;">' +
                        html +
                        '</div>';
                },
                onExpandRow: function (index, row) {
                    console.log(row);
                    $("#productionDate_" + (index + 1)).datetimebox({
                        onChange: function (value) {
                            if (submitData.batteries) {
                                submitData.batteries[index].productionDate = value;
                            }
                        }
                    });

                    $("#battery_firstUseDate_" + (index + 1)).datetimebox({
                        onChange: function (value) {
                            if (submitData.batteries) {
                                submitData.batteries[index].battery_firstUseDate = value;
                            }
                        }
                    });
                    batteryCombobox(index);
                    initChemicalComposition(index);
                    getBatteryDataById(row.battery_id, index);
                },
                onLoadSuccess: function (data) {
                    if (data && data.total > 0) {
                        isBcuGridInit = true;
                        initBatteriesEditInfo(data.total);
//                                batteryCombobox(i);
//                                initChemicalComposition(i);
//                                getBatteryDataById(data.rows[i].battery_id, i);
                    }
                }
            }
        ).SetColumns([[{
            field: "type",
            title: "采样类型",
            width: 80,
            formatter: function (value) {
                return "BCU";
            }
        }, {
            field: "battery_num",
            title: "序号",
            width: 80
        }, {
            field: "registerAddress",
            title: "BCU编号",
            width: 80,
            editor: 'text'
        }, {
            field: "BCUBanBen",
            title: "BCU版本",
            width: 80,
            formatter: function (value, row, index) {
                return "V" + index + 1 + "00BCU0";
            }
        }, {
            field: "op",
            title: "操作",
            width: 80,
            editor: {
                type: 'combobox',
                options: {
                    data: op,
                    valueField: "op_flag",
                    textField: "op_text",
                    required: true
                }
            },
            formatter: function (value, row, index) {
                if (value == "add") {
                    row.op = "add";
                    return "增加";
                } else {
                    row.op = "edit";
                    return "修改";
                }
            }
        }, {
            field: "mac",
            title: "MAC",
            width: 80
        }, {
            field: "channel",
            title: "无线信道",
            width: 80,
            editor: 'text'
        }, {
            field: "panId1",
            title: "PANID1",
            width: 80,
            editor: 'text'
        },
            {
                field: "panId2",
                title: "PANID2",
                width: 80,
                editor: 'text'
            }, {
                field: "zigBeeLocal",
                title: "短地址",
                width: 80,
                editor: 'text'
            }, {
                field: "battery_status",
                title: "电池状态",
                width: 80,
                formatter: function (value, row, index) {
                    if (!value) {
                        return "激活";
                    }
                    return "未激活";
                }
            }, {
                field: "BtnSet",
                ContentType: "button",
                text: "设置",
                width: 40,
                handler: function (index, row) {
                    var oldRegisterAddress = row.oldRegisterAddress;
                    if (endEditing()) {
                        $('#dg').datagrid('acceptChanges');
                    }
                    if (row.op === "edit") {
                        sendUpdCmd(index, row, oldRegisterAddress, row.registerAddress);
                    } else {
                        sendAddCmd(index, row);
                    }

                }
            }, {
                field: "BtnReload",
                ContentType: "button",
                text: "刷新",
                width: 40,
                handler: function (index, row) {
                    if (endEditing()) {
                        $('#dg').datagrid('acceptChanges');
                    }
                    sendSelCmd(index, row);
                }
            }, {
                field: "BtnEdit",
                ContentType: "button",
                text: "详细信息",
                width: 80,
                handler: function (index, row) {
                    if (endEditing()) {
                        $('#dg').datagrid('acceptChanges');
                    }
                    var expander = $('#dg').datagrid('getExpander', index);
                    if ((expander) && (expander.hasClass('datagrid-row-expand'))) {
                        $("#productionDate_" + (index + 1)).datetimebox({
                            onChange: function (value) {
                                if (submitData.batteries) {
                                    submitData.batteries[index].productionDate = value;
                                }
                            }
                        });

                        $("#battery_firstUseDate_" + (index + 1)).datetimebox({
                            onChange: function (value) {
                                if (submitData.batteries) {
                                    submitData.batteries[index].battery_firstUseDate = value;
                                }
                            }
                        });
                        batteryCombobox(index);
                        initChemicalComposition(index);

                        getBatteryDataById(row.battery_id, index);

                        $('#dg').datagrid('expandRow', index);
                    }
                    else
                        $('#dg').datagrid('collapseRow', index);
                }
            }, {
                field: "BtnDelete",
                ContentType: "button",
                text: "拆除",
                width: 60,
                handler: function (index, row) {
                    if (!row.battery_state) {
                        // 拆除
                        removeBattery(parameters.circuit.id, row.battery_id);
                    } else {
                        // 恢复
                        recoveryBattery(parameters.circuit.id, row.battery_id);
                    }
                },
                formatter: function (value, row, index) {
                    if (!row.battery_state)
                        return '<a href="javascript:;">拆除</a>';
                    return '<a href="javascript:;">恢复</a>';
                }
            }, {
                field: "alarmDllForParam",
                ContentType: "button",
                text: "查看告警库参数",
                width: 150,
                handler: function (index, row) {
                    console.log(index, row, parameters.circuit.id);
                    var showAlarmDllForParam = new XspWeb.Controls.Dialog("addGroupDialog");
                    showAlarmDllForParam.SetUrl("${_RootPath}/System/alarmDllBatteryForParam?circuitId=" + parameters.circuit.id + "&index=" + index)
                        .SetCallback({
                            name: "showAlarmDllBatteryForParam",
                            callback: function () {
                                showAlarmDllForParam.Hide();
                                if (window.alarmDll_timer) {
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

        return testGrid;
    }

    // 电池恢复
    function recoveryBattery(circuitId, batteryId) {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/recoveryBattery",
            data: {
                circuitId: circuitId,
                batteryId: batteryId
            },
            success: function (data) {
                XspWeb.Misc.Tips(data.message);
                $("#dg").datagrid('reload');
            }
        });
    }

    // 电池拆除
    function removeBattery(circuitId, batteryId) {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/removeBattery",
            data: {
                circuitId: circuitId,
                batteryId: batteryId
            },
            success: function (data) {
                XspWeb.Misc.Tips(data.message);
                $("#dg").datagrid('reload');
            }
        });
    }

    /**
     * 列表行编辑中事件
     */
    function endEditing() {
        if (editIndex == undefined) {
            return true
        }
        if ($('#dg').datagrid('validateRow', editIndex)) {
            $('#dg').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 列表单元格单击事件
     */
    function onClickCell(index, field) {
        if (editIndex != index) {
            if (endEditing()) {
                $('#dg').datagrid('selectRow', index)
                    .datagrid('beginEdit', index);
                var ed = $('#dg').datagrid('getEditor', {index: index, field: field});
                if (ed) {
                    ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                }
                editIndex = index;
            } else {
                setTimeout(function () {
                    $('#dg').datagrid('selectRow', editIndex);
                }, 0);
            }
        }
    }

    /**
     * 列表中设置按钮事件-增加
     */
    var ajaxBCUCount = 0;
    function sendAddCmd(index, row) {

        if(ajaxBCUCount>0){
            XspWeb.Misc.Tips("正在获取数据，请稍等");
            return;
        }

        var circuitId = parameters.circuit.id;
        if (!circuitId) {
            XspWeb.Misc.Tips("请选择一条回路");
            return;
        }

        var registerAddress = row.registerAddress;
        if (!registerAddress) {
            XspWeb.Misc.Tips("请输入编号");
            return;
        }
        if (!Business.Misc.validateNumber(registerAddress)) {
            XspWeb.Misc.Tips("编号必须是数字");
            return;
        }

        var channel = row.channel;
        if (!Business.Misc.validateHex(channel)) {
            XspWeb.Misc.Tips("无线信道必须是16进制数,最小一位最大四位");
            return;
        }

        var zigBeeLocal = row.zigBeeLocal;
        if (!Business.Misc.validateHex(zigBeeLocal)) {
            XspWeb.Misc.Tips("短地址必须是16进制数,最小一位最大四位");
            return;
        }

        var panId1 = row.panId1;
        if (!panId1) {
            XspWeb.Misc.Tips("请输入PANID1");
            return;
        }
        if (!Business.Misc.validateHex(panId1)) {
            XspWeb.Misc.Tips("PANID1必须是16进制数,最小一位最大四位");
            return;
        }

        var panId2 = row.panId2;
        if (!panId2) {
            XspWeb.Misc.Tips("请输入PANID2");
            return;
        }
        if (!Business.Misc.validateHex(panId2)) {
            XspWeb.Misc.Tips("PANID2必须是16进制数,最小一位最大四位");
            return;
        }

        row.panId1 = parseInt(panId1,16);
        row.panId2 = parseInt(panId2,16)
        row.channel = parseInt(channel,16);
        row.zigBeeLocal = parseInt(zigBeeLocal,16);

        var bcuConfig = JSON.stringify(row);

        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/setSfBCUConfig",
            data: {
                circuitId: circuitId,
                bcuConfig: bcuConfig
            },
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        getSfBCU(index);
                    }
                    else {
                        XspWeb.Misc.Tips("下发命令失败");
                    }
                }
                else {
                    XspWeb.Misc.Tips("下发命令失败");
                }
            }
        });
    }

    /**
     * 列表中设置按钮事件-修改
     */
    function sendUpdCmd(index, row, oldRegisterAddress, registerAddress) {

        if(ajaxBCUCount>0){
            XspWeb.Misc.Tips("正在获取数据，请稍等");
            return;
        }

        var oldCircuitId = parameters.circuit.id;
        if (!oldCircuitId) {
            XspWeb.Misc.Tips("请选择一条回路");
            return;
        }

        var channel = row.channel;
        if (!Business.Misc.validateHex(channel)) {
            XspWeb.Misc.Tips("无线信道必须是16进制数,最小一位最大四位");
            return;
        }

        var zigBeeLocal = row.zigBeeLocal;
        if (!Business.Misc.validateHex(zigBeeLocal)) {
            XspWeb.Misc.Tips("短地址必须是16进制数,最小一位最大四位");
            return;
        }

        var panId1 = row.panId1;
        if (!panId1) {
            XspWeb.Misc.Tips("请输入PANID1");
            return;
        }
        if (!Business.Misc.validateHex(panId1)) {
            XspWeb.Misc.Tips("PANID1必须是16进制数,最小一位最大四位");
            return;
        }

        var panId2 = row.panId2;
        if (!panId2) {
            XspWeb.Misc.Tips("请输入PANID2");
            return;
        }
        if (!Business.Misc.validateHex(panId2)) {
            XspWeb.Misc.Tips("PANID2必须是16进制数,最小一位最大四位");
            return;
        }

        var newCircuitId = parameters.circuit.id;
        if (!newCircuitId) {
            XspWeb.Misc.Tips("请选择一条回路");
            return;
        }

        var newRegisterAddress = row.registerAddress;
        if (!newRegisterAddress) {
            XspWeb.Misc.Tips("请输入编号");
            return;
        }
        if (!Business.Misc.validateNumber(newRegisterAddress)) {
            XspWeb.Misc.Tips("编号必须是数字");
            return;
        }

        row.panId1 = parseInt(panId1,16);
        row.panId2 = parseInt(panId2,16)
        row.channel = parseInt(channel,16);
        row.zigBeeLocal = parseInt(zigBeeLocal,16);

        var bcuConfig = JSON.stringify(row);

        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/updateSfBCUConfig",
            data: {
                oldCircuitId: oldCircuitId,
                oldRegisterAddress: oldRegisterAddress,
                newCircuitId: newCircuitId,
                bcuConfig: bcuConfig,
                registerAddress: registerAddress
            },
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        getSfBCU(index);
                    } else {
                        XspWeb.Misc.Tips("下发命令失败");
                    }
                } else {
                    XspWeb.Misc.Tips("下发命令失败");
                }
            }
        });
    }

    /**
     * 列表中刷新按钮事件
     */
    function sendSelCmd(index, row) {

        if(ajaxBCUCount>0){
            XspWeb.Misc.Tips("正在获取数据，请稍等");
            return;
        }

        var circuitId = parameters.circuit.id;
        if (!circuitId) {
            XspWeb.Misc.Tips("请选择一条回路");
            return;
        }

        var registerAddress = row.registerAddress;
        if (!registerAddress) {
            XspWeb.Misc.Tips("请输入编号");
            return;
        }
        if (!Business.Misc.validateNumber(registerAddress)) {
            XspWeb.Misc.Tips("编号必须是数字");
            return;
        }

        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfBCUConfig",
            data: {
                circuitId: circuitId,
                registerAddress: registerAddress
            },
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        getSfBCU(index);
                    } else {
                        XspWeb.Misc.Tips("下发命令失败");
                    }
                } else {
                    XspWeb.Misc.Tips("下发命令失败");
                }
            }
        });
    }

    /**
     * 轮询获取深福BCU
     */
    function getSfBCU(index) {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfBCUConfigData",
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        ajaxBCUCount = 0;
                        $('#dg').datagrid('updateRow', {
                            index: index,
                            row: {
                                channel: rec.data.channel,
                                mac: rec.data.mac,
                                panId1: rec.data.panId1,
                                panId2: rec.data.panId2,
                                zigBeeLocal: rec.data.zigBeeLocal
                            }
                        });
                    }
                    else if (ajaxBCUCount <= 3) {
                        ajaxBCUCount++;
                        setTimeout(function () {
                            getSfBCU(index);
                        }, 1000);
                    }
                    else {
                        XspWeb.Misc.Tips("操作失败");
                        ajaxBCUCount = 0;
                    }
                }
                else {
                    XspWeb.Misc.Tips("操作失败");
                }
            }
        });
    }

    /**
     * 轮询获取深福ECU
     */
    var ajaxECUCount = 0;
    function getSfECU() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfECUConfigData",
            success: function (rec) {
                //console.log(rec);
                if (rec) {
                    if (rec.code === 0) {
                        //alert(rec.data);
                        XspWeb.Misc.Tips("设置成功");
                        ajaxECUCount = 0;
                    }
                    else if (ajaxECUCount <= 3) {
                        ajaxECUCount++;
                        setTimeout(getSfECU, 1000);
                    }
                    else {
                        XspWeb.Misc.Tips("设置失败");
                        ajaxECUCount = 0;
                    }
                }
                else {
                    XspWeb.Misc.Tips("设置失败");
                }
            }
        });
    }

    /**
     * 查看单体详细内容视图-获取内容
     */
    function getBatteryDataById(id, index) {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getBatteryDataById",
            data: {
                id: id
            },
            success: function (rec) {
                if ((rec) && (rec.code == 0)) {
                    initBatteryView(index, rec.data);
                }
                else {
                    XspWeb.Misc.Tips(rec.message);
                }
            }
        });
    }

    /**
     * 查看单体详细内容视图-初始化内容
     */
    function initBatteryView(index, data) {
        console.log(data);
        index = index + 1;
        for (var key in data) {
            var selector = $("#" + key + "_" + index);
            if ((selector) && (key === "alarm")) {
                selector = $("#isAlarm_" + index);
                selector.attr("checked", data[key]);
            }
            else if ((selector) &&
                ((key === "battery_firstUseDate") || (key === "productionDate"))) {
                selector.datetimebox('setValue', data[key]);
            }
            else if ((selector) &&
                ((key === "battery_specifications") || (key === "chemicalComposition")))
                selector.combobox('setValue', data[key]);
            else if (selector)
                selector.val(data[key]);
        }
    }

    /**
     * 修改设备-设备中设置按钮事件
     */
    function editDevice() {
        var json = deviceInfoFormatJson();
        if (!json) {
            return;
        }

        $("#set_device").attr("disabled", "disabled");
        $("#set_device").addClass("disabled");
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/updateDevice",
            data: {
                id: parameters.deviceInfo.data.id,
                config: json
            },
            success: function (rec) {
                XspWeb.Misc.Tips(rec.message);
                $("#set_device").removeAttr("disabled");
                $("#set_device").removeClass("disabled");
            }
        });
    }

    /**
     * 修改电池组-电池组中设置按钮事件
     */
    function editBatteryPack() {
        var arrBatteryJson = JSON.stringify(submitData.batteries);
        var batteryPackParamsJson = JSON.stringify(submitData.batteryPack);
        // console.log(submitData.batteries);
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/editBatteryPack",
            data: {
                arrBatteryJson: arrBatteryJson,
                batteryPackParamsJson: batteryPackParamsJson
            },
            success: function (rec) {
                XspWeb.Misc.Tips(rec.message);
            }
        });
    }

    /**
     * 修改回路-确定按钮事件
     */
    function editCircuit() {

        var circuitName = $("#circuitName").val();
        if (!circuitName) {
            XspWeb.Misc.Tips("回路名称不可以省略！");
            return;
        }

        var batteryGroupId = parameters.circuit.batteryPackId;
        var deviceId = parameters.circuit.deviceId;
        var dataAccuracy = dataAccuracyFormatJson();

        var arrAreaIds = parameters.circuit.areaIds.split(",");
        var areaId = 0;
        if (arrAreaIds) {
            areaId = arrAreaIds[arrAreaIds.length - 1];
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
                areaIdPath:parameters.circuit.areaIds
            },
            success: function (rec) {
                if (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code == 0) {
                        if (typeof XspWeb.Controls.Dialog.Callbacks.editCiruitDialog2 === "function")
                            XspWeb.Controls.Dialog.Callbacks.editCiruitDialog2();
                    }
                }
                $("#btnSure").removeAttr("disabled");
                $("#btnSure").removeClass("disabled");
            }
        });
    }

    /**
     * 封装设备配置数据
     * @return string JSON
     */
    function deviceInfoFormatJson() {
        var configJson = parameters.deviceInfo.data.config;
        if (configJson) {
            var oConfig = JSON.parse(configJson);
            var Address = $("#address").val();
            if (!Address) {
                XspWeb.Misc.Tips("地址未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Address)) {
                XspWeb.Misc.Tips("地址输入有误!");
                return;
            }
            oConfig.Address = Address;

            var Port = $("#port").val();
            if (!Port) {
                XspWeb.Misc.Tips("端口号未填!");
                return;
            }
            if (!Business.Misc.validateNumber(Port)) {
                XspWeb.Misc.Tips("端口号输入有误!");
                return;
            }
            oConfig.Port = Port;

            var ReadTimeout = $("#readTimeout").val();
            if (!Business.Misc.validateNumber(ReadTimeout)) {
                XspWeb.Misc.Tips("读取超时时间输入有误!");
                return;
            }
            oConfig.ReadTimeout = ReadTimeout;

            var WriteTimeout = $("#writeTimeout").val();
            if (!Business.Misc.validateNumber(WriteTimeout)) {
                XspWeb.Misc.Tips("写入超时时间输入有误!");
                return;
            }
            oConfig.WriteTimeout = WriteTimeout;
            configJson = JSON.stringify(oConfig);
        }
        return configJson;
    }

    /**
     * 封装分度数据
     * @return string JSON
     */
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

    /**
     * ecu单选框选中事件
     */
    function ecuRadioCheckedEvent() {
        $("#tool-content").css("display", "block");
//        $("#tool-content").css("height", "120px");

        $("#btn_shrink").attr("style", "width:62px;display: block;");

        if ($("#ecuA_radio")[0].checked) {
            $("#ecuA").attr("style", "display:block;");
            $("#ecuB").attr("style", "display:none;");
            $("#batteryPack").attr("style", "display:none;");
            $("#device").attr("style", "display:none;");
        }
        else {
            $("#ecuA").attr("style", "display:none;");
            $("#ecuB").attr("style", "display:block;");
            $("#batteryPack").attr("style", "display:none;");
            $("#device").attr("style", "display:none;");
        }
        $("#bcu_grid_content").attr("style", "height: 470px;display: none;");
        $("#btn_batteryPack").attr("flag", "collapse");
        $("#set_fd").attr("flag", "collapse");
        $("#btn_device").attr("flag", "collapse");
        $("#btn_sensor").attr("flag", "collapse");
    }

    /**
     * 获取电压对应地址
     */
    function getVMappingAddress(value) {
        if (value == 1) {
            return 600;
        }
        else if (value == 2) {
            return 601;
        }
        else if (value == 3) {
            return 602;
        }
        else if (value == 4) {
            return 603;
        }
        else if (value == 5) {
            return 604;
        }
        else if (value == 6) {
            return 605;
        }
        else {
            return "未找到";
        }
    }

    /**
     * 获取电流对应地址
     */
    function getIMappingAddress(value) {
        if (value == 1) {
            return 610;
        }
        else if (value == 2) {
            return 611;
        }
        else if (value == 3) {
            return 612;
        }
        else if (value == 4) {
            return 613;
        }
        else if (value == 5) {
            return 614;
        }
        else if (value == 6) {
            return 615;
        }
        else {
            return "未找到";
        }
    }

    /**
     * ecuA&ecuB设置
     */
    function setECUNumber() {
        var params = {};

        if ($("#ecuA_radio")[0].checked) {
            if(!Business.Misc.validateHex($("#ecuA0_canel1").combobox('getValue'))){
                XspWeb.Misc.Tips("无线通道1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_canel2").combobox('getValue'))){
                XspWeb.Misc.Tips("无线通道2输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_canel3").combobox('getValue'))){
                XspWeb.Misc.Tips("无线通道3输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_panid1").val())){
                XspWeb.Misc.Tips("协调器1PANID1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_panid2").val())){
                XspWeb.Misc.Tips("协调器1PANID2输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_panid3").val())){
                XspWeb.Misc.Tips("协调器2PANID1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_panid4").val())){
                XspWeb.Misc.Tips("协调器2PANID2输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_panid5").val())){
                XspWeb.Misc.Tips("协调器3PANID1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuA0_panid6").val())){
                XspWeb.Misc.Tips("协调器3PANID2输入有误");
                return;
            }

            params.VoltageAddress =$("#ecuAV0").combobox('getValue');
            params.CurrentAddress = $("#ecuAI0").combobox('getValue');
            params.Channel1 =  parseInt($("#ecuA0_canel1").combobox('getValue'),16);
            params.Channel2 = parseInt($("#ecuA0_canel2").combobox('getValue'),16);
            params.Channel3 = parseInt($("#ecuA0_canel3").combobox('getValue'),16);
            params.PANId1 = parseInt($("#ecuA0_panid1").val(),16);
            params.PANId2 = parseInt($("#ecuA0_panid2").val(),16);
            params.PANId3 = parseInt($("#ecuA0_panid3").val(),16);
            params.PANId4 = parseInt($("#ecuA0_panid4").val(),16);
            params.PANId5 = parseInt($("#ecuA0_panid5").val(),16);
            params.PANId6 = parseInt($("#ecuA0_panid6").val(),16);
        }
        else {

            if(!Business.Misc.validateHex($("#ecuB0_canel1").combobox('getValue'))){
                XspWeb.Misc.Tips("无线通道1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_canel2").combobox('getValue'))){
                XspWeb.Misc.Tips("无线通道2输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_canel3").combobox('getValue'))){
                XspWeb.Misc.Tips("无线通道3输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_panid1").val())){
                XspWeb.Misc.Tips("协调器1PANID1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_panid2").val())){
                XspWeb.Misc.Tips("协调器1PANID2输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_panid3").val())){
                XspWeb.Misc.Tips("协调器2PANID1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_panid4").val())){
                XspWeb.Misc.Tips("协调器2PANID2输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_panid5").val())){
                XspWeb.Misc.Tips("协调器3PANID1输入有误");
                return;
            }
            if(!Business.Misc.validateHex($("#ecuB0_panid6").val())){
                XspWeb.Misc.Tips("协调器3PANID2输入有误");
                return;
            }

            params.VoltageAddress = $("#ecuBV1").combobox('getValue');
            params.CurrentAddress = $("#ecuBI1").combobox('getValue');
            params.NegativeVoltageAddress = $("#ecuBV2").combobox('getValue');
            params.NegativeCurrentAddress = $("#ecuBI2").combobox('getValue');
            params.Channel1 =  parseInt($("#ecuA0_canel1").combobox('getValue'),16);
            params.Channel2 = parseInt($("#ecuA0_canel2").combobox('getValue'),16);
            params.Channel3 = parseInt($("#ecuA0_canel3").combobox('getValue'),16);
            params.PANId1 = parseInt($("#ecuA0_panid1").val(),16);
            params.PANId2 = parseInt($("#ecuA0_panid2").val(),16);
            params.PANId3 = parseInt($("#ecuA0_panid3").val(),16);
            params.PANId4 = parseInt($("#ecuA0_panid4").val(),16);
            params.PANId5 = parseInt($("#ecuA0_panid5").val(),16);
            params.PANId6 = parseInt($("#ecuA0_panid6").val(),16);
        }
        params.batteryCount = parameters.batteryPackInfo.data.batteryCount;
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/setSfECUConfig",
            data: {
                circuitId: parameters.circuit.id,
                paramsJson: JSON.stringify(params)
            },
            success: function (rec) {
                if (rec) {
                    // console.log(rec);
                    if (rec.code === 0)
                        getSfECU();
                }
            }
        });
    }

    /**
     * 电池组参数改变事件
     * @param Object obj 改变对象
     */
    function batteryPackParamChangeEvent(obj) {
        if ($(obj).attr("test")) {
            if (Business.Misc.validateNumber(obj.value)) {
                submitData.batteryPack[obj.id] = obj.value;
            }
            else {
                $("#" + obj.id).val("");
                XspWeb.Misc.Tips("输入有误");
            }
        }
        else {
            submitData.batteryPack[obj.id] = obj.value;
        }
        // console.log(submitData.batteryPack);
    }

    /**
     * 单体信息输入验证
     * @param Object obj 改变对象
     */
    function batteryInputValidation(obj, index) {
        var id = obj.id.replace("_" + (index + 1), "");
        // 电池名称 厂家名称 --- 字符长度验证
        if ((id === "battery_name") || (id === "producerName")) {
            if (obj.value.length > 64) {
                XspWeb.Misc.Tips("输入长度有误,请重新输入");
                $("#" + obj.id).val("");
                return false;
            }
        }
        // 序列号和条形码编号最长32字符
        else if ((id === "serialNum") || (id === "barcode")) {
            if (obj.value.length > 32) {
                XspWeb.Misc.Tips("输入长度有误,请重新输入");
                $("#" + obj.id).val("");
                return false;
            }
        }
        // 电池容量：0~65535Ah;浮充寿命(0~65535月)和循环寿命（0~65535次）
        else if ((id === "initCapacity") ||
            (id === "floatChargeLife") ||
            (id === "circleLife")) {
            if (obj.value < 0 || obj.value > 655535) {
                XspWeb.Misc.Tips("输入有误,请重新输入");
                $("#" + obj.id).val("");
                return false;
            }
        }
        // 正确或不需要验证
        return true;
    }

    /**
     * 单体参数改变事件
     * @param Object obj 改变对象
     */
    function batteryParamChangeEvent(obj, index) {
        if ((submitData.batteries) && (batteryInputValidation(obj, index))) {
            var key = index;
            var id = obj.id.replace("_" + (index + 1), "");
            if (id === "isAlarm") {
                submitData.batteries[key][id] = obj.checked;
            }
            else if ($(obj).attr("test")) {
                if (id === "floatChargeVolt"
                    || id === "equalChargeVolt"
                    || id === "capacityCheckPoInt32"
                    || id === "virtualCapacity"
                    || id === "virtualAmp") {

                    if (Business.Misc.validateFloatNumber(obj.value)) {
                        var value = parseFloat(obj.value);
                        submitData.batteries[key][id] = value.toFixed(2);
                        $("#" + obj.id).val(value.toFixed(2));
                    } else {
                        $("#" + obj.id).val("");
                        XspWeb.Misc.Tips("输入有误");
                    }

                }
                else {
                    if (Business.Misc.validateNumber(obj.value)) {
                        submitData.batteries[key][id] = obj.value;
                    } else {
                        $("#" + obj.id).val("");
                        XspWeb.Misc.Tips("输入有误");
                    }
                }
            }
            else {
                submitData.batteries[key][id] = obj.value;
            }
            // console.log(submitData.batteries[key]);
        }
    }

    /**
     * 导入特性曲线界面
     */
    function importCharacteristicCurveDialog() {
        var obj = $("#uploadDialog");
        XspWeb.Misc.Dialog(obj, {
            title: "导入",
            width: 400,
            height: 150,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "导入",
                handler: function () {
                    importCharacteristicCurveAjax(false);
                }
            }, {
                text: "导入并应用",
                handler: function () {
                    importCharacteristicCurveAjax(true);
                }
            }]
        });
    }

    /**
     * 导入特性曲线事件
     */
    function importCharacteristicCurveAjax(flag) {
        var url = '${_RootPath}/System/importCharacteristicCurve'
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
                    submitData.batteryPack.battery_characteristicCurve = rec;
                    $("#uploadDialog").dialog('close');
                    if (flag) {
                        editBatteryPack();
                    } else {
                        XspWeb.Misc.Tips("导入成功，请设置应用。");
                    }
                }
            }
        });
    }

    /**
     * 绑定按钮事件
     */
    function bindBtnEvent() {

        $("#ecuA0_canel1").combobox({
            data: ecuA0_canel1_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                $('#ecuA0_panid1').val(panid1_data[record.index]);
                $('#ecuA0_panid2').val(panid2_data[record.index]);
            }
        });

        $("#ecuA0_canel2").combobox({
            data: ecuA0_canel2_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                $('#ecuA0_panid3').val(panid1_data[record.index]);
                $('#ecuA0_panid4').val(panid2_data[record.index]);
            }
        });

        $("#ecuA0_canel3").combobox({
            data: ecuA0_canel3_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                $('#ecuA0_panid5').val(panid1_data[record.index]);
                $('#ecuA0_panid6').val(panid2_data[record.index]);
            }
        });

        $("#ecuB0_canel1").combobox({
            data: ecuB0_canel1_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                $('#ecuB0_panid1').val(panid1_data[record.index]);
                $('#ecuB0_panid2').val(panid2_data[record.index]);
            }
        });

        $("#ecuB0_canel2").combobox({
            data: ecuB0_canel2_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                $('#ecuB0_panid3').val(panid1_data[record.index]);
                $('#ecuB0_panid4').val(panid2_data[record.index]);
            }
        });

        $("#ecuB0_canel3").combobox({
            data: ecuB0_canel3_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                $('#ecuB0_panid5').val(panid1_data[record.index]);
                $('#ecuB0_panid6').val(panid2_data[record.index]);
            }
        });


        /**
         * 电池组按钮-点击
         */
        $("#btn_batteryPack").click(function () {
            var flag2 = $(this).attr("flag");
            $("#btn_device").attr("flag", "collapse");
            if (flag2 === "collapse") {
                $("#bcu_grid_content").attr("style", "height: 470px;display: block;");
                // 第一次初始化列表
                if (!isBcuGridInit) {
                    var paramsJson = '${circuit}';
                    var testGrid = initCircuitGrid();
                    testGrid.LoadRemoteData({
                        paramsJson: paramsJson
                    });
                    // 初始化电池组编辑数据
                    initBatteryPackEditInfo();
                }

                $("#tool-content").css("display", "block");

                $("#btn_shrink").attr("style", "width:62px;display: block;");

                $("#ecuA").attr("style", "display:none;");
                $("#ecuB").attr("style", "display:none;");
                $("#batteryPack").attr("style", "display:block;");
                $("#device").attr("style", "display:none;");
                $("#sensorDiv").attr("style", "display:none;");
                $(this).attr("flag", "expand");
            }
            else {
                $("#bcu_grid_content").attr("style", "height: 470px;display: none;");
                $(this).attr("flag", "collapse");
                $("#tool-content").css("display", "none");
                $("#btn_shrink").attr("style", "width:62px;display: none;");
            }
        });

        /**
         * 分度分割线-点击
         */
        $("#set_fd").click(function () {
            var flag2 = $(this).attr("flag");
            if (flag2 === "collapse") {
                $("#set_fd").attr("title", "收缩分度设置");
                $("#tool-content").css("height", "240px");
                $("#fd").attr("style", "display:block;");
                $(this).attr("flag", "expand");
            }
            else {
                $("#set_fd").attr("title", "展开分度设置");
                $("#tool-content").css("height", "130px");
                $("#fd").attr("style", "display:none;");
                $(this).attr("flag", "collapse");
            }
        });

        /**
         * 分度分割线-鼠标移入
         */
        $("#set_fd").mousemove(function () {
            $("#set_fd").css("border", "#b06ec1 solid 1px");
        });
        /**
         * 分度分割线-鼠标移出
         */
        $("#set_fd").mouseout(function () {
            $("#set_fd").css("border", "#6ec19e solid 1px");
        });

        /**
         * 设备按钮-点击
         */
        $("#btn_device").click(function () {
            var flag3 = $(this).attr("flag");
            $("#btn_batteryPack").attr("flag", "collapse");
            $("#bcu_grid_content").attr("style", "height: 470px;display: none;");
            $("#set_fd").attr("flag", "collapse");
            if (flag3 === "collapse") {
                $("#tool-content").css("display", "block");
//                $("#tool-content").css("height", "120px");

                $("#btn_shrink").attr("style", "width:62px;display: block;");

                $("#ecuA").attr("style", "display:none;");
                $("#ecuB").attr("style", "display:none;");
                $("#batteryPack").attr("style", "display:none;");
                $("#device").attr("style", "display:block;");
                $("#sensorDiv").attr("style", "display:none;");

                $(this).attr("flag", "expand");
            }
            else {
                $(this).attr("flag", "collapse");
                $("#tool-content").css("display", "none");
                $("#btn_shrink").attr("style", "width:62px;display: none;");
            }
        });

        $('#btn_sensor').click(function (){
            $("#tool-content").css("display", "block");

            $("#btn_shrink").attr("style", "display:none;");
            $("#ecuA").attr("style", "display:none;");
            $("#ecuB").attr("style", "display:none;");
            $("#batteryPack").attr("style", "display:none;");
            $("#device").attr("style", "display:none;");
            $("#sensorDiv").attr("style", "display:block;");

            $(this).attr("flag", "expand");
        });

        /**
         * 收缩按钮-点击
         */
        $("#btn_shrink").click(function () {
            $("#tool-content").css("display", "none");
            $("#btn_shrink").attr("style", "width:62px;display: none;");
            $("#bcu_grid_content").attr("style", "height: 470px;display: none;");
            $("#btn_batteryPack").attr("flag", "collapse");
            $("#set_fd").attr("flag", "collapse");
            $("#btn_device").attr("flag", "collapse");
        });

        /**
         * 选中ECUA-点击
         */
        $("#ecuA_radio").click(ecuRadioCheckedEvent);

        /**
         * 选中ECUB-点击
         */
        $("#ecuB_radio").click(ecuRadioCheckedEvent);

        /**
         * ECUA数据初始化-电压
         */
        $("#ecuAV0").combobox({
            data: ecuAV0_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                if (record) {
                    $("#ecuAV0_address").html(getVMappingAddress(record.value));
                }
            }
        });

        /**
         * ECUA数据初始化-电流
         */
        $("#ecuAI0").combobox({
            data: ecuAI0_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                if (record) {
                    $("#ecuAI0_address").html(getIMappingAddress(record.value));
                }
            }
        });

        /**
         * ECUB数据初始化-正电压
         */
        $("#ecuBV1").combobox({
            data: ecuBV1_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                if (record) {
                    $("#ecuBV1_address").html(getVMappingAddress(record.value));
                }
            }
        });

        /**
         * ECUB数据初始化-正电流
         */
        $("#ecuBI1").combobox({
            data: ecuBI1_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                if (record) {
                    $("#ecuBI1_address").html(getIMappingAddress(record.value));
                }
            }
        });

        /**
         * ECUB数据初始化-负电压
         */
        $("#ecuBV2").combobox({
            data: ecuBV2_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                if (record) {
                    $("#ecuBV2_address").html(getVMappingAddress(record.value));
                }
            }
        });

        /**
         * ECUB数据初始化-负电流
         */
        $("#ecuBI2").combobox({
            data: ecuBI2_data,
            valueField: "value",
            textField: "text",
            onSelect: function (record) {
                if (record) {
                    $("#ecuBI2_address").html(getIMappingAddress(record.value));
                }
            }
        });

        /**
         * 分度数据初始化-单体电压
         */
        var batteryV = [['1', '1'], ['10', '10'], ['100', '100']];
        $("#batteryV").combobox({
            data: batteryV,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#batteryV ").combobox('select', parameters.circuit.volent);

        /**
         * 分度数据初始化-单体内阻
         */
        var batteryR = [['1', '1'], ['10', '10'], ['100', '100']];
        $("#batteryR").combobox({
            data: batteryR,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#batteryR ").combobox('select', parameters.circuit.resistance);

        /**
         * 分度数据初始化-单体极柱温度
         */
        var batteryJZT = [['0.1', '0.1'], ['1', '1']];
        $("#batteryJZT").combobox({
            data: batteryJZT,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#batteryJZT ").combobox('select', parameters.circuit.temperature);

        /**
         * 分度数据初始化-组端电压
         */
        var groupV = [['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupV").combobox({
            data: groupV,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupV ").combobox('select', parameters.circuit.packVollent);

        /**
         * 分度数据初始化-组端电流
         */
        var groupA = [['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupA").combobox({
            data: groupA,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupA ").combobox('select', parameters.circuit.current);

        /**
         * 分度数据初始化-组端环境温度
         */
        var groupHJT = [['0.1', '0.1'], ['1', '1']];
        $("#groupHJT").combobox({
            data: groupHJT,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupHJT ").combobox('select', parameters.circuit.environTemperature);

        /**
         * 分度数据初始化-组端波纹电压
         */
        var groupBWV = [['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupBWV").combobox({
            data: groupBWV,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupBWV ").combobox('select', parameters.circuit.rippleVoltage);

        /**
         * 分度数据初始化-组端绝缘泄露电流
         */
        var groupJUXLA = [['1', '1'], ['10', '10'], ['100', '100'], ['1000', '1000']];
        $("#groupJUXLA").combobox({
            data: groupJUXLA,
            textField: 1,
            valueField: 0,
            editable: false
        });
        $("#groupJUXLA ").combobox('select', parameters.circuit.leakageCurrent);

        /**
         * 确定按钮事件
         */
        $("#btnSure").click(editCircuit);

        /**
         * 设备设置按钮事件
         */
        $("#set_device").click(editDevice);

        /**
         * 电池组设置按钮事件
         */
        $("#set_batteryPack").click(editBatteryPack);

        /**
         * 导入特性曲线
         */
        $("#battery_characteristicCurve").click(importCharacteristicCurveDialog);

        /**
         * 设置ECUA
         */
        $("#set_ecuA").click(setECUNumber);

        /**
         * 设置ECUB
         */
        $("#set_ecuB").click(setECUNumber);

        /**
         * 手动测试
         */
        $("#btnTest").click(function () {
            $("#checkCycleTime").attr("disabled", "disabled");
            $("#testMode").html("手动");
            $("#testMode").attr("testMode", "");
        });

        /**
         * 自动测试
         */
        $("#btnAutoTest").click(function () {
            $("#checkCycleTime").removeAttr("disabled");
            $("#testMode").html("自动");
            $("#testMode").attr("testMode", "auto");
        });

        $("#refresh_ecuA").click(refreshEcuA);

        $("#refresh_ecuB").click(refreshEcuB);
    }

    function refreshEcuA(){
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfECUConfig",
            data: {
                circuitId: parameters.circuit.id
            },
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        getSfECUA();
                    } else {
                        XspWeb.Misc.Tips("下发命令失败");
                    }
                } else {
                    XspWeb.Misc.Tips("下发命令失败");
                }
            }
        });
    }

    /**
     * 轮询获取深福ECU
     */
    var ajaxECUACount = 0;
    function getSfECUA() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfECUConfigData",
            success: function (rec) {
                console.log(rec);
                if (rec) {
                    if (rec.code === 0) {
                        ajaxECUACount = 0;
                        $('#ecuA0_canel1').combobox('setValue',"0"+parseInt(rec.data.channel1,10).toString(16).toUpperCase());
                        $('#ecuA0_canel2').combobox('setValue',"0"+parseInt(rec.data.channel2,10).toString(16).toUpperCase());
                        $('#ecuA0_canel3').combobox('setValue',"0"+parseInt(rec.data.channel3,10).toString(16).toUpperCase());
                        $('#ecuA0_panid1').val("0"+parseInt(rec.data.panId1,10).toString(16).toUpperCase());
                        $('#ecuA0_panid2').val("0"+parseInt(rec.data.panId2,10).toString(16).toUpperCase());
                        $('#ecuA0_panid3').val("0"+parseInt(rec.data.panId3,10).toString(16).toUpperCase());
                        $('#ecuA0_panid4').val("0"+parseInt(rec.data.panId4,10).toString(16).toUpperCase());
                        $('#ecuA0_panid5').val("0"+parseInt(rec.data.panId5,10).toString(16).toUpperCase());
                        $('#ecuA0_panid6').val("0"+parseInt(rec.data.panId6,10).toString(16).toUpperCase());
                    }
                    else if (ajaxECUCount <= 3) {
                        ajaxECUACount++;
                        setTimeout(getSfECUA, 1000);
                    }
                    else {
                        XspWeb.Misc.Tips("设置失败");
                        ajaxECUACount = 0;
                    }
                }
                else {
                    XspWeb.Misc.Tips("设置失败");
                }
            }
        });
    }

    function refreshEcuB(){
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfECUConfig",
            data: {
                circuitId: parameters.circuit.id
            },
            success: function (rec) {
                if (rec) {
                    if (rec.code === 0) {
                        getSfECUB();
                    } else {
                        XspWeb.Misc.Tips("下发命令失败");
                    }
                } else {
                    XspWeb.Misc.Tips("下发命令失败");
                }
            }
        });
    }

    /**
     * 轮询获取深福ECU
     */
    var ajaxECUBCount = 0;
    function getSfECUB() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getSfECUConfigData",
            success: function (rec) {
                console.log(rec);
                if (rec) {
                    if (rec.code === 0) {
                        ajaxECUBCount = 0;
                        $('#ecuB0_canel1').combobox('setValue',"0"+parseInt(rec.data.channel1,10).toString(16).toUpperCase());
                        $('#ecuB0_canel2').combobox('setValue',"0"+parseInt(rec.data.channel2,10).toString(16).toUpperCase());
                        $('#ecuB0_canel3').combobox('setValue',"0"+parseInt(rec.data.channel3,10).toString(16).toUpperCase());
                        $('#ecuB0_panid1').val("0"+parseInt(rec.data.panId1,10).toString(16).toUpperCase());
                        $('#ecuB0_panid2').val("0"+parseInt(rec.data.panId2,10).toString(16).toUpperCase());
                        $('#ecuB0_panid3').val("0"+parseInt(rec.data.panId3,10).toString(16).toUpperCase());
                        $('#ecuB0_panid4').val("0"+parseInt(rec.data.panId4,10).toString(16).toUpperCase());
                        $('#ecuB0_panid5').val("0"+parseInt(rec.data.panId5,10).toString(16).toUpperCase());
                        $('#ecuB0_panid6').val("0"+parseInt(rec.data.panId6,10).toString(16).toUpperCase());
                    }
                    else if (ajaxECUCount <= 3) {
                        ajaxECUBCount++;
                        setTimeout(getSfECUB, 1000);
                    }
                    else {
                        ajaxECUBCount = 0;
                    }
                }
                else {
                    XspWeb.Misc.Tips("设置失败");
                }
            }
        });
    }

    /**
     * 获取和设置ECU版本
     */
    function getECUVersion() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getVersionNumberOfECU",
            data: {
                circuitId: parameters.circuit.id
            },
            success: function (data) {
                $("#ECUVN1").html(data.ECUVersion);
                $("#ECUVN2").html(data.ECUVersion);
            }
        });
    }

    /**
     * 初始化页面
     */
    function initHtml() {
        $("#circuitName").val(parameters.circuit.name);
        initDeviceInfoView();
        batteryPackCombobox();
        initBatteryPackInfoView();
        bindBtnEvent();
        getECUVersion();
    }

    $(function () {
        initHtml();
    });
</script>
</body>
</html>