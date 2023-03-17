package equipment.weapon;

import GameController.dices.DiceFour;
import util.Attribute;

public class Dagger extends Weapon{

    public Dagger() {
        //TODO Würfel später hinzufügen bzw damage
        super(Attribute.DEXTERITY,2,1,0,new DiceFour(),true,2,true);
    }
    protected void draw() {

    }

    protected void prepare() {

    }

    protected void aim() {

    }



    protected void holster() {

    }
}
