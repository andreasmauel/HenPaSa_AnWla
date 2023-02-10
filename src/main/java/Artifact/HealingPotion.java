package Artifact;

public class HealingPotion extends Potion{

    public HealingPotion(int charges){
        this.setCharges(charges);
    }
    public void use() {
        return Player.getlifePoints() + (2 * GameController.dice4()) + 2;
    }
}
