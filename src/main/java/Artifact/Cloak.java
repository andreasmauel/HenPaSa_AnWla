package Artifact;

import Characters.Player;

public class Cloak extends Magical{

    public Cloak(){
        super(false);
    }

    public void use(Player player) {
        player.setisVisible = true;
    }
}
