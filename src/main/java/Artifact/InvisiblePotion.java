package Artifact;

public class InvisiblePotion extends Potion{

    public InvisiblePotion(int charges){
        this.setCharges(charges);
    }

    public void use() {
        Player.setVisible = true;
    }
}
