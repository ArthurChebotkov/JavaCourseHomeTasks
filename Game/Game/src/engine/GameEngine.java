package engine;

import models.InventoryModel;
import models.gameStates.GameState;
import models.gameStates.InGameState;
import models.gameStates.InventoryState;
import scene.Scene;
import systems.CameraSystem;
import systems.CollisionSystem;
import systems.MoveSystem;
import systems.controllerSystems.InGameControllerSystem;
import systems.controllerSystems.InventoryControllerSystem;

import java.io.IOException;
import java.util.Scanner;

public class GameEngine {

    public final String pathToFileLevelTerrain = "Game/resources/map-level-0.txt";
    public final String pathToFileLevelItems = "Game/resources/map-level-1.txt";

    private Scene scene;
    private CameraSystem cameraSystem;
    private MoveSystem moveSystem;
    private CollisionSystem collisionSystem;
    private InventoryModel inventoryModel;

    private GameState gameState;
    private InGameState inGameState;
    private InventoryState inventoryState;
//    private ControllerSystem controllerSystem;
    private InGameControllerSystem inGameControllerSystem;
    private InventoryControllerSystem inventoryControllerSystem;

    private boolean running;

    public GameEngine() throws IOException {
        this.scene = new Scene(pathToFileLevelTerrain,pathToFileLevelItems);
        this.running = true;
        this.cameraSystem = new CameraSystem(this);
        this.inGameControllerSystem = new InGameControllerSystem(this);
        this.inventoryControllerSystem = new InventoryControllerSystem(this);
        this.moveSystem = new MoveSystem(this.scene);
        this.collisionSystem = new CollisionSystem(this);
        this.inventoryModel = new InventoryModel();
        this.inGameState = new InGameState(this);
        this.inventoryState = new InventoryState(this);

        this.gameState = inGameState;
//        this.controllerSystem = inGameControllerSystem;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (running) {
            gameState.execute();
        }
    }

    public Scene getScene() {
        return scene;
    }
    public InventoryModel getInventoryModel() {
        return inventoryModel;
    }
    public CameraSystem getCameraSystem() {
        return cameraSystem;
    }
    public boolean isRunning() {
        return running;
    }
    public MoveSystem getMoveSystem() {
        return moveSystem;
    }
    public CollisionSystem getCollisionSystem() {
        return collisionSystem;
    }
    public void setRunning(boolean running){ this.running = running; }


    public void setGameState(GameState gameState) { this.gameState = gameState; }

    public InGameState getInGameState() {
        return inGameState;
    }

    public InventoryState getInventoryState() {
        return inventoryState;
    }

    public GameState getGameState() {
        return gameState;
    }

//    public void setControllerSystem(ControllerSystem controllerSystem) { this.controllerSystem = controllerSystem; }

    public InGameControllerSystem getInGameControllerSystem() {
        return inGameControllerSystem;
    }

    public InventoryControllerSystem getInventoryControllerSystem() {
        return inventoryControllerSystem;
    }
}
