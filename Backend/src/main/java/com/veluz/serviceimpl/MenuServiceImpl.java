package com.veluz.serviceimpl;

import com.veluz.entity.Menu;
import com.veluz.repository.MenuRepository;
import com.veluz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Optional<Menu> getMenuById(Integer id) { // changed Long → Integer
        return menuRepository.findById(id);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Integer id) { // changed Long → Integer
        menuRepository.deleteById(id);
    }
}