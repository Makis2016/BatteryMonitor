package com.furongsoft.XspWeb.Security;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 定义验证码错误类型
 * 
 * @author Alex
 */
public class CaptchaException extends AuthenticationException
{
    private static final long serialVersionUID = 4278431525971593919L;
}