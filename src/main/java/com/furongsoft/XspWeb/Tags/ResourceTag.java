package com.furongsoft.XspWeb.Tags;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * 定义资源标签类型
 *
 * @author Alex
 */
public class ResourceTag extends RequestContextAwareTag
{
    private static final long serialVersionUID = 8481292069765315283L;

    private String url;

    @Override
    protected int doStartTagInternal() throws JspException
    {
        try {
            HttpServletRequest request = (HttpServletRequest) this.pageContext
                .getRequest();

            String rootPath = (String) request.getAttribute("_RootPath");
            String version = (String) request.getAttribute("_Version");

            JspWriter out = pageContext.getOut();
            out.write(rootPath + "/" + url + "?VERSION=" + version);
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