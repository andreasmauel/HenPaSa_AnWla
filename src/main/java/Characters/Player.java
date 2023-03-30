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
import observer.Observer;
import observer.Subject;
import util.Attribute;
import util.Effect;

import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractCharacter {



    private ArrayList<Equipment> inventory;
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armor;
    private ArrayList<Artifact> artifact;

    private Artifact currentArtifact;

    public Player(String name, int dexterity, int intelligence, int strenght, int constitution, int wisdom,
                  Race race, int walkingrange, int armorClass, Armor currentArmor, boolean isVisible,
                  ViewDirection viewDirection, ArrayList<Effect> effects, Clazz clazz) {
        super(name, dexterity, intelligence, strenght, constitution, wisdom, race, walkingrange, armorClass,
                currentArmor, isVisible, viewDirection, effects, clazz);

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

    public Artifact getCurrentArtifact() {
        return this.currentArtifact;
    }

    public String showInventory(){
        return "0";
    }


    public int calculateMaxLivepoints(){
        return 0;
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
