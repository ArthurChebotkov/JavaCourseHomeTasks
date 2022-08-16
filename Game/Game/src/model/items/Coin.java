package model.items;

import model.Position;

public class Coin extends Item{

    public Coin(Position position) {
        this.name = "Coin";
        this.position = position;
        this.icon = '$';
    }
}
