package systems;

import engine.GameEngine;
import models.Position;

public class MoveSystem {
    private GameEngine gameEngine;

    public MoveSystem (GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    public void moveUp(String entityName) {
        gameEngine.getScene().getActorsByName(entityName).getPosition().setX(gameEngine.getScene().getActorsByName(entityName).getPosition().getX()-1);
    }
    public void moveDown(String entityName) {
        gameEngine.getScene().getActorsByName(entityName).getPosition().setX(gameEngine.getScene().getActorsByName(entityName).getPosition().getX()+1);
    }
    public void moveLeft(String entityName) {
        gameEngine.getScene().getActorsByName(entityName).getPosition().setY(gameEngine.getScene().getActorsByName(entityName).getPosition().getY()-1);
    }
    public void moveRight(String entityName) {
        gameEngine.getScene().getActorsByName(entityName).getPosition().setY(gameEngine.getScene().getActorsByName(entityName).getPosition().getY()+1);
    }
    public void moveTo(String entityName, int x, int y) {
        gameEngine.getScene().getActorsByName(entityName).getPosition().setPosition(x,y);
    }
    public void moveToPosition(String entityName, Position position) {
        gameEngine.getScene().getActorsByName(entityName).getPosition().setPosition(position.getX(),position.getY());
    }
    public Position getCurrentPosition(String entityName) {
        return new Position(gameEngine.getScene().getActorsByName(entityName).getPosition().getX(),gameEngine.getScene().getActorsByName(entityName).getPosition().getY());
    }
    public Position lookUp(String entityName) {
        return new Position(gameEngine.getScene().getActorsByName(entityName).getPosition().getX()-1,gameEngine.getScene().getActorsByName(entityName).getPosition().getY());
    }
    public Position lookDown(String entityName) {
        return new Position(gameEngine.getScene().getActorsByName(entityName).getPosition().getX()+1,gameEngine.getScene().getActorsByName(entityName).getPosition().getY());
    }
    public Position lookLeft(String entityName) {
        return new Position(gameEngine.getScene().getActorsByName(entityName).getPosition().getX(),gameEngine.getScene().getActorsByName(entityName).getPosition().getY()-1);
    }
    public Position lookRight(String entityName) {
        return new Position(gameEngine.getScene().getActorsByName(entityName).getPosition().getX(),gameEngine.getScene().getActorsByName(entityName).getPosition().getY()+1);
    }


}
