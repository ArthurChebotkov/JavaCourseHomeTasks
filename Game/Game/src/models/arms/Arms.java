package models.arms;

public class Arms {
    protected String name;
    protected int durability;
    protected int hitValue;

    protected usageValue usageStatus;

    public enum usageValue {
        UNUSED,
        NOT_BROKEN,
        BROKEN
    }

    public String getName() {return this.name;}

    public void decrementValue() {
        durability--;
        if (durability <= 0) {
            usageStatus = usageValue.BROKEN;
        }
    }

    public int getValue() { return durability; }

    public int getHitValue() {
        return hitValue;
    }

    public usageValue getUsageStatus() {
        return usageStatus;
    }
}
