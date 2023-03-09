package Artifact;

import Characters.AbstractCharacter;
import Characters.Player;

public class Ring extends Magical{

    public Ring(){

        super(false);
    }

    public int use(AbstractCharacter player) {
        return 0;
    }
}
