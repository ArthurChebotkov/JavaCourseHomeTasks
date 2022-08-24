package systems;

import engine.GameEngine;
import model.Position;
import model.entities.Brick;
import model.entities.Coin;

public class CollisionSystem {
    private GameEngine gameEngine;

    public CollisionSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public boolean hasCollision(Position target) {
        for (Brick brick : gameEngine.getScene().getWall()) {
            if (target.equals(brick.position)) {
                return false;
            }
        }
        return true;
    }

    public void update(Position position) {
        for(int i=0; i < gameEngine.getScene().getCoins().size(); i++) {
            if (position.equals(gameEngine.getScene().getCoins().get(i).position)) {
                gameEngine.getPlayer().money += 1;
                gameEngine.getScene().getCoins().remove(i);
                break;
            }
        }
        int numberOfTargetTeleport = 0;
        for(int i=0; i < gameEngine.getScene().getTeleports().size(); i++) {
            if (position.equals(gameEngine.getScene().getTeleports().get(i).position)) {
                numberOfTargetTeleport = gameEngine.getScene().getTeleports().size()-i-1;
                gameEngine.getMoveSystem().moveToPosition(gameEngine.getScene().getTeleports().get(numberOfTargetTeleport).position);
                break;
            }
        }

        for(int i=0; i < gameEngine.getScene().getThorns().size(); i++) {
            if (position.equals(gameEngine.getScene().getThorns().get(i).position)) {
                gameEngine.getPlayer().health -= gameEngine.getScene().getThorns().get(i).getDamage();
                break;
            }
        }

    }
}

