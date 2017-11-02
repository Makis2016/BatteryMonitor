/**
 * 定义zTree相关常量
 */
$.DeclareClass("Business.ZTree", {
    /**
     * 静态成员
     */
    Static: {
        /**
         * 默认zTree配置
         */
        DefaultSetting: {
            data: {
                key: {
                    children: "children"
                },
                simpleData: {
                    enable: true,
                    idKey: "pkid",
                    pIdKey: "parentPkId"
                }
            },
            view: {
                showLine: true,
                showIcon: false,
                selectedMulti: false
            },
            callback: {
                onClick: function (event, treeId, treeNode) {
                    if (typeof (ZTreeNodeOnClick) === 'function') {
                        ZTreeNodeOnClick(event, treeId, treeNode);
                    }
                }
            }
        }
    }
});

/**
 * 定义常量
 */
$.DeclareClass("Business.Misc", {
    /**
     * 静态成员
     */
    Static: {
        /**
         * 将工单周期类型转换为字符串
         *
         * @param {Enum}
         *        periodType 周期类型
         */
        TaskSetPeriodTypeToString: function (periodType) {
            return (periodType == 0) ? "定期" : "周期";
        },

        /**
         * 将工单类型转换为字符串
         *
         * @param {Enum}
         *        type 工单类型
         */
        TaskSetTypeToString: function (type) {

            switch (type) {
                case 2:
                    return "认证测试";
                case 3:
                    return "巡检管控";
                case 4:
                    return "湖北测试";
                case 5:
                    return "热点测试";
                case 6:
                    return "热点定位测试";
                case 7:
                    return "热点整改测试";
                default:
                    return "性能测试";
            }
        },

        /**
         * 将任务状态转换为字符串
         *
         * @param {Enum}
         *        status 任务状态
         */
        TaskStatusToString: function (status) {

            switch (status) {
                case 1:
                    return "待指派";
                case 2:
                    return "待测试";
                case 3:
                    return "完成";
                default:
                    return "待确认";
            }
        },

        ConvertSerialMsg: function (type) {
            switch (type) {
                case "Success":
                    return "操作成功";
                case "BatteryPackNull":
                    return "无电池组";
                case "BatteryPackNameNull":
                    return "无电池组名称";
                case "NOBatteryCount":
                    return "无单体电池个数";
                case "BatteryPackTypeNull":
                    return "无电池组规格";
                case "CapacityNull":
                    return "无电池组容量";
                case "BatteryGroupThresholdNull":
                    return "电池组阈值为空";
                case "BatteryNull":
                    return "无电池";
                case "BatteryNameNull":
                    return "无单体电池名称";
                case "BatteryTypeNull":
                    return "无单体规格";
                case "BatteryCellNumNull":
                    return "无单体节数";
                case "BatteryThresholdNull":
                    return "无电池阈值";
                case "LoadBatteryPackFail":
                    return "加载电池组失败";
                case "GetObjectNull":
                    return "获取对象为空";
                case "DataBaseConnectionError":
                    return "数据库连接错误";
                default:
                    return "未知错误,请联系管理员";
            }
        },

        ConvertBatteryType: function (v) {
            switch (v) {
                case "53":
                    return "非阻燃，自制生板";
                case "51":
                    return "非阻燃，自制熟板";
                case "54":
                    return "非阻燃，外购生板";
                case "52":
                    return "非阻燃，外购熟板";
                case "63":
                    return "阻燃，自制生板";
                case "61":
                    return "阻燃，自制熟板";
                case "64":
                    return "阻燃，外购生板";
                case "62":
                    return "阻燃，外购熟板";
                default:
                    return "未知类型";
            }
        },

        ConvertDischargeType: function (type) {
            switch (type) {
                case 1:
                    return "故障";
                case 2:
                    return "运行";
                case 3:
                    return "待机";
                case 4:
                    return "掉电";
                case 5:
                    return "暂停";
                case 6:
                    return "脉冲";
                default:
                    return "初始化";
            }
        },

        ConvertGrooveType: function (type) {
            switch (type) {
                case 1:
                    return "大密";
                case 2:
                    return "中密";
                default:
                    return "未知";
            }
        },

        ConvertBatteryPlace: function (v) {
            switch (v) {
                case "0":
                    return "临安";
                case "2":
                    return "国舰";
                case "3":
                    return "海容";
                case "4":
                    return "南鹰";
                case "5":
                    return "南鹰极板佳华化成";
                case "6":
                    return "佳华";
                default:
                    return "未知产地";
            }
        },

        ConvertAlarmType: function (value) {
            switch (value) {
                case 0:
                    return "电池温度上限(℃)";
                case 1:
                    return "电池温度下限(℃)";
                case 2:
                    return "环境温度上限(℃)";
                case 3:
                    return "环境温度下限(℃)";
                case 4:
                    return "水槽温度上限(℃)";
                case 5:
                    return "水槽温度下限(℃)";
                case 6:
                    return "负压告警上限(V)";
                case 7:
                    return "负压告警下限(V)";
                default:
                    return "未知";
            }
        },

        ConvertAlarmInfoType: function (value) {
            switch (value) {
                case "DCDCFault":
                    return "充电机故障";
                case "DCDCWarning":
                    return "充电机内部告警";
                case "WarningInThreshold":
                    return "平台阈值告警";
                case "HardwareFailure":
                    return "硬件通讯告警";
                default:
                    return "未知";
            }
        },

        ConvertAlarmInfoLevel: function (value) {
            switch (value) {
                case "Critical":
                    return "严重的";
                case "SecondOnlyToCritical":
                    return "仅次于严重的";
                default:
                    return "未知";
            }
        },

        /**
         * 同步加载数据
         *
         * @param {String}
         *        url 请求数据URL
         * @param {Method}
         *        callback 加载完成回调函数
         */
        AsyncLoadData: function (url, callback) {

            if ((typeof url === "undefined") || !url)
                return;

            XspWeb.Misc.Ajax({
                action: url,
                success: function (data) {
                    if (typeof callback === "function")
                        callback(data);
                }
            });
        },

        /**
         * 正整数验证
         *
         * @param var
         *        value 验证数据
         * @return boolean
         *
         */
        validateNumber: function (value) {
            if (!value) {
                return false;
            }
            var reg = new RegExp("^[0-9]*$");
            if (!reg.test(value)) {
                return false;
            }
            return true;
        },


        /**
         * 正实数(保留两位小数)验证
         *
         * @param var
         *        value 验证数据
         * @return boolean
         *
         */
        validateFloatNumber: function (value) {
            if (!value) {
                return false;
            }

            var reg = /^-?\d+\.?\d*$/;
            return reg.test(value);
        },

        /**
         * ip格式验证
         *
         * @param var
         *        value 验证数据
         * @return boolean
         *
         */
        validateIP: function (value) {
            if (!value) {
                return false;
            }
            var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
            if (reg.test(value)) {
                return true;
            } else {
                return false;
            }
        },

        validatePhone:function(value){
            var reg = /^1(3|4|5|7|8)\d{9}$/;
            return reg.test(value);
        },

        validateMail:function(value){
            var reg  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            return reg.test(value);
        },

        validateHex:function (value) {
            var reg = /^[0-9a-fA-F]{1,4}$/
            return reg.test(value);
        }
    }
});

