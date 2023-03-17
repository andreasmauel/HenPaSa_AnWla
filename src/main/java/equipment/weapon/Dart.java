package equipment.weapon;

import GameController.dices.DiceFour;
import util.Attribute;

public class Dart extends RangeWeapon{


    public Dart() {
        super(Attribute.DEXTERITY, 0.1F, 0.25F, 0, new DiceFour(), false, 2, false);
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
