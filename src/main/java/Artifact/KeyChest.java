package Artifact;

public class KeyChest implements IKey, Artifact {

    private int keycharges;

    public KeyChest(int keycharges) {
        this.keycharges = keycharges;
    }

    public int use() {
        if (keycharges != 0) {
            keycharges = keycharges - 1;
        }
        return 0; //TODO Was soll hier wiedergegeben werden?
    }
}
