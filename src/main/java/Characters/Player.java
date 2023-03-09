package Characters;

import Characters.Races.Race;
import Characters.classes.Clazz;
import GameController.DiceTwenty;
import GameController.IDice;
import equipment.Equipment;
import equipment.armor.Armor;
import util.Attribute;
import util.Effect;

import java.util.ArrayList;

public class Player extends AbstractCharacter{

    private Clazz clazz;
    private ArrayList<Equipment> inventory;
    public ArrayList<Effect> effects;


    public Player(String name, int dexterity, int intelligence, int strenght, int constitution, int wisdom,
                  Race race, int lifepoints, int walkingrange, int armorClass, Armor currentArmor, boolean isVisible,
                  ViewDirection viewDirection, Clazz clazz, ArrayList<Effect> effects) {
        super(name, dexterity, intelligence, strenght, constitution, wisdom, race, lifepoints, walkingrange, armorClass,
                currentArmor, isVisible, viewDirection, effects);
        this.clazz = clazz;
        this.inventory = inventory;
    }


    public void useArtifact(){

    }

    public String showInventory(){
        return "0";
    }

    public int calculateMaxLivepoints(){
        return 0;
    }

}
