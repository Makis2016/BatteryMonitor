<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript">
        var _RootPath = "${_RootPath}";
    </script>
</head>
<body>
<style type="text/css">
    .window {
        border: 1px solid #000000;
        padding: 0;
        background-color: #ffffff;
    }

    .window .window-header {
        background-color: #000;
        padding: 2px 0 2px 0;

    }

    .window, .window .window-body {
        border-color: #000000;
        background-color: #ffffff;
    }

    .panel-body {
        background-color: rgba(255, 255, 255, 0);
        border-color: #F6F7F9;
    }

    .panel-header {
        background-color: #41526C;
        background: #41526C;
        border-color: #41526C;
        height: 20px;
    }

    .panel-title {
        color: #f4f4f4;
        margin-left: 20px;
        padding: 2px 0 2px 0;
    }

    .panel-tool a {
        display: none;
    }

    .window-header .panel-tool a {
        display: block;
    }

    .layout-expand {
        background: none;
        width: 0px !important;
    }

    .layout-split-east {
        border-left: 5px solid rgba(230, 238, 248, 0);
    }

    .layout-split-west {
        border-right: 10px solid rgba(230, 238, 248, 0);
    }

    .layout-split-north {
        border-bottom: 15px solid rgba(230, 238, 248, 0);
    }

    .layout-expand .panel-header {
        border: none;
        background: none;
    }

    .dialog-button {
        border-top: 1px solid #dddddd;
        padding: 0 50% 0 0;
        background-color: #ffffff;
        border: none;
        margin: -25px;
    }

    #div_secah {
        border-top: 1px solid #193040;
        border-bottom: 1px solid #193040;
        width: 240px;
        margin-left: 20px;
    }

    #div_tree {
        width: 240px;
        padding: 0 20px 0 20px;
    }

    #treeRMenu {
        position: absolute;
        display: none;
    }

    #treeRMenu ul {
        position: absolute;
        float: left;
        border: 1px solid #979797;
        background: #f1f1f1;
        padding: 2px;
        box-shadow: 2px 2px 2px rgba(0, 0, 0, .6);
        width: 120px;
        overflow: hidden;
    }

    #treeRMenu ul li {
        float: left;
        clear: both;
        height: 24px;
        cursor: pointer;
        line-height: 24px;
        white-space: nowrap;
        padding: 0 30px;
        width: 100%;
        display: inline-block;
        color: #999999;
    }

    #treeRMenu ul li:hover {
        background: #E6EDF6;
        border: 1px solid #B4D2F6;
    }

    #propose_title {
        height: 72px;
        margin: 0 1px 0 10px;
    }

    #propose_title_name {
        width: 100%;
        height: 50%;
    }

    #item_alarm_count {
        width: 2%;
        height: 24%;
        border-radius: 100%;
        background-color: red;
        float: left;
        margin: 20px 7px 0px 0px;
        padding: 0px 11px 13px 5px;
        color: #ffffff;
        font-size: 14pt;
    }

    #propose_title_name_val {
        width: 88%;
        height: 55%;
        float: left;
        padding: 20px 0 0 0;
        font-size: 14px;
        color: #5a5657;
    }

    #propose_title_time {
        width: 74%;
        height: 30%;
        font-size: 13px;
        padding: 0px 0px 0px 28px;
        color: #5a5657;
    }

    #propose_content {
        margin: 0 1px 0 10px;
        font-size: 13px;
        color: #5a5657;
        border-top: 1px solid #e3e2e0;
    }

    .helpImg {
        width: 1px;
        height: 1px;
        border-radius: 100%;
        background-color: #FFF;
        float: right;
        padding: 3px 16px 17px 6px;
        margin: -3px 10px 0px 0px;
        font-size: 17px;
        color: #40516b;
    }

    .helpBtnImg {
        width: 1px;
        height: 1px;
        line-height: 10px;
        border-radius: 100%;
        background-color: #D8DCE5;
        float: right;
        padding: 6px 12px 12px 6px;
        margin: 0px 0 0px 0px;
        font-size: 14px;
        font-weight: bold;
        color: #7D848A;
    }

    .helpBtnImg-selected {
        background-color: #41526C;
        color: #fff;
    }

    .alarm_count_img {
        width: 1px;
        height: 1px;
        border-radius: 100%;
        background-color: #FFF;
        float: left;
        padding: 2px 20px 17px 0px;
        margin: -2px -100px 0px 57px;
        font-size: 17px;
        color: #40516b;
    }

    .btnEditArea {
        width: 13px;
        height: 5px;
        line-height: 5px;
        float: right;
        background-image: url(resources/images/u113.png);
    }

    #addOrEditHtml {
        padding: 25px 0 0 70px;
        height: 110px;
    }

    #addOrEditHtml Div {
        float: left;
        width: 240px;
        height: 35px;
    }

    #addOrEditHtml span {
        width: 65px;
        float: left;
        line-height: 20px;
        height: 20px;
        text-align: right;
    }

    #alarmData .datagrid-header {
        height: 0px !important;
    }

    #alarmData .datagrid-row-selected {
        background: #fff;
    }

    .panel-header {
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#41526C, endColorstr=#41526C, GradientType=0);
    }

    #msgDiv {
        margin: auto;
        width: 200px;
        height: 40px;
        font-size: 30px;
        padding: 100px;
        color: #cccccc;
    }

    .datagrid-header{
        cursor: default;
        border-width: 0 0 1px 0;
        border-style: solid;
        overflow: visible;
    }
