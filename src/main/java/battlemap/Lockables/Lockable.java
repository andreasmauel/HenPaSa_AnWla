package battlemap.Lockables;

import GUI.Main.DialogBox;

public abstract class Lockable
{
    protected boolean isSecret;
    protected boolean isLocked;
    protected int difficultyClass;

    public Lockable(boolean isSecret, int difficultyClass)
    {
        this.isSecret = isSecret;
        this.difficultyClass = difficultyClass;
    }

    public void unlock(int roll)
    {
        if(roll >= difficultyClass)
        {
            isLocked = false;
        }
        else {
            DialogBox.ConsoleOut("Your Lockpick failed, roll: " + roll);
        }
    }

    public void reveal(int roll)
    {
        if(roll > difficultyClass)
        {
            isSecret = false;
        }
    }

    public int getDifficultyClass()
    {
        return difficultyClass;
    }

    public boolean isLocked()
    {
        return isLocked;
    }

    public boolean isSecret()
    {
        return isSecret;
    }
}
