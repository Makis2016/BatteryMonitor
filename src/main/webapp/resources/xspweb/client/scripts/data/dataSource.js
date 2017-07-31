/**
 * Created by Alex on 2015/10/6.
 */
(function (window, $, namespace) {
    /**
     * 定义数据源类型
     */
    $.DeclareClass("XspWeb.Data.DataSource", XspWeb.Core.Parcelable, {
        /**
         * 构造函数
         */
        Constructor: function (dataSource) {
            /**
             * 内部数据
             */
            this.mData = dataSource;
        },

        /**
         * 返回元素数量
         *
         * @return Int32 元素数量
         */
        Length: function () {
        },

        /**
         * 加载数据
         *
         * @param Int32 startOffset 加载元素偏移
         * @param Int32 length 元素数量
         * @param Function callback 加载完成事件处理函数
         * @param Object argument 加载完成事件处理函数参数
         * @return Int32 实际加载元素数量
         */
        Load: function (startOffset, length, callback, argument) {
        },

        /**
         * 从对象序列化类型中读取数据
         *
         * @param XspWeb.Core.Parcel parcel 对象序列化类型
         */
        ReadFromParcel: function (parcel) {
            this.Super(parcel);
            this.mData = parcel.Read();
        },

        /**
         * 写入对象序列化类型
         *
         * @param XspWeb.Core.Parcel parcel 对象序列化类型
         */
        WriteToParcel: function (parcel) {
            this.Super(parcel);
            parcel.Write(this.mData);
        }
    });
})(window, jQuery, jQuery.Namespace());