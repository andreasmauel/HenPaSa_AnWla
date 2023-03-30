package Artifact;

import Characters.AbstractCharacter;
import Characters.Player;
import util.Effect;

public class PoisonPotion extends  Potion{

    public PoisonPotion(int charges) {
        super(charges);
    }
    @Override
    public void use(AbstractCharacter player) {
        player.setHealDamage(player.getCurrentLifepoints() - 6, Effect.DAMAGE);
    }
}
