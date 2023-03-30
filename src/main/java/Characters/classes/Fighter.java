package Characters.classes;

import equipment.Equipment;
import util.Attribute;

import java.util.ArrayList;

public class Fighter extends Clazz{
    private Equipment secondaryWeapon;
    private FightingStyle fightingStyle;

    public Fighter( Attribute mainAttribute, Attribute secondMainAttribute, ArrayList<Attribute> savingthrowAttribute, Equipment secondaryWeapon, FightingStyle fightingStyle) {
        super("Fighter",10, 13, mainAttribute, secondMainAttribute, savingthrowAttribute);
        this.secondaryWeapon = secondaryWeapon;
        this.fightingStyle = fightingStyle;

    }


    public void setSecondaryWeapon(Equipment equipment){
        this.secondaryWeapon = equipment;
    }
}
