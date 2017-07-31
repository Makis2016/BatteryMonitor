/**
 * Created by Alex on 2015/9/22.
 */
define(["uniui/control", "core/list"], function () {
    /**
     * 定义容器基础控件
     */
    $.declareClass("XspWeb.Controls.Uniui.ContainerControl", XspWeb.Controls.Uniui.Control, {
        static: {
            /**
             * 属性列表
             */
            propertyList: [
                parcelCount = 2,
                {name: "class", key: "theme", id: 0},
                {name: null, key: null, id: 1, defaultValue: 0}
            ]
        },

        /**
         * 构造函数
         *
         * @param {VAR} control 控件索引或DOM节点对象
         */
        ctor: function (control) {
            this.parent(control);

            /**
             * 控件风格
             */
            this.mClass = this.mControl.className;

            /**
             * 内部控件
             */
            this.mChilds = new XspWeb.Core.List();
        },

        /**
         * 清理函数
         */
        dispose: function () {
            this.removeAll();
            this.parent();
        },

        /**
         * 设置控件风格
         *
         * @param {String} clazz 风格
         */
        setClass: function (clazz) {
            if (!clazz)
                return;

            this.mClass = clazz;
            this.mControl.className = clazz;
        },

        /**
         * 添加子控件
         *
         * @param {VAR} control 子控件索引或DOM节点对象或控件对象
         */
        add: function (control) {
            if (typeof(control) === "string") {
                control = $("#" + control)[0];
                if (!control)
                    return;

                if (control.parentNode)
                    control.parentNode.removeChild(control);

                this.mControl.appendChild(control);
            }
            else if (!control.subclassOf) {
                if (control.parentNode)
                    control.parentNode.removeChild(control);

                this.mControl.appendChild(control);
            }
            else {
                control.removeFromParent();
                this.mControl.appendChild(control.mControl);
                this.mChilds.add(control);

                // 双向绑定
                if (!control.mIsInDom) {
                    control.bind();
                    control.mIsInDom = true;
                }
            }
        },

        /**
         * 删除子控件
         *
         * @param {Object} control 子控件
         */
        remove: function (control) {
            if (!control)
                return;

            control.removeFromParent();
            this.mChilds.remove(control);
            control.mIsInDom = false;
        },

        /**
         * 清空所有子控件
         */
        removeAll: function () {
            var list = this.mChilds;
            for (var i = 0; i < list.length(); i++) {
                var object = list.get(i);
                object.dispose();
            }

            this.mChilds.clear();
            this.mControl.innerHTML = "";
        },

        /**
         * 从对象序列化类型中读取数据
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        readFromParcel: function (parcel) {
            this.parent(parcel);
            this.setClass(parcel.read());

            var length = parcel.read();
            for (var i = 0; i < length; i++) {
                var object = $.createObjectByParcel(parcel);
                this.add(object);
            }
        },

        /**
         * 写入对象序列化类型
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        writeToParcel: function (parcel) {
            this.parent(parcel);
            parcel.write(this.mClass);

            var list = this.mChilds;
            parcel.write(list.length());
            for (var i = 0; i < list.length(); i++) {
                var object = list.get(i);
                object.writeToParcel(parcel);
            }
        }
    });
});