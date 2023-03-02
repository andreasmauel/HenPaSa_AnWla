package battlemap.Lockables;

import Artifact.Artifact;
import equipment.Equipment;

public class Chest extends Lockable
{
    private Equipment equipmentLoot;
    private Artifact artifactLoot;
    public Chest(boolean isSecret, int difficultyClass, Equipment equipmentLoot, Artifact artifactLoot) {
        super(isSecret, difficultyClass);
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
