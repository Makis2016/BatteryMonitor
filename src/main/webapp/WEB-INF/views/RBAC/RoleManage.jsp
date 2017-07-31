<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>角色管理</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
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
        <input id="addRoleBtn" type="button" value="新增"
               style="border-width: 1px;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 80px;height: 35px; background-color: #2794D5;"/>
        <div id="d_role" style="width: 100%;height: 100%;">
            <table id="t_role"></table>
        </div>
    </div>
</div>
<div style="display: none">
    <div id="divAdd" class="easyui-dialog" style="background-color: #fff;padding: 10px 30px 30px 30px; overflow: hidden"
         data-options="closed:true">
        <table>
            <tr style="height: 40px;line-height: 40px;">
                <td class=".divAdd-lable">角色名称</td>
                <td>
                    <input id="name" name="name" style="width: 100px;" type="text" class="easyui_text"/>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr style="height: 40px;line-height: 40px;">
                <td class=".divAdd-lable">角色描述</td>
                <td>
                    <input id="remark" name="remark" style="width: 100px;" type="text" class="easyui_text"/>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td class=".divAdd-lable">角色权限</td>
                <td>
                    <div style="width: 100px;height: 120px;background-color: #ffffff;border: 1px solid #000000;">
                        <div id="cpermissions" name="cpermissions" class="divAdd-permissions"></div>
                    </div>
                </td>
                <td>
                    <div style="width: 50px;height: 120px;margin: auto;">
                        <div style="width: 100%;height: 25px;line-height: 25px;">
                            <a href="#" class="easyui-linkbutton" onclick="addPermissionToRole('all')"><<</a>
                        </div>
                        <div style="width: 100%;height: 25px;line-height: 25px;">
                            <a href="#" class="easyui-linkbutton" onclick="addPermissionToRole('selected')"><</a>
                        </div>
                        <div style="width: 100%;height: 25px;line-height: 25px;">
                            <a href="#" class="easyui-linkbutton" onclick="removePermissionToRole('selected')">></a>
                        </div>
                        <div style="width: 100%;height: 25px;line-height: 25px;">
                            <a href="#" class="easyui-linkbutton" onclick="removePermissionToRole('all')">>></a>
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
<script type="text/javascript">
    var parameters = {
        Action: {
            getRoles: "${_RootPath}/RBAC/getRoles",
            addRole: "${_RootPath}/RBAC/addRole",
            updRole: "${_RootPath}/RBAC/updRole",
            deleteRole: "${_RootPath}/RBAC/deleteRole",
            getPermissions: "${_RootPath}/RBAC/getPermissions",
            getAllPermissions: "${_RootPath}/RBAC/getAllPermissions",
            getPermissionsToRoleId: "${_RootPath}/RBAC/getPermissionsToRoleId"
        }
    };

    function initPermissionSelectTable(data){
        document.getElementById("permissions").innerHTML = '';
        document.getElementById("cpermissions").innerHTML = '';

        for (var i = 0; i < data.rows.length; i++) {
            var liObj = VElement('div', {'id': 'div_a_' + data.rows[i].id}, [
                VElement('a', {
                    'id': data.rows[i].id,
                    'href': "#",
                    'name': data.rows[i].id,
                    'value': data.rows[i].name,
                    'class': 'divAdd-permissions-a'
                })
            ]);
            if (data.rows[i].role_id > 0) {
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

    function addPermissionToRole(type) {
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

    function removePermissionToRole(type) {
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

    function formatJson(id) {

        var jsonArr = [];
        var permissionJsonArr = [];

        if (id) {
            jsonArr.push("\"id\":" + id)
        }

        var name = $("#name").val();
        jsonArr.push("\"name\":\"" + name + "\"")

        var remark = $("#remark").val();
        jsonArr.push("\"remark\":\"" + remark + "\"")

        var permissions = document.getElementById("cpermissions").childNodes;

        for (var i = 0; i < permissions.length; i++) {

            var permission = permissions[i].childNodes;
            if (permission[0].nodeName == "A")
                permissionJsonArr.push(permission[0].getAttribute("id"));
        }

        jsonArr.push("\"ids\":\"" + permissionJsonArr.join(",") + "\"");
        return '{' + jsonArr.join(",") + '}';
    }

    function initRoleTable() {
        var gridRole = new XspWeb.Controls.RemoteDataGrid();
        gridRole.Initialize("#t_role", parameters.Action.getRoles, {
            border: false,
            fit: true,
            scrollbarSize: 0,
            pageSize: 20,
            pageList: [5, 10, 20, 40]
        }).SetColumns([[{
            field: "id",
            hidden: true,
            width: 40
        }, {
            field: "name",
            title: "名称",
            width: 40
        }, {
            field: "remark",
            title: "角色描述",
            width: 80
        }, {
            field: "BtnShow",
            ContentType: "button",
            text: "编辑",
            width: 40,
            handler: function (index, row) {
                editRoleDialog(gridRole,row);
            }
        }, {
            field: "BtnDelete",
            ContentType: "button",
            text: "删除",
            width: 40,
            handler: function (index, row) {
                deleteRole(gridRole,row);
            }
        }]]);

        return gridRole;

    }

    function addRoleDialog() {
        $("#name").val("");
        $("#remark").val("");
        XspWeb.Misc.Ajax({
            action: parameters.Action.getAllPermissions,
            success: function (data) {
                if (data) {
                    initPermissionSelectTable(data);
                }

                XspWeb.Misc.Dialog($("#divAdd"), {
                    title: "新增角色",
                    width: 400,
                    height: 320,
                    maximizable: false,
                    minimizable: false,
                    buttons: [{
                        text: "新增",
                        handler: function () {
                            addRole();
                        }
                    }]
                });
            }
        });
    }

    function addRole() {

        var json = formatJson();
        XspWeb.Misc.Ajax({
            action: parameters.Action.addRole,
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
                    $("#t_role").datagrid('reload');
                }
            }
        });
    }

    function deleteRole(gridRole,row){
        XspWeb.Misc.Confirm("确定删除" + row.name + "角色吗?", function () {
            XspWeb.Misc.Ajax({
                action: parameters.Action.deleteRole,
                data: {
                    id: row.id
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code === 0) {
                        gridRole.LoadRemoteData();
                    }
                }
            })
        });
    }

    function editRoleDialog(gridRole,row) {

        $("#name").val(row.name);
        $("#remark").val(row.remark);
        XspWeb.Misc.Ajax({
            action: parameters.Action.getPermissionsToRoleId,
            data: {
                id: row.id
            },
            success: function (data) {
                if (data) {
                    initPermissionSelectTable(data);
                }
                XspWeb.Misc.Dialog($("#divAdd"), {
                    title: "编辑角色",
                    width: 400,
                    height: 320,
                    maximizable: false,
                    minimizable: false,
                    buttons: [{
                        text: "修改",
                        handler: function () {
                            editRole(gridRole,row.id);
                        }
                    }]
                });
            }
        });
    }

    function editRole(gridRole,id) {

        var json = formatJson(id);
        XspWeb.Misc.Ajax({
            action: parameters.Action.updRole,
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
                    gridRole.LoadRemoteData();
                }
            }
        });
    }

    function loadRoleGridData(){
        var gridRole = initRoleTable();
        gridRole.LoadRemoteData();
    }

    function bindBtnEvent(){
        $("#addRoleBtn").click(addRoleDialog);
    }

    $(function () {
        loadRoleGridData();
        bindBtnEvent();
    });
</script>
</body>
</html>