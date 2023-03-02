package spells;

import util.Effect;

public class Shield extends Spell{
    protected Shield(Dice dice, Effect effect) {
        super(new DiceEight(), Effect.ARMOR);
    }

    @Override
    public int cast() {
        return this.dice.roll();
    }
}
