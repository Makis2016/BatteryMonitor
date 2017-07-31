package com.furongsoft.XspWeb.Servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.furongsoft.XspWeb.Common.Errno;
import com.furongsoft.XspWeb.Common.Errno.AResult;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.Utils.FileScanner;
import com.furongsoft.XspWeb.Utils.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 定义XSP分发器类型
 *
 * @author Alex
 */
public class XspDispatcherServlet extends DispatcherServlet
{
    private static final long serialVersionUID = -7372602775168351486L;

    /**
     * XSP分发器键
     */
    public static final String XSPDISPATCHER_NAME = "XspDispatcherServlet";

    /**
     * 网站根目录
     */
    private String mBasePath;

    /**
     * XSP文件存放目录
     */
    private String mXspPath = "Views";

    /**
     * 网站相对目录
     */
    private String mContextPath;

    /**
     * 网站名称
     */
    private String mTitle = "未命名网站";

    /**
     * 网站风格
     */
    private String mTheme = "Default";

    /**
     * 网站语言
     */
    private String mLanguage = "zh_CN";

    /**
     * 网站版本
     */
    private String mVersion = "0";

    /**
     * 映射目录
     */
    private String mMappingPath = "";

    /**
     * 模板配置
     */
    private Configuration mConfiguration = new Configuration();

    /**
     * 获取XSP分发器
     *
     * @param request HTTP请求
     * @return XSP分发器
     */
    public static XspDispatcherServlet getXspDispatcherServlet(
            HttpServletRequest request)
    {
        return (XspDispatcherServlet) request.getAttribute(XSPDISPATCHER_NAME);
    }

    @Override
    protected void initStrategies(ApplicationContext context)
    {
        super.initStrategies(context);

        if (Errno.FAILED(applicationRestart())) {
            Tracker.e("ApplicationRestart failed!");
        }
    }

    @Override
    protected void doDispatch(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        request.setAttribute(XSPDISPATCHER_NAME, this);

        super.doDispatch(request, response);
    }

