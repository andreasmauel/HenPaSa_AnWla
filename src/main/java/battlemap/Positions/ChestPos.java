package battlemap.Positions;

import Artifact.Artifact;
import battlemap.AbstractPositions.TilePos;
import battlemap.Lockables.Chest;
import battlemap.Meta.TileType;
import equipment.Equipment;

public class ChestPos extends TilePos
{
    private Equipment equipmentLoot;
    private Artifact artifactLoot;
    public ChestPos(int posX, int posY, int difficultyClass, boolean isSecret, Equipment equipmentLoot, Artifact artifactLoot)
    {
        super(posX, posY, TileType.CHEST, false, false);
        lock = new Chest(isSecret, difficultyClass);
        this.artifactLoot = artifactLoot;
        this.equipmentLoot = equipmentLoot;
    }

    public Artifact getArtifactLoot()
    {
        return artifactLoot;
    }

    public void setArtifactLoot(Artifact artifactLoot)
    {
        this.artifactLoot = artifactLoot;
    }

    public Equipment getEquipmentLoot()
    {
        return equipmentLoot;
    }

    public void setEquipmentLoot(Equipment equipmentLoot)
    {
        this.equipmentLoot = equipmentLoot;
    }
}
