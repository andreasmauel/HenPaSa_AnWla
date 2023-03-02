package spells;

import util.Effect;

public class HealingHands extends Spell {
    protected HealingHands(Dice dice, Effect effect) {
        super(new DiceEight(), Effect.HEAL);
    }

    @Override
    public int cast() {
        return this.dice.roll();
    }
}
