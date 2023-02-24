package Artifact;

public class InvisiblePotion extends Potion{

    public InvisiblePotion(int charges){
        super(charges);

    }

    public int use() {
        player.setisVisible = true;
    }
}
