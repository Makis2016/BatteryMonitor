package com.furongsoft.XspWeb.Utils;

/**
 * 定义字符串工具类型
 * 
 * @author ZGL
 */
public class StringUtils
{
    /**
     * 判断字符串是否为空字符串
     * 
     * @param string
     *            字符串
     * 
     * @return 是否为字符串
     */
    public static boolean isNullOrEmpty(final String string)
    {
        return ((string == null) || (string.length() <= 0));
    }

    /**
     * 获取路径的父路径
     * 
     * @param path
     *            路径
     * 
     * @return 父路径
     */
    public static String getParentPath(final String path)
    {
        int pos = path.lastIndexOf('/');
        if (pos <= 0)
            return "";
        else
            return path.substring(0, pos);
    }
}