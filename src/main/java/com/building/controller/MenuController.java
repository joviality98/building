package com.building.controller;

import com.building.common.lang.Result;
import com.building.entity.vo.MenuVo;
import com.building.service.MenuService;
import com.building.service.UserService;
import com.building.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public Result getMenu(){
        List<MenuVo> menus = menuService.getMenu();
        return Result.success(TreeUtils.toTree(menus));
    }


}
