package Artifact;

public class HealingPotion extends Potion{

    public HealingPotion(int charges){
        super(charges);
    }
    public int use() {
        return player.getlifePoints() + (2 * GameController.dice4()) + 2;
    }
}
