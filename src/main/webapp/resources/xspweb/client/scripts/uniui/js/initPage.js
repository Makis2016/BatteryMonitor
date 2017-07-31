/**
 * Created by Alex on 2016/2/17.
 */
require.config({
    baseUrl: "../../../../",
    priority: ["text", "css"],
    paths: {
        common: "core/common-0.3",
        oo: "core/oo-0.3",
        core: "core",
        oniui: "thirdparty/oniui",
        uniui: "uniui/js"
    },
    shim: {
        common: {exports: "common"},
        oo: {exports: "oo"}
    }
});

/**
 * 导入组件列表
 *
 * @param {Array} moduleList 组件列表
 * @param {function} callback 组件列表加载完成处理函数
 */
function imports(moduleList, callback) {
    moduleList = moduleList || [];
    if (!moduleList["uniui/page"])
        moduleList.push("uniui/page");

    require(moduleList, function () {
        if (typeof(window.sPage) === "undefined") {
            window.sPage = new XspWeb.Controls.Uniui.Page();
            window.sPage.onStart();
        }

        if (callback)
            callback();
    });
}