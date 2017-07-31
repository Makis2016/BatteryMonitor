/**
 * Created by wellen on 2015/9/2.
 */
(function (window, $, namespace) {
    /**
     * 定义可序列化类型
     */
    $.DeclareClass("XspWeb.Core.Parcelable", {
        /**
         * 从对象序列化类型中读取数据
         *
         * @param XspWeb.Core.Parcel parcel 对象序列化类型
         */
        ReadFromParcel: function (parcel) {
            parcel.Read();
        },

        /**
         * 写入对象序列化类型
         *
         * @param XspWeb.Core.Parcel parcel 对象序列化类型
         */
        WriteToParcel: function (parcel) {
            parcel.Write(this.Class.ClassName);
        }
    });
})(window, jQuery, jQuery.Namespace());