package equipment.weapon;

import GameController.dices.IDice;
import util.Attribute;

public class RangeWeapon extends Weapon {

    private int ammo;

    public RangeWeapon(Attribute attribute, float price, float weigth, int requiredStrength, IDice dice, boolean multiAttackAllowed, float range, boolean isThrowable) {
        super(attribute,  price,  weigth, requiredStrength, dice, multiAttackAllowed,range, isThrowable);

    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
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
    protected void holster() {

    }
}
