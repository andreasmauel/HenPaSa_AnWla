package equipment.armor;

import util.Attribute;

public class NoArmor extends Armor{
    public NoArmor(Attribute attribute, float price, float weigth, int requiredStrength, int armorClass, String drawback) {
        super(Attribute.NOATTRIBUTE, 0, 0, 0, 0, "no");
    }
}
