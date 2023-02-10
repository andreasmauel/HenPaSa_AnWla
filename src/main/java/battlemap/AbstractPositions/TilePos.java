package battlemap.AbstractPositions;

import battlemap.Meta.MetaData;
import battlemap.Meta.TileType;

public abstract class TilePos
{
    protected MetaData metaData;

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
}
