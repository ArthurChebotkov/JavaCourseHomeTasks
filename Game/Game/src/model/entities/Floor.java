package model.entities;

import model.Position;

public class Floor extends Entity {
    public Floor(Position position) {
        this.name = "Floor";
        this.position = position;
        this.icon = '.';
        this.level = 0;
    }
}
