package battlemap.AbstractPositions;

import battlemap.Meta.MetaData;
import battlemap.Meta.TileType;
import equipment.Equipment;

public abstract class EquipmentPos
{
    protected MetaData metaData;
    protected Equipment equipment;

    public EquipmentPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible, Equipment equipment)
    {
        metaData = new MetaData(posX,posY,tileType,isPassable,isVisible);
        this.equipment = equipment;
    }

    public MetaData getMetaData()
    {
        return metaData;
    }

    public void setMetaData(MetaData metaData)
    {
        this.metaData = metaData;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setEquipment(Equipment equipment)
    {
        this.equipment = equipment;
    }
}
