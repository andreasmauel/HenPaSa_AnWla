package spells;

import GameController.DiceTen;
import util.Effect;

public class SecondLife extends Spell{
    protected SecondLife() {
        super(new DiceTen(), Effect.HEAL);
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
