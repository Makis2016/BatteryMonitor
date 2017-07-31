<%--
  Created by IntelliJ IDEA.
  User: Linyudui
  Date: 2016/7/21
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <title>模块管理</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
</head>
<body id="layout_main" class="easyui-layout minheightwidth" data-options="fit:true">
<style type="text/css">
    .panel-body {
        background-color: #ecefe8;
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

    .divAdd-lable {
        width: 120px;
    }

    .divAdd-permissions {
        height: 100%;

        background-color: #ffffff;
        overflow: auto;
    }

    .divAdd-permissions-a {
        color: #000000;
        text-decoration: none;
        background: none;
    }

    .divAdd-permissions-diva {
        color: #000000;
        background-color: #ffffff;
    }

    .divAdd-permissions-diva-selected {
        color: #b3b3b3;
        background-color: #ffff00;
    }

    .panel-title {
        color: #fff;
    }

    .window {
        border: 1px solid #000000;
        background: #000000;
    }

    .window .window-header {
        padding: 0px 0px 0px 0px;
    }

    .window .window-body {
        border-width: none;
        background-color: #fff;
    }

    .dialog-button {
        /* border-top: 1px solid #dddddd; */
        background-color: #fff;
        padding: 0 165px 0 0;
        border: none;
        margin: -35px 0 0 0;
    }

    #divAdd a.l-btn {
        background-color: #2596d2;
        background-image: none;
    }

    #divAdd a.l-btn span.l-btn-left {
        background-image: none;
    }

    #divAdd a.l-btn span span.l-btn-text {
        color: #fff;
    }
</style>
<div region="center" style="border: none;overflow: auto;">
    <div style="width: 90%;height: 90%;padding: 10px 0 0 0px;margin: auto;">
        <input id="addModuleBtn" type="button" value="新增"
               style="border-width: 1px;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 80px;height: 35px; background-color: #2794D5;"/>
        <div id="d_module" style="width: 100%;height: 100%;">
            <table id="t_module"></table>
        </div>
    </div>
