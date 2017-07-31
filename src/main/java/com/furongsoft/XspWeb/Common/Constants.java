package com.furongsoft.XspWeb.Common;

import java.util.HashMap;

/**
 * 定义常量类型
 * 
 * @author Alex
 */
public class Constants
{
    /**
     * 常量哈希表
     */
    protected static HashMap<String, Object> sMap;

    static {
        sMap = new HashMap<String, Object>();

        // 默认数据库连接别名
        sMap.put("DEFAULT_DATABASE_ALIAS", "default");

        // 下载目录文件夹名称
        sMap.put("DIRECTORY_DOWNLOAD", "Download");

        // 上传目录文件夹名称
        sMap.put("DIRECTORY_UPLOAD", "Upload");

        // 上传附件文件夹
        sMap.put("DIRECTORY_ATTACHMENT", "Attachment");
        
        // 验证码会话键值
        sMap.put("SESSION_KEY_CAPTCHA", "session_key_captcha");
        
        // 认证盐值
        sMap.put("AUTH_SALT", "rY802x2@A13d");
    }

    /**
     * 获取常量
     * 
     * @param key
     *            常量键
     * 
     * @return 常量
     */
    public static Object get(String key)
    {
        return sMap.get(key);
    }
}