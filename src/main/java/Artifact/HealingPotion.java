package Artifact;

import Characters.Player;
import GameController.dices.DiceFour;

public class HealingPotion extends Potion{

    public HealingPotion(int charges){
        super(charges);
    }
    public int use(Player player, DiceFour dice) {
        return player.getLifepoints() + (2 * dice.rollDice()) + 2;
    }
}
