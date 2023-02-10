package battlemap.AbstractPositions;

import battlemap.Meta.MetaData;
import battlemap.Meta.TileType;

public abstract class ArtifactPos
{
    protected MetaData metaData;
    protected Artifact artifact;

    public ArtifactPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible, Artifact artifact)
    {
        metaData = new MetaData(posX,posY,tileType,isPassable,isVisible);
        this.artifact = artifact;
    }

    public MetaData getMetaData()
    {
        return metaData;
    }

    public void setMetaData(MetaData metaData)
    {
        this.metaData = metaData;
    }

    public Artifact getArtifact()
    {
        return artifact;
    }

    public void setArtifact(Artifact artifact)
    {
        this.artifact = artifact;
    }
}
