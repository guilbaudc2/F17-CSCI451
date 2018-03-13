package com.example.plantep.javashoppinglist;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by plantep on 8/24/2017.
 */

public class ShoppingList {
    private static ShoppingList shoppingSet;
    private static ArrayList<Item> shoppingList = new ArrayList<Item>();

    private ShoppingList() {
        //populating ArrayList

        shoppingList.add(new Item(2, "Apples", "Fruit", false));
        shoppingList.add(new Item(4, "Oranges", "Fruit", false));
        shoppingList.add(new Item(2, "Turkey", "Poultry", false));
        shoppingList.add(new Item(5, "Hamburger Patties", "Meat", false));
        shoppingList.add(new Item(7, "Bell Peppers", "Vegetable", false));
        shoppingList.add(new Item(1, "Frying Pan", "Kitchen Utencils", false));
        shoppingList.add(new Item(2, "Sharpies", "Stationary", false));
        shoppingList.add(new Item(9, "Sunny D", "Beverage", false));

    }

    public static ShoppingList getList() {
        if(shoppingSet == null) {
            shoppingSet = new ShoppingList();
        }
        return shoppingSet;
    }

    public static ArrayList getItems() {
        return shoppingList;
    }

    public Item getItem(UUID id){

        for (int i = 0; i < shoppingList.size(); i++){
            if (id.equals(shoppingList.get(i).getId())){
                return shoppingList.get(i);
            }
        }
        return null;
    }
}