    @Override
    protected void render(
            ModelAndView mv,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        // 过滤跳转请求和非XSP文件请求
        if (mv.getViewName().startsWith("redirect:") || (!mv
                .getViewName().toLowerCase().endsWith(".xsp"))) {
            super.render(makeDefaultArguments(mv), request, response);
            return;
        }

        // 检查XSP文件是否有更新并生成XSPT
        String fileName = mBasePath + mv.getViewName();
        String newFileName = fileName + ".jsp";

        try {
            // 处理XSP文件更新
            File file1 = new File(fileName);
            File file2 = new File(newFileName);

            if ((!file2.exists()) || (file1.lastModified() > file2
                    .lastModified())) {
                processXspFile(mConfiguration, file1);
            }
            else {
                // 处理模板文件更新
                String layout = getLayoutFileName(file1);
                if (!StringUtils.isNullOrEmpty(layout)) {
                    File file3 = new File(mBasePath + layout);
                    if (file3.exists() && (file3.lastModified() > file2
                            .lastModified())) {
                        processXspFile(mConfiguration, file1);
                    }
                }
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }

        super.render(makeDefaultArguments(mv), request, response);
    }

    /**
     * @return 获取网站部署目录物理路径
     */
    public String getBasePath()
    {
        return mBasePath;
    }

    /**
     * @return XSP文件存放目录
     */
    public String getXspPath()
    {
        return mXspPath;
    }

    /**
     * @return 网站根目录
     */
    public String getContextPath()
    {
        return mContextPath;
    }

    /**
     * @return 获取网站名称
     */
    public String getTitle()
    {
        return mTitle;
    }

    /**
     * @return 获取网站风格
     */
    public String getTheme()
    {
        return mTheme;
    }

    /**
     * @return 获取网站语言
     */
    public String getLanguage()
    {
        return mLanguage;
    }

    /**
     * @return 获取网站版本
     */
    public String getVersion()
    {
        return mVersion;
    }

    /**
     * @return 获取映射目录
     */
    public String getMappingPath()
    {
        return (mMappingPath != null) ? mMappingPath : "";
    }

    /**
     * 网站应用启动函数
     */
    protected AResult applicationRestart()
    {
        Tracker.i("Application Restart");

        // 获取配置
        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();

        // 读取配置信息
        if (config != null) {
            mXspPath = config.getInitParameter("XSPPath");
            mTitle = config.getInitParameter("Title");
            mTheme = config.getInitParameter("Theme");
            mLanguage = config.getInitParameter("Language");
            mVersion = config.getInitParameter("Version");
            mMappingPath = config.getInitParameter("MappingPath");
            mTheme += "_" + mLanguage;
        }

        // 获取网站根目录
        mBasePath = context.getRealPath("/");

        // 获取网站相对目录
        mContextPath = context.getContextPath();

        // 生成模板配置
        try {
            mConfiguration = new Configuration();
            mConfiguration.setDirectoryForTemplateLoading(new File(mBasePath));
            mConfiguration.setObjectWrapper(new DefaultObjectWrapper());
            mConfiguration.setDefaultEncoding("UTF-8");
        }
        catch (Exception e) {
            return AResult.E_FAIL;
        }

        // 处理XSP文件,生成XSPT中间文件
        // return ProcessAllXspFiles();

        return AResult.S_OK;
    }

    /**
     * 扫描XSP文件存放目录下所有XSP文件并生成XSPT文件
     *
     * @return 是否成功, 成功返回S_OK
     */
    protected AResult processAllXspFiles()
    {
        try {
            File xspPath = new File(mBasePath + mXspPath);

            // 扫描XSP文件存放目录下所有XSP文件并生存XSPT文件
            List<File> files = FileScanner.scanFiles(xspPath);
            for (File file : files) {
                if (!file.getName().toLowerCase().endsWith(".xsp")) {
                    continue;
                }

                processXspFile(mConfiguration, file);
            }

            return AResult.S_OK;
        }
        catch (Exception e) {
            return AResult.E_FAIL;
        }
    }

    /**
     * 解析XSP文件并生成XSPT文件
     *
     * @param configuration 模板配置
     * @param file          XSP文件
     * @return 是否成功, 成功返回S_OK
     */
    protected AResult processXspFile(Configuration configuration, File file)
    {
        // 生成XSPT文件名
        String tempFileName = file.getAbsolutePath().substring(
                mBasePath.length());
        String newFileName = file.getAbsolutePath() + ".jsp";

        try {
            // 尝试获取自定义模板文件名
            String layout = getLayoutFileName(file);
            if (layout == null) {
                // 生成XSPT文件
                Template template = configuration.getTemplate(tempFileName);
                Map<String, Object> map = new HashMap<String, Object>();
                makeDefaultArguments(map, file);
                Writer writer = new OutputStreamWriter(new FileOutputStream(
                        newFileName), "UTF-8");
                template.process(map, writer);
            }
            else {
                // 使用自定义模板生成XSPT文件
                Template template = configuration.getTemplate(layout);
                Map<String, Object> map = new HashMap<String, Object>();
                makeDefaultArguments(map, file);
                map.put("Content", "/" + tempFileName);
                Writer writer = new OutputStreamWriter(new FileOutputStream(
                        newFileName), "UTF-8");
                template.process(map, writer);
            }

            return AResult.S_OK;
        }
        catch (Exception e) {
            Tracker.e(e);
            return AResult.E_FAIL;
        }
    }

    /**
     * 获取自定义模板文件名 e.g.: <!-- layout="/Views/Layout/MainLayout.ftl" -->
     *
     * @param xspFile XSP文件名
     * @return 自定义模板文件名, 若不存在则返回空
     * @throws Exception 文件未找到或其他异常
     */
    protected String getLayoutFileName(File xspFile) throws Exception
    {
        FileReader reader = new FileReader(xspFile);
        BufferedReader br = new BufferedReader(reader);

        String str = null;
        String result = null;

        // 解析首行是否含有layout标签
        while ((str = br.readLine()) != null) {
            String str1 = str.toLowerCase();

            // 绕过BOM头部对标签的影响,不检测"<!"
            int pos = str1.indexOf("-- layout=\"");
            if (pos < 0) {
                break;
            }

            int pos2 = str1.indexOf('\"', pos + 11);
            if (pos2 < 0) {
                break;
            }

            result = str.substring(pos + 11, pos2);
            break;
        }

        br.close();
        reader.close();

        return result;
    }

    /**
     * 生成默认参数
     *
     * @param mv ModelAndView对象
     * @return ModelAndView对象
     */
    protected ModelAndView makeDefaultArguments(ModelAndView mv)
    {
        mv.addObject("_RootPath", mContextPath);
        mv.addObject("_Title", mTitle);
        mv.addObject("_Theme", mTheme);
        mv.addObject("_Language", mLanguage);
        mv.addObject("_Version", mVersion);
        mv.addObject("_FilePath", StringUtils.getParentPath(mv.getViewName()));

        return mv;
    }

    /**
     * 生成默认参数
     *
     * @param map  参数列表
     * @param file XSP文件
     */
    protected void makeDefaultArguments(Map<String, Object> map, File file)
    {
        map.put("_RootPath", mContextPath);
        map.put("_Title", mTitle);
        map.put("_Theme", mTheme);
        map.put("_Language", mLanguage);
        map.put("_Version", mVersion);

        String pagePath = mContextPath + "/" + file.getParent().substring(
                mBasePath.length());
        pagePath = pagePath.replace('\\', '/');
        map.put("_PagePath", pagePath);
    }
}