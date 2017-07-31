package com.furongsoft.Public.Controllers;

import com.furongsoft.Public.Dao.Entities.Permission;
import com.furongsoft.Public.Services.RBACService;
import com.furongsoft.XspWeb.Common.BaseController;
import com.furongsoft.XspWeb.Common.Tracker;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lyd on 2016/1/19.
 */
@Controller
@RequestMapping("/RBAC")
@SessionAttributes("user")
public class RbacController extends BaseController
{
    @Autowired
    public RBACService rbacService;

    @RequestMapping("/rbacManagement")
    @RequiresPermissions("usersetting")
    public String rbacManagement()
    {
        return "RBAC/RBACManage";
    }

    @RequestMapping("/moduleManagement")
    @RequiresPermissions("usersetting")
    public String moduleManagement()
    {
        return "RBAC/ModuleManagement";
    }

    @RequestMapping("/permissionManagement")
    @RequiresPermissions("usersetting")
    public String permissionManagement()
    {
        return "RBAC/PermissionManage";
    }

    @RequestMapping("/roleManagement")
    @RequiresPermissions("usersetting")
    public String roleManagement()
    {
        return "RBAC/RoleManage";
    }

    @RequestMapping("/setUserDialog")
    public ModelAndView setUserDialog(String userInfo)
    {
        return makeModelAndView("RBAC/setUserDialog")
            .addObject("mUserInfo", userInfo);
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public void getUsers(int page, int rows)
    {
        responseJson(rbacService.getUsers(page,rows));
    }

    @RequestMapping("/getRoles")
    @ResponseBody
    public void getRoles(int page, int rows)
    {
        responseJson(rbacService.getRoles(page,rows));
    }

    @RequestMapping("/getPermissions")
    @ResponseBody
    public void getPermissions(int page, int rows)
    {
        responseJson(rbacService.getPermissions(page,rows));
    }

    @RequestMapping("/getModule")
    @ResponseBody
    public void getModule(int page, int rows)
    {
        responseJson(rbacService.getModule(page,rows));
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public void addRole(String json)
    {
        responseJson(rbacService.addRole(json));
    }

    @RequestMapping("/updRole")
    @ResponseBody
    public void updRole(String json)
    {
        responseJson(rbacService.updRole(json));
    }

    @RequestMapping("/addPermission")
    public void addPermission(Permission permission, HttpServletResponse response)
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.write(rbacService.addPermission(permission));
        }
        catch (IOException e) {
            Tracker.e(e);
        }
    }

    @RequestMapping("/addModule")
    @ResponseBody
    public void addModule(String json)
    {
        responseJson(rbacService.addModule(json));
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(String json)
    {
        responseJson(rbacService.addUser(json));
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public void deleteRole(long id)
    {
        responseJson(rbacService.deleteRole(id));
    }

    @RequestMapping("/deletePermission")
    @ResponseBody
    public void deletePermission(long id)
    {
        responseJson(rbacService.deletePermission(id));
    }

    @RequestMapping("/deleteModule")
    @ResponseBody
    public void deleteModule(long id)
    {
        responseJson(rbacService.deleteModule(id));
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(long id)
    {
        responseJson(rbacService.deleteUser(id));
    }

    @RequestMapping("/updPermission")
    @ResponseBody
    public void updPermission(String json)
    {
        responseJson(rbacService.updPermission(json));
    }

    @RequestMapping("/updModule")
    @ResponseBody
    public void updModule(String json)
    {
        responseJson(rbacService.updModule(json));
    }

    @RequestMapping("/updUser")
    @ResponseBody
    public void updUser(String json,Long role_id)
    {
        responseJson(rbacService.updUser(json,role_id));
    }

    /*ui数据*/
    @RequestMapping("/getAllRoles")
    @ResponseBody
    public void getAllRoles()
    {
        responseJson(rbacService.getAllRoles());
    }

    @RequestMapping("/getAllPermissions")
    @ResponseBody
    public void getAllPermissions()
    {
        responseJson(rbacService.getAllPermissions());
    }

    @RequestMapping(value = "/getPermissionsToRoleId")
    @ResponseBody
    public void getPermissionsToRoleId(long id)
    {
        responseJson(rbacService.getPermissionsToRoleId(id));
    }

    @RequestMapping(value = "/getPermissionsToRecId")
    @ResponseBody
    public void getPermissionsToRecId(long id)
    {
        responseJson(rbacService.getPermissionsToRecId(id));
    }
}