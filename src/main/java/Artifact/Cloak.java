package Artifact;

public class Cloak extends Magical{

    public Cloak(){
        super(false);
    }

    public int use() {
        player.setisVisible = true;
        return 0;
    }
}
