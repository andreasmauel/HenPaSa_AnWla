package battlemap.AbstractPositions;

import battlemap.Meta.MetaData;
import battlemap.Meta.TileType;

public abstract class CharacterPos
{
    protected MetaData metaData;
    protected AbstractCharacter character;

    public CharacterPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible, AbstractCharacter character)
    {
        metaData = new MetaData(posX,posY,tileType,isPassable,isVisible);
        this.character = character;
    }

    public MetaData getMetaData()
    {
        return metaData;
    }

    public void setMetaData(MetaData metaData)
    {
        this.metaData = metaData;
    }

    public AbstractCharacter getCharacter()
    {
        return character;
    }

    public void setCharacter(AbstractCharacter character)
    {
        this.character = character;
    }
}
