package Artifact;

public class KeyDoor implements IKey, Artifact {

    private int keycharges;

    public KeyDoor(int keycharges){
        this.keycharges = keycharges;
    }

    public int use() {
        if(keycharges != 0) {
            keycharges = keycharges - 1;
            return  keycharges;
        }
        return keycharges;
    }
}
