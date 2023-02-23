package Artifact;

public class InvisiblePotion extends Potion{

    public InvisiblePotion(int charges){
        super(charges);

    }

    public void use() {
        player.setisVisible = true;
    }
}
