package battlemap.Lockables;

import Artifact.Artifact;

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
    }

    public boolean getopenable()
    {
        if(isLocked)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean getcloseable()
    {
        if(isLocked)
        {
            return false;
        }
        else
        {
            return true;
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
}
