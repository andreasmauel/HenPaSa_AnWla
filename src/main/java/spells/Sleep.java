package spells;

import util.Effect;

public class Sleep extends Spell {

    public Sleep() {
        this.dice = new DiceFour();
        this.effect = Effect.SLEEP;
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
