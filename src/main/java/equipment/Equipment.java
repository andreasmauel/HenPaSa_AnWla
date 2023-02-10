package equipment;

import util.Attribute;

public abstract class Equipment {

    private final Attribute attribute;
    private final float price;
    private final float weigth;
    private final int requiredStrength;

    public Equipment(Attribute attribute, float price, float weigth, int requiredStrength) {
        this.attribute = attribute;
        this.price = price;
        this.weigth = weigth;
        this.requiredStrength = requiredStrength;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public float getPrice() {
        return price;
    }

    public float getWeigth() {
        return weigth;
    }

    public int getRequiredStrength() {
        return requiredStrength;
    }
}
