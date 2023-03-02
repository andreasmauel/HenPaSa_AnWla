package battlemap.Positions;

import Artifact.Artifact;
import battlemap.AbstractPositions.ArtifactPos;
import battlemap.Meta.TileType;

public class MagicalPos extends ArtifactPos
{
    public MagicalPos(int posX, int posY, Artifact artifact)
    {
        super(posX, posY, TileType.MAGICAL, true, false, artifact);
    }
}
