package models.entities;

import models.Position;

public class Brick extends Entity {
    public Brick(Position position) {
        this.name = "Brick";
        this.position = position;
        this.icon = '#';
        this.level = 0;
    }
}
