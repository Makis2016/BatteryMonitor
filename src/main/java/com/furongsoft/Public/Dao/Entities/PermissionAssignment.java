package com.furongsoft.Public.Dao.Entities;

/**
 * Created by Linyudui on 2016/6/29.
 */
public class PermissionAssignment
{
    private long id;
    private long role_id;
    private long permission_id;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getRole_id()
    {
        return role_id;
    }

    public void setRole_id(long role_id)
    {
        this.role_id = role_id;
    }

    public long getPermission_id()
    {
        return permission_id;
    }

    public void setPermission_id(long permission_id)
    {
        this.permission_id = permission_id;
    }
}