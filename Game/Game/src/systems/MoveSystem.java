package systems;

import engine.GameEngine;
import model.Position;

public class MoveSystem {
    private GameEngine gameEngine;

    public MoveSystem (GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    public void moveUp() {
        gameEngine.getPlayer().position.setX(gameEngine.getPlayer().position.getX()-1);
    }

    public void moveDown() {
        gameEngine.getPlayer().position.setX(gameEngine.getPlayer().position.getX()+1);
    }

    public void moveLeft() {
        gameEngine.getPlayer().position.setY(gameEngine.getPlayer().position.getY()-1);
    }

    public void moveRight() {
        gameEngine.getPlayer().position.setY(gameEngine.getPlayer().position.getY()+1);
    }

    public void moveTo(int x, int y) {
        gameEngine.getPlayer().position.setPosition(x,y);
    }

    public void moveToPosition(Position position) {
        gameEngine.getPlayer().position.setPosition(position.getX(),position.getY());
    }

    public Position getCurrentPosition() {
        return new Position(gameEngine.getPlayer().position.getX(),gameEngine.getPlayer().position.getY());
    }

    public Position lookUp() {
        return new Position(gameEngine.getPlayer().position.getX()-1,gameEngine.getPlayer().position.getY());
    }
    public Position lookDown() {
        return new Position(gameEngine.getPlayer().position.getX()+1,gameEngine.getPlayer().position.getY());
    }
    public Position lookLeft() {
        return new Position(gameEngine.getPlayer().position.getX(),gameEngine.getPlayer().position.getY()-1);
    }
    public Position lookRight() {
        return new Position(gameEngine.getPlayer().position.getX(),gameEngine.getPlayer().position.getY()+1);
    }


}
