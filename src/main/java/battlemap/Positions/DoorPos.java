package battlemap.Positions;

import battlemap.AbstractPositions.TilePos;
import battlemap.Meta.TileType;

public class DoorPos extends TilePos
{
    public DoorPos(int posX, int posY)
    {
        super(posX, posY, TileType.DOOR, false, false);
    }
}
