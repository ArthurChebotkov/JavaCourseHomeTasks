package models.entities;

import models.Position;

public class Teleport extends Entity {
    public Teleport(Position position) {
        this.name = "Teleport";
        this.position = position;
        this.icon = 't';
        this.level = 1;
    }
}
