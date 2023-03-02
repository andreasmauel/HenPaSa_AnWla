package spells;

import util.Effect;

public class BurningHands extends Spell{

    public BurningHands(Dice dice, Effect effect) {
        super(new DiceSix(), Effect.DAMAGE);
    }

    @Override
    public int cast() {
        return this.dice.roll() + this.dice.roll() + this.dice.roll();
    }
}
