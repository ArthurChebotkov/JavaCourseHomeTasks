package models;

import engine.GameEngine;
import models.arms.Arms;
import models.arms.Axe;
import models.arms.Pickaxe;
import models.entities.FirstAid;

import java.util.ArrayDeque;
import java.util.HashMap;

public class InventoryModel {

    private ArrayDeque<FirstAid> items;
    private HashMap<Integer, Arms> arms;
    private int selectedIndexArms;

    public InventoryModel(){
        this.arms = new HashMap<>();
        this.items = new ArrayDeque<>();
        arms.put(0,new Axe());
        arms.put(1, new Pickaxe());
    }

    public void setSelectedIndexArms(int selectedIndexArms) {
        if (selectedIndexArms >= arms.size()) return;
        this.selectedIndexArms = selectedIndexArms;
    }

    public int getCurrentToolHitValue(){
        return arms.get(selectedIndexArms).getHitValue();
    }

    public Arms getCurrentItem() {
        return arms.get(selectedIndexArms);
    }

    public int getSelectedIndexArms() {
        return selectedIndexArms;
    }

    public HashMap<Integer, Arms> getArms() {
        return arms;
    }

    public ArrayDeque<FirstAid> getItems() {
        return items;
    }

    public void applyFirstAid(GameEngine gameEngine) {
        if(items.isEmpty() != true){
            FirstAid firstAid = items.pop();
            gameEngine.getScene().getActorsByName("player").incrementHealth(firstAid.getRepairHealthsValue());
            gameEngine.getCameraSystem().applyFirstAid();
        }
    }

}