</style>
<%@ include file="/WEB-INF/tags/ZTree.ftl" %>
<div id="layout_main_content" class="easyui-layout minheightwidth" data-options="fit:true">
    <div id="west_menu" data-options="region:'west',split:true" title="区域选择"
         style="width:290px;background-color: #41526C;border: #41526C;">
        <div id="div_secah">
            <div style="background-color: #FFFFFF;width: 240px;height: 40px;margin: 20px 0 20px 0;border: none;">
                <input id="text_secah" type="text" value="" style="width: 210px;height: 35px;border: none;"/>
                <span><a href="javascript:void(0);" onclick="selectAreaNode()"><img src="./resources/images/search.png"/></a></span>
            </div>
        </div>
        <div id="div_tree">
            <a href="javascript:void(0)"  onclick="addArea()" style="color:#ffffff;text-decoration:none">添加区域</a>
            <ul id="tree" class="fr_ztree" style="padding:0"></ul>
            <shiro:hasPermission name="areaTree:create">
                <div id="treeRMenu">
                    <ul>
                        <li id="addArea">新增同级区域</li>
                        <li id="addChildArea">新增子区域</li>
                        <li id="deleteArea">删除当前区域</li>
                        <li id="editArea">修改当前区域</li>
                        <li id="addCircuit">添加回路</li>
                        <li id="addBatteryGroup">添加电池组</li>
                    </ul>
                </div>
            </shiro:hasPermission>
        </div>
    </div>
    <div id="center_main" data-options="region:'center',split:true" style="border: none;">
        <div class="easyui-layout " data-options="fit:true">
            <div id="north" data-options="region:'north',split:true" title="实时状态"
                 style="height:400px;background-color: #E8EbEf;padding: 10px 0 0 20px;">
                <div id="groupData" data-options="fit:true" class="easyui-panel">
                </div>
            </div>
            <div id="alarmData" data-options="region:'center',split:true"
                 title="告警信息<div id='alarmCount' style='display:none;' class='alarm_count_img'>0</div>"
                 style="width:800px;height: 226px;background-color: rgb(255, 255, 255);">
                <table id="t_alarm" style="overflow-x: hidden"></table>
            </div>
            <div id="east" data-options="region:'east',split:true" title="维护建议<div class='helpImg'>?</div>"
                 style="width:300px;height: 226px;background-color: rgb(255, 255, 255);">
                <div id="propose_title">
                    <div id="propose_title_name">
                        <div style="display: none;" id="item_alarm_count"></div>
                        <div id="propose_title_name_val"></div>
                    </div>
                    <div id="propose_title_time"></div>
                </div>
                <div id="propose_content">
                    请选择告警信息编号
                </div>
            </div>
        </div>
    </div>
</div>
<div style="display: none">
    <div id="areaOperation" style="background-color: #fff;">
        <div id="addOrEditHtml" style="display: block">
            <div><span id="lab_name" style="display: block;">区域名称：</span>
                <input id="areaName" type="text"/>
            </div>
            <div><span id="lab_charge_person" style="display: block;">负责人：</span>
                <input id="charge_person" type="text"/>
            </div>
            <div><span id="lab_email" style="display: block;">邮箱：</span>
                <input id="email" type="text"/></div>
        </div>
        <span id="deleteHtml" style="display: block;padding: 54px;">
            删除该区域后，将自动删除该区域下所有电池组、该区域下的所有子区域和子区域下所有电池组，确定删除？
        </span>
    </div>
</div>

