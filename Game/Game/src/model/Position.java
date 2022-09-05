package model;

public class Position {
    //Number of line
    private int x;

    //Number of element in line
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean equals(Position position) {
        if (this.x == position.getX() && this.y == position.getY()){
            return true;
        }
        return false;
    }
    public boolean reachToPosition(Position position) {
        if (this.x == position.getX()+1 && this.y == position.getY()){
            return true;
        }
        if (this.x == position.getX()-1 && this.y == position.getY()){
            return true;
        }
        if (this.x == position.getX() && this.y == position.getY()+1){
            return true;
        }
        if (this.x == position.getX() && this.y == position.getY()-1){
            return true;
        }
        return false;
    }

}
