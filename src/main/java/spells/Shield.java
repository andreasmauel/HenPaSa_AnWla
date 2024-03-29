package spells;

import GameController.dices.DiceEight;
import util.Effect;

public class Shield extends Spell{
    protected Shield() {
        super(new DiceEight(), Effect.ARMOR);
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
