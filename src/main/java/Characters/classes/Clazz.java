package Characters.classes;

import Characters.Player;
import util.Attribute;

import java.util.ArrayList;

public class Clazz {

    private String className;
    private int baseLifePoints;
    private int baseArmorclass;
    private Attribute mainAttribute;
    private Attribute secondMainAttribute;
    private ArrayList<Attribute> savingthrowAttribute;

    public int getBaseLifePoints() {
        return this.baseLifePoints;
    }

    public int getBaseArmorclass() {
        return this.baseArmorclass;
    }

    public String getClassName() {
        return this.className;
    }

    public Attribute getMainAttribute() {
        return this.mainAttribute;
    }

    public Attribute getSecondMainAttribute() {
        return this.secondMainAttribute;
    }

    public ArrayList<Attribute> getSavingthrowAttribute() {
        return this.savingthrowAttribute;
    }

    public Clazz(String className, int baseLifePoints, int baseArmorclass, Attribute mainAttribute, Attribute secondMainAttribute, ArrayList<Attribute> savingthrowAttribute){
        this.className = className;
        this.baseLifePoints = baseLifePoints;
        this.baseArmorclass = baseArmorclass;
        this.mainAttribute = mainAttribute;
        this.secondMainAttribute = secondMainAttribute;
        this.savingthrowAttribute = savingthrowAttribute;
    }
    public void applyModifiers(Player player) {
        final int MAIN_BONUS = 2;
        final int SECONDARY_BONUS = 1;
        if (this.mainAttribute == Attribute.CONSTITUTION){
            player.setConstitution(player.getConstitution() + MAIN_BONUS);
        } else if (this.mainAttribute == Attribute.DEXTERITY){
            player.setDexterity(player.getDexterity() + MAIN_BONUS);
        } else if (this.mainAttribute == Attribute.INTELLIGENCE){
            player.setIntelligence(player.getIntelligence() + MAIN_BONUS);
        } else if (this.mainAttribute == Attribute.STRENGTH){
            player.setStrength(player.getStrength() + MAIN_BONUS);
        } else if (this.mainAttribute == Attribute.WISDOM){
            player.setWisdom(player.getWisdom() + MAIN_BONUS);
        }
        if (this.getSecondMainAttribute() == Attribute.CONSTITUTION){
            player.setConstitution(player.getConstitution() + SECONDARY_BONUS);
        } else if (this.getSecondMainAttribute() == Attribute.DEXTERITY){
            player.setDexterity(player.getDexterity() + MAIN_BONUS);
        } else if (this.getSecondMainAttribute() == Attribute.INTELLIGENCE){
            player.setIntelligence(player.getIntelligence() + SECONDARY_BONUS);
        } else if (this.getSecondMainAttribute() == Attribute.STRENGTH){
            player.setStrength(player.getStrength() + SECONDARY_BONUS);
        } else if (this.getSecondMainAttribute() == Attribute.WISDOM){
            player.setWisdom(player.getWisdom() + SECONDARY_BONUS);
        }
    }
}
