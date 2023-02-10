package Artifact;

public class PoisonPotion extends  Potion{

    public PoisonPotion(int charges) {
        this.setCharges(charges);
    }
    public void use() {
        return Player.getlifePoints - 6;
    }
}
