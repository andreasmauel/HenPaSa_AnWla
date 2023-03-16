package spells;

import util.Effect;
import GameController.dices.DiceSix;

public class BurningHands extends Spell{

    public BurningHands(DiceSix dice, Effect effect) {
        super(new DiceSix(), Effect.DAMAGE);
    }

    @Override
    public int cast() {
        return this.dice.rollDice() + this.dice.rollDice() + this.dice.rollDice();
    }
}
