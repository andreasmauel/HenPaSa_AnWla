package battlemap.Positions;

import battlemap.Dungeon.AbstractPositions.CharacterPos;
import battlemap.Meta.TileType;

public class MonsterPos extends CharacterPos
{
    public MonsterPos(int posX, int posY, AbstractCharacter character)
    {
        super(posX, posY, TileType.MONSTER, false, false, character);
    }
}
