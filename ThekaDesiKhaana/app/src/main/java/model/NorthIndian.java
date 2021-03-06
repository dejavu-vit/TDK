package model;

import java.util.List;

/**
 * Created by ParmeshMahore on 2/7/17.
 */

public class NorthIndian implements IFoodType{

    private String name;

    private List<MenuItems> menuItems;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public List<MenuItems> getMenuItems ()
    {
        return menuItems;
    }

    public void setMenuItems (List<MenuItems> menuItems)
    {
        this.menuItems = menuItems;
    }

    @Override
    public String toString()
    {
        return "NorthIndian [name = "+name+", menuItems = "+menuItems+"]";
    }

}
