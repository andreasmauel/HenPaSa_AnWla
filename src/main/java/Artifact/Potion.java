package Artifact;

import Characters.AbstractCharacter;

public abstract class Potion implements Artifact {
    private int charges;

    protected Potion(int charges){
        this.charges = this.charges;
    }

    public int getCharges() throws Exception {
        if(charges != 0) {
            return charges;
        } else {
            throw new Exception("keine Aufladungen mehr");
        }
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    @Override
    public void use(AbstractCharacter player) {

    }
}
