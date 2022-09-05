package model.actors;

import engine.GameEngine;
import model.Position;

public class KillerPlayer extends Actor {
    public int direction;
    public KillerPlayer(Position position) {
        this.position = position;
        this.icon = 'K';
        this.level = 1;
        this.health = 10;
        this.name = "KillerPlayer";
        this.direction = 0;
        this.damage = 2;
        this.liveValue = LiveValue.LIVE;
    }

    public String getEvent(GameEngine gameEngine) {
        String killerEvent = null;
        switch (this.direction){
            case 0:
                if (gameEngine.getCollisionSystem().hasCollisionWithWall(gameEngine.getMoveSystem().lookUp("killerPlayer"))){
                    killerEvent = "w";
                    return killerEvent;
                }
                else {
                    this.direction = 1;
                    killerEvent ="s";
                    return killerEvent;
                }
            case 1:
                if (gameEngine.getCollisionSystem().hasCollisionWithWall(gameEngine.getMoveSystem().lookDown("killerPlayer"))){
                    killerEvent = "s";
                    return killerEvent;
                }
                else {
                    this.direction = 0;
                    killerEvent ="w";
                    return killerEvent;
                }
            default:
                return killerEvent;
        }
    }

}
