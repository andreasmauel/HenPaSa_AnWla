package spells;

import GameController.DiceEight;
import util.Effect;

public class Fireball extends Spell{

    private final int range;

    public Fireball() {
        super(new DiceEight(), Effect.DAMAGE);
        this.range = 3;
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
