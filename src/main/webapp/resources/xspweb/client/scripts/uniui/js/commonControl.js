/**
 * Created by Alex on 2015/9/15.
 */
define(["uniui/control"], function () {
    /**
     * 定义通用基础控件
     */
    $.declareClass("XspWeb.Controls.Uniui.CommonControl", XspWeb.Controls.Uniui.Control, {
        static: {
            /**
             * 属性列表
             */
            propertyList: [
                parcelCount = 5,
                {name: "x", key: "x", id: 0},
                {name: "y", key: "y", id: 1},
                {name: "width", key: "width", id: 2},
                {name: "height", key: "height", id: 3},
                {name: "class", key: "theme", id: 4}
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
             * 控件X轴坐标
             */
            this.mX = this.mControl.style.left;

            /**
             * 控件Y轴坐标
             */
            this.mY = this.mControl.style.top;

            /**
             * 控件宽度
             */
            this.mWidth = this.mControl.style.width;

            /**
             * 控件高度
             */
            this.mHeight = this.mControl.style.height;

            /**
             * 控件风格
             */
            this.mClass = this.mControl.className;

            /**
             * 控件内容
             */
            this.mContent = null;
            this.mViewModel.content = null;
        },

        /**
         * 设置控件X轴坐标
         *
         * @param {Double} x X轴坐标
         */
        setX: function (x) {
            this.mX = x;
            this.mControl.style.left = x;
        },

        /**
         * 设置控件Y轴坐标
         *
         * @param {Double} y Y轴坐标
         */
        setY: function (y) {
            this.mY = y;
            this.mControl.style.top = y;
        },

        /**
         * 设置控件宽度
         *
         * @param {Double} width 宽度
         */
        setWidth: function (width) {
            this.mWidth = width;
            this.mControl.style.width = width;
        },

        /**
         * 设置控件高度
         *
         * @param {Double} height 高度
         */
        setHeight: function (height) {
            this.mHeight = height;
            this.mControl.style.height = height;
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
         * 从对象序列化类型中读取数据
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        readFromParcel: function (parcel) {
            this.parent(parcel);
            this.setX(parcel.read());
            this.setY(parcel.read());
            this.setWidth(parcel.read());
            this.setHeight(parcel.read());
            this.setClass(parcel.read());
        },

        /**
         * 写入对象序列化类型
         *
         * @param {XspWeb.Core.Parcel} parcel 对象序列化类型
         */
        writeToParcel: function (parcel) {
            this.parent(parcel);
            parcel.write(this.mX);
            parcel.write(this.mY);
            parcel.write(this.mWidth);
            parcel.write(this.mHeight);
            parcel.write(this.mClass);
        }
    });
});