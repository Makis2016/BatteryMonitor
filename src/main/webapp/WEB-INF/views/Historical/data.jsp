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
<body class="easyui-layout minheightwidth" data-options="fit:true">
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
</style>
<div style="height: 100%;width: 100%;background-color: rgba(0, 0, 0, 0);">
    <div id="tabMenu_4" style="height: 100%;background-color: rgba(0, 0, 0, 0);">
    </div>
</div>
<script type="text/javascript">
    $(function () {
        window.tabMenu = new XspWeb.Controls.Tabs("#tabMenu_4");
        tabMenu.Initialize({
            closable: false,
            onSelect: function () {
                tabMenu.RefreshTab();
            }
        });

        var tabPaddingLeft = document.getElementById("tabMenu_4").style.width;
        tabPaddingLeft = parseInt(tabPaddingLeft) - 2 * 106 + 2 + "px";
        document.getElementById("tabMenu_4").firstElementChild.style.paddingLeft = tabPaddingLeft;

        tabMenu.AddTab("历史数据", "${_RootPath}/Historical/batteryGroupData");
        tabMenu.AddTab("历史告警", "${_RootPath}/Historical/alarmData");
        tabMenu.SelectTab(0);
    });
</script>
</body>
</html>
