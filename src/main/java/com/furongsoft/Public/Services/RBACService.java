package com.furongsoft.Public.Services;

import com.alibaba.fastjson.JSON;
import com.furongsoft.Public.Dao.Entities.Menu;
import com.furongsoft.Public.Dao.Entities.Permission;
import com.furongsoft.Public.Dao.Entities.PermissionAssignment;
import com.furongsoft.Public.Dao.Entities.Role;
import com.furongsoft.Public.Dao.MbServices.ObjectService;
import com.furongsoft.Public.Model.AResult;
import com.furongsoft.Public.Model.PaginationResultByEuiGrid;
import com.furongsoft.Public.Model.Permissions;
import com.furongsoft.Public.Model.User;
import com.furongsoft.Public.Utils.Constant;
import com.furongsoft.Public.Utils.Misc;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.DbHelper.ORM.BaseDao;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.DB;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Record;
import com.furongsoft.XspWeb.ThirdParty.me.zzp.ar.Table;
import com.furongsoft.XspWeb.Utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LYD on 2016/10/6.
 */
@Service
public class RBACService
{
    @Autowired
    public OperationLogSevcie operationLogSevcie;

    @Autowired
    public ObjectService objectService;

    @Autowired
    @Qualifier("BaseDao_system")
    public BaseDao baseDao;

