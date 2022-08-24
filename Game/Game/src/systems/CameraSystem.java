package systems;

import engine.GameEngine;
import model.entities.Coin;
import model.entities.Teleport;
import model.entities.Thorn;

public class CameraSystem {
    public static final int DEFAULT_WIDTH = 37;
    public static final int DEFAULT_HEIGHT = 14;

    private Character[][] outputScreen;


    private GameEngine gameEngine;

    public CameraSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.outputScreen = new Character[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        this.printTitle();
        this.printMenu();
    }


    public void update(){
        outputScreen = gameEngine.getScene().getMapModel().copy();

        for(Coin coin : gameEngine.getScene().getCoins()) {
            outputScreen[coin.position.getX()][coin.position.getY()] = coin.icon;
        }

        for(Teleport teleport:gameEngine.getScene().getTeleports()) {
            outputScreen[teleport.position.getX()][teleport.position.getY()] = teleport.icon;
        }

        for(Thorn thorn:gameEngine.getScene().getThorns()) {
            outputScreen[thorn.position.getX()][thorn.position.getY()] = thorn.icon;
        }

        outputScreen[gameEngine.getPlayer().position.getX()][gameEngine.getPlayer().position.getY()] =
                gameEngine.getPlayer().icon;

        this.draw();
    }

    private void draw() {
        for (int i = 0; i < outputScreen.length; i++) {
            for (int j = 0; j < outputScreen[0].length; j++) {
                System.out.print(outputScreen[i][j]);
            }
            System.out.println();
        }
        System.out.println("Coins: " + gameEngine.getPlayer().money);
        System.out.println("Healts: " + gameEngine.getPlayer().health);
    }
    public void printTitle(){
        System.out.println("" +
                "╔═══╗╔══╗╔╗──╔╗╔═══╗\n" +
                "║╔══╝║╔╗║║║──║║║╔══╝\n" +
                "║║╔═╗║╚╝║║╚╗╔╝║║╚══╗\n" +
                "║║╚╗║║╔╗║║╔╗╔╗║║╔══╝\n" +
                "║╚═╝║║║║║║║╚╝║║║╚══╗\n" +
                "╚═══╝╚╝╚╝╚╝──╚╝╚═══╝\n");
    }

    public void printMenu(){
        System.out.println("MENU:");
        System.out.println("(w) - Press to Move Up");
        System.out.println("(s) - Press toMove Down");
        System.out.println("(a) - Press toMove Left");
        System.out.println("(d) - Press to Move Right");
        System.out.println("(q) - Press to Quit Game\n");
    }
}
