package GameController.dices;

import java.util.Random;

public class DiceEight extends IDice {

    protected DiceSites diceSites;

    public DiceEight() {
        this.diceSites = DiceSites.EIGHT;
    }

    @Override
    public int rollDice() {
        Random random = new Random();
        return random.nextInt(1, 9);
    }
}
