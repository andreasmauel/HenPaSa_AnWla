package equipment.weapon;

import Characters.AbstractCharacter;
import Characters.Monster;
import equipment.Equipment;
import util.Attribute;

public abstract class Weapon extends Equipment {

    private final int damage;
    private final boolean multiAttackAllowed;
    private final float range;
    private final boolean isThrowable;

    public Weapon(Attribute attribute, float price, float weigth, int requiredStrength, int damage, boolean multiAttackAllowed, float range, boolean isThrowable) {
        super(attribute, price, weigth, requiredStrength);
        this.damage = damage;
        this.multiAttackAllowed = multiAttackAllowed;
        this.range = range;
        this.isThrowable = isThrowable;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isMultiAttackAllowed() {
        return multiAttackAllowed;
    }

    public float getRange() {
        return range;
    }

    public boolean isThrowable() {
        return isThrowable;
    }


    public int useWeapon() {

        draw();
        prepare();
        aim();
        int damage = strike();
        holster();
        return damage;
    }

    protected abstract void draw();

    protected abstract void prepare();

    protected abstract void aim();

    protected int strike() {
        return this.getDamage();
    }

    protected abstract void holster();

}
