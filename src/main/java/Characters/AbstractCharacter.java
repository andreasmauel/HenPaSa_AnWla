package Characters;

import Characters.Races.Race;
import Characters.classes.Clazz;
import GameController.dices.DiceTwenty;
import GameController.dices.IDice;
import equipment.armor.Armor;
import equipment.armor.ChainMail;
import equipment.weapon.Weapon;
import observer.Observer;
import observer.Subject;
import util.Attribute;
import util.Effect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractCharacter implements Subject {
    private Clazz clazz;
    private String name;
    private int dexterity;
    private int intelligence;
    private int strength;
    private int constitution;
    private int wisdom;
    private Race race;
    private int currentLifepoints;
    private int maxLifePoints;
    private int walkingrange;
    private int armorClass;
    private Weapon currentWeapon;
    private Armor currentarmor;
    private boolean isVisible;
    private ViewDirection viewDirection;
    private ArrayList<Effect> effects;
    private IDice diceTwenty = new DiceTwenty();
    private int initiative;
    private int xPosition;
    private int yPosition;

    private List<Observer> observer = new ArrayList<>();


    public AbstractCharacter(String name, int desterity, int intelligence, int strenght, int constitution, int wisdom,
                             Race race, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                             ViewDirection viewDirection, ArrayList<Effect> effects, Clazz clazz) {
        this.name = name;
        this.dexterity = desterity;
        this.intelligence = intelligence;
        this.strength = strenght;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.race = race;
        this.clazz = clazz;
        if (clazz != null) {
            this.maxLifePoints = clazz.getBaseLifePoints();
        } else {
            this.setMaxLifePoints(20);
        }
        this.currentLifepoints = this.maxLifePoints;
        this.walkingrange = walkingrange;
        this.armorClass = armorClass;
        this.currentarmor = currentarmor;
        this.isVisible = isVisible;
        this.viewDirection = viewDirection;
        this.effects = effects;

    }


    public void addObserver(Observer observer) {
        this.observer.add(observer);
    }


    public void removeObserver(Observer observer) {
        this.observer.remove(observer);
    }


    public void notifyObserver() {
        for (Observer observer : this.observer) {
            observer.update();
        }
    }


    public int getX() {
        return this.xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObserver();
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void addEffect(Effect effect) {
        this.effects.add(effect);
        notifyObserver();
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        if (dexterity > 20) {
            this.dexterity = 20;
        }
        this.dexterity = dexterity;
        notifyObserver();
    }

    IDice dice = new DiceTwenty();

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence > 20) {
            this.intelligence = 20;
        }
        this.intelligence = intelligence;
        notifyObserver();
    }

    public int getStrength() {
        return strength;
    }

    public String getClazzName() {
        return this.clazz.getClassName();
    }

    public void setStrength(int strength) {
        if (strength > 20) {
            this.strength = 20;
        }
        this.strength = strength;
        notifyObserver();
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        if (constitution > 20) {
            this.constitution = 20;
        }
        this.constitution = constitution;
        notifyObserver();
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        if (wisdom > 20) {
            this.wisdom = 20;
        }
        this.wisdom = wisdom;
        notifyObserver();
    }

    public Race getRace() {
        return race;
    }

    public String getRaceName() {
        return this.getRace().getClass().getSimpleName();
    }

    public void setRace(Race race) {
        this.race = race;
        race.applyModifier(this);
        notifyObserver();
    }

    public int getCurrentLifepoints() {
        return this.currentLifepoints;
    }

    public int getMaxLifePoints() {
        return this.maxLifePoints;
    }

    public void setHealDamage(int lifepoints, Effect effect) {

        if (this.currentLifepoints - lifepoints <= 0 && effect == Effect.DAMAGE) {
            this.currentLifepoints = 0;
        } else if (this.currentLifepoints + lifepoints >= this.maxLifePoints && effect == Effect.HEAL) {
            this.currentLifepoints = maxLifePoints;
        } else if (effect == Effect.DAMAGE) {
            this.currentLifepoints = this.currentLifepoints - lifepoints;
        } else {
            this.currentLifepoints = +lifepoints;
        }
        notifyObserver();
    }

    public void setMaxLifePoints(int lifepoints) {
        this.maxLifePoints = lifepoints;
    }

    public int getWalkingrange() {
        return walkingrange;
    }

    public void setWalkingrange(int walkingrange) {
        this.walkingrange = walkingrange;
        notifyObserver();
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
        notifyObserver();
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public Armor getCurrentarmor() {
        return currentarmor;
    }

    public void setCurrentarmor(Armor currentarmor) {
        this.currentarmor = currentarmor;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
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
        if (currentarmor.equals(ChainMail.class)) {
            isVisible = true;
        } else {
            isVisible = visible;
        }
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
        notifyObserver();
    }

    public void attack(AbstractCharacter character) {
        int damage = this.currentWeapon.useWeapon();
        character.getDamage(damage);
    }

    public void getDamage(int damage) {
        this.setHealDamage(damage, Effect.DAMAGE);
    }


    public int modifier(util.Attribute attribute) {
        switch (attribute) {
            case WISDOM:
                return (getWisdom() - 10) / 2;

            case CONSTITUTION:
                return (getConstitution() - 10) / 2;

            case DEXTERITY:
                return (getDexterity() - 10) / 2;

            case STRENGTH:
                return (getStrength() - 10) / 2;

            case INTELLIGENCE:
                return (getIntelligence() - 10) / 2;

            default:
        }

        return 0;
    }

    public static class InitiativeComparator implements Comparator<AbstractCharacter> {
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


