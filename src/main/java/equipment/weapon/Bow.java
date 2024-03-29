package equipment.weapon;

import GameController.dices.DiceEight;
import util.Attribute;

public class Bow extends RangeWeapon {


    public Bow() {
        super(Attribute.DEXTERITY, 15, 2, 13, new DiceEight(), false, 6, false);
        this.setAmmo(20);
    }

    @Override
    protected void draw() {
        super.draw();
    }

    @Override
    protected void prepare() {
        super.prepare();
    }

    @Override
    protected void aim() {
        super.aim();
    }

    @Override
    protected void holster() {
        super.holster();
    }
}
