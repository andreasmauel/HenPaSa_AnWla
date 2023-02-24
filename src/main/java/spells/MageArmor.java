package spells;

import util.Effect;

public class MageArmor extends Spell{
    public MageArmor() {
        this.dice = new DiceEight();
        this.effect = Effect.ARMOR;
    }

    @Override
    public int cast() {
        return this.dice.rollDice();
    }
}
