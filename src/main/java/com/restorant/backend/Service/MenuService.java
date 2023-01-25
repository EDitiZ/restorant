package com.restorant.backend.Service;

import com.restorant.backend.POJO.Menu;

public interface MenuService {

    Menu create(Menu menu);

    void deleteItem(Menu menu);

    Menu update(Menu menuToUpdate);
}
