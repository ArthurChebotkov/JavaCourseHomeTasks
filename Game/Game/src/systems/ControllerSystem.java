package systems;

import engine.GameEngine;
import model.actors.Actor;
import model.actors.KillerPlayer;
import model.actors.Player;

public class ControllerSystem {
    private GameEngine gameEngine;
    public ControllerSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void update(String event) {
        Player player = (Player)gameEngine.getScene().getActorsByName("player");
        KillerPlayer killerPlayer = (KillerPlayer)gameEngine.getScene().getActorsByName("killerPlayer");

        if(killerPlayer.getLiveValue() == Actor.LiveValue.LIVE) {
            execute("killerPlayer", killerPlayer.getEvent(gameEngine));
        }

        execute("player",event);
        if(player.getLiveValue() == Actor.LiveValue.DEAD) {
            gameEngine.setRunning(false);
            gameEngine.getCameraSystem().printPlayerDead();
        }
    }

    public void execute (String entityName, String event) {
        switch (event) {
            case "w":
                if(gameEngine.getCollisionSystem().hasCollisionWithWall(gameEngine.getMoveSystem().lookUp(entityName))) {
                    gameEngine.getMoveSystem().moveUp(entityName);
                }
                break;
            case "s":
                if(gameEngine.getCollisionSystem().hasCollisionWithWall(gameEngine.getMoveSystem().lookDown(entityName))) {
                    gameEngine.getMoveSystem().moveDown(entityName);
                }
                break;
            case "a":
                if(gameEngine.getCollisionSystem().hasCollisionWithWall(gameEngine.getMoveSystem().lookLeft(entityName))) {
                    gameEngine.getMoveSystem().moveLeft(entityName);
                }
                break;
            case "d":
                if(gameEngine.getCollisionSystem().hasCollisionWithWall(gameEngine.getMoveSystem().lookRight(entityName))) {
                    gameEngine.getMoveSystem().moveRight(entityName);
                }
                break;
            case "i":
                gameEngine.getCameraSystem().printToolsInformation();
                break;
            case "1":
                gameEngine.getInventoryModel().setSelectedItem(0);
                gameEngine.getCameraSystem().printToolsInformation();
                break;
            case "2":
                gameEngine.getInventoryModel().setSelectedItem(1);
                gameEngine.getCameraSystem().printToolsInformation();
                break;
            case "§":
                gameEngine.getCollisionSystem().playerHit();
                break;
            case "q":
                gameEngine.setRunning(false);
                gameEngine.getCameraSystem().printQuit();
                break;
            default:
                break;
        }

        if(gameEngine.isRunning() == true && entityName == "player") {
            gameEngine.getCollisionSystem().update(gameEngine.getMoveSystem().getCurrentPosition(entityName));
        }

    }
}
