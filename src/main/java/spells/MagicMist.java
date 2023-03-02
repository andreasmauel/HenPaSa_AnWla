package spells;

import util.Effect;

public class MagicMist extends Spell{
    protected MagicMist(Dice dice, Effect effect) {
        super(new DiceFour(), Effect.REDUCEATTACK);
    }

    @Override
    public int cast() {
        return this.dice.roll();
    }
}
