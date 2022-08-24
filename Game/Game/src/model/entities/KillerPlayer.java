package model.entities;

import model.Position;

public class KillerPlayer extends Entity{
    public int health;

    public KillerPlayer(Position position) {
        this.position = position;
        this.icon = 'K';
        this.level = 1;
        this.health = 5;
    }
}
