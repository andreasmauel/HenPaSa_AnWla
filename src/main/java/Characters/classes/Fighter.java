package Characters.classes;

import equipment.Equipment;

public class Fighter extends Clazz{
    private Equipment secundaryWeapon;
    private FightingStyle fightingStyle;

    public void setSecundaryWeapon(Equipment equipment){
        this.secundaryWeapon = equipment;
    }
}
