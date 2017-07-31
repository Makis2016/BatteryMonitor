<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>欢迎登录电池监测系统</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <script type="text/javascript">
        var _RootPath = "${_RootPath}";
    </script>
    <style type="text/css">
        input {
            outline: none;
        }

        .panel-body {
            border: none;
        }

        .tap_menu {
            border: none;
            width: 100px;
            height: 30px;
            line-height: 30px;
            color: #333;
            background-color: #ffffff;
            border-radius: 20px;
            margin-left: 5px;
        }

        .aui_state_focus, .aui_state_lock {
            background-color: #fff;
            border: 3px solid #000;
        }

        .aui_title {
            float: left;
        }

        .aui_close {
            display: inline-block;
            width: 16px;
            height: 18px;
            text-align: center;
            line-height: 18px;
            background: url('resources/xspweb/client/scripts/jquery-easyui-1.3.5/themes/default/images/panel_tools.png') no-repeat -16px 2px;
            color: #fff;
            font-weight: 300;
            font-size: 12px;
            text-decoration: none;
            float: right;
        }

        .aui_buttons {
            text-align: right;
        }

        .panel-loading {
            margin: auto;
            width: 100px;
            position: relative;
            top: 45%;
        }

        .tab-selected {
            color: #ffffff;
            background-color: #2794d5;
        }
    </style>
    <%@ include file="/WEB-INF/tags/header.ftl" %>
</head>
<body class="easyui-layout minheightwidth" data-options="fit:true">
<div region="north"
     style="height:134px;text-align:center;">
    <div style="height: 65%;background-color: #000000">
        <div style="font-weight:bold; font-size: 25px;color:#FFf;padding-left:3%;padding-top:18px;float:left;">
            <div style="float: left"><img src="${_RootPath}/resources/images/logo.png"
                                          style="height: 50px;" alt=""/></div>
            <span style="display: block;float: left;margin: 10px;">蓄电池监控系统</span>
        </div>
        <div
                style="color:#FFF;padding-top:4%;padding-right:5%;float:right;">
            <script language=JavaScript>
                var username = "${username}";
                document.write("<font color=#FFFFFF style='font-size:10pt;font-family: 宋体'>欢迎您,", username, " / <a href='javascript:;' onclick='logout()' style='text-decoration: none;color: #FFF'>登出</a></font>");
            </script>
        </div>
    </div>
    <div style="height:35%;background-color:#41526C">
        <div id="tabMenu" style="padding: 9px 20px 0 0;text-align: right;">
        </div>
    </div>
</div>
<div id="main_center" region="center" class="easyui-panel"
     style="padding: 20px;border: none;background: url(resources/images/b_img.png);background-position: center;">
</div>

<script type="text/javascript">
    var parameters = {
        Action: {
            getTabMenu: "${_RootPath}/getTabMenu"
        }
    };

    function getTabMenu() {
        var tabMenuArr =  ${tabMenuList};
        for (var i = 0; i < tabMenuArr.length; i++) {
            var btnMenu = VElement('input', {
                'id': 'input' + tabMenuArr[i].id, 'type': 'button', 'class': 'tap_menu',
                'value': tabMenuArr[i].name,
                'onclick': 'setPanelUrl("' + tabMenuArr[i].url + '",this)'
            });
            document.getElementById("tabMenu").appendChild(btnMenu.render());
        }

    }

    function setPanelUrl(url, obj) {
        var inputTabs = $("#tabMenu input");
        for (var i = 0; i < inputTabs.length; i++) {
            $(inputTabs[i]).removeClass("tab-selected");
        }
        $(obj).addClass("tab-selected");

        if (parameters) {
            if (parameters.Public) {
                if (parameters.Public.groupTimer) {
                    clearTimeout(parameters.Public.groupTimer);
                    parameters.Public.groupTimer = null;
                }

                if (parameters.Public.mBatteryPackId) {
                    parameters.Public.mBatteryPackId = null;
                }

                if (parameters.Public.batteryPackTimeout) {
                    parameters.Public.batteryPackTimeout = false;
                }

                if (parameters.Public.isTimeout) {
                    parameters.Public.isTimeout = false;
                }
            }
        }

        if (url) {
            $("#main_center").panel(
                    'refresh', url
            );
        } else {
            $("#main_center").panel({
                href: '${_RootPath}/default'
            });
        }

    }

    function logout() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/Security/logout.action",
            success: function (data) {
                XspWeb.Misc.Tips(data.info);
                window.location.reload();
            },
            error: function () {
                XspWeb.Misc.Tips("出错");
            }
        });
    }

    $(function () {
        getTabMenu();
        var url = null;
        setPanelUrl(url);
        $("#input1").addClass("tab-selected");
    });
</script>
</body>
</html>