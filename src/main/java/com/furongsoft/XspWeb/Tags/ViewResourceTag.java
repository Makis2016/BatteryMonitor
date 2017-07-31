package com.furongsoft.XspWeb.Tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * 定义视图资源标签类型
 * 
 * @author Alex
 */
public class ViewResourceTag extends RequestContextAwareTag
{
    private static final long serialVersionUID = -6351425333272228853L;

    private String url;

    @Override
    protected int doStartTagInternal() throws JspException
    {
        try {
            HttpServletRequest request = (HttpServletRequest) this.pageContext
                .getRequest();

            String rootPath = (String) request.getAttribute("_RootPath");
            String filePath = (String) request.getAttribute("_FilePath");
            String version = (String) request.getAttribute("_Version");

            JspWriter out = pageContext.getOut();
            out
                .write(rootPath + "/views/" + filePath + "/" + url + "?VERSION=" + version);
        }
        catch (Exception e) {
        }

        return 0;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}