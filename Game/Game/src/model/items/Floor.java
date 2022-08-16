package model.items;

import model.Position;

public class Floor extends Item{
    public Floor(Position position) {
        this.name = "Floor";
        this.position = position;
        this.icon = '.';
    }
}
