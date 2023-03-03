package spells;

import GameController.DiceFour;
import util.Effect;

public class Sleep extends Spell {


    protected Sleep() {
        super(new DiceFour(), Effect.SLEEP);
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
