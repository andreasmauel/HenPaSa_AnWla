package spells;

import util.Effect;

public class Fireball extends Spell{

    private final int range;

    public Fireball() {
        this.range = 3;
        this.dice = new DiceEight();
        this.effect = Effect.DAMAGE;
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
