package Artifact;

public class Amulet extends Magical{
    public Amulet(){
        super(false);
    }


    public void use() {
        return Player.getArmorClass + 2;
    }
}
