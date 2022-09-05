package model.tools;

public class Tools {
    protected String name;
    protected int durability;
    protected int hitValue;

    public enum usageValue {
        UNUSED,
        NOT_BROKEN,
        BROKEN
    }

    public String getName() {return this.name;}

    public usageValue decrementValue() {
        durability--;
        if (durability <= 0) return usageValue.BROKEN;
        return usageValue.NOT_BROKEN;
    }

    public int getValue() { return durability; }

    public int getHitValue() {
        return hitValue;
    }
}
