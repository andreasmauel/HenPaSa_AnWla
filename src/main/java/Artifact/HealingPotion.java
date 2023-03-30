package Artifact;

import Characters.AbstractCharacter;
import GameController.dices.DiceFour;
import util.Effect;

public class HealingPotion extends Potion{

    public HealingPotion(int charges){
        super(charges);
    }

    @Override
    public void use(AbstractCharacter player) {
        DiceFour dice = new DiceFour();
        player.setHealDamage(player.getCurrentLifepoints() + dice.rollDice() + dice.rollDice() + 2, Effect.HEAL);

    }
}
