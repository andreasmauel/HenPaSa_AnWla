package Artifact;

public class Amulet extends Magical{
    public Amulet(){
        super(false);
    }


    public int use() {
        return player.getArmorClass + 2;
    }
}
