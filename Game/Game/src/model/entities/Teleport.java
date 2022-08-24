package model.entities;

import model.Position;

public class Teleport extends Entity {
    public Teleport(Position position) {
        this.position = position;
        this.icon = 't';
        this.level = 1;
    }
}
