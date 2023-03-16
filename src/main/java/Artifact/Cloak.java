package Artifact;

import Characters.AbstractCharacter;

public class Cloak extends Magical{

    public Cloak(){
        super(false);
    }

    public void use(AbstractCharacter player) {
        player.setVisible(false);
    }
}
