package GameController;

import GameController.DiceSites;
import GameController.IDice;

import java.util.Random;

public class DiceFour extends IDice {

    protected DiceSites diceSites;


        public DiceFour() {
            this.diceSites = DiceSites.FOUR;
        }

}
