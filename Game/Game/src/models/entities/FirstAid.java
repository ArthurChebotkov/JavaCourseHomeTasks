package models.entities;

import models.Position;

public class FirstAid extends Entity{

    private int repairHealthsValue;

    public FirstAid(Position position) {
        this.name = "FIRST AID";
        this.icon = '+';
        this.level = 1;
        this.repairHealthsValue = 5;
        this.position = position;
    }

    public int getRepairHealthsValue() {
        return repairHealthsValue;
    }
}
