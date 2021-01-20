package com.building.service.impl;

import com.building.dao.MenuMapper;
import com.building.entity.Menu;
import com.building.entity.vo.MenuVo;
import com.building.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mapper;

    @Override
    public List<MenuVo> getMenu() {
        return mapper.getMenu();
    }

    @Override
    public List<Menu> getMenuByUsername(String username) {
        System.out.println("user menu="+mapper.getMenuByUsername(username));
        return mapper.getMenuByUsername(username);
    }
}
