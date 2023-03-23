package Characters.classes;

import org.w3c.dom.Attr;
import util.Attribute;

import java.util.ArrayList;

public class Clazz {
    private int baseLifePoints;
    private int baseArmorclass;
    private Attribute mainAttribute;
    private Attribute secondMainAttribute;
    private ArrayList<Attribute> savingthrowAttribute;

    public int getBaseLifePoints() {
        return baseLifePoints;
    }

    public int getBaseArmorclass() {
        return baseArmorclass;
    }

    public Attribute getMainAttribute() {
        return mainAttribute;
    }

    public Attribute getSecondMainAttribute() {
        return secondMainAttribute;
    }

    public ArrayList<Attribute> getSavingthrowAttribute() {
        return savingthrowAttribute;
    }

    public Clazz(int baseLifePoints, int baseArmorclass, Attribute mainAttribute, Attribute secondMainAttribute, ArrayList<Attribute> savingthrowAttribute){
        this.baseLifePoints = baseLifePoints;
        this.baseArmorclass = baseArmorclass;
        this.mainAttribute = mainAttribute;
        this.secondMainAttribute = secondMainAttribute;
        this.savingthrowAttribute = savingthrowAttribute;
    }
}
