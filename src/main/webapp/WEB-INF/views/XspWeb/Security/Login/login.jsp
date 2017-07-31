<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>欢迎登录电池监测系统</title>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <style>
        html, body {
            height: 100%;
        }

        .span_log {
            display: inline-block;
            height: 100%;
            line-height: 48px;
            color: #FFFFFF;
            margin-left: 50px;
            font-weight: bold;
        }

        .header {
            width: 100%;
            height: 48px;
            background-color: #393938;
        }

        .center {
            height: 100%;
            margin: auto;
            text-align: center;
            width: 100%;
            background: url(resources/images/b_img.png);
            background-position: center;
        }

        .login {
            width: 350px;
            height: 400px;
            background-color: rgba(255, 255, 255, 0);
            position: absolute;
            left: 50%;
            top: 25%;
            text-align: center;
            margin-left: -195px;
        }

        .login_heard {
            width: 100%;
            height: 80px;
            float: left;
            text-align: center;
            margin-bottom: 10px;
            background-color: #40526C;
        }

        .login-log {
            line-height: 80px;
            height: 80px;
            width: 80px;
            float: left;
        }

        .login-title {
            line-height: 80px;
            height: 80px;
            width: 260px;
            float: left;
            color: #ffffff;
            font-size: 24px;
            font-weight: bold;
        }

        .login_content {
            width: 100%;
            height: 250px;
            float: left;
            text-align: center;
            background-color: #FFFFFF;
        }

        .login_footer {
            width: 100%;
            height: 60px;
            float: left;
            text-align: center;
            background-color: rgba(255, 255, 255, 0);
        }

        .login_k_input_in {
            width: 350px;
            height: 50px;
            line-height: 50px;
            float: left;
            margin-bottom: 12px;
        }

        .login_k_input_submit {
            width: 120px;
            height: 35px;
            border: none;
            border-radius: 20px;
            background-color: #2597D4;
            color: #ffffff;
            font-size: 20px;
            font-weight: bold;
        }

        .remember-user {
            width: 50%;
            height: 100%;
            line-height: 50px;
            float: left;
        }

        .remember-pass {
            width: 50%;
            height: 100%;
            line-height: 50px;
            float: left;
        }

        .CaptchaInput {
            width: 190px;
            height: 100%;
            line-height: 50px;
            float: left;
            margin: 0 0 0 22px;
        }

        .CaptchaImg {
            width: 80px;
            height: 100%;
            line-height: 50px;
            float: left;
        }

        .CaptchaRefactor {
            width: 35px;
            height: 100%;
            line-height: 50px;
            float: left;
        }

        .aui_state_focus ,.aui_state_lock{
            background-color: #fff;
            border: 3px solid #000;
        }

        .aui_title{
            float: left;
        }

        .aui_close{
            background-color: red;
            color: #fff;
            font-weight: 600;
            text-decoration: none;
            float: right;
        }

        .aui_buttons{
            text-align: right;
        }

        .combo{
            border: none;
        }

        .combo .combo-text{
            display: none;
        }

        .combo-arrow {
            background-color: rgba(0,0,0,0);
            float: right;
        }

        .usernames{
            outline: none;
            width:60px;
            height: 40px;
            line-height: 40px;
            margin: 5px;
            border: none;
        }
    </style>
