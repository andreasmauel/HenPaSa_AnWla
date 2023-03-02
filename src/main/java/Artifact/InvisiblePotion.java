package Artifact;

import Characters.Player;

public class InvisiblePotion extends Potion{

    public InvisiblePotion(int charges){
        super(charges);

    }

    public void use(Player player) {
        player.setVisible(false);
    }



}
