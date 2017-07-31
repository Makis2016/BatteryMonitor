<%--
  Created by IntelliJ IDEA.
  User: LYD
  Date: 2016/10/5
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <style>
        #userDialog a.l-btn {
            background-color: #2596d2;
            background-image: none;
        }

        #userDialog a.l-btn span.l-btn-left {
            background-image: none;
        }

        #userDialog a.l-btn span span.l-btn-text {
            color: #fff;
        }

        .btn0 {
            width: 70px;
            height: 25px;
            background-color: #2596D2;
            text-align: center;
            color: #ffffff;
        }
    </style>
</head>
<body class="easyui-layout" data-options="fit:true">
<div id="userDialog" region="center" style="background-color: #fff;padding: 20px;">
    <div style="width: 100%;height: 80px;">
        <div style="text-align:right;width: 100px;height: 40px;float: left;">用户名：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <input type="text" id="login_id" style="width: 95px;"/>
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">账号状态：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <input id="radio1" name="start" type="radio" checked="checked"/>启用
        </div>
        <div style="width: 100px;height: 40px;float: left;">
            <input id="radio2" name="start" type="radio"/>停用
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">角色：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <select id="role_name" style="width:95px"></select>
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">初始密码：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <input type="password" id="password" style="width: 95px;"/>
        </div>
    </div>
    <div style="width: 100%;height: 120px;">
        <div style="text-align:right;width: 100px;height: 40px;float: left;">姓名：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <input type="text" id="name" style="width: 95px;"/>
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">性别：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <input id="radioSex1" name="sex" type="radio"/>男
        </div>
        <div style="width: 100px;height: 40px;float: left;">
            <input id="radioSex2" name="sex" type="radio" checked="checked"/>女
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">所属机构：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <select id="affiliated_institutions" style="width:95px"></select>
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">区域：</div>
        <div style="width: 70px;height: 40px;float: left;">
            <select id="point1_id" style="width:65px"></select>
        </div>
        <div style="width: 70px;height: 40px;float: left;">
            <select id="point2_id" style="width:65px"></select>
        </div>
        <div style="width: 70px;height: 40px;float: left;">
            <select id="point3_id" style="width:70px"></select>
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">联系电话：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <input type="text" id="tel_no" style="width: 95px;"/>
        </div>
        <div style="text-align:right;width: 100px;height: 40px;float: left;">邮箱：</div>
        <div style="width: 100px;height: 40px;float: left;">
            <input type="text" id="email" style="width: 95px;"/>
        </div>
    </div>
    <div class="btn-div" style="text-align: center">
        <input class="btn0" id="btnSure" type="button" value="确定"/>
    </div>
