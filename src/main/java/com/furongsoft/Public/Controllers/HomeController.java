package com.furongsoft.Public.Controllers;

import com.alibaba.fastjson.JSON;
import com.furongsoft.Public.CallServices.CallService;
import com.furongsoft.Public.Dao.Entities.Menu;
import com.furongsoft.Public.Dao.Entities.SimpleDateForzTree;
import com.furongsoft.Public.Dao.Entities.User;
import com.furongsoft.Public.Dao.MbServices.ObjectService;
import com.furongsoft.Public.Utils.Constant;
import com.furongsoft.Public.Utils.Misc;
import com.furongsoft.XspWeb.Common.BaseController;
import com.furongsoft.XspWeb.Common.Tracker;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义根视图控制器
 *
 * @author Alex
 */
@Controller
@SessionAttributes("user")
public class HomeController extends BaseController
{
    @Autowired
    public ObjectService objectService;

    @RequestMapping(value = "/")
    public ModelAndView home()
    {
        return makeForwardView(null, "/Security/login");
    }

    @RequestMapping(value = "/Index")
    @RequiresAuthentication
    @RequiresPermissions("shouye:show")
    public ModelAndView index(ModelMap model)
    {
        Subject currentUser = (Subject) model.get("user");
        if (currentUser == null) {
            return makeModelAndView("XspWeb/Security/Login/unLogin");
        }
        User user = (User) currentUser.getSession().getAttribute("userModel");
        List<Menu> tabMenuList = objectService.getTabMenu(user.getId());
        return makeModelAndView("Home/Index/index")
            .addObject("_RootPath", getContextPath())
            .addObject("username", user.getName())
            .addObject("tabMenuList", JSON.toJSONString(tabMenuList));
    }

    @RequestMapping(value = "/default")
    public ModelAndView defaultjsp()
    {
        return makeModelAndView("Home/Index/default");
    }

    @RequestMapping(value = "/Unauthorized")
    public ModelAndView Unauthorized()
    {
        return makeModelAndView("XspWeb/Security/Login/unLogin");
    }

    @RequestMapping(value = "/getSimpleDateForzTree")
    @ResponseBody
    public void getSimpleDateForzTree()
    {
        try {
            List<SimpleDateForzTree> simpleDateForzTrees = CallService.convertToSimpleDateForzTree();
            for (SimpleDateForzTree simpleDateForzTree : simpleDateForzTrees) {
                if (simpleDateForzTree.getPid() == 0) {
                    simpleDateForzTree.setParent(true);
                    simpleDateForzTree.setIconSkin("furong");
                    long id = simpleDateForzTree.getId();
                    for (SimpleDateForzTree simpleDateForzTree2 : simpleDateForzTrees) {
                        if (simpleDateForzTree2.getPid() == id) {
                            simpleDateForzTree2.setParent(true);
                            simpleDateForzTree2.setIconSkin("furong");
                        }
                    }
                }
            }
            responseJson(Misc.convertAResultJson("", 0, simpleDateForzTrees));
        }
        catch (Exception e) {
            Tracker.e(Constant.operationError + "\n" + e);
            responseJson(Misc.convertAResultJson(Constant.operationError, -1, null));
        }

    }

    @RequestMapping(value = "/getRightMenu")
    @ResponseBody
    public void getRightMenu(long id)
    {
        List<Menu> rightMenuList = objectService.getRightMenu(id);
        responseJson(JSON.toJSONString(rightMenuList));
    }

    @RequestMapping(value = "/getPoint1Names")
    @ResponseBody
    public void getPoint1Names()
    {
        List<SimpleDateForzTree> simpleDateForzTrees = objectService
            .getSimpleDateForzTree();

        List<SimpleDateForzTree> point1Names = new ArrayList<>();
        for (SimpleDateForzTree simpleDateForzTree : simpleDateForzTrees) {
            if (simpleDateForzTree.getPid() == 0) {
                point1Names.add(simpleDateForzTree);
            }
        }
        responseJson(JSON.toJSONString(point1Names));
    }

    @RequestMapping(value = "/getPoint2Names")
    @ResponseBody
    public void getPoint2Names(long pid)
    {
        List<SimpleDateForzTree> simpleDateForzTrees = objectService
            .getSimpleDateForzTree();

        List<SimpleDateForzTree> point2Names = new ArrayList<>();
        for (SimpleDateForzTree simpleDateForzTree : simpleDateForzTrees) {
            if (simpleDateForzTree.getPid() == pid) {
                point2Names.add(simpleDateForzTree);
            }
        }
        responseJson(JSON.toJSONString(point2Names));
    }

    @RequestMapping(value = "/getPoint3Names")
    @ResponseBody
    public void getPoint3Names(long pid)
    {
        List<SimpleDateForzTree> simpleDateForzTrees = objectService
            .getSimpleDateForzTree();

        List<SimpleDateForzTree> point3Names = new ArrayList<>();
        for (SimpleDateForzTree simpleDateForzTree : simpleDateForzTrees) {
            if (simpleDateForzTree.getPid() == pid) {
                point3Names.add(simpleDateForzTree);
            }
        }
        responseJson(JSON.toJSONString(point3Names));
    }
}