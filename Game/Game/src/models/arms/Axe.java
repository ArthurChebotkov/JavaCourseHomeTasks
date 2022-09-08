package models.arms;

public class Axe extends Arms {
    public Axe() {
        this.name = "AXE";
        this.durability = 10;
        this.hitValue = 1;
        this.usageStatus = usageValue.NOT_BROKEN;
    }
}
