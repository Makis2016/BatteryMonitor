package com.furongsoft.XspWeb.Security.Dao;

import java.util.List;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.furongsoft.XspWeb.Security.Entities.PermissionEntity;
import com.furongsoft.XspWeb.Security.Entities.User;
import com.furongsoft.XspWeb.Security.Entities.UserPermission;
import com.furongsoft.XspWeb.Security.Entities.UserRole;

public class SecurityDao extends BaseDao
{
    @MyBatisMapper
    public interface UserPermissionMapper
    {
        @Select("SELECT DISTINCT\n" +
            "\ttp.id,\n" +
            "\t`value`\n" +
            "FROM\n" +
            "\tt_sys_permission tp,\n" +
            "\tt_sys_pa tpa,\n" +
            "\tt_sys_ua tu\n" +
            "WHERE tp.id = tpa.permission_id\n" +
            "AND tpa.role_id = tu.role_id\n" +
            "AND tu.user_id = #{id}")
        public List<UserPermission> getUserPermissions(final long id);
    }

    @MyBatisMapper
    public interface UserRoleMapper
    {
        @Select("SELECT `name` FROM t_sys_role WHERE id IN " + "(SELECT role_id FROM t_sys_ua WHERE user_id = #{id})")
        public List<UserRole> getUserRoles(final long id);
    }

    @MyBatisMapper
    public interface UserMapper
    {
        @Select("SELECT * FROM t_sys_user WHERE login_id=#{loginId} AND starus = 1")
        public User Login(final String loginId);

        @Select("SELECT * FROM t_sys_user WHERE login_id=#{loginId} AND starus = 1")
        public com.furongsoft.Public.Dao.Entities.User getUser(final String loginId);
    }
}