package com.furongsoft.XspWeb.Utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义文件扫描器类型
 * 
 * @author Alex
 */
public class FileScanner
{
    /**
     * 获取指定目录下所有文件
     * 
     * @param root
     *            根目录
     * 
     * @return 指定目录下所有文件列表
     * 
     * @throws Exception
     *             内存不足
     */
    public static List<File> scanFiles(File root) throws Exception
    {
        List<File> fileInfo = new ArrayList<File>();

        File[] files = root.listFiles(new FileFilter() {
            public boolean accept(File pathname)
            {
                if (pathname.isDirectory() && pathname.isHidden())
                    return false;
                else if (pathname.isFile() && pathname.isHidden())
                    return false;
                else
                    return true;
            }
        });

        for (File file : files) {
            if (file.isDirectory()) {
                List<File> ff = scanFiles(file);
                fileInfo.addAll(ff);
            }
            else {
                fileInfo.add(file);
            }
        }

        return fileInfo;
    }
}