package Characters.classes;

import equipment.Equipment;
import util.Attribute;

import java.util.ArrayList;

public class Fighter extends Clazz{
    private Equipment secundaryWeapon;
    private FightingStyle fightingStyle;

    public Fighter(int baseArmorclass, Attribute mainAttribute, Attribute secondMainAttribute, ArrayList<Attribute> savingthrowAttribute, Equipment secundaryWeapon, FightingStyle fightingStyle) {
        super("Fighter",10, baseArmorclass, mainAttribute, secondMainAttribute, savingthrowAttribute);
        this.secundaryWeapon = secundaryWeapon;
        this.fightingStyle = fightingStyle;

    }


    public void setSecundaryWeapon(Equipment equipment){
        this.secundaryWeapon = equipment;
    }
}
