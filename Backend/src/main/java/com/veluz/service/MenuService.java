package com.veluz.service;

import com.veluz.entity.Menu;
import java.util.List;
import java.util.Optional;

public interface MenuService {

    Menu addMenu(Menu menu);

    Optional<Menu> getMenuById(Integer id); // change Long → Integer

    List<Menu> getAllMenus();

    Menu updateMenu(Menu menu);

    void deleteMenu(Integer id); // change Long → Integer
}