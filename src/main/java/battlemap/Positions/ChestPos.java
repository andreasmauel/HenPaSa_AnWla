package battlemap.Positions;

import Artifact.Artifact;
import battlemap.AbstractPositions.TilePos;
import battlemap.Lockables.Chest;
import battlemap.Lockables.Lockable;
import battlemap.Meta.TileType;
import equipment.Equipment;

public class ChestPos extends TilePos
{
    public ChestPos(int posX, int posY, Chest chest)
    {
        super(posX, posY, TileType.CHEST, false, false);
        this.chest = chest;
    }
}