</div>
<script>
    var mUserInfo = '${mUserInfo}';
    var parameters = {
        Action: {
            getPoint1Names: "${_RootPath}/getPoint1Names",
            getPoint2Names: "${_RootPath}/getPoint2Names?pid=",
            getPoint3Names: "${_RootPath}/getPoint3Names?pid=",
            getAllRoles: "${_RootPath}/RBAC/getAllRoles",
            addUser: "${_RootPath}/RBAC/addUser",
            updUser: "${_RootPath}/RBAC/updUser"
        }
    };

    // 初始化角色下拉框
    function initRoleNameCom() {
        $("#role_name").combobox({
            url: parameters.Action.getAllRoles,
            valueField: "id",
            textField: "name",
            editable: false
        });
    }

    // 初始化区域下拉框 -1级区域
    function initPoint1Com() {
        $("#point1_id").combobox({
            url: parameters.Action.getPoint1Names,
            valueField: "id",
            textField: "name",
            editable: false,
            onSelect: function (record) {
                initPoint2Com(record);
            },
            onLoadSuccess: function () {
                $("#point2_id").combobox({
                    url: parameters.Action.getPoint2Names + -1,
                    valueField: "id",
                    textField: "name",
                    editable: false
                });
                $("#point3_id").combobox({
                    url: parameters.Action.getPoint3Names + -1,
                    valueField: "id",
                    textField: "name",
                    editable: false
                });

                if (mUserInfo) {
                    var data = $("#point1_id").combobox('getData');
                    var obj = JSON.parse(mUserInfo);
                    var areaId = obj.point1_id;
                    if (areaId) {
                        for (var i = 0; i < data.length; i++) {
                            if (data[i].id == areaId) {
                                $("#point1_id").combobox('select', areaId);
                            }
                        }
                    }
                }
            }
        });
    }

    // 初始化区域下拉框 -2级区域
    function initPoint2Com(record) {
        $("#point2_id").combobox('clear');
        $("#point2_id").combobox({
            url: parameters.Action.getPoint2Names + record.id,
            valueField: "id",
            textField: "name",
            editable: false,
            onSelect: function (record) {
                initPoint3Com(record);
            },
            onLoadSuccess: function () {
                $("#point3_id").combobox({
                    url: parameters.Action.getPoint3Names + -1,
                    valueField: "id",
                    textField: "name",
                    editable: false
                });

                if (mUserInfo) {
                    var data = $("#point2_id").combobox('getData');
                    var obj = JSON.parse(mUserInfo);
                    var areaId = obj.point2_id;
                    if (areaId) {
                        for (var i = 0; i < data.length; i++) {
                            if (data[i].id == areaId) {
                                $("#point2_id").combobox('select', areaId);
                            }
                        }
                    }
                }
            }
        });
    }

    // 初始化区域下拉框 -3级区域
    function initPoint3Com(record) {
        $("#point3_id").combobox('clear');
        $("#point3_id").combobox({
            url: parameters.Action.getPoint3Names + record.id,
            valueField: "id",
            textField: "name",
            editable: false,
            onLoadSuccess: function () {
                if (mUserInfo) {
                    var data = $("#point3_id").combobox('getData');
                    var obj = JSON.parse(mUserInfo);
                    var areaId = obj.point3_id;
                    if (areaId) {
                        for (var i = 0; i < data.length; i++) {
                            if (data[i].id == areaId) {
                                $("#point3_id").combobox('select', areaId);
                            }
                        }
                    }
                }
            }
        });
    }

    // 初始化所属机构下拉框
    function initAffiliatedCom() {
        $("#affiliated_institutions").combobox({});
    }

    // 设置用户编辑信息
    function setUserEditInfo() {
        var row = JSON.parse(mUserInfo);
        $("#name").val(row.name);
        $("#login_id").val(row.login_id);
        $('#login_id').attr("disabled", "disabled");
        $("#role_name").combobox("select", row.role_id);
        $("#password").val(row.password);
        $('#password').attr("disabled", "disabled");
        <shiro:hasPermission name="updOtherUserPass">
        $('#password').removeAttr("disabled");
        </shiro:hasPermission>
        $("#email").val(row.email);
        $("#tel_no").val(row.tel_no);


        if (row.affiliated_institutions != "" || row.affiliated_institutions != 'null')
            $("#affiliated_institutions").combobox("select", row.affiliated_institutions);

        var starus = row.starus;
        if (starus === 1) {
            $("#radio1")[0].checked = true;
        } else {
            $("#radio2")[0].checked = true;
        }

        var sex = row.sex;
        if (sex === 1) {
            $("#radioSex1")[0].checked = true;
        } else {
            $("#radioSex2")[0].checked = true;
        }
    }

    // 封装用户信息JOSN
    function formatJson() {
        var conditions = [];
        if (mUserInfo) {
            var row = JSON.parse(mUserInfo);
            if (row) {
                var id = row.id;
                conditions.push("\"id\":\"" + id + "\"");
            }
        }

        var name = $("#name").val();
        if (!name || $.trim(name) === "") {
            XspWeb.Misc.Tips("姓名必须填写");
            return;
        }
        conditions.push("\"name\":\"" + name + "\"");

        var login_id = $("#login_id").val();
        if (!login_id || $.trim(login_id) === "") {
            XspWeb.Misc.Tips("用户名必须填写");
            return;
        }
        conditions.push("\"login_id\":\"" + login_id + "\"");

        var password = $("#password").val();
        if (!password || $.trim(password) === "") {
            XspWeb.Misc.Tips("密码必须填写");
            return;
        }
        conditions.push("\"password\":\"" + password + "\"");

        var starus = 0
        if ($("#radio1")[0].checked) {
            starus = 1;
        }
        conditions.push("\"starus\":\"" + starus + "\"");

        var point1_id = $("#point1_id").combobox("getValue");
        if (!point1_id || point1_id < 0) {
            XspWeb.Misc.Tips("一级区域必须选择");
            return;
        }
        conditions.push("\"point1_id\":\"" + point1_id + "\"");

        var point2_id = $("#point2_id").combobox("getValue");
        conditions.push("\"point2_id\":\"" + point2_id + "\"");

        var point3_id = $("#point3_id").combobox("getValue");
        conditions.push("\"point3_id\":\"" + point3_id + "\"");

        var email = $("#email").val();
        if (email) {
            if (!Business.Misc.validateMail(email)) {
                XspWeb.Misc.Tips("邮箱格式不正确");
                return;
            }
        }
        conditions.push("\"email\":\"" + email + "\"");

        var tel_no = $("#tel_no").val();
        if (tel_no) {
            if (!Business.Misc.validatePhone(tel_no)) {
                XspWeb.Misc.Tips("手机号码格式不正确");
                return;
            }
        }
        conditions.push("\"tel_no\":\"" + tel_no + "\"");

        var affiliated_institutions = $("#affiliated_institutions").combobox("getValue");
        conditions.push("\"affiliated_institutions\":\"" + affiliated_institutions + "\"");

        var sex = 0
        if ($("#radioSex1")[0].checked) {
            sex = 1;
        }
        conditions.push("\"sex\":\"" + sex + "\"");

        var role_id = $("#role_name").combobox("getValue");
        if (!role_id || $.trim(role_id) === "") {
            XspWeb.Misc.Tips("必须选择角色");
            return;
        }
        conditions.push("\"role_id\":\"" + role_id + "\"");

        return "{" + conditions.join(",") + "}";
    }

    // 添加用户
    function addUser() {
        var json = formatJson();
        if (json) {
            XspWeb.Misc.Ajax({
                action: parameters.Action.addUser,
                data: {
                    json: json
                },
                success: function (data) {
                    XspWeb.Misc.Tips(data.message);
                    if (data && data.code === 0) {
                        if (typeof XspWeb.Controls.Dialog.Callbacks.addUserSuccess === "function")
                            XspWeb.Controls.Dialog.Callbacks.addUserSuccess();
                    }
                }
            });
        }
    }

    // 编辑用户
    function editUser() {
        var json = formatJson();
        var roleId = $("#role_name").combobox("getValue");
        if (json && roleId) {
            XspWeb.Misc.Ajax({
                action: parameters.Action.updUser,
                data: {
                    json: json,
                    role_id: roleId
                },
                success: function (rec) {
                    XspWeb.Misc.Tips(rec.message);
                    if (rec.code === 0) {
                        if (typeof XspWeb.Controls.Dialog.Callbacks.editUserSuccess === "function")
                            XspWeb.Controls.Dialog.Callbacks.editUserSuccess();
                    }
                }
            });
        }
    }

    // 绑定按钮事件
    function bindBtnEvent() {
        if (mUserInfo) {
            setUserEditInfo();
            $("#btnSure").click(editUser);
        } else {
            $("#btnSure").click(addUser);
        }
    }

    // 初始化页面
    function initUserDialogHtml() {
        initRoleNameCom();
        initAffiliatedCom();
        initPoint1Com();
        bindBtnEvent();
    }

    $(function () {
        initUserDialogHtml();
    });
</script>
</body>
</html>