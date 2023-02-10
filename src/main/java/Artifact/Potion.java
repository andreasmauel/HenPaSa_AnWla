package Artifact;

public abstract class Potion implements Artifact {
    private int charges;

    public int getCharges() {
            return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }
}
