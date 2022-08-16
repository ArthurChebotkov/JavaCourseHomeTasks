package model.items;

import model.Position;

public class Brick extends Item {
    public Brick(Position position) {
        this.name = "Brick";
        this.position = position;
        this.icon = '#';
    }
}
