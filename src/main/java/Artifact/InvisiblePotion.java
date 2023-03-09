package Artifact;

import Characters.AbstractCharacter;
import Characters.Player;

public class InvisiblePotion extends Potion{

    public InvisiblePotion(int charges){
        super(charges);

    }

    public void use(AbstractCharacter player) {
        player.setVisible(false);
    }



}
