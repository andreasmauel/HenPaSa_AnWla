package spells;

import util.Effect;

public class Sleep extends Spell {


    protected Sleep(Dice dice, Effect effect) {
        super(new DiceFour(), Effect.SLEEP);
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
