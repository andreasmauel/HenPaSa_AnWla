package Artifact;

import Characters.AbstractCharacter;
import GameController.dices.DiceFour;

public class HealingPotion extends Potion{

    public HealingPotion(int charges){
        super(charges);
    }
    public void use(AbstractCharacter player) {
        DiceFour dice = new DiceFour();
        player.setLifepoints(player.getLifepoints() + dice.rollDice() + dice.rollDice() + 2);

    }
}
