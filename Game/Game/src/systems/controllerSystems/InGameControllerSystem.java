package systems.controllerSystems;

import engine.GameEngine;
import models.actors.Actor;
import models.actors.KillerPlayer;
import models.actors.Player;
import models.arms.Arms;

public class InGameControllerSystem implements ControllerSystem{
    private GameEngine gameEngine;
    public InGameControllerSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
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
                gameEngine.setGameState(gameEngine.getInventoryState());
                break;
            case "§":
                if(gameEngine.getInventoryModel().getCurrentItem().getUsageStatus() == Arms.usageValue.NOT_BROKEN) {
                    gameEngine.getCollisionSystem().playerHit();
                }
                break;
            case "e":
                gameEngine.getCollisionSystem().pickUpItem();
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
