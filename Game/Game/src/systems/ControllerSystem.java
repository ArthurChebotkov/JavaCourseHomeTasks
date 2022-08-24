package systems;

import engine.GameEngine;

public class ControllerSystem {
    private GameEngine gameEngine;
    public ControllerSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void update(String event) {
        switch (event) {
            case "w":
                if(gameEngine.getCollisionSystem().hasCollision(gameEngine.getMoveSystem().lookUp())) {
                    gameEngine.getMoveSystem().moveUp();
                    gameEngine.getCollisionSystem().update(gameEngine.getMoveSystem().getCurrentPosition());
                }
                break;
            case "s":
                if(gameEngine.getCollisionSystem().hasCollision(gameEngine.getMoveSystem().lookDown())) {
                    gameEngine.getMoveSystem().moveDown();
                    gameEngine.getCollisionSystem().update(gameEngine.getMoveSystem().getCurrentPosition());
                }
                break;
            case "a":
                if(gameEngine.getCollisionSystem().hasCollision(gameEngine.getMoveSystem().lookLeft())) {
                    gameEngine.getMoveSystem().moveLeft();
                    gameEngine.getCollisionSystem().update(gameEngine.getMoveSystem().getCurrentPosition());
                }
                break;
            case "d":
                if(gameEngine.getCollisionSystem().hasCollision(gameEngine.getMoveSystem().lookRight())) {
                    gameEngine.getMoveSystem().moveRight();
                    gameEngine.getCollisionSystem().update(gameEngine.getMoveSystem().getCurrentPosition());
                }
                break;
            case "q":
                gameEngine.setRunning(false);
                System.out.println("\nQuitting");
                break;
            default:
                break;
        }
    }
}
