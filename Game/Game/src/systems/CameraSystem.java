package systems;

import engine.GameEngine;
import model.actors.Actor;
import model.actors.Player;
import model.entities.Entity;

import javax.swing.text.PlainDocument;
import java.util.ArrayList;

public class CameraSystem {
    private static final int DEFAULT_WIDTH = 37;
    private static final int DEFAULT_HEIGHT = 14;

    private Character[][] outputScreen;


    private GameEngine gameEngine;

    public CameraSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.outputScreen = new Character[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        this.printTitle();
        this.printInstructions();
    }

    public void update() {
        outputScreen = gameEngine.getScene().getMapModel().copy();

        for (ArrayList<Entity> entities : gameEngine.getScene().getItemsArrayList()) {
            for (Entity entity : entities) {
                outputScreen[entity.getPosition().getX()][entity.getPosition().getY()] = entity.getIcon();
            }
        }

        gameEngine.getScene().getActors().forEach((k,v) -> {
            if(v.getLiveValue() == Actor.LiveValue.LIVE) {
                outputScreen[v.getPosition().getX()][v.getPosition().getY()] = v.getIcon();
            }
        });

        this.draw();
    }

    private void draw() {
        for (int i = 0; i < outputScreen.length; i++) {
            for (int j = 0; j < outputScreen[0].length; j++) {
                System.out.print(outputScreen[i][j]);
            }
            System.out.println();
        }

        Player player = (Player) gameEngine.getScene().getActorsByName("player");
        System.out.println("Coins: " + player.getMoney());
        System.out.println("Health: " + player.getHealth());

        if(gameEngine.getScene().getActorsByName("killerPlayer").getLiveValue() == Actor.LiveValue.LIVE) {
            System.out.println("Killer health: " + gameEngine.getScene().getActorsByName("killerPlayer").getHealth());
        }
    }

    public void printTitle() {
        System.out.println("" +
                "╔═╗ ╔╗ ╔╦╗ ╔═\n" +
                "║╔╗ ╠╣ ║║║ ╠═\n" +
                "╚═╝ ║║ ║║║ ╚═\n");

    }

    public void printInstructions() {
        System.out.println("Instructions:");
        System.out.println("(w) - Press to Move Up");
        System.out.println("(s) - Press to Move Down");
        System.out.println("(a) - Press to Move Left");
        System.out.println("(d) - Press to Move Right");
        System.out.println("(§) - Press to Attack");
        System.out.println("(i) - Press to see stuff information");
        System.out.println("(1) - Press to choose Axe");
        System.out.println("(2) - Press to choose Pickaxe");
        System.out.println("(q) - Press to Quit Game\n");
    }

    public void printToolsInformation() {
        String[] selectedItems = new String[2];

        if (gameEngine.getInventoryModel().selectedIndex == 0) {
            selectedItems[0] = " <--";
            selectedItems[1] = "";
        } else {
            selectedItems[0] = "";
            selectedItems[1] = " <--";
        }

        for (int i = 0; i < gameEngine.getInventoryModel().items.size(); i++) {
            System.out.print(gameEngine.getInventoryModel().items.get(i).getName()
                    + " " + gameEngine.getInventoryModel().items.get(i).getValue());
            System.out.println(selectedItems[i]);
        }

    }

    public void printQuit() {
        System.out.println("\nQuitting");
    }

    public void printPlayerDead() {
        System.out.println("\nHealts: " + gameEngine.getScene().getActorsByName("player").getHealth() + ". Player id dead!");
    }

}
