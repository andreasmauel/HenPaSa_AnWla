package spells;

import util.Effect;

public class RayOfFrost extends Spell{

    private int range = 0;//TODO

    public RayOfFrost() {
        this.dice = Dice.EIGHT;
        this.effect = Effect.DAMAGE;
    }
    @Override
    public int cast() {
        return this.dice.roll();
    }
}
