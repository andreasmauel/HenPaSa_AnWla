package Characters;

import Characters.Races.Race;

import equipment.armor.Armor;
import equipment.weapon.Weapon;
import util.Effect;

import java.util.ArrayList;

public class Monster extends AbstractCharacter{

    private ArrayList<Effect> effects;

    public Monster(String name, int dexterity, int intelligence, int strength, int constitution, int wisdom,
                   Race race, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                   ViewDirection viewDirection, ArrayList<Effect> effects, Weapon weapon){
        super(name, dexterity, intelligence, strength, constitution, wisdom,
        race, walkingrange, armorClass, currentarmor, isVisible,
        viewDirection, effects, null, weapon );
        this.setMaxLifePoints(20);
    }


}
