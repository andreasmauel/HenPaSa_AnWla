package Characters;

import Characters.Races.Race;

import equipment.armor.Armor;
import equipment.weapon.Weapon;
import util.Effect;

import java.util.ArrayList;

public class Monster extends AbstractCharacter{

    private ArrayList<Effect> effects;

    public Monster(int id, String name, int dexterity, int intelligence, int strength, int constitution, int wisdom,
                   Race race, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                   ViewDirection viewDirection, Weapon weapon){
        super(id, name, dexterity, intelligence, strength, constitution, wisdom,
        race, walkingrange, armorClass, currentarmor, isVisible,
        viewDirection, null, weapon );
        if (id < 4) {
            throw new RuntimeException("Monster Id must be greater than 4");
        }
        this.setMaxLifePoints(20);
    }


}
