package Characters;

import Characters.Races.Race;
import Characters.classes.Clazz;
import GameController.DiceTwenty;
import GameController.IDice;
import Mocks.Armor;
import equipment.Equipment;

import java.util.ArrayList;

public class Player extends AbstractCharacter{

    private Clazz clazz;
    private ArrayList<Equipment> inventory;
    private IDice dice = new DiceTwenty() {
    }

    public Player(String name, int dexterity, int intelligence, int strenght, int constitution, int wisdom,
                  Race race, int lifepoints, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                  ViewDirection viewDirection, ArrayList<Effect> effects, Clazz clazz, ArrayList<Equipment> inventory) {
        super(name, dexterity, intelligence, strenght, constitution, wisdom, race, lifepoints, walkingrange, armorClass,
                currentarmor, isVisible, viewDirection, effects);
        this.clazz = clazz;
        this.inventory = inventory;
    }

    public void useArtifact(){

    }

    public String showInventory(){
        return "0";
    }

    @Override
    public int attack(){
        return 0;
    }

    public int calculateMaxLivepoints(){
        return 0;
    }

    public int modifier(util.Attribute attribute){

        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
