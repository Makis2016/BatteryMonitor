/**
 * 创建命名空间和类
 */
$.declareClass = function (name, extend, prototype) {
    if (arguments.length == 2) {
        prototype = extend;
        extend = $.baseClass;
    }
    else if (!extend) {
        extend = $.baseClass;
    }

    prototype = prototype || {};

    // 命名空间
    var parentPackage = window;
    var nameSpace = [];
    var className = "";

    // 创建命名空间
    var createNameSpace = function (str) {
        parentPackage[str] = parentPackage[str] || {};
        nameSpace = parentPackage[str];
        parentPackage = nameSpace;
    };

    var namespaces = name.split(".");
    $.each(namespaces, function (i, str) {
        if (i == (namespaces.length - 1))
            className = str;
        else
            createNameSpace(str);
    });

    // 构造函数
    var func = nameSpace[className] = function () {
        this.clazz = nameSpace[className];
        if (this.ctor)
            this.ctor.apply(this, arguments);
        else
            extend.prototype.ctor.apply(this, arguments);

        this.onConstructed();
    };

    // 继承父类基本属性
    $.extend2(true, func.prototype, extend.prototype);

    // 本身属性及实现
    $.extend2(true, func.prototype, prototype);

    // 静态成员
    if (typeof(prototype.static) === "object")
        $.extend2(true, func, prototype.static);

    // 设置父类原型
    func["className"] = name;
    func["parents"] = extend;
};

/**
 * 定义基础类型
 */
$.baseClass = {};

$.baseClass.prototype = {
    // 父类型
    parents: null,

    /**
     * 构造函数
     */
    ctor: function () {
    },

    /**
     * 构造完成处理函数
     */
    onConstructed: function () {
    },

    /**
     * 清理函数
     */
    dispose: function () {
    },

    /**
     * 调用父类函数
     */
    parent: function () {
        var func = this.parent.caller.prototype["__parent_func__"];
        if (func)
            return func.apply(this, arguments);
    },

    /**
     * 对象是否为指定类型的实例
     *
     * @param String className 指定类型
     * @returns Boolean 是否为指定类型的实例
     */
    instanceOf: function (className) {
        return (this.clazz.ClassName === className);
    },

    /**
     * 对象是否为指定类型的子类型的实例
     *
     * @param String className 指定类型
     * @returns Boolean 是否为指定类型的子类型的实例
     */
    subclassOf: function (className) {
        var currentClazz = this.clazz;
        while (currentClazz) {
            if (currentClazz.className === className)
                return true;
            else
                currentClazz = currentClazz.parents;
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
$.createClass = function (clazz, args) {
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
$.cloneObject = function (src) {
    return $.extend2(true, {}, src);
};

/**
 * 创建对象
 *
 * @param XspWeb.Core.Parcel parcel 对象序列化类型
 * @returns Object 控件对象
 */
$.createObjectByParcel = function (parcel) {
    var clazz = eval(parcel.Get(parcel.getPosition()));
    if (!clazz)
        return null;

    if (typeof(clazz.createByParcel) !== "undefined") {
        return clazz.createByParcel(parcel);
    }
    else if (typeof(clazz.Create) !== "undefined") {
        var object = clazz.create();
        if (object)
            object.readFromParcel(parcel);

        return object;
    }
    else {
        var object = new clazz;
        object.readFromParcel(parcel);

        return object;
    }
};

/**
 * 判断对象是否为基础类型派生对象
 *
 * @param {Object} 对象
 * @returns {Boolean} 是否为基础类型派生对象
 */
$.isClassObject = function (object) {
    return ((object) && (typeof object.clazz !== "undefined"));
};

/**
 * 判断对象是否为类型派生对象
 *
 * @param {Object} 对象
 * @returns {Boolean} 是否为类型派生对象
 */
$.instanceOf = function (object, className) {
    return ($.isClassObject(object) && object.instanceOf(className));
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
            var isClassObject = (typeof options.clazz !== "undefined");
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
                    else if (copy && (typeof copy.clazz !== "undefined")) {
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