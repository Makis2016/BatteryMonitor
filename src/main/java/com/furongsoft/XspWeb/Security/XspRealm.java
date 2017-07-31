package com.furongsoft.XspWeb.Security;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.furongsoft.XspWeb.Common.Constants;
import com.furongsoft.XspWeb.Security.Entities.User;
import com.furongsoft.XspWeb.Security.Entities.UserPermission;
import com.furongsoft.XspWeb.Security.Entities.UserRole;
import com.furongsoft.XspWeb.Security.Services.SecurityService;
import com.furongsoft.XspWeb.Utils.StringUtils;

public class XspRealm extends AuthorizingRealm
{
    @Autowired
    public SecurityService securityService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0)
    {
        String loginId = (String) getAvailablePrincipal(arg0);
        if (loginId == null)
            return null;

        User user = securityService.Login(loginId);
        if (user == null)
            return null;

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<UserRole> roles = securityService.getUserRoles(user.getId());
        for (UserRole role : roles) {
            info.addRole(role.getName());
        }

        List<UserPermission> permissions = securityService
            .getUserPermissions(user.getId());
        for (UserPermission permission : permissions) {
            info.addStringPermission((String) permission.getValue());
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
        AuthenticationToken arg0) throws AuthenticationException
    {
        /*UsernamePasswordToken token = (UsernamePasswordToken) arg0;*/
        UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) arg0;

        String loginId = token.getUsername();
        if (StringUtils.isNullOrEmpty(loginId))
            return null;

        String captcha = token.getCaptcha();
        String code = (String) SecurityUtils
            .getSubject().getSession()
            .getAttribute(Constants.get("SESSION_KEY_CAPTCHA"));
        if ((captcha == null) || (!captcha.equalsIgnoreCase(code)))
            throw new CaptchaException();

        User user = securityService.Login(loginId);
        if (user == null)
            return null;

        return new SimpleAuthenticationInfo(
            loginId, user.getPassword(),
            ByteSource.Util.bytes(
                Constants.get("AUTH_SALT").toString() + user.getLogin_id()),
            getName());
    }
}