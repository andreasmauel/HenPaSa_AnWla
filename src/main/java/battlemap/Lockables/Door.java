package battlemap.Lockables;

public class Door extends Lockable {
    public Door(boolean isSecret, int difficultyClass)
    {
        super(isSecret, difficultyClass);
        isLocked = true;
    }

}
