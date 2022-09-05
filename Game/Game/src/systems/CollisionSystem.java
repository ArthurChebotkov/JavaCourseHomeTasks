package systems;

import engine.GameEngine;
import model.Position;
import model.actors.Actor;
import model.actors.KillerPlayer;
import model.actors.Player;
import model.entities.Coin;
import model.entities.Entity;
import model.entities.Thorn;

public class CollisionSystem {
    private GameEngine gameEngine;

    public CollisionSystem(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }


    public void update(Position position) {
        Player player = (Player) (gameEngine.getScene().getActorsByName("player"));

        for (int i = 0; i < gameEngine.getScene().getItemsByName("coins").size(); i++) {
            if (position.equals(gameEngine.getScene().getItemsByName("coins").get(i).getPosition())) {
                Coin coin = (Coin) gameEngine.getScene().getItemsByName("coins").get(i);
                player.setMoney(player.getMoney()+coin.getValueCoin());
                gameEngine.getScene().getItemsByName("coins").remove(i);
                break;
            }
        }
        int numberOfTargetTeleport = 0;
        for (int i = 0; i < gameEngine.getScene().getItemsByName("teleports").size(); i++) {
            if (position.equals(gameEngine.getScene().getItemsByName("teleports").get(i).getPosition())) {
                numberOfTargetTeleport = gameEngine.getScene().getItemsByName("teleports").size() - i - 1;
                gameEngine.getMoveSystem().moveToPosition("player", gameEngine.getScene().getItemsByName("teleports").get(numberOfTargetTeleport).getPosition());
                break;
            }
        }

        for (int i = 0; i < gameEngine.getScene().getItemsByName("thorns").size(); i++) {
            if (position.equals(gameEngine.getScene().getItemsByName("thorns").get(i).getPosition())) {
                Thorn thorn = (Thorn) (gameEngine.getScene().getItemsByName("thorns").get(i));
                player.decrementHealth(thorn.getDamage());
                break;
            }
        }

        KillerPlayer killerPlayer = (KillerPlayer) (gameEngine.getScene().getActorsByName("killerPlayer"));
        if(gameEngine.getScene().getActorsByName("killerPlayer").getLiveValue() == Actor.LiveValue.LIVE) {
            if(position.equals(killerPlayer.getPosition())){
                player.decrementHealth(killerPlayer.getDamage());
            }
        }
    }

    public boolean hasCollisionWithWall(Position target) {
        for (Entity brick : gameEngine.getScene().getTerrainByName("wall")) {
            if (target.equals(brick.getPosition())) {
                return false;
            }
        }
        return true;
    }

    public void playerHit() {
        KillerPlayer killerPlayer = (KillerPlayer) (gameEngine.getScene().getActorsByName("killerPlayer"));
        if (killerPlayer.getLiveValue() == Actor.LiveValue.LIVE) {
            if (gameEngine.getScene().getActorsByName("player").getPosition().reachToPosition(killerPlayer.getPosition())) {
                killerPlayer.decrementHealth(gameEngine.getInventoryModel().getCurrentToolHitValue());
            }
        }
    }
}

