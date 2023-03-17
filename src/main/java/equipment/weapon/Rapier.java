package equipment.weapon;

import GameController.dices.DiceEight;
import util.Attribute;

public class Rapier extends Weapon {

    public Rapier() {
        super(Attribute.DEXTERITY,25,2,0,new DiceEight(),false,1,false);
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
