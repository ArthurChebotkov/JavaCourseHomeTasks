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

    public Position lookUp() {
        return new Position(this.x-1,this.y);
    }
    public Position lookDown() {
        return new Position(this.x+1,this.y);
    }
    public Position lookLeft() {
        return new Position(this.x,this.y-1);
    }
    public Position lookRight() {
        return new Position(this.x,this.y+1);
    }

}
