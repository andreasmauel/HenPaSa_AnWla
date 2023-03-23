package Characters;

import Artifact.Artifact;
import Artifact.IKey;
import Characters.Races.Race;
import Characters.classes.Clazz;

import battlemap.AbstractPositions.TilePos;
import equipment.Equipment;
import equipment.armor.Armor;
import util.Effect;

import java.util.ArrayList;

public class Player extends AbstractCharacter{

    private Clazz clazz;
    private ArrayList<Equipment> inventory;
    public ArrayList<Effect> effects;

    @Override
    public void setLifepoints(int lifepoints) {
        if (lifepoints < clazz.getBaseLifePoints()) {
            this.setLifepoints(lifepoints);
        } else {
            this.setLifepoints(clazz.getBaseLifePoints());
        }
    }

    public Player(String name, int dexterity, int intelligence, int strenght, int constitution, int wisdom,
                  Race race, int walkingrange, int armorClass, Armor currentArmor, boolean isVisible,
                  ViewDirection viewDirection, ArrayList<Effect> effects, Clazz clazz) {
        super(name, dexterity, intelligence, strenght, constitution, wisdom, race, walkingrange, armorClass,
                currentArmor, isVisible, viewDirection, effects);
        this.clazz = clazz;
        this.inventory = inventory;

    }


    public void useArtifact(Artifact artifact){
        artifact.use();
    }

    public void useKey(IKey key){
        key.use();
    }

    public String showInventory(){
        return "0";
    }

    public int calculateMaxLivepoints(){
        return 0;
    }

    @Override
    public void move(int xposition, int yposition, TilePos tilePos) {
        if (tilePos.getMetaData().isPassable()){
            setPosition(xposition, yposition);
        }

    }
}
