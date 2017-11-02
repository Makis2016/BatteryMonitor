package com.furongsoft.Public.Dao.MbMapper;

import com.furongsoft.Public.Dao.Entities.*;
import com.furongsoft.Public.Model.Permissions;
import com.furongsoft.Public.Model.User;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by Linyudui on 2016/5/27.
 */
public class ObjectMapper extends BaseDao
{

    /**
     * 删除实体对象
     *
     * @param mapperClass 映射类型
     * @param methodName  方法名称
     * @param parameter   参数对象
     * @throws DataAccessException
     */
    public void delete(
        final Class<?> mapperClass,
        String methodName,
        final Object parameter) throws DataAccessException
    {
        getSqlSessionTemplate()
            .delete(mapperClass.getName() + "." + methodName, parameter);
    }

    @MyBatisMapper
    public interface RbacMapper
    {
        @Select("SELECT\n" +
            "\ttu.*, tr.id AS role_id,GROUP_CONCAT(tr.`name`) AS role_name\n" +
            "FROM\n" +
            "\tt_sys_user tu\n" +
            "LEFT JOIN t_sys_ua tua ON tu.id = tua.user_id\n" +
            "LEFT JOIN t_sys_role tr ON tr.id = tua.role_id\n" +
            "GROUP BY\n" +
            "\ttu.id LIMIT #{page},#{rows}")
        public List<User> getUserList(final int page, final int rows);

        @Select("SELECT * FROM t_sys_role LIMIT #{page},#{rows}")
        public List<Role> getRoleList(final int page, final int rows);

        @Select("SELECT\n" +
            "\tp.id,\n" +
            "\tp.`name`,\n" +
            "\tp.`value`,\n" +
            "\tGROUP_CONCAT(DISTINCT role_name) AS role_names\n" +
            "FROM\n" +
            "\tt_sys_permission p\n" +
            "LEFT JOIN (\n" +
            "\tSELECT\n" +
            "\t\tp.permission_id,\n" +
            "\t\tr.`name` AS role_name\n" +
            "\tFROM\n" +
            "\t\tt_sys_role r,\n" +
            "\t\tt_sys_pa p\n" +
            "\tWHERE\n" +
            "\t\tr.id = p.role_id\n" +
            ") t ON p.id = t.permission_id\n" +
            "LEFT JOIN t_sys_ac ac ON ac.permission_id = p.id\n" +
            "GROUP BY\n" +
            "\tp.id LIMIT #{page},#{rows}")
        public List<Permissions> getPermissionList(final int page, final int rows);

        @Select("SELECT p.id,p.`name`,p.`value`,pa.role_id FROM t_sys_permission p LEFT JOIN t_sys_pa pa  ON p.id = pa.permission_id AND pa.role_id = #{id}")
        public List<Permissions> getPermissionsToRoleId(final long id);

        @Select("SELECT\n" +
            "\tp.id,\n" +
            "\tp.`name`,\n" +
            "\tp.`value`,\n" +
            "\tac.resources_id\n" +
            "FROM\n" +
            "\tt_sys_permission p\n" +
            "LEFT JOIN t_sys_ac ac ON p.id = ac.permission_id\n" +
            "AND ac.resources_id = #{id}")
        public List<Permissions> getPermissionsToRecId(final long id);

        @Insert("INSERT INTO t_sys_role(name) VALUES(#{name})")
        public Boolean addRole(final Role role);

        @Insert("INSERT INTO t_sys_permission(name,value,remarks) VALUES(#{name},#{value},#{remarks})")
        public Boolean addPermission(final Permission permission);

        @Insert("INSERT INTO t_sys_pa(role_id,permission_id) VALUES(#{role_id},#{permission_id})")
        public Boolean setRolesPermission(
            final PermissionAssignment permissionAssignment);

        @Delete("DELETE FROM t_sys_role WHERE id = #{id}")
        public Boolean deleteRole(final long id);

        @Delete("DELETE FROM t_sys_permission WHERE id = #{id}")
        public Boolean deletePermission(final long id);

        @Delete("DELETE FROM t_sys_user WHERE id = #{id}")
        public Boolean deleteUser(final long id);
    }

    @MyBatisMapper
    public interface SystemMapper
    {
        @Select("SELECT id,pid,area_name FROM t_sys_area where status = 1")
        public List<SimpleDateForzTree> getSimpleDateForzTree();

        @Select("SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tt_sys_menu\n" +
            "WHERE\n" +
            "\tstatus = 1\n" +
            "AND type = 0\n" +
            "AND id IN (\n" +
            "\tSELECT\n" +
            "\t\tresources_id\n" +
            "\tFROM\n" +
            "\t\tt_sys_ac\n" +
            "\tWHERE\n" +
            "\t\tpermission_id IN (\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tpermission_id\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tt_sys_pa pa\n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\tpa.role_id IN (\n" +
            "\t\t\t\t\tSELECT\n" +
            "\t\t\t\t\t\trole_id\n" +
            "\t\t\t\t\tFROM\n" +
            "\t\t\t\t\t\tt_sys_ua\n" +
            "\t\t\t\t\tWHERE\n" +
            "\t\t\t\t\t\tuser_id = #{id}\n" +
            "\t\t\t\t)\n" +
            "\t\t)\n" +
            ") ORDER BY id")
        public List<Menu> getTabMenu(final long id);

        @Select("SELECT\n" +
            "\tid,\n" +
            "\tparent_id AS pid,\n" +
            "\tNAME,\n" +
            "\turl AS address\n" +
            "FROM\n" +
            "\tt_sys_menu\n" +
            "WHERE\n" +
            "\tstatus = 1\n" +
            "AND type = 1\n" +
            "AND id IN (\n" +
            "\tSELECT\n" +
            "\t\tresources_id\n" +
            "\tFROM\n" +
            "\t\tt_sys_ac\n" +
            "\tWHERE\n" +
            "\t\tpermission_id IN (\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\tpermission_id\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tt_sys_pa pa\n" +
            "\t\t\tWHERE\n" +
            "\t\t\t\tpa.role_id IN (\n" +
            "\t\t\t\t\tSELECT\n" +
            "\t\t\t\t\t\trole_id\n" +
            "\t\t\t\t\tFROM\n" +
            "\t\t\t\t\t\tt_sys_ua\n" +
            "\t\t\t\t\tWHERE\n" +
            "\t\t\t\t\t\tuser_id = #{id}\n" +
            "\t\t\t\t)\n" +
            "\t\t)\n" +
            ")")
        public List<Menu> getRightMenu(final long id);

        @Select("SELECT\n" +
            "\ttm.*, GROUP_CONCAT(ac.permission_id) AS permission_ids\n" +
            "FROM\n" +
            "\tt_sys_menu tm\n" +
            "LEFT JOIN t_sys_ac ac ON tm.id = ac.resources_id\n" +
            "GROUP BY\n" +
            "\ttm.id LIMIT #{page},#{rows}")
        public List<Menu> getModule(final int page, final int rows);
    }
}