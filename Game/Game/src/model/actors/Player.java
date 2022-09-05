package model.actors;

import model.Position;

public class Player extends Actor{

    private int money;

    public Player(Position position) {
        this.position = position;
        this.icon = '@';
        this.level = 1;
        this.money = 0;
        this.health = 10;
        this.name = "Player";
        this.liveValue = LiveValue.LIVE;
        this.damage = 1;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
