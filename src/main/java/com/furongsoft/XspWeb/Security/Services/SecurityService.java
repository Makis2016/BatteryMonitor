package com.furongsoft.XspWeb.Security.Services;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.furongsoft.XspWeb.Common.Constants;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao.MyBatisMapper;
import com.furongsoft.XspWeb.Security.Dao.SecurityDao;
import com.furongsoft.XspWeb.Security.Dao.SecurityDao.UserMapper;
import com.furongsoft.XspWeb.Security.Dao.SecurityDao.UserPermissionMapper;
import com.furongsoft.XspWeb.Security.Dao.SecurityDao.UserRoleMapper;
import com.furongsoft.XspWeb.Security.Entities.PermissionEntity;
import com.furongsoft.XspWeb.Security.Entities.User;
import com.furongsoft.XspWeb.Security.Entities.UserPermission;
import com.furongsoft.XspWeb.Security.Entities.UserRole;

@Service
public class SecurityService
{
    @Autowired
    public SecurityDao securityDao;

    @MyBatisMapper
    public interface ResourceMapper
    {
        @Select("SELECT name, value AS permission FROM t_sys_permission")
        public List<PermissionEntity> loadPermissions();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Cacheable(value = "permissionCache", key = "'getPermissions'")
    public List<PermissionEntity> getPermissions()
    {
        return securityDao.loadAll(ResourceMapper.class, "loadPermissions");
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<UserRole> getUserRoles(final long id)
    {
        return securityDao.loadAll(
            UserRoleMapper.class, "getUserRoles",
            new HashMap<String, Object>() {
                {
                    put("id", id);
                }
            });
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<UserPermission> getUserPermissions(final long id)
    {
        return securityDao.loadAll(
            UserPermissionMapper.class, "getUserPermissions",
            new HashMap<String, Object>() {
                {
                    put("id", id);
                }
            });
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User Login(final String loginId)
    {
        User user = securityDao
            .query(UserMapper.class, "Login", new HashMap<String, Object>() {
                {
                    put("loginId", loginId);
                }
            });
        return user;
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public
        com.furongsoft.Public.Dao.Entities.User getUser(final String loginId)
    {
        com.furongsoft.Public.Dao.Entities.User user = securityDao
            .query(UserMapper.class, "getUser", new HashMap<String, Object>() {
                {
                    put("loginId", loginId);
                }
            });
        return user;
    }

    /**
     * 生成储存密码
     * 
     * @param userName
     *            用户名
     * @param password
     *            原始密码
     * 
     * @return 储存密码
     */
    public String generatePassword(String userName, String password)
    {
        return (new SimpleHash(
            "MD5", password, Constants.get("AUTH_SALT").toString() + userName,
            2)).toHex();
    }
}