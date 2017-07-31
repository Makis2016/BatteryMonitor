/**
 * Created by Alex on 2016/2/17.
 */
define(["common", "oo", "core/hashTable", "uniui/control"], function () {
    /**
     * 定义页面类型
     */
    $.declareClass("XspWeb.Controls.Uniui.Page", {
        /**
         * 构造函数
         */
        ctor: function () {
            /**
             * 根控件
             */
            this.mRoot = null;

            /**
             * 控件列表
             */
            this.mControls = new XspWeb.Core.HashTable();
        },

        /**
         * 页面启动事件处理函数
         */
        onStart: function () {
            this.initializeComponent();
            this.onResume();
        },

        /**
         * 页面重新启动事件处理函数
         */
        onResume: function () {
        },

        /**
         * 初始化界面组件
         */
        initializeComponent: function () {
            // 寻找自定义标签
            if (typeof(initializeComponent) === "function")
                initializeComponent(this);
        },

        /**
         * 设置界面内容
         *
         * @param {Object} node DOM节点对象
         */
        setContentView: function (node) {
            this.mControls.clear();
            var root = XspWeb.Controls.Uniui.Control.inflate(node, null, this.mControls);
            if (this.mRoot)
                this.mRoot.dispose();

            this.mRoot = root;
            document.body.appendChild(root.getControl());
        },

        /**
         * 设置界面内容
         *
         * @param {Object} node 虚拟DOM节点对象
         */
        setContentViewByVirtualDom: function (node) {
            this.mControls.clear();
            var root = XspWeb.Controls.Uniui.Control.inflateByVirtualDom(node, null, this.mControls);
            if (this.mRoot)
                this.mRoot.dispose();

            this.mRoot = root;
            document.body.appendChild(root.getControl());
        },

        /**
         * 根据指定控件索引获取控件
         *
         * @param id 控件索引
         * @returns Object 控件对象
         */
        findViewById: function (id) {
            return this.mControls.get(id);
        }
    });
});