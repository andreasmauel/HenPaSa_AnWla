package Characters;

import Mocks.Armor;
import Mocks.Weapon;

import java.util.ArrayList;

public abstract class AbstractCharacter {
    private String name;
    private int desterity;
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

    public AbstractCharacter(String name, int desterity, int intelligence, int strenght, int constitution, int wisdom,
                             Race race, int lifepoints, int walkingrange, int armorClass, Armor currentarmor, boolean isVisible,
                             ViewDirection viewDirection,ArrayList<Effect> effects) {
        this.name = name;
        this.desterity = desterity;
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
    // TODO getter Setter noch schreiben

    public int attack(){
        return 0;
    }

    public void move(){

    }

    public void changeWeapon(Weapon weapon){
        this.weapon = weapon;
    }

}
