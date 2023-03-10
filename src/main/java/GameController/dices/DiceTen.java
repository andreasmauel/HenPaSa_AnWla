package GameController.dices;

import java.util.Random;

public class DiceTen extends IDice {

    protected DiceSites diceSites;


    public DiceTen() {
        this.diceSites = DiceSites.TEN;
    }

    @Override
    public int rollDice() {
        Random random = new Random();
        return random.nextInt(1, 11);
    }
}
