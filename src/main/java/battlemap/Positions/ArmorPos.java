package battlemap.Positions;

import battlemap.AbstractPositions.EquipmentPos;
import battlemap.Meta.TileType;
import equipment.Equipment;

public class ArmorPos extends EquipmentPos
{
    public ArmorPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible, Equipment equipment)
    {
        super(posX, posY, tileType, isPassable, isVisible, equipment);
        metaData.setTileType(TileType.ARMOR);
    }
}
