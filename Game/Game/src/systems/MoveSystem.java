package systems;

import models.Position;
import scene.Scene;

public class MoveSystem {
    private Scene scene;

    public MoveSystem (Scene scene){
        this.scene = scene;
    }

    public void moveUp(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        entityPosition.setX(entityPosition.getX()-1);
    }
    public void moveDown(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        entityPosition.setX(entityPosition.getX()+1);
    }
    public void moveLeft(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        entityPosition.setY(entityPosition.getY()-1);
    }
    public void moveRight(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        entityPosition.setY(entityPosition.getY()+1);
    }
    public void moveTo(String entityName, int x, int y) {
        scene.getActorsByName(entityName).getPosition().setPosition(x,y);
    }
    public void moveToPosition(String entityName, Position position) {
        scene.getActorsByName(entityName).getPosition().setPosition(position.getX(),position.getY());
    }
    public Position getCurrentPosition(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        return new Position(entityPosition.getX(),entityPosition.getY());
    }
    public Position lookUp(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        return new Position(entityPosition.getX()-1,entityPosition.getY());
    }
    public Position lookDown(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        return new Position(entityPosition.getX()+1,entityPosition.getY());
    }
    public Position lookLeft(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        return new Position(entityPosition.getX(),entityPosition.getY()-1);
    }
    public Position lookRight(String entityName) {
        Position entityPosition = scene.getActorsByName(entityName).getPosition();
        return new Position(entityPosition.getX(),entityPosition.getY()+1);
    }

}
