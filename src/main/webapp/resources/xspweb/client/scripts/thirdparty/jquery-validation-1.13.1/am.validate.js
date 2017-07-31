/**
 *  Apex  电商验证脚本，继承自原有协会版本的validateCommon.js
 * User: Archer
 * Date: 13-11-7
 * Time: 下午8:47
 */

function AmValid() {
    var VALIDATESCIPT = {
        "email": /^[_\.0-9a-z-]+@([0-9a-z][0-9a-z-]+\.){1,4}[a-z]{2,3}$/i,                                                // 电子邮箱
        "mobile": /^((1(3[0-9])\d{8}$)|(1(4[0-9])\d{8}$)|(1(5[0-9])\d{8}$)|(1(7|8[0-9])\d{8}$))/,                 // 移动电话
        "telephone": /^[0-9]{3,4}-?[0-9]{7,8}$/,                                                                                            // 固定电话
        "zip": /^[0-9]\d{5}$/,                                                                                                                          // 中国邮政编码
        "date": /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/,                                                                                   // 日期
        "url": /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\:+!]*([^<>])*$/                        // 地址或者IP验证
    };
    // 对外简单的通用验证脚本
    this.validate = function(key ,value) {
        var p = VALIDATESCIPT[key];
        if ( p ) {
            return p.test($.trim(value));
        }
        return false;
    };
    // 是否合法日期，需要正则分组单独处理
    this._isDate = function(value) {
        return value.match(VALIDATESCIPT.date);
    }
}

var amValid = new AmValid();
// 是否是电子邮件
function isEmail (text) {
    return amValid.validate('email', text);
}

// 判断中英文混排时候的长度
function byteLength (sStr) {
    var aMatch = sStr.match(/[^\x00-\x80]/g);
    return (sStr.length + (! aMatch ? 0 : aMatch.length));
}

// 字符是否为空字符值;
function isEmpty(s){
    s = $.trim(s);
    return s.length == 0;
}

// 数字;
function isNumber(s){
    return !isNaN($.trim(s));
}

// 手机号码;
/*
* 运营商手机号段一览表
　　中国电信：133、153、180、189
　　中国联通：130、131、132、145、155、156、185、186
　　中国移动：134、135、136、137、138、139、147、150、151、152、157、158、159、182、183、187、188
  暂时放开：13*，14*，15*，18*号码段的校验
* */
function isMobile(text) {
    return amValid.validate('mobile', text);
}

// 固定电话;
function isPhone(text) {
    return amValid.validate('telephone', text);
}

// 中国 - 邮政编码
function isZip(text){
    return amValid.validate('zip', text);
}

