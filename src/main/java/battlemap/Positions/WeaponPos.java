package battlemap.Positions;

import battlemap.AbstractPositions.EquipmentPos;
import battlemap.Meta.TileType;
import equipment.Equipment;

public class WeaponPos extends EquipmentPos
{
    public WeaponPos(int posX, int posY, Equipment equipment)
    {
        super(posX, posY, TileType.WEAPON, true, false, equipment);
    }
}
