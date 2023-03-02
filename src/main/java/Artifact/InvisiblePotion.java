package Artifact;

import Characters.Player;

public class InvisiblePotion extends Potion{

    public InvisiblePotion(int charges){
        super(charges);

    }

    @Override
    public void use(Player player) {
        player.setisVisible = true;

    }



}
