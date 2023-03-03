package Artifact;

public class KeyChest implements IKey, Artifact {

    private int keycharges;

    public KeyChest(int keycharges) {
        this.keycharges = keycharges;
    }

    public int use() {
        if (keycharges != 0) {
            keycharges = 0;
        }
    }
}
