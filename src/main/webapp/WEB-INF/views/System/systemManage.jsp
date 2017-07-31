<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/XspWebTags.tld" prefix="x" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript">
        var _RootPath = "${_RootPath}";
    </script>
</head>
<body>
<style type="text/css">
    .panel-body {
        background-color: rgba(255, 255, 255, 0);
        border :none;
    }

    .panel-header {
        background-color: #41526C;
        background: #41526C;
        border-color: #41526C;
        height: 20px;
    }

    .panel-title {
        color: #f4f4f4;
        margin-left: 20px;
        padding: 2px 0 2px 0;
    }

    .panel-tool a {
        display: none;
    }

    .layout-split-west {
        border-right: 10px solid rgba(230, 238, 248, 0);
    }

    .layout-split-north {
        border-bottom: 15px solid rgba(230, 238, 248, 0);
    }

    #div_tree {
        width: 240px;
        padding: 40px 20px 0 20px;
    }

    #treeRMenu {
        position: absolute;
        display: none;
    }

    #treeRMenu ul {
        position: absolute;
        float: left;
        border: 1px solid #979797;
        background: #f1f1f1;
        padding: 2px;
        box-shadow: 2px 2px 2px rgba(0, 0, 0, .6);
        width: 120px;
        overflow: hidden;
    }

    #treeRMenu ul li {
        float: left;
        clear: both;
        height: 24px;
        cursor: pointer;
        line-height: 24px;
        white-space: nowrap;
        padding: 0 30px;
        width: 100%;
        display: inline-block;
    }

    #treeRMenu ul li:hover {
        background: #E6EDF6;
        border: 1px solid #B4D2F6;
    }

    .window {
        background: #ffffff;
        padding: 0;
    }

    .window .window-header {
        background: #000000;
        padding: 0px 0px 6px 0px;
    }

    .window-header .panel-tool a {
        display: block;
    }

    .window, .window .window-body {
        border: none;
        border-bottom: 1px solid;
        border-right: 1px solid;
        border-left: 1px solid;
    }

    .window-shadow {
        background: none;
    }

    .panel-title {
        padding: 6px 0 0px 0;
    }

    .tabs-panels{
        background-color: #ecefe8;
    }

    .combobox-item, .combobox-group {
        background-color: #efefef;
        border: 1px solid rgba(170, 197, 231, 0.63);
    }

    .combobox-item-selected {
        background-color: #fbec88;
        color: #000000;
    }
</style>
<%@ include file="/WEB-INF/tags/ZTree.ftl" %>
<div class="easyui-layout minheightwidth" data-options="fit:true">
    <div data-options="region:'west',split:true"
         style="width:290px;background-color: #41526C;border: #41526C;">
        <div id="div_tree">
            <ui id="tree" class="fr_ztree"></ui>
        </div>
    </div>
    <div region="center" style="border: none;width: 100%;height: 100%;">
        <div id="sys_main_content" class="easyui-panel" data-options="fit:true"
             style="background-color: rgba(0, 0, 0, 0);">
        </div>
    </div>
</div>
<script type="text/javascript">
    var parameters = {
        Action: {
            getRightMenu: "${_RootPath}/getRightMenu?id=${id}"
        }
    };

    function InitMenuTree() {
        var zTreeDefaultSetting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid"
                }
            },
            view: {
                dblClickExpand: true,
                showLine: false,
                showIcon: true,
                selectedMulti: true
            },
            callback: {
                onClick: function (event, treeId, treeNode) {
                    $("#sys_main_content").panel({
                        href: '${_RootPath}/' + treeNode.address
                    });
                }
            }
        };

        XspWeb.Misc.Ajax({
            action: parameters.Action.getRightMenu,
            success: function (data) {
                var ztreeObj = $.fn.zTree.init($("#tree"), zTreeDefaultSetting, data);
                var treeNode = ztreeObj.getNodeByParam("name", data[0].name);
                ztreeObj.selectNode(treeNode);
                $("#sys_main_content").panel({
                    href: '${_RootPath}/'+treeNode.address
                });
            }
        });
    }

    $(function () {
        InitMenuTree();
    });
</script>
</body>
</html>