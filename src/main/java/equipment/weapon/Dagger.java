package equipment.weapon;

import equipment.Attribute;

public class Dagger extends Weapon{

    public Dagger() {
        //TODO Würfel später hinzufügen bzw damage
        setAttribute(Attribute.STRENGTH);
        setMultiAttackAllowed(false);
        setPrice(2);
        setWeigth(1);
        setRange(1);
        setThrowable(false);
        setRequiredStrength(0);

    }
    protected void draw() {

    }

    protected void prepare() {

    }

    protected void aim() {

    }

    protected void strike() {

    }

    protected void holster() {

    }
}
