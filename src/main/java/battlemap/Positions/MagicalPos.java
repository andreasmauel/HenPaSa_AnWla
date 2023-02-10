package battlemap.Positions;

import battlemap.AbstractPositions.ArtifactPos;
import battlemap.Meta.TileType;

public class MagicalPos extends ArtifactPos
{
    public MagicalPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible, Artifact artifact)
    {
        super(posX, posY, tileType, isPassable, isVisible, artifact);
        metaData.setTileType(TileType.MAGICAL);
    }
}
