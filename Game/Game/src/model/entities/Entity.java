package model.entities;

import model.Position;

public class Entity {
    protected String name;
    protected Position position;
    protected Character icon;
    protected int level;

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Character getIcon() {
        return icon;
    }

    public int getLevel() {
        return level;
    }
}
