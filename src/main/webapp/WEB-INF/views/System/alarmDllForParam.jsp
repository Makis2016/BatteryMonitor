<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/28
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/tags/header.ftl" %>
<div id="content"></div>
<script>
    function getBatteryPackAlarmLibrary() {
        XspWeb.Misc.Ajax({
            action: "${_RootPath}/System/getBatteryPackAlarmLibrary",
            data: {
                circuitId:${circuitId}
            },
            success: function (data) {
                console.log(data);
                $("#content").html("");
                for(var i in data){
                    $("#content").append($("<h2>"+i+":</h2>"));
                    for(var j in data[i]){
                        if(j=== "JudgeFlag" ){
                            $("#content").append("<div style='margin-bottom: 5px;'>&nbsp;&nbsp;<span style='font-weight: 600;'>"+j+":</span>");
                            for(var k in data[i][j]){
                                $("#content").append($("<div style='margin-bottom: 5px;'>&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-weight: 600;'>"+k+":</span>&nbsp;<span>"+data[i][j][k]+"</span></div>"));
                            }
                            $("#content").append("</div>");
                        }else{
                            $("#content").append($("<div style='margin-bottom: 5px;'>&nbsp;&nbsp;<span style='font-weight: 600;'>"+j+":</span>&nbsp;<span>"+data[i][j]+"</span></div>"));
                        }
                    }
                }
            }
        });
    }
    $(function () {
        getBatteryPackAlarmLibrary();
        window.alarmDll_timer = setInterval(getBatteryPackAlarmLibrary, 1000);
    });
</script>
</body>
</html>
