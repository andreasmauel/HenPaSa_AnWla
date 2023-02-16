package battlemap.Positions;

import battlemap.AbstractPositions.TilePos;
import battlemap.Lockables.Door;
import battlemap.Lockables.Lockable;
import battlemap.Meta.TileType;

public class DoorPos extends TilePos
{
    public DoorPos(int posX, int posY, int difficultyClass, boolean isSecret)
    {
        super(posX, posY, TileType.DOOR, false, false);
        lock = new Door(isSecret, difficultyClass);
    }
}
