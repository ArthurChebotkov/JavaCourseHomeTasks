package controller;

import model.Position;

public class Command {
    private GameController gameController;
    public Command(GameController gameController) {
        this.gameController = gameController;
    }

    public void execute(String event) {
        switch (event) {
            case "w":
                if(gameController.getMapModel().hasCollision(gameController.getPlayer().getPosition().lookUp())) {
                    gameController.getPlayer().getPosition().moveUp();
                }
                break;
            case "s":
                if(gameController.getMapModel().hasCollision(gameController.getPlayer().getPosition().lookDown())) {
                    gameController.getPlayer().getPosition().moveDown();
                }
                break;
            case "a":
                if(gameController.getMapModel().hasCollision(gameController.getPlayer().getPosition().lookLeft())) {
                    gameController.getPlayer().getPosition().moveLeft();
                }
                break;
            case "d":
                if(gameController.getMapModel().hasCollision(gameController.getPlayer().getPosition().lookRight())) {
                    gameController.getPlayer().getPosition().moveRight();
                }
                break;
            case "q":
                gameController.setRunning(false);
                System.out.println("\nQuitting");
                break;
            default:
                break;
        }
    }
}
