package spells;

import GameController.dices.DiceEight;
import util.Effect;

public class RayOfFrost extends Spell{

    private int range = 3;//TODO

    public RayOfFrost() {
        super(new DiceEight(), Effect.DAMAGE);
    }
    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
