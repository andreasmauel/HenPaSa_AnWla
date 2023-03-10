package Artifact;

import Characters.AbstractCharacter;
import Characters.Player;

public class PoisonPotion extends  Potion{

    public PoisonPotion(int charges) {
        super(charges);
    }
    public int use(AbstractCharacter player) {
        return player.getLifepoints() - 6;
    }
}
