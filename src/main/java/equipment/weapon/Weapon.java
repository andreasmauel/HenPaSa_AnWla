package equipment.weapon;

import equipment.Equipment;
import util.Attribute;

public abstract class Weapon extends Equipment {



    private final int  damage;
    private final boolean  multiAttackAllowed;
    private final float  range;
    private final boolean  isThrowable;

    public Weapon(Attribute attribute, float price, float weigth,int requiredStrength,  int damage, boolean multiAttackAllowed, float range, boolean isThrowable) {
        super(attribute,  price,  weigth, requiredStrength);
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


    public void useWeapon() {
         draw();
         prepare();
         aim();
         strike();
         holster();
    }

     protected  abstract void draw();

     protected  abstract void prepare();

     protected  abstract void aim();

     protected  abstract void strike();

     protected  abstract void holster();

}
