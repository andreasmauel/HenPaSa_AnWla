package Artifact;

import Characters.AbstractCharacter;
import Characters.Player;

public class Amulet extends Magical{
    public Amulet(){
        super(false);
    }



      public void use(AbstractCharacter player) {
        player.setArmorClass(player.getArmorClass() + 2);
    }

}
