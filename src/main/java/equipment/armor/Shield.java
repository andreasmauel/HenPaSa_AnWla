package equipment.armor;

import util.Attribute;

public class Shield extends Armor {
    public Shield(Attribute attribute, float price, float weigth, int requiredStrength, int armorClass, String drawback) {
        super(Attribute.NOATTRIBUTE, 0, 6, 0, 2, "no");
    }
}
