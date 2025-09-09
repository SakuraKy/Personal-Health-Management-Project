package com.atsakuraky.sportplay.dao;

import com.atsakuraky.sportplay.bean.MainMenu;
import com.atsakuraky.sportplay.bean.SubMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {

    public List<MainMenu> getMenus();
}
