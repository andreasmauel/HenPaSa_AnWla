package Artifact;

public class HealingPotion extends Potion{

    public HealingPotion(int charges){
        super(charges);
    }
    public void use() {
        return Player.getlifePoints() + (2 * GameController.dice4()) + 2;
    }
}
