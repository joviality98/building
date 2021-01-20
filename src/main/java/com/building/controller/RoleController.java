package com.building.controller;


import com.alibaba.fastjson.JSON;
import com.building.common.lang.Result;
import com.building.entity.vo.MenuVo;
import com.building.entity.vo.RolePermissionVo;
import com.building.log.MyLog;
import com.building.service.RoleService;
import com.building.service.UserService;
import com.building.util.Entity2VO;
import com.building.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CDSY
 * @since 2020-12-15
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public Result list(){
        return Result.success(roleService.getAll());
    }

    //-----------------------------------------------------------------------
    /**
     * 对应前端：系统管理->用户角色设置->右边用户查询
     * @param roleId
     * @return
     */

    @GetMapping("/roleUser")
    public Result getRoleAndUserList(String roleId) {
        System.out.println("roleId:"+roleId);
        return Result.success(roleService.getRoleAndUserList(roleId));
    }

    @MyLog("给用户添加角色")
    @PostMapping("/addRoleUser")
    public Result saveRoleUser(@RequestBody HashMap<String, String> map){
        String roleId = map.get("roleId");
        List<String> data = (List<String>) JSON.parse(map.get("list"));
        System.out.println("--------------现在进入方法saveRoleUser--------------");
        roleService.saveRoleUser(roleId, data);
        return Result.success("添加成功",null);
    }

    //-----------------------------------------------------------------------
    /**
     * 对应前端：系统管理->菜单角色设置->右边菜单查询
     * @param roleId
     * @return
     */
    @GetMapping("/roleMenu")
    public Result getRoleAndMenuList(String roleId) {
        List<RolePermissionVo> menus = roleService.getRoleAndMenuList(roleId);
        List<MenuVo> listVO = Entity2VO.entityList2VOList(menus, MenuVo.class);
        return Result.success(TreeUtils.toTree(listVO));
    }


    @RequestMapping(value = "/setRoleMenu",method = RequestMethod.POST)
    public Result saveRoleMenu(@RequestBody HashMap<String, String> map){
        String roleId = map.get("roleId");
        List<String> data = (List<String>) JSON.parse(map.get("list"));
        if(roleId==null){
            return Result.fail("传入的roleId为空");
        }

        System.out.println("--------------现在进入方法saveRoleMenu--------------");
        roleService.saveRoleMenu(roleId,data);
        return Result.success("添加成功",null);
    }

}