/**
 * 定义Cookie操作
 */
$.DeclareClass("Business.Cookie", {
    /**
     * 静态成员
     */
    Static: {
        setCookie: function (c_name, value, expiredays) {
            var exdate = new Date()
            exdate.setDate(exdate.getDate() + expiredays)
            document.cookie = c_name + "=" + escape(value) +
                ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
        },

        getCookie: function () {
            return document.cookie;
        },

        getCookieByName: function (c_name) {
            if (document.cookie.length > 0) {
                var c_start = document.cookie.indexOf(c_name + "=")
                if (c_start != -1) {
                    c_start = c_start + c_name.length + 1;
                    var c_end = document.cookie.indexOf(";", c_start)
                    if (c_end == -1) c_end = document.cookie.length
                    return unescape(document.cookie.substring(c_start, c_end))
                }
            }
            return ""
        },

        getCookieNames: function () {
            if (document.cookie.length > 0) {
                var arrCookieByName = document.cookie.split(";");
                var arrName = [];
                for (var i = 0; i < arrCookieByName.length; i++) {
                    var c_end = $.trim(arrCookieByName[i]).indexOf("=");
                    if (arrCookieByName[i])
                        arrName[i] = $.trim(arrCookieByName[i]).substring(0, c_end);
                }
                return arrName;
            }
            return ""
        }
    }
});