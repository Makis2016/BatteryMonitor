package com.furongsoft.Public.Controllers;

import com.alibaba.fastjson.JSON;
import com.furongsoft.Public.Dao.Entities.User;
import com.furongsoft.Public.Model.Login;
import com.furongsoft.Public.Services.OperationLogSevcie;
import com.furongsoft.XspWeb.Common.BaseController;
import com.furongsoft.XspWeb.Security.CaptchaException;
import com.furongsoft.XspWeb.Security.Services.SecurityService;
import com.furongsoft.XspWeb.Security.UsernamePasswordCaptchaToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Security")
public class LoginController extends BaseController
{
    @Autowired
    public SecurityService securityService;

    @Autowired
    public OperationLogSevcie operationLogSevcie;

    @RequestMapping(value = "/login")
    public String login()
    {
        return "XspWeb/Security/Login/login";
    }

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    @ResponseBody
    public String loginAction(
        HttpSession httpSession,
        final String json)
    {

        Login loginModel = JSON.parseObject(json, Login.class);
        String loginId = StringUtils.clean(loginModel.getUsername());
        String password = StringUtils.clean(loginModel.getPassword());
        String captcha = StringUtils.clean(loginModel.getCaptcha());
        Long id = operationLogSevcie.insertOperation("login",loginId);

        UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(
            loginId, password, captcha);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            User user = securityService.getUser(loginId);
            currentUser.getSession().setAttribute("userModel", user);
            httpSession.setAttribute("user", currentUser);
        }
        catch (UnknownAccountException uae) {
            responseJson("{\"result\":-1, \"info\":\"未知账户\"}");
            return null;
        }
        catch (IncorrectCredentialsException ice) {
            responseJson("{\"result\":-1, \"info\":\"密码不正确\"}");
            return null;
        }
        catch (LockedAccountException lae) {
            responseJson("{\"result\":-1, \"info\":\"账户已锁定\"}");
            return null;
        }
        catch (ExcessiveAttemptsException eae) {
            responseJson("{\"result\":-1, \"info\":\"用户名或密码错误次数过多\"}");
            return null;
        }
        catch (AuthenticationException ae) {
            if (ae instanceof CaptchaException) {
                responseJson("{\"result\":-1, \"info\":\"验证码错误\"}");
            }
            else {
                responseJson("{\"result\":-1, \"info\":\"用户名或密码不正确\"}");
            }

            return null;
        }
        catch (Exception e) {
            responseJson("{\"result\":-1, \"info\":\"登录失败\"}");
            return null;
        }

        if (!currentUser.isAuthenticated()) {
            token.clear();
            responseJson("{\"result\":-1, \"info\":\"登录失败\"}");
            return null;
        }

        responseJson("{\"result\":0, \"info\":\"登录成功\"}");
        operationLogSevcie.updateOperationResult(id);
        return null;
    }

    @RequestMapping(value = "/logout.action")
    @ResponseBody
    public void logoutAction()
    {
        SecurityUtils.getSubject().logout();
        responseJson("{\"result\":0, \"info\":\"注销成功\"}");
    }
}