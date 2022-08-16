package controller;

import camera.Camera;
import model.Player;
import model.MapModel;
import model.Position;

import java.io.IOException;
import java.util.Scanner;

public class GameController {

    public static final int DEFAULT_START_POSITION_X = 5;
    public static final int DEFAULT_START_POSITION_Y = 5;

    private MapModel mapModel;
    private Player player;
    private Camera camera;
    private Command command;


    private boolean running;

    public GameController() throws IOException {
        this.mapModel = new MapModel("Game/resources/map.txt");
        this.player = new Player(new Position(DEFAULT_START_POSITION_X,DEFAULT_START_POSITION_Y));
        this.running = true;
        this.camera = new Camera(this);
        this.command = new Command(this);
    }

    public GameController(Player player, MapModel mapModel) {
        this.mapModel = mapModel;
        this.player = player;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (running) {
            camera.update();
            System.out.print("Enter the command: ");
            String event = sc.next();
            command.execute(event);
        }
    }

    public MapModel getMapModel() {
        return mapModel;
    }
    public Player getPlayer() {
        return player;
    }

    public void setRunning(boolean running){ this.running = running; }
}
