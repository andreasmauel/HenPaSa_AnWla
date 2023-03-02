package battlemap.Positions;

import battlemap.Dungeon.AbstractPositions.TilePos;
import battlemap.Meta.TileType;

public class WallPos extends TilePos
{
    public WallPos(int posX, int posY)
    {
        super(posX, posY, TileType.WALL, false, false);
    }
}
