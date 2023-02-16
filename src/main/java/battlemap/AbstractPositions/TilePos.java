package battlemap.AbstractPositions;

import battlemap.Lockables.Lockable;
import battlemap.Meta.MetaData;
import battlemap.Meta.TileType;
import equipment.Equipment;

public abstract class TilePos
{
    protected MetaData metaData;
    protected Lockable lock;

    public TilePos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible)
    {
        metaData = new MetaData(posX,posY,tileType,isPassable,isVisible);
    }

    public MetaData getMetaData()
    {
        return metaData;
    }

    public void setMetaData(MetaData metaData)
    {
        this.metaData = metaData;
    }

    public Lockable getLockable()
    {
        return lock;
    }

    public void setLockable(Lockable lock)
    {
        this.lock = lock;
    }

    public void open()
    {
        if(!lock.equals(null))
        {
            if(lock.getopenable())
            {
                metaData.setPassable(true);
            }
        }
    }

    public void close()
    {
        if(!lock.equals(null))
        {
            if(lock.getcloseable())
            {
                metaData.setPassable(false);
            }
        }
    }
}
