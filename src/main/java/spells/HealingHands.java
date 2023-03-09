package spells;

import GameController.dices.DiceEight;
import util.Effect;

public class HealingHands extends Spell {
    protected HealingHands() {
        super(new DiceEight(), Effect.HEAL);
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
