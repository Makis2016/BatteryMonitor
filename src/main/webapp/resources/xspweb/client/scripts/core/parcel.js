/**
 * Created by wellen on 2015/9/3.
 */
(function (window, $, namespace) {
    /**
     * 对象序列化类型
     */
    $.DeclareClass("XspWeb.Core.Parcel", {
        /**
         * 构造函数
         *
         * @param VAR stream 数组对象或字符串或空
         */
        Constructor: function (stream) {
            /**
             * 数组数据
             */
            this.mStream = ((typeof(stream) === "string") ? $.parseJSON(stream) : stream) || [];

            /**
             * 数据长度
             */
            this.mLength = this.mStream.length;

            /**
             * 当前读写位置
             */
            this.mPosition = 0;
        },

        /**
         * 重置当前读写位置
         *
         * @returns XspWeb.Core.Parcel 对象序列化类型
         */
        Reset: function () {
            this.mPosition = 0;
            return this;
        },

        /**
         * 获取当前读写位置
         *
         * @returns Int64 当前读写位置
         */
        GetPosition: function () {
            return this.mPosition;
        },

        /**
         * 设置当前读写位置
         *
         * @param Int64 position 当前读写位置
         */
        Seek: function (position) {
            this.mPosition = position;
        },

        /**
         * 获取内部数据
         *
         * @returns Array 内部数据
         */
        GetPayload: function () {
            return this.mStream;
        },

        /**
         * 获取数据长度
         *
         * @returns Int64 数据长度
         */
        GetLength: function () {
            return this.mLength;
        },

        /**
         * 获取指定位置数据
         *
         * @param Int64 position 读写位置
         * @returns Object 数据
         */
        Get: function (position) {
            if (position < this.mLength)
                return this.mStream[position];
            else
                return null;
        },

        /**
         * 设置指定位置数据
         *
         * @param Int64 position 读写位置
         * @param Object object 数据
         */
        Set: function (position, object) {
            this.mStream[position] = object;
            if (position >= this.mLength)
                this.mLength = position + 1;
        },

        /**
         * 读取数据
         *
         * @returns Object 数据
         */
        Read: function () {
            if (this.mPosition < this.mLength)
                return this.mStream[this.mPosition++];
            else
                return null;
        },

        /**
         * 写入数据
         *
         * @param Object object 数据
         */
        Write: function (object) {
            this.mStream[this.mPosition++] = object;
            this.mLength++;
        }
    });
})(window, jQuery, jQuery.Namespace());