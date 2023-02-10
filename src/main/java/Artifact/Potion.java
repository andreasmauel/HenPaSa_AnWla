package Artifact;

public abstract class Potion implements Artifact {
    private int charges;

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
}
