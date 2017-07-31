/**
 * Created by Alex on 2016/1/25.
 */
define(["common", "oo", "core/hashTable", "core/parcel", "core/parcelable"], function () {
    /**
     * 定义基础控件
     */
    $.declareClass("XspWeb.Controls.Uniui.Control", XspWeb.Core.Parcelable, {
        static: {
            /**
             * 获取控件属性JSON
             *
             * @param {VAR} control 控件索引或DOM节点对象
             * @param {Class} clazz 对象类型
             * @returns {XspWeb.Core.Parcel} 对象序列化类型
             */
            getAttributes: function (control, clazz) {
                control = (typeof(control) === "string") ? $("#" + control)[0] : control;
                var map = control.attributes;
                var parcel = new XspWeb.Core.Parcel();
                var currentClazz = clazz;
                var length = 0;

                // 计算Parcel总长度
                while (currentClazz) {
                    if (currentClazz.propertyList)
                        length += currentClazz.propertyList[0];
                    currentClazz = currentClazz.parents;
                }

                // 清空Parcel内容
                for (var i = 0; i < length; ++i)
                    parcel.set(i, null);

                // 填充Parcel内容
                currentClazz = clazz;
                while (currentClazz) {
                    if (currentClazz.propertyList) {
                        var propertyList = currentClazz.propertyList;
                        length -= propertyList[0];
                        for (var j = 1; j < propertyList.length; ++j) {
                            var property = propertyList[j];
                            var item = map[property.key];
                            if (item)
                                parcel.set(length + property.id, item.value);
                            else if (typeof(property.defaultValue) !== "undefined")
                                parcel.set(length + property.id, property.defaultValue);
                        }
                    }

                    currentClazz = currentClazz.parents;
                }

                // 填写对象类型名称
                parcel.set(0, clazz.className);

                return parcel.reset();
            },

            /**
             * 从标签语言生成控件对象
             *
             * @param {Object} node DOM节点对象
             * @param {Object} parent 父控件
             * @param {XspWeb.Core.HashTable} controls 控件列表
             * @returns Object 控件对象
             */
            inflate: function (node, parent, controls) {
                if (node.nodeName.indexOf("UNIUI-") !== 0)
                    return null;

                // node.parentNode.removeChild(node);
                var clazz = XspWeb.Controls.Tags.get(node.nodeName);
                if (!clazz)
                    return null;

                var parcel = this.getAttributes(node, clazz);
                var object = $.createObjectByParcel(parcel);
                var children = node.childNodes;
                for (var i = 0; i < children.length; ++i) {
                    this.inflate(children.item(i), object, controls);
                }

                object.addToParent(parent);
                if (controls && object.getControl().id)
                    controls.add(object.getControl().id, object);

                return object;
            },

            /**
             * 从标签语言生成虚拟DOM
             *
             * @param {Object} node DOM节点对象
             * @param {Object} parent 父虚拟DOM节点
             * @returns {Object} 虚拟DOM对象
             */
            inflateVirtualDom: function (node, parent) {
                if (node.nodeName.indexOf("UNIUI-") !== 0)
                    return null;

                // node.parentNode.removeChild(node);
                var clazz = XspWeb.Controls.Tags.get(node.nodeName);
                if (!clazz)
                    return null;

                var parcel = this.getAttributes(node, clazz);
                var vdom = {
                    "clazz": clazz,
                    "info": parcel,
                    "children": []
                };

                var children = node.childNodes;
                for (var i = 0; i < children.length; ++i) {
                    this.inflateVirtualDom(children.item(i), vdom);
                }

                if (parent)
                    parent.children.push(vdom);

                return vdom;
            },

            /**
             * 从虚拟DOM生成控件对象
             *
             * @param {Object} node 虚拟DOM节点对象
             * @param {Object} parent 父控件
             * @param {XspWeb.Core.HashTable} controls 控件列表
             * @returns Object 控件对象
             */
            inflateByVirtualDom: function (node, parent, controls) {
                var clazz = node.clazz;
                var object = $.createObjectByParcel(node.info);
                node.info.reset();

                for (var key in node.children) {
                    this.inflateByVirtualDom(node.children[key], object, controls);
                }

                object.addToParent(parent);
                if (controls && object.getControl().id)
                    controls.add(object.getControl().id, object);

                return object;
            },

            /**
             * 属性列表
             */
            propertyList: [
                parcelCount = 2,
                {name: "className", key: "className", id: 0},
                {name: "id", key: "id", id: 1}
            ]
        },

        /**
         * 构造函数
         *
         * @param {VAR} control 控件索引或DOM节点对象
         */
        ctor: function (control) {
            if (!control)
                throw $.aresult.AE_INVALIDARG();

            this.parent();

            /**
             * 是否在DOM树上
             */
            this.mIsInDom = (typeof(control) === "string");

            /**
             * 控件名称
             */
            this.mName = (this.mIsInDom) ? control : control.id;

            /**
             * 控件对象
             */
            this.mControl = (this.mIsInDom) ? $("#" + control)[0] : control;
            this.mControl.style.visibility = "inherit";

            /**
             * 控件模型
             */
            this.mViewModel = {$id: this.mControl.id};
        },

        /**
         * 构造完成处理函数
         */
        onConstructed: function () {
            // 若控件在DOM树上则立即进行双向绑定
            if (this.mIsInDom)
                this.bind();
        },

        /**
         * 清理函数
         */
        dispose: function () {
            this.removeFromParent();
        },

        /**
         * 获取控件名称
         *
         * @returns {String} 控件名称
         */
        getName: function () {
            return this.mName;
        },

        /**
         * 获取控件名称
         *
         * @returns {Object} DOM节点对象
         */
        getControl: function () {
            return this.mControl;
        },

        /**
         * 添加到父控件
         *
         * @param {VAR} parent 父控件索引或DOM节点对象或容器控件对象
         */
        addToParent: function (parent) {
            if (!parent)
                return;

            if (typeof(parent) === "string") {
                parent = $("#" + parent)[0];
                if (!parent)
                    return;

                parent.appendChild(this.mControl);
            }
            else if (!parent.subclassOf) {
                parent.appendChild(this.mControl);
            }
            else if (parent.subclassOf("XspWeb.Controls.Uniui.ContainerControl")) {
                parent.add(this);
                return;
            }
            else {
                return;
            }

            // 双向绑定
            if (!this.mIsInDom) {
                this.bind();
                this.mIsInDom = true;
            }
        },

        /**
         * 从父控件中删除
         */
        removeFromParent: function () {
            if ((this.mControl) && (this.mControl.parentNode))
                this.mControl.parentNode.removeChild(this.mControl);

            this.mIsInDom = false;
        },

        /**
         * 重新布局
         */
        relayout: function () {
        },

        /**
         * MVVM绑定
         */
        bind: function () {
            if ((!!this.mControl.attributes["ms-controller"])) {
                this.mViewModel = avalon.define(this.mViewModel);
                avalon.scan(this.mControl, this.mViewModel);
            }
        },

        /**
         * 获取子DOM节点
         *
         * @param {String} type 子DOM节点类型
         *
         * @returns {VAR} DOM节点对象
         */
        getChildNode: function (type) {
            var children = this.mControl.childNodes;
            for (var i = 0; i < children.length; ++i) {
                if (children[i].nodeName === type)
                    return children[i];
            }

            return null;
        },

        /**
         * 从对象序列化类型中读取数据
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        readFromParcel: function (parcel) {
            this.parent(parcel);
            var id = parcel.read();
            if (id)
                this.mControl.id = id;
        },

        /**
         * 写入对象序列化类型
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        writeToParcel: function (parcel) {
            this.parent(parcel);
            parcel.write(this.mControl.id);
        }
    });

    /**
     * 控件标签
     */
    XspWeb.Controls.Tags = new XspWeb.Core.HashTable();
});