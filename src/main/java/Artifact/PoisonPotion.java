package Artifact;

public class PoisonPotion extends  Potion{

    public PoisonPotion(int charges) {
        super(charges);
    }
    public int use() {
        return player.getlifePoints - 6;
    }
}