</head>
<body style="margin-left:0px;margin-top:0px;margin-right:0px;margin-bottom:0px;overflow:hidden;">
<div style="height: 100%">
    <div class="header">
	        <span class="span_log">
	                  深圳市福光动力通信设备有限公司
	        </span>
    </div>
    <div class="center">
        <div class="login">
            <div class="login_heard">
                <div class="login-log">
                    <img src="${_RootPath}/resources/images/slogo.png" alt="" style="position: relative;top:10px;"/>
                </div>
                <div class="login-title">
                    蓄电池诊断与管理系统
                </div>
            </div>
            <div class="login_content">
                <div class="login_k_input_in">
                    <div style="width: 300px;margin: 10px 0 0 25px;height: 54px;border: 1px solid #ccc;">
                        <div style="float: left;padding: 13px 0 0 11px;">
                            <img src="${_RootPath}/resources/images/b_user_img.png"/>
                        </div>
                        <input type="text" id="username" name="username"
                               style="outline: none;width: 160px;height: 40px;line-height: 40px;margin: 5px 0 0 0;border: none;-webkit-box-shadow: 0 0 0px 1000px white inset;"/>
                        <select id="usernames" class="usernames">
                        </select>
                    </div>
                </div>
                <div class="login_k_input_in">
                    <div style="width: 300px;margin: 10px 0 0 25px;height: 54px;border: 1px solid #ccc;">
                        <div style="float: left;padding: 13px 0 0 11px;">
                            <img src="${_RootPath}/resources/images/yaoshi.png" style="width: 28px;height: 30px;"/>
                        </div>

                        <input type="password" id="password" name="password"
                               style="outline: none;width: 200px;height: 40px;line-height: 40px;margin: 5px 0 0 -35px;border: none;-webkit-box-shadow: 0 0 0px 1000px white inset;"/>
                    </div>
                </div>
                <div class="login_k_input_in" style="margin: 10px 0 0 0;">
                    <div class="CaptchaInput">
                        <input type="text" id="captcha" name="captcha"
                               style="width: 180px;height: 40px;line-height: 40px;border: 1px solid #ccc;outline: none;"/>
                    </div>
                    <div class="CaptchaImg">
                        <img alt="loading..." title="点击换一张"
                             src="<c:url value="/Captcha/image" />" class="login-validate-img"
                             id="ImgCodeImage" onclick="ChangeCode();"
                             style="height: 40px;width: 80px;margin: 3px 0 0 0;"/>
                    </div>
                    <div class="CaptchaRefactor">
                        <a href="javascript:;" onclick="ChangeCode();">刷新</a>
                    </div>
                </div>
                <div class="login_k_input_in">
                    <div class="remember-user"><input id="checked1" type="checkbox"/>记住账号</div>
                    <div class="remember-pass"><input id="checked2" type="checkbox"/>记住密码</div>
                </div>
            </div>
            <div class="login_footer">
                <div style="width:100%;height: 35px;padding: 25px 0 0 0;">
                    <input type="button" onclick="login()" value=" 登  录 " class="login_k_input_submit"/>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function formatJson() {
        var jsonArr = [];
        jsonArr.push('"username":"' + $("#username").val() + '"');
        jsonArr.push('"password":"' + $("#password").val() + '"');
        jsonArr.push('"captcha":"' + $("#captcha").val() + '"');
        return '{' + jsonArr.join(",") + '}';
    }
    function login() {
        XspWeb.Misc.Ajax({
            action: "/BatteryMonitor/Security/login.action",
            type: "POST",
            data: {
                json: formatJson()
            },
            success: function (data) {
                if (data.result == 0) {
                    var isRememberUser = $("#checked1").is(':checked'); //是否选择
                    var isRememberPass = $("#checked2").is(':checked');
                    if (isRememberPass) {
                        Business.Cookie.setCookie($("#username").val(),$("#password").val(),365);
                    }
                    else if (isRememberUser) {
                        Business.Cookie.setCookie($("#username").val(),"",365);
                    }

                    window.location.replace("/BatteryMonitor/Index");
                }
                else {
                    ChangeCode();
                    XspWeb.Misc.Tips(data.info)
                }
            },
            error: function () {
                XspWeb.Misc.Tips("出错");
            }
        });
    }

    function ChangeCode() {
        document.getElementById("ImgCodeImage").src = "/BatteryMonitor/Captcha/image?t" + new Date().getTime();
    }

    function initUserNamesCom(){
        var arrName = Business.Cookie.getCookieNames();
        var comDataSource = [];

        for(var i=0;i<arrName.length;i++){
            var arr = [];
            arr.push(arrName[i]);
            arr.push(arrName[i]);
            comDataSource.push(arr);
        }

        if(comDataSource&&comDataSource.length>0){
            $("#usernames").combobox({
                data:comDataSource,
                textField: 1,
                valueField: 0,
                editable: false,
                onSelect:function(data){
                    $("#username").val(data[0]);
                    $("#password").val(Business.Cookie.getCookieByName(data[0]));
                }
            });
            $("#usernames ").combobox('select', comDataSource[0][0]);
        }
    }

    // 回车登录
    document.onkeydown = function (event) {
        if (event.keyCode == 13) {
            login();
        }
    }

    $(function () {
        $("#checked2").click(function () {
            if ($("#checked2").is(':checked')) {
                $("#checked1").attr("checked", true);
            }
        });

        $("#checked1").click(function () {
            if (!$("#checked1").is(':checked')) {
                $("#checked2").attr("checked", false);
            }
        });

        initUserNamesCom();
    })

</script>
<script type="text/javascript"
        src="<c:url value="/resources/xspweb/client/scripts/thirdparty/jquery-validation-1.13.1/jquery.validate.min.js" />"></script>
<script type="text/javascript"
        src="<c:url value="/resources/xspweb/client/scripts/thirdparty/jquery-validation-1.13.1/jquery.validate.min.js" />"></script>
<script type="text/javascript"
        src="<c:url value="/resources/xspweb/client/scripts/thirdparty/jquery-plugins/jquery.cookie.js" />"></script>
<script type="text/javascript"
        src="<c:url value="/resources/xspweb/client/scripts/thirdparty/jquery-plugins/jquery.md5.js" />"></script>
</body>
</html>