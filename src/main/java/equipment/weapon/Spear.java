package equipment.weapon;

import GameController.dices.DiceSix;
import util.Attribute;

public class Spear extends Weapon {

    public Spear() {
        super(Attribute.NOATTRIBUTE,2,3,0,new DiceSix(),false,2,false);
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
