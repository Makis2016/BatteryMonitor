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
<!DOCTYPE html PUBLIC "-//W3C//Ddiv XHTML 1.0 divansitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>个人信息</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
</head>
<body id="layout_main" class="easyui-layout minheightwidth" data-options="fit:divue">
<style type="text/css">
    #personalInfo {
        width: 100%;
        height: 100%;
        background-color: #FFFFFF;
        overflow: auto;
    }

    #d_table {
        width: 400px;
        height: 350px;
        margin: 50px;
    }

    .d-tr {
        width: 400px;
    }

    .div-lable {
        width: 80px;
        float: left;
        height: 50px;
        line-height: 50px;
    }

    .input-text {
        width: 120px;
        height: 20px;
        line-height: 20px;
        margin: 15px 0 0 0;
    }

    .input-radio {
        height: 20px;
        line-height: 20px;
        margin: 15px 0 0 0;
    }

    .input-button {
        margin: 12px 0;
        width: 75px;
        height: 25px;
        line-height: 25px;
        border-radius: 10px;
        border-width: 1px;
        background-color: #2693CE;
        color: #ffffff;
    }

    .combobox {
        margin: 15px 0 0 0;
        width: 100px;
    }

    .combo {
        margin: 15px 0 0 0;
    }

    .window {
        background: #000000;
        padding: 0;
        border: 1px solid #000000;
    }

    .panel-header {
        height: 25px;
    }

    .window .window-header {
        padding: 0px 0px 0px 0px;
    }

    .panel-title {
        padding: 0;
        line-height: 25px;
        height: 25px;
    }

    .panel-tool a {
        display: block;
        margin: 0px;
    }

    .dialog-button {
        text-align: center;
        border: none;
        background: #ffffff;
    }

    .contentDiv {
        padding: 8px 0px 0 90px;
    }

    a.l-btn span.l-btn-left {
        background-image: none;
    }

    .dialog-button .l-btn {
        margin-left: 5px;
        background: #2596d2;
        color: #fff;
    }

    .window .window-header .panel-icon, .window .window-header .panel-tool {
        top: 50%;
        margin-top: -6px;
    }
</style>
<div id="personalInfo">
    <div id="d_table">
        <div class="d-tr">
            <div class="div-lable">姓名：</div>
            <div style="width: 120px;height:50px;line-height:50px;float: left"><input id="name" type="text"
                                                                                      class="input-text" value=""/>
            </div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
        </div>
        <div class="d-tr">
            <div class="div-lable">性别：</div>
            <div style="width: 60px;height:50px;line-height:50px;float: left"><input type="radio" name="sex"
                                                                                     checked="checked" id="sexMan"/>男
            </div>
            <div style="width: 60px;height:50px;line-height:50px;float: left"><input type="radio" name="sex"
                                                                                     id="sexWuMan"/>女
            </div>
            <div style="width: 200px;height:50px;line-height:50px;float: left"></div>
        </div>
        <div class="d-tr">
            <div class="div-lable">所属机构：</div>
            <div style="width: 120px;height:50px;line-height:50px;float: left"><select class="easyui-combobox combobox"
                                                                                       id="affiliated_institutions"
                                                                                       name="affiliated_institutions"></select>
            </div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
        </div>
        <div class="d-tr">
            <div class="div-lable">区域：</div>
            <div style="width: 100px;height:50px;line-height:50px;float: left">
                <select id="point1_id" class="combobox" id="point1_id" name="point1_id"></select>
            </div>
            <div style="width: 100px;height:50px;line-height:50px;float: left">
                <select id="point2_id" class="combobox" id="point2_id" name="point2_id"></select>
            </div>
            <div style="width: 120px;height:50px;line-height:50px;float: left">
                <select id="point3_id" class="combobox" id="point3_id" name="point3_id"></select>
            </div>
        </div>
        <div class="d-tr">
            <div class="div-lable">联系电话：</div>
            <div style="width: 120px;height:50px;line-height:50px;float: left"><input id="tel_no" type="text"
                                                                                      class="input-text"/></div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
        </div>
        <div class="d-tr">
            <div class="div-lable">邮箱:</div>
            <div style="width: 120px;height:50px;line-height:50px;float: left"><input id="email" type="text"
                                                                                      class="input-text"/></div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
            <div style="width: 100px;height:50px;line-height:50px;float: left"></div>
        </div>
        <div class="d-tr">
            <div style="width: 60px;height:50px;line-height:50px;float: left"></div>
            <div style="width: 80px;height:50px;line-height:50px;float: left">
                <input id="btnEdit" type="button" value="提交修改" class="input-button"/></div>
            <div style="width: 80px;height:50px;line-height:50px;float: left">
                <input id="btnEditPass" type="button" value="修改密码" class="input-button"/
            </div>
            <div style="width: 180px;height:50px;line-height:50px;float: left"></div>
        </div>
    </div>
