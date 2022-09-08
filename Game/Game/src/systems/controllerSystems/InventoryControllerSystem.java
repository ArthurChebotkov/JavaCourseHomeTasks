package systems.controllerSystems;

import engine.GameEngine;

public class InventoryControllerSystem implements ControllerSystem{
    private GameEngine gameEngine;
    public InventoryControllerSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void update(String event) {
        execute(event);
    }

    public void execute (String event) {
        switch (event) {
            case "i":
                gameEngine.setGameState(gameEngine.getInGameState());
                break;
            case "1":
                gameEngine.getInventoryModel().setSelectedIndexArms(0);
                break;
            case "2":
                gameEngine.getInventoryModel().setSelectedIndexArms(1);
                break;
            case "e":
                gameEngine.getInventoryModel().applyFirstAid(gameEngine);
                break;
            case "q":
                gameEngine.setRunning(false);
                gameEngine.getCameraSystem().printQuit();
                break;
            default:
                break;
        }
    }
}
