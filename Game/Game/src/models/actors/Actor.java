package models.actors;

import models.Position;

public class Actor {
    protected String name;
    protected Position position;
    protected Character icon;
    protected int level;
    protected int health;
    protected int damage;
    protected LiveValue liveValue;
    public enum LiveValue {
        LIVE,
        DEAD
    }

    public void decrementHealth(int damageValue) {
        this.health -= damageValue;
        if (this.health <= 0) {
            this.liveValue = LiveValue.DEAD;
        }
    }

    public void incrementHealth(int repairHealthsValue) {
        this.health += repairHealthsValue;
    }

    public Position getPosition() {
        return position;
    }
    public Character getIcon() {
        return icon;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public LiveValue getLiveValue() {
        return liveValue;
    }

    public String getName() {
        return name;
    }

}