<script type="text/javascript">

    // 全局公有变量
    var parameters = {
        Public: {
            // 已选择回路Div索引
            groupSelectedIndex: "",
            // 功能菜单特效定时器
            smpleMenuTimer: null,
            // 是否点击编辑
            isEditClick: false,
            // 功能菜单透明度
            opacity: null,
            // 功能菜单选择的树节点
            diyBtnClickNode: null,
            // 回路DIV定时器ID
            groupTimer: null,
            // 定时刷新回路DIV true 开启，false 关闭
            isTimeout: null,
            // 已选择区域索引
            areaSelectedId: 0,
            // 已选择告警索引
            alarmSelectedIndex: null
        }
    };

    // 初始化树配置，加载数据
    function initMenuTree(areaName) {
        var zTreeDefaultSetting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            },
            view: {
                dblClickExpand: false,
                showLine: false,
                showIcon: true,
                selectedMulti: true,
                <shiro:hasPermission name="areaTree:create">
                addHoverDom: addHoverBtn,
                removeHoverDom: removeHoverBtn
                </shiro:hasPermission>
            },
            edit: {
                enable: true,
                showRenameBtn: false
            },
            callback: {
                onClick: function (event, treeId, treeNode) {
                    if (parameters.Public.isEditClick) {
                        hideHoverBtnMenu();
                        return;
                    }

                    var treeObj = $.fn.zTree.getZTreeObj("tree");
                    treeObj.expandNode(treeNode, !treeNode.open, false, true, true);
                    if (typeof (zTreeOnClick) === 'function') {
                        zTreeOnClick(event, treeId, treeNode);
                    }
                }
            }
        };

        loadMenuTreeData(zTreeDefaultSetting, areaName);
    }

    // MenuTree加载数据
    function loadMenuTreeData(zTreeDefaultSetting, areaName) {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/getSimpleDateForzTree",
            success: function (rec) {
                if (rec.code == 0) {
                    var treeobj = $.fn.zTree.init($("#tree"), zTreeDefaultSetting, rec.data);
                    if (areaName) {
                        var treeNode = treeobj.getNodeByParam("name", areaName);
                        treeobj.selectNode(treeNode);
                        initGroupDataTitle(treeNode);
                        treeobj.expandNode(treeNode, true, false, true, true);
                    }
                    $("#groupData").html('<div id="msgDiv"><span id="msg">请选择区域</span></div>');
                }
                else {
                    $("#groupData").html('<div id="msgDiv"><span id="msg">' + rec.message + '</span></div>');
                }
            }
        });
    }

    // 菜单树点击事件
    function zTreeOnClick(event, treeId, treeNode) {
        $("#groupData").html('<div id="msgDiv"><span id="msg">加载中......</span></div>');
        parameters.Public.areaSelectedId = treeNode.id;
        initGroupDataTitle(treeNode);
        parameters.Public.isTimeout = true;
    }

    /* 菜单树中功能按钮初始化方法 */
    // 菜单树中添加功能按钮
    function addHoverBtn(treeId, treeNode) {
        var aObj = $("#" + treeNode.tId + "_a");
        if ($("#diyBtn_" + treeNode.id).length > 0) return;
        var editStr = "<input class='btnEditArea' id='diyBtn_" + treeNode.id
                + "' title='" + treeNode.name + "' onfocus='this.blur();' style='margin: 18px 15px 0 0;border: none;background-color: #41526c;' />";
        aObj.append(editStr);
        var btn = $("#diyBtn_" + treeNode.id);
        if (btn) btn.bind("click", function (event) {
            hoverBtnClickEvent(event, treeId, treeNode);
        });
    }

    // 菜单树中的功能按钮事件
    function hoverBtnClickEvent(event, treeId, treeNode) {
        var oDiv = document.getElementById('treeRMenu');
        if (oDiv.style.display !== 'none') {
            hideHoverBtnMenu();
        }
        else {
            oDiv.style.display = 'block';
            parameters.Public.opacity = 0;
            oDiv.style.opacity = 0;
            oDiv.style.left = event.clientX - 120 + 'px';
            oDiv.style.top = event.clientY - 160 + "px";
            showHoverBtnMenu();
            parameters.Public.diyBtnClickNode = treeNode;
        }
    }

    // 菜单树中功能按钮释放
    function removeHoverBtn(treeId, treeNode) {
        $("#diyBtn_" + treeNode.id).unbind().remove();
        $("#diyBtn_space_" + treeNode.id).unbind().remove();
    }

    /* 菜单树中功能按钮控制-功能菜单-显示/隐藏 */
    // 显示菜单树中功能菜单
    function showHoverBtnMenu() {
        if (parameters.Public.opacity < 1) {
            var oDiv = document.getElementById('treeRMenu');
            parameters.Public.opacity += 0.3;
            oDiv.style.opacity = parameters.Public.opacity;
            parameters.Public.smpleMenuTimer = setTimeout(showHoverBtnMenu, 300);
        } else {
            clearTimeout(parameters.Public.smpleMenuTimer);
            parameters.Public.isEditClick = true;
        }
    }

    // 隐藏菜单树中功能菜单
    function hideHoverBtnMenu() {
        var oDiv = document.getElementById('treeRMenu');
        if (parameters.Public.opacity > 0) {
            parameters.Public.opacity -= 0.2;
            oDiv.style.opacity = parameters.Public.opacity;
            parameters.Public.smpleMenuTimer = setTimeout(hideHoverBtnMenu, 300);
        } else {
            clearTimeout(parameters.Public.smpleMenuTimer);
            oDiv.style.display = 'none';
            parameters.Public.isEditClick = false;
        }
    }

    // 点击页面隐藏菜单树中功能菜单
    document.onclick = function () {
        if (parameters.Public) {
            if (parameters.Public.isEditClick) {
                hideHoverBtnMenu();
                return;
            }
        }
    };

    /* 功能菜单中的按钮事件 */
    // 添加同级区域
    function addArea() {
        setAddOrEditAreaInput("add");
        var parentDiv1 = document.getElementById("addOrEditHtml");
        var parentDiv2 = document.getElementById("deleteHtml");
        var pid = 0;
        if(parameters.Public.diyBtnClickNode !=  null){
            pid = parameters.Public.diyBtnClickNode.pid;
        }
        parentDiv1.style.display = "block";
        parentDiv2.style.display = "none";
        var obj = $("#areaOperation");
        XspWeb.Misc.Dialog(obj, {
            title: "新增同级区域",
            width: 400,
            height: 200,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "确定",
                handler: function () {
                    var name = $("#areaName").val();
                    var charge_person = $("#charge_person").val();
                    var email = $("#email").val();
                    if (email) {
                        if (!Business.Misc.validateMail(email)) {
                            XspWeb.Misc.Tips("输入的邮箱格式不正确");
                            return;
                        }
                    }
                    XspWeb.Misc.Ajax({
                        action: "${_RootPath}/System/addArea",
                        data: {
                            pid: pid,
                            name: name,
                            charge_person: charge_person,
                            email: email
                        },
                        success: function (data) {
                            if (data) {
                                XspWeb.Misc.Tips(data.message);
                                if (data.code == 0) {
                                    if(parameters.Public.diyBtnClickNode == null){
                                        initMenuTree(name);
                                    }else{
                                        initMenuTree(parameters.Public.diyBtnClickNode.name);
                                    }
                                    parameters.Public.diyBtnClickNode = null;
                                    obj.dialog('close');
                                }
                            }
                        }
                    });
                }
            }]
        });
    }

    // 添加子区域
    function addChildArea() {
        setAddOrEditAreaInput("add");
        var parentDiv1 = document.getElementById("addOrEditHtml");
        var parentDiv2 = document.getElementById("deleteHtml");
        parentDiv1.style.display = "block";
        parentDiv2.style.display = "none";
        var obj = $("#areaOperation");
        XspWeb.Misc.Dialog(obj, {
            title: "新增子区域",
            width: 400,
            height: 200,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "确定",
                handler: function () {
                    var name = $("#areaName").val();
                    var charge_person = $("#charge_person").val();
                    var email = $("#email").val();
                    if (email) {
                        if (!Business.Misc.validateMail(email)) {
                            XspWeb.Misc.Tips("输入的邮箱格式不正确");
                            return;
                        }
                    }
                    XspWeb.Misc.Ajax({
                        action: "${_RootPath}/System/addArea",
                        data: {
                            pid: parameters.Public.diyBtnClickNode.id,
                            name: name,
                            charge_person: charge_person,
                            email: email
                        },
                        success: function (data) {
                            if (data) {
                                XspWeb.Misc.Tips(data.message);
                                if (data.code == 0) {
                                    initMenuTree(parameters.Public.diyBtnClickNode.name);
                                    parameters.Public.diyBtnClickNode = null;
                                    obj.dialog('close');
                                }
                            }
                        }
                    });
                }
            }]
        });
    }

    // 删除区域
    function deleteArea() {
        var parentDiv1 = document.getElementById("addOrEditHtml");
        var parentDiv2 = document.getElementById("deleteHtml");
        parentDiv1.style.display = "none";
        parentDiv2.style.display = "block";

        var obj = $("#areaOperation");
        XspWeb.Misc.Dialog(obj, {
            title: "删除区域",
            width: 400,
            height: 200,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "删除",
                handler: function () {
                    XspWeb.Misc.Ajax({
                        action: "${_RootPath}/System/deleteArea",
                        data: {id: parameters.Public.diyBtnClickNode.id},
                        success: function (data) {
                            if (data.code >= 0) {
                                XspWeb.Misc.Tips(data.message);
                                var parentNode = parameters.Public.diyBtnClickNode.getParentNode();
                                if (parentNode)
                                    initMenuTree(parentNode.name);
                                else {
                                    initMenuTree();
                                }
                                parameters.Public.diyBtnClickNode = null;
                                obj.dialog('close');
                            } else {
                                XspWeb.Misc.Tips(data.message);
                            }
                        }
                    });
                }
            }]
        });
    }

    // 修改区域
    function editArea() {
        setAddOrEditAreaInput("edit");
        var parentDiv1 = document.getElementById("addOrEditHtml");
        var parentDiv2 = document.getElementById("deleteHtml");
        parentDiv1.style.display = "block";
        parentDiv2.style.display = "none";
        var obj = $("#areaOperation");
        XspWeb.Misc.Dialog(obj, {
            title: "修改区域",
            width: 400,
            height: 200,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "修改",
                handler: function () {
                    var name = $("#areaName").val();
                    var charge_person = $("#charge_person").val();
                    var email = $("#email").val();
                    if (email) {
                        if (!Business.Misc.validateMail(email)) {
                            XspWeb.Misc.Tips("输入的邮箱格式不正确");
                            return;
                        }
                    }
                    XspWeb.Misc.Ajax({
                        action: "${_RootPath}/System/editArea",
                        data: {
                            id: parameters.Public.diyBtnClickNode.id,
                            pid: parameters.Public.diyBtnClickNode.pid,
                            name: name,
                            charge_person: charge_person,
                            email: email
                        },
                        success: function (data) {
                            if (data) {
                                XspWeb.Misc.Tips(data.message);
                                if (data.code == 0) {
                                    initMenuTree(name);
                                    parameters.Public.diyBtnClickNode = null;
                                    obj.dialog('close');
                                }
                            }
                        }
                    });
                }
            }]
        });
    }

    // 添加回路
    function addCircuitDialog() {
        var areaId = parameters.Public.diyBtnClickNode.id;
        var addCircuitDialog = new XspWeb.Controls.Dialog("addCircuitDialog");
        addCircuitDialog.SetUrl("${_RootPath}/System/addCircuitDialog?areaId=" + areaId)
                .SetCallback({
                    name: "addGroupSuccess",
                    callback: function () {
                        addCircuitDialog.Hide();
                    }
                }).Show({
            title: "新增回路",
            width: 850,
            height: 565,
            maximizable: false,
            minimizable: false
        }, true);
    }

    // 添加电池组
    function addBatteryGroup() {
        var addBatteryGroupDialog = new XspWeb.Controls.Dialog("addBatteryGroupDialog");
        addBatteryGroupDialog.SetUrl("${_RootPath}/System/addBatteryPackDialog").SetCallback(
                function () {
                    addBatteryGroupDialog.Hide();
                }
        ).Show({
            title: "新增电池组",
            width: 1350,
            height: 500,
            maximizable: false,
            minimizable: false
        }, true);
    }

    function setAddOrEditAreaInput(op) {
        if (op === "add") {
            $("#areaName").val("");
            $("#charge_person").val("");
            $("#email").val("");
        } else {
            $("#areaName").val(parameters.Public.diyBtnClickNode.name);
            $("#charge_person").val(parameters.Public.diyBtnClickNode.charge_person);
            $("#email").val(parameters.Public.diyBtnClickNode.email);
        }
    }

    // 绑定功能菜单按钮事件
    function bindTreeHoverBtnEvent() {
        $("#addArea").click(addArea);
        $("#addChildArea").click(addChildArea);
        $("#editArea").click(editArea);
        $("#deleteArea").click(deleteArea);
        $("#addCircuit").click(addCircuitDialog);
        $("#addBatteryGroup").click(addBatteryGroup);
    }

    /* 选择菜单树区域方法 */
    // 区域选择方法
    function selectAreaNode() {
        var areaName = $("#text_secah").val();
        if (!areaName) {
            XspWeb.Misc.Tips("请输入区域名称！")
        } else {
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodeObj = treeObj.getNodesByParamFuzzy("name",areaName);
            console.log(nodeObj);
            if(nodeObj.length > 0){
                var treeNode = treeObj.getNodeByParam("name",nodeObj[0].name);
                if (treeNode) {
                    $("#groupData").html('<div id="msgDiv"><span id="msg">加载中......</span></div>');
                    parameters.Public.areaSelectedId = treeNode.id;
                    treeObj.selectNode(treeNode);
                    initGroupDataTitle(treeNode);
                    parameters.Public.isTimeout = true;
                } else
                    XspWeb.Misc.Tips("找不到该区域！");
            }else
                XspWeb.Misc.Tips("找不到该区域！");
        }
    }

    // 获取选中区域名称
    function getGroupDataTitle(treeNode) {
        var parentNode = treeNode.getParentNode();
        if (parentNode) {
            return getGroupDataTitle(parentNode) + " " + treeNode.name;
        } else {
            return treeNode.name;
        }
    }

    // 初始化选中区域名称提示在 groupDataDiv 头标示
    function initGroupDataTitle(treeNode) {
        var title = getGroupDataTitle(treeNode);
        if (title) {
            $("#north").panel({
                title: "<span id='northTitle' onclick='returnInterface(" + '"' + treeNode.name + '"' + ")'><<" + title + " 实时状态</span>"
            });
        }
    }

    /* 回路数据Div初始化方法 */
    // 回路详情界面返回回路界面方法
    function returnInterface(areaName) {
        if (parameters.Public.batteryPackTimeout) {
            parameters.Public.batteryPackTimeout = false;
        }
        if (parameters.Public.mCircuitId) {
            parameters.Public.mCircuitId = null;
        }
        if (parameters.Public.isGroupDetailInit) {
            parameters.Public.isGroupDetailInit = false;

        }

        $("#groupData").html('<div id="msgDiv"><span id="msg">加载中......</span></div>');
        $('#layout_main_content').layout('expand', 'west');
        var treeObj = $.fn.zTree.getZTreeObj("tree");
        var treeNode = treeObj.getNodeByParam("name", areaName);
        initGroupDataTitle(treeNode);
        parameters.Public.areaSelectedId = treeNode.id;
        treeObj.selectNode(treeNode);
        parameters.Public.isTimeout = true;

        initAlarmGrid();
    }

    // 获取设置回路div样式名称
    function getClassNmaeToBatteryGroup(data, mId) {

        var classNmaeToBatteryGroup = "batteryGroup";
        if (("batteryGroup_" + mId) === parameters.Public.groupSelectedIndex) {
            classNmaeToBatteryGroup += " batteryGroup_selected";
        }

        var circuitStatus = data.mCircuitStatus;
        if (circuitStatus === "Fault") {
            classNmaeToBatteryGroup += " batteryGroupFault";
        }
        else if (circuitStatus === "Ready") {
            classNmaeToBatteryGroup += " batteryGroupReady";
        }
        else if (circuitStatus === "ReadyToRuning") {
            classNmaeToBatteryGroup += " batteryGroupReadyRun";
        }
        else if (circuitStatus === "Formating") {
            classNmaeToBatteryGroup += " batteryGroupFormating";
        }
        else if (circuitStatus === "Pauseing") {
            classNmaeToBatteryGroup += " batteryGroupPauseing";
        }
        else if (circuitStatus === "Pause") {
            classNmaeToBatteryGroup += " batteryGroupPause";
        }
        else if (circuitStatus === "Recovering") {
            classNmaeToBatteryGroup += " batteryGroupRecovering";
        }
        else if (circuitStatus === "Jumping") {
            classNmaeToBatteryGroup += " batteryGroupJumping";
        }
        else if (circuitStatus === "Reseting") {
            classNmaeToBatteryGroup += " batteryGroupReseting";
        }

        return classNmaeToBatteryGroup;
    }

    // 获取设置回路div内容
    function initGroupDivValue(mId, data) {
        //$("#serial_number_" + mId).html(mId);
        var circuitName = data.mName;
        if (circuitName && circuitName.length > 10)
            circuitName = circuitName.substr(0, 10) + "...";
        $("#serial_number_" + mId).html(circuitName);
        $('#batteryGroup_' + mId + '_ring_content_ratio_value').html(data.mElectricity+"%");
        $('#batteryGroup_' + mId + '_content_voltage').html(data.mVoltage + "V");
        $('#batteryGroup_' + mId + '_content_current').html(data.mCurrent + "A");

        var monitorStatus = data.mMonitorStatus;
        $('#batteryGroup_' + mId + '_ring_content_start').html(getMonitorStatus(monitorStatus, mId));
        initGroupDivClickEvent(mId);
        initGroupDivDblClickEvent(data, monitorStatus, mId);
    }

    // 设置回路div单击事件
    function initGroupDivClickEvent(mId) {
        $("#batteryGroup_" + mId).click(function () {
            var obj = $("#" + this.id);
            var chils = obj.parent()[0].childNodes;
            for (var i = 0; i < chils.length; i++) {
                var cobj = $("#" + chils[i].id);
                cobj.removeClass("batteryGroup_selected");
            }
            if (parameters.Public.groupSelectedIndex !== this.id) {
                obj.addClass("batteryGroup_selected");
                parameters.Public.groupSelectedIndex = this.id;
            } else {
                parameters.Public.groupSelectedIndex = "";
            }
        });
    }

    // 设置回路div双击事件
    function initGroupDivDblClickEvent(data, monitorStatus, mId) {
        if (monitorStatus && monitorStatus !== "NoBatteryPack") {
            $("#batteryGroup_" + mId).attr("circuitId", mId);
            $("#batteryGroup_" + mId).dblclick(function () {
                // 设置title
                var arrNorthTitle = $("#northTitle").html().split(" ");
                var batteryPackName = data.mName;//$("#serial_number_" + this.getAttribute("circuitId")).html();
                if ((arrNorthTitle) && (arrNorthTitle.length > 0) && (batteryPackName)) {
                    var len = arrNorthTitle.length;
                    arrNorthTitle[len - 1] = batteryPackName + " " + arrNorthTitle[len - 1];
                    $("#northTitle").html(arrNorthTitle.join(" ").replace("&lt;&lt;", "<<"));
                }

                parameters.Public.isTimeout = false;

                $('#layout_main_content').layout('collapse', 'west');
                var circuitId = this.getAttribute("circuitId");
                $("#groupData").panel(
                        'refresh', '${_RootPath}/RealTime/groupDetail?circuitId=' + circuitId
                )

                var oLayout = document.getElementById("layout_main_content");
                var oLayoutLeft = parseInt(oLayout.childNodes[3].style.left);
                oLayout.childNodes[3].style.left = oLayoutLeft / 2 + "px";

                initAlarmGrid();
            });
        }
    }

    // 获取设置回路div状态
    function getMonitorStatus(monitorStatus, mId) {
        if (!monitorStatus || monitorStatus === "NoBatteryPack") {
            return '无电池组';
        } else if (monitorStatus === "Charge") {
            $('#batteryGroup_' + mId + '_mark_ring').attr("style", "background-image: url(resources/images/congdian.png)");
            return "充电中";
        } else if (monitorStatus === "Discharge") {
            $('#batteryGroup_' + mId + '_mark_ring').attr("style", "background-image: url(resources/images/fangdian.png)");
            return "放电中";
        } else if(monitorStatus === "FloatCharge") {
            return "浮充";
        } else {
            return "非充非放";
        }
    }

    // 初始化回路数据DIV
    function initGroupDate(data) {
        if (parameters.Public && parameters.Public.isTimeout) {
            $('#groupData').html('');
            var count = data.length;
            for (var i = 0; i < count; i++) {
                var mId = data[i].mId;
                var mBatteryPackId = data[i].mBatteryPackId;
                var classNmaeToBatteryGroup = getClassNmaeToBatteryGroup(data[i], mId);
                var batteryGroup = VElement('div', {
                    'id': 'batteryGroup_' + mId,
                    'class': classNmaeToBatteryGroup,
                    'batteryPackId': mBatteryPackId
                }, [
                    VElement('span', {
                        'id': 'serial_number_' + mId,
                        style: 'font-size: 15px;display: block;    margin-bottom: 10px;'
                    }),
                    VElement('div', {'id': 'batteryGroup_' + mId + '_outer_ring', 'class': 'batteryGroup_outer_ring'}, [
                        VElement('div', {
                            'id': 'batteryGroup_' + mId + '_inner_ring',
                            'class': 'batteryGroup_inner_ring'
                        }, [
                            VElement('div', {
                                'id': 'batteryGroup_' + mId + '_ring_content',
                                'class': 'batteryGroup_ring_content'
                            }, [
                                VElement('div', {
                                    'id': 'batteryGroup_' + mId + '_ring_content_ratio',
                                    'class': 'batteryGroup_ring_content_ratio'
                                }, [
                                    VElement('div', {
                                        'id': 'batteryGroup_' + mId + '_ring_content_ratio_value',
                                        'class': 'batteryGroup_ring_content_ratio_value'
                                    })
                                ]),
                                VElement('div', {
                                    'id': 'batteryGroup_' + mId + '_ring_content_start',
                                    'class': 'batteryGroup_ring_content_start'
                                })
                            ]),
                            VElement('div', {
                                'id': 'batteryGroup_' + mId + '_mark_ring',
                                'class': 'batteryGroup_mark_ring'
                            })
                        ])
                    ]),
                    VElement('div', {'id': 'batteryGroup_' + mId + '_content', 'class': 'batteryGroup_content'}, [
                        VElement('div', {
                            'id': 'batteryGroup_' + mId + '_content_voltage',
                            'class': 'batteryGroup_content_voltage'
                        }),
                        VElement('div', {
                            'id': 'batteryGroup_' + mId + '_content_current',
                            'class': 'batteryGroup_content_current'
                        })
                    ])
                ]);

                $("#groupData").append(batteryGroup.render());
                initGroupDivValue(mId, data[i]);
            }
        }
    }

    // 初始化告警表格
    function initAlarmGrid() {
        var alarmGrid = new XspWeb.Controls.RemoteDataGrid();
        alarmGrid.Initialize("#t_alarm", "${_RootPath}/RealTime/getAlarm", {
            fit: true,
            rownumbers: true,
            border: false,
            scrollbarSize: 0,
            pagination: false,
            showFooter: false,
            onSelect: function (rowIndex, row) {
                $("#item_alarm_count").attr("style", "display:block;");
                $("#item_alarm_count").html(row.Level ? row.Level.replace("Level", "") : "");
                $("#propose_title_name_val").html(row.AreaName);
                $("#propose_title_time").html("告警时间：" + row.StrarTime);
                $("#propose_content").html(row.MaintainAdvise);

                // 获取区域名称，触发区域搜索，休眠2秒等待页面渲染成功触发回路双击事件
                var areaName = row.AreaName.split('-');
                $("#text_secah").val(areaName[areaName.length -1]);
                selectAreaNode();
                setTimeout(function () {
                    $("#batteryGroup_" + row.CircuitId).dblclick();
                }, 1500);

                if (parameters.Public.alarmSelectedIndex) {
                    $("#helpBtn" + parameters.Public.alarmSelectedIndex)
                            .removeClass("helpBtnImg-selected");
                }
                $("#helpBtn" + row.Id).addClass("helpBtnImg-selected");
                parameters.Public.alarmSelectedIndex = row.Id;
            },
            onLoadSuccess: function (data) {
                if (data.total > 0) {
                    $("#alarmCount").attr("style", "display:block;");
                    if (data.total < 10)
                        $("#alarmCount").html("0" + data.total)
                    else {
                        $("#alarmCount").html(data.total)
                    }
                    $("#t_alarm").datagrid('unselectAll');
                    if (parameters.Public.alarmSelectedIndex) {
                        for (var index = 0; index < data.total; index++) {
                            if (data.rows[index].Id === parameters.Public.alarmSelectedIndex) {
                                $("#t_alarm").datagrid("selectRow", index);
                                break;
                            }
                        }
                    }
                } else {
                    $("#alarmCount").attr("style", "display:none;");
                }
            }
        }).SetColumns([[{
            field: "Id",
            hidden: true,
            width: 40,
        }, {
            field: "StrarTime",
            width: 60,
            title: "时间"
        }, {
            field: "AreaName",
            width: 80,
            title: "告警位置"
        }, {
            field: "AlarmMessage",
            width: 120,
            title: "告警原因"
        }, {
            field: "BtnEdit",
            ContentType: "button",
            align: "center",
            width: 20,
            formatter: function (value, row) {
                return "<div style='width: 100%;height: 100%;'><div id='helpBtn" + row.Id + "' style='position: relative;right: 30px' class='helpBtnImg'>?</div></div>"
            }
        }]]);

        return alarmGrid;
    }

    // 异步获取告警信息
    function alarmAjax() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/RealTime/getAlarm",
            success: function (data) {
                if (data) {
                    $("#t_alarm").datagrid('loadData', data);
                }
            }
        });
    }

    // 异步获取回路信息
    function groupAjax() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/RealTime/getCircuits",
            data: {
                areaId: parameters.Public.areaSelectedId
            },
            success: function (rec) {
                if (rec) {
                    if (rec.code == 0) {
                        if (initGroupDate) {
                            initGroupDate(rec.data.mCircuits);
                        }
                    } else {
                        $("#groupData").html('<div id="msgDiv"><span id="msg">' + rec.message + '</span></div>');
                    }
                }
            }
        });
    }

    // 异步获取回路详情信息
    function groupDetailAjax() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/RealTime/getCircuit",
            data: {
                id: parameters.Public.mCircuitId
            },
            success: function (rec) {
                if (rec) {
                    if (rec.code == 0) {
                        if (!parameters.Public.isGroupDetailInit) {
                            if (initBatteryPackGrid) {
                                initBatteryPackGrid(rec);
                            }
                        }
                        else {
                            if (refreshData) {
//                                initBatteryPackGrid(rec)
                                refreshData(rec);
                            }
                        }
                    }
                    else {
                        $("#groupData").html('<div id="msgDiv"><span id="msg">' + rec.message + '</span></div>');
                    }
                }
            }
        });
    }

    // 轮询定时器工作线程
    // interval 是否间隔轮询 ture 间隔 false 1次 调试使用
    function timeoutWorkerThread(interval) {
        alarmAjax();
        //console.log(parameters.Public.batteryPackTimeout+" "+parameters.Public.mCircuitId);
        if (parameters.Public.isTimeout && parameters.Public.areaSelectedId) {
            groupAjax();
        }
        else if (parameters.Public.batteryPackTimeout && parameters.Public.mCircuitId) {
            // console.log("groupDetail");
            groupDetailAjax();
        }

        if (interval) {
            parameters.Public.groupTimer = setTimeout(function () {
                timeoutWorkerThread(true);
            }, 3000);
        }
    }

    // 页面跳转 清除定时器 方法
    function closeGroupTimer() {
        if (parameters.Public.groupTimer) {
            clearTimeout(parameters.Public.groupTimer);
            parameters.Public.groupTimer = null;
        }
    }

    // 开启轮询定时器
    function openTimeoutWorkThread() {
        closeGroupTimer();
        if (parameters.Public.areaSelectedId === 0 && !parameters.Public.groupTimer) {
            timeoutWorkerThread(true);
            var alarmGrid = initAlarmGrid();
            alarmGrid.LoadRemoteData();
        }
    }

    // 初始化页面
    function initGroupHtml() {
        var widthLeft = (document.body.clientWidth - 330) * 3 / 4;
        var widthRight = (document.body.clientWidth - 330) * 1 / 4;
        var heightUp = (document.body.clientHeight - 350) * 3 / 4 + 65;
        $("#north").height(heightUp);
        $("#alarmData").width(widthLeft);
        $("#east").width(widthRight);

        initMenuTree();
        bindTreeHoverBtnEvent();
        $("#groupData").panel({});
        openTimeoutWorkThread();
    }

    // 页面加载后初始化
    $(function () {
        initGroupHtml();
    });
</script>
</body>
</html>
