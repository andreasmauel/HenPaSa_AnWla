package spells;

import GameController.dices.DiceEight;
import util.Effect;

public class MageArmor extends Spell{
    public MageArmor() {
        super(new DiceEight(), Effect.ARMOR);
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
