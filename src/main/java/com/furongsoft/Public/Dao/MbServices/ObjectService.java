package com.furongsoft.Public.Dao.MbServices;

import com.furongsoft.Public.Dao.Entities.*;
import com.furongsoft.Public.Dao.MbMapper.ObjectMapper;
import com.furongsoft.Public.Dao.MbMapper.ObjectMapper.RbacMapper;
import com.furongsoft.Public.Model.Permissions;
import com.furongsoft.Public.Model.User;
import com.furongsoft.XspWeb.Common.Tracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Linyudui on 2016/5/27.
 */
@Service
public class ObjectService
{
    @Autowired
    public ObjectMapper objectMapper;

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> getUserList(final int page, final int rows)
    {
        return objectMapper.loadAll(RbacMapper.class, "getUserList", new HashMap<String, Object>()
        {
            {
                put("page", page);
                put("rows", rows);
            }
        });
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Role> getRoleList(final int page, final int rows)
    {
        return objectMapper.loadAll(RbacMapper.class, "getRoleList", new HashMap<String, Object>()
        {
            {
                put("page", page);
                put("rows", rows);
            }
        });
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Permissions> getPermissionList(final int page, final int rows)
    {
        return objectMapper.loadAll(RbacMapper.class, "getPermissionList", new HashMap<String, Object>()
        {
            {
                put("page", page);
                put("rows", rows);
            }
        });
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Permissions> getPermissionsToRoleId(final long id)
    {
        return objectMapper.loadAll(
            RbacMapper.class, "getPermissionsToRoleId",
            new HashMap<String, Object>() {
                {
                    put("id", id);
                }
            });
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Permissions> getPermissionsToRecId(final long id) {
        return objectMapper.loadAll(
            RbacMapper.class, "getPermissionsToRecId",
            new HashMap<String, Object>() {
                {
                    put("id", id);
                }
            });
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean addRole(final Role role)
    {
        try {
            objectMapper.insert(RbacMapper.class, "addRole", role);
            return true;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean addPermission(final Permission permission)
    {
        try {
            objectMapper.insert(RbacMapper.class, "addPermission", permission);
            return true;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean setRolesPermission(
        final PermissionAssignment permissionAssignment)
    {
        try {
            objectMapper.insert(
                RbacMapper.class, "setRolesPermission", permissionAssignment);
            return true;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean deleteRole(final long id)
    {
        try {
            objectMapper.delete(RbacMapper.class, "deleteRole", id);
            return true;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    @SuppressWarnings("serial")
    public Boolean deletePermission(final long id)
    {
        try {
            objectMapper.delete(RbacMapper.class, "deletePermission", id);
            return true;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean deleteUser(final long id)
    {
        try {
            objectMapper.delete(RbacMapper.class, "deleteUser", id);
            return true;
        }
        catch (Exception e) {
            Tracker.e(e);
            return false;
        }
    }

    @SuppressWarnings("serial")
    @Transactional(propagation = Propagation.REQUIRED)
    public List<SimpleDateForzTree> getSimpleDateForzTree()
    {
        return objectMapper
            .loadAll(ObjectMapper.SystemMapper.class, "getSimpleDateForzTree");
    }

    public List<Menu> getTabMenu(final long id)
    {
        return objectMapper
            .loadAll(ObjectMapper.SystemMapper.class, "getTabMenu", new HashMap<String, Object>()
            {
                {
                    put("id", id);
                }
            });
    }

    public List<Menu> getModule(final int page, final int rows)
    {
        return objectMapper
            .loadAll(ObjectMapper.SystemMapper.class, "getModule", new HashMap<String, Object>()
            {
                {
                    put("page", page);
                    put("rows", rows);
                }
            });
    }

    public List<Menu> getRightMenu(final long id)
    {
        return objectMapper
            .loadAll(ObjectMapper.SystemMapper.class, "getRightMenu", new HashMap<String, Object>()
            {
                {
                    put("id", id);
                }
            });
    }
}