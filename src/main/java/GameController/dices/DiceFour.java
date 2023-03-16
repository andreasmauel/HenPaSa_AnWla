package GameController.dices;

import java.util.Random;

public class DiceFour extends IDice {

    protected DiceSites diceSites;


        public DiceFour() {
            diceSites = DiceSites.FOUR;
        }

    @Override
    public int rollDice() {
        Random random = new Random();
        return random.nextInt(1, 5);
    }
}
