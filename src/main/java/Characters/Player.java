package Characters;

import Artifact.Artifact;
import Characters.Races.Race;
import Characters.classes.Clazz;

import equipment.Equipment;
import equipment.armor.Armor;
import equipment.armor.NoArmor;
import equipment.weapon.BattleAxe;
import equipment.weapon.Dagger;
import equipment.weapon.Weapon;
import util.Attribute;
import util.Effect;

import java.util.ArrayList;

public class Player extends AbstractCharacter {



    private ArrayList<Equipment> inventory;
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armor;
    private ArrayList<Artifact> artifact;

    private Artifact currentArtifact;

    public Player(String name, int dexterity, int intelligence, int strength, int constitution, int wisdom,
                  Race race, int walkingrange, int armorClass, Armor currentArmor, boolean isVisible,
                  ViewDirection viewDirection, ArrayList<Effect> effects, Clazz clazz) {
        super(name, dexterity, intelligence, strength, constitution, wisdom, race, walkingrange, armorClass,
                currentArmor, isVisible, viewDirection, effects, clazz);

        this.getClazz().applyModifiers(this);
        this.inventory = inventory;
        this.weapons = new ArrayList<>();
        this.weapons.add(new Dagger());
        this.weapons.add(new BattleAxe());
        this.armor = new ArrayList<>();
        this.armor.add(new NoArmor());
        this.artifact = new ArrayList<>();


    }


    public void useArtifact(){

        this.currentArtifact.use(this);
    }

    public void setCurrentArtifact(Artifact artifact) {
        this.currentArtifact = artifact;
    }

    public String showInventory(){
        return "0";
    }



    public int calculateMaxLivepoints(){
        return getClazz().getBaseLifePoints() + (modifier(Attribute.CONSTITUTION)-10)/2;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmor() {
        return armor;
    }

    public ArrayList<Artifact> getArtifact() {
        return artifact;
    }


}
