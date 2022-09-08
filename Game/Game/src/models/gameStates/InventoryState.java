package models.gameStates;

import engine.GameEngine;

import java.util.Scanner;

public class InventoryState implements GameState{

    GameEngine gameEngine;
    public InventoryState(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void execute(){
        Scanner sc = new Scanner(System.in);
        gameEngine.getCameraSystem().printArmsInformation();
        gameEngine.getCameraSystem().printItemsInformation();
        System.out.print("\nEnter the command: ");
        String event = sc.next();
        gameEngine.getInventoryControllerSystem().update(event);
    }
}
