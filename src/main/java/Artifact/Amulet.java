package Artifact;

import Characters.Player;

public class Amulet extends Magical{
    public Amulet(){
        super(false);
    }



      public int use(Player player) {return player.getArmorClass() + 2;
    }
}
