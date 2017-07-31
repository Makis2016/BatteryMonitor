/**
 * 创建命名空间和类
 */
$.DeclareClass = function (name, extend, prototype) {
    if (arguments.length == 2) {
        prototype = extend;
        extend = $.BaseClass;
    }
    else if (!extend) {
        extend = $.BaseClass;
    }

    prototype = prototype || {};

    // 命名空间
    var parentPackage = window;
    var nameSpace = [];
    var className = "";

    // 创建命名空间
    var CreateNameSpace = function (str) {
        parentPackage[str] = parentPackage[str] || {};
        nameSpace = parentPackage[str];
        parentPackage = nameSpace;
    };

    var namespaces = name.split(".");
    $.each(namespaces, function (i, str) {
        if (i == (namespaces.length - 1))
            className = str;
        else
            CreateNameSpace(str);
    });

    // 构造函数
    var func = nameSpace[className] = function () {
        this.Class = nameSpace[className];
        if (this.Constructor)
            this.Constructor.apply(this, arguments);
        else
            extend.prototype.Constructor.apply(this, arguments);
    };

    // 继承父类基本属性
    $.extend2(true, func.prototype, extend.prototype);

    // 本身属性及实现
    $.extend2(true, func.prototype, prototype);

    // 静态成员
    if (typeof(prototype.Static) === "object")
        $.extend2(true, func, prototype.Static);

    // 设置父类原型
    func["ClassName"] = name;
    func["Extends"] = extend;
};

/**
 * 定义基础类型
 */
$.BaseClass = {};

$.BaseClass.prototype = {
    // 父类型
    Extends: null,

    /**
     * 构造函数
     */
    Constructor: function () {
    },

    /**
     * 清理函数
     */
    Dispose: function () {
    },

    /**
     * 调用父类函数
     */
    Super: function () {
        var func = this.Super.caller.prototype["__parent_func__"];
        if (func)
            return func.apply(this, arguments);
    },

    /**
     * 对象是否为指定类型的实例
     *
     * @param String className 指定类型
     * @returns Boolean 是否为指定类型的实例
     */
    InstanceOf: function (className) {
        return (this.Class.ClassName === className);
    },

    /**
     * 对象是否为指定类型的子类型的实例
     *
     * @param String className 指定类型
     * @returns Boolean 是否为指定类型的子类型的实例
     */
    SubclassOf: function (className) {
        var currentClazz = this.Class;
        while (currentClazz) {
            if (currentClazz.ClassName === className)
                return true;
            else
                currentClazz = currentClazz.Extends;
        }

        return false;
    }
};

/**
 * 构造类型
 *
 * @param Class clazz 类型
 * @param args 构造参数
 * @returns Object 类型实例
 */
$.CreateClass = function (clazz, args) {
    function F() {
        return clazz.apply(this, args);
    }

    F.prototype = clazz.prototype;

    var f = new F();
    f.constructor = constructor;

    return f;
};

/**
 * 深度克隆对象
 *
 * @param Object src 源对象
 * @returns Object 深度克隆对象
 */
$.CloneObject = function (src) {
    return $.extend2(true, {}, src);
};

/**
 * 创建对象
 *
 * @param XspWeb.Core.Parcel parcel 对象序列化类型
 * @returns Object 控件对象
 */
$.CreateObjectByParcel = function (parcel) {
    var clazz = eval(parcel.Get(parcel.GetPosition()));
    if (!clazz)
        return null;

    if (typeof(clazz.CreateByParcel) !== "undefined") {
        return clazz.CreateByParcel(parcel);
    }
    else if (typeof(clazz.Create) !== "undefined") {
        var object = clazz.Create();
        if (object)
            object.ReadFromParcel(parcel);

        return object;
    }
    else {
        var object = new clazz;
        object.ReadFromParcel(parcel);

        return object;
    }
};

/**
 * 判断对象是否为基础类型派生对象
 *
 * @param object 对象
 * @returns Boolean 是否为基础类型派生对象
 */
$.IsClassObject = function (object) {
    return ((object) && (typeof object.Class !== "undefined"));
};

/**
 * 基于JQuery.extend扩展实现类型函数调用链
 */
jQuery.extend2 = jQuery.fn.extend2 = function () {
    var src, copyIsArray, copy, name, options, clone,
        target = arguments[0] || {},
        i = 1,
        length = arguments.length,
        deep = false;

    // Handle a deep copy situation
    if (typeof target === "boolean") {
        deep = target;
        target = arguments[1] || {};
        // skip the boolean and the target
        i = 2;
    }

    // Handle case when target is a string or something (possible in deep copy)
    if (typeof target !== "object" && !jQuery.isFunction(target)) {
        target = {};
    }

    // extend jQuery itself if only one argument is passed
    if (length === i) {
        target = this;
        --i;
    }

    for (; i < length; i++) {
        // Only deal with non-null/undefined values
        if ((options = arguments[i]) != null) {
            //ALEX[[[
            var isClassObject = (typeof options.Class !== "undefined");
            if (isClassObject)
                target.__proto__ = options.__proto__;
            //]]]ALEX

            // Extend the base object
            for (name in options) {
                src = target[name];
                copy = options[name];

                // Prevent never-ending loop
                if (target === copy) {
                    continue;
                }

                //ALEX[[[
                if (isClassObject && (copy === options.__proto__[name]))
                    continue;
                //]]]ALEX

                // Recurse if we're merging plain objects or arrays
                if (deep && copy && (jQuery.isPlainObject(copy) || (copyIsArray = jQuery.isArray(copy)) )) {
                    if (copyIsArray) {
                        copyIsArray = false;
                        clone = src && jQuery.isArray(src) ? src : [];
                    } else {
                        clone = src && jQuery.isPlainObject(src) ? src : {};
                    }

                    // Never move original objects, clone them
                    target[name] = jQuery.extend2(deep, clone, copy);

                    // Don't bring in undefined values
                } else if (copy !== undefined) {
                    //ALEX[[[
                    // 实现类型函数调用链
                    if (copy
                        && (target[name] !== undefined)
                        && (jQuery.isFunction(target[name]))
                        && (jQuery.isFunction(copy))) {
                        copy.prototype["__parent_func__"] = target[name];
                    }
                    else if (copy && (typeof copy.Class !== "undefined")) {
                        copy = jQuery.extend2(deep, {}, copy);
                    }
                    //]]]ALEX
                    target[name] = copy;
                }
            }
        }
    }

    // Return the modified object
    return target;
};