package equipment.weapon;

import GameController.dices.DiceSix;
import util.Attribute;

public class HandAxe extends Weapon {

    public HandAxe() {
        //TODO Damage
        super(Attribute.NOATTRIBUTE,5,2,0,new DiceSix(),true,2,true);
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
