package spells;

import util.Effect;

public class SecondLife extends Spell{
    protected SecondLife(Dice dice, Effect effect) {
        super(new DiceTen(), Effect.HEAL);
    }

    @Override
    public int cast() {
        return this.dice.roll();
    }
}
