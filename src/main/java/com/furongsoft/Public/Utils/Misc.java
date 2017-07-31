package com.furongsoft.Public.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.furongsoft.Public.Model.AResult;
import com.furongsoft.XspWeb.Common.BaseController;
import com.furongsoft.XspWeb.Common.Constants;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.Servlets.XspDispatcherServlet;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Record;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Linyudui on 2016/6/22.
 */
public class Misc
{
    private static final String DefaultConfigUrl = getBasePath() + "/WEB-INF/XspWeb/DefaultConfig.properties";

    // 获取JdbcUrl
    public static String getJdbcUrl()
    {
        Object oUrl = com.furongsoft.XspWeb.Utils.Misc
            .getProperties(DefaultConfigUrl).get("JdbcUrl");
        if (oUrl != null) {
            return oUrl.toString();
        }

        return null;
    }

    // 获取网站绝对路径
    public static String getBasePath()
    {
        return XspDispatcherServlet
            .getXspDispatcherServlet(BaseController.getRequest()).getBasePath();
    }

    // 获取默认配置文件中指定的值
    public static String getDefaultConfigValueByObjName(Object name)
    {
        Object oUrl = com.furongsoft.XspWeb.Utils.Misc
            .getProperties(DefaultConfigUrl).get(name);
        if (oUrl != null) {
            return oUrl.toString();
        }

        return null;
    }

    public static String generatePassword(String userName, String password)
    {
        return (new SimpleHash(
            "MD5", password, Constants.get("AUTH_SALT").toString() + userName,
            2)).toHex();
    }

    public static String convertAResultJson(String message, int code, Object data)
    {
        return JSON.toJSONString(new AResult(message, code, data), SerializerFeature.DisableCircularReferenceDetect);
    }

