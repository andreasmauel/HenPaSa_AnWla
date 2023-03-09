package Artifact;

import Characters.AbstractCharacter;
import Characters.Player;

public class Amulet extends Magical{
    public Amulet(){
        super(false);
    }



      public int use(AbstractCharacter player) {return player.getArmorClass() + 2;
    }
}
