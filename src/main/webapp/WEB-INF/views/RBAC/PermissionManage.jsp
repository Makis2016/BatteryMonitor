<%--
  Created by IntelliJ IDEA.
  Permission: Linyudui
  Date: 2016/6/29
  Time: 16:43
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
    <title>权限管理</title>
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
        padding: 0 110px 0 0;
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
        <input id="addPermissionBtn" type="button" value="新增"
               style="border-width: 1px;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 80px;height: 35px; background-color: #2794D5;"/>
        <div id="d_permission" style="width: 100%;height: 100%;">
            <table id="t_permission"></table>
        </div>
    </div>
</div>
<div style="display: none">
    <div id="divAdd" class="easyui-dialog" style="background-color: #fff;padding: 30px; overflow: hidden"
         data-options="closed:true">
        <form id="f_permission">
            <div style="width: 100%;height:30px;line-height: 30px;">
                <div style="width: 30%;height:30px;line-height: 30px;;float: left;text-align:right;">
                    <span>权限名称：</span>
                </div>
                <div style="width: 70%;height:30px;line-height: 30px;;float: left;text-align: left;">
                    <input id="name" name="name" type="text"/>
                </div>
            </div>
            <div style="width: 100%;height: 30px;line-height: 30px;">
                <div style="width: 30%;height:30px;line-height: 30px;;float: left;text-align:right;">
                    <span>权限权值：</span>
                </div>
                <div style="width: 70%;height: 30px;line-height: 30px;float: left;text-align: left;">
                    <input id="value" name="value" type="text"/>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    var parameters = {
        Action: {
            getPermissions: "${_RootPath}/RBAC/getPermissions",
            addPermission: "${_RootPath}/RBAC/addPermission",
            deletePermission: "${_RootPath}/RBAC/deletePermission",
            updPermission: "${_RootPath}/RBAC/updPermission"
        }
    };

    function InitPermissionTable() {
        var gridPermission = new XspWeb.Controls.RemoteDataGrid();
        gridPermission.Initialize("#t_permission", parameters.Action.getPermissions, {
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
            field: "name",
            title: "名称",
            width: 60
        }, {
            field: "value",
            title: "权值",
            width: 60
        }, {
            field: "role_names",
            title: "包含该权限的角色",
            width: 120
        }, {
            field: "BtnShow",
            ContentType: "button",
            text: "编辑",
            width: 40,
            handler: function (index, row) {
                editPermissionDialog(gridPermission, row);
            }
        }, {
            field: "BtnDelete",
            ContentType: "button",
            text: "删除",
            width: 40,
            handler: function (index, row) {
                deletePermission(gridPermission, row);
            }
        }]]);

        return gridPermission;

    }

    function addPermissionDialog() {
        $("#name").val("");
        $("#value").val("");
        XspWeb.Misc.Dialog($("#divAdd"), {
            title: "新增权限",
            width: 300,
            height: 200,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "新增",
                handler: function () {
                    addPermissions();
                }
            }]
        });
    }

    function addPermissions() {

        var _name = $("#name").val();
        if (!_name && $.trim(_name) == '') {
            XspWeb.Misc.Tips('权限名称不可为空');
            return;
        }

        var _value = $("#value").val();
        if (!_value && $.trim(_value) == '') {
            XspWeb.Misc.Tips('权限值不可为空');
            return;
        }

        $("#f_permission").form("submit", {
            url: parameters.Action.addPermission,
            success: function (data) {
                var odata = eval("(" + data + ")");
                XspWeb.Misc.Tips(odata.message);
                $("#divAdd").dialog('close');
                $("#t_permission").datagrid("reload");
            }
        });
    }

    function editPermissionDialog(gridPermission, row) {
        $("#name").val(row.name);
        $("#value").val(row.value);
        XspWeb.Misc.Dialog($("#divAdd"), {
            title: "查看权限",
            width: 300,
            height: 200,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "确定",
                handler: function () {
                    editPermission(gridPermission, row);
                }
            }]
        });
    }

    function editPermission(gridPermission, row) {

        if ($("#name").val() !== row.name || $("#value").val() !== row.value) {
            var jsonArr = [];
            jsonArr.push("\"id\":\"" + row.id + "\"");
            jsonArr.push("\"name\":\"" + $("#name").val() + "\"");
            jsonArr.push("\"value\":\"" + $("#value").val() + "\"");
            var json = "{" + jsonArr.join(",") + "}";
            XspWeb.Misc.Ajax({
                action: parameters.Action.updPermission,
                data: {
                    json: json
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code === 0) {
                        $("#divAdd").dialog('close');
                        gridPermission.LoadRemoteData();
                    }

                }
            })
        }
        else {
            $("#divAdd").dialog('close');
            gridPermission.LoadRemoteData();
        }
    }

    function deletePermission(gridPermission, row) {
        XspWeb.Misc.Confirm("确定删除" + row.name + "权限吗?", function () {
            XspWeb.Misc.Ajax({
                action: parameters.Action.deletePermission,
                data: {
                    id: row.id
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code === 0)
                        gridPermission.LoadRemoteData();
                }
            })
        });
    }

    function loadPermissionGridData() {
        var gridPermission = InitPermissionTable();
        gridPermission.LoadRemoteData();
    }

    function bindBtnEvent() {
        $("#addPermissionBtn").click(addPermissionDialog);
    }

    $(function () {
        loadPermissionGridData();
        bindBtnEvent();
    });
</script>
</body>
</html>