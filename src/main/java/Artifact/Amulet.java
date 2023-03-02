package Artifact;

import Characters.Player;

public class Amulet extends Magical{
    public Amulet(){
        super(false);
    }


      public void use(Player player) {
        player.getArmorClass + 2;
    }
}
