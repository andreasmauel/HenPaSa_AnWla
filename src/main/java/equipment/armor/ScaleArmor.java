package equipment.armor;

import util.Attribute;

public class ScaleArmor extends Armor{
    public ScaleArmor(Attribute attribute, float price, float weigth, int requiredStrength, int armorClass, String drawback) {
        super(Attribute.DEXTERITY, 50, 45, 0, armorClass, "no");
    }
}
