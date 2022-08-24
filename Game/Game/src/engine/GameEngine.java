package engine;

import systems.CollisionSystem;
import systems.ControllerSystem;
import systems.MoveSystem;
import systems.CameraSystem;
import model.entities.Player;
import model.Position;
import scene.Scene;

import java.io.IOException;
import java.util.Scanner;

public class GameEngine {

    public final int DEFAULT_START_POSITION_X = 5;
    public final int DEFAULT_START_POSITION_Y = 10;
    public final String pathToFileLevel0 = "Game/resources/map-level-0.txt";
    public final String pathToFileLevel1 = "Game/resources/map-level-1.txt";

    private Scene scene;
    private Player player;
    private CameraSystem cameraSystem;
    private ControllerSystem controllerSystem;
    private MoveSystem moveSystem;
    private CollisionSystem collisionSystem;


    private boolean running;

    public GameEngine() throws IOException {
        this.scene = new Scene(pathToFileLevel0,pathToFileLevel1);
        this.player = new Player(new Position(DEFAULT_START_POSITION_X, DEFAULT_START_POSITION_Y));
        this.running = true;
        this.cameraSystem = new CameraSystem(this);
        this.controllerSystem = new ControllerSystem(this);
        this.moveSystem = new MoveSystem(this);
        this.collisionSystem = new CollisionSystem(this);
    }

    public GameEngine(Player player, Scene scene) {
        this.scene = scene;
        this.player = player;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (running) {
            cameraSystem.update();
            System.out.print("Enter the command: ");
            String event = sc.next();
            controllerSystem.update(event);
        }
    }

    public Scene getScene() {
        return scene;
    }
    public Player getPlayer() {
        return player;
    }
    public MoveSystem getMoveSystem() {
        return moveSystem;
    }

    public CollisionSystem getCollisionSystem() {
        return collisionSystem;
    }

    public void setRunning(boolean running){ this.running = running; }
}
