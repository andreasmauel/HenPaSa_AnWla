package battlemap.AbstractPositions;

import battlemap.Lockables.Chest;
import battlemap.Lockables.Door;
import battlemap.Lockables.Lockable;
import battlemap.Meta.MetaData;
import battlemap.Meta.TileType;

public abstract class TilePos
{
    protected MetaData metaData;
    protected Chest chest;
    protected Door door;

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
        if(chest!=null)
        {
            return chest;
        } else if (door!=null)
        {
            return door;
        } else
        {
            return null;
        }
    }

    public void setChest(Chest chest)
    {
        if(door!=null)
        this.chest = chest;
    }

    public void setDoor(Door door)
    {
        if(chest !=null)
        this.door = door;
    }
    public void open()
    {
        if(chest!=null)
        {
            if(!chest.isLocked())
            {
                metaData.setPassable(true);
            }
        } else if (door!=null)
        {
            if(!door.isLocked())
            {
                metaData.setPassable(true);
            }
        }
    }

    public void close()
    {
        if(chest!=null)
        {
            if(!chest.isLocked())
            {
                metaData.setPassable(false);
            }
        } else if (door!=null)
        {
            if(!door.isLocked())
            {
                metaData.setPassable(false);
            }
        }
    }
}
