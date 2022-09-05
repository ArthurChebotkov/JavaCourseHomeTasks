package model.entities;

import model.Position;

public class Thorn extends Entity {
    private int damage;
    public Thorn(Position position) {
        this.name = "thorn";
        this.position = position;
        this.icon = 's';
        this.level = 1;
        this.damage = 1;
    }

    public int getDamage() {
        return damage;
    }
}
