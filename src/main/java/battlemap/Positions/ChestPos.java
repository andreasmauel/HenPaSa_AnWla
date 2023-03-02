package battlemap.Positions;

import battlemap.Dungeon.AbstractPositions.TilePos;
import battlemap.Lockables.Chest;
import battlemap.Meta.TileType;

public class ChestPos extends TilePos
{
    public ChestPos(int posX, int posY, Chest chest)
    {
        super(posX, posY, TileType.CHEST, false, false);
        this.chest = chest;
    }
}
