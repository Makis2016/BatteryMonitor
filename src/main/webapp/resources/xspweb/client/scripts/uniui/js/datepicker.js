/**
 * Created by Alex on 2016/1/25.
 */
define(["uniui/commonControl", "oniui/datepicker/avalon.datepicker"], function () {
    /**
     * Usage:
     *
     * HTML:
     * <div ms-controller="[ID]">
     *     <label ms-html="title"></label>
     *     <input ms-widget="datepicker" value="content" />
     * </div>
     */

    /**
     * 定义日期选择控件
     */
    $.declareClass("XspWeb.Controls.Uniui.DatePicker", XspWeb.Controls.Uniui.CommonControl, {
        static: {
            /**
             * 创建日期选择控件
             *
             * @param {String} id 控件索引
             * @param {String} content 控件内容
             * @param {String} title 标题内容
             * @returns {XspWeb.Controls.Uniui.DatePicker} 日期选择控件对象
             */
            create: function (id, title, content) {
                var div = document.createElement("div");
                if (id)
                    div.id = id;
                div.style.display = "inline";
                div.setAttribute("ms-controller", id);

                var label = document.createElement("label");
                label.setAttribute("ms-html", "title");
                div.appendChild(label);

                var datepicker = document.createElement("input");
                datepicker.setAttribute("ms-widget", "datepicker");
                datepicker.setAttribute("ms-duplex", "content");
                datepicker.setAttribute("data-datepicker-allow-blank", (content === "")? "true": "false"); // 默认输入框内容为当前时间,为true时允许输入框为空
                div.appendChild(datepicker);

                var object = new XspWeb.Controls.Uniui.DatePicker(div);
                object.setTitle(title);
                object.setContent(content);

                return object;
            },

            /**
             * 属性列表
             */
            propertyList: [
                parcelCount = 2,
                {name: "title", key: "title", id: 0},
                {name: "content", key: "content", id: 1}
            ]
        },

        /**
         * 获取控件标题内容
         *
         * @returns {String} 控件标题内容
         */
        getTitle: function () {
            return this.mViewModel.title;
        },

        /**
         * 设置控件标题内容
         *
         * @param {String} title 控件标题内容
         */
        setTitle: function (title) {
            this.mViewModel.title = title;
        },

        /**
         * 获取控件内容
         *
         * @returns {String} 控件内容
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
         * 验证输入内容是否匹配过滤器
         *
         * @returns {Boolean} 输入内容是否匹配过滤器
         */
        verify: function () {
            var reg = /^(\d{4})-(\d{2})-(\d{2})$/;
            return (reg.test(this.mViewModel.content));
        },

        /**
         * 从对象序列化类型中读取数据
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        readFromParcel: function (parcel) {
            this.parent(parcel);
            this.setTitle(parcel.read());
            this.setContent(parcel.read());
        },

        /**
         * 写入对象序列化类型
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        writeToParcel: function (parcel) {
            this.parent(parcel);
            parcel.write(this.getTitle());
            parcel.write(this.getContent());
        }
    });

    /**
     * 控件标签
     */
    XspWeb.Controls.Tags.add("UNIUI-DATEPICKER", XspWeb.Controls.Uniui.DatePicker);
});