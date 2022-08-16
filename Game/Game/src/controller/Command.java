package controller;

public class Command {
    private GameController gameController;
    public Command(GameController gameController) {
        this.gameController = gameController;
    }

    public void execute(String event) {
        switch (event) {
            case "w":
                gameController.getPlayer().getPosition().moveUp();
                break;
            case "s":
                gameController.getPlayer().getPosition().moveDown();
                break;
            case "a":
                gameController.getPlayer().getPosition().moveLeft();
                break;
            case "d":
                gameController.getPlayer().getPosition().moveRight();
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
