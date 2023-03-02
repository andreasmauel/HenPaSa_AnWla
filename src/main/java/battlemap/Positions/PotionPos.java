package battlemap.Positions;

import Artifact.Artifact;
import battlemap.Dungeon.AbstractPositions.ArtifactPos;
import battlemap.Meta.TileType;

public class PotionPos extends ArtifactPos
{
    public PotionPos(int posX, int posY, Artifact artifact)
    {
        super(posX, posY, TileType.POTION, true, false, artifact);
    }
}