    /*UserManage*/
    @Transactional(propagation = Propagation.REQUIRED)
    public String addUser(String json)
    {
        Long operationId = operationLogSevcie.insertOperation("addUser",null);
        User user = JSON.parseObject(json, User.class);
        user.setPassword(Misc.generatePassword(user.getLogin_id(), user.getPassword()));
        try {
            DB db = baseDao.getDb();
            Record record = db
                .active("t_sys_user").findA("login_id", user.getLogin_id());
            if (record != null && record.getLong("id") > 0) {
                return JSON.toJSONString(
                    new AResult("用户名已经被人使用,请重新选择", -1, null));
            }

            record = db.active("t_sys_user").create(
                "name:", user.getName(), "login_id:", user.getLogin_id(),
                "password:", user.getPassword(), "point1_id:",
                user.getPoint1_id(), "point2_id:", user.getPoint2_id(),
                "point3_id:", user.getPoint3_id(), "sex:", user.getSex(),
                "starus:", user.getStarus(), "email:", user.getEmail(),
                "tel_no:", user.getTel_no(), "affiliated_institutions:",
                user.getAffiliated_institutions());

            long uid = record.getLong("id");
            record = db.active("t_sys_ua").create("user_id:", uid, "role_id:", user.getRole_id());

            if (record.getLong("id") > 0) {
                operationLogSevcie.updateOperationResult(operationId);
                return JSON.toJSONString(new AResult(Constant.addSuccess, 0, null));
            }
            else {
                return JSON.toJSONString(new AResult(Constant.addError, -1, null));
            }
        }
        catch (Exception e) {
            return JSON.toJSONString(new AResult(Constant.addError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String deleteUser(long id)
    {
        Long operationId = operationLogSevcie.insertOperation("deleteUser",null);
        if (objectService.deleteUser(id)) {
            DB db = baseDao.getDb();
            List<Record> records = db.active("t_sys_ua").where("user_id = ?", id);
            for (Record record : records) {
                db.active("t_sys_ua").delete(record);
            }

            operationLogSevcie.updateOperationResult(operationId);
            return JSON.toJSONString(new AResult(Constant.deleteSuccess, 0, null));
        }
        else {
            return JSON.toJSONString(new AResult(Constant.deleteError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String updUser(String json,Long role_id)
    {
        Long operationId = operationLogSevcie.insertOperation("updUser",null);
        com.furongsoft.Public.Dao.Entities.User user = JSON
            .parseObject(json, com.furongsoft.Public.Dao.Entities.User.class);
        try {
            // 判断当前登录用户是否可以在这个页面编辑密码
            if(SecurityUtils.getSubject().isPermitted("updOtherUserPass")){
                String newPassword = Misc.generatePassword(user.getLogin_id(),user.getPassword());
                user.setPassword(newPassword);
            }

            baseDao.update(user);
            DB db = baseDao.getDb();
            Table table=db.active("t_sys_ua");
            List<Record> records = table.where("user_id = ?",user.getId());
            if(records!=null&&records.size()>0){
                for(Record record :records){
                    record.set("role_id",role_id);
                    table.update(record);
                }
            }else{
                db.active("t_sys_ua").create("user_id:",user.getId(),"role_id:",role_id);
            }
            operationLogSevcie.updateOperationResult(operationId);
            return JSON.toJSONString(new AResult(Constant.updateSuccess, 0, null));
        }
        catch (Exception e) {
            Tracker.e(e);
            return JSON.toJSONString(new AResult(Constant.updateError, -1, null));
        }
    }

    public String getUsers(int page,int rows){
        int total = baseDao.getDb().active("t_sys_user").all().size();
        List<User> users = objectService.getUserList((page - 1) * rows, rows);
        return JSON.toJSONString(new PaginationResultByEuiGrid(total, users));
    }

    /* RoleManage */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String addRole(String json)
    {
        Long operationId = operationLogSevcie.insertOperation("addRole",null);
        try {
            com.furongsoft.Public.Model.Role roleModel = JSON
                .parseObject(json, com.furongsoft.Public.Model.Role.class);
            Role role = new Role();
            role.setName(roleModel.getName());
            role.setRemark(roleModel.getRemark());
            String[] ids = roleModel.getIds().split(",");

            if (roleModel != null) {
                role = baseDao.getDb().active("t_sys_role").create(
                    role, BeanPropertyRowMapper.newInstance(Role.class));

                if (ids != null) {
                    for (int i = 0; i < ids.length; i++) {
                        if (!StringUtils.isNullOrEmpty(ids[i])) {
                            PermissionAssignment permissionAssignment = new PermissionAssignment();
                            permissionAssignment.setRole_id(role.getId());
                            permissionAssignment
                                .setPermission_id(Long.parseLong(ids[i]));
                            objectService.setRolesPermission(permissionAssignment);
                        }
                    }
                }
                operationLogSevcie.updateOperationResult(operationId);
                return JSON.toJSONString(new AResult(Constant.addSuccess, 0, null));
            }
            else {
                return JSON.toJSONString(new AResult(Constant.addError, -1, null));
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return  JSON.toJSONString(new AResult(Constant.addError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String deleteRole(long id)
    {
        Long operationId = operationLogSevcie.insertOperation("deleteRole",null);
        if (objectService.deleteRole(id)) {
            DB db = baseDao.getDb();
            db.execute("DELETE FROM t_sys_pa WHERE role_id = " + id);
            db.execute("DELETE FROM t_sys_ua WHERE role_id = " + id);

            operationLogSevcie.updateOperationResult(operationId);
            return JSON.toJSONString(new AResult(Constant.deleteSuccess, 0, null));
        }
        else {
            return JSON.toJSONString(new AResult(Constant.deleteError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String updRole(String json)
    {
        Long operationId = operationLogSevcie.insertOperation("updRole",null);
        try {
            com.furongsoft.Public.Model.Role roleModel = JSON
                .parseObject(json, com.furongsoft.Public.Model.Role.class);

            if (roleModel != null) {
                String[] ids = roleModel.getIds().split(",");

                DB db = baseDao.getDb();
                db
                    .active("t_sys_role").find(roleModel.getId())
                    .set(
                        "name", roleModel.getName())
                    .set(
                        "remark", roleModel.getRemark())
                    .save();

                if (ids != null) {

                    List<Record> records = db.active("t_sys_pa").where(
                        "role_id = ?", roleModel.getId());

                    for (int i = 0; i < records.size(); i++)
                        db.active("t_sys_pa").delete(records.get(i));

                    for (int i = 0; i < ids.length; i++) {
                        if (!StringUtils.isNullOrEmpty(ids[i])) {
                            db.active("t_sys_pa").create(
                                "role_id:", roleModel.getId(), "permission_id:",
                                Long.parseLong(ids[i]));
                        }
                    }
                }

                operationLogSevcie.updateOperationResult(operationId);
                return JSON.toJSONString(new AResult(Constant.updateSuccess, 0, null));
            }
            else {
                return JSON.toJSONString(new AResult(Constant.updateError, -1, null));
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return JSON.toJSONString(new AResult(Constant.updateError, -1, null));
        }
    }

    public String getRoles(int page, int rows)
    {
        int total = baseDao.getDb().active("t_sys_role").all().size();
        List<Role> roles = objectService.getRoleList((page - 1) * rows, rows);
        return JSON.toJSONString(
                new PaginationResultByEuiGrid(total, roles));
    }

    /* ModuleManage */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String addModule(String json)
    {
        Long operationId = operationLogSevcie.insertOperation("addModule",null);
        try {
            Menu module = JSON.parseObject(json, Menu.class);
            if (module != null) {
                DB db = baseDao.getDb();
                Record record = db.active("t_sys_menu").create(
                    "name:",module.getName(),
                    "url:", module.getUrl(), "type:", module.getType(),
                    "start:", 1, "parent_id:", 0);

                Long rid = record.getLong("id");
                String pids = module.getPermission_ids();
                if (!StringUtils.isNullOrEmpty(pids)) {
                    String[] pidArr = pids.split(",");
                    for (String pid : pidArr) {
                        if (!StringUtils.isNullOrEmpty(pid)) {
                            record = db.active("t_sys_ac").create("permission_id:", Integer.parseInt(pid),
                                "resources_id:", rid);
                        }
                    }
                }

                operationLogSevcie.updateOperationResult(operationId);
                return JSON.toJSONString(new AResult(Constant.addSuccess, 0, null));
            }
            else {
                return JSON.toJSONString(new AResult(Constant.addError, -1, null));
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return JSON.toJSONString(new AResult(Constant.addError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String deleteModule(long id)
    {
        Long operationId = operationLogSevcie.insertOperation("deleteModule",null);
        try {
            DB db = baseDao.getDb();
            Table table = db.active("t_sys_menu");
            table.delete(table.find(id));

            List<Record> records = db
                .active("t_sys_ac").where("resources_id = ?", id);
            for (Record record : records) {
                db.active("t_sys_ac").delete(
                    db.active("t_sys_ac").find(record.getLong("id")));
            }

            operationLogSevcie.updateOperationResult(operationId);
            return JSON.toJSONString(new AResult(Constant.deleteSuccess, 0, null));
        }
        catch (Exception e) {
            return JSON.toJSONString(new AResult(Constant.deleteError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String updModule(String json)
    {
        Long operationId = operationLogSevcie.insertOperation("updModule",null);
        Menu module = JSON.parseObject(json, Menu.class);
        try {
            DB db = baseDao.getDb();
            Record record = db.active("t_sys_menu").find(module.getId());
            record.set("name", module.getName());
            record.set("url", module.getUrl());
            record.set("type", module.getType());
            db.active("t_sys_menu").update(record);

            List<Record> records = db.active("t_sys_ac").where("resources_id = ?", module.getId());
            for (Record record1 : records) {
                db.active("t_sys_ac").delete(record1);
            }

            if (!StringUtils.isNullOrEmpty(module.getPermission_ids())) {
                String[] pidArr = module.getPermission_ids().split(",");
                for (String pid : pidArr) {
                    db.active("t_sys_ac").create("resources_id:", module.getId(), "permission_id:", Integer.parseInt(pid));
                }
            }
            record.set("permission_id", module.getPermission_ids());
            return JSON.toJSONString(new AResult(Constant.updateSuccess, 0, null));
        }
        catch (Exception e) {
            Tracker.e(e);
            return JSON.toJSONString(new AResult(Constant.updateError, -1, null));
        }
    }

    public String getModule(int page, int rows)
    {
        int total = baseDao.getDb().active("t_sys_permission").all().size();
        List<Menu> modules = objectService.getModule((page - 1) * rows, rows);
        return JSON.toJSONString(
            new PaginationResultByEuiGrid(total, modules));
    }

    /* PermissionManage */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String addPermission(Permission permission)
    {
        Long operationId = operationLogSevcie.insertOperation("addPermission",null);
        try {
            permission.setName(permission.getName());
            if (objectService.addPermission(permission)) {

                operationLogSevcie.updateOperationResult(operationId);
                return JSON.toJSONString(new AResult(Constant.addSuccess, 0, null));
            }
            else {
                return JSON.toJSONString(new AResult(Constant.addError, -1, null));
            }
        }
        catch (Exception e) {
            Tracker.e(e);
            return JSON.toJSONString(new AResult(Constant.addError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String deletePermission(long id)
    {
        Long operationId = operationLogSevcie.insertOperation("deletePermission",null);
        if (objectService.deletePermission(id)) {
            DB db = baseDao.getDb();
            List<Record> records = db
                .active("t_sys_pa").where("permission_id = ?", id);
            for (Record record : records) {
                db.active("t_sys_pa").delete(
                    db.active("t_sys_pa").find(record.getLong("id")));
            }

            records = db
                .active("t_sys_ac").where("permission_id = ?", id);
            for (Record record : records) {
                db.active("t_sys_ac").delete(
                    db.active("t_sys_ac").find(record.getLong("id")));
            }

            operationLogSevcie.updateOperationResult(operationId);
            return JSON.toJSONString(new AResult(Constant.deleteSuccess, 0, null));
        }
        else {
            return JSON.toJSONString(new AResult(Constant.deleteError, -1, null));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public String updPermission(String json)
    {
        Long operationId = operationLogSevcie.insertOperation("updPermission",null);
        Permission permission = JSON.parseObject(json, Permission.class);
        try {
            DB db = baseDao.getDb();
            Record record = db
                .active("t_sys_permission").find(permission.getId());
            record.set("name", permission.getName());
            record.set("value", permission.getValue());
            db.active("t_sys_permission").update(record);

            operationLogSevcie.updateOperationResult(operationId);
            return JSON.toJSONString(new AResult(Constant.updateSuccess, 0, null));
        }
        catch (Exception e) {
            Tracker.e(e);
            return JSON.toJSONString(new AResult(Constant.updateError, -1, null));
        }
    }

    public String getPermissions(int page, int rows)
    {
        int total = baseDao.getDb().active("t_sys_permission").all().size();
        List<Permissions> permissions = objectService.getPermissionList((page - 1) * rows, rows);
        return JSON.toJSONString(
            new PaginationResultByEuiGrid(
                total, permissions));
    }

    /* UI数据 */
    // 下拉框 - 角色
    public String getAllRoles()
    {
        List<Record> records = baseDao.getDb().active("t_sys_role").all();
        List<Role> roles = new ArrayList<>();
        for (Record record : records) {
            Role role = new Role();
            role.setId(record.getLong("id"));
            role.setName(record.getStr("name"));
            roles.add(role);
        }
        return JSON.toJSONString(roles);
    }

    // 下拉框 - 角色的权限
    public String getPermissionsToRoleId(long id)
    {
        List<Permissions> permissions = objectService
            .getPermissionsToRoleId(id);
        return JSON.toJSONString(
            new PaginationResultByEuiGrid(
                permissions.size(), permissions));
    }

    // 选择框 - 所有权限
    public String getAllPermissions()
    {
        List<Record> records = baseDao.getDb().active("t_sys_permission").all();
        List<Permission> permissions = new ArrayList<>();
        for (Record record : records) {
            Permission permission = new Permission();
            permission.setId(record.getLong("id"));
            permission.setName(record.getStr("name"));
            permissions.add(permission);
        }
        return JSON.toJSONString(
            new PaginationResultByEuiGrid(
                permissions.size(), permissions));
    }

    // 选择框 - 拥有的权限
    public String getPermissionsToRecId(long id)
    {
        List<Permissions> permissions = objectService
            .getPermissionsToRecId(id);
        return JSON.toJSONString(
                new PaginationResultByEuiGrid(
                    permissions.size(), permissions));
    }
}