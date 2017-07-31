package com.furongsoft.XspWeb.Utils;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Properties;

import com.furongsoft.XspWeb.Common.Errno.AResult;
import com.furongsoft.XspWeb.Common.Tracker;

/**
 * 杂项函数
 * 
 * @author Alex
 */
public class Misc
{
    /**
     * 字符串URL编码
     * 
     * @param source
     *            原始字符串
     * 
     * @return 经过URL编码后的字符串,失败返回空
     */
    public static String urlEncode(final String source)
    {
        if (StringUtils.isNullOrEmpty(source))
            return null;

        try {
            return URLEncoder.encode(source, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 字符串URL解码
     * 
     * @param source
     *            编码后字符串
     * 
     * @return 经过URL解码后的字符串,失败返回空
     */
    public static String urlDecode(final String source)
    {
        if (StringUtils.isNullOrEmpty(source))
            return null;

        try {
            return URLDecoder.decode(source, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 执行shell命令
     * 
     * @param cmd
     *            命令名称和参数组成的数组,例如：{"/system/bin/cat", "/proc/version"}
     * 
     * @return 是否成功,成功返回S_OK
     */
    public static AResult shellExecute(final String[] cmd)
    {
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

            return AResult.S_OK;
        }
        catch (Exception e) {
            return AResult.E_FAIL;
        }
    }

    /**
     * 读取配置文件
     * 
     * @param fileName
     *            配置文件
     * 
     * @return 配置信息
     */
    public static Properties getProperties(final String fileName)
    {
        FileInputStream is = null;

        try {
            Properties properties = new Properties();
            is = new FileInputStream(fileName);
            properties.load(is);
            is.close();
            is = null;

            return properties;
        }
        catch (Exception e) {
            Tracker.e(e);
            return null;
        }
        finally {
            try {
                if (is != null)
                    is.close();
            }
            catch (Exception e1) {
            }
        }
    }
}