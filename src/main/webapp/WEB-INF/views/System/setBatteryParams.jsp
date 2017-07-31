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
    #comNetWorkParam {
        width: 100%;
        height: 100%;
        background-color: #FFFFFF;
        overflow: auto;
    }
</style>
<div id="comNetWorkParam">
    <input type="button" value="导入" onclick="importDllFile()"/>
</div>
<div style="display: none;">
    <div id="uploadDialog">
        <div style="width: 200px;left: 80px;top: 24px;">
            <form id="from1" enctype="multipart/form-data"
                  method="post">
                上传文件1：<input type="file" name="file1"/>
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
                    var url = '${_RootPath}/System/importDllFile'
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
                            console.log(rec);
                        }
                    });
                }
            }]
        });
    }
</script>
</body>
</html>