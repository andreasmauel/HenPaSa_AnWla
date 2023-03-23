package Characters.classes;

import util.Attribute;

import java.util.ArrayList;

public class Thief extends Clazz{
    private boolean isSneaking;

    public Thief(int baseArmorclass, Attribute mainAttribute, Attribute secondMainAttribute, ArrayList<Attribute> savingthrowAttribute) {
        super(8, 10, mainAttribute, secondMainAttribute, savingthrowAttribute);
        this.isSneaking = false;
    }

    public void steal(){

    }

    public void sneak(){

    }
    public void lockPicking(){

    }
}