</div>
<div style="display: none">
    <div id="divAdd" class="easyui-dialog" style="background-color: #fff;padding: 30px; overflow: hidden"
         data-options="closed:true">
        <div style="width: 100%;height: 30px;">
            <div style="width: 30%;height: 100%;float: left;text-align:right;">
                <span>名称：</span>
            </div>
            <div style="width: 70%;height: 100%;float: left;text-align: left;">
                <input id="name" name="name" type="text"/>
            </div>
        </div>
        <div style="width: 100%;height: 30px;">
            <div style="width: 30%;height: 100%;float: left;text-align:right;">
                <span>地址：</span>
            </div>
            <div style="width: 70%;height: 100%;float: left;text-align: left;">
                <input id="url" name="url" type="text"/>
            </div>
        </div>
        <div style="width: 100%;height: 30px;">
            <div style="width: 30%;height: 100%;float: left;text-align:right;">
                <span>模块类型：</span>
            </div>
            <div style="width: 70%;height: 100%;float: left;text-align: left;">
                <select id="type" class="easyui-combobox" name="type" style="width:95px">
                    <option value="0">顶级菜单模块</option>
                    <option value="1">子菜单模块</option>
                </select>
            </div>
        </div>
        <div style="width: 100%;height: 130px;">
            <table>
                <tr>
                    <td class=".divAdd-lable">权限控制</td>
                    <td>
                        <div style="width: 100px;height: 120px;background-color: #ffffff;border: 1px solid #000000;">
                            <div id="cpermissions" name="cpermissions" class="divAdd-permissions"></div>
                        </div>
                    </td>
                    <td>
                        <div style="width: 50px;height: 120px;margin: auto;">
                            <div style="width: 100%;height: 25px;line-height: 25px;">
                                <a href="#" class="easyui-linkbutton" onclick="addPermissionToModule('all')"><<</a>
                            </div>
                            <div style="width: 100%;height: 25px;line-height: 25px;">
                                <a href="#" class="easyui-linkbutton"
                                   onclick="addPermissionToModule('selected')"><</a>
                            </div>
                            <div style="width: 100%;height: 25px;line-height: 25px;">
                                <a href="#" class="easyui-linkbutton"
                                   onclick="removePermissionToModule('selected')">></a>
                            </div>
                            <div style="width: 100%;height: 25px;line-height: 25px;">
                                <a href="#" class="easyui-linkbutton" onclick="removePermissionToModule('all')">>></a>
                            </div>
                        </div>
                    </td>
                    <td>
                        <div style="width: 100px;height: 120px;background-color: #ffffff;border: 1px solid #000000;">
                            <div id="permissions" name="permissions" class="divAdd-permissions">
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    var parameters = {
        Action: {
            getModule: "${_RootPath}/RBAC/getModule",
            addModule: "${_RootPath}/RBAC/addModule",
            getPermissions: "${_RootPath}/RBAC/getPermissions",
            getAllPermissions: "${_RootPath}/RBAC/getAllPermissions",
            getPermissionsToRecId: "${_RootPath}/RBAC/getPermissionsToRecId",
            deleteModule: "${_RootPath}/RBAC/deleteModule",
            updModule: "${_RootPath}/RBAC/updModule"
        }
    };

    function formatJson(id) {

        var jsonArr = [];
        var permissionJsonArr = [];

        if (id) {
            jsonArr.push("\"id\":\"" + id + "\"");
        }

        var name = $("#name").val();
        jsonArr.push("\"name\":\"" + name + "\"");

        var url = $("#url").val();
        jsonArr.push("\"url\":\"" + url + "\"");

        var type = $("#type").combobox('getValue');
        jsonArr.push("\"type\":\"" + type + "\"");

        var permissions = document.getElementById("cpermissions").childNodes;

        for (var i = 0; i < permissions.length; i++) {

            var permission = permissions[i].childNodes;
            if (permission[0].nodeName == "A")
                permissionJsonArr.push(permission[0].getAttribute("id"));
        }

        jsonArr.push("\"permission_ids\":\"" + permissionJsonArr.join(",") + "\"");
        return '{' + jsonArr.join(",") + '}';
    }

    function initPermissionSelectTable(data) {
        console.log(data);
        document.getElementById("permissions").innerHTML = '';
        document.getElementById("cpermissions").innerHTML = '';
        for (var i = 0; i < data.rows.length; i++) {
            var liObj = VElement('div', {'id': 'div_a_' + data.rows[i].id}, [
                VElement('a', {
                    'id': data.rows[i].id,
                    'href': "javascript:;",
                    'name': data.rows[i].id,
                    'value': data.rows[i].name,
                    'class': 'divAdd-permissions-a'
                })
            ]);
            if (data.rows[i].resources_id > 0) {
                document.getElementById("cpermissions").appendChild(liObj.render());
            }
            else {
                document.getElementById("permissions").appendChild(liObj.render());
            }
            document.getElementById(data.rows[i].id).innerHTML = data.rows[i].name;
            document.getElementById('div_a_' + data.rows[i].id).ondblclick = function () {
                var pid = this.parentNode.getAttribute("id");
                if (pid === "cpermissions") {
                    document.getElementById("permissions").appendChild(this);
                }
                else {
                    document.getElementById("cpermissions").appendChild(this);
                }
            }
            document.getElementById('div_a_' + data.rows[i].id).onclick = function () {
                if (this.className == 'divAdd-permissions-diva-selected')
                    this.className = 'divAdd-permissions-diva';
                else {
                    this.className = 'divAdd-permissions-diva-selected';
                }
            }
        }
    }

    function addPermissionToModule(type) {
        if (type == "all") {
            var childNodes = document.getElementById("permissions").childNodes;
            while (childNodes.length > 0) {
                movePermission(childNodes, "cpermissions");
            }
        }
        else if (type == "selected") {
            var childNodes = $(".divAdd-permissions-diva-selected");
            movePermission(childNodes, "cpermissions");
        }
    }

    function movePermission(permission, targetId) {
        for (var i = 0; i < permission.length; i++) {
            document.getElementById(targetId).appendChild(permission[i]);
        }
    }

    function removePermissionToModule(type) {
        if (type == "all") {
            var childNodes = document.getElementById("cpermissions").childNodes;
            while (childNodes.length > 0) {
                movePermission(childNodes, "permissions");
            }
        }
        else if (type == "selected") {
            var childNodes = $(".divAdd-permissions-diva-selected");
            movePermission(childNodes, "permissions");
        }
    }

    function initModuleTable() {
        var gridModule = new XspWeb.Controls.RemoteDataGrid();
        gridModule.Initialize("#t_module", parameters.Action.getModule, {
            border: false,
            fit: true,
            scrollbarSize: 0,
            pageSize: 20,
            pageList: [5, 10, 20, 40]
        }).SetColumns([[{
            field: "id",
            hidden: true,
            width: 30
        }, {
            field: "type",
            hidden: true,
            width: 30
        }, {
            field: "name",
            title: "名称",
            width: 60
        }, {
            field: "url",
            title: "地址",
            width: 100
        }, {
            field: "BtnShow",
            ContentType: "button",
            text: "编辑",
            width: 40,
            handler: function (index, row) {
                editModuleDialog(gridModule,row);
            }
        }, {
            field: "BtnDelete",
            ContentType: "button",
            text: "删除",
            width: 40,
            handler: function (index, row) {
                deleteModule(gridModule, row);
            }
        }]]);

        return gridModule;

    }
    function addModuleDialog() {
        $("#name").val("");
        $("#url").val("");
        XspWeb.Misc.Ajax({
            action: parameters.Action.getAllPermissions,
            success: function (data) {
                if (data) {
                    initPermissionSelectTable(data);
                }

                XspWeb.Misc.Dialog($("#divAdd"), {
                    title: "新增模块",
                    width: 400,
                    height: 350,
                    maximizable: false,
                    minimizable: false,
                    buttons: [{
                        text: "新增",
                        handler: function () {
                            addModule();
                        }
                    }]
                });
            }
        });
    }

    function addModule() {
        var json = formatJson();
        $.ajax({
            url: parameters.Action.addModule,
            data: {
                json: json
            },
            success: function (data) {
                if (data && data.code < 0) {
                    XspWeb.Misc.Tips(data.message);
                }
                else {
                    $("#divAdd").dialog('close');
                    XspWeb.Misc.Tips(data.message);
                    $("#t_module").datagrid("reload");
                }
            }
        });
    }

    function deleteModule(gridModule, row) {
        XspWeb.Misc.Confirm("确定删除" + row.name + "模块吗?", function () {
            XspWeb.Misc.Ajax({
                action: parameters.Action.deleteModule,
                data: {
                    id: row.id
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code === 0)
                        gridModule.LoadRemoteData();
                }
            })
        });
    }

    function editModuleDialog(gridModule, row){
        $("#name").val(row.name);
        $("#url").val(row.url);
        $("#type").combobox('select', row.type)

        XspWeb.Misc.Ajax({
            action: parameters.Action.getPermissionsToRecId,
            data: {
                id: row.id
            },
            success: function (data) {
                if (data) {
                    initPermissionSelectTable(data);
                }

                XspWeb.Misc.Dialog($("#divAdd"), {
                    title: "编辑模块",
                    width: 400,
                    height: 350,
                    maximizable: false,
                    minimizable: false,
                    buttons: [{
                        text: "确定",
                        handler: function () {
                            editModule(gridModule, row);
                        }
                    }]
                });
            }
        });
    }

    function editModule(gridModule, row){
        var json = formatJson(row.id);
        $.ajax({
            url: parameters.Action.updModule,
            data: {
                json: json
            },
            success: function (rec) {
                XspWeb.Misc.Tips(rec.message);
                if (rec.code === 0) {
                    $("#divAdd").dialog('close');
                    gridModule.LoadRemoteData();
                }
            }
        });
    }

    function loadModuleGridData(){
        var gridModule = initModuleTable();
        gridModule.LoadRemoteData();
    }

    function bindBtnEvent(){
        $("#addModuleBtn").click(addModuleDialog);
    }
    $(function () {
        loadModuleGridData();
        bindBtnEvent();
    });
</script>
</body>
</html>