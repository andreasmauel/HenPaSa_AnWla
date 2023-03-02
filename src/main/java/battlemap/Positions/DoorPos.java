package battlemap.Positions;

import battlemap.Dungeon.AbstractPositions.TilePos;
import battlemap.Lockables.Door;
import battlemap.Meta.TileType;

public class DoorPos extends TilePos
{
    public DoorPos(int posX, int posY, Door door)
    {
        super(posX, posY, TileType.DOOR, false, false);
        this.door = door;
    }
}
