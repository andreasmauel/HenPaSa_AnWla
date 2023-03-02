package battlemap.Positions;

import battlemap.AbstractPositions.EquipmentPos;
import battlemap.Meta.TileType;
import equipment.Equipment;

public class ArmorPos extends EquipmentPos
{
    public ArmorPos(int posX, int posY, Equipment equipment)
    {
        super(posX, posY, TileType.ARMOR, true, false, equipment);
    }
}
