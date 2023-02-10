package Artifact;

public abstract class Magical implements  Artifact{
    private boolean target;


    protected Magical(boolean target) {
        this.target = target;
    }
}
