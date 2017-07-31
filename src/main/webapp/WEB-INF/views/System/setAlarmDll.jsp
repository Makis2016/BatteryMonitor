<%--
  Created by IntelliJ IDEA.
  User: Linyudui
  Date: 2016/7/21
  Time: 15:34
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

</head>
<body id="layout_main" class="easyui-layout minheightwidth" data-options="fit:true">
<style type="text/css">
    #about {
        width: 100%;
        height: 100%;
        background-color: #ffffff;
        position: relative;
    }

    #about-img {
        width: 600px;
        height: 400px;
        margin: auto;
        background-color: #00a2d4;
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
    }

    #heard-img, #content, #footer {
        width: 100%;
    }

    #heard-img {
        height: 100px;
        color: #ffffff;
        background-color: #40526B;
    }

    #content {
        background-color: #f0f1f9;
        height: 250px;
    }

    #footer {
        background-color: #f0f0f0;
        height: 50px;
        text-align: right;
    }

    #footer input {
        width: 150px;
        height: 30px;
    }
</style>
<div id="about">
    <div id="about-img">
        <div id="heard-img"></div>
        <div id="content">
            <div style="width: 400px;padding: 30px 50px;">
                <div style="padding-top: 5px;">电池组动态库版本:<span id="batteryPackVersion">未知</span></div>
                <div style="padding-top: 5px;">单体动态库版本:<span id="batteryVersion">未知</span></div>
                <%--<div style="padding-top: 5px;">ECU版本:<span id="ECUVersion">未知</span></div>--%>
                <div style="padding-top: 5px;">系统版本号:<span id="systemVersion">V20170105385</span></div>
                <div style="padding-top: 5px;">
                        <span>
                            福容软件 版权所有
                        </span>
                </div>
                <div style="padding-top: 5px;">
                        <span>
                            Copyright© 2016 Fujian Furong Software Technologies Co.,Ltd. All Rights Reserved.
                        </span>
                </div>
            </div>
        </div>
        <div id="footer">
            <input type="button" value="更新告警动态库" onclick="importDllFile()"/>
        </div>
    </div>
</div>

<div style="display: none;">
    <div id="uploadDialog">
        <div style="width: 300px;left: 80px;top: 24px;padding: 15px;">
            <div style="padding: 0 0 5px 0">
                <span style="display: block;float: left;">类型：</span>
                <select id="type" class="easyui-combobox" style="width: 200px;" name="type"></select>
            </div>
            <form id="from1" enctype="multipart/form-data" method="post">
                <div>
                    <span style="display: block;float: left;">上传文件：</span>
                    <input style="float: left;" type="file" name="file"/>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    function importDllFile() {
        var obj = $("#uploadDialog");
        XspWeb.Misc.Dialog(obj, {
            title: "导入",
            width: 400,
            height: 150,
            maximizable: false,
            minimizable: false,
            buttons: [{
                text: "确定",
                handler: function () {
                    var url = '${_RootPath}/System/importBatteryPackAlarmDllFile';
                    var type = $("#type").combobox('getValue');
                    if (type == 1) {
                        url = '${_RootPath}/System/importBatteryAlarmDllFile';
                    }

                    if (!FormData) {
                        XspWeb.Misc.Tips("当前不支持在此版本浏览器上传");
                        return;
                    }

                    var formData = new FormData($("#from1")[0]);
                    $.ajax({
                        url: url,
                        type: 'POST',
                        data: formData,
                        async: false,
                        cache: false,
                        contentType: false,
                        processData: false,
                        success: function (rec) {
                            XspWeb.Misc.Tips(rec.message);
                            if (rec.code == 0) {
                                obj.dialog('close');
                            }
                        },
                        error: function (rec) {
                            //console.log(rec);
                        }
                    });
                }
            }]
        });
    }

    function showVersionNumberOfBPDLLAndBDLL() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getVersionNumberOfBPDLLAndBDLL",
            success: function (data) {
                if(data){
                    $("#batteryPackVersion").html(data.BPDLLVerSionNum);
                    $("#batteryVersion").html(data.BDLLVerSionNum);
                    $("#ECUVersion").html(data.ECUVersion);
                }
            }
        });
    }

    $(function () {
        showVersionNumberOfBPDLLAndBDLL();
        var type = [[0, 'batteryPackAlarm'], [1, 'batteryAlarm']];
        $("#type").combobox({
            data: type,
            textField: 1,
            valueField: 0
        });
        $("#type ").combobox('select', 0);
    });
</script>
</body>
</html>