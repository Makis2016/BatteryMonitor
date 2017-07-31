package com.furongsoft.Public.Utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Constant
{
    public static final String addSuccess = "添加成功";
    public static final String addError= "添加失败";
    public static final String deleteSuccess = "删除成功";
    public static final String deleteError = "删除失败";
    public static final String updateSuccess = "修改成功";
    public static final String updateError = "修改失败";
    public static final String noneData = "暂无数据";
    public static final String operationError = "操作失败";

    public static Map<String, String> DOWNLOAD_MIME = new LinkedHashMap<String, String>();
    static {
        DOWNLOAD_MIME.put(".xlsx", "application/vnd.ms-excel.12");
        DOWNLOAD_MIME.put(".zip", "application/zip");
        DOWNLOAD_MIME.put(".csv", "text/comma-separated-values");
    }
}