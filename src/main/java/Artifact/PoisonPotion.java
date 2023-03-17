package Artifact;

import Characters.AbstractCharacter;
import Characters.Player;

public class PoisonPotion extends  Potion{

    public PoisonPotion(int charges) {
        super(charges);
    }
    public void use(AbstractCharacter player) {
        player.setLifepoints(player.getLifepoints() - 6);
    }
}
