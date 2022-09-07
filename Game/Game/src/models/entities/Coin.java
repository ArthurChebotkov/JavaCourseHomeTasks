package models.entities;

import models.Position;

public class Coin extends Entity {

    private int valueCoin;
    public Coin(Position position) {
        this.name = "Coin";
        this.position = position;
        this.icon = '$';
        this.level = 1;
        this.valueCoin = 1;
    }

    public int getValueCoin() {
        return valueCoin;
    }
}
