package Characters;

import Characters.Races.Race;

import equipment.armor.Armor;
import util.Effect;

import java.util.ArrayList;

public class Monster extends AbstractCharacter{

    private ArrayList<Effect> effects;

    public Monster(String name, int dexterity, int intelligence, int strenght, int constitution, int wisdom,
                   Race race, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                   ViewDirection viewDirection, ArrayList<Effect> effects){
        super(name, dexterity, intelligence, strenght, constitution, wisdom,
        race, walkingrange, armorClass, currentarmor, isVisible,
        viewDirection, effects, null);
        setLifepoints(20);
    }

    @Override
    public void setLifepoints(int lifepoints) {
        super.setLifepoints(lifepoints);
    }
}
