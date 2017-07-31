package com.furongsoft.XspWeb.Common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.furongsoft.XspWeb.Common.Errno.AResult;
import com.furongsoft.XspWeb.Servlets.XspDispatcherServlet;

/**
 * 定义基础控制器类型
 * 
 * @author Alex
 */
public class BaseController extends BaseBean
{
    /**
     * @return 获取网站部署目录物理路径
     */
    public String getBasePath()
    {
        return getXspDispatcherServlet().getBasePath();
    }

    /**
     * @return 网站根目录
     */
    public String getContextPath()
    {
        return getXspDispatcherServlet().getContextPath();
    }

    /**
     * 获取请求对象
     * 
     * @return 请求对象
     */
    public static HttpServletRequest getRequest()
    {
        return ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getRequest();
    }

    /**
     * 获取响应对象
     * 
     * @return 响应对象
     */
    public static HttpServletResponse getResponse()
    {
        return ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getResponse();
    }

    /**
     * 创建视图
     * 
     * @param url
     *            视图URL
     * 
     * @return 视图,失败返回空
     */
    public ModelAndView makeModelAndView(final String url)
    {
        try {
            XspDispatcherServlet xds = getXspDispatcherServlet();
            ModelAndView mv = new ModelAndView(xds.getMappingPath() + url);

            return mv;
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 创建重定向视图
     * 
     * @param url
     *            视图URL
     * 
     * @return 视图,失败返回空
     */
    public ModelAndView makeForwardView(final String url)
    {
        try {
            return new ModelAndView(
                "forward:" + getXspDispatcherServlet().getMappingPath() + url);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 创建重定向视图
     * 
     * @param mappingPath
     *            映射目录
     * @param url
     *            视图URL
     * 
     * @return 视图,失败返回空
     */
    public
        ModelAndView makeForwardView(final String mappingPath, final String url)
    {
        try {
            if (mappingPath == null)
                return new ModelAndView("forward:" + url);
            else
                return new ModelAndView("forward:" + mappingPath + url);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 创建重定向视图
     * 
     * @param url
     *            视图URL
     * 
     * @return 视图,失败返回空
     */
    public ModelAndView makeRedirectView(final String url)
    {
        try {
            return new ModelAndView(
                "redirect:" + getXspDispatcherServlet().getMappingPath() + url);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 创建错误提示视图
     * 
     * @param message
     *            错误提示
     * 
     * @return 视图,失败返回空
     */
    public ModelAndView makeErrorView(final String message)
    {
        try {
            ModelAndView mv = new ModelAndView("/views/shared/error.xsp");
            mv.addObject("Message", message);

            return mv;
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取当前会话中属性
     * 
     * @param attributeName
     *            属性名称
     * 
     * @return 属性内容,失败返回空
     */
    public Object getSessionAttribute(final String attributeName)
    {
        if (RequestContextHolder.getRequestAttributes() == null)
            return null;

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
            .currentRequestAttributes();
        if (attr == null)
            return null;

        HttpSession session = attr.getRequest().getSession();
        if (session == null)
            return null;

        return session.getAttribute(attributeName);
    }

    /**
     * 设置当前会话中属性
     * 
     * @param attributeName
     *            属性名称
     * @param value
     *            属性内容
     * 
     * @return 是否成功,成功返回S_OK
     */
    public AResult setSessionAttribute(
        final String attributeName,
        final Object value)
    {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
            .currentRequestAttributes();
        if (attr == null)
            return AResult.E_FAIL;

        HttpSession session = attr.getRequest().getSession();
        if (session == null)
            return AResult.E_FAIL;

        session.setAttribute(attributeName, value);

        return AResult.S_OK;
    }

    /**
     * 回应前端JSON内容
     * 
     * @param data
     *            响应内容
     */
    public void responseJson(final String data)
    {
        HttpServletResponse response = getResponse();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter out = response.getWriter();
            out.write(data);
        }
        catch (IOException e) {
            Tracker.e(e);
        }
    }

    /**
     * 回应前端HTML内容
     * 
     * @param data
     *            响应内容
     */
    public void responseHtml(final String data)
    {
        HttpServletResponse response = getResponse();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter out = response.getWriter();
            out.write(data);
        }
        catch (IOException e) {
            Tracker.e(e);
        }
    }

    /**
     * 回应前端图片内容
     * 
     * @param data
     *            响应图片内容
     */
    public void responseImage(final byte[] data)
    {
        HttpServletResponse response = getResponse();
        response.setContentType("image/jpeg");

        try {
            response.getOutputStream().write(data);
        }
        catch (IOException e) {
            Tracker.e(e);
        }
    }

    /**
     * @return 获取XSP分发器
     */
    protected XspDispatcherServlet getXspDispatcherServlet()
    {
        return XspDispatcherServlet.getXspDispatcherServlet(getRequest());
    }
}