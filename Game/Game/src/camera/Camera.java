package camera;

import controller.GameController;
import model.MapModel;

import java.util.Scanner;

public class Camera {
    public static final int DEFAULT_WIDTH = 37;
    public static final int DEFAULT_HEIGHT = 14;

    private Character[][] outputScreen;

    private GameController gameController;

    public Camera(GameController gameController) {
        this.gameController = gameController;
        this.outputScreen = new Character[DEFAULT_HEIGHT][DEFAULT_WIDTH];
        this.printTitle();
        this.printMenu();
    }

    public void update(){
        outputScreen = gameController.getMapModel().makeMapCopy();
        outputScreen[gameController.getPlayer().getPosition().getX()][gameController.getPlayer().getPosition().getY()] =
                gameController.getPlayer().getIcon();
        this.draw();
    }

    private void draw() {
        for (int i = 0; i < outputScreen.length; i++) {
            for (int j = 0; j < outputScreen[0].length; j++) {
                System.out.print(outputScreen[i][j]);
            }
            System.out.println();
        }
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