// 检查密码格式是否满足8~16位
function isPassword(s){
	var p = /^[a-zA-Z0-9][\w~!@#$%^&*()\_\+{}:"<>?\-=[\];\',.\/\\\|]{7,15}$/; //
    return p.test(s);
}

// 检查潜在用户名是否符合输入格式2-16位
function isUserName(s){
    var p = /^[a-zA-Z0-9\u4e00-\u9fa5]{2,16}$/; //
    return p.test(s);
}

// 只有数字，英文，字母， -， _
function isNotContainChinese(s){
    var p = /^([a-zA-Z0-9_-])*$/;
    return p.test(s);
}

// 只有数字，字母
function isOnlyNumAndEnglish(s){
    var p = /^([a-zA-Z0-9])*$/;
    return p.test(s);
}

// 只有英文
function isOnlyEnglish(s){
    var p = /^([a-zA-Z\-\_\.\ ])*$/;
    return p.test(s);
}

// 检验日期输入合法性
function isDate(text) {
    var result = amValid._isDate(text);
    if ( result == null ) {
        return false;
    }
    var d = new Date(result[1], result[3] - 1, result[4]);
    return (d.getFullYear() == result[1] && (d.getMonth() + 1) == result[3] && d.getDate() == result[4]);
}

/**
 * 校验URL网址是否合法
 * @param text
 * @return {Boolean}
 */
function isURL(text){
    return amValid.validate('url', text);
}

// 是否是货币型数字, bZero为true的时候，表示负数货币也将被返回fasle
function isMoney(s, bZero){
    var tempValue = s.replace(/(^\s+)|(\s+$)/g,'');
    if( !tempValue ){
        return false;
    }
    if( bZero && parseFloat(tempValue) <= 0 ){
        return false;
    }
    if (  s.indexOf(".") > -1 && (s.substring(s.indexOf(".") + 1 , s.length) == "00" || s.substring(s.indexOf(".") + 1 , s.length) == "0")){
        s = s.substring(0, s.indexOf("."));
    }
    // 有小数点并且最后一位如果是0的时候，忽略这个0
    if ( s.indexOf(".") > -1 && s.substring(s.indexOf(".") + 1 , s.length).length == 2 && s.substring(s.length - 1, s.length) == "0") {
        s = s.substring(0, s.length - 1);
    }
    return /^-?\d+(\.\d{1,2})?$/.test(tempValue) && s == parseFloat(s).toString();
}

// 检查输入字符串的长度
function lengthCheck(s, max, min){
    return s.length <= max && s.length >= min;
}

// 补0函数
function Append_zore(temp, intLength) {
    var strLength = temp.length;
    if (strLength < intLength) {
        var gap = intLength - strLength;
        var zeroNum = "";
        for(var i = 0 ; i<gap; i++){
            zeroNum += "0";
        }
        return zeroNum + temp;
    }
    else {
        return temp;
    }
}

/**
 * 身份证检验函数
 * @param person_id
 * @return {{success: boolean, msg: string}}
 */
function isIDCard(person_id) {
    if ( person_id != "" ) {
        //身份证的地区代码对照
        var aCity = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外" };
        //合法性验证
        var sum = 0;
        //出生日期
        var birthday;
        //验证长度与格式规范性的正则
        var patten = new RegExp(/(^\d{15}$)|(^\d{17}(\d|x|X)$)/i);
        if (patten.exec(person_id)) {
            //验证身份证的合法性的正则
            patten = new RegExp(/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/);
            if (patten.exec(person_id)) {
                //获取15位证件号中的出生日期并转位正常日期
                //birthday = "19" + person_id.substring(6, 8) + "-" + person_id.substring(8, 10) + "-" + person_id.substring(10, 12);
                //15位身份证已失效
                return {"success": false, "msg" : "15位身份证已失效，请输入18位身份证号码！"};
            }
            else {
                person_id = person_id.replace(/x|X$/i, "a");
                //获取18位证件号中的出生日期
                birthday = person_id.substring(6, 10) + "-" + person_id.substring(10, 12) + "-" + person_id.substring(12, 14);

                //校验18位身份证号码的合法性
                for (var i = 17; i >= 0; i--) {
                    sum += (Math.pow(2, i) % 11) * parseInt(person_id.charAt(17 - i), 11);
                }

                //检测证件地区的合法性
                if (aCity[parseInt(person_id.substring(0, 2))] == null) {
                    return {"success": false, "msg" : "证件地区未知，请核对！"};
                }
                var dateStr = new Date(birthday.replace(/-/g, "/"));

                if (birthday != (dateStr.getFullYear() + "-" + Append_zore(String(dateStr.getMonth() + 1), 2) + "-" + Append_zore(String(dateStr.getDate()), 2))) {
                    return {"success": false, "msg" : "证件出生日期非法！"};
                }
                if (sum % 11 != 1) {
                    return {"success": false, "msg" : "身份证号码不符合国定标准，请核对！"};
                }
            }
        }
        else {
            return {"success": false, "msg" : "证件号码格式非法！"};
        }
    }
    else {
        return {"success": false, "msg" : "请输入证件号！"};
    }
    return {"success": true, "msg" : "成功"};
}

/**
 * 校验带小数点点后pos位的字符串是否合法
 * @param pos               小数点后N位
 * @param s                    待校验字符串
 * @return {Boolean}      是否通过检验
 */
function isFloat( pos, s ){
    var reg = new RegExp("^(([1-9]\\d*)|0)(\\.\\d{1," + pos + "})?$", "g");
    return reg.test(s);
}

// 检测浏览器是否支持 placeholder 属性
function isPlaceholder(){
    var input = document.createElement('input');
    return 'placeholder' in input;
}