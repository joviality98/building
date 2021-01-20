package com.building.service;

import com.building.entity.Menu;
import com.building.entity.vo.MenuVo;

import java.util.List;

public interface MenuService {

    List<MenuVo> getMenu();

    List<Menu> getMenuByUsername(String username);
}
