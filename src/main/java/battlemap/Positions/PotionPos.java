package battlemap.Positions;

import battlemap.AbstractPositions.ArtifactPos;
import battlemap.Meta.TileType;

public class PotionPos extends ArtifactPos
{
    public PotionPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible, Artifact artifact)
    {
        super(posX, posY, tileType, isPassable, isVisible, artifact);
        metaData.setTileType(TileType.POTION);
    }
}
