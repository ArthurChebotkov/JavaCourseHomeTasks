package model.entities;

import model.Position;

public class Coin extends Entity {

    public Coin(Position position) {
        this.name = "Coin";
        this.position = position;
        this.icon = '$';
        this.level = 1;
    }
}
