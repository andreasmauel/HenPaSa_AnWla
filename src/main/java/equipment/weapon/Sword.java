package equipment.weapon;

import GameController.dices.DiceEight;
import util.Attribute;

public class Sword extends Weapon{

    public Sword() {
        super(Attribute.STRENGTH,15,3,13,new DiceEight(),false,1,false);
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
