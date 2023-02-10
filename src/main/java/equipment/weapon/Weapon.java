package equipment.weapon;

import equipment.Equipment;

public abstract class Weapon extends Equipment {

    private int damage;
    private boolean multiAttackAllowed;
    private float range;
    private boolean isThrowable;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isMultiAttackAllowed() {
        return multiAttackAllowed;
    }

    public void setMultiAttackAllowed(boolean multiAttackAllowed) {
        this.multiAttackAllowed = multiAttackAllowed;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public boolean isThrowable() {
        return isThrowable;
    }

    public void setThrowable(boolean throwable) {
        isThrowable = throwable;
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
