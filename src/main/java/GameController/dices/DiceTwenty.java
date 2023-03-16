package GameController.dices;

import java.util.Random;

public class DiceTwenty extends IDice {

    protected DiceSites diceSites;


    public DiceTwenty() {
        this.diceSites = DiceSites.TWENTY;
    }

    @Override
    public int rollDice() {
        Random random = new Random();
        return random.nextInt(1, 21);
    }
}
