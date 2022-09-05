package model;

import model.tools.Axe;
import model.tools.Pickaxe;
import model.tools.Tools;

import java.util.ArrayList;

public class InventoryModel {
    public ArrayList<Tools> items;
    public int selectedIndex;

    public InventoryModel(){
        this.items = new ArrayList<>();
        items.add(new Axe());
        items.add(new Pickaxe());
        selectedIndex = 0;
    }

    public void setSelectedItem(int selectedIndex) {
        if (selectedIndex >= items.size()) return;
        this.selectedIndex = selectedIndex;
    }

    public int getCurrentToolHitValue(){
        if (selectedIndex == 0){
            return items.get(0).getHitValue();
        }
        else return items.get(1).getHitValue();
    }

    public Tools getCurrentItem() {
        if (selectedIndex == 0){
            return items.get(0);
        }
        else return items.get(1);
    }
}
