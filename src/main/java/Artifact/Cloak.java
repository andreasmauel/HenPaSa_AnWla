package Artifact;

public class Cloak extends Magical{

    public Cloak(){
        super(false);
    }

    public void use() {
        Player.setisVisible = true;
    }
}
