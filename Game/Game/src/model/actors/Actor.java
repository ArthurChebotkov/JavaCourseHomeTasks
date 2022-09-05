package model.actors;

import model.Position;

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

    public void decrementHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.liveValue = LiveValue.DEAD;
        }
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
