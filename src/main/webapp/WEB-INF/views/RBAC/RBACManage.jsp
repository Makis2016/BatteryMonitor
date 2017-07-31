<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>权限设置</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
</head>
<body id="layout_main" class="easyui-layout minheightwidth" data-options="fit:true">
<style type="text/css">
    .tabs {
        height: 40px !important;
        line-height: 40px;
    }

    .tabs-header {
        border-color: #ffffff;
        height: 40px;
        background-color: rgba(255, 255, 255, 0);
    }

    .tabs-wrap {
        height: 40px;
    }

    .tabs li a.tabs-inner {
        height: 40px !important;
        line-height: 40px !important;
        width: 80px;
        color: #ffffff;
        background: #2794D5;
    }

    .tabs li.tabs-selected a.tabs-inner {
        border: none;
        color: #000000;
        background-color: #e8ecef;
    }

    .tabs li a.tabs-close {
        display: none;
    }

    .tabs-header, .tabs-scroller-left, .tabs-scroller-right, .tabs-tool, .tabs, .tabs-panels, .tabs li a.tabs-inner, .tabs li.tabs-selected a.tabs-inner, .tabs-header-bottom .tabs li.tabs-selected a.tabs-inner, .tabs-header-left .tabs li.tabs-selected a.tabs-inner, .tabs-header-right .tabs li.tabs-selected a.tabs-inner {
        border: none;
    }

    /*grid*/
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

    .tabs-wrap .tabs{
        width: auto;
        float: right;
    }
