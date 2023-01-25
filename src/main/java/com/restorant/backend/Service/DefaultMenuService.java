package com.restorant.backend.Service;

import com.restorant.backend.POJO.Menu;
import com.restorant.backend.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMenuService implements MenuService{

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteItem(Menu menu) {
        menuRepository.delete(menu);
    }

    @Override
    public Menu update(Menu menuToUpdate) {
        return menuRepository.save(menuToUpdate);
    }
}
