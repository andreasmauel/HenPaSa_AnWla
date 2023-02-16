package battlemap.Positions;

import battlemap.AbstractPositions.TilePos;
import battlemap.Lockables.Chest;
import battlemap.Meta.TileType;

public class ChestPos extends TilePos
{
    public ChestPos(int posX, int posY, int difficultyClass, boolean isSecret)
    {
        super(posX, posY, TileType.CHEST, false, false);
        lock = new Chest(isSecret, difficultyClass);
    }
}
