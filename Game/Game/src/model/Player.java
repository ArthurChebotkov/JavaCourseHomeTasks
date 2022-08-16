package model;

public class Player {
    private Position position;
    private Character icon;

    public Player(Position position) {
        this.position = position;
        this.icon = '@';
    }

    public Position getPosition() {
        return position;
    }

    public Character getIcon() {
        return icon;
    }
}
