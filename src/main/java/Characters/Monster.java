package Characters;

import Characters.Races.Race;
import Mocks.Armor;

import java.util.ArrayList;

public class Monster extends AbstractCharacter{
    public Monster(String name, int dexterity, int intelligence, int strenght, int constitution, int wisdom,
                   Race race, int lifepoints, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                   ViewDirection viewDirection, ArrayList<Effect> effects){
        super(name, dexterity, intelligence, strenght, constitution, wisdom, race, lifepoints, walkingrange, armorClass,
                currentarmor, isVisible, viewDirection, effects);
    }

    @Override
    public int attack(){
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}