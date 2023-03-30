package Characters.classes;

import org.w3c.dom.Attr;
import util.Attribute;

import java.util.ArrayList;

public class Clazz {

    private String className;
    private int baseLifePoints;
    private int baseArmorclass;
    private Attribute mainAttribute;
    private Attribute secondMainAttribute;
    private ArrayList<Attribute> savingthrowAttribute;

    public int getBaseLifePoints() {
        return this.baseLifePoints;
    }

    public int getBaseArmorclass() {
        return this.baseArmorclass;
    }

    public String getClassName() {
        return this.className;
    }

    public Attribute getMainAttribute() {
        return this.mainAttribute;
    }

    public Attribute getSecondMainAttribute() {
        return this.secondMainAttribute;
    }

    public ArrayList<Attribute> getSavingthrowAttribute() {
        return this.savingthrowAttribute;
    }

    public Clazz(String className, int baseLifePoints, int baseArmorclass, Attribute mainAttribute, Attribute secondMainAttribute, ArrayList<Attribute> savingthrowAttribute){
        this.className = className;
        this.baseLifePoints = baseLifePoints;
        this.baseArmorclass = baseArmorclass;
        this.mainAttribute = mainAttribute;
        this.secondMainAttribute = secondMainAttribute;
        this.savingthrowAttribute = savingthrowAttribute;
    }
}
