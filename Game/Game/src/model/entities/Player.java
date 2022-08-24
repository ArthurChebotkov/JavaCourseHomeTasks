package model.entities;

import model.Position;

public class Player extends Entity {

    public int money;
    public int health;

    public Player(Position position) {
        this.position = position;
        this.icon = '@';
        this.level = 1;
        this.money = 0;
        this.health = 5;
    }

}
