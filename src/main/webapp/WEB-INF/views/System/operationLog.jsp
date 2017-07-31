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
    <title></title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
</head>
<body>
<style type="text/css">
    .panel-body {
        background-color: #ecefe8;
    }

    .div-content {
        width: 840px;
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
        line-height: 480px;
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
        width: 150px;
        height: 30px;
        line-height: 30px;
        margin-top: 8px;
    }

    .input-text-div {
        margin-top: 8px;
    }

    .input-button {
        width: 60px;
        height: 30px;
        line-height: 30px;
        background-color: #2596d2;
        color: #ffffff;
        border-radius: 5px;
        border: none;
        margin: 3px 0 0 10px;
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

    #monthReport tr {
        height: 20px;
        line-height: 20px;
    }

    #monthReport td {
        height: 20px;
        line-height: 20px;
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
</style>
<div class="easyui-layout minheightwidth" data-options="fit:true">
    <div data-options="region:'center'" style="background-color: rgb(232, 235, 239);text-align: center;border: none">
        <div id="div-content1" class="div-content" style="display:block;">
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
                <div class="div-content-tool-dspan">操作用户：</div>
                <div class="div-select">
                    <div>
                        <div class="input-text-div">
                            <select id="login_name" class="input-text-b"></select>
                        </div>
                    </div>
                </div>
                <div><input id="selectBtn" class="input-button" type="button" value="搜索"/>
                </div>
            </div>
            <div class="div-content-content">
                <table id="t_log"></table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    /*本页面上的电池组下拉框*/
    // 初始化电池组下拉框
    function initUserNameCom() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/RBAC/getUsers",
            data:{
                page:1,
                rows:9999999
            },
            success: function (rec) {
                if (rec) {
                    $("#login_name").combobox({
                        data: rec.rows,
                        textField: "name",
                        valueField: "id"
                    });
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

        var login_name = $("#login_name").combobox("getText");
        if (login_name) {
            arrParams.push('"login_name":"' + login_name + '"');
        }

        var json = "{" + arrParams.join(",") + "}";
        loadOperationLogGridData(json);
    }

    function initLogGrid() {
        var logGrid = new XspWeb.Controls.RemoteDataGrid();
        logGrid.Initialize("#t_log", "${_RootPath}/System/getOperationLog", {
            fit: true,
            rownumbers: true,
            border: false,
            scrollbarSize: 0,
            pagination: false,
            showFooter: false
        }).SetColumns([[
            {
                field: "id",
                title: "编号",
                width: 40,
                hidden: true
            }, {
                field: "time",
                title: "操作时间",
                width: 100
            }, {
                field: "login_name",
                title: "操作用户",
                width: 100
            }, {
                field: "operation",
                title: "操作内容",
                width: 100
            }
        ]]);

        return logGrid;
    }

    function loadOperationLogGridData(paramJson){
        var logGrid = initLogGrid();
        logGrid.LoadRemoteData({
            paramJson:paramJson
        });
    }

    function bindBtnEvent(){
        $("#selectBtn").click(selectByParams);
    }

    $(function () {
        initUserNameCom();
        loadOperationLogGridData("");
        bindBtnEvent();
    });
</script>
</body>
</html>