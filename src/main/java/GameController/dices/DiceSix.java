package GameController.dices;

import java.util.Random;

public class DiceSix extends IDice {

    protected DiceSites diceSites;


    public DiceSix() {
        this.diceSites = DiceSites.SIX;
    }

    @Override
    public int rollDice() {
        Random random = new Random();
        return random.nextInt(1, 7);
    }
}
