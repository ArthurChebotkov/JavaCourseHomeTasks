package models.gameStates;

import engine.GameEngine;

import java.util.Scanner;

public class InGameState implements GameState{

    private GameEngine gameEngine;

    public InGameState(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void execute(){
        Scanner sc = new Scanner(System.in);
        gameEngine.getCameraSystem().update();
        System.out.print("\nEnter the command: ");
        String event = sc.next();
        gameEngine.getInGameControllerSystem().update(event);
    }
}
