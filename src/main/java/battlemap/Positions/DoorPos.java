package battlemap.Positions;

import battlemap.AbstractPositions.TilePos;
import battlemap.Meta.TileType;

public class DoorPos extends TilePos
{
    public DoorPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible)
    {
        super(posX, posY, tileType, isPassable, isVisible);
        metaData.setTileType(TileType.DOOR);
    }
}
