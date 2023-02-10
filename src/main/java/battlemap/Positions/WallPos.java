package battlemap.Positions;

import battlemap.AbstractPositions.TilePos;
import battlemap.Meta.TileType;

public class WallPos extends TilePos
{
    public WallPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible)
    {
        super(posX, posY, tileType, isPassable, isVisible);
        metaData.setTileType(TileType.WALL);
    }
}
