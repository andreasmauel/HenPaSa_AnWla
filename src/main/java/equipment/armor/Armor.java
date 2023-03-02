package equipment.armor;

import equipment.Equipment;
import util.Attribute;

public abstract class Armor extends Equipment {

    private final int armorClass;
    private String drawback;

    public Armor(Attribute attribute, float price, float weigth, int requiredStrength, int armorClass, String drawback) {
        super(attribute, price, weigth, requiredStrength);
        this.armorClass = armorClass;
        this.setDrawback(drawback);
    }

    public int getArmorClass() {
        return armorClass;
    }

    public String getDrawback() {
        return drawback;
    }

    public void setDrawback(String drawback) {
        this.drawback = drawback;
    }


}
