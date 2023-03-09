package Characters;

import Characters.Races.Race;
import GameController.DiceTwenty;
import GameController.FightController;
import GameController.IDice;
import equipment.armor.Armor;
import equipment.weapon.Weapon;
import util.Attribute;
import util.Effect;

import java.util.ArrayList;

public abstract class AbstractCharacter implements Comparable {
    private String name;
    private int dexterity;
    private int intelligence;
    private int strenght;
    private int constitution;
    private int wisdom;
    private Race race;
    private int lifepoints;
    private int walkingrange;
    private int armorClass;
    private Weapon weapon;
    private Armor currentarmor;
    private boolean isVisible;
    private ViewDirection viewDirection;
    private ArrayList<Effect> effects;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    IDice dice = new DiceTwenty();

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getLifepoints() {
        return lifepoints;
    }

    public void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }

    public int getWalkingrange() {
        return walkingrange;
    }

    public void setWalkingrange(int walkingrange) {
        this.walkingrange = walkingrange;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getCurrentarmor() {
        return currentarmor;
    }

    public void setCurrentarmor(Armor currentarmor) {
        this.currentarmor = currentarmor;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public ViewDirection getViewDirection() {
        return viewDirection;
    }

    public void setViewDirection(ViewDirection viewDirection) {
        this.viewDirection = viewDirection;
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public void setEffects(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public AbstractCharacter(String name, int desterity, int intelligence, int strenght, int constitution, int wisdom,
                             Race race, int lifepoints, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                             ViewDirection viewDirection, ArrayList<Effect> effects) {
        this.name = name;
        this.dexterity = desterity;
        this.intelligence = intelligence;
        this.strenght = strenght;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.race = race;
        this.lifepoints = lifepoints;
        this.walkingrange = walkingrange;
        this.armorClass = armorClass;
        this.currentarmor = currentarmor;
        this.isVisible = isVisible;
        this.viewDirection = viewDirection;
        this.effects = effects;
    }

    public int attack(Player player){
        //ToDo: player actions implementieren
        return 0;
    }

    public void move(){

    }

    public void changeWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public int modifier(util.Attribute attribute){
        switch (attribute){
            case WISDOM:
                return (getWisdom()-10)/2;

            case CONSTITUTION:
                return (getConstitution()-10)/2;

            case DEXTERITY:
                return (getDexterity()-10)/2;

            case STRENGTH:
                return (getStrenght()-10)/2;

            case INTELLIGENCE:
                return (getIntelligence()-10)/2;

            default:
        }

        return 0;
    }

    public int compareInitiative(Player player){
        if(this.compareInitiative((Player) this) < compareTo(player) + modifier(Attribute.DEXTERITY)) {

        } else if (this.compareInitiative((Player) this) < compareTo(player) + modifier(Attribute.DEXTERITY)) {
            return player.getDexterity();
        }
        return 1;
    }

    @Override
    public int compareTo(Object o) {
        return dice.rollDice() ;
    }
}


