package GameController.dices;

import java.util.Random;

public abstract class IDice {

    public DiceSites diceSites;


    public abstract int rollDice();

    public int rollDiceAdvantage() {
        int x = rollDice(), y = rollDice();
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    public int rollDiceDisadvantage() {
        int x = rollDice(), y = rollDice();
        if (x > y) {
            return y;
        } else {
            return x;
        }
    }

    public DiceSites getDiceSites() {
        return diceSites;
    }
}

