/**
 * Created by Alex on 2016/1/25.
 */
define(["uniui/commonControl", "oniui/button/avalon.button"], function () {
    /**
     * Usage:
     *
     * HTML:
     * <div id="[ID]" class="uniui uniui-button">
     *     <input value="content" />
     * </div>
     */

    /**
     * 定义按钮控件
     */
    $.declareClass("XspWeb.Controls.Uniui.Button", XspWeb.Controls.Uniui.CommonControl, {
        static: {
            /**
             * 创建按钮控件
             *
             * @param {String} id 控件索引
             * @param {String} content 控件内容
             * @returns {XspWeb.Controls.Uniui.Button} 按钮控件对象
             */
            create: function (id, content) {
                var div = document.createElement("div");
                if (id)
                    div.id = id;

                var button = document.createElement("input");
                button.setAttribute("value", content);
                div.appendChild(button);

                return new XspWeb.Controls.Uniui.Button(div);
            },

            /**
             * 属性列表
             */
            propertyList: [
                parcelCount = 2,
                {name: "content", key: "content", id: 0},
                {name: "onClickHandler", key: "onClickHandler", id: 1}
            ]
        },

        /**
         * 构造函数
         *
         * @param {VAR} control 控件索引或DOM节点对象
         */
        ctor: function (control) {

            this.parent(control);

            // 初始化控件
            this.mControl.setAttribute("ms-controller", this.mControl.id);
            var button = this.getChildNode("INPUT");
            button.setAttribute("ms-widget", "button");
            button.setAttribute("ms-attr-value", "content");
            button.setAttribute("ms-click", "click");
            this.setContent(button.value);
            this.setOnClickHandler(null);
        },

        /**
         * 获取控件内容
         *
         * @returns String 控件内容
         */
        getContent: function () {
            return this.mViewModel.content;
        },

        /**
         * 设置控件内容
         *
         * @param {String} content 控件内容
         */
        setContent: function (content) {
            this.mViewModel.content = content;
        },

        /**
         * 获取控件点击处理函数
         *
         * @returns {Function} 控件点击处理函数
         */
        getOnClickHandler: function () {
            return this.mViewModel.click;
        },

        /**
         * 设置控件内容
         *
         * @param {Function} onClickHandler 控件点击处理函数
         */
        setOnClickHandler: function (onClickHandler) {
            this.mViewModel.click = onClickHandler;
        },

        /**
         * 从对象序列化类型中读取数据
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        readFromParcel: function (parcel) {
            this.parent(parcel);
            this.setContent(parcel.read());
            this.setOnClickHandler(parcel.read());
        },

        /**
         * 写入对象序列化类型
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        writeToParcel: function (parcel) {
            this.parent(parcel);
            parcel.write(this.getContent());
            parcel.write(this.getOnClickHandler());
        }
    });

    /**
     * 控件标签
     */
    XspWeb.Controls.Tags.add("UNIUI-BUTTON", XspWeb.Controls.Uniui.Button);
});