</style>
<div id="RBAC" style="height: 100%;width: 100%;background-color: rgba(0, 0, 0, 0);">
    <div id="tabMenu_2" style="height: 100%;background-color: rgba(0, 0, 0, 0);">
        <div title="用户管理">
            <div style="width: 90%;height: 90%;padding: 10px 0 0 0px;margin: auto;">
                <input id="addUserBtn" type="button" value="新增"
                       style="border-width: 1px;margin-bottom: 15px;color: #ffffff;border-radius: 20px;width: 80px;height: 35px; background-color: #2794D5;"/>
                <div id="d_user" style="width: 100%;height: 100%;">
                    <table id="t_user"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var parameters = {
        Action: {
            getPoint1Names: "${_RootPath}/getPoint1Names",
            getPoint2Names: "${_RootPath}/getPoint2Names?pid=",
            getPoint3Names: "${_RootPath}/getPoint3Names?pid=",
            getUsers: "${_RootPath}/RBAC/getUsers",
            addUser: "${_RootPath}/RBAC/addUser",
            updUser: "${_RootPath}/RBAC/updUser",
            deleteUser: "${_RootPath}/RBAC/deleteUser"
        }
    };

    /* tabs初始化 */
    function initRBACTabMenu() {
        window.tabMenu = new XspWeb.Controls.Tabs("#tabMenu_2");
        tabMenu.Initialize({
            closable: false,
            selected:-1,
            onSelect: function (title, index) {
                if(index == 0){
                    loadUserGridData();
                }else{
                    tabMenu.RefreshTab();
                }
            }
        });

        tabMenu.AddTab("角色管理", "/BatteryMonitor/RBAC/roleManagement");
        tabMenu.AddTab("模块管理", "/BatteryMonitor/RBAC/moduleManagement");
        tabMenu.AddTab("权限管理", "/BatteryMonitor/RBAC/permissionManagement");
        tabMenu.SelectTab(0);
    }

    /* 用户管理 */
    // 设置用户列表
    function initUserGrid() {
        var gridUser = new XspWeb.Controls.RemoteDataGrid();
        gridUser.Initialize("#t_user", parameters.Action.getUsers, {
            border: false,
            fit: true,
            scrollbarSize: 0,
            pageSize: 20,
            pageList: [20]
        }).SetColumns([[{
            field: "id",
            hidden: true,
            width: 30
        }, {
            field: "point1_id",
            hidden: true,
            width: 30
        }, {
            field: "point2_id",
            hidden: true,
            width: 30
        }, {
            field: "point3_id",
            hidden: true,
            width: 30
        }, {
            field: "role_id",
            hidden: true,
            width: 30
        }, {
            field: "login_id",
            title: "用户名",
            width: 80
        }, {
            field: "starus",
            title: "帐号状态",
            width: 80,
            formatter: function (value, rowData, rowIndex) {
                if (value === 1) {
                    return "启用";
                } else {
                    return "停用";
                }
            }
        }, {
            field: "role_name",
            title: "角色",
            width: 80
        }, {
            field: "name",
            title: "姓名",
            width: 80
        }, {
            field: "sex",
            title: "性别",
            width: 80,
            formatter: function (value, rowData, rowIndex) {
                if (value === 1) {
                    return "男";
                } else {
                    return "女";
                }
            }
        }, {
            field: "affiliated_institutions",
            title: "所属机构",
            width: 80
        }, {
            field: "tel_no",
            title: "联系电话",
            width: 80
        }, {
            field: "email",
            title: "邮箱",
            width: 100
        }, {
            field: "BtnShow",
            ContentType: "button",
            text: "编辑",
            width: 40,
            handler: function (index, row) {
                editUserDialog(gridUser, row);
            }
        }, {
            field: "BtnLock",
            ContentType: "button",
            text: "锁",
            width: 40,
            handler: function (index, row) {
                bindUser(gridUser, row);
            }
        }, {
            field: "BtnDelete",
            ContentType: "button",
            text: "删除",
            width: 40,
            handler: function (index, row) {
                deleteUser(gridUser, row);
            }
        }]]);

        return gridUser;

    }

    // 新增用户dialog
    function addUserDialog() {
        var addUserDialog = new XspWeb.Controls.Dialog("addUserDialog");
        addUserDialog.SetUrl("${_RootPath}/RBAC/setUserDialog")
                .SetCallback({
                    name: "addUserSuccess",
                    callback: function () {
                        addUserDialog.Hide();
                        $("#t_user").datagrid("reload");
                    }
                }).Show({
            title: "新增用户",
            width: 600,
            height: 300,
            maximizable: false,
            minimizable: false
        }, true);
    }

    // 删除用户
    function deleteUser(gridUser, row) {
        XspWeb.Misc.Confirm("确定删除" + row.name + "用户吗?", function () {
            XspWeb.Misc.Ajax({
                action: parameters.Action.deleteUser,
                data: {
                    id: row.id
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code === 0) {
                        gridUser.LoadRemoteData();
                    }
                }
            })
        });
    }

    // 锁/解锁 用户
    function bindUser(gridUser, row) {
        var obj = row;
        obj.starus = row.starus == 0 ? 1 : 0;
        var json = JSON.stringify(obj);
        XspWeb.Misc.Ajax({
            action: parameters.Action.updUser,
            data: {
                json: json,
                role_id: obj.role_id
            },
            success: function (rec) {
                XspWeb.Misc.Tips(rec.message);
                if (rec.code === 0) {
                    gridUser.LoadRemoteData();
                }
            }
        });
    }

    // 编辑用户dialog
    function editUserDialog(gridUser, row) {
        var objJson = JSON.stringify(row);
        var editUserDialog = new XspWeb.Controls.Dialog("editUserDialog");
        editUserDialog.SetUrl("${_RootPath}/RBAC/setUserDialog?userInfo=" + objJson)
                .SetCallback({
                    name: "editUserSuccess",
                    callback: function () {
                        editUserDialog.Hide();
                        gridUser.LoadRemoteData();
                    }
                }).Show({
            title: "编辑用户",
            width: 600,
            height: 300,
            maximizable: false,
            minimizable: false
        }, true);
    }

    // 初始化用户列表和加载数据
    function loadUserGridData() {
        var gridUser = initUserGrid();
        gridUser.LoadRemoteData();
    }

    // 异步加载用户列表数据
    function loadUserDataByAjax() {
        XspWeb.Misc.Ajax({
            action: parameters.Action.getUsers,
            data:{
                page:1,
                rows:20
            },
            success: function (data) {
                if (data) {
                    $("#t_user").datagrid('loadData', data);
                }
            }
        });
    }


    // 绑定按钮事件
    function bindBtnEvent() {
        $("#addUserBtn").click(addUserDialog);
    }

    $(function () {
        initRBACTabMenu();
        //loadUserGridData();
        bindBtnEvent();
    });
</script>
</body>
</html>