    // Active 分页数据链表转对象数据链表
    public static <T> List<T> getListTs(Collection<?> collection, Class<T> t)
    {
        try {
            List<T> ts = new ArrayList<T>();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                T obj = t.newInstance();
                Record record = (Record) it.next();
                Set<String> columnNames = record.columnNames();
                Iterator cit = columnNames.iterator();
                while (cit.hasNext()) {
                    String columnName = cit.next().toString();
                    String[] arrstr = columnName.split("_");
                    String setfunName = "set";
                    String getfunName = "get";
                    for (int i = 0; i < arrstr.length; i++) {
                        String name = firstCharCapitalForStr(arrstr[i]);
                        setfunName += name;
                        getfunName += name;
                    }

                    Object value = record.get(columnName);
                    Method method = getMethod(obj, getfunName, null);

                    if (method != null) {
                        Class clazz = method.getReturnType();
                        method = getMethod(obj, setfunName, clazz);
                        if (method != null) {
                            if (value != null)
                                value = ConvertToType(clazz, value);
                            method.invoke(obj, value);
                        }
                    }
                }
                ts.add(obj);
            }
            return ts;
        }
        catch (Exception e) {
            return null;
        }
    }

    private static <T> Method getMethod(T obj, String funName, Class clazz)
    {
        Method method;
        try {
            if (clazz == null) {
                method = obj.getClass().getMethod(funName);
            }
            else {
                method = obj.getClass().getMethod(funName, clazz);
            }

        }
        catch (NoSuchMethodException ex) {
            method = null;
        }
        return method;
    }

    private static Object ConvertToType(Class clazz, Object value)
    {
        if ("string".getClass().equals(clazz)) {
            return value.toString();
        }
        return value;
    }

    // 将字符串首字母转变成大写
    public static String firstCharCapitalForStr(String str)
    {
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        String newStr = String.valueOf(cs);
        return newStr;
    }

    // 读取文件根据行
    public static List<String> readFileByLines(String fileName)
    {
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> stringList = new ArrayList<String>();
        try {
            //以行为单位读取文件内容，一次读一整行;
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
                stringList.add(tempString);
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e1) {
                }
            }
        }
        return stringList;
    }

    // 解析上传文件成字符串
    public static String uploadFileToLineStr(HttpServletRequest request)
    {
        try {
            // 判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return null;
            }

            //使用Apache文件上传组件处理文件上传步骤：
            // 创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 使用ServletFileUpload解析器解析上传数据，
            // 解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            // 解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            List<FileItem> list = upload.parseRequest(request);

            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                if (!item.isFormField()) {
                    //获取item中的上传文件的输入流
                    InputStream is = item.getInputStream();
                    String str = convertStreamToString(is);
                    System.out.println(str);

                    //关闭输入流
                    if (is != null) {
                        is.close();
                    }
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    return str;
                }
            }
        }
        catch (Exception e) {
            Tracker.e(e);
        }
        return null;
    }

    // 上传文件
    public static String uploadFile(HttpServletRequest request, String folderName)
    {
        // 得到上传文件的保存目录，将上传的文件存放于upload目录下，
        // 不允许外界直接访问，保证上传文件的安全
        String savePath = Misc.getBasePath() + folderName;
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return null;
            }

            String filename = null;
            //4、使用ServletFileUpload解析器解析上传数据，
            // 解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的不是普通输入项的数据
                if (!item.isFormField()) {
                    //如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    filename = item.getName();
                    System.out.println(filename);
                    if (filename == null || filename.trim().equals("")) {
                        continue;
                    }
                    // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，
                    // 如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);

                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((len = in.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }

                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                }

            }
            return filename;
        }
        catch (Exception e) {
            Tracker.e(e);
            return null;
        }
    }

    // 解析上传文件成Byte链表
    public static List<Byte> uploadFileToByteList(HttpServletRequest request)
    {
        List<Byte> bytes = null;
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            // 不允许外界直接访问，保证上传文件的安全
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return bytes;
            }
            //4、使用ServletFileUpload解析器解析上传数据，
            // 解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的不是普通输入项的数据
                if (!item.isFormField()) {
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    /*FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);*/
                    //创建一个缓冲区
                    byte buffer[] = new byte[1];
                    /*//判断输入流中的数据是否已经读完的标识
                    int len = 0;*/

                    bytes = new ArrayList();
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while (in.read(buffer) > 0) {
                        bytes.add(buffer[0]);
                        /*//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);*/
                    }

                    //关闭输入流
                    in.close();
                    //关闭输出流
                   /* out.close();*/
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                }
            }
            return bytes;
        }
        catch (Exception e) {
            Tracker.e(e);
            return bytes;
        }
    }

    public static String wirteToFile(List<String> list, String fileName)
    {
        String path = Misc.getBasePath() + "upload\\" + fileName + "_" + new Date().getTime() + ".csv";
        BufferedWriter writer = null;
        try {
            if (list != null && list.size() > 0) {
                File file = new File(path);
                file.delete();
                file.createNewFile();
                writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "UTF-8"));
                for (int i = 0; i < list.size(); i++) {
                    String content = list.get(i);
                    writer.write(content);
                    if (i < list.size() - 1) {
                        writer.newLine();
                    }
                }
                writer.close();
            }

        }
        catch (Exception e) {
            Tracker.e(e);
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (Exception e) {
                    Tracker.e(e);
                }

            }
        }


        return path;
    }

    // 将输入流转成字符串，每行用"\n"隔开
    private static String convertStreamToString(InputStream is)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 下载文件
     *
     * @param fileFullName 文件完整路径名称
     * @param fileName     下载显示文件名称
     * @param httpRequest  HttpServletRequest
     * @param httpResponse HttpServletResponse
     */
    public static void DownLoad(
        String fileFullName,
        String fileName,
        HttpServletRequest httpRequest,
        HttpServletResponse httpResponse)
    {
        try {
            fileName = EncodeFileName(httpRequest, fileName);
            String prefix = fileFullName.substring(fileFullName
                .lastIndexOf("."));

            boolean isSupportedMime = false;
            for (Map.Entry<String, String> mimeType : Constant.DOWNLOAD_MIME
                .entrySet()) {
                if (prefix.equals(mimeType.getKey())) {
                    httpResponse.setContentType(mimeType.getValue());
                    httpResponse.setHeader(
                        "content-disposition",
                        "attachment;filename=" + fileName + mimeType.getKey());

                    OutputStream out = httpResponse.getOutputStream();
                    InputStream in = new FileInputStream(fileFullName);
                    byte[] chunk = new byte[1024];
                    int count;
                    while ((count = in.read(chunk)) >= 0) {
                        out.write(chunk, 0, count);
                    }

                    in.close();
                    out.flush();
                    out.close();

                    isSupportedMime = true;
                    break;
                }
            }

            if (!isSupportedMime) {
                Tracker.i("MIME类型(" + prefix + ")不支持!");
            }
        }
        catch (IOException e) {
            Tracker.e(e);
        }
    }

    /**
     * 根据浏览器类型对下载的文件名进行不同的编码
     *
     * @param httpRequest HttpServletRequest
     * @param fileName    需要编码的文件名
     * @return 编码后的文件名, 编码失败则返回编码前的文件名
     */
    public static String EncodeFileName(
        HttpServletRequest httpRequest,
        String fileName)
    {
        String Agent = httpRequest.getHeader("User-Agent");
        if (null != Agent) {
            try {
                Agent = Agent.toLowerCase();
                if (Agent.indexOf("firefox") != -1 || Agent.indexOf("chrome") != -1) {
                    fileName = new String(fileName.getBytes(), "ISO8859-1");
                }
                else {
                    fileName = com.furongsoft.XspWeb.Utils.Misc.urlEncode(fileName);
                }
            }
            catch (Exception e) {
                Tracker.e(e);
            }
        }

        return fileName;
    }
}