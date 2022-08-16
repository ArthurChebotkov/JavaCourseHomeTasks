package model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void moveUp() {
        this.x--;
    }

    public void moveDown() {
        this.x++;
    }

    public void moveLeft() {
        this.y--;
    }

    public void moveRight() {
        this.y++;
    }

}
