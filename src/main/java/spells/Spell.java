package spells;

import GameController.dices.IDice;
import util.Effect;

public abstract class Spell {

     protected final IDice dice;
     private  final Effect effect;

    protected Spell(IDice dice, Effect effect) {
        this.dice = dice;
        this.effect = effect;
    }


    public Effect getEffect() {
        return effect;
    }

    public abstract int cast();

}
