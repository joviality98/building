package com.building.dao;

import com.building.entity.Menu;
import com.building.entity.vo.MenuVo;
import com.building.util.MyMapper;

import java.util.List;

public interface MenuMapper extends MyMapper<Menu> {
    public List<MenuVo> getMenu();

    public List<Menu> getMenuByUsername(String username);
}