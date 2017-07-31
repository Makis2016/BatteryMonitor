package com.furongsoft.XspWeb.Tags;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

/**
 * Created by Alex on 2016/1/10.
 *
 * @author Alex
 */
public class ResourceFunction
{
    /**
     * 获取资源路径
     *
     * @param url 资源相对路径
     * @return 资源路径
     */
    public static String r(String url)
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String rootPath = (String) request.getAttribute("_RootPath");
        String version = (String) request.getAttribute("_Version");

        return rootPath + "/" + url + "?VERSION=" + version;
    }

    /**
     * 获取视图资源路径
     *
     * @param url 视图资源相对路径
     * @return 视图资源路径
     */
    public static String vr(String url)
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String rootPath = (String) request.getAttribute("_RootPath");
        String filePath = (String) request.getAttribute("_FilePath");
        String version = (String) request.getAttribute("_Version");

        return rootPath + "/views/" + filePath + "/" + url + "?VERSION=" + version;
    }
}