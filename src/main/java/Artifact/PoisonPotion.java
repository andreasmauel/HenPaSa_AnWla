package Artifact;

import Characters.Player;

public class PoisonPotion extends  Potion{

    public PoisonPotion(int charges) {
        super(charges);

    }
    public int use(Player player) {
        return player.getLifepoints() - 6;
    }
}
