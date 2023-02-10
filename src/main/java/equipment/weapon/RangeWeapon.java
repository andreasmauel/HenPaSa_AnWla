package equipment.weapon;

import util.Attribute;

public class RangeWeapon extends Weapon {

    public RangeWeapon(Attribute attribute, float price, float weigth, int requiredStrength, int damage, boolean multiAttackAllowed, float range, boolean isThrowable) {
        super(attribute,  price,  weigth, requiredStrength, damage, multiAttackAllowed,range, isThrowable);

    }

    @Override
    protected void draw() {

    }

    @Override
    protected void prepare() {

    }

    @Override
    protected void aim() {

    }

    @Override
    protected void strike() {

    }

    @Override
    protected void holster() {

    }
}
