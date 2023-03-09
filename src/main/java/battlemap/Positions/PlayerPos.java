package battlemap.Positions;

import Characters.AbstractCharacter;
import battlemap.AbstractPositions.CharacterPos;
import battlemap.Meta.TileType;

public class PlayerPos extends CharacterPos
{
    public PlayerPos(int posX, int posY, AbstractCharacter character)
    {
        super(posX, posY, TileType.PLAYER, false, true, character);
    }
}
