package engine;

import models.InventoryModel;
import systems.CollisionSystem;
import systems.ControllerSystem;
import systems.MoveSystem;
import systems.CameraSystem;
import scene.Scene;

import java.io.IOException;
import java.util.Scanner;

public class GameEngine {

    public final String pathToFileLevelTerrain = "Game/resources/map-level-0.txt";
    public final String pathToFileLevelItems = "Game/resources/map-level-1.txt";

    private Scene scene;
    private CameraSystem cameraSystem;
    private ControllerSystem controllerSystem;
    private MoveSystem moveSystem;
    private CollisionSystem collisionSystem;
    private InventoryModel inventoryModel;
    private boolean running;

    public GameEngine() throws IOException {
        this.scene = new Scene(pathToFileLevelTerrain,pathToFileLevelItems);
        this.running = true;
        this.cameraSystem = new CameraSystem(this);
        this.controllerSystem = new ControllerSystem(this);
        this.moveSystem = new MoveSystem(this);
        this.collisionSystem = new CollisionSystem(this);
        this.inventoryModel = new InventoryModel();
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (running) {
            cameraSystem.update();
            System.out.print("\nEnter the command: ");
            String event = sc.next();
            controllerSystem.update(event);
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

}
