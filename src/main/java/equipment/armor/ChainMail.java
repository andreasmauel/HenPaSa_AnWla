package equipment.armor;

import util.Attribute;

public class ChainMail  extends Armor{
    public ChainMail(Attribute attribute, float price, float weigth, int requiredStrength, int armorClass, String drawback) {
        super(Attribute.NOATTRIBUTE, 75, 55, 13, 6, "Stealth");
    }
}
