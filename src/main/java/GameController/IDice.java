package GameController;

import java.util.Random;

public abstract class IDice {

    protected DiceSites diceSites;

    public int rollDice() {
        Random random = new Random();
        if (diceSites.equals(DiceSites.FOUR)) {
            return random.nextInt(1, 5);
        }
        else if (diceSites.equals(DiceSites.SIX)) {
            return random.nextInt(1, 7);
        }else if (diceSites.equals(DiceSites.EIGHT)) {
            return random.nextInt(1, 9);
        } else if (diceSites.equals(DiceSites.TEN)) {
            return random.nextInt(1, 11);
        } else {
            return random.nextInt(1, 21);
        }
    }

    public int rollDiceAdvantage(){
        int x = rollDice(), y = rollDice();
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    public int rollDiceDisadvantage(){
        int x = rollDice(), y = rollDice();
        if (x > y) {
            return y;
        } else {
            return x;
        }
    }

    public DiceSites getDiceSites(){
        return diceSites;
    }
    }

