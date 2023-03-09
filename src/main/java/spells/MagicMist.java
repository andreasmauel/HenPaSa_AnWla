package spells;

import GameController.dices.DiceFour;
import util.Effect;

public class MagicMist extends Spell{
    protected MagicMist() {
        super(new DiceFour(), Effect.REDUCEATTACK);
    }

    //TODO

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
