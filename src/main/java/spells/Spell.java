package spells;

import util.Effect;

public abstract class Spell {

     protected final Dice dice;
     private  final Effect effect;

    protected Spell(Dice dice, Effect effect) {
        this.dice = dice;
        this.effect = effect;
    }


    public Effect getEffect() {
        return effect;
    }

    public abstract int cast();

}