</div>
<div style="display: none;">
    <div id="editPasswordDialog" style="background-color: #ffffff">
        <div class="contentDiv" style="float: left;">
            <span style="float: left;display: block;height: 30px;line-height: 30px;width: 80px;">
                旧密码：
            </span>
            <input id="oldPass" type="password" style="float: left;width: 120px;height: 30px;line-height: 30px;"/>
        </div>
        <div class="contentDiv" style="float: left;">
            <span style="float: left;display: block;height: 30px;line-height: 30px;width: 80px;">
                新密码：
            </span>
            <input id="newPass" type="password" style="float: left;width: 120px;height: 30px;line-height: 30px;"/>
        </div>
        <div class="contentDiv" style="float: left;">
            <span style="float: left;display: block;height: 30px;line-height: 30px;width: 80px;">
                重复新密码:
            </span>
            <input id="rNewPass" type="password" style="float: left;width: 120px;height: 30px;line-height: 30px;"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    var mUserInfo = '${userJson}';
    var parameters = {
        Action: {
            editPersonInfo: "${_RootPath}/System/editPersonInfo",
            editPassword: "${_RootPath}/System/editPassword",
            getPoint1Names: "${_RootPath}/getPoint1Names",
            getPoint2Names: "${_RootPath}/getPoint2Names?pid=",
            getPoint3Names: "${_RootPath}/getPoint3Names?pid="
        }
    };

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

                var data = $("#point1_id").combobox('getData');
                if (mUserInfo&&data) {
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

                var data = $("#point2_id").combobox('getData');
                if (mUserInfo && data) {
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
                var data = $("#point3_id").combobox('getData');
                if (mUserInfo&&data) {
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

    function formatJson() {
        var user = ${userJson};
        var conditions = [];
        if (user) {
            var id = user.id;
            conditions.push("\"id\":\"" + id + "\"");
        }

        var name = $("#name").val();
        if (!name || $.trim(name) === "") {
            XspWeb.Misc.Tips("姓名必须填写");
            return;
        }
        conditions.push("\"name\":\"" + name + "\"");

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
        conditions.push("\"email\":\"" + email + "\"");

        var tel_no = $("#tel_no").val();
        conditions.push("\"tel_no\":\"" + tel_no + "\"");

        var affiliated_institutions = $("#affiliated_institutions").combobox("getValue");
        conditions.push("\"affiliated_institutions\":\"" + affiliated_institutions + "\"");

        var sex = 0
        if ($("#sexMan")[0].checked) {
            sex = 1;
        }
        conditions.push("\"sex\":\"" + sex + "\"");

        return "{" + conditions.join(",") + "}";
    }
    function submitEdit() {
        XspWeb.Misc.Ajax({
            action: parameters.Action.editPersonInfo,
            data: {
                json: formatJson()
            },
            success: function (data) {
                XspWeb.Misc.Tips(data.message);
                if (data.code === 0) {
                    mUserInfo = data.data+"";
                    initPersonInfo();
                }
            }
        });
    }

    function initPersonInfo() {
        if (mUserInfo) {
            var user = JSON.parse(mUserInfo);
            $("#name").val(user.name);
            $("#email").val(user.email);
            $("#tel_no").val(user.tel_no);

            if (user.affiliated_institutions != "" || user.affiliated_institutions != 'null')
                $("#affiliated_institutions").combobox("select", user.affiliated_institutions);

            var sex = user.sex;
            if (sex === 1) {
                $("#sexMan")[0].checked = true;
            } else {
                $("#sexWuMan")[0].checked = true;
            }
        }
    }

    function editPassword() {
        XspWeb.Misc.Dialog($("#editPasswordDialog"), {
            title: "修改密码",
            width: 400,
            height: 200,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "修改",
                handler: function () {
                    var json = '${userJson}';
                    if ($("#newPass").val() !== $("#rNewPass").val()) {
                        XspWeb.Misc.Tips("两次密码输入不一致");
                        return;
                    }
                    XspWeb.Misc.Ajax({
                        action: parameters.Action.editPassword,
                        data: {
                            oldPass: $("#oldPass").val(),
                            newPass: $("#newPass").val(),
                            json: json
                        },
                        success: function (data) {
                            XspWeb.Misc.Tips(data.message);
                            if (data.code === 0) {
                                $("#editPasswordDialog").dialog('close');
                            }
                        }
                    });
                }
            }]
        });
    }

    $(function () {
        initPoint1Com();
        initAffiliatedCom();
        initPersonInfo();
        $("#btnEdit").click(submitEdit);
        $("#btnEditPass").click(editPassword);
    })
</script>
</body>
</html>