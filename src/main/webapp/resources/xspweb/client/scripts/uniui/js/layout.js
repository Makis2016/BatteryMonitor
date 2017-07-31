/**
 * Created by Alex on 2016/1/25.
 */

define(["uniui/ContainerControl", "oniui/layout/avalon.layout"], function () {
    /**
     * Usage:
     *
     * HTML:
     * <div ms-controller="[ID]">
     *     <label ms-html="title">[title]</label>
     *     <select ms-widget="button" value="content" ms-attr-value="content">
     *         <option value="list[i]">list[i]</option>
     *     </select>
     * </div>
     */

    /**
     * 定义Layout控件
     */
    $.declareClass("XspWeb.Controls.Uniui.Layout", XspWeb.Controls.Uniui.ContainerControl, {
        static: {
            /**
             * 创建Layout控件
             *
             * @param {String} id 控件索引
             */
            create: function (id, style) {

                var div = document.createElement("div");
                if (id)
                    div.id = id;

                if (!style) {
                    div.setAttribute("ms-controller", id);
                    div.setAttribute("ms-widget", "layout,$," + id + "_layoutVMOptions");
                }

                var object = new XspWeb.Controls.Uniui.Layout(div);
                if (style)
                    object.setStyle(style);

                return object;
            },

            /**
             * 属性列表
             */
            propertyList: [
                parcelCount = 3,
                {name: "style", key: "style", id: 0},
                {name: "size", key: "size", id: 1},
                {name: "resizable", key: "resizable", id: 2}
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
             *
             */
            this.mStyle = null;

            /**
             *
             */
            this.mSize = null;

            /**
             *
             */
            this.mResizable = false;
        },

        getStyle: function () {
            return this.mStyle;
        },

        setStyle: function (style) {
            this.mStyle = style;
            this.mControl.setAttribute("ms-layout-dock", style);
        },

        getSize: function () {
            return this.mSize;
        },

        setSize: function (size) {
            this.mSize = size;
        },

        getResizable: function () {
            return this.mResizable;
        },

        setResizable: function (resizable) {
            this.mResizable = resizable;
        },

        getLayoutOptions: function () {

            var layoutOptions = {};

            for (var i = 0; i < this.mChilds.length(); ++i) {
                var item = this.mChilds.get(i);
                if ((item.subclassOf) && (item.subclassOf("XspWeb.Controls.Uniui.Layout"))) {
                    layoutOptions[item.getStyle() + "Region"] = {
                        "size": item.getSize(),
                        "resizable": item.getResizable()
                    };
                }
            }

            return layoutOptions;
        },

        /**
         * MVVM绑定
         */
        bind: function () {
            if ((!!this.mControl.attributes["ms-controller"])) {
                this.mViewModel[this.mControl.id + "_layoutVMOptions"] = this.getLayoutOptions();
                this.mViewModel = avalon.define(this.mViewModel);
                avalon.scan(this.mControl, this.mViewModel);
            }
        },

        /**
         * 从对象序列化类型中读取数据
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        readFromParcel: function (parcel) {
            this.parent(parcel);
            this.setStyle(parcel.read());
            this.setSize(parcel.read());
            this.setResizable(parcel.read());
        },

        /**
         * 写入对象序列化类型
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        writeToParcel: function (parcel) {
            this.parent(parcel);
            parcel.write(this.getStyle());
            parcel.write(this.getSize());
            parcel.write(this.getResizable());
        }
    });

    /**
     * 控件标签
     */
    XspWeb.Controls.Tags.add("UNIUI-LAYOUT", XspWeb.Controls.Uniui.Layout);
});