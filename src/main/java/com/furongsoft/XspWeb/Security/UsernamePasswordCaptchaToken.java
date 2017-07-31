package com.furongsoft.XspWeb.Security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 定义用户名、密码、验证码令牌类型
 * 
 * @author Alex
 */
public class UsernamePasswordCaptchaToken extends UsernamePasswordToken
{
    private static final long serialVersionUID = 5047445062081253542L;

    private String captcha;

    public UsernamePasswordCaptchaToken()
    {
        super();
    }

    public UsernamePasswordCaptchaToken(
        String username,
        String password,
        String captcha)
    {
        super(username, password);
        this.captcha = captcha;
    }

    public String getCaptcha()
    {
        return captcha;
    }

    public void setCaptcha(String captcha)
    {
        this.captcha = captcha;
    }
}