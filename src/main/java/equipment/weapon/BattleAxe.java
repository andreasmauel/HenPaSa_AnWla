package equipment.weapon;

import GameController.dices.DiceSix;
import util.Attribute;

public class BattleAxe extends Weapon{
    public BattleAxe() {
        //TODO damage
        super(Attribute.STRENGTH,10,4,0, new DiceSix(),false,1,false);
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
