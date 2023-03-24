package Characters;

import Characters.Races.Race;
import Characters.classes.Clazz;
import GameController.dices.DiceTwenty;
import GameController.dices.IDice;
import battlemap.Dungeon.Dungeon;
import equipment.armor.Armor;
import equipment.armor.ChainMail;
import equipment.weapon.Weapon;
import util.Attribute;
import util.Effect;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class AbstractCharacter {
    private Clazz clazz;
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
    private IDice diceTwenty = new DiceTwenty();
    private int initiative;
    private int xPosition;
    private int yPosition;


    public int getX() {
        return this.xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public void setxPosition(int xPosition){
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }

    public AbstractCharacter(String name, int desterity, int intelligence, int strenght, int constitution, int wisdom,
                             Race race, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                             ViewDirection viewDirection, ArrayList<Effect> effects, Clazz clazz) {
        this.name = name;
        this.dexterity = desterity;
        this.intelligence = intelligence;
        this.strenght = strenght;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.race = race;
        this.clazz = clazz;
        if(clazz != null) {
            this.lifepoints = clazz.getBaseLifePoints();
        } else{
            this.setLifepoints(20);
        }
        this.walkingrange = walkingrange;
        this.armorClass = armorClass;
        this.currentarmor = currentarmor;
        this.isVisible = isVisible;
        this.viewDirection = viewDirection;
        this.effects = effects;

    }

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

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrenght() {
        return strenght;
    }

    public String getClazzName() {
        return this.clazz.getClassName();
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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getInitiative() {
        return initiative;
    }

    public void rollInitiative() {
        this.initiative = this.diceTwenty.rollDice() + this.modifier(Attribute.DEXTERITY);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        if(currentarmor.equals(ChainMail.class)){
            isVisible = true;
        }
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

    public void attack(AbstractCharacter character){
       int damage = this.weapon.useWeapon();
       character.getDamage(damage);
    }

    public void getDamage(int damage) {
        this.setLifepoints(this.getLifepoints() - damage);
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

    public static class InitiativeComperetor implements Comparator<AbstractCharacter> {
        @Override
        public int compare(AbstractCharacter otherPlayer, AbstractCharacter player) {
            if (otherPlayer.getInitiative() < player.getInitiative()) {
                return -1;
            } else if (otherPlayer.getInitiative() > player.getInitiative()) {
                return 1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
}


