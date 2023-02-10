package battlemap.Positions;

import battlemap.AbstractPositions.CharacterPos;
import battlemap.Meta.TileType;

public class PlayerPos extends CharacterPos
{
    public PlayerPos(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible, AbstractCharacter character)
    {
        super(posX, posY, tileType, isPassable, isVisible, character);
        metaData.setTileType(TileType.PLAYER);
    }
}
