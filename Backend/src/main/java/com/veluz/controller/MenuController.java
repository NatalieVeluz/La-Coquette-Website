package com.veluz.controller;

import com.veluz.entity.Menu;
import com.veluz.service.MenuService; // ✅ correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable Integer id) {
        return menuService.getMenuById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    @PostMapping
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @PutMapping("/{id}")
    public Menu updateMenu(@PathVariable Integer id, @RequestBody Menu menu) {
        menu.setId(id);
        return menuService.updateMenu(menu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable Integer id) {
        menuService.deleteMenu(id);
    }
